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
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var dqzt = rowData.dqzt;
	var czlb = rowData.czlb;
	//初始化状态
	if(dqzt=="01"&&czlb=="100"){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
	       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">下发</a>&nbsp;'+
	       '<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateQb(this, '+index+');">申请变更</a>';	
	}
	//已下发状态
	if(dqzt=="02"&&czlb=="01"){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>';
		
	}
	if(dqzt=="03"&&czlb=="02"){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
	       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">撤销申请</a>';
	}
	if(dqzt=="04"&&czlb=="03"){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
	       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">撤销回退</a>';
	}
	if((dqzt=="03"&&czlb=="01")||(dqzt=="04"&&czlb=="01")){
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
	       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">重新分配管辖区</a>';
	}
	
};
 function deliver(linkObject, index){
	   var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		insertZdry(rowData);
		initopreation(rowData.zdryid);	
		var Str="";
		Str = Str+"	<table border='0' cellpadding='0' cellspacing='10' width='100%' height='100%' align='center'>";
		Str = Str+" <tr>"
		Str = Str+" <th align='right' width='20%'>下发部门：</th>";
		Str = Str+" <td width='30%' class='dialogTd'><input type=\"text\" name=\"orgList\" id=\"orgList\"  class=\"easyui-combobox\" style=\"width:200px;\" data-options=\"url: contextPath + '/orgPublicSelect/queryComboBoxList?parentOrgCode="+parentOrgCode+"',required:true,method:'get',valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false\"></td>";
		Str = Str+" <th align='right' width='20%'>操作意见：</th>";
		Str = Str+" <td width='30%' class='dialogTd'><input type='text' name='xf_czyj' id ='xf_czyj'style='width:300px;' /></td>";
		Str = Str+" </tr>";
		Str = Str+"	<tr>";
		Str = Str+"	<td width='100%' colspan='2' align='right'>"
		Str = Str+"	<a  class='easyui-linkbutton'  href='javascript:void(0)'  onclick=\"doDeliver('"+rowData.zdryid+"');\">下发</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
	    $.parser.parse();
		$("#deliverd").show();
		$("#deliverd").window("open"); 
	   
 }
 function doUpdateQb(linkObject, index){
	 var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		insertZdry(rowData);
		initopreation(rowData.zdryid);
		var Str="";
		Str = Str+"	<table border='0' cellpadding='0' cellspacing='10' width='100%' height='100%' align='center'>";
		Str = Str+" <tr>"
		Str = Str+" <th width='20%'>操作意见：</th>";
		Str = Str+" <td width='30%' class='dialogTd'><input type='text' name='czyj' id ='sq_czyj' style='width:300px;' /></td>";
		Str = Str+" </tr>";
		Str = Str+"	<tr>";
		Str = Str+"	<td width='100%' colspan='2' align='center'>"
		Str = Str+"	<a id='doUpdateQbBgBtn' href='javascript:void(0)'  onclick=\"doUpdateQbBg('"+rowData.zdryid+"');\">申请变更</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
		$.parser.parse();
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

//执行完毕
function closeWindowdeverd(){
	$("#deliverd").window("close");
	$('#dg').datagrid('reload');
}

function ZdryxxAndOp_back(){
	
}
//初始化重点人员基本信息
function insertZdry(data){
	$("#xm").val(data.xm) ;
	$("#wwxm ").val(data.wwxm) ;
	$("#xb").val(data.xb) ;
	$("#csrq").val(data.csrq) ;
	$("#gj").val(data.gj) ;
	if(data.sfzh !=null&&data.sfzh!=""){
		$("#zjhm").val(data.sfzh) ;
	}else{
		$("#zjhm").val(data.qtzjhm) ;
	}
	$("#mz").val(data.mz) ;
	
	$("#jg").val(data.jg) ;
	$("#hjdxz").val(data.hjdxz) ;
	$("#xzdxz").val(data.xzdxz) ;
	$("#ladwjgdm").val(data.ladwjgdm) ;
	$("#zjlasj").val(data.zjlasj) ;
	$("#zdryxl").val(data.zdryxl) ;
	$("#yxx").val(data.yxx) ;
}
//初始化操作列表
function initopreation(zdryid){
	$('#dgtable').datagrid({
		url:contextPath+'/zdryQbzdryxxb/operation?zdryid='+zdryid,
		selectOnCheck:true,
		checkOnSelect:true,
		singleSelect:true,
		fitColumns:true,
		border:true,
		pagination:true,
		width:100,
		rownumbers:true,
		columns:[[
	          	{field:'czrq',title:'操作时间',width:150,align:'center',halign:'center'},
				{field:'czr',title:'操作人',width:80,align:'center',halign:'center'},
				{field:'czbm',title:'操作部门',width:80,align:'center',halign:'center'},      
				{field:'czlb',title:'操作类型',width:80,align:'center',halign:'center'},
				{field:'czyj',title:'说明',width:80,align:'center',halign:'center'}
		 ]]
		
	});
}

//初始化操作列表
//function doUpdateQbBg(zdryid){
//	var sq_czyj =$("#sq_czyj").val();
//	var params = {zdryid:zdryid,czyj:sq_czyj};
//	var fajax =new FrameTools.Ajax(contextPath+"/zdryQbzdryxxbUp/updateQb",closeWindowdeverd);
//	fajax.send(params);
//	
//}
function doUpdateQbBg(zdryid) {
	var doUpdateUrl = contextPath + '/zdryQbzdryxxbUp/updateQb';
	var datagrid_ID = 'dg';
	var sq_czyj =$("#sq_czyj").val();
    var data = {
        "zdryid":zdryid,
		"czyj":sq_czyj
	};
	$.ajax({
		url: doUpdateUrl,
		type: 'POST',
		data: data
	}).done(function(result) {
		$("#deliverd").window("close");
		$('#dg').datagrid('reload');
		doSubmitResult(result, null, datagrid_ID);
	});
}

//下发操作
function doDeliver(zdryid){
var orgListcode =$('#orgList').combobox('getValue');
var xf_czyj = $("#xf_czyj").val();
var params = {zdryid:zdryid,xfczyj:xf_czyj,orgcode:orgListcode};
var fajax =new FrameTools.Ajax(contextPath+"/zdryQbzdryxxb/deliver",closeWindowdeverd);
fajax.send(params);
	
}
//查看
function doView(linkObject, index){
	   var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		insertZdry(rowData);
		initopreation(rowData.zdryid);	
		$("#deliverd").show();
		$("#deliverd").window("open"); 
	   
}