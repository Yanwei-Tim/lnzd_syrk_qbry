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
		width: 400px;
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
		<form action="<%=basePath%>jfjfjctz/saveJffctzscg" id="dataForm" name="dataForm" method="post">
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<input type="hidden" name="id" id="pk" value="${entity.id}" />
				<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
				<input type="hidden" name="jcid" id="jcid" value="${entity.jcid}" />
				<input type="hidden" name="wh" id="wh" value="${entity.wh}" />
				<input type="hidden" name="operation" id="operation" value="${entity.operation}" />
				
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;"><input type="text" name="zzjgmc" value="${entity.zzjgmc}" class="easyui-validatebox" style="line-height: 20px;border-top: 0px;border-left: 0px;border-right: 0px;width: 120px;border-color: #333333;"/>公安（分）局</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">复查意见书 <br>（存根）</span></div>
						</td>
					</tr>
					<tr class="dialogTr">
						<td style="text-align: right;">
							<span style="font-size: 18px;font: bolder;">${entity.wh }</span>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;复查意见书文号<input type="text" name="fcyjswh"   value="${entity.fcyjswh}"  class="easyui-validatebox text"  />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;复查单位<input type="text" name="dwmc"  value="${entity.dwmc}"  class="easyui-validatebox text" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;复查时间<input type="text" id="fcsj" name="fcsj" value="${entity.fcsj }" class="easyui-validatebox date" 
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;监督检查人员<input type="text" name="jcry" value="${entity.jcry}"  style="width: 100px" class="easyui-validatebox text" />、
							<input type="text" name="cjry"   value="${entity.cjry}" style="width:100px"  class="easyui-validatebox text" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;责令限期整改通知书文号<input type="text" name="zltzswh" value="${entity.zltzswh}"  class="easyui-validatebox text"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;承办部门<input type="text" name="cbbm"   value="${entity.cbbm}"  class="easyui-validatebox text"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;批准人<input type="text" name="pzr"   value="${entity.pzr}"  class="easyui-validatebox text"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;批准时间<input type="text" id="pzsj" name="pzsj" class="easyui-validatebox date" value="${entity.pzsj}"
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;填发人<input type="text" id="tfr" name="tfr"   value="${entity.tfr}"  class="easyui-validatebox text"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;填发时间<input type="text" name="tfrq" class="easyui-validatebox date" value="${entity.tfrq}"
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;送达时间<input type="text" name="sdrq" value="${entity.sdrq}" class="easyui-validatebox date" 
								data-options="validType:['date[\'yyyy年MM月dd日\']'],tipPosition:'left'"
								onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy年MM月dd日'})"/>
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;抄送单位
						</td>
					</tr>
					<tr class="dialogTr">
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="csdw" style="width: 815px;height: 60px;" class="easyui-validatebox">${entity.csdw}</textarea>
						</td>
					</tr>
					<tr class="dialogTr" align="center">
						<td>
						　　操作结果：<input name="operationBox" type="checkbox" value="0"/> 复查通过
						<input name="operationBox" type="checkbox" value="1"/>转行政案件
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
			var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+'${entity.jcid}'+"&type=jffctzscg";
			window.open(editUrl,"详情","height=1054,width=724,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		});
		
		$('input[type=checkbox]').click(function(){
			
			var clickElement = $(this).val();
			$('#operation').val(clickElement);
			$('input[type=checkbox]').each(function(i,o){
				var elment = $(o);
				if(elment.val() != clickElement){
					elment.attr('checked',false);
				}
			});
		});
		
	}
	function beforeSubmit() {
		
	}
	function afterSubmit(arr) {
		executeTabPageMethod(mainTabID, "queryButton()");
		//if (arr["saveID"]) {
		//	window.open(contextPath + "/jfjczg/queryJfzlzgtzs?id="+arr["saveID"],"详情","height=554,width=1054,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
		//}
	}
</script>