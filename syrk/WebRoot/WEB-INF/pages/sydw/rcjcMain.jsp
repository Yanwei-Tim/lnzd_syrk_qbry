<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=contextPath%>/js/sydw/rcjcMain.js"></script>
<title>日常检查管理</title>
</head>
<body class="easyui-layout" data-options="fit:true">  
    <div data-options="region:'center',border:false">
    	<div class="easyui-layout" data-options="fit:true,border:false">   
            <div data-options="region:'center',split:true,title:'日常检查管理',border:true" style="height:auto">
            	<input type="hidden" id="mode" value="select">
            	<table id="dg" class="easyui-datagrid" data-options="url: contextPath +'/dwjcxxb/queryList',
            		toolbar:'#datagridToolbar',queryParams:getInitQuery(),
            		singleSelect:true,selectOnCheck:true,
            		checkOnSelect:true,border:false,
            		sortName:'a.xt_cjsj',sortOrder:'desc',
            		idField:'id',pageSize:getAutoPageSize(),
            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
				    <thead>
				        <tr>
				        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
				        	<th data-options="field:'jcsj',width:25,align:'center',sortable:true,halign:'center'">检查时间</th>
				        	<th data-options="field:'jcry',width:15,align:'center',sortable:true,halign:'center'">检查人</th>
				        	<th data-options="field:'jcdw',width:30,align:'left',sortable:true,halign:'center'">检查单位</th>
				        	<th data-options="field:'dwmc',width:40,align:'left',sortable:true,halign:'center'">单位名称</th>
				        	<th data-options="field:'jcjg',width:40,align:'left',sortable:true,halign:'center'">检查结果</th>
				        	<th data-options="field:'zghcfyj',width:40,align:'left',sortable:true,halign:'center'">整改或处罚意见</th>
				        	<th data-options="field:'zt',width:30,align:'left',sortable:true,align:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_DWZAJCZTDM.js'">状态</th>
				            <th data-options="field:'process',align:'center',align:'center',formatter:processFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;width:100%" >
					<!-- 表格工具条按钮 -->
					<form id="queryForm">
						<table cellspacing="5" cellpadding="0" border="0" width="100%">
							<tbody>
								<tr id="tr1">
									<td class="toolbarTd" style="width:10%;white-space: nowrap;" align="right">单位名称：</td>
									<td class="toolbarTd" style="width:40%;">
										<input type="text" name="dwmc" id ="dwmc" class="easyui-validatebox" data-options="required:false,tipPosition:'right'" maxlength="50"
										style="width:305px;"/>
									</td>
									<td class="toolbarTd" style="width:10%;white-space: nowrap;" align="right"> 单位类型：</td>
									<td class="toolbarTd" style="width:40%;">
										<input class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
										style="width:222px;" data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:210,
										method:'get',editable:true,lines:true"/>
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:10%;white-space: nowrap;" align="right">检查状态：</td>
									<td class="toolbarTd" style="width:40%;">
										<input type="radio" name="checkStatus" value="unCheck" checked="checked"/>未检查
										<input type="radio" name="checkStatus" value="checked"/>已检查
									</td>
									<td class="toolbarTd" style="width:10%;white-space: nowrap;" align="right">管理部门：</td>
									<td class="toolbarTd" style="width:40%;">
										<input class='easyui-combobox' type='text' id='ywlbdm' name='ywlbdm' style="width:222px;" 
											data-options="valueField:'id',textField:'text',selectOnNavigation:false,required:false"/>
									</td>
								</tr>
								<tr>
									<td class="toolbarTd" style="width:10%;white-space: nowrap;" align="right">检查时间：</td>
									<td class="toolbarTd" style="width:40%;">
										<input type="text" name="jcsj" id="jcsj" class="easyui-validatebox " style="width:140px;"
										data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'jcsjz\') }'})" />
										至
										<input type="text" name="jcsjz" id="jcsjz" class="easyui-validatebox " style="width:140px;"
										data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
										onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'jcsj\') }'})" />
									</td>
									<td class="toolbarTd" style="width:10%;white-space: nowrap;"></td>
									<td class="toolbarTd" style="width:40%;">
										<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" >查询</a>
										<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();" >重置</a>
										<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="addRcjc();">新增</a>
									</td>
								</tr>
								
							</tbody>
						</table>
					</form>
				</div>
			</div>
        </div>
    </div>   
</body>
<script type="text/javascript">

function getInitQuery(){
	var ywlbdmVal = '${ywlbdm}';
	if(ywlbdmVal == null || ywlbdmVal == ''){
		ywlbdmVal = '04';
	}
	return {dwid:'${dwid}',ywlbdm:ywlbdmVal,status:'unCheck'};
}

function processFormater(val, row, index) { // 自定义操作生成
	var  zghtml = "";
	if(row.ywlbdm == "14"){
		zghtml = processFormaterJf(val, row, index);
	}else{
		zghtml = processFormaterNormal(val, row, index);
	}
	
	 return	zghtml;
}

function processFormaterJf(val, row, index) {
	var  zghtml = "";
	
	if(row.zt=="0"){
		//未下发通知
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.createJfjctzs('+index+')">下发通知</a>&nbsp;';
	}else if(row.zt=="1"){
		//已下发通知
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.createJfjctzs('+index+')">下发通知</a>&nbsp;';
	}else if(row.zt=="2"){
		//开展检查
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.createJfdwjcjl('+index+')">检查</a>&nbsp;';
	}else if(row.zt=="3"){
		//检查合格
		//zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.createJfjctzs('+index+')">查看记录</a>&nbsp;';
	}else if(row.zt=="4"){
		//复查未录入记录
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.createJfjctzs('+index+')">新增记录</a>&nbsp;';
	}else if(row.zt=="5"){
		//复查合格
		//zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.createJfjctzs('+index+')">查看记录</a>&nbsp;';
	}else if(row.zt=="99"){
		//开展检查
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.createJfdwjcjl('+index+')">检查</a>&nbsp;';
	}else if(row.zt=="80"){
		//责令整改通知书
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.createJfzltzs('+index+')">整改通知</a>&nbsp;';
	}else if(row.zt=="40"){
		//复查
		zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.createJffctzs('+index+')">复查通知</a>&nbsp;';
	}else if(row.zt=="110"){
	}else if(row.zt=="120"){
	}else{
	}
	
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="Workflow.showJfWorkflow('+index+')">流程</a>&nbsp;'+
	zghtml;
}

function processFormaterNormal(val, row, index) {
	var  zghtml = '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doView('+index+')">查看</a>&nbsp;';
	if(row.zt=="10"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">整改</a>&nbsp;';
	}else if(row.zt=="20"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">整改</a>&nbsp;';
	}else if(row.zt=="30"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">整改</a>&nbsp;';
	}else if(row.zt=="50"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="60"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="70"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="80"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">整改</a>&nbsp;';
	}else if(row.zt=="90"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="100"&&row.ywlbdm!=14){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">打印</a>&nbsp;';
	}else if(row.zt=="100"&&row.ywlbdm==14){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else if(row.zt=="110"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doZg('+index+')">复查</a>&nbsp;';
	}else if(row.zt=="120"){
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doPrint('+index+');">打印</a>&nbsp;';
	}else{
		zghtml += '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit('+index+')">编辑</a>&nbsp;' +
				 '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="cancelBubble();" style="color:gray;">整改</a>&nbsp;';
	}
	return zghtml;
}

/*
 * 修改日常检查
 * index 行索引 
 */
function doEdit(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = basePath+"dwjcxxb/add?id="+rowData.id+"&mainTabID="+getMainTabID();
	if(rowData.ywlbdm=="11"){
		editUrl = basePath+"dwjcxxb/addXf?id="+rowData.id+"&mainTabID="+getMainTabID();
	}else if(rowData.ywlbdm=="14"){
		editUrl = basePath+"dwjcxxb/addJf?id="+rowData.id+"&mainTabID="+getMainTabID();
	}else{
		editUrl = basePath+"dwjcxxb/add?id="+rowData.id+"&mainTabID="+getMainTabID();
	}
	window.top.openWindowWithSave(false, null, window, 
   		{dwmc:rowData.dwmc,dwlbdm:rowData.dwlbdm,ywlbdm:rowData.ywlbdm}, 
   		{
   		title: '单位检查信息',
   		url: editUrl,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, null,null
   	);
}

/*
 * 整改
 * index 行索引 
 */
function doZg(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var openFlag = false;
	var editUrl = contextPath + "/forward/sydw|zlxqzgxxbAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
	if(rowData.zt=="10"){
		editUrl = contextPath + "/forward/sydw|zlxqzgxxbAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}else if(rowData.zt=="20"){
		editUrl = contextPath + "/forward/sydw|zdhzyhzgAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}else if(rowData.zt=="30"){
		editUrl = contextPath + "/forward/sydw|lscfzgAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}else if(rowData.zt=="80"){
		editUrl = contextPath + "/forward/sydw|jfzlxqzgxxbAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}else if(rowData.zt=="110"){
		editUrl = contextPath + "/forward/sydw|jffcyjsAdd?jcid="+rowData.id+"&mainTabID="+getMainTabID();
		openFlag = true;
	}
	if(openFlag){
		window.top.openWindowWithSave(false, null, window, 
	   		{jcid:rowData.id,dwid:rowData.dwid,dwmc:rowData.dwmc}, 
	   		{
	   		title: '录入整改通知书',
	   		url: editUrl,
	   		width: 880,
	   		inline:true,
	   		height:500
	   		}, 
	   		null, null,null
	   	);
   	}
}

function doPrint(index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var openFlag = false;
	var editUrl = contextPath + "/dwjczg/queryZlzgtzs?jcid="+rowData.id;
	if(rowData.zt=="50"){
		editUrl = contextPath + "/dwjczg/queryZlzgtzs?jcid="+rowData.id;
		openFlag = true;
	}else if(rowData.zt=="60"){
		editUrl = contextPath + "/dwjczg/queryZdhzyhzgtzs?jcid="+rowData.id;
		openFlag = true;
	}else if(rowData.zt=="70"){
		editUrl = contextPath + "/dwjczg/queryLscftzs?jcid="+rowData.id;
		openFlag = true;
	}else if(rowData.zt=="90"){
		editUrl = contextPath + "/jfjczg/queryJfzlzgtzs?jcid="+rowData.id;
		openFlag = true;
	}else if(rowData.zt=="120"){
		editUrl = contextPath + "/jfjczg/queryJFfcyjs?jcid="+rowData.id;
		openFlag = true;
		alert(rowData.zt);
		alert(editUrl);
	}
	if(openFlag){
		window.open(editUrl,"详情","height=1054,width=1024,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
   	}
}

/*
 * 查看日常检查
 * index 行索引 
 */
function doView(index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = basePath+"dwjcxxb/add?id="+rowData.id;
	if(rowData.ywlbdm=="11"){
		editUrl = basePath+"dwjcxxb/addXf?id="+rowData.id;
	}else if(rowData.ywlbdm=="14"){
		editUrl = basePath+"dwjcxxb/addJf?id="+rowData.id;
	}
	window.top.openWindowNoSave(false, null, window, 
   		{dwmc:rowData.dwmc,dwlbdm:rowData.dwlbdm,ywlbdm:rowData.ywlbdm,mode:"view"}, 
   		{
   		title: '单位检查信息',
   		url: editUrl,
   		width: 880,
   		inline:true,
   		height:500
   		}, 
   		null, null,null
   	);
}

function addRcjc() {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var editUrl = basePath+"dwjcxxb/selCheckTemp?dwid=${dwid}&dwlbdm=${dwlbdm}"+"&mainTabID="+getMainTabID();
	openWindowWithSave(false, null, window, 
   		{mode:$("#mode").val(),dwmc:"${dwmc}",dwlbdm:"${dwlbdm}"}, 
   		{
   		title: '单位检查信息',
   		url: editUrl,
   		width: 880,
   		height:500
   		}, 
   		null, null,null
   	);
}
//查询按钮
function queryButton(){
	var dwlbdm = $("#dwlbdm").combotree("getValue");
	var dwmc = $("#dwmc").val();
	var jcsj = $("#jcsj").val();
	var jcsjz = $("#jcsjz").val();
	var ywlbdm =  $("#ywlbdm").combobox("getValue");
	//设置后续数据状态
	var status = $("input[name=checkStatus]:checked ").val();
	$('#dg').datagrid('load',{'dwlbdm':dwlbdm,'dwmc':dwmc,'jcsj':jcsj,'jcsjz':jcsjz,'ywlbdm':ywlbdm,'status':status});
}

function clearCase(){
	  var dwmc="${dwmc}";
	  if(dwmc==""||dwmc==null){
	  	 $("#dwlbdm").combotree("setValue","");
	 	 $("#dwmc").val("");
	  }
	  if('${ywlbdm}' == null || '${ywlbdm}' == '' || typeof('${ywlbdm}') == 'undefined'){
		  $("#ywlbdm").combobox("setValue",'');
	  }
	  $("#jcsj").val("");
	  $("#jcsjz").val("");
};

$(function(){
	
	var dwmc="${dwmc}";
	var dwlbdm="${dwlbdm}";
	if(dwmc!=""&&dwmc!=null){
		$("#dwmc").val(decodeURI(dwmc));
		$("#dwlbdm").combotree("setValue",dwlbdm);
		$("#tr1").find('input[type="text"]').each(function(i,o){
			$(o).attr('readonly','readonly');
			$(o).addClass('inputReadonly');
			$(o).next(".combo").addClass("inputReadonly");
		});
		$("#mode").val("");
	}
	
	initYwlbdmCombo();
});

function initYwlbdmCombo(){
	$("#ywlbdm").combobox({
		onChange:function (i,o){
			queryButton();
		}
	});
	$("#ywlbdm").combobox("loadData"
		,[{id:"04",text:"治安/内保"}
		,{id:"11",text:"三级消防单位"}
		,{id:"12",text:"环保单位"}
		,{id:"13",text:"保安单位"}
		,{id:"14",text:"技防单位"}]);
	if('${ywlbdm}' == null || '${ywlbdm}' == ''){
		$("#ywlbdm").combobox("setValue","04");
		$("#ywlbdm").combobox("setText","治安/内保");
	}else{
		if('${ywlbdm}' == '14'){
			$("#ywlbdm").combobox("setValue",'${ywlbdm}');
			$("#ywlbdm").combobox("setText","技防单位");
		}else if('${ywlbdm}' == '11'){
			$("#ywlbdm").combobox("setValue",'${ywlbdm}');
			$("#ywlbdm").combobox("setText","三级消防单位");
		}else if('${ywlbdm}' == '12'){
			$("#ywlbdm").combobox("setValue",'${ywlbdm}');
			$("#ywlbdm").combobox("setText","环保单位");
		}else if('${ywlbdm}' == '13'){
			$("#ywlbdm").combobox("setValue",'${ywlbdm}');
			$("#ywlbdm").combobox("setText","保安单位");
		}else{
			$("#ywlbdm").combobox("setValue",'${ywlbdm}');
			$("#ywlbdm").combobox("setText","治安/内保");
		}
		
	}
	
}
</script>  

</html>
