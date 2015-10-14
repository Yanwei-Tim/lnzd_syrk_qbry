<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
    }
 %>
<html>
  <head>
    <title>责任区主页</title>
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/main/zrq/main_zrq.css" />
	<script type="text/javascript" src="<%=contextPath%>/js/main/zrq/main_zrq.js" ></script>
	<script type="text/javascript">
		var bjzbz = "<%=bjzbz%>";
		var userOrgCode = "<%=userOrgCode%>";
	</script>
  </head>
  <body>
    <div class="leftDiv">
    	<div class="leftCss">
    		<div id="xqMap"></div>
    	</div>
    	<div class="leftCss">
    	    <div id="xqTj"></div>
    	</div>
   	</div>
    <div class="centerDiv">
    	<div class="centerCss">
           	<!-- <div class="centerTopCss" id="db">
	   		   <div class="titleCss">&nbsp;待办事项</div>
			   <div class="messageCss" id="waitingWorkDiv"></div>
	   		</div>
	   		<div class="centerTopCss1" id="yw">
	   		   <div class="titleCss">&nbsp;业务提醒</div>
			   <div class="messageCss" id="remindDiv"></div>
	   		</div>    		 -->
	   		<table border="0" cellpadding="0" cellspacing="0" style="width: 100%;height: 100%;">
	   		<tr>
	   		<td class="titleCss" style="height: 20px;width:49.5%;">
	   		<span class="titleCssleft">&nbsp;待办事项</span><a href="javascript:void(0);" onclick="queryMsg('工作待办');" title="更多"><span class="titleCssright" title="更多">>></span></a>
	   		</td>
	   		
	   		<td style="width:1px;">
	   		</td>
	   		<td class="titleCss" style="height: 20px;width:49.5%;">
	   		<span class="titleCssleft">&nbsp;业务提醒</span><a href="javascript:void(0);" onclick="queryMsg('消息提醒');" title="更多"><span class="titleCssright" title="更多">>></span></a>
	   		</td>
	   		
	   		</tr>
	   		<tr>
	   		<td style="border: 1px solid rgb(17, 144, 241)">
	   		<div class="messageCsscenter"  id="waitingWorkDiv" >
	   		</div>
	   		</td>
	   		<td>
	   		</td>
	   		<td style="border: 1px solid rgb(17, 144, 241)">
	   		<div class="messageCsscenter"  id="remindDiv"></div>
	   		</td>
	   		</tr>
	   		</table>
    	</div>
    	<div class="centerCss1" >
    		<div class="titleCss" id="ullis">
				<ul id="tab">
					<li class="fli" onclick="MainZrq.ChangeTab(this)">&nbsp;每周基础信息采集</li>
				<!-- 	<li onclick="MainZrq.ChangeTab(this)">重点人员监控</li>
					<li onclick="MainZrq.ChangeTab(this)">治安防范管理</li> -->
				</ul>
			</div>
    		<div class="dgCss">
    			<table id="dg"></table>
    		</div>
    	</div>
   	</div>
    <div class="rightDiv">
   		<div class="rightCss">
   		<table border="0" cellpadding="0" cellspacing="0" style="width: 100%;height: 30%;">
   		<tr>
   		<td class="titleCss" style="height: 20px;">
   		<span class="titleCssleft">&nbsp;接处警</span><a href="javascript:void(0);" onclick="menu_open('动态警情', '/forward/jcj|dtjjMessage');"  title="更多"><span class="titleCssright" title="更多">>></span></a>
   		</td>
   		</tr>
   		<tr>
   		<td >
   		   <div class="messageCss" id="newDiv"></div>
   		
   		</td>
   		</tr>
   		</table>
   		   <!-- <div class="titleCss">&nbsp;接处警<td class="titleBg"><a href="javascript:void(0);" onclick="menu_open('动态警情', '/forward/jcj|dtjjMessage');" title="更多">>></a></td></div> -->
		</div>
   		<div class="rightCss1" id="zrqmenu">
   		</div>
   	</div>
  </body>
</html>