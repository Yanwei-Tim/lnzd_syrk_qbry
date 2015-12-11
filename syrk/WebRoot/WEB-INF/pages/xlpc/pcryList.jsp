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
    <title>盘查人员列表</title>
    <script type="text/javascript">
    	var userOrgCode = "<%=userOrgCode%>";
    	var bjzbz = "<%=bjzbz%>";
    	var orglevel = "<%=userInfo.getUserOrgLevel()%>";
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/xlpc/pcryList.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'west',border:false" style="width:658px;">
        <!-- 巡逻盘查列表 -->
        <table id="dg" class="easyui-datagrid"
           	data-options="url:'<%=contextPath%>/xlpc/queryPcryList',
				selectOnCheck:true,
	       		checkOnSelect:true,
	       		rownumbers:true,
	       		border:false,
	       		sortName:'',
	       		sortOrder:'desc',
	       		pageSize:getAutoPageSize(120),
	       		pageList:[getAutoPageSize(120),
	       		getAutoPageSize(120) * 2],
	       		singleSelect:true,
	       		fitColumns:true,
				toolbar:'#datagridToolbar'">
		    <thead>
		        <tr>
			        <th data-options="field:'fssj',width:130,align:'center',halign:'center'">盘查时间</th>
			        <th data-options="field:'clzt',width:60,align:'center',halign:'center'">处理状态</th>
			        <th data-options="field:'ryxm',width:120,align:'center',halign:'center'">姓名</th>
			        <th data-options="field:'xb',width:60,align:'center',halign:'center',hidden:true">性别</th>
			        <th data-options="field:'sfzh',width:140,align:'center',halign:'center'">身份证号</th>
			        <th data-options="field:'mz',width:60,align:'center',halign:'center',hidden:true">民族</th>
			        <th data-options="field:'csrq',width:120,align:'center',halign:'center',hidden:true">出生日期</th>
			        <th data-options="field:'xjzd',width:160,align:'center',halign:'center',hidden:true">现居住地</th>
			        <th data-options="field:'cjr',width:80,align:'center',halign:'center',hidden:true">采集人</th>
			        <th data-options="field:'pcyy',width:160,align:'center',halign:'center',hidden:true">盘查原因</th>
			        <th data-options="field:'sfzt',width:80,align:'center',halign:'center'">是否在逃</th>
			        <th data-options="field:'sffa',width:80,align:'center',halign:'center'">是否负案</th>
			        <th data-options="field:'sfpcdx',width:80,align:'center',halign:'center',hidden:true">是否盘查对象</th>
		       </tr>
		    </thead>
		</table>
		<!-- 查询条件 -->
        <div id="datagridToolbar" style="padding:5px;height:auto;">
			<form id="queryForm">
			<table cellspacing="0" cellpadding="0" border="0" id="dmTable">
				<tbody>
				     <tr class="dialogTr">
						<td class="dialogTd" style="width:55px" align="right">姓名：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="ryxm" id="ryxm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" style="width:65px" align="right">身份证号：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="sfzh" id="sfzh" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" style="width:65px" align="right">是否在逃：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="sfzt" id="sfzt" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td class="dialogTd" style="width:65px" align="right">是否负案：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="sffa" id="sffa" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" style="width:85px" align="right">是否盘查对象：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="sfpcdx" id="sfpcdx" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" colspan="2" align="center">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="PcryList.queryButton()">查询</a>
						</td>
					</tr>
				</tbody>
			  </table>
			</form>
         </div>
    </div>
    <div data-options="region:'center',border:false">
	    <div id="mapDiv"></div>
	    <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
	</div>
  </body>
</html>