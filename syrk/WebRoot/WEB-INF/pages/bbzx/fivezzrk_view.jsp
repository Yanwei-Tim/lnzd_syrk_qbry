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
	String bj_starttime = formatter.format(date.getBjStartTime());
	String bj_endtime = formatter.format(date.getBjEndTime());
	String sj_starttime = formatter.format(date.getSjStartTime());
	String sj_endtime = formatter.format(date.getSjEndTime());
	String qn_starttime = formatter.format(date.getQnDqJdStartTime());
	String qn_endtime = formatter.format(date.getQnDqJdEndTime());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>五支队暂住人口数据统计</title>
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
			var bj_starttime="<%=bj_starttime%>";
			var bj_endtime="<%=bj_endtime%>";
			var sj_starttime="<%=sj_starttime%>";
			var sj_endtime="<%=sj_endtime%>";
			var qn_starttime="<%=qn_starttime%>";
			var qn_endtime="<%=qn_endtime%>";
			function queryButton(){
				mask();
				var url ="<%=contextPath%>/ReportEmitter?rpt=FZZRK_report.brt&params=";
				url = url+"bj_starttime="+bj_starttime+";bj_endtime="+bj_endtime+";sj_starttime="+sj_starttime+";sj_endtime="+sj_endtime+";qn_starttime="+qn_starttime+";qn_endtime="+qn_endtime+";"
				iframe.window.location.href=url;
			}
			
			function mask(){
				$(document.body).mask("正在加载，很快就好，请稍等...");
			}
	</script>
  </body>
</html>