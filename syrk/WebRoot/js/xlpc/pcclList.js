if(typeof PcclList == "undefined" || !PcclList){
	var PcclList = {};
};
PcclList = function(){
	this.pk = Math.random();
};
PcclList.initMarkerArr = new Array();//放点对象
PcclList.setInt = "";//记录延时
PcclList.initMarker = "";//记录点击列表点
/**
 * @title:Jquery
 * @description:初始化盘查人员信息
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-12-02 16:03:43
 */
$(function(){
	PcclList.onloadMap();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-02 11:32:23
 */	
PcclList.onloadMap = function(){
	/*地图对象*/
	PcclList.map = new FrameTools.Map();
	/*设置地图代理*/
	PcclList.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	PcclList.map.setMapDiv("mapDiv");
	/*加载地图*/
	PcclList.map.onloadMap();
	/*显示鹰眼*/
	PcclList.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	PcclList.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	PcclList.map.showNewMapServer("mapDiv","PcclList.map");
	/*加载地图工具条*/
	PcclList.map.buildTools("mapDiv","toolDiv","PcclList.map");
	//只在责任区和派出所级别加载辖区边界 辖区太大在IE8会停止运行脚本
	PcclList.map.moveMapToBjzbz(bjzbz);
};
/**
 * @title:queryButton
 * @description:查询按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-11-23 20:30:32
 */	
PcclList.queryButton = function(){
	var syrxm = $.trim($('#syrxm').searchbox('getValue'));
	syrxm = $.trim(syrxm);
	$('#dg').datagrid('load',{    
		'syrxm':syrxm
	});
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-08 15:30:13
 */	
PcclList.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	PcclList.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(PcclList.setInt!=""){
		clearInterval(PcclList.setInt);
	}
	//判断地图上已经存在点图层清除
	if(PcclList.initMarkerArr!=null){
		var markerLen = PcclList.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			PcclList.map._MapApp.removeOverlay(PcclList.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	PcclList.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].xpoint;
			var zby = rows[count].ypoint;
			var title = rows[count].cphm;
			if(zbx!=""&&zby!=""){
				var initMarker = PcclList.map.initMarker(title,zbx,zby,"jzw3.png",null,null,43,37);
				PcclList.map._MapApp.addOverlay(initMarker);
				PcclList.initMarkerArr.push(initMarker);
				PcclList.addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(PcclList.setInt);
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
PcclList.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		 PcclList.addClickMarker(row);
	});
};
/**
 * @title:addClickMarker
 * @description:地图图标变换
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-08 15:37:43
 */	
PcclList.addClickMarker = function(row){
	//关闭所有器已经打开的气泡框
	PcclList.map._MapApp.closeInfoWindow();
	if(PcclList.initMarker!=""){
		//清除之前的坐标点
		PcclList.map._MapApp.removeOverlay(PcclList.initMarker);
	}
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var title = rowData.cphm;
	var zbx = rowData.xpoint;
	var zby = rowData.ypoint;
	if(zbx!=""&&zby!=""){
		PcclList.initMarker = PcclList.map.initMarker(title,zbx,zby,'jzw1.png',null,null,43,37);
		PcclList.map._MapApp.addOverlay(PcclList.initMarker);
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
	}else{
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: "该盘查车辆暂无坐标信息。",
			timeout:2500
		});
	}
};
/**
 * @title:onClickRow
 * @description:点击列表事件
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-12-08 15:40:23
 */
PcclList.onClickRow = function(rowIndex,rowData){
	PcclList.addClickMarker(rowIndex);
};