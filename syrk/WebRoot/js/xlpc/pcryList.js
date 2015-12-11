if(typeof PcryList == "undefined" || !PcryList){
	var PcryList = {};
};
PcryList = function(){
	this.pk = Math.random();
};
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
	var sfpcdx = document.getElementById("sfpcdx").value;
	ryxm = $.trim(ryxm);
	sfzh = $.trim(sfzh);
	$('#dg').datagrid('load',{    
		'ryxm':ryxm,
		'sfzh':sfzh,
		'sfzt':sfzt,
		'sffa':sffa,
		'sfpcdx':sfpcdx
	});
};