if(typeof PcrwList == "undefined" || !PcrwList){
	var PcrwList = {};
};
PcrwList = function(){
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
	var gzdd = document.getElementById("gzdd").value;
	var xlmc = document.getElementById("xlmc").value;
	gzdd = $.trim(gzdd);
	xlmc = $.trim(xlmc);
	$('#dg').datagrid('load',{    
		'gzdd':gzdd,
		'xlmc':xlmc
	});
};