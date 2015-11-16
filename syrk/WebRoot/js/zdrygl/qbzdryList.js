if (typeof QbZdryManage == "undefined" || !QbZdryManage) {
	var QbZdryManage = {};
};
QbZdryManage = function() {
	this.pk = Math.random();
};
QbZdryManage.initMarkerArr = new Array();// 放点对象
QbZdryManage.setInt = "";// 记录延时
/**
 * @title:Jquery
 * @description:初始化地址管理
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:37:32
 */
$(function() {
	QbZdryManage.onloadMap();
	// 键盘回车进行查询
	$("body").bind("keydown", function(e) {
		if (e.keyCode == 13) {
			queryButton();
		}
	});
});
/**
 * @title:onloadMap
 * @description:加载地图
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:38:12
 */
QbZdryManage.onloadMap = function() {
	/* 地图对象 */
	QbZdryManage.map = new FrameTools.Map();
	/* 设置地图代理 */
	QbZdryManage.map.setProxy(contextPath + "/Proxy");
	/* 设置地图加载容器 */
	QbZdryManage.map.setMapDiv("mapDiv");
	/* 加载地图 */
	QbZdryManage.map.onloadMap();
	/* 显示鹰眼 */
	QbZdryManage.map.addOverView();
	/* 隐藏自带矢量影像图层对象 */
	QbZdryManage.map._MapApp.hideMapServer();
	/* 加载自定义的矢量影像图层对象 */
	QbZdryManage.map.showNewMapServer("mapDiv", "QbZdryManage.map");
	/* 加载地图工具条 */
	QbZdryManage.map.buildTools("mapDiv", "toolDiv", "QbZdryManage.map");
	/* 设置工具条显示的位置 */
	QbZdryManage.diyToolDiv();
	/* 窗口变化地图工具条自动变 */
	$("#mapDiv").resize(function() {
		QbZdryManage.diyToolDiv();
	});
	/* 加载边界坐标值 */
	if (bjzbz != "" && bjzbz != 'null') {
		/* 显示当前用户边界 */
		QbZdryManage.moveMapToBjzbz();
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:39:41
 */
QbZdryManage.diyToolDiv = function() {
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : 10
	});
};
/**
 * @title:moveMapToBjzbz
 * @description:加载当前用户边界
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:39:54
 */
QbZdryManage.moveMapToBjzbz = function() {
	/* 清楚地图上所有的标记 */
	QbZdryManage.map._MapApp.clear();
	/* 非地坐标 */
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/* 记录边线中心点坐标 */
	QbZdryManage.mbrArr = new Array();
	for ( var j = 0; j < bjnum; j++) {
		var gArr = bj[j];
		/* 创建边界图元素 */
		var polyline = QbZdryManage.map.initPolyline(gArr, "blue");
		/* 图元素添加到地图上 */
		if (polyline) {
			QbZdryManage.map._MapApp.addOverlay(polyline);
			QbZdryManage.mbrArr.push(polyline);
			if (QbZdryManage.Mbr == null) {
				QbZdryManage.Mbr = polyline.getMBR();
			} else {
				QbZdryManage.Mbr = MBR.union(QbZdryManage.Mbr, polyline.getMBR());
			}
		}
	}
	/* 根据图元素将地图放到最适合的级别和位置 */
	QbZdryManage.map._MapApp.centerAtMBR(QbZdryManage.Mbr);
	/* 新版本cliect自动适应级别有问题必须降一级 */
	QbZdryManage.map._MapApp.zoomOut();
};

/**
 * @title:loadPoint
 * @description:加载地图坐标点
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 10:58:43
 */
 QbZdryManage.loadPoint = function(data) {
	// 延迟加载列表统计
	beforeTableLoad(data, 'dg');
	// 关闭所有器已经打开的气泡框
	QbZdryManage.map._MapApp.closeInfoWindow();
	// 判断延时是否执行完，没执行完终止此方法
	if (QbZdryManage.setInt != "") {
		clearInterval(QbZdryManage.setInt);
	}
	// 判断地图上已经存在点图层清除
	if (QbZdryManage.initMarkerArr != null) {
		var markerLen = QbZdryManage.initMarkerArr.length;
		for ( var j = 0; j < markerLen; j++) {
			QbZdryManage.map._MapApp.removeOverlay(QbZdryManage.initMarkerArr[j]);
		}
	}
	// 延时加载点图层     地图zbx、zby 从后台获取过来更改一下
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	QbZdryManage.setInt = setInterval(function() {
		if (count < len) {
//			var zbx = rows[count].zbx;
//			var zby = rows[count].zby;
			var zbx = "121.5853";
			var zby = "38.9031";
			var title = rows[count].xm;
			if (zbx != "" && zby != "") {
				// 气泡框内容
				var openHtml = "";
				var initMarker = QbZdryManage.map.initMarker(title, zbx, zby,
						"jzw1.png", openHtml, null, 43, 37);
				QbZdryManage.map._MapApp.addOverlay(initMarker);
				QbZdryManage.initMarkerArr.push(initMarker);
				// 地图元素和列表联动
				QbZdryManage.addMapToListFun(initMarker, count);
			}
		} else {
			clearInterval(QbZdryManage.setInt);
		}
		count++;
	}, 90);
};
/**
 * @title:addMapToListFun
 * @description:地图元素和列表联动
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-26 18:02:12
 */
QbZdryManage.addMapToListFun = function(PMarker, row) {
	PMarker.addListener("click", function() {
		// 鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow", row);
	});
	/*
	 * PMarker.addListener("mouseout",function(){ //鼠标移动到点上取消列表选中
	 * $('#dg').datagrid("unselectRow",row); });
	 */
};
/**
 * @title:onClickRow
 * @description:点击一行的时候触发
 * @author: zhang_guoliang@founder.com
 * @param
 * @date:2014-12-27 14:57:21
 */
QbZdryManage.onClickRow = function(rowIndex, rowData) {
	var point = new Point("121.5853", "38.9031");
	// 气泡框内容
	//var openHtml = "";
	//ZdryManage.map._MapApp.openInfoWindow(point, openHtml, true);
	QbZdryManage.clearMarkers();
	//ZdryManage.map._MapApp.clear();
	QbZdryManage.map._MapApp.addOverlay(QbZdryManage.initMarkerArr[rowIndex]);
	QbZdryManage.map._MapApp.centerAndZoom(point, 19);
};
//只清除marker
QbZdryManage.clearMarkers = function(){
	QbZdryManage.map._MapApp.closeInfoWindow();
	var objs = QbZdryManage.map._MapApp.getOverlays() ;
	var len = objs.length;
	if(len>=1){
		for(var i=0;i<len;i++){
			var obj =objs[i].toString().split(",");
			if(obj.length<=2){
				QbZdryManage.map._MapApp.removeOverlay(objs[i]);
			}
		}
	}
};

//搜索功能
function searchMain(){
	var condition = document.getElementById("condition").value;
	if(condition=="请输入重点人员证件号码、姓名信息"){
		condition="";
	}
	var reloadUrl = contextPath + '/zdryQbzdryxxb/list';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	condition= $.trim(condition);
	$('#dg').datagrid('load',{condition:condition});
	$('#dg').datagrid("clearSelections");
}

function datagridProcessQbFormater(val,row,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var dqzt = rowData.dqzt;
	var czlb = rowData.czlb;
	var sfsyrk = rowData.sfsyrk;
	//初始化状态
	if(orgLevel!="50"){
		if((dqzt=="01"&&czlb=="100") || (dqzt=="01"&&czlb=="05")){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="deliver(this, '+index+')">下发</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateQb(this, '+index+');">申请退回</a>';	
		}
		//已下发状态
		if(dqzt=="02"&&czlb=="01"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>';
			
		}
		if(dqzt=="04"&&czlb=="03"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doCxSq(this, '+index+')">撤回申请</a>';
		}
		if(dqzt=="04"&&czlb=="01"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doSpSq(this, '+index+')">审批退回</a>';
		}

	}else{
		if((dqzt=="05"&&czlb=="100"&&sfsyrk=="0")||(dqzt=="05"&&czlb=="05"&&sfsyrk=="0")){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
			'<a class="link" href="javascript:javascript:void(0)" onclick="accept(this, '+index+')">接收</a>&nbsp;';
//		       '<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateQb(this, '+index+');">申请退回</a>';	
		}
		if((dqzt=="05"&&czlb=="100"&&sfsyrk=="1")||(dqzt=="05"&&czlb=="05"&&sfsyrk=="1")){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
		       '<a class="link" href="javascript:javascript:void(0)" onclick="doAdd(this, '+index+')">新增实有人口</a>&nbsp;';
//		       '<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateQb(this, '+index+');">申请退回</a>';	
		}
		//已接收状态
		if(dqzt=="06"&&czlb=="06"){
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>';
			
		}
//		if(dqzt=="04"&&czlb=="03"){
//			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
//		       '<a class="link" href="javascript:javascript:void(0)" onclick="doCxSq(this, '+index+')">撤回申请</a>';
//		}
//		if(dqzt=="02"&&czlb=="03"){
//			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView(this, '+index+')">查看</a>&nbsp;'+
//		       '<a class="link" href="javascript:javascript:void(0)" onclick="doSpSq(this, '+index+')">审批退回</a>';
//		}

		
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
		Str = Str+" <td align='right' width='20%'>操作意见：</td>";
		Str = Str+" <td width='30%' class='dialogTd' align='left'><input type='text' name='xf_czyj' id ='xf_czyj' class=\"easyui-validatebox\" data-options=\"required:true\"style='width:280px;' /></td>";
		Str = Str+" </tr>";
		Str = Str+"	<tr>";
		Str = Str+"	<td width='100%' colspan='4' align='center'>"
		Str = Str+"	<a  class='easyui-linkbutton'  href='javascript:void(0)'  onclick=\"doDeliver('"+rowData.zdryid+"');\">下发</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
	    $.parser.parse();
		$("#deliverd").show();
		$("#deliverd").window("open"); 
		$("#deliverd").panel({
			title:"情报下发"
			});
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
		Str = Str+" <td width='20%' align='right'>操作意见：</td>";
		Str = Str+" <td width='30%' class='dialogTd' align='left'><input type='text' name='czyj' id ='sq_czyj' class=\"easyui-validatebox\" data-options=\"required:true\"style='width:300px;' /></td>";
		Str = Str+" </tr>";
		Str = Str+"	<tr>";
		Str = Str+"	<td width='100%' colspan='2' align='center'>"
		Str = Str+"	<a class='easyui-linkbutton' href='javascript:void(0)'  onclick=\"doUpdateQbBg('"+rowData.zdryid+"','"+rowData.sjsfjjbgsq+"');\">申请退回</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
		$.parser.parse();
		$("#deliverd").show();
		$("#deliverd").window("open"); 
		$("#deliverd").panel({
			title:"申请退回"
			});
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
		Str = Str+" <td width='20%' align='right'>操作意见：</td>";
		Str = Str+" <td width='30%' class='dialogTd' align='left'><input type='text' name='czyj' id ='sq_czyj' class=\"easyui-validatebox\" data-options=\"required:true\"style='width:300px;' /></td>";
		Str = Str+" </tr>";
		Str = Str+"	<tr>";
		Str = Str+"	<td width='100%' colspan='2' align='center'>"
		Str = Str+"	<a  class='easyui-linkbutton' id='doCxSqBg' href='javascript:void(0)'  onclick=\"doCxSqBg('"+rowData.zdryid+"');\">撤回退回</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
		$.parser.parse();
		$("#deliverd").show();
		$("#deliverd").window("open"); 
		$("#deliverd").panel({
			title:"撤回申请"
			});
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
		Str = Str+" <input type='text' name='sp_czyj' id ='sp_czyj' class=\"easyui-validatebox\" data-options=\"required:true\"style='width:280px;' /></td>";
		Str = Str+" </td>"
		Str = Str+" <td width=\"55%\" class=\"dialogTd\" align=\"left\" id=\"sp_tr2\">下发部门：";
		Str = Str+" <input type=\"text\" name=\"orgList\" id=\"orgList\"  class=\"easyui-combobox\" style=\"width:200px;\" data-options=\"url: contextPath + '/orgPublicSelect/queryComboBoxList?parentOrgCode="+parentOrgCode+"',required:true,method:'get',valueField:'id',textField:'text',selectOnNavigation:false,isTopLoad:false\">";
		Str = Str+" </td>"
		Str = Str+" </tr>";
		Str = Str+" <tr class='dialogTr'>";
		Str = Str+"	<td width='100%' colspan='3' align='center'>"
		Str = Str+"	<a class='easyui-linkbutton' href='javascript:void(0)'  onclick=\"doSpThSq('"+rowData.zdryid+"','"+rowData.zrqbmdm+"','"+rowData.pcsbmdm+"','"+rowData.fxjbmdm+"','"+rowData.sjbmdm+"','"+rowData.stbmdm+"');\">审批退回申请</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
		$.parser.parse();   //解析所有页面
		$("#deliverd").show();
		$("#deliverd").window("open"); 
		$("#deliverd").panel({
			title:"审批退回申请"
			});
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
	var zdryxl = $("#qb_zdryxl").combobox("getValue");
	var xm = document.getElementById("qb_xm").value;
	var sfzh = document.getElementById("qb_sfzh").value;
	var xb = document.getElementById("qb_xbdm").value;
	var xzdxz = document.getElementById("qb_xzdxz").value;	
	xm= $.trim(xm);
	sfzh= $.trim(sfzh);
	xzdxz= $.trim(xzdxz);
	var reloadUrl = contextPath + '/zdryQbzdryxxb/list';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid(
			'load',
			{    
				'zdryxl': zdryxl,
				'xm': xm,   
				'sfzh': sfzh ,
				'xb': xb,
				'xzdxz':xzdxz
			});
	closeWindow();
}

//重置按钮
function resetButton(){
	$("#query_Qb_Form").form("reset");
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
	$("#xb").val(window.top.getDictName(contextPath+'/common/dict/D_BZ_XB.js',data.xb));
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
	$("#dqzt").val(window.top.getDictName(contextPath+'/common/dict/QB_D_DQZT.js',data.dqzt)) ;
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
				{field:'czlb',title:'操作类型',width:80,align:'center',halign:'center',fixed:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/QB_D_CZLB.js'},
				{field:'czyj',title:'说明',width:80,align:'center',halign:'center'}
		 ]]
		
	});
}

//申请变更
function doUpdateQbBg(zdryid,sjsfjjbgsq) {
	if(orgLevel=="10"){
		alert("当前最高级为市局！省厅暂时未开发！");
	}else{
	if(sjsfjjbgsq=="2"){
		alert("上级已经拒绝过一次变更申请,不可再次申请！");
	}else{
	var sq_czyj =$("#sq_czyj").val();
	if(sq_czyj==""||sq_czyj==null){
		alert("操作意见不能为空！");
	}else{
	var doUpdateUrl = contextPath + '/zdryQbzdryxxbUp/updateQb';
	var datagrid_ID = 'dg';
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
	}
	}
}

//撤销申请变更
function doCxSqBg(zdryid) {
	var doUpdateUrl = contextPath + '/zdryQbzdryxxbUp/updateCxQb';
	var datagrid_ID = 'dg';
	var sq_czyj =$("#sq_czyj").val();
	if(sq_czyj==""||sq_czyj==null){
		alert("操作意见不能为空！");
	}else{
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
}

//审批退回申请
function doSpThSq(zdryid,zrqbmdm,pcsbmdm,fxjbmdm,sjbmdm,stbmdm){
var orgListcode =$('#orgList').combobox('getValue');
var orgtext = $('#orgList').combobox('getText');
var sp_czyj = $("#sp_czyj").val(); 
var redio = $('input[name="sfty"]:checked').val();
//orgLevel=32当前级别为派出所、查找下一级责任区
if(redio=="0"){
	if ("undefined" == typeof orgtext || orgtext == null || orgtext=="") {
		return;
	}
	if(orgLevel=="10"){
		if(orgListcode==fxjbmdm)
		{
			alert("不可指定原来所下发过的地市");
		}else{
			Ty(zdryid,orgListcode,orgtext,fxjbmdm);
		}
	}
	if(orgLevel=="21"){
		if(orgListcode==pcsbmdm)
		{
			alert("不可指定原来所下发过的地市");
		}else{
			Ty(zdryid,orgListcode,orgtext,pcsbmdm);
		}
	}
	if(orgLevel=="32"){
		if(orgListcode==zrqbmdm)
			{
				alert("不可指定原来所下发过的地市");
			}else{
				Ty(zdryid,orgListcode,orgtext,zrqbmdm);
			}
	}
}
if(redio=="1"){
	if(orgLevel=="10"){
		Jj(zdryid,fxjbmdm);
	}
	if(orgLevel=="21"){
		Jj(zdryid,pcsbmdm);
	}
	if(orgLevel=="32"){
		Jj(zdryid,zrqbmdm);
	}
}	
}
function Ty(zdryid,orgListcode,orgtext,xjbmdm){
	var params = {zdryid:zdryid,orgcode:orgListcode,orgcodetext:orgtext,xjbmdm:xjbmdm};
	var fajax =new FrameTools.Ajax(contextPath+"/zdryQbzdryxxbUp/agdeliver",closeWindowdeverd);
	fajax.send(params);
}

//拒绝申请变更
function Jj(zdryid,zrqbmdm) {
	var doUpdateUrl = contextPath + '/zdryQbzdryxxbUp/jjbgsq';
	var datagrid_ID = 'dg';
	var sp_czyj =$("#sp_czyj").val();
    var data = {
        "zdryid":zdryid,
		"czyj":sp_czyj,
		"czbmdm":zrqbmdm
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
var orgtext = $('#orgList').combobox('getText');
var xf_czyj = $("#xf_czyj").val();
if ("undefined" == typeof orgtext || orgtext == null || orgtext=="") {
	alert("请选择所要下发的单位！");
}else if(xf_czyj =="" || xf_czyj == null){
	alert("操作意见不能为空！");
}
else{
var params = {zdryid:zdryid,xfczyj:xf_czyj,orgcode:orgListcode,orgcodetext:orgtext};
var fajax =new FrameTools.Ajax(contextPath+"/zdryQbzdryxxb/deliver",closeWindowdeverd);
fajax.send(params);
}	
}
//查看
function doView(linkObject, index){
	   var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		insertZdry(rowData);
		initopreation(rowData.zdryid);
		var Str="";
		Str = Str+"	<table border='0' cellpadding='0' cellspacing='10' width='100%' height='100%' align='center'>";
		Str = Str+" <tr class='dialogTr'>";
		Str = Str+"	<td width='100%' align='center'>"
		Str = Str+"	<a class='easyui-linkbutton' href='javascript:void(0)'  onclick=\"closeWindowdeverd();\">关闭</a>" 
		Str = Str+"	</td>";
		Str = Str+"	</tr>";
		Str = Str+"	</table>";
		$("#operation").html(Str);
		$.parser.parse();
		$("#deliverd").show();
		$("#deliverd").window("open"); 
		$("#deliverd").panel({
			title:"情报详情"
			});
	   
}
//民警重点人员情报接收
function accept(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var zdryid = rowData.zdryid;
	var shjh = rowData.sfzh;
	var zdrylb = rowData.zdryxl;
	var params = {zdryid:zdryid,shjh:shjh,zdlylb:zdrylb};
	var fajax =new FrameTools.Ajax(contextPath+"/zdryQbzdryxxb/accept",accept_back);
	fajax.send(params);
	
}
function accept_back(json){
	if(json == "0"){
		jQuery.messager.alert('提示:','接收成功！!','info');
		$('#dg').datagrid('reload');
	} else if(json == "1"){
		jQuery.messager.alert('提示:','接收失败, 该重点人员信息已被接收！!','error');
	}
}

function doAdd(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var sfzh = rowData.sfzh;
	var csdm = "111";
//	menu_open('实有人口新增','/syrkGl/add?cyzjdm='+csdm+'&zjhm='+sfzh+'&mainTabID='+getMainTabID()+'&invokeJSMethod=SyrkGl.queryButton');
	menu_open('实有人口新增','/syrkGl/add?mainTabID='+getMainTabID()+'&invokeJSMethod=SyrkGl.queryButton');
	
}