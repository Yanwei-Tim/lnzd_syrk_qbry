if(typeof PcryList == "undefined" || !PcryList){
	var PcryList = {};
};
PcryList = function(){
	this.pk = Math.random();
};
PcryList.initMarkerArr = new Array();//放点对象
PcryList.setInt = "";//记录延时
PcryList.initMarker = "";//记录点击列表点
/**
 * @title:Jquery
 * @description:初始化盘查人员信息
 * @author: zhang_guoliang@founder.com
 * @param      
 * @date:2015-12-02 16:03:43
 */
$(function(){
	PcryList.onloadMap();
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-02 11:32:23
 */	
PcryList.onloadMap = function(){
	/*地图对象*/
	PcryList.map = new FrameTools.Map();
	/*设置地图代理*/
	PcryList.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	PcryList.map.setMapDiv("mapDiv");
	/*加载地图*/
	PcryList.map.onloadMap();
	/*显示鹰眼*/
	PcryList.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	PcryList.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	PcryList.map.showNewMapServer("mapDiv","PcryList.map");
	/*加载地图工具条*/
	PcryList.map.buildTools("mapDiv","toolDiv","PcryList.map");
	//只在责任区和派出所级别加载辖区边界 辖区太大在IE8会停止运行脚本
	PcryList.map.moveMapToBjzbz(bjzbz);
};
/**
 * @title:queryButton
 * @description:查询按钮
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-11-23 20:30:32
 */	
PcryList.queryButton = function(){
	var ryxm = document.getElementById("ryxm").value;
	var sfzh = document.getElementById("sfzh").value;
	var sfzt = document.getElementById("sfzt").value;
	var sffa = document.getElementById("sffa").value;
	ryxm = $.trim(ryxm);
	sfzh = $.trim(sfzh);
	$('#dg').datagrid('load',{    
		'ryxm':ryxm,
		'sfzh':sfzh,
		'sfzt':sfzt,
		'sffa':sffa
	});
};
/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-08 15:30:13
 */	
PcryList.loadPoint = function(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	PcryList.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(PcryList.setInt!=""){
		clearInterval(PcryList.setInt);
	}
	//判断地图上已经存在点图层清除
	if(PcryList.initMarkerArr!=null){
		var markerLen = PcryList.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			PcryList.map._MapApp.removeOverlay(PcryList.initMarkerArr[j]);
		}
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	PcryList.setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].xpoint;
			var zby = rows[count].ypoint;
			var title = rows[count].ryxm;
			if(zbx!=""&&zby!=""){
				var initMarker = PcryList.map.initMarker(title,zbx,zby,"syrkBlue.png",null,null,43,37);
				PcryList.map._MapApp.addOverlay(initMarker);
				PcryList.initMarkerArr.push(initMarker);
				PcryList.addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(PcryList.setInt);
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
PcryList.addMapToListFun = function(PMarker,row){
	PMarker.addListener("click",function(){
		 PcryList.addClickMarker(row);
	});
};
/**
 * @title:addClickMarker
 * @description:地图图标变换
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-08 15:37:43
 */	
PcryList.addClickMarker = function(row){
	//关闭所有器已经打开的气泡框
	PcryList.map._MapApp.closeInfoWindow();
	if(PcryList.initMarker!=""){
		//清除之前的坐标点
		PcryList.map._MapApp.removeOverlay(PcryList.initMarker);
	}
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var title = rowData.ryxm;
	var zbx = rowData.xpoint;
	var zby = rowData.ypoint;
	if(zbx!=""&&zby!=""){
		PcryList.initMarker = PcryList.map.initMarker(title,zbx,zby,'syrkRedSmall.png',null,null,43,37);
		PcryList.map._MapApp.addOverlay(PcryList.initMarker);
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
	}
};
/**
 * @title:onClickRow
 * @description:点击列表事件
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-12-08 15:40:23
 */
PcryList.onClickRow = function(rowIndex,rowData){
	PcryList.addClickMarker(rowIndex);
};
/**
 * @title:datagridProcessFormater
 * @description:列表操作
 * @author: zhang_guoliang@founder.com
 * @param 
 * @date:2015-12-11 11:02:21
 */
PcryList.datagridProcessFormater = function(val,row,index){
	return '&nbsp;<a class="link" href="javascript:void(0)" onclick="PcryList.doXlgj('+index+')">轨迹</a>&nbsp;';
};
/**
 * @title:doXlgj
 * @description:巡逻轨迹
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2015-12-11 11:31:21
 */	
PcryList.doXlgj = function(index){
    cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var url = '/xlpc/createXlpc?ryxm='+rowData.ryxm+'&sfzh='+rowData.sfzh+'&mainTabID='+getMainTabID();
    menu_open('盘查轨迹',encodeURI(encodeURI(url)));
};