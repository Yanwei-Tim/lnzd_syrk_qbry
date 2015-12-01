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
	  font-size:15px;
	  word-break : break-all;
	  vertical-align: top;
	}
	.date{
		font-size:15px;
		width: 500px;
		line-height: 20px;
		text-align:left;
		border-top: 0px;
		border-left: 0px;
		border-right: 0px;
		border-color: #333333;
		text-indent:5px;
	}
	.text{
		font-size:15px;
		width: 500px;
		line-height: 20px;
		text-align:left;
		border-top: 0px;
		border-left: 0px;
		border-right: 0px;
		border-color: #333333;
		text-indent:5px;
	}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true" >
		<form action="" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center'" align="center" style="padding: 50px">
			<div style="width:694px;height:978px; border:1px solid #000000;padding: 20px">
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;">${entity.zzjgmc}公安（分）局</span></div>
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
						<td style="padding-left: 50px;padding-right: 50px;height: 400px;">
						　　${entity.qt}
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
				</table>
				</div>
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td  class="noprint" align="center">
							<a id="printButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">文书打印</span>
								<span class="l-btn-icon icon-save"> </span>
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
		$('input').each(function(i,elment){
			$(elment).attr("readonly","readonly");
		});
	}
	function beforeSubmit() {
	}
	function afterSubmit(arr) {
	}
	//打印
	$('#printButton').click(function(){
		window.print();
	});
</script>