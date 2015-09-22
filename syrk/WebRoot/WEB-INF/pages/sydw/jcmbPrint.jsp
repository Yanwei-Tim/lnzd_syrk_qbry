<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style>
.thhead {
	text-align: center;
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
	<table class="font" width="100%" border="0" cellpadding="2" cellspacing="0">
		<tr>
			<td width="100%">
			<div align="center" style="width: 100%;padding: 15px 0 15px 0">
				<c:if test="${ywlbdm =='04'}">
					<span style="font-size: 26px">治安/内保单位检查模板</span>
				</c:if>
				<c:if test="${ywlbdm =='12'}">
					<span style="font-size: 26px">环保单位检查模板</span>
				</c:if>
				<c:if test="${ywlbdm =='13'}">
					<span style="font-size: 26px">保安单位检查模板</span>
				</c:if>
			</div>
				<table style="border:black 2px solid;" class="mainTable" cellpadding="0" cellspacing="10" width="845px" align="center">
					<tr class="dialogTr" id="tr1">
						<td width="16%" class="dialogTd" align="right">单位名称：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">单位类型：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled">${dictxxb.ct}</textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="16%" class="dialogTd" align="right">单位负责人：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">单位负责人联系电话：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="16%" class="dialogTd" align="right">检查时间：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">参检人数：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="16%" class="dialogTd" align="right">检查单位：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br> 
						</td>
						<td width="16%" class="dialogTd" align="right">检查人员：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr>
						<td width="16%" class="dialogTd" align="right">现场负责人：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">现场负责人联系电话：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					</tr>
					<tr class="dialogTr">
						<td width="18%" class="dialogTd" align="right"
							style="vertical-align: top;"><br/>检查项信息：</td>
						<td width="82%" class="dialogTd" colspan="3">
							<table style="width:640px;border:  1px solid #cccccc;" cellpadding="0" cellspacing="0">
								<tr style="height: 25px;">
									<td style="width:130px;" class="thhead">类目</td>
									<td style="width:363px;" class="thhead">检查项目</td>
									<td style="width:20px;" class="thhead">是</td>
									<td style="width:20px;" class="thhead">否</td>
									<td style="width:97px;" class="thhead">备注</td>
								</tr>
								<c:choose>
									<c:when test="${list != null and fn:length(list) !=0}">
										<c:forEach items="${list}" var="dwjctype" varStatus="status">
											<tr>
												<td style="width:130px;" class="tdbr">${status.index+1}、${dwjctype.name}
													<input type="hidden" id="type_${dwjctype.id}"
													value="${dwjctype.id}" /></td>
												<td colspan="4" style="width:510px;">
													<table style="width:100%" cellpadding="0" cellspacing="0">
														<c:forEach items="${dwjctype.list}" var="dwjcdata"
															varStatus="data">
															<tr>
																<td style="width:400px;" class="tdbr">${data.index+1}）${dwjcdata.name}
																	<input type="hidden" id="data_${dwjctype.id}"value="${dwjcdata.id}" />
																</td>
																<c:choose>
																	<c:when test="${dwjcdata.def == '1'}">
																		<td style="width:10px;" class="tdbr">
																		<input id="ch_${dwjcdata.id}" type="checkbox" value="1" onclick="return false;"/>
																		</td>
																		<td style="width:10px;" class="tdbr">
																		<input id="ch_${dwjcdata.id}" type="checkbox" value="0" onclick="return false;"/>
																		</td>
																	</c:when>
																	<c:when test="${dwjcdata.def == '0'}">
																		<td style="width:10px;" class="tdbr">
																		<input id="ch_${dwjcdata.id}" type="checkbox" value="1" onclick="return false;"/>
																		</td>
																		<td style="width:10px;" class="tdbr">
																		<input id="ch_${dwjcdata.id}" type="checkbox" value="0" onclick="return false;"/>
																		</td>
																	</c:when>
																	<c:otherwise>
																		<td style="width:10px;" class="tdbr">
																		<input id="ch_${dwjcdata.id}" type="checkbox" value="1" onclick="return false;"/>
																		</td>
																		<td style="width:10px;" class="tdbr">
																		<input id="ch_${dwjcdata.id}" type="checkbox" value="0" onclick="return false;"/>
																		</td>
																	</c:otherwise>
																</c:choose>
																<td style="width:100px;height: 100%;" class="tdb">
																	<textarea id="bz_${dwjcdata.id}" style="width:100px;height: 100%;background:white;border-top: 0px;border-left: 0px;border-right: 0px;overflow: hidden;" disabled="disabled"></textarea>
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
											<td
												style="border-left:0px solid #cccccc;height:30px;color: red;text-align: center;font-size: 13px;"
												class="tdbr" colspan="5">无配置检查项信息,请联系管理员...</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</table></td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">其他违规情况和安全隐患：</td>
						<td width="80%" class="dialogTd" colspan='3'>
						<textarea  type="text"  class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 640px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr>
						<td width="20%" class="dialogTd" align="right">检查结果：</td>
						<td width="80%" class="dialogTd" colspan='3'>
						<textarea  type="text"  class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 640px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">整改通知书或裁决书号：</td>
						<td width="34%" class="dialogTd">
						<textarea  type="text"  class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="16%" class="dialogTd" align="right">整改通知书名称：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text"  class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>

					<tr>
						<td width="20%" class="dialogTd" align="right">整改或处罚意见：</td>
						<td width="80%" class="dialogTd" colspan='3'>
						<textarea  type="text"  class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 640px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr>
						<td width="20%" class="dialogTd" align="right">备注：</td>
						<td width="80%" class="dialogTd" colspan='3'>
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 640px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
				</table>
				<table width="90%" height="147" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td class="noprint" align="center">
						<input onclick="javascript:this.style.display = 'none';window.print();"
							type="button" name="打印" value="打  印" id="b12" />&nbsp;&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>