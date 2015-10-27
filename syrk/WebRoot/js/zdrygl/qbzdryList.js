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
	if(orgLevel!="50"){
		if(dqzt=="01"&&czlb=="100"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">下发</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateQb(this, '+index+');">申请退回</a>';	
		}
		//已下发状态
		if(dqzt=="02"&&czlb=="01"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>';
			
		}
		if(dqzt=="01"&&czlb=="01"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">下发</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateQb(this, '+index+');">申请退回</a>';
			
		}
		if(dqzt=="04"&&czlb=="03"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doCxSq(this, '+index+')">撤回退回</a>';
		}
		if(dqzt=="02"&&czlb=="03"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doSpSq(this, '+index+')">审批退回</a>';
		}

		if((dqzt=="03"&&czlb=="01")||(dqzt=="04"&&czlb=="01")){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">重新分配管辖区</a>';
		}
	}else{
		if(dqzt=="01"&&czlb=="100"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="accept(this, '+index+')">接收</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateQb(this, '+index+');">申请退回</a>';	
		}
		//已下发状态
		if(dqzt=="02"&&czlb=="01"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>';
			
		}
		if(dqzt=="01"&&czlb=="01"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
			'<a class="link" href="javascript:javascript:void(0)" onclick="accept(this, '+index+')">接收</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateQb(this, '+index+');">申请退回</a>';
			
		}
		if(dqzt=="04"&&czlb=="03"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doCxSq(this, '+index+')">撤回退回</a>';
		}
		if(dqzt=="02"&&czlb=="03"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doSpSq(this, '+index+')">审批退回</a>';
		}

		if((dqzt=="03"&&czlb=="01")||(dqzt=="04"&&czlb=="01")){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">重新分配管辖区</a>';
		}
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
 //申请退回
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
		Str = Str+"	<a id='doUpdateQbBgBtn' href='javascript:void(0)'  onclick=\"doUpdateQbBg('"+rowData.zdryid+"');\">申请退回</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
		$.parser.parse();
		$("#deliverd").show();
		$("#deliverd").window("open"); 
};
//撤回申请退回
function doCxSq(linkObject, index){
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
		Str = Str+"	<a id='doCxSqBg' href='javascript:void(0)'  onclick=\"doCxSqBg('"+rowData.zdryid+"');\">撤回退回</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
		$.parser.parse();
		$("#deliverd").show();
		$("#deliverd").window("open"); 
};

//审批退回申请
function doSpSq(linkObject, index){
	 var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		insertZdry(rowData);
		initopreation(rowData.zdryid);
		var Str="";
		Str = Str+"	<table border='0' cellpadding='0' cellspacing='10' width='100%' height='100%' align='center'>";
		Str = Str+" <tr class='dialogTr'>";
		Str = Str+" <td width='20%' class='dialogTd' align=\"right\">审批情况：";
		Str = Str+" </td>";
		Str = Str+" <td width='25%' class='dialogTd'>";
		Str = Str+" <input type=\"radio\" id=\"sfty\" name=\"sfty\" value=\"0\" onclick=\"sp_onClick()\" checked=\"checked\">同意";
		Str = Str+" <input type=\"radio\" id=\"sfty\" name=\"sfty\" value=\"1\" onclick=\"sp_onClick()\">拒绝";
		Str = Str+" </td>";
		Str = Str+" <td width=\"55%\" class=\"dialogTd\" align=\"left\" id=\"sp_tr1\" style=\"display:none;\">操作意见：";
		Str = Str+" <input type='text' name='sp_czyj' id ='sp_czyj' style='width:280px;'/>";
		Str = Str+" </td>"
		Str = Str+" <td width=\"55%\" class=\"dialogTd\" align=\"left\" id=\"sp_tr2\">下发部门：";
		Str = Str+" <input type=\"text\" name=\"orgList\" id=\"orgList\"  class=\"easyui-combobox\" style=\"width:200px;\" data-options=\"url: contextPath + '/orgPublicSelect/queryComboBoxList?parentOrgCode="+parentOrgCode+"',required:true,method:'get',valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false\">";
		Str = Str+" </td>"
		Str = Str+" </tr>";
		Str = Str+" <tr class='dialogTr'>";
		Str = Str+"	<td width='100%' colspan='3' align='center'>"
		Str = Str+"	<a id='' href='javascript:void(0)'  onclick=\"doSpThSq('"+rowData.zdryid+"','"+rowData.zrqbmdm+"','"+rowData.pcsbmdm+"','"+rowData.fxjbmdm+"','"+rowData.sjbmdm+"','"+rowData.stbmdm+"');\">审批退回申请</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
		$.parser.parse();
		$("#deliverd").show();
		$("#deliverd").window("open"); 
};


function sp_onClick(){
	var redio = $('input[name="sfty"]:checked').val();
	if(redio=='0'){
		$("#sp_tr1").hide();
		$("#sp_tr2").show();
	}else if(redio=='1'){
		$("#sp_tr1").show();
		$("#sp_tr2").hide();
	}
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
				{field:'czlb',title:'操作类型',width:80,align:'center',halign:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/QB_D_DQZT.js'},
				{field:'czyj',title:'说明',width:80,align:'center',halign:'center'}
		 ]]
		
	});
}

//申请变更
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

//撤销申请变更
function doCxSqBg(zdryid) {
	var doUpdateUrl = contextPath + '/zdryQbzdryxxbUp/updateCxQb';
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

//审批退回申请
function doSpThSq(zdryid,zrqbmdm,pcsbmdm,fxjbmdm,sjbmdm,stbmdm){
var orgListcode =$('#orgList').combobox('getValue');
var orgtext = $('#orgList').combobox('getText');
var sp_czyj = $("#sp_czyj").val(); 
var redio = $('input[name="sfty"]:checked').val();
if ("undefined" == typeof orgtext || orgtext == null || orgtext=="") {
	return;
}
//orgLevel=32当前级别为派出所、查找下一级责任区
if(redio=="0"){
	if(orgLevel=="32"){
		if(orgListcode==zrqbmdm)
			{
				alert("不可指定原来所下发过的地市");
			}else{
				alert("你妹的");
				Ty(zdryid,orgListcode,orgtext,zrqbmdm);
			}
	}
}
	

function Ty(zdryid,orgListcode,orgtext,xjbmdm){
	var params = {zdryid:zdryid,orgcode:orgListcode,orgcodetext:orgtext,xjbmdm:xjbmdm};
	var fajax =new FrameTools.Ajax(contextPath+"/zdryQbzdryxxbUp/agdeliver",closeWindowdeverd);
	fajax.send(params);
}

	
}

//下发操作
function doDeliver(zdryid){
var orgListcode =$('#orgList').combobox('getValue');
var orgtext = $('#orgList').combobox('getText');
var xf_czyj = $("#xf_czyj").val();
var params = {zdryid:zdryid,xfczyj:xf_czyj,orgcode:orgListcode,orgcodetext:orgtext};
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
//民警重点人员情报接收
function accept(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var zdryid = rowData.zdryid;
	var shjh = rowData.shjh;
	var params = {zdryid:zdryid,shjh:shjh};
	var fajax =new FrameTools.Ajax(contextPath+"/zdryQbzdryxxb/accept",accept_back);
	fajax.send(params);
	
}
function accept_back(json){
	if(json=="0"){
	       menu_open('实有人口新增', "/forward/message|sysMessage");
	}else{
		jQuery.messager.alert('提示:','接收成功！!','info');
		$('#dg').datagrid('reload');
	}
}