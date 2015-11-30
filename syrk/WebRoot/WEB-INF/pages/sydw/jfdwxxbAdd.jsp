<!--  
	@Author:       [yu_guangli@founder.com.cn]
	@CreateDate:   [2015-6-3 下午13:15:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技防单位信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dwjfdwxxb/save" id="dataForm" name="dataForm" method="post">
    	<input type="hidden" name="dwid" id="dwid" value="${entity.dwid}" />
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;margin-top:10px;text-align: center;">
	    	<div style="width: 100%;padding: 20px;" align="left">
	    		<div id="scjcrq">
		    		<span style="font: bold red;font-size: 20px">上次检查日期:${entity.scjcrq }</span> 
		    		&nbsp;&nbsp;
		    		<a id="jcgjButton" class="l-btn l-btn-small" href="javascript:void(0)" >
						<span >
							<span class="l-btn-text">检查轨迹</span>
							<span class="l-btn-icon"> </span>
						</span>
					</a>
				</div>
	    		<span id="unCheck" style="font: bold red;font-size: 20px">温馨提示：您还未对该单位进行日常检查!</span>
	    	</div> 
	    	<fieldset style="width: 95%;">
	  			<legend>视频监控</legend>
	  			<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
		    		<input type="hidden" name="id" id="pk" value="${entity.id}" />
		    		<input type="hidden" name="flag" id="flag" value="${flag}" />
		    		<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">有无监控：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-combobox ' data-options="url: contextPath + '/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
						 	type='text' name='spjk_ywjkdm' style="width:200px;" value="${entity.spjk_ywjkdm}" />
						</td>
						<td width="20%" class="dialogTd" align="right">监控范围：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-combobox ' data-options="url: contextPath + '/common/dict/BD_D_BFFWDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
							type='text'  name='spjk_jkfwdm' style="width:200px;" value="${entity.spjk_jkfwdm}" />
						</td>
				    </tr>
				   <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">摄像头分类：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-combobox ' data-options="url: contextPath + '/common/dict/BD_D_SXTFLDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
						 	type='text' name='spjk_sxtfldm' style="width:200px;" value="${entity.spjk_sxtfldm}" />
						</td>
						<td width="20%" class="dialogTd" align="right">点位数量：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-validatebox" type="text" id="spjk_dwsl" name="spjk_dwsl" style="width:200px;float:left;" value="${entity.spjk_dwsl }" 
				    		data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'left'"/>
					    </td>
				    </tr>
				    <tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">存储时间：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-validatebox" type="text" id="spjk_cxsj" name="spjk_cxsj" style="width:200px;float:left;" value="${entity.spjk_cxsj }" 
				    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					    </td>
						<td width="20%" class="dialogTd" align="right">有无监控室：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-combobox" type="text" id="spjk_ywjksdm" name="spjk_ywjksdm" style="width:200px;float:left;" value="${entity.spjk_ywjksdm }" 
				    		data-options="url: contextPath + '/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
					    </td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">联系人姓名：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="required:false,validType:['maxLength[40]'],tipPosition:'right'" type='text' 
							name='spjk_lxrxm' style="width:200px;" value="${entity.spjk_lxrxm}" />
						</td>
						<td width="20%" class="dialogTd" align="right">联系人联系方式：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-validatebox" type="text" id="spjk_lxrlxfs" name="spjk_lxrlxfs" style="width:200px;float:left;" value="${entity.spjk_lxrlxfs }" 
				    		data-options="validType:['phone'],required:false,tipPosition:'left'"/>
					    </td>
				    </tr>
		    	</table>
		    </fieldset>
		    <fieldset style="width: 95%;">
	  			<legend>入侵报警</legend>
	  			<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
		    		<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">有无 入侵报警：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-combobox ' data-options="url: contextPath + '/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
						 	type='text'  name='rqbj_ywrqbjdm' style="width:200px;" value="${entity.rqbj_ywrqbjdm}" />
						</td>
						<td width="20%" class="dialogTd" align="right">布防范围：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-combobox ' data-options="url: contextPath + '/common/dict/BD_D_BFFWDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
						 	type='text' name='rqbj_bffwdm' style="width:200px;" value="${entity.rqbj_bffwdm}" />
						</td>
				    </tr>
				   <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">入侵检测方式：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="required:false,validType:['maxLength[40]'],tipPosition:'right'" type='text' 
							name='rqbj_rqjcfs' style="width:200px;" value="${entity.rqbj_rqjcfs}" />
						</td>
						<td width="20%" class="dialogTd" align="right">数量：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-validatebox" type="text" id="rqbj_sl" name="rqbj_sl" style="width:200px;float:left;" value="${entity.rqbj_sl }" 
				    		data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'left'"/>
					    </td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">联系人姓名：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="required:false,validType:['maxLength[40]'],tipPosition:'right'" type='text' 
							name='rqbj_lxrxm' style="width:200px;" value="${entity.rqbj_lxrxm}" />
						</td>
						<td width="20%" class="dialogTd" align="right">联系人联系方式：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-validatebox" type="text" id="rqbj_lxrlxfs" name="rqbj_lxrlxfs" style="width:200px;float:left;" value="${entity.rqbj_lxrlxfs }" 
				    		data-options="validType:['phone'],required:false,tipPosition:'left'"/>
					    </td>
				    </tr>
				    <tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">是否与公安机关联网：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-combobox" type="text" id="rqbj_sfygajglwdm" name="rqbj_sfygajglwdm" style="width:200px;float:left;" value="${entity.rqbj_sfygajglwdm }" 
				    		data-options="url: contextPath + '/common/dict/D_GG_SF.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"/>
					    </td>
				    </tr>
		    	</table>
	  		</fieldset>
		    <fieldset style="width: 95%;">
	  			<legend>出入口控制</legend>
	  			<table border="0" cellpadding="0" cellspacing="5" width="100%" align="center">
		    		<tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">有无出入口：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-combobox ' data-options="url: contextPath + '/common/dict/D_GG_YW.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
							type='text' name='crkkz_ywcrkdm' style="width:200px;" value="${entity.crkkz_ywcrkdm}" />
						</td>
						<td width="20%" class="dialogTd" align="right">布防范围：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-combobox ' data-options="url: contextPath + '/common/dict/BD_D_BFFWDM.js',valueField:'id',textField:'text',selectOnNavigation:false,required:false,method:'get'"
						 	type='text'  name='crkkz_bffwdm' style="width:200px;" value="${entity.crkkz_bffwdm}" />
						</td>
				    </tr>
				    <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">控制方式：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="required:false,validType:['maxLength[40]'],tipPosition:'right'" type='text' 
							name='crkkz_kzfs' style="width:200px;" value="${entity.crkkz_kzfs}" />
						</td>
						<td width="20%" class="dialogTd" align="right">数量：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-validatebox" type="text" id="crkkz_sl" name="crkkz_sl" style="width:200px;float:left;" value="${entity.crkkz_sl }" 
				    		data-options="required:false,validType:['naturalNumberRange[1,1000]'],tipPosition:'left'"/>
					    </td>
				     </tr>
				     <tr class="dialogTr">
				    	<td width="20%" class="dialogTd" align="right">联系人姓名：</td>
						<td width="30%" class="dialogTd">
							<input class='easyui-validatebox ' data-options="required:false,validType:['maxLength[40]'],tipPosition:'right'" type='text' 
							name='crkkz_lxrxm' style="width:200px;" value="${entity.crkkz_lxrxm}" />
						</td>
						<td width="20%" class="dialogTd" align="right">联系人联系方式：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-validatebox" type="text" id="crkkz_lxrlxfs" name="crkkz_lxrlxfs" style="width:200px;float:left;" value="${entity.crkkz_lxrlxfs }" 
				    		data-options="validType:['phone'],required:false,tipPosition:'left'"/>
					    </td>
				    </tr>
				    <tr class="dialogTr">
						<td width="20%" class="dialogTd" align="right">存储时间：</td>
				    	<td width="30%" class="dialogTd" align="left">
				    		<input class="easyui-validatebox" type="text" id="crkkz_cxsj" name="crkkz_cxsj" style="width:200px;float:left;" value="${entity.crkkz_cxsj }" 
				    		data-options="validType:['date[\'yyyy-MM-dd\']'],required:false,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
					    </td>
				    </tr>
		    	</table>
  			</fieldset>
	    </div>
    </form>
</div>
</html>
<script type="text/javascript" >
var _p ;
function doInit(paramArray) {
	
	if('${entity.scjcrq}' != null && '${entity.scjcrq}' != ''){
		$('#unCheck').hide();
		
		$('#jcgjButton').click(function(){
			var editUrl = "/forward/sydw|rcjcMain?dwid="+'${dwjcxxb.dwid}'+"&dwmc="+encodeURI('${dwjcxxb.dwmc}')+"&dwlbdm="+'${dwjcxxb.dwlbdm}'+'&ywlbdm=14';
			console.log(editUrl);
			menu_open("检查轨迹",editUrl);
		});
		
	}else{
		$('#scjcrq').hide();
	}
	
	_p = paramArray["_p"];
	$("#bafzrsfzh").validatebox({validType:['sfzh'],charSet:'halfUpper'});
	$("#fwqyfzrsfzh").validatebox({validType:['sfzh'],charSet:'halfUpper'});
}
function beforeSubmit() {
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
	$(_p).find("input[name='id']").val($("#pk").val());
	window.parent.location.reload();
}
</script>