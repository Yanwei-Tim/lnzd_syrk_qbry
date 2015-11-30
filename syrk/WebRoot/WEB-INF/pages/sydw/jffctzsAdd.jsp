<!--  
	@Author: [xu_haibo@founder.com]
	@CreateDate:   [2015-6-29 上午8:51:54]
-->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技防复查通知书</title>
<style>
	td{
	  font-size:13px;
	}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>jfjfjctz/saveJffctzs" id="dataForm" name="dataForm" method="post">
			<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
			<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<input type="hidden" name="wh" id="wh" value="${entity.wh}" />
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">复查意见书</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							<span style="font-size: 18px;font: bolder;">${entity.wh}</span>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<input type="text" id="dwmc" name="dwmc" value="${entity.dwmc}"  class="easyui-validatebox"  style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;"/>：
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						　　根据  ${entity.jctzswh} 责令通知书，我局（分局）于
								<input type="text" name="fcrq" value="${entity.fcrq}" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>对你（单位）进行了复查。复查意见如下：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="fcyj" style="width: 815px;height: 60px;" class="easyui-validatebox">${entity.fcyj}</textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;（对逾期未改的违法行为，将依法予以处罚。你单位应当继续整改，并确保安全，防止发生事故。）
						</td>
					</tr>
					<tr class="dialogTr" align="right">
						<td>
						　　 （公安机关印章）
						</td>
					</tr>
					<tr class="dialogTr" align="right">
						<td>
						　　<input type="text" name="hgrq" value="${entity.hgrq}" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						此联交被检查单位
						</td>
					</tr>
					<tr class="dialogTr" align="center">
						<td>
							<a id="printButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">预览</span>
									<span class="l-btn-icon icon-print"> </span>
								</span>
							</a>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>
<script type="text/javascript">
	var mainTabID = "${mainTabID}";
	function doInit(paramArray) {
		//打印
		$('#printButton').click(function(){
			var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+'${entity.jcid}'+"&type=jffctzs";
			window.open(editUrl,"详情","height=1054,width=724,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		});
	}
	function beforeSubmit() {
		
	}
	
	function afterSubmit(arr) {
		executeTabPageMethod(mainTabID, "queryButton()");
		if (arr["saveID"]) {
			var editUrl = basePath+'jfjfjctz/addJffctzscg?jcid='+$("#jcid").val()+"&mainTabID="+mainTabID;
			window.top.openWindowWithSave(false, null, window, null,
			{title: '复查意见书存根',url: editUrl,width: 880,inline:true,height:500}, 
		   		null, null,null
		   	);
		}
	}
</script>