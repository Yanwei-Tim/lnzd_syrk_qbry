<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.config.SystemConfig"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>一支队数据统计</title>
  </head>
  <body class="easyui-layout" style="overflow: hidden;height:100%;">
      <div data-options="region:'center',split:true,title:'',border:true" style="height:auto">
			<iframe id="iframe" src="" width="100%" height="100%" frameborder="0"></iframe>
    </div>
	<script type="text/javascript">
	$(document).ready(function(){
		queryButton();
	    $("#iframe").on("load",function(){
			$(document.body).unmask(); 
		});
	});
	function queryButton(){
		var url ="<%=contextPath%>/ReportEmitter?rpt=YZD_report.brt&params=";
		iframe.window.location.href=url;
	}
	
	function mask(){
		$(document.body).mask("正在加载，很快就好，请稍等...");
	}

	</script>
  </body>
</html>