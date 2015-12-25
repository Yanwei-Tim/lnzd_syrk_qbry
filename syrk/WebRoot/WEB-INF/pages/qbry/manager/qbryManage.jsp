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
    <title>重点人员管理</title>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
    </script>
    <style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}
	
	</style>
    <script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdryzbManage.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'center',border:false" style="width:538px;">
           <!-- 地址管理列表 -->
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/qbryManager/queryList',
						onLoadSuccess:function(data){ZdryManage.loadPoint(data,'dg');},
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(105),
		        		pageList:[getAutoPageSize(105),
		        		getAutoPageSize(105) * 2],
		        		singleSelect:true,
		        		fitColumns:true,
		        		toolbar:'#datagridToolbar'">
			        <thead>
			          <tr>
				            <th data-options="field:'zdrylb',width:100,align:'center',halign:'center',sortable:true">类型</th>
				            <th data-options="field:'gmsfhm',width:100,align:'center',sortable:true,halign:'center'">身份证号码</th>
				            <th data-options="field:'xm',width:70,align:'center',sortable:true,halign:'center'">姓名</th>
				            <th  data-options="field:'xzd',width:200,align:'center',halign:'center',sortable:true">现居住地址</th>
				            <th  data-options="field:'hjd',width:200,align:'center',halign:'center',sortable:true">户籍地址</th>
				            <th  data-options="field:'bjzdryrksj',width:200,align:'right',halign:'center',sortable:true">入部省库时间</th>
				            <th data-options="field:'process',align:'center',width:100,halign:'center',formatter:ZdryManage.datagridProcessFormater">操作</th>
				        </tr>
			       </thead>
		       </table>	  
		<div id="datagridToolbar" style="padding:5px;height:auto;">
			<input id="searchBox" type="text" class="easyui-searchbox" data-options="prompt:'请输入姓名'"/>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="SyrkGl.detailSearch()">精确查询</a>
			<a id="dzaddid" class="easyui-linkbutton"   onclick="SyrkGl.syrkAdd();">新增</a>
        </div>
	  </div>
	  <!-- 查询条件 -->
	  
        
   </body>
</html>
<script type="text/javascript">

</script>