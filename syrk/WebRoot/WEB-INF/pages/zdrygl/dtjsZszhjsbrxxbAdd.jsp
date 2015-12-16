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
<title>肇事肇祸精神病人信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>dtjsMore/saveDtjsSfxx" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	<input type="hidden" id="zdryzjhm" name="zdryzjhm" value="${entity.zdryzjhm}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
	
			
	        </tr>
		     	<td width="20%" class="dialogTd" align="right">重点人员所属类别：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="sslb" name="sslb"   style="width:200px;" value="${entity.sslb}"
					data-options="url: contextPath +  '/common/dict/BD_D_ZDRYLBDMLIST_MUNICIPAL.js',
					valueField:'id',textField:'text',dataFilter: '03',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',readonly:true"/>
				</td>
					<td width="20%" class="dialogTd" align="right">病人类别：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="brlb" name="brlb"   style="width:200px;" value="${entity.brlb}"
					data-options="url: contextPath +  '/common/dict/D_QBLB_BRLB.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',readonly:true"/>
				</td>

		     <tr class="dialogTr">
		     		<td width="20%" class="dialogTd" align="right">现实状况：</td>
	    		<td width="30%" class="dialogTd">
					<input class="easyui-combobox" type="text"  id="xszk" name="xszk"   style="width:200px;" value="${entity.xszk}"
					data-options="url: contextPath +  '/common/dict/D_QBLB_XSZK.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right',readonly:true"/>
				</td>
		    </tr>	


    	    <tr>
		        <td width="20%" class="dialogTd" align="right">病情描述：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="bqms" id="bqms" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:true,validType:['maxLength[1000]'],invalidMessage:'主要事情不超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bqms}</textarea></td>
    	    </tr>
    	    <tr>
		        <td width="20%" class="dialogTd" align="right">主要病因：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="zyby" id="zyby" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:false,validType:['maxLength[1000]'],invalidMessage:'上访过程描述不超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.zyby}</textarea></td>
    	    </tr>  
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 

    if("${type}"=="view"){
    	setInputReadonly("sslb", true);
    	setInputReadonly("brlb", true);
    	setInputReadonly("xszk", true);
    	setInputReadonly("bqms", true);
    	setInputReadonly("zyby", true);

    	
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