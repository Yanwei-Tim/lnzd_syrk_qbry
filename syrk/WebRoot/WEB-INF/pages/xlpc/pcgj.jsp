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
    <title>盘查轨迹</title>
    <%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
	<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
	<script type="text/javascript">
    	var bjzbz = "<%=bjzbz%>";
    	var sfzh = "${sfzh}";
    	var ryxm = "${ryxm}";
    	var kssj = "${kssj}";
    	var jssj = "${jssj}";
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/tools/floatWin/floatWin.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/xlpc/pcgj.js"></script>
  </head>
  <body style="overflow: hidden;">
    <div id="mapDiv"></div>
	<div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
  </body>
</html>