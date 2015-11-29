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
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;"><br>公共安全技术防范检查记录<br>&nbsp;<br>&nbsp;</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;监督检查人员：<input class="easyui-validatebox text" type="text" name="jcry" id="jcry"
						data-options="required:true,validType:['maxLength[50]'],tipPosition:'right'"
						style="width:100px" value="${entity.jcry}" />、
						<input class="easyui-validatebox text" type="text" name="cjry" id="cjry"
						data-options="required:true,validType:['maxLength[50]'],tipPosition:'right'"
						style="width:100px" value="${entity.cjry}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;监督检查时间：<input class="easyui-validatebox text" readonly="readonly" type="text" style="width:100px" value="${entity.jcsj}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;被检查单位（场所）名称：<input class="easyui-validatebox text" readonly="readonly" type="text" style="width:300px" value="${entity.dwmc}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;地址：<input class="easyui-validatebox text" readonly="readonly" type="text" style="width:400px" value="${entity.dz_dwdzmlpxz}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;被检查单位法定代表人姓名：<input class="easyui-validatebox text" type="text" name="fddbrxm" id="fddbrxm"
						data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
						style="width:100px" value="${entity.fddbrxm}" />&nbsp;&nbsp;联系电话：<input class="easyui-validatebox text" type="text" name="fddbrlxdh" id="fddbrlxdh"
						data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
						style="width:150px" value="${entity.fddbrlxdh}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;被检查单位分管负责人姓名：<input class="easyui-validatebox text" type="text" name="dwfgfzrxm" id="dwfgfzrxm"
						data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
						style="width:100px" value="${entity.dwfgfzrxm}" />&nbsp;&nbsp;联系电话：<input class="easyui-validatebox text" type="text" name="dwfgfzrlxdh" id="dwfgfzrlxdh"
						data-options="required:false,validType:['maxLength[50]'],tipPosition:'right'"
						style="width:150px" value="${entity.dwfgfzrlxdh}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;检查情况：
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="height:450px;padding-left: 50px;padding-right: 50px;">
						${entity.jcjg}
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;被检查单位（协助检查）人员签名（单位章）：<input class="easyui-validatebox text" type="text" style="width:200px" name="xzjcrxm" value="${entity.xzjcrxm}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;联系电话&nbsp;&nbsp;&nbsp;&nbsp;：<input class="easyui-validatebox text" type="text" style="width:200px" name="xzjcrlxdh" value="${entity.xzjcrlxdh}"  />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;被检查人签名：<input class="easyui-validatebox text" type="text" style="width:200px" name="bjcryxm" value="${entity.bjcryxm}"  />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;联系电话&nbsp;&nbsp;&nbsp;&nbsp;：<input class="easyui-validatebox text" type="text" style="width:200px" name="bjcrylxdh" value="${entity.bjcrylxdh}"  />
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="padding-top: 50px;">
						&nbsp;&nbsp;&nbsp;&nbsp;此记录附卷
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