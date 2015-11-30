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
<title>技防检查通知书</title>
<style>
	td{
	  font-size:13px;
	}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>jfjfjctz/saveJfjfjctzs" id="dataForm" name="dataForm" method="post">
			<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
			<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
			<input type="hidden" name="zzjgid" id="zzjgid" value="${entity.zzjgid}" />
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<input type="hidden" name="wh" id="wh" value="${entity.wh}" />
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;"><input type="text" name="zzjgmc" value="${entity.zzjgmc}" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 120px;border-color: #333333;"/>公安（分）局</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">公共安全技术防范（系统）检查通知书</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							<span style="font-size: 18px;font: bolder;">${entity.wh }</span>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<input type="text" id="dwmc" name="dwmc" value="${entity.dwmc}"  class="easyui-validatebox"  style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;"/>：
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　根据《辽宁省公共安全技术防范条例》，第&nbsp;&nbsp;条之规定，我局（分局）于
								<input type="text"  id="jcrq" name="jcrq" value="${entity.jcrq}" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>对你（单位）进行检查。
							<br/>检查内容如下：
							<br/>1. 公共安全技术防范系统工作落实情况
							<br/>2. 公共安全技术防范系统防范效能
							<br/>3. 公共安全技术防范系统操作人员使用熟练度
							<br/>4. 其他：
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<textarea  id="qt"  name="qt" style="width: 815px;height: 60px;" class="easyui-validatebox">${entity.qt}</textarea>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="line-height: 2em;">
						　　请你单位派员协助检查。
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
			var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+'${entity.jcid}'+"&type=jfjfjctzs";
			window.open(editUrl,"详情","height=1054,width=724,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		});
	}
	function beforeSubmit() {
		
	}
	
	function afterSubmit(arr) {
		executeTabPageMethod(mainTabID, "queryButton()");
		if (arr["saveID"]) {
			var editUrl = basePath+'jfjfjctz/addJfjfjctzscg?tzsid='+arr["saveID"]+"&mainTabID="+mainTabID;
			window.top.openWindowWithSave(false, null, window, null,
			{title: '单位检查信息',url: editUrl,width: 880,inline:true,height:500}, 
		   		null, null,null
		   	);
		}
	}
</script>