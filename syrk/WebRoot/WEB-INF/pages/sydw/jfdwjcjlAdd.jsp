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
<title>技防单位检查记录</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/sydw/sydwWord.css"><link/>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<form action="<%=basePath%>jfjfjctz/saveJfdwjcjl" id="dataForm" name="dataForm" method="post">
			<input type="hidden" name="id" id="pk" value="${entity.id}" />
			<input type="hidden" name="jcdw" value="${entity.jcdw}" />
			<input type="hidden" name="jcdwid" value="${entity.jcdwid}" />
			<div data-options="region:'center', split:true" style="width:100%; border-width: 0px;">
				<table border="0" cellpadding="0" cellspacing="6" width="100%" align="center" style="font-size: 26px;">
					<tr class="dialogTr">
						<td>
							<div align="center" style="width: 100%;padding: 15px 0 0 0"><span style="font-size: 18px;font: bolder;">公共安全技术防范检查记录<br>&nbsp;<br>&nbsp;</span></div>
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
						&nbsp;&nbsp;&nbsp;&nbsp;被检查单位（场所）名称：<input class="easyui-validatebox text" readonly="readonly" type="text" style="width:465px" value="${entity.dwmc}" />
						</td>
					</tr>
					<tr class="dialogTr">
						<td >
						&nbsp;&nbsp;&nbsp;&nbsp;地址：<input class="easyui-validatebox text" readonly="readonly" type="text" style="width:600px" value="${entity.dz_dwdzxz}" />
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
						<br>&nbsp;&nbsp;&nbsp;&nbsp;<textarea  id="jcjg"  name="jcjg" style="width: 700px;height: 60px;" class="easyui-validatebox">${entity.jcjg}</textarea>
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
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;此记录附卷
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
	var dwid = "${entity.dwid}";
	var dwlbdm = "${entity.dwlbdm}";
	function doInit(paramArray) {
		//打印
		$('#printButton').click(function(){
			var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+"${entity.id}"+"&type=jfdwjcjl";
			window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
		});
	}
	function beforeSubmit() {
		
	}
	
	function afterSubmit(arr) {
		executeTabPageMethod(mainTabID, "queryButton()");
		if (arr["saveID"]) {
			var editUrl = basePath+"dwjcxxb/addJfdwjcjlb?dwid="+dwid+"&dwlbdm="+dwlbdm+"&ywlbdm=14"+"&mainTabID="+mainTabID+"&jcid="+arr["saveID"];
			window.top.openWindowWithSave(false, null, window, null, 
		   		{title: '单位技防检查记录表',url: editUrl,width: 880,inline:true,height:500}, 
		   		null, null,null
		   	);
		}
	}
</script>