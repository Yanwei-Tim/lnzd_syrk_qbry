if(typeof Pcgj == "undefined" || !Pcgj){
	var Pcgj = {};
};
Pcgj = function(){
	this.pk = Math.random();
};
Pcgj.initMarkerArr = new Array();//放点对象
Pcgj.setInt = "";//记录延时
/**
 * @title:Jquery
 * @description:初始化盘查轨迹
 * @author: zhang_guoliang@founder.com
 * @date:2015-12-10 09:19:24
 */
$(function(){
	//初始化地图
	Pcgj.onloadMap();
	//加载浮动窗口
	Pcgj.initFloatWin();
	//键盘回车进行查询
	$("body").bind("keydown",function(e){
        if(e.keyCode==13){
        	Pcgj.initButton();
        }		
	});
});
/**
 * @title:onloadMap
 * @description:初始化地图
 * @author: zhang_guoliang@founder.com
 * @date:2015-12-10 09:20:31
 */
Pcgj.onloadMap = function(){
	/*地图对象*/
	Pcgj.map = new FrameTools.Map();
	/*设置地图代理*/
	Pcgj.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	Pcgj.map.setMapDiv("mapDiv");
	/*加载地图*/
	Pcgj.map.onloadMap();
	/*显示鹰眼*/
	Pcgj.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	Pcgj.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	Pcgj.map.showNewMapServer("mapDiv","Pcgj.map");
	/*加载地图工具条*/
	Pcgj.map.buildTools("mapDiv","toolDiv","Pcgj.map");
	//只在责任区和派出所级别加载辖区边界
	Pcgj.map.moveMapToBjzbz(bjzbz);
};
/**
 * @title:onloadMap
 * @description:加载浮动窗口
 * @author: zhang_guoliang@founder.com
 * @date:2015-12-10 09:31:46
 */
Pcgj.initFloatWin = function(){
	 var queryHTML = '<table cellspacing="0" cellpadding="0" border="0" style="margin:10px;padding:5px;">' +
		 				 '<tr class="dialogTr">' +
		 				 	 '<td class="dialogTd" style="width:65px" align="left">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>' +
		 				 	 '<td class="dialogTd" style="width:195px" align="left">' +
		 				 	 	'<input type="text" name="ryxm" id="ryxm" class="easyui-validatebox" data-options="required:false" style="width:195px;" value="'+ryxm+'"/>' +
		 				 	 '</td>' +
		 				 '</tr>' +
		 				 '<tr class="dialogTr">' +
		 				 	 '<td class="dialogTd" style="width:65px" align="left">身份证号：</td>' +
		 				 	 '<td class="dialogTd" style="width:195px" align="right">' +
		 				 	 	'<input type="text" name="sfzh" id="sfzh" class="easyui-validatebox" data-options="required:false" style="width:195px;" value="'+sfzh+'"/>' +
		 				 	 '</td>' +
		 				 '</tr>' +
			 		     '<tr class="dialogTr">' +
		 				 	 '<td class="dialogTd" style="width:65px" align="left">盘查日期：</td>' +
		 				 	 '<td class="dialogTd" style="width:220px" align="left">'+
		 				 	 	'<input type="text" name="kssj" id="kssj" class="easyui-validatebox" style="width:85px;vertical-align: middle;" value="'+kssj+'"'+
		 				 	 	'onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyy-MM-dd\', maxDate:\'%y-%M-%d\'})"'+
		 				 		'data-options="required:false,tipPosition:\'left\',validType:[\'date[\'yyyy-MM-dd\']\']"/>'+
		 				 	 	'&nbsp;至&nbsp;'+
		 				 	 	'<input type="text" name="jssj" id="jssj" class="easyui-validatebox" style="width:85px;vertical-align: middle;" value="'+jssj+'"'+
							    'onclick="WdatePicker({skin:\'whyGreen\',dateFmt:\'yyyy-MM-dd\', maxDate:\'%y-%M-%d\'})" data-options="required:false,tipPosition:\'left\','+
								'validType:[\'date[\'yyyy-MM-dd\']\']"/>' +
		 				 	 '</td>' +
	 				 	 '</tr>' +
	 				 	 '<tr class="dialogTr">' +
	 				 	 	 '<td class="dialogTd" style="width:65px" align="left"></td>' +
	 				 	 	 '<td class="dialogTd" style="width:195px;" align="left">'+
	 				 	 	 	  '<input type="button" onclick="Pcgj.dateTime(1)" id="query" value="今天" style="width:40px;border:#93bee2 1px solid;background-color:#e8f4ff;color:#003399;cursor: pointer;"/>' +
	 				 	 	 	  '<input type="button" onclick="Pcgj.dateTime(2)" id="query" value="三天" style="width:40px;margin-left:10px;border:#93bee2 1px solid;background-color:#e8f4ff;color:#003399;cursor: pointer;"/>' +
	 				 	 	 	  '<input type="button" onclick="Pcgj.dateTime(3)" id="query" value="本周" style="width:40px;margin-left:10px;border:#93bee2 1px solid;background-color:#e8f4ff;color:#003399;cursor: pointer;"/>' +
	 				 	 	 '</td>' +
	 				 	 '</tr>' +
	 				 	 '<tr class="dialogTr" style="padding-top: 25px;">' +
				 	 	     '<td class="dialogTd" colspan="2" style="width:290px" align="center">'+
				 	 	     	'<input type="button" onclick="Pcgj.initButton()" value="查询" style="font-size: 14px;width:50px;height:20px;border:#93bee2 1px solid;background-color:#127EE2;color:#fff;cursor: pointer;"/>' +
				 	 	     	'<input type="button" onclick="Pcgj.restButton()" value="重置" style="font-size: 14px;width:50px;height:20px;margin-left:10px;border:#93bee2 1px solid;background-color:#127EE2;color:#fff;cursor: pointer;"/>' +
				 	 	     '</td>' +
				 	 	 '</tr>' +
	 				 '</table>';
	 var left = $jquery("#mapDiv").width() - 320;
	 Pcgj.floatWin = new FrameTools.FloatWin("盘查轨迹","mapDiv",300,240,85,left,85,null,220,1);
	 Pcgj.floatWin.setOpHtml(queryHTML);
	 if(sfzh!=null&&sfzh!=""){
		 Pcgj.initButton();
	 }
};
/**
 * @title:initButton
 * @description:查询盘查轨迹
 * @author: zhang_guoliang@founder.com
 * @date:2015-12-10 14:53:32
 */
Pcgj.initButton = function(){
	var xm = document.getElementById("ryxm").value;
	var zjhm = document.getElementById("sfzh").value;
	var kssj = document.getElementById("kssj").value;
	var jssj = document.getElementById("jssj").value;
	xm = $.trim(xm);
	zjhm = $.trim(zjhm);
	if(xm==""&&zjhm==""){
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: "请输入姓名或身份证号进行查询。",
			timeout:2500
		});
	}else{
		var params = {ryxm:xm,sfzh:zjhm,kssj:kssj,jssj:jssj};
		var fajax = new FrameTools.Ajax(contextPath+"/xlpc/queryPcry",Pcgj.initButton_back);
		fajax.send(params);
	}
};
/**
 * @title:initButton_back
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param   
 * @date:2015-12-08 15:30:13
 */	
Pcgj.initButton_back = function(data){
	//关闭所有器已经打开的气泡框
	Pcgj.map._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(Pcgj.setInt!=""){
		clearInterval(Pcgj.setInt);
	}
	//判断地图上已经存在点图层清除
	if(Pcgj.initMarkerArr!=null){
		var markerLen = Pcgj.initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			Pcgj.map._MapApp.removeOverlay(Pcgj.initMarkerArr[j]);
		}
	}
	var len = data.length;
	if(len!=0){
		var count = 0;
		Pcgj.setInt = setInterval(function(){
			if(count<len){
				var zbx = data[count].xpoint;
				var zby = data[count].ypoint;
				var title = data[count].fssj;
				if(zbx!=""&&zby!=""){
					var initMarker = Pcgj.map.initMarker((count+1)+" "+title,zbx,zby,"syrkBlue.png",null,null,43,37);
					Pcgj.map._MapApp.addOverlay(initMarker);
					Pcgj.initMarkerArr.push(initMarker);
					if(count>0){
						var line = data[count-1].xpoint+","+data[count-1].ypoint+","+data[count].xpoint+","+data[count].ypoint;
						var Linepolyline = Pcgj.map.initPolyline(line,"red",4,0.7,1,"dash");
						if(Linepolyline){
							Pcgj.map._MapApp.addOverlay(Linepolyline);
							Pcgj.initMarkerArr.push(Linepolyline);
						}
					}
				}
			}else{
				clearInterval(Pcgj.setInt);
			}
			count++;
		},400);
	}else{
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: "暂无盘查轨迹信息。",
			timeout:2500
		});
	}
};
/**
 * @title:restButton
 * @description:重置查询条件
 * @author: zhang_guoliang@founder.com
 * @date:2015-12-11 14:38:43
 */
Pcgj.restButton = function(){
	document.getElementById("ryxm").value = "";
	document.getElementById("sfzh").value = "";
	document.getElementById("kssj").value = kssj;
	document.getElementById("jssj").value = jssj;
};
/**
 * @title: dateTime
 * @description:设置时间
 * @author: zhang_guoliang@founder.com
 * @date:2015-12-11 16:26:32
 */
Pcgj.dateTime = function(bz){
	var params = {bz:bz};
	var fajax = new FrameTools.Ajax(contextPath+"/xlpc/queryDateTime",Pcgj.dateTime_back);
	fajax.send(params);
};
/**
 * @title: dateTime
 * @description:设置时间_回调函数
 * @author: zhang_guoliang@founder.com
 * @date:2015-12-11 16:35:23
 */
Pcgj.dateTime_back = function(json){
	document.getElementById("kssj").value = json.kssj;
	document.getElementById("jssj").value = json.jssj;
};