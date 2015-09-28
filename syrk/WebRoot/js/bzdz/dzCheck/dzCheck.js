if(typeof DzCheck == "undefined" || !DzCheck){
	var DzCheck = {};
};
DzCheck = function(){
	this.pk = Math.random();
};
DzCheck.initMarkerArr = new Array();//放点对象
DzCheck.setInt = "";//记录延时
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2014-12-26 10:37:32
 */
$(function(){
	DzCheck.onloadMap();
	//新增权限判断
	if(orglevel != "50"){
 	   document.getElementById("dzaddid").style.display = "none";
    }
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:38:12
 */	
DzCheck.onloadMap = function(){
	/*地图对象*/
	DzCheck.map = new FrameTools.Map();
	/*设置地图代理*/
	DzCheck.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	DzCheck.map.setMapDiv("mapDiv");
	/*加载地图*/
	DzCheck.map.onloadMap();
	/*显示鹰眼*/
	DzCheck.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	DzCheck.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	DzCheck.map.showNewMapServer("mapDiv","DzCheck.map");
	/*加载地图工具条*/
	DzCheck.map.buildTools("mapDiv","toolDiv","DzCheck.map");
	//只在责任区和派出所级别加载辖区边界 辖区太大在IE8会停止运行脚本
	if(orglevel=="50"||orglevel=="32"){
		DzCheck.map.moveMapToBjzbz(bjzbz);
	}
};
/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param  bzdzSh 标准地址新增或维护是否审核：0为禁用（默认）、1为启用  
 * @date:2014-12-26 10:47:21
 */	
DzCheck.datagridProcessFormater = function(val,row,index){
	if(row.dzzt=="01"){
		if(orglevel != "50"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.doUpdateAndXq(this, '+index+',1,0,1)">详情</a>&nbsp;';
		}else{
			if(row.bz=="维护中"){
				return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.doUpdateAndXq(this, '+index+',1,0,1)">详情</a>&nbsp;'+
				       '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.doDeleteYqy(this, '+index+')">注销</a>&nbsp;';
			}else{
				return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.doUpdateAndXq(this, '+index+',0,0,0)">维护</a>&nbsp;'+
		           	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.doDeleteYqy(this, '+index+')">注销</a>&nbsp;';
			}
		}
    }else if(row.dzzt=="02"){
    	if(orglevel != "50"){
    		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.dzVerifyShAndXq(this, '+index+',1,1,1)">详情</a>&nbsp;';
    	}else{
    		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.dzVerifyShAndXq(this, '+index+',1,1,1)">详情</a>&nbsp;'+
	           	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.doDeleteDspAndTh(this, '+index+',2)">注销</a>&nbsp;';
    	}
    }else if(row.dzzt=="03"){
    	if(orglevel != "50"){
    		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.dzVerifyShAndXq(this, '+index+',1,1,1)">详情</a>&nbsp;';
    	}else{
    		if(bzdzSh=="1"){
        		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.doUpdateAndXq(this, '+index+',0,1,0)">维护</a>&nbsp;'+
    			   	   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.doDeleteDspAndTh(this, '+index+',3)">注销</a>&nbsp;';
        	}else{
        		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.dzVerifyShAndXq(this, '+index+',1,1,1)">详情</a>&nbsp;'+
        			   '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="DzCheck.doDeleteDspAndTh(this, '+index+',3)">注销</a>&nbsp;';
        	}
    	}
    }else{
    	return "";
    }
};
/**
 * @title:queryButton
 * @description:查询按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:58:43
 */	
DzCheck.queryButton = function(){
	var dzmc = $.trim($('#dzmc').searchbox('getValue'));
	var dzzt = document.getElementById("dzzt").value;
	dzmc = $.trim(dzmc);
	//加载查询列表
	$('#dg').datagrid('load',{    
		'dzmc':dzmc,
		'dzzt':dzzt
	});
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 10:58:43
 */	
DzCheck.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	DzCheck.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(DzCheck.setInt!=""){
		clearInterval(DzCheck.setInt);
	}
	//判断地图上已经存在点图层清除
	if(DzCheck.initMarkerArr!=null){
		var markerLen = DzCheck.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			DzCheck.map._MapApp.removeOverlay(DzCheck.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	DzCheck.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].zbx;
			var zby = rows[count].zby;
			var title = rows[count].mlphqc;
			var dzzt = rows[count].dzzt;
			var mldzid = rows[count].mldzid;
			if(zbx!=""&&zby!=""){
				//气泡框内容
				var openHtml =  "<div id='uploadFileImageDiv' style='width: 300px; height: 300px;text-align: center;'></div>" +
						        "<div class='divwrap'><div class='oneText'>1</div><div class='title_big'>地址全称："+rows[count].dzmc+"</div></div>" +
								"<div class='divwrap'><div class='oneText'>2</div><div class='title_big'>采集时间："+rows[count].xt_cjsj+"</div></div>";
				//地图标点
				var img = "";
				if(dzzt=="01"){
					//绿色
					img = "jzw3.png";
					openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>启用时间："+rows[count].xt_zhxgsj+"</div></div>";
				}else if(dzzt=="02"){
					//黄色
					img = "jzw4.png";
				}else if(dzzt=="03"){
					//红色
					img = "jzw1.png";
					openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>退回时间："+rows[count].xt_zhxgsj+"</div></div>";
				}else{
					//灰色
					img = "jzw0.png";
					openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>注销时间："+rows[count].xt_zhxgsj+"</div></div>";
				}
				if(dzzt!="04"){
					openHtml += "<div class='divwrap'><div class='title_big'><div class='blueText'>";
					openHtml +=	"<a class='blueText' href='javascript:javascript:void(0)' onclick='DzCheck.uploadFileEdit(\""+mldzid+"\",\""+title+"\")'>【照片管理】</a>";
					openHtml +=	"<a class='blueText' href='javascript:javascript:void(0)' onclick='DzCheck.onloadChjg(\""+mldzid+"\",\""+title+"\",\""+dzzt+"\")'>【层户结构】</a>";
					openHtml +=	"</div></div></div>";
				}
				var initMarker = DzCheck.map.initMarker(title,zbx,zby,img,openHtml,null,43,37);
				DzCheck.map._MapApp.addOverlay(initMarker);
				DzCheck.initMarkerArr.push(initMarker);
				//地图元素和列表联动
				DzCheck.addMapToListFun(initMarker,count);
				initMarker.addListener("click", function(){
					DzCheck.uploadFileImageView(mldzid);
				});
			}
		}else{
			clearInterval(DzCheck.setInt);
		}
		count++;
	},90);
};
/**
 * @title:uploadFileImageView
 * @description:加载照片
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2015-03-21 14:56:32
 */
DzCheck.uploadFileImageView = function(mldzid){
	uploadFileImageView('BZDZ_ADD_MLDZDXB',mldzid, 'uploadFileImageDiv', 300, 275,contextPath+'/images/bzdz/building/building.jpg'); //附件图片多张显示
};
/**
 * @title:uploadFileEdit
 * @description:照片管理
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2015-03-21 14:56:32
 */
DzCheck.uploadFileEdit = function(mldzid,title){
	//关闭所有器已经打开的气泡框
	DzCheck.map._MapApp.closeInfoWindow();
	uploadFileEdit('BZDZ_ADD_MLDZDXB',mldzid, '【'+title+'】照片', 'img', '0', '','【'+title+'】照片管理');
};
/**
 * @title:onloadChjg
 * @description:打开加载层户结构页面
 * @author: zhang_guoliang@founder.com
 * @param type 0为可编辑、1为只读,dzChb地址层户表 0为层户地址对象表、1为层户地址审核表 
 * @date:2015-03-21 14:38:23
 */
DzCheck.onloadChjg = function(mldzid,title,dzzt){
	var dzChb = 0;
	if(dzzt!="01"){
		dzChb = 1;
	}
	//层户结构URL
	menu_open('【'+title+'】层户结构', "/dz/dzBuilding?mldzid="+mldzid+"&type=1&dzChb="+dzChb+"&chType=1&mainTabID="+getMainTabID());
};
/**
 * @title:addMapToListFun
 * @description:地图元素和列表联动
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 18:02:12
 */	
DzCheck.addMapToListFun = function(PMarker,row){
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
 * @title:datagridDzzt
 * @description:地址状态颜色
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-26 18:12:24
 */	
DzCheck.datagridDzzt = function(value,row,index){
	var opts = $(this);
	if (opts[0].dictName) {
		try {
			value = window.top.getDictName(opts[0].dictName, value);
		}
		catch (err) {}
	}
    if(row.dzzt=="01"){
    	if(row.bz=="维护中"){
    		return "<span style='color:green;font: bold;'>"+value+"(维护中)</span>";
    	}else{
    		return "<span style='color:green;font: bold;'>"+value+"</span>";
    	}
    }else if(row.dzzt=="02"){
    	return "<span style='color:#C86C00;font: bold;'>"+value+"</span>";
    }else if(row.dzzt=="03"){
    	return "<span style='color:red;font: bold;'>"+value+"</span>";
    }else if(row.dzzt=="04"){
    	return "<span style='color:gray;font: bold;'>"+value+"</span>";
    }else{
    	return value;   
    }	
};
/**
 * @title:onClickRow
 * @description:点击一行的时候触发
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-27 14:57:21
 */	
DzCheck.onClickRow = function(rowIndex,rowData){
	if(rowData.zbx!=""&&rowData.zby!=""){
		var mldzid = rowData.mldzid;
		var title = rowData.mlphqc;
		var point = new Point(rowData.zbx,rowData.zby);
		//气泡框内容
		var openHtml =  "<div id='uploadFileImageDiv' style='width: 300px; height: 300px;text-align: center;'></div>" +
				        "<div class='divwrap'><div class='oneText'>1</div><div class='title_big'>地址全称："+rowData.dzmc+"</div></div>" +
						"<div class='divwrap'><div class='oneText'>2</div><div class='title_big'>采集时间："+rowData.xt_cjsj+"</div></div>";
		if(rowData.dzzt=="01"){
			openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>启用时间："+rowData.xt_zhxgsj+"</div></div>";
		}else if(rowData.dzzt=="03"){
			openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>退回时间："+rowData.xt_zhxgsj+"</div></div>";
		}else if(rowData.dzzt=="04"){
			openHtml += "<div class='divwrap'><div class='oneText'>3</div><div class='title_big'>注销时间："+rowData.xt_zhxgsj+"</div></div>";
		}
		if(rowData.dzzt!="04"){
			openHtml += "<div class='divwrap'><div class='title_big'><div class='blueText'>";
			openHtml += "<a class='blueText' href='javascript:javascript:void(0)' onclick='DzCheck.uploadFileEdit(\""+mldzid+"\",\""+title+"\")'>【照片管理】</a>";
			openHtml += "<a class='blueText' href='javascript:javascript:void(0)' onclick='DzCheck.onloadChjg(\""+mldzid+"\",\""+title+"\",\""+rowData.dzzt+"\")'>【层户结构】</a>";
			openHtml += "</div></div></div>";
		}
		DzCheck.map._MapApp.openInfoWindow(point,openHtml,true);
		//延时获取照片信息
		setTimeout(function(){
			DzCheck.uploadFileImageView(mldzid);
		},1);
	}else{
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: "此地址暂无坐标，请进行地图标注。",
			timeout:3500
		});
	}
};
/**
 * @title:dzAdd
 * @description:新建地址
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2014-12-29 14:37:47
 */	
DzCheck.dzAdd = function(){
	menu_open('地址新建', '/dz/createDz?mainTabID='+getMainTabID());
};
/**
 * @title:doDeleteDspAndTh
 * @description:待审批或被退回地址注销
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-04 16:36:45
 */	
DzCheck.doDeleteDspAndTh = function(linkObject,index,type){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	document.getElementById("index").value = "";
	document.getElementById("xt_zxyy").value = "";
	document.getElementById("zxbz").value = "2";
	document.getElementById("type").value = type;
	$("#index").val(index);
	$("#dzzxId").window("open"); 
	var strTit = "";
	if(type=="2"){
		strTit = "待审批";
	}else if(type=="3"){
		strTit = "被退回";
	}
	$("#dzzxId").window("setTitle","【"+rowData.mlphqc+"】"+strTit+"地址注销");
};
/**
 * @title:doDelete_back
 * @description:地址数据注销_回调函数可共用
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-04 20:04:12
 */	
DzCheck.doDelete_back = function(result){
	if(result){
		if(result.status == 'success'){
			DzCheck.queryButton();
		}
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: result.message,
			timeout:3500
		});
	}
};
/**
 * @title:dzVerifyShAndXq
 * @description:地址审核或查看详情
 * @author: zhang_guoliang@founder.com
 * @param type 0为可编辑、1为只读，dzChb地址层户表 0为层户地址对象表、1为层户地址审核表、chType层户结构 0为编辑、1为只读
 * @date:2015-02-09 18:18:54
 */
DzCheck.dzVerifyShAndXq = function(linkObject,index,type,dzChb,chType){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
    menu_open('【'+rowData.mlphqc+'】详情','/dz/createDzShAndXq?mldzid='+rowData.mldzid+'&type='+type+'&dzChb='+dzChb+'&chType='+chType+'&mainTabID='+getMainTabID());
};
/**
 * @title:doDeleteYqy
 * @description:已启用地址注销【有业务数据处理】
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-04 18:30:57
 */	
DzCheck.doDeleteYqy = function(linkObject,index){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	document.getElementById("index").value = "";
	document.getElementById("xt_zxyy").value = "";
	document.getElementById("zxbz").value = "1";
	$("#index").val(index);
	$("#dzzxId").window("open"); 
	$("#dzzxId").window("setTitle","【"+rowData.mlphqc+"】地址注销");
};
/**
 * @title:cancelButton
 * @description:地址注销【注销】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-04-14 18:42:43
 */
DzCheck.cancelButton = function(){
	if($("#cancelform").form('validate')){
		//关闭弹出框
		DzCheck.closeWindow();
		var index = document.getElementById("index").value;
		var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		var xt_zxyy = document.getElementById("xt_zxyy").value;
		var zxbz = document.getElementById("zxbz").value;
		if(zxbz=="1"){
			var params = {mldzid:rowData.mldzid,mlphqc:rowData.mlphqc,xt_zxyy:xt_zxyy};
			var fajax = new FrameTools.Ajax(contextPath+"/dz/doDeleteYqy",DzCheck.doDelete_back);
			fajax.send(params);
		}else if(zxbz=="2"){
			var type = document.getElementById("type").value;
			var params = {mldzid:rowData.mldzid,mlphqc:rowData.mlphqc,shztdm:type,xt_zxyy:xt_zxyy};
			var fajax = new FrameTools.Ajax(contextPath+"/dz/crossOutDspAndTh",DzCheck.doDelete_back);
			fajax.send(params);
		}
	}
};
/**
 * @title:closeWindow
 * @description:地址注销【关闭】
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-05-12 14:39:43
 */
DzCheck.closeWindow = function(){
	$("#dzzxId").window("close");
};
/**
 * @title:doUpdateAndXq
 * @description:地址维护
 * @author: zhang_guoliang@founder.com
 * @param type 0为可编辑、1为只读，dzChb地址层户表 0为层户地址对象表、1为层户地址审核表, chType层户结构 0为编辑、1为只读
 * @date:2015-02-04 18:23:35
 */	
DzCheck.doUpdateAndXq = function(linkObject, index,type,dzChb,chType){
	//阻止冒泡，不然要执行onClickRow
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var title = "";
	if(type=="0"){
		title = "维护";
	}else{
		title = "详情";
	}
    menu_open('【'+rowData.mlphqc+'】'+title+'','/dz/createUpdateAndXq?mldzid='+rowData.mldzid+'&type='+type+'&dzChb='+dzChb+'&chType='+chType+'&mainTabID='+getMainTabID());
};
/**
 * @title:doDelete_back
 * @description:地址数据注销_回调函数可共用
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-02-04 20:04:12
 */	
DzCheck.doDelete_back = function(result){
	if(result){
		if(result.status == 'success'){
			DzCheck.queryButton();
		}
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: result.message,
			timeout:3500
		});
	}
};