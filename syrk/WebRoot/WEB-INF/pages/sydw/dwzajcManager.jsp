<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>单位治安管理</title>
	<script type="text/javascript">
	   var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
    </script>
	<script type="text/javascript" src="<%=contextPath%>/js/sydw/sydw.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/sydw/dwzajcManager.js"></script>
  </head>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'west',border:false" style="width:528px;">
         <!-- 单位治安管理 -->
         <table id="dg" class="easyui-datagrid" 
           		data-options="url:'<%=basePath %>sydw/list',
           		selectOnCheck:true,
           		checkOnSelect:true,
           		border:false,
           		sortName:'',
           		sortOrder:'desc',
           		idField:'id',
           		pageSize:getAutoPageSize(120),
           		pageList:[getAutoPageSize(120),
           		getAutoPageSize(120) * 2],
           		onLoadSuccess:function(data){ loadpoints1(data);},
           		onSelect:onSelectRow,
           		singleSelect:true,
           		fitColumns:true,
           		rownumbers:true,
           		toolbar:'#datagridToolbar'">
			    <thead>
			        <tr>
			            <th data-options="field:'dwlbdm',width:70,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_DWLXDM.js',sortable:true">类别</th>
			            <th data-options="field:'dwmc',width:160,align:'left',halign:'center',sortable:true">单位名称</th>
			            <th data-options="field:'dz_dwdzxz',width:200,align:'left',halign:'center',formatter:subjzdz,sortable:true">单位地址</th>
			            <th data-options="field:'process',width:100,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
			        </tr>
			    </thead>
		 </table>
		 <!-- 查询条件 -->
		<div id="datagridToolbar" style="padding:5px;height:auto">
			<table cellspacing="0" cellpadding="0" border="0" >
				<tr class="dialogTr">
					<td class="dialogTd" style="width:410px;" align="right">
						<input type="text" name="condition" id="condition" class="easyui-searchbox" data-options="height:24,prompt:'请输入单位名称、地址信息搜索',searcher:searchMain" style="width:410px;"/>
					</td>
					<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
					<td class="dialogTd">
						<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="detailSearch()">精确查询</a>
					</td>
				</tr>
				<tr class="dialogTr">
				    <td class="dialogTd" colspan="3">
						<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="tree-leaf" onclick="doAllCheck();">所有检查列表</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="tree-leaf" onclick="doAllPunish();">所有处罚列表</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-print" onclick="doJcFormatPrint();">检查模板打印</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
    <!-- 精确查询框 -->
	<div id="win" class="easyui-window" title="实有单位精确查询"
		style="width:370px;height:330px;display:none;"
		data-options="iconCls:'icon-search',collapsible:false,minimizable:false,maximizable:false,modal:true,closed:true">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'left'">
				<form id="queryForm">
					<table border="0" cellpadding="0" cellspacing="10" width="100%"
						height="100%" align="center">
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">单位类型：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
								style="width:150px;"
								data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:210,
									method:'get',editable:true,lines:true" />
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">单位名称：</td>
							<td width="70%" class="dialogTd">
								<input type="text" id="dwmc" name="dwmc" style="width:150px;"
								class="easyui-validatebox"
								data-options="required:false,validType:'maxLength[20]'" /></td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">单位地址：</td>
							<td width="70%" class="dialogTd"><input type="text"
								id="dz_dwdzxz" name="dz_dwdzxz" class="easyui-validatebox"
								data-options="required:false,validType:'maxLength[30]'"
								style="width:150px;" /></td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">经营范围(主营)：</td>
							<td width="70%" class="dialogTd"><input type="text"
								id="jyfwzy" name="jyfwzy" style="width:150px;"
								class="easyui-validatebox"
								data-options="required:false,validType:'maxLength[30]'" /></td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">经营性质：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-combobox" type="text" id="jyxzdm" name="jyxzdm"
								style="width:150px;"
								data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">单位地址状态：</td>
							<td width="70%" class="dialogTd"><input type='checkbox'
								id='ybzdz' />有标准地址 <input type='checkbox' id='wbzdz' />无标准地址</td>
						</tr>
						<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
							<td width="100%" colspan="2" align="right">
							<a class="easyui-linkbutton" iconCls="icon-ok"onclick="queryButton();">确定</a> 
							<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a> 
							<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<!-- 检查模板打印 -->
	<div id="print" class="easyui-window" title="检查模板打印"
		style="width:360px;height:220px;display:none;"
		data-options="collapsible:false,minimizable:false,maximizable:false,modal:true,closed:true">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'left'">
				<form id="queryPrintForm">
					<table border="0" cellpadding="0" cellspacing="5" width="100%" height="100%" align="center">
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right">单位类型：</td>
							<td width="80%" class="dialogTd" align="left">
								<input class="easyui-combotree" type="text" id="dwlbdm_p" name="dwlbdm_p"
									style="width:250px;" data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:190,
									method:'get',editable:true,lines:true,required:true,tipPosition:'left'"/>
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="20%" class="dialogTd" align="right" >检查模板：</td>
							<td width="80%" class="dialogTd">
								<span style="display: none;"></span>
								<input type="radio" name="ywlbdm" id="ywlbdm" checked value="04" openurl="dwjcxxb/add"/>治安/内保 
								<input type="radio" name="ywlbdm" id="ywlbdm" value="11" openurl="dwjcxxb/addXf"/>三级消防单位
								<input type="radio" name="ywlbdm" id="ywlbdm" value="12" openurl="dwjcxxb/add"/>环保单位 
								<input type="radio" name="ywlbdm" id="ywlbdm" value="13" openurl="dwjcxxb/add"/>保安单位 
								<input type="radio" name="ywlbdm" id="ywlbdm" value="14" openurl="dwjcxxb/addJf"/>技防单位
							</td>
						</tr>
						<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
							<td width="100%" colspan="2" align="center">
								<a class="easyui-linkbutton" iconCls="icon-print" onclick="queryPrint()">打印</a>
								<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closePrint();">关闭</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div data-options="region:'center',border:false">
      <div id="mapDiv"></div>
      <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
   </div>
</body>
</html>