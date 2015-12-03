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
	.thhead {
	text-align: center;
	background: #e1e1e1;
	border: 1px solid #cccccc;
}

.tdbr {
	border-right: 1px solid #cccccc;
	border-bottom: 1px solid #cccccc;
}

.tdb {
	border-bottom: 1px solid #cccccc;
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
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 26px;font: bolder;">公共安全技术防范系统检查记录表<br>&nbsp;</span></div>
						</td>
					</tr>
					<tr  class="dialogTr" style="margin-top: 50px">
						<td width="80%" class="dialogTd" align="center">
							<table style="width:620px;border:  1px solid #cccccc;" cellpadding="0" cellspacing="0">
								<tr style="height: 25px;">
									<td style="width:130px;" class="thhead">类目</td>
									<td style="width:343px;" class="thhead">检查项目</td>
									<td style="width:20px;" class="thhead">是</td>
									<td style="width:20px;" class="thhead">否</td>
									<td style="width:97px;" class="thhead">备注</td>
								</tr>
								<c:choose>
									<c:when test="${list != null and fn:length(list) !=0}">
										<c:forEach items="${list}" var="dwjctype" varStatus="status">
											<tr>
												<td style="width:130px;" class="tdbr">${status.index+1}、${dwjctype.name} 
													<input type="hidden" id="type_${dwjctype.id}" value="${dwjctype.id}" />
												</td>
												<td colspan="4" style="width:490px;">
													<table style="width:100%" cellpadding="0" cellspacing="0">
														<c:forEach items="${dwjctype.list}" var="dwjcdata" varStatus="data">
															<tr>
																<td style="width:400px;" class="tdbr">${data.index+1}）${dwjcdata.name}
																	<input type="hidden" id="data_${dwjctype.id}" value="${dwjcdata.id}" />
																</td>
																<c:choose>
																	<c:when test="${dwjcdata.def == '1'}">
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" disabled="disabled"  checked value="1" />
																		</td>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" disabled="disabled" value="0"/>
																		</td>
																	</c:when>
																	<c:when test="${dwjcdata.def == '0'}">
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" disabled="disabled" value="1"/>
																		</td>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" disabled="disabled" checked value="0" />
																		</td>
																	</c:when>
																	<c:otherwise>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" disabled="disabled" value="1" />
																		</td>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" disabled="disabled" value="0" />
																		</td>
																	</c:otherwise>
																</c:choose>
																<td style="width:100px;height: 100%;" class="tdb">
																	<textarea id="bz_${dwjcdata.id}" class="easyui-validatebox"
																		style="width:100px;height: 100%;">${dwjcdata.bz}</textarea>
																</td>
															</tr>
														</c:forEach>
													</table>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td style="border-left:1px solid #cccccc;height:30px;color: red;text-align: center;font-size: 13px;" class="tdbr" colspan="5">
												无配置检查项信息,请联系管理员...
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</table>
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