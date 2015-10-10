<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   	<title>实有单位核实</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=contextPath%>/js/sydw/sydwHs.js"></script>
</head>
<body class="easyui-layout" data-options="fit:true">
   	<div data-options="region:'center',border:false">
  	<div class="easyui-layout" data-options="fit:true,border:false">   
	    <div data-options="region:'center',split:true,title:'实有单位核实',border:true" style="height:auto">
			<table id="dg" class="easyui-datagrid" 
				data-options="
				url:'',
				toolbar:'#datagridToolbar',
				rownumbers: true,
				singleSelect:true,
				selectOnCheck:false,
				checkOnSelect:false,
				border:false,
			    idField:'id',
			    pageSize:getAutoPageSize(),
			    pageList:[getAutoPageSize(),
			    getAutoPageSize() * 2]">
			    <thead>
			        <tr>
			       	 	<%-- <th data-options="checkbox:true,align:'center',halign:'center'"></th>--%>
			            <th data-options="field:'dwlbdm',	width:10,	align:'left' ,sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_DWLXDM.js'">类别</th>
			            <th data-options="field:'dwmc', 	width:10,	align:'left',	halign:'center',sortable:true">单位名称</th>
			            <th data-options="field:'jjlxdm',	width:10,	align:'left' ,sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_JYXZDM.js'">经营性质</th>
			            <th data-options="field:'dz_dwdzxz', width:20,	align:'left',	halign:'center',sortable:true	">单位详址</th>
			            <th data-options="field:'hs_status',width:30,align:'center',sortable:true,halign:'center',formatter:isCheck">核实状态</th>
			            <th data-options="field:'process',	 width:10,align:'center',	halign:'center',	formatter:datagridProcessFormater">操作</th>
			            <th data-options="field:'xt_zxbz',width:50,align:'center',halign:'center',hidden:true">xt_zxbz</th>
			        </tr>
			    </thead>
			</table>
			<div id="datagridToolbar" style="padding:5px;height:auto;">
				<!-- 表格工具条按钮 -->
				<form id="queryForm">
					<table cellspacing="0" cellpadding="0" border="0">
						<tbody>
							<tr>
								<td class="toolbarTd">单位类型：
									<input class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
									    data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:210,
										method:'get',editable:true,lines:true"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" align="right">单位名称 ：
									<input type="text" name="dwmc" id ="dwmc" class="easyui-validatebox" 
									data-options="required:false,validType:'maxLength[20]'"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" >单位地址：
									<input type="text" name="dz_dwdzxz" id ="dz_dwdzxz" class="easyui-validatebox" 
									data-options="required:false,validType:'maxLength[30]'"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">核实状态：
									<input class="easyui-combobox" type="text" id="hs_status" name="hs_status"  
										data-options="url: contextPath + '/common/dict/D_JWRY_BZHSZT.js',valueField:'id',textField:'text'"/>
								</td>
							</tr>
							<tr>
								<td class="toolbarTd">经营性质：
									<input class="easyui-combobox" type="text" id="jyxzdm" name="jyxzdm" 
										data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd" >经营范围(主营)：
									<input class="easyui-validatebox" type="text" id="jyfwzy" name="jyfwzy" 
									data-options="required:false,validType:'maxLength[30]'"/>
								</td>
								
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">注销状态：
						    	    <input class="easyui-combobox" type="text" id="xt_zxbz" name="xt_zxbz" 
										data-options="url: contextPath + '/common/dict/D_RK_ZXBS.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
							    </td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="toolbarTd">
									<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();" style="margin-right: 10px;">查询</a>
									<a class="easyui-linkbutton" iconCls="icon-reload" onclick="clearCase();">重置</a>
									<%-- <a class="easyui-linkbutton" iconCls="icon-add" onclick="batchHs();">批量核实</a>--%>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>

<div id="win" class="easyui-window" title="实有单位核实注销" style="width:700px;height:200px"   
      data-options="iconCls:'icon-save',modal:true,closed:true,collapsible:false,minimizable:false, maximizable:false"> 
      <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
      	<tr>
      		<td align="center"> 
	      		<input type="hidden" id ="id" value="">
	       		<textarea id="xt_zxyy"  onblur="if(value==''){value='请输入注销原因...';}" onfocus="if(value=='请输入注销原因...'){value='';}" title="添加注销原因"
	       			class="easyui-validatebox" style="width: 613px; height:78px;"
					data-options="validType:['maxLength[100]'],invalidMessage:'注销原因不能超过100个汉字，请重新输入！',tipPosition:'left'">请输入注销原因...</textarea>
      		</td>
      	</tr>
      	<tr>
      		<td align="right">
      			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="updateHs();">确定</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
	       	</td>
	   	</tr>
   	</table>
</div> 
</body>
<script type="text/javascript">
//截地址字段
function subjzdz(val, row, index){
	if(val.indexOf("辽宁省大连市")>=0){
		val = val.substring(val.lastIndexOf("市")+1,val.length);
	}
	if(val.indexOf("辽宁省")>=0){
		val = val.substring(val.lastIndexOf("省")+1,val.length);
	}
	//var searchKey = "美丽巷";
	//var regExp = new RegExp(searchKey, "igm");
	//val = val.replace(regExp, "<font color=\"#FF0000\">"+ searchKey +"</font>");
	return val;
}
</script>
</html>
