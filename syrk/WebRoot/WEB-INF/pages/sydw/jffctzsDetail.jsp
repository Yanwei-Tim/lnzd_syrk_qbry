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
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/sydw/sydwWord.css"><link/>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true" >
		<form action="" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center'" align="center" style="padding: 50px">
			<div style="width:694px;height:978px; border:1px solid #000000;padding: 20px">
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">复查意见书<br>&nbsp;</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							<span style="font-size: 18px;font: bolder;">${entity.wh}</span>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							${entity.dwmc}：
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						　　根据  ${entity.jctzswh} 责令通知书，我局（分局）于
								<input type="text" name="fcrq" value="${entity.fcrq}" class="easyui-validatebox" style="line-height: 20px;text-align:center;border-top: 0px;border-left: 0px;border-right: 0px;width: 100px;border-color: #333333;"
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>日派员对你单位整改情况进行了复查。复查意见如下：
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="height: 400px;padding-left: 50ps;padding-right: 50px">
						${entity.fcyj}
						</td>
					</tr>
					<tr class="dialogTr" style="padding-top: 300px;">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;（对逾期未改的违法行为，将依法予以处罚。你单位应当继续整改，并确保安全，防止发生事故。）
						</td>
					</tr>
					<tr class="dialogTr" align="right" >
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
	$(function(){
		if('${printAble}' == null || '${printAble}' == ''){
			$('#printButton').hide();
		}
	});
	//打印
	$('#printButton').click(function(){
		window.print();
	});
</script>