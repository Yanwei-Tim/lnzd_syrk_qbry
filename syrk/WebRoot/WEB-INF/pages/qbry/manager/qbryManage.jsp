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
	.table-toolbar{
		width:100%;
	}
	.table-toolbar .td-title{
		text-align:right;
		padding-top:15px;
	}
	.table-toolbar .td-value{
		text-align:left;
		padding-top:15px;
	}
	#datagridToolbar{
		padding-bottom:20px;
	}
	.td-btns-container{
		padding-left:20%;
	}
	.td-btns{
		padding-top:15px;
	}
	#reset-btn{
		margin-left:25px;
	}
	.td-value input, 
	.td-value input{
		width:160px;
		height:22px;
	}
	</style>
    <script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdryzbManage.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'center',border:false" style="width:538px;padding:20px;">
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
				            <th data-options="field:'zdrylb',width:100,align:'center',halign:'center',sortable:true">操作类别</th>
				            <th data-options="field:'gmsfhm',width:100,align:'center',sortable:true,halign:'center'">操作时间</th>
				            <th data-options="field:'xm',width:70,align:'center',sortable:true,halign:'center'">操作原因</th>
				            <th  data-options="field:'xzd',width:200,align:'center',halign:'center',sortable:true">操作部门</th>
				            <th  data-options="field:'hjd',width:200,align:'center',halign:'center',sortable:true">操作人</th>
				        </tr>
			       </thead>
		       </table>	  
		<div id="datagridToolbar" style="padding:5px;height:auto;">
			<!-- <input id="searchBox" type="text" class="easyui-searchbox" data-options="prompt:'请输入姓名'"/> -->
			<table cellspacing = "0" cellpadding="0" class="table-toolbar">
				<tr>
					<td class="td-title">重点人员大类:</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
					<td class="td-title">重点人员大细类:</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
					<td class="td-title">姓名：</td>
					<td class="td-value"><input type="text" class="easyui-validatebox"/></td>
				</tr>
				<tr>
					<td class="td-title">证件号码:</td>
					<td class="td-value"><input type="text" class="easyui-validatebox"/></td>
					<td class="td-title">性别:</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
					<td class="td-title">国籍：</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
				</tr>
				<tr>
					<td class="td-title">现居住地址:</td>
					<td class="td-value"><input type="text" class="easyui-validatebox"/></td>
					<td class="td-title">户籍地址:</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
					<td class="td-title">责任单位：</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
				</tr>
				<tr>
					<td class="td-title">当前级别:</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
					<td class="td-title">下发状态:</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
					<td class="td-title">纪实时间:</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
				</tr>
				<tr>
					<td class="td-title">入部省库时间-开始:</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
					<td class="td-title">入部省库时间-截止:</td>
					<td class="td-value"><input class="easyui-combobox" data-options="width:160,height:22"/></td>
					<td class="td-btns" colspan="2">
						<div class="td-btns-container">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0)">查询</a>
							<a id="reset-btn" class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="#">重置</a>
						</div>
					</td>
				</tr>
			</table>
			<!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="SyrkGl.detailSearch()">精确查询</a>
			<a id="dzaddid" class="easyui-linkbutton"   onclick="SyrkGl.syrkAdd();">新增</a> -->
			<input id="searchBox" type="text" class="easyui-searchbox" data-options="prompt:'请输入姓名'"/>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="SyrkGl.detailSearch()">精确查询</a>
			<a id="dzaddid" class="easyui-linkbutton"   onclick="add()">新增</a>
			<a id="dzaddid" class="easyui-linkbutton"   onclick="addSyrk()">新增实有人口</a>
        </div>
	  </div>
	  <!-- 查询条件 -->
	  
        
   </body>
</html>
<script type="text/javascript">
 function add(){
	 location.href="<%=contextPath%>/qbryManager/qbryadd";
	 
 }
 
 function addSyrk(){
	 menu_open('实有人口新增','/syrkGl/add?mainTabID='+getMainTabID()+'&zjhm=210211198906132911');
 }
</script>