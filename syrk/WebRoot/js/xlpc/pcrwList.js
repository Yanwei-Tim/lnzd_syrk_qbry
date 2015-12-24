if(typeof PcrwList == "undefined" || !PcrwList){
	var PcrwList = {};
};
PcrwList = function(){
	this.pk = Math.random();
};
PcrwList.initMarkerArr = new Array();//放点对象
PcrwList.setInt = "";//记录延时
PcrwList.initMarker = "";//记录点击列表点
/**
 * @title:Jquery
 * @description:初始化盘查人员信息
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-12-02 16:03:43
 */
$(function(){
	PcrwList.onloadMap();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-02 11:32:23
 */	
PcrwList.onloadMap = function(){
	/*地图对象*/
	PcrwList.map = new FrameTools.Map();
	/*设置地图代理*/
	PcrwList.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	PcrwList.map.setMapDiv("mapDiv");
	/*加载地图*/
	PcrwList.map.onloadMap();
	/*显示鹰眼*/
	PcrwList.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	PcrwList.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	PcrwList.map.showNewMapServer("mapDiv","PcrwList.map");
	/*加载地图工具条*/
	PcrwList.map.buildTools("mapDiv","toolDiv","PcrwList.map");
	//只在责任区和派出所级别加载辖区边界 辖区太大在IE8会停止运行脚本
	PcrwList.map.moveMapToBjzbz(bjzbz);
};
/**
 * @title:queryButton
 * @description:查询按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-11-23 20:30:32
 */	
PcrwList.queryButton = function(){
	var gzdd = $.trim($('#gzdd').searchbox('getValue'));
	gzdd = $.trim(gzdd);
	$('#dg').datagrid('load',{    
		'gzdd':gzdd
	});
};

/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-08 15:30:13
 */	
PcrwList.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	PcrwList.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(PcrwList.setInt!=""){
		clearInterval(PcrwList.setInt);
	}
	//判断地图上已经存在点图层清除
	if(PcrwList.initMarkerArr!=null){
		var markerLen = PcrwList.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			PcrwList.map._MapApp.removeOverlay(PcrwList.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	PcrwList.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].xpoint;
			var zby = rows[count].ypoint;
			var title = rows[count].gzdd;
			if(zbx!=""&&zby!=""){
				var openHtml = "<div class='divwrap'><div class='oneText'>1</div><div class='title_big'>盘查人员</div>" +
							   "</div><div class='text'>共有<span class='bold'>2</span>个责任区，面积<span class='redText'>85</span>(平方公里)</div>" +
							   "<div class='divwrap'><div class='oneText'>2</div><div class='title_big'>盘查车辆</div></div>";
				var initMarker = PcrwList.map.initMarker(title,zbx,zby,"jq_tj.png",openHtml,null,32,32);
				PcrwList.map._MapApp.addOverlay(initMarker);
				PcrwList.initMarkerArr.push(initMarker);
				PcrwList.addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(PcrwList.setInt);
		}
		count++;
	},90);
};
/**
 * @title:addMapToListFun
 * @description:地图元素和列表联动
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-08 15:30:13
 */	
PcrwList.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		 PcrwList.addClickMarker(row);
	});
};
/**
 * @title:addClickMarker
 * @description:地图图标变换
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-08 15:37:43
 */	
PcrwList.addClickMarker = function(row){
	//关闭所有器已经打开的气泡框
	PcrwList.map._MapApp.closeInfoWindow();
	if(PcrwList.initMarker!=""){
		//清除之前的坐标点
		PcrwList.map._MapApp.removeOverlay(PcrwList.initMarker);
	}
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var zbx = rowData.xpoint;
	var zby = rowData.ypoint;
	var title = rowData.gzdd;
	var pcid = rowData.pcid;
	var point = new Point(zbx,zby);
	$.ajax({
		type:"POST",
		sync:true,
		url:contextPath+"/xlpc/queryPcry",
		dataType:'json',
		data:{pcid:pcid},
		success:function(json){
			var openHtml = "<div class='divwrap'><div class='oneText'>1</div><div class='title_big'>盘查人员</div></div>";
			var jsonlen = json.length;
			if(jsonlen>0){
				for(var i=0;i<jsonlen;i++){
					openHtml += "<div class='text'>姓名："+json[i].ryxm+"  证件号码："+json[i].sfzh+"</div>";
				}
			}
			$.ajax({
				type:"POST",
				sync:true,
				url:contextPath+"/xlpc/queryPccl",
				dataType:'json',
				data:{pcid:pcid},
				success:function(returnJson){
					openHtml += "<div class='divwrap'><div class='oneText'>2</div><div class='title_big'>盘查车辆</div></div>";
					var returnJsonLength = returnJson.length;
					if(returnJsonLength>0){
						for(var j=0;j<returnJsonLength;j++){
							openHtml += "<div class='text'>车牌号码："+returnJson[j].cphm+"  所有人姓名："+returnJson[j].syrxm+"</div>";
						}
					}
					if(zbx!=""&&zby!=""){
						PcrwList.initMarker = PcrwList.map.initMarker(title,zbx,zby,'jq_xs.png',openHtml,null,32,32);
						PcrwList.map._MapApp.addOverlay(PcrwList.initMarker);
						$('#dg').datagrid("selectRow",row);
						PcrwList.map._MapApp.openInfoWindow(point,openHtml,true);
					}
				}
			})
		}
	})
};
/**
 * @title:onClickRow
 * @description:点击列表事件
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-12-08 15:40:23
 */
PcrwList.onClickRow = function(rowIndex,rowData){
	PcrwList.addClickMarker(rowIndex);
};