<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.utils.DateTimeUtils"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>

<%
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	DateTimeUtils date = new DateTimeUtils();
	String qnby_starttime = formatter.format(date.getQnFirstDayOfMonth());
	String qnby_endtime = formatter.format(date.getQnDefaultDay());
	String sy_starttime = formatter.format(date.getPreviousMonthFirst());
	String sy_endtime = formatter.format(date.getPreviousMonthEnd());
	String by_starttime = formatter.format(date.getFirstDayOfMonth());
	String by_endtime = formatter.format(date.getDefaultDay());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>四支队三级消防数据统计</title>
  </head>
  <body class="easyui-layout" style="overflow: hidden;height:100%;">
      <div data-options="region:'center',split:true,title:'',border:true" style="height:auto">
		<iframe id="iframe" src="" width="100%" height="90%" frameborder="0"></iframe>
      </div>
	<script type="text/javascript">
	$(document).ready(function(){
		queryButton();
	    $("#iframe").on("load",function(){
			$(document.body).unmask(); 
		});
	 });
		var qnz_starttime="<%=qnby_starttime%>";
		var qnz_endtime="<%=qnby_endtime%>";
		var sy_starttime="<%=sy_starttime%>";
		var sy_endtime="<%=sy_endtime%>";
		var by_starttime="<%=by_starttime%>";
		var by_endtime="<%=by_endtime%>";
		function queryButton(){
			mask();
			var url ="<%=contextPath%>/ReportEmitter?rpt=FOURXFZD_report.brt&params=";
			url = url+"qnz_starttime="+qnz_starttime+";qnz_endtime="+qnz_endtime+";sy_starttime="+sy_starttime+";sy_endtime="+sy_endtime+";by_starttime="+by_starttime+";by_endtime="+by_endtime+";"
			iframe.window.location.href=url;
		}
		
		function mask(){
			$(document.body).mask("正在加载，很快就好，请稍等...");
		}
	</script>
  </body>
</html>