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
<title>写实基本信息</title>
</head>
<div class="easyui-layout" data-options="fit:true">
    <form action="<%=basePath%>zdryDtjs/saveDtjs" id="dataForm" name="dataForm" method="post" >
    	<input type="hidden" id="zdryid" name="zdryid" value="${entity.zdryid}" />
        <input type="hidden" id="rylbxx" name="rylbxx" value="${entity.rylbxx}" />
    	
    	<input type="hidden" id="pk" name="id" value="${entity.id}" />
    	
	    <div data-options="region:'center', split:true" style="width:500px; border-width: 0px;">
			<table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
			<tr>
			<td width="20%" class="dialogTd" align="right">核实时间：</td>
		    <td width="30%" class="dialogTd"><input type="text" name="hssj" id="hssj" class="easyui-validatebox" style="width: 200px;" value="${entity.hssj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    </td>
			
			<td width="20%" class="dialogTd" align="right">核实地点区划：</td>
		    <td width="30%" class="dialogTd">
		    	<input class="easyui-combotree" type="text"  id="hsddqh" name="hsddqh"   style="width:200px;" value="${entity.hsddqh}"
	    			data-options="mode:'remote',required:true,tipPosition:'right',url: contextPath + '/common/dict/D_BZ_XZQH_MUNICIPAL.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',editable:true,lines:true"/>
		    </td>
	        </tr>
		     <tr class="dialogTr">
		        <td width="20%" class="dialogTd" align="right">核实地点名称：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="hsddmc" name="hsddmc" value="${entity.hsddmc}" style="width:200px;" data-options="required:true,validType:['maxLength[100]'],invalidMessage:'核实地点名称不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
			      <td width="20%" class="dialogTd" align="right">核实地点详址：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="hsddxz" name="hsddxz" value="${entity.hsddxz}" style="width:200px;" data-options="required:true,validType:['maxLength[200]'],invalidMessage:'核实地点详址不能超过200个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
		    </tr>

		     <tr class="dialogTr">
		      <td width="20%" class="dialogTd" align="right">在控状态：</td>
		       <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="zkzt" name="zkzt"   style="width:200px;" value="${entity.zkzt}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_ZKZT.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			"/>
		       </td>
			    <td width="20%" class="dialogTd" align="right">在籍状态：</td>
		        <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="zjzt" name="zjzt"   style="width:200px;" value="${entity.zjzt}"
					data-options="url: contextPath +  '/common/dict/D_QBLD_ZJZT.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/>
		       </td>
		    </tr>	
		    <tr>
			<td width="20%" class="dialogTd" align="right">离开时间：</td>
		    <td width="30%" class="dialogTd"><input type="text" name="lksj" id="lksj" class="easyui-validatebox" style="width: 200px;" value="${entity.lksj}"
					data-options="validType:['date[\'yyyy-MM-dd\']'],required:true,tipPosition:'left'" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
		    </td>
			
			<td width="20%" class="dialogTd" align="right">去往省市：</td>
		    <td width="30%" class="dialogTd">
		    	<input class="easyui-combobox" type="text"  id="qwss" name="qwss"   style="width:200px;" value="${entity.qwss}"
		             data-options="mode:'remote',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/>
		    </td>
	        </tr>	
		     <tr>
		     	<td width="20%" class="dialogTd" align="right">危险级别（提示）：</td>	     
			    <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="wxjb" name="wxjb"   style="width:200px;" value="${entity.wxjb}"
					data-options="url: contextPath +  '/common/dict/D_QBLD_WXJB.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
	    			/>
		       </td>
			
			  <td width="20%" class="dialogTd" align="right">主要意向：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="zyyx" name="zyyx" value="${entity.zyyx}" style="width:200px;" data-options="validType:['maxLength[100]'],invalidMessage:'主要意向不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
	        </tr>	
	        
	        	    	
		    <tr>
		       <td width="20%" class="dialogTd" align="right">职业：</td>
		       <td width="30%" class="dialogTd">
		     	<input class="easyui-combotree" type="text"  id="zy" name="zy"   style="width:200px;" value="${entity.zy}"
					data-options="required:false,tipPosition:'right',url: contextPath + '/common/dict/GB_D_ZYFLYDM.js',onlyLeaf:true,panelWidth:280,multiple:false,method:'get',editable:true,lines:true"/>
		        </td> 
		  
		         <td width="20%" class="dialogTd" align="right">实际收入：</td>	     
			    <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sjsr" name="sjsr"   style="width:200px;" value="${entity.sjsr}"
					data-options="url: contextPath +  '/common/dict/D_QBLD_SJSR.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		        
		    </tr>
		     <tr>
		       <td width="20%" class="dialogTd" align="right">经济来源：</td>
		         <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="jjly" name="jjly"   style="width:200px;" value="${entity.jjly}"
					data-options="url: contextPath +  '/common/dict/D_QBLD_JJLY.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:false,tipPosition:'right'"/>
		       </td>
		        
		    </tr>
		   <tr class="dialogTr">
		        <td width="20%" class="dialogTd" align="right">工作单位：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="gzdw" name="gzdw" value="${entity.gzdw}" style="width:200px;" data-options="validType:['maxLength[100]'],invalidMessage:'工作单位不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
			      <td width="20%" class="dialogTd" align="right">工作单位详址：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="gzdwxz" name="gzdwxz" value="${entity.gzdwxz}" style="width:200px;" data-options="validType:['maxLength[200]'],invalidMessage:'工作单位详址不能超过200个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		       <td width="20%" class="dialogTd" align="right">现住地区划：</td>
		    	<td width="30%" class="dialogTd">
		    	<input class="easyui-combobox" type="text"  id="jzdqh" name="jzdqh"   style="width:200px;" value="${entity.jzdqh}"
	    			 data-options="mode:'remote',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"
		   		 </td>
			      <td width="20%" class="dialogTd" align="right">现住地详址：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="jzdxz" name="jzdxz" value="${entity.jzdxz}" style="width:200px;" data-options="validType:['maxLength[200]'],invalidMessage:'职务名称不能超过200个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
		    </tr>
		    <tr class="dialogTr">
		       <td width="20%" class="dialogTd" align="right">管辖单位：</td>
		    	<td width="30%" class="dialogTd">
		    		<span   id="gxdwmc" name="gxdwmc" style="width:200px;"><%=userOrgName %></span>
		    		<input class="easyui-validatebox" type="hidden" id="gxdwmc" name="gxdwmc" value="<%=userOrgName %>" style="width:200px;"/>
		    	
		    		<input class="easyui-validatebox" type="hidden" id="gxdwdm" name="gxdwdm" value="<%=userOrgCode %>" style="width:200px;"/>
		    	
		   		 </td>
			    <td width="20%" class="dialogTd" align="right">是否见到本人：</td>
		         <td width="30%" class="dialogTd">
		           <input class="easyui-combobox" type="text"  id="sfjdbr" name="sfjdbr"   style="width:200px;" value="${entity.sfjdbr}"
	    			data-options="url: contextPath +  '/common/dict/D_QBLD_SF.js',
					valueField:'id',textField:'text',selectOnNavigation:false,method:'get',required:true,tipPosition:'right'"/>
		       </td>	      
			      
		    </tr>
		    <tr class="dialogTr">
		       <td width="20%" class="dialogTd" align="right">直系亲属信息：</td>
		    	<td width="30%" class="dialogTd">
		    	   <input class="easyui-validatebox" type="text" id="zxqsxx" name="zxqsxx" value="${entity.zxqsxx}" style="width:200px;" data-options="validType:['maxLength[100]'],invalidMessage:'直系亲属信息不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
		    	
		   		 </td>
			      <td width="20%" class="dialogTd" align="right">虚拟身份信息：</td>
		    	<td width="30%" class="dialogTd">
		    		<input class="easyui-validatebox" type="text" id="xnsfxx" name="xnsfxx" value="${entity.xnsfxx}" style="width:200px;" data-options="validType:['maxLength[200]'],invalidMessage:'虚拟身份信息不能超过100个汉字，请重新输入！',tipPosition:'left'"/>
		    	</td>
		    </tr>
		    <tr>
		        <td width="20%" class="dialogTd" align="right">情况描述（提示）：</td>
		    	<td width="80%" class="dialogTd" colspan="3"><textarea name="hsqkms" id="hsqkms" class="easyui-validatebox" style="width: 627px; height:48px;"
					data-options="required:false,validType:['maxLength[500]'],invalidMessage:'情况描述超过500个汉字，请重新输入！',tipPosition:'left'">${entity.hsqkms}</textarea></td>
    	    </tr>
		
	    	</table>
	    </div>
    </form>
</div>

<script type="text/javascript" >

function doInit(paramArray) { 
	
	initComboBox("qwss", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	initComboBox("jzdqh", contextPath + "/common/dict/GB_D_XZQHDMLIST.js"); 
	
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