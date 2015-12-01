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
<title>技防检查通知书存根</title>
<style>
	td{
	  font-size:13px;
	}
	.date{
		width: 600px;
		line-height: 20px;
		text-align:left;
		border-top: 0px;
		border-left: 0px;
		border-right: 0px;
		border-color: #333333;
		text-indent:5px;
	}
	.text{
		width: 600px;
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
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>jfjfjctz/saveJfjfjctzscg" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
				<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
				<input type="hidden" name="tzid" id="tzid" value="${entity.tzid}" />
				<input type="hidden" name="wh" id="wh" value="${entity.wh}" />
				<input type="hidden" name="zzjgid" id="zzjgid" value="${entity.zzjgid}" />
				
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;"><input type="text" name="zzjgmc" value="${entity.zzjgmc}" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 120px;border-color: #333333;"/>公安（分）局</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">公共安全技术防范（系统）检查通知书 <br>（存根）</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							<span style="font-size: 18px;font: bolder;">${entity.wh }</span>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<span style="font-size: 18px;font: bolder;">案由&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="text" id="ay" name="ay"   value="${entity.ay}"  class="easyui-validatebox text"  />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<span style="font-size: 18px;font: bolder;">通知对象</span><input type="text" id="dwmc" name="dwmc"   value="${entity.dwmc}"  class="easyui-validatebox text" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<span style="font-size: 18px;font: bolder;">通知原因</span><input type="text" id="tzyy" name="tzyy"   value="${entity.tzyy}"  class="easyui-validatebox text" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<span style="font-size: 18px;font: bolder;">经办人&nbsp;&nbsp;</span><input type="text" id="jbr" name="jbr"   value="${entity.jbr}"  class="easyui-validatebox text" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<span style="font-size: 18px;font: bolder;">批准人&nbsp;&nbsp;</span><input type="text" id="pzr" name="pzr"   value="${entity.pzr}"  class="easyui-validatebox text"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<span style="font-size: 18px;font: bolder;">批准时间</span><input type="text" name="pzrq" value="${entity.pzrq}" class="easyui-validatebox date" 
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<span style="font-size: 18px;font: bolder;">填发人&nbsp;&nbsp;</span><input type="text" id="tfr" name="tfr"   value="${entity.tfr}"  class="easyui-validatebox text"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　<span style="font-size: 18px;font: bolder;">填发时间</span><input type="text" name="tfrq" value="${entity.tfrq}" class="easyui-validatebox date" 
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
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
			var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+'${entity.jcid}'+"&type=jfjfjctzscg";
			window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		});
	}
	function beforeSubmit() {
	}
	function afterSubmit(arr) {
		executeTabPageMethod(mainTabID, "queryButton()");
	}
</script>