<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String username = "";
    String userorg = "";
    String orgcode = "";
    if(userInfo!=null){
        username = userInfo.getUserName();
        userorg = userInfo.getUserOrgNameQc();
        orgcode = userInfo.getUserOrgCode();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<%=contextPath%>/css/dbrw.css" rel="stylesheet" type="text/css" />
    <title>实有房屋核实列表</title>
    <script type="text/javascript">
    <!--
       var username = "<%=username%>"; 
       var userorg = "<%=userorg%>";
       var orgcode = "<%=orgcode%>";
    //-->
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/syfw/syfwCheck.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true">
  	 <div data-options="region:'center',split:true, title:'',border:false" style="height:auto">
  			<table id="dg" class="easyui-datagrid" 
            	data-options="url:'<%=contextPath%>/syfw/list?isCheck=check',
	           		toolbar:'#datagridToolbar',
	           		border:false,
	           		rownumbers: true,
	           		sortName:'fz_xm',
	           		sortOrder:'desc',
	           		pageSize:getAutoPageSize(180),
	           		pageList:[getAutoPageSize(180),
	           		getAutoPageSize(180) * 2],
	           		singleSelect:true,
	           		fitColumns:true">
			    <thead>
			        <tr>
			           <th data-options="field:'fwlbdm',width:70,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_FWLBDM.js'">房屋类别</th>
					   <th data-options="field:'fwdz_dzxz',width:200,align:'left',halign:'center',sortable:true,formatter:subjzddzxz">房屋地址</th>
					   <th data-options="field:'fz_xm',width:70,align:'center',halign:'center',sortable:true">房主</th>
					   <th data-options="field:'sfczfw',width:70,align:'center',halign:'center',sortable:true">出租房屋</th>
					   <th data-options="field:'hs_status',width:30,align:'center',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/DZ_BZDZ_HSZT.js'">核实状态</th>
			           <th data-options="field:'true',width:50,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
			        </tr>
			    </thead>
			</table>
  			<div id="datagridToolbar" style="padding:5px;height:20">
	  			<form id ="queryForm">
	   			<table border="0" cellpadding="0" cellspacing="0">
					<tr class="dialogTr">
						<td class="dialogTd" nowrap="nowrap" style="width:85px;" align="right">房主姓名：</td>
						<td class="dialogTd"><input
							class="easyui-validatebox" type="text" id="fz_xm" name="fz_xm"
							style="width:140px;" /></td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>	
						<td class="dialogTd" nowrap="nowrap" style="width:85px;" align="right">房屋类别：</td>
						<td class="dialogTd"><input
							class="easyui-combobox" type="text" id="fwlbdm" name="fwlbdm"
							style="width:140px;"
							data-options="url: contextPath + '/common/dict/D_BZ_FWLBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" nowrap="nowrap" style="width:85px;" align="right">房屋地址：</td>
						<td class="dialogTd"><input type="text"
							name="fwdz_dzxz" id="fwdz_dzxz" class="easyui-validatebox"
							data-options="required:false,validType:'maxLength[50]'"
							style="width:140px;" />
						</td>
					</tr>
					<tr class="dialogTr">
					    <td class="dialogTd" nowrap="nowrap" style="width:85px;" align="right">是否出租房：</td>
						<td class="dialogTd"><input
							class="easyui-combobox" type="text" id="sfczfw" name="sfczfw"
							style="width:140px;"
							data-options="url: contextPath + '/common/dict/D_BZ_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" nowrap="nowrap" style="width:85px;" align="right">核实状态：</td>
						<td class="dialogTd">
							<input class="easyui-combobox" type="text" id="hs_status" name="hs_status" style="width:140px;" 
								data-options="url: contextPath + '/common/dict/DZ_BZDZ_HSZT.js',valueField:'id',textField:'text',
											  onLoadSuccess:function(){$('#hs_status').combobox('setValue','01');}"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td nowrap="nowrap" colspan="2" align="right">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton();">查询</a>
				    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
						</td>
					</tr>
				</table>
	   		</form>
			</div>
		</div>
		<div id="win" class="easyui-window" title="实有房屋核实注销" style="width:700px;height:200px"   
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
		      		<td style="width:85px;" align="right">
		      			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="updateHs();">确定</a>
						<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
			       	</td>
			   	</tr>
		   	</table>
		</div>
</body>
</html>