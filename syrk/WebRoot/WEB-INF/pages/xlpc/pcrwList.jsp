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
    <title>盘查任务列表</title>
    <%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
	<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
    <script type="text/javascript">
    	var userOrgCode = "<%=userOrgCode%>";
    	var bjzbz = "<%=bjzbz%>";
    	var orglevel = "<%=userInfo.getUserOrgLevel()%>";
    </script>
    <style type="text/css">
    .divwrap {
		width: 250px;
		margin: 5px auto;
		height: auto;
		overflow: hidden;
		font-size: 15px;
	}
    .text {
		line-height: 23px;
		color:black;
		width: 250px;
		float: left;
		font-size: 12px;
	}
	.oneText {
		font-size: 16px;
		background-color: #007be3;
		text-align: center;
		width: 18px;
		height: 18px;
		float: left;
		color: #fff;
		font-weight: bold;
		line-height: 18px;
	}
	.title_big {
		width: 100%;
		font-size: 14px;
		font-weight:bold;
		color: #333333;
		line-height: 18px;
	}
    </style>
    <script type="text/javascript" src="<%=contextPath%>/js/xlpc/pcrwList.js"></script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'west',border:false" style="width:618px;">
        <!-- 盘查任务列表 -->
        <table id="dg" class="easyui-datagrid"
           	data-options="url:'<%=contextPath%>/xlpc/queryPcrwList',
           		onLoadSuccess:function(data){PcrwList.loadPoint(data,'dg');},
				selectOnCheck:true,
	       		checkOnSelect:true,
	       		rownumbers:true,
	       		border:false,
	       		sortName:'kssj',
	       		sortOrder:'desc',
	       		pageSize:getAutoPageSize(115),
	       		pageList:[getAutoPageSize(115),
	       		getAutoPageSize(115) * 2],
	       		singleSelect:true,
	       		fitColumns:true,
				toolbar:'#datagridToolbar',
				onClickRow:PcrwList.onClickRow">
		    <thead>
		        <tr>
			        <th data-options="field:'kssj',width:100,align:'center',halign:'center'">盘查开始时间</th>
			        <th data-options="field:'xffs',width:70,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_YDJW_PCFS.js'">盘查方式</th>
			        <th data-options="field:'gzdd',width:150,align:'left',halign:'center'">盘查地点</th>
			        <th data-options="field:'jssj',width:100,align:'center',halign:'center'">盘查结束时间</th>
			        <th data-options="field:'gzddms',width:150,align:'center',halign:'center',hidden:true">盘查地点描述</th>
			        <th data-options="field:'xlmc',width:80,align:'center',halign:'center',hidden:true">巡逻路线名称</th>
			        <th data-options="field:'jyxm',width:80,align:'center',halign:'center',hidden:true">带班民警姓名</th>
			        <th data-options="field:'jybh',width:80,align:'center',halign:'center',hidden:true">带班民警警号</th>
			        <th data-options="field:'stmjxm',width:80,align:'center',halign:'center',hidden:true">随同民警姓名</th>
			        <th data-options="field:'stmjbh',width:80,align:'center',halign:'center',hidden:true">随同民警编号</th>
			        <th data-options="field:'xjrs',width:60,align:'center',halign:'center',hidden:true">协警人数</th>
			        <th data-options="field:'djsj',width:120,align:'center',halign:'center',hidden:true">登记时间</th>
		       </tr>
		    </thead>
		</table>
		<!-- 查询条件 -->
        <div id="datagridToolbar" style="padding:5px;height:auto;">
			<form id="queryForm">
			<table cellspacing="0" cellpadding="0" border="0" id="dmTable">
				<tbody>
				     <tr class="dialogTr">
						<td class="dialogTd" style="width:508px" align="right">
							<input type="text" name="gzdd" id="gzdd" class="easyui-searchbox" data-options="height:24,prompt:'请输入盘查地点、巡逻路线搜索',searcher:PcrwList.queryButton" style="width:508px;"/>
						</td>
						<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						<td class="dialogTd">
							<a class="easyui-linkbutton" iconCls="icon-search" onclick="PcrwList.queryButton()">查询</a>
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