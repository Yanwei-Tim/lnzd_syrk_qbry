<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>车辆轨迹</title>
		<script type="text/javascript">
			$(function (){
				
			});
		</script>
	</head>

<body>
	<form action="" id="dataForm" name="dataForm" method="post" >
		<input type="hidden" id="_method" name="_method" value=""/>
		<input type='hidden' name='id' id="pk" value="${entity.id}" />
		<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}"/>
		<input type="hidden" name="lxdh" id="lxdh" />	
		<table border="0" cellpadding="0" cellspacing="10" width="846" align="left">
			<tr class="dialogTr">
				<td> </td>
			</tr>
			<tr class="dialogTr">
				<td> </td>
			</tr>
			<tr class="dialogTr">
				<td width="10%" class="dialogTd" align="right">姓名：</td>
		    	<td width="20%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="xm" name="xm" style="width:180px;" readonly="readonly"/>
		    	</td>
		    	<td width="10%" class="dialogTd" align="right">身份号码：</td>
		    	<td width="20%" class="dialogTd">
		    	<input class="easyui-validatebox inputreadonly" type="text" id="sfzh" name="sfzh" style="width:180px;" readonly="readonly"/>
		    	</td>
		    	<td width="10%" class="dialogTd" align="right">监控状态：</td>
		    	<td width="20%" class="dialogTd">
		    	<input class="easyui-combobox" type="text" id="xt_jkbz" name="xt_jkbz" style="width:180px;"
					data-options="url: contextPath + '/common/dict/BD_D_ZDRYGJJKZT.js',valueField:'id',
					textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
		    	</td>
	    	</tr>
	    	<tr class="dialogTr">
				<td> </td>
			</tr>
			<tr class="dialogTr">
				<td> </td>
			</tr>
			<tr class="dialogTr">
				<td> </td>
			</tr>
	    	<tr class="dialogTr" align="center">
	    		<td colspan="4">
	    			<font color='red'>选择监控状态后点击保存。该人员的车辆轨迹信息将被保存并根据状态选择是否显示！</font>
	    		</td>
	    	</tr>
    	</table>
    	
    </form>
</body>

<script type="text/javascript">


function doInit(paramArray){
	$('#sfzh').val(paramArray["sfzh"]);
	$('#xm').val(paramArray["xm"]);
	$('#lxdh').val(paramArray["lxdh"]);
	$('#xt_jkbz').combobox('setValue', paramArray["xt_jkbz"]);
}

function beforeSubmit() {
	if ($("#pk").val() == "") {
		$("#_method").val('');
		$("#dataForm").attr('action', contextPath + '/zdryCarTrail/save');
	}
}

function afterSubmit(arr) {
	parent.location.reload();
}
</script>
</html>
