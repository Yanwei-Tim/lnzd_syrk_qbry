<!--  
	@updateAuthor: [yuguangli@founder.com]
	@updateDate:   [2015-6-6 上午8:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位检查记录</title>
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
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>jfjfjctz/saveJfdwjcjlb" id="dataForm" name="dataForm" method="post">
			<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
			<input type="hidden" name="dwmc" id="dwmc" value="${entity.dwmc}" />
			<input type="hidden" name="ywlbdm" id="ywlbdm" value="${entity.ywlbdm}"/>
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<input type="hidden" name="rwid" id="rwid" value="${rwid}" />
			<input type="hidden" id="jcxmx" name="jcxmx"/>
			<input type="hidden" id="statusFlag" name="statusFlag"/>
			
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<table id="tp_"border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;">公共安全技术防范系统检查记录表</span></div>
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
																			<input id="ch_${dwjcdata.id}" type="checkbox" checked value="1" />
																		</td>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" value="0"/>
																		</td>
																	</c:when>
																	<c:when test="${dwjcdata.def == '0'}">
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" value="1"/>
																		</td>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" checked value="0" />
																		</td>
																	</c:when>
																	<c:otherwise>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" value="1" />
																		</td>
																		<td style="width:10px;" class="tdbr">
																			<input id="ch_${dwjcdata.id}" type="checkbox" value="0" />
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
					
					<tr class="dialogTr">
						<td class="dialogTd" width="80%" align="center">
						<br>检查状态：
							<input type="radio" name="status" value="startCheck" checked="checked" />开始检查
							<input type="radio" name="status" value="checkOk" />检查合格
							<input type="radio" name="status" value="zlzg" />责令整改
						</td>
					</tr>
					<tr class="dialogTr">
						<td class="dialogTd" width="80%" align="center">
							<a id="upButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
								<span class="l-btn-left l-btn-icon-left">
									<span class="l-btn-text">上传附件</span>
									<span class="l-btn-icon icon-save"> </span>
								</span>
							</a>
							
							&nbsp;&nbsp;
							
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
		
		//上传
		$('#upButton').click(function(){
			var editUrl = basePath+'jfjfjctz/fjxxUpload?jcid='+'${entity.id}';
			window.top.openWindowWithSave(false, null, window, {'_p':$('tp_')},
			{title: '附件信息上传',url: editUrl,width: 880,inline:true,height:500}, 
		   		null, null,null
		   	);
		});
		
		//打印
		$('#printButton').click(function(){
			var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+'${entity.id}'+"&type=jfdwjcjlb";
			window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
		});
		
		if(!paramArray){
			return;
		}
		checkboxToRadio();
		if(paramArray["mode"]=='view'){
			$('#dataForm').find('input[type="text"]').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
				$(o).next(".combo").addClass("inputReadonly");
			});
			$('#dataForm').find('textarea').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
			});
			$('#dataForm').find('input[type="checkbox"]').each(function(i,o){
				$(o).attr('disabled','disabled');
			});
			
		}else{
			$("#tr1").find('input[type="text"]').each(function(i,o){
				$(o).attr('readonly','readonly');
				$(o).addClass('inputReadonly');
				$(o).next(".combo").addClass("inputReadonly");
			});
		}
	}
	function beforeSubmit() {
		var jcxparamsMap = "[";
		$("input:hidden[id^='type_']").each(function(index, domEle) {
			var typeid = $(domEle).val();
			jcxparamsMap += "{\"typeid\":\"" + typeid + "\",\"list\":[";
			$("input:hidden[id='data_" + typeid + "']").each(function(index, domEle) {
				var dataid = $(domEle).val();
				var checkboxs = $("input:checkbox[id='ch_" + dataid + "']:checked");
				var def = "";
				if (checkboxs.length == 1) {
					def = checkboxs[0].value;
				};
				var bz = $("#bz_" + dataid).text();
				jcxparamsMap += "{\"dataid\":\""+ dataid + "\",\"def\":\"" + def + "\",\"bz\":\"" + bz + "\"},";
			});
			jcxparamsMap += "],";
			jcxparamsMap = jcxparamsMap.replace("},]", "}]}");
		});
		jcxparamsMap += "]";
		jcxparamsMap = jcxparamsMap.replace("},]", "}]");
		$("#jcxmx").val(jcxparamsMap);
		
		//设置后续数据状态
		$("#statusFlag").val($("input[name=status]:checked ").val());
	}

	function afterSubmit(arr) {
		if (arr["saveID"]) {
			$("#pk").val(arr["saveID"]);
			
			if($("input[name=status]:checked ").val() == "zlzg"){
				//责令整改
				
			}
		}
		executeTabPageMethod(mainTabID, "queryButton()");
		//gem #86 实有单位-单位编辑页面，单位检查信息和单位处罚信息新增后，当前页面未刷新
		//parent.location.reload();
	}
	
	function checkboxToRadio() {
		checkboxs = $("input:checkbox[id^='ch_']");
		for (i = 0; i < checkboxs.length; i++) {
			checkboxs[i].onclick = function() {
				for (j = 0; j < checkboxs.length; j++) {
					if (this.id == checkboxs[j].id && this.value != checkboxs[j].value && checkboxs[j].checked == true) {
						checkboxs[j].checked = false;
					}
				}
			};
		};
	};
</script>

