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
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;"><input type="text" name="zzjgmc" value="${entity.zzjgmc}" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 120px;border-color: #333333;font-size: 18px;font: bolder;"/>公安（分）局</span></div>
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
						案由&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="ay" name="ay" value="${entity.ay}"  class="easyui-validatebox text"  />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						通知对象<input type="text" id="dwmc" name="dwmc"   value="${entity.dwmc}"  class="easyui-validatebox text" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						通知原因<input type="text" id="tzyy" name="tzyy"   value="${entity.tzyy}"  class="easyui-validatebox text" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						经办人&nbsp;&nbsp;<input type="text" id="jbr" name="jbr"   value="${entity.jbr}"  class="easyui-validatebox text" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						批准人&nbsp;&nbsp;<input type="text" id="pzr" name="pzr"   value="${entity.pzr}"  class="easyui-validatebox text"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						批准时间<input type="text" name="pzrq" value="${entity.pzrq}" class="easyui-validatebox date" 
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						填发人&nbsp;&nbsp;<input type="text" id="tfr" name="tfr"   value="${entity.tfr}"  class="easyui-validatebox text"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						填发时间<input type="text" name="tfrq" value="${entity.tfrq}" class="easyui-validatebox date" 
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						　　&nbsp;
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