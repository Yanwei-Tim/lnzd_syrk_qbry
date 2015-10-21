var markerArr = new Array();
var dz_dwdzdmArr = new Array();
//datagrid加载完成后事件，地图定位
function loadpoints1(data){
	//延迟加载统计
	beforeTableLoad(data,'dg');
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if (mapWindow.SydwMap) {
			mapPoint(mapWindow);
		}else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}
//地图定位
function mapPoint(mapWindow) {
	//markerArr = new Array();
	if (mapWindow.SydwMap) {
		mapWindow.SydwMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		var dwidsArray = [];
		for (var i = 0; i < len; i++) {
			dwidsArray.push("'" + rows[i].id + "'");
			if (rows[i].dz_dwdzdm != "undefined" && rows[i].dz_dwdzdm != "") {
				dz_dwdzdmArr[rows[i].dz_dwdzdm] = rows[i].dz_dwdzdm;
			}
		}
		if (len > 0) {
			$.ajax({
				type:"GET",
				sync:true,
				url:contextPath+"/sydwcx/queryZbByDzId",
				data:{dwids:dwidsArray.join(",")},
				dataType:'json',
				success:function(json){
					var len = json.length;
					for (var i = 0; i < len; i++) {
						
						if (json[i].zbx!=null && json[i].zbx!=""){
							var marker = null;
							if (IE) {
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							} else{
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							}
							markerArr[json[i].dz_dwdzdm] = marker;
							dz_dwdzdmArr[json[i].dz_dwdzdm] = json[i].dz_dwdzdm;
							console.log(json[i].dz_dwdzdm);
						}
					}
				}
			});
		}
	}
}

//ZdryManage.onClickRow = function(rowIndex, rowData) {
//	var point = new Point(rowData.zbx, rowData.zby);
//	// 气泡框内容
//	//var openHtml = "";
//	//ZdryManage.map._MapApp.openInfoWindow(point, openHtml, true);
//	ZdryManage.clearMarkers();
//	//ZdryManage.map._MapApp.clear();
//	ZdryManage.map._MapApp.addOverlay(ZdryManage.initMarkerArr[rowIndex]);
//	ZdryManage.map._MapApp.centerAndZoom(point, 19);
//};

function datagridProcessFormater(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateAndXq(this, '+index+')">查看</a>&nbsp;'+
	       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">下发</a>&nbsp;'+
	       '<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateAndXq1(this, '+index+');">呈请变更</a>';
};
 function deliver(linkObject, index){
	   var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		/*var params = {zdryid:rowData.zdryid};
		var fajax =new FrameTools.Ajax(contextPath+"/main/countPcs",ZdryxxAndOp_back);
		fajax.send(params);*/
		var Str="";
		Str = Str+"	<table border=\"0\" cellpadding=\"0\" cellspacing=\"10\" width=\"100%\" height=\"100%\" align=\"center\">";
		Str = Str+" <tr >"
		Str = Str+"<th  align=\"right\"  width=\"20%\">管辖地市：</th>";
		Str = Str+"<td width=\"30%\"><input></td>";
		Str = Str+"<th  align=\"right\"  width=\"20%\">操作意见：</th>";
		Str = Str+"<td width=\"30%\"></td>";
		Str = Str+"</tr>";
		Str = Str+"		<tr class=\"dialogTr\" style=\"padding-bottom:0px;margin-bottom:0px;\">";
		Str = Str+"		<td width=\"100%\" colspan=\"2\" align=\"right\"><a class=\"easyui-linkbutton\" iconCls=\"icon-ok\" onclick=\"queryButton();\">下发</a>";
		Str = Str+"		<a class=\"easyui-linkbutton\" iconCls=\"icon-cancel\"	onclick=\"closeWindowdeverd();\">关闭</a></td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
	
		$("#deliverd").show();
		$("#deliverd").window("open"); 
	   
 }
 function doUpdateAndXq1(linkObject, index){
	 var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		/*var params = {zdryid:rowData.zdryid};
		var fajax =new FrameTools.Ajax(contextPath+"/main/countPcs",ZdryxxAndOp_back);
		fajax.send(params);*/
		var Str="";
		Str = Str+"	<table border=\"0\" cellpadding=\"0\" cellspacing=\"10\" width=\"100%\" height=\"100%\" align=\"center\">";
		Str = Str+" <tr >"
		Str = Str+"<th  align=\"right\"  width=\"20%\">操作意见：</th>";
		Str = Str+"<td width=\"30%\"></td>";
		Str = Str+"</tr>";
		Str = Str+"		<tr class=\"dialogTr\" style=\"padding-bottom:0px;margin-bottom:0px;\">";
		Str = Str+"		<td width=\"100%\" colspan=\"2\" align=\"right\"><a class=\"easyui-linkbutton\" iconCls=\"icon-ok\" onclick=\"queryButton();\">下方法</a>";
		Str = Str+"		<a class=\"easyui-linkbutton\" iconCls=\"icon-cancel\"	onclick=\"closeWindowdeverd();\">关闭</a></td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
	
		$("#deliverd").show();
		$("#deliverd").window("open"); 
};
//查询按钮
function queryButton(){
	
	var xm =$("#xm").val();
	var zjhm =$("#sfzh").val();
	var xzdxz =$("#xzdxz").val();
	$('#dg').datagrid(
			'load',
			{    
				'xm': xm,   
				'sfzh': zjhm ,
				'xzdxz':xzdxz
			});
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}

function setDzqc(obj){
	   obj.value="";
}

//精确查询
function detailSearch() {
	$("#win").window("open");
}
function closeWindow() {
	$("#win").window("close");
}

//下发相关操作
function closeWindowdeverd(){
	$("#deliverd").window("close");
}

function ZdryxxAndOp_back(){
	
}