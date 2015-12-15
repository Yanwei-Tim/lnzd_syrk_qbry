<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
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
    <title>盘查车辆列表</title>
    <%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
	<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
    <script type="text/javascript">
    	var userOrgCode = "<%=userOrgCode%>";
    	var bjzbz = "<%=bjzbz%>";
    	var orglevel = "<%=userInfo.getUserOrgLevel()%>";
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/xlpc/pcclList.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'west',border:false" style="width:618px;">
        <!-- 巡逻盘查列表 -->
        <table id="dg" class="easyui-datagrid"
           	data-options="url:'<%=contextPath%>/xlpc/queryPcclList',
           		onLoadSuccess:function(data){PcclList.loadPoint(data,'dg');},
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
				toolbar:'#datagridToolbar',
				onClickRow:PcclList.onClickRow">
		    <thead>
		        <tr>
		            <th data-options="field:'fssj',width:110,align:'center',halign:'center'">盘查时间</th>
			        <th data-options="field:'syrxm',width:80,align:'center',halign:'center'">所有人姓名</th>
			        <th data-options="field:'syrsfzh',width:120,align:'center',halign:'center'">所有人身份证号</th>
			        <th data-options="field:'cphm',width:90,align:'center',halign:'center'">车牌号码</th>
			        <th data-options="field:'clpp',width:80,align:'center',halign:'center',hidden:true">车辆品牌</th>
			        <th data-options="field:'pcyy',width:90,align:'center',halign:'center'">盘查原因</th>
		       </tr>
		    </thead>
		</table>
		<!-- 查询条件 -->
        <div id="datagridToolbar" style="padding:5px;height:auto;">
			<form id="queryForm">
			<table cellspacing="0" cellpadding="0" border="0" id="dmTable">
				<tbody>
				     <tr class="dialogTr">
						<td class="dialogTd" style="width:90px" align="right">所有人姓名：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="syrxm" id="syrxm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" style="width:140px" align="right">所有人身份证号：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="syrsfzh" id="syrsfzh" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td class="dialogTd" style="width:90px" align="right">车牌号码：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="cphm" id="cphm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" style="width:140px" align="right">盘查原因：</td>
						<td class="dialogTd" style="width:140px" align="right">
						    <input type="text" name="pcyy" id="pcyy" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:140px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd" align="right">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="PcclList.queryButton()">查询</a>
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