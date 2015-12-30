if(typeof SyfwManager == "undefined" || !SyfwManager){
	var SyfwManager = {};
};
SyfwManager = function(){
	this.pk = Math.random();
};
SyfwManager.initMarkerArr = new Array();//放点对象
SyfwManager.setInt = "";//记录延时
SyfwManager.initMarker = ""; //记录点击列表点
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2014-12-26 10:37:32
 */
$(function(){
	SyfwManager.onloadMap();
	//键盘回车进行查询
	$("body").bind("keydown",function(e){
        if(e.keyCode==13){
        	SyfwManager.queryButton();
        }		
	});
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:38:12
 */	
SyfwManager.onloadMap = function(){
	/*地图对象*/
	SyfwManager.map = new FrameTools.Map();
	/*设置地图代理*/
	SyfwManager.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	SyfwManager.map.setMapDiv("mapDiv");
	/*加载地图*/
	SyfwManager.map.onloadMap();
	/*显示鹰眼*/
	SyfwManager.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	SyfwManager.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	SyfwManager.map.showNewMapServer("mapDiv","SyfwManager.map");
	/*加载地图工具条*/
	SyfwManager.map.buildTools("mapDiv","toolDiv","SyfwManager.map");
	/*设置工具条显示的位置*/
	SyfwManager.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){SyfwManager.diyToolDiv();});
	/*加载边界坐标值*/
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		SyfwManager.moveMapToBjzbz();
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:39:41
 */	
SyfwManager.diyToolDiv = function(){
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};
/**
 * @title:moveMapToBjzbz
 * @description:加载当前用户边界
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:39:54
 */	
SyfwManager.moveMapToBjzbz = function(){
	/*清楚地图上所有的标记*/
	SyfwManager.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*记录边线中心点坐标*/
	SyfwManager.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = SyfwManager.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			SyfwManager.map._MapApp.addOverlay(polyline);
			SyfwManager.mbrArr.push(polyline);
			if(SyfwManager.Mbr==null){
				SyfwManager.Mbr = polyline.getMBR();
			}else{
				SyfwManager.Mbr = MBR.union(SyfwManager.Mbr,polyline.getMBR());
			}
		}
	}
	/*根据图元素将地图放到最适合的级别和位置*/
	SyfwManager.map._MapApp.centerAtMBR(SyfwManager.Mbr);
	/*新版本cliect自动适应级别有问题必须降一级*/
	SyfwManager.map._MapApp.zoomOut();
};
/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param  bzdzSh 标准地址新增或维护是否审核：0为禁用（默认）、1为启用  
 * @date:2014-12-26 10:47:21
 */	
SyfwManager.datagridProcessFormater = function(val, row, index) { // 自定义操作生成
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyfwManager.doEdit(this,'+index+')">编辑</a>&nbsp;'+
	'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="SyfwManager.doDelete(this, '+index+')">注销</a>&nbsp;';
}
/**
 * @title:queryButton
 * @description:查询按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:58:43
 */	
SyfwManager.queryButton = function(value,name){
	value = $.trim(value)
	$('#dg').datagrid('load',{condition:value});  
	
	$('#dg').datagrid("clearSelections");
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:58:43
 */	
SyfwManager.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	SyfwManager.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(SyfwManager.setInt!=""){
		clearInterval(SyfwManager.setInt);
	}
	//判断地图上已经存在点图层清除
	if(SyfwManager.initMarkerArr!=null){
		var markerLen = SyfwManager.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			SyfwManager.map._MapApp.removeOverlay(SyfwManager.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	SyfwManager.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].zbx;
			var zby = rows[count].zby;
			var title = rows[count].fwdz_dzxz;
			for (var i = 0; i < addressPrefixArray.length; i++) {
				title = rows[count].fwdz_dzxz.replace(addressPrefixArray[i], "");
			}
			var mldzid = rows[count].bzdzid;
			if(zbx!=""&&zby!=""){
				//气泡框内容
				var openHtml = "<table width='360'><tr>" +
			    "<td valign='top' width='360'>" +
			    "<table cellpadding='0' cellspacing='0'>" +
			    "<tr><td class='infoTable' align='right' width='125'>房主证件号码：</td><td class='infoTable1'>"+rows[count].fz_zjhm+"</td></tr>" +
			    "<tr><td class='infoTable' align='right' width='125'>房&nbsp;&nbsp;主&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;名：</td><td class='infoTable1' colspan='2'>"+rows[count].fz_xm+"</td></tr>" +
			    "<tr><td class='infoTable' align='right' width='125'>托管人证件号码：</td><td class='infoTable1' colspan='2'>"+rows[count].tgr_zjhm+"</td></tr>" +
			    "<tr><td class='infoTable' align='right' width='125'>托&nbsp;管&nbsp;人&nbsp;姓&nbsp;名：</td><td class='infoTable1' colspan='2'>"+rows[count].tgr_xm+"</td></tr>" +
			    "<tr><td class='infoTable' align='right' width='125'>房屋所属单位：</td><td class='infoTable1' colspan='2'>"+rows[count].fwssdw_dwmc+"</td></tr>";
			    var fwdz = "";
				if(rows[count].fwdz_dzxz!=null){
					fwdz = rows[count].fwdz_dzxz;
				}else{
					fwdz = rows[count].fwdz_mlpxz;
				}
				if(rows[count].fwdz_mlpdm!=""&&rows[count].fwdz_mlpxz!=""){
					openHtml += "<tr><td class='infoTable' align='right' width='125'>地&nbsp;&nbsp;&nbsp;址&nbsp;&nbsp;全&nbsp;&nbsp;称：</td><td><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyfwManager.doBuildingShow("+count+")'>"+fwdz+"</a></td></tr>";
			    }else{
			    	openHtml += "<tr><td class='infoTable' align='right' width='125'>地&nbsp;&nbsp;&nbsp;址&nbsp;&nbsp;全&nbsp;&nbsp;称：</td><td>"+fwdz+"</td></tr>";
			    }
				openHtml += "</table></td>";
				openHtml += "</tr>";
				openHtml += "</table>";
				//地图标点
				var img = "jzw3.png";
				var initMarker = SyfwManager.map.initMarker(title,zbx,zby,img,openHtml,null,43,37);
				SyfwManager.map._MapApp.addOverlay(initMarker);
				SyfwManager.initMarkerArr.push(initMarker);
				//地图元素和列表联动
				SyfwManager.addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(SyfwManager.setInt);
		}
		count++;
	},90);
};
/**
 * @title:addMapToListFun
 * @description:地图元素和列表联动
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 18:02:12
 */	
SyfwManager.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
	});
	/*PMarker.addListener("mouseout",function(){
		//鼠标移动到点上取消列表选中
		$('#dg').datagrid("unselectRow",row);
	});*/
};
/**
 * @title:addClickMarker
 * @description:地图图标变换
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 19:28:43
 */	
SyfwManager.addClickMarker = function(row){
	//关闭所有器已经打开的气泡框
	SyfwManager.map._MapApp.closeInfoWindow();
	if(SyfwManager.initMarker!=""){
		//清除之前的坐标点
		SyfwManager.map._MapApp.removeOverlay(SyfwManager.initMarker);
	}
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var title = rowData.fwdz_dzxz;
	var zbx = rowData.fwdz_zbx;
	var zby = rowData.fwdz_zby;
	if(zbx!=""&&zby!=""){
		SyfwManager.initMarker = SyfwManager.map.initMarker(title,zbx,zby,'jzw1.png',null,null,43,37);
		SyfwManager.map._MapApp.addOverlay(SyfwManager.initMarker);
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
		//打开气泡
		SyfwManager.openInfoWindow(row);
	}
};
SyfwManager.openInfoWindow = function(row){
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var point = new Point(rowData.fwdz_zbx,rowData.fwdz_zby);
	//气泡框内容
	var openHtml = "<table width='360'><tr>" +
    "<td valign='top' width='360'>" +
    "<table cellpadding='0' cellspacing='0'>" +
    "<tr><td class='infoTable' align='right' width='125'>房主证件号码：</td><td class='infoTable1'>"+rowData.fz_zjhm+"</td></tr>" +
    "<tr><td class='infoTable' align='right' width='125'>房&nbsp;&nbsp;主&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;名：</td><td class='infoTable1' colspan='2'>"+rowData.fz_xm+"</td></tr>" +
    "<tr><td class='infoTable' align='right' width='125'>托管人证件号码：</td><td class='infoTable1' colspan='2'>"+rowData.tgr_zjhm+"</td></tr>" +
    "<tr><td class='infoTable' align='right' width='125'>托&nbsp;管&nbsp;人&nbsp;姓&nbsp;名：</td><td class='infoTable1' colspan='2'>"+rowData.tgr_xm+"</td></tr>" +
    "<tr><td class='infoTable' align='right' width='125'>房屋所属单位：</td><td class='infoTable1' colspan='2'>"+rowData.fwssdw_dwmc+"</td></tr>";
    var fwdz = "";
	if(rowData.fwdz_dzxz!=null){
		fwdz = rowData.fwdz_dzxz;
	}else{
		fwdz = rowData.fwdz_mlpxz;
	}
	if(rowData.fwdz_mlpdm!=""&&rowData.fwdz_mlpxz!=""){
		openHtml += "<tr><td class='infoTable' align='right' width='125'>地&nbsp;&nbsp;&nbsp;址&nbsp;&nbsp;全&nbsp;&nbsp;称：</td><td><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='SyfwManager.doBuildingShow("+row+")'>"+fwdz+"</a></td></tr>";
    }else{
    	openHtml += "<tr><td class='infoTable' align='right' width='125'>地&nbsp;&nbsp;&nbsp;址&nbsp;&nbsp;全&nbsp;&nbsp;称：</td><td>"+fwdz+"</td></tr>";
    }
	openHtml += "</table></td>";
	openHtml += "</tr>";
	openHtml += "</table>";
	SyfwManager.map._MapApp.openInfoWindow(point,openHtml,true);
};
/**
 * @title:onClickRow
 * @description:点击一行的时候触发
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-27 14:57:21
 */	
SyfwManager.onClickRow = function(rowIndex,rowData){
	SyfwManager.addClickMarker(rowIndex);
};
/**
 * @title:doDelete_back
 * @description:地址数据注销_回调函数可共用
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-04 20:04:12
 */	
SyfwManager.doDelete_back = function(result){
	if(result){
		if(result.status == 'success'){
			SyfwManager.queryButton();
		}
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: result.message,
			timeout:3500
		});
	}
};
SyfwManager.doEdit = function(linkObject, index) {
	//阻止冒泡，不然要执行onClickRow
    cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/syfw/"+rowData.id+"/main"+'?&mainTabID='+getMainTabID();
	menu_open("实有房屋编辑",editUrl);
};
SyfwManager.add = function(){
	menu_open('实有房屋', '/syfw/create?mainTabID='+getMainTabID());
};
/**
 * @title:doDelete
 * @description:地址注销
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-29 14:37:47
 */	
SyfwManager.doDelete = function(linkObject, index){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	$("#main_id").val(rowData.id);
	$("#cancelform_1").attr("action",basePath+"syfw/"+rowData.id+"/delete");
	$("#cancel_1").window("open"); 
	$("#cancel_1").window("setTitle","注销");
};
SyfwManager.cancelButton = function(obj){
	if(!$("#cancelform_1").form("validate")){
		return ;
	}
	topMessager.confirm('','您确认要注销数据吗？',function(r){    
		if(r){
			$("#cancelform_1").form("submit",{
				dataType:"json",
				success: function(result){
					result = parseReturn(result);
					if (result.status == "success"){
						SyfwManager.queryButton();
						topMessager.show({
							title: MESSAGER_TITLE,
							msg: result.message,
							timeout:1500
						});
						SyfwManager.resetButton("cancelform_1");
						closeWindow("cancel_1");
					}
					else {
						topMessager.alert(MESSAGER_TITLE, result.message, "error");
					}
				}
			});
		}
	});
};
SyfwManager.resetButton = function(obj){
	$("#"+obj).form("reset");
};
//层户结构【展现】
SyfwManager.doBuildingShow = function(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var title = "层户结构";
	if(rowData.fwdz_mlpdm!=""){
		var xzqhmc = window.top.getDictName(contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',rowData.fwdz_ssxdm);
		var mlpxz = rowData.fwdz_dzxz.replace(xzqhmc, "");
		title = "【"+mlpxz+"】层户结构";
	}
	//层户结构URL
	menu_open(title, "/dz/dzBuildingShow?mldzid="+rowData.fwdz_mlpdm+"&chdzid="+rowData.fwdz_dzid+"&mainTabID="+getMainTabID());
};
/**
 * @title: subjzddzxz
 * @description:地址截取
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-04-14 15:08:32
 */	
SyfwManager.subjzddzxz = function(val, row, index){
  	var xzqhmc = window.top.getDictName(contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',row.fwdz_xzqhdm);
	return val.replace(xzqhmc, "");
};