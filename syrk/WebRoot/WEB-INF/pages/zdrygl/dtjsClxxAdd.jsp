<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>

<html>
<% SessionBean userInfo = (SessionBean) session.getAttribute("userSession"); 

String userOrgCode = userInfo.getUserOrgCode();
String userOrgName = userInfo.getUserOrgName();

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
<title>车辆信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dtjsMore/saveDtjsClxx" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zjhm" name="zjhm" value="${entity.zjhm}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
		     <tr class="dialogTr">
		      <td width="20%" class="dialogTd" align="right">车辆品牌：</td>
		      <td width="30%" class="dialogTd">
		          	<input class="easyui-validatebox" type="text" id="clpp" name="clpp" data-options="validType:['maxLength[50]'],invalidMessage:'车辆品牌不能超过50，请重新输入！',tipPosition:'left'" value="${entity.clpp}" style="width: 200;" />
				    
		      </td>
		        <td width="20%" class="dialogTd" align="right">车辆类型：</td>
	            <td width="30%" class="dialogTd"><input class="easyui-combotree" type="text" id="cllx" name="cllx" value="${entity.cllx}" style="width:200px;" 
							data-options="url: contextPath + '/common/dict/D_CL_CLLX.js',onlyLeaf:true,multiple:false,panelWidth:200,method:'get',editable:true,lines:true"></td>
		       </td>
		    </tr>	

		    <tr>
		         <td width="20%" class="dialogTd" align="right">车辆颜色：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="csys" name="csys"   style="width:200px;" value="${entity.csys}"
	    			data-options="url: contextPath +  '/common/dict/D_CL_CSYS.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		       </td>
		      <td width="20%" class="dialogTd" align="right">车辆号码：</td>
		       <td width="30%" class="dialogTd">		          	
		           <input class="easyui-validatebox" type="text" id="jdchphm" name="jdchphm" value="${entity.jdchphm}" data-options="validType:['maxLength[10]'],invalidMessage:'车辆号码不能超过10，请重新输入！',tipPosition:'left'" style="width: 200px;" />		       
		      </td>
    	    </tr>
		    <tr>
		         <td width="20%" class="dialogTd" align="right">车辆来源：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="clly" name="clly"   style="width:200px;" value="${entity.clly}"
	    			data-options="url: contextPath +  '/common/dict/D_DW_CLHDFS.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		       </td>
		         <td width="20%" class="dialogTd" align="right">归属人：</td>
		      <td width="30%" class="dialogTd">
		          	<input class="easyui-validatebox" type="text" id="gsr" name="gsr" value="${entity.gsr}" style="width: 200;" />
				    
		      </td>
    	    </tr>  
    	        <tr>
    	           <td width="20%" class="dialogTd" align="right">车辆信息编号：</td>
		           <td width="30%" class="dialogTd">
		          	<input class="easyui-validatebox" type="text" id="clxxbh" name="clxxbh" data-options="validType:['maxLength[50]'],invalidMessage:'车辆编号信息不能超过50，请重新输入！',tipPosition:'left'" value="${entity.clxxbh}" style="width: 200;" />
				    
		      </td>
		     	
    	    </tr>  
    	   
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 

    if("${type}"=="view"){
    	setInputReadonly("clpp", true);
    	setInputReadonly("cllx", true);
    	setInputReadonly("csys", true);
    	setInputReadonly("jdchphm", true);
    	setInputReadonly("clly", true);
    	setInputReadonly("gsr", true);
    	setInputReadonly("clxxbh", true);
    	
    }
}



function beforeSubmit() {
	
	
}

function afterSubmit(arr) {
	if(arr["saveID"]){
		$("#pk").val(arr["saveID"]);
	}
}

</script>
</html>