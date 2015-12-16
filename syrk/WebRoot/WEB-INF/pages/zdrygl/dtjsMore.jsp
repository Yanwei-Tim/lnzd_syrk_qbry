<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	SessionBean userInfo = (SessionBean) session
			.getAttribute("userSession");
	String userOrgCode = userInfo.getUserOrgCode();	
	%>
<html>
	<head>
	  <title>动态纪实详细</title>
	    <script type="text/javascript" src="<%=contextPath%>/js/zdrygl/dtjsMore.js"></script>
	  <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
</head>
<body style="overflow: hidden;">
<input type="hidden" id="zdry_zjhm"  value="${zdryZjhm}"/>
<input type="hidden" id="zdryid"  value="${zdryid}"/>
 <div id="dtjsMore" class="easyui-tabs" data-options="border:false">
	   <div title="写实基本信息" id="dwxx" style="height: 435px;">
 	   <table cellspacing="0" cellpadding="0" border="0" style="height:35px">
					<tbody>
					     <tr class="dialogTr">

							<td class="toolbarTd" style="width: 100%;" align="right"> 
								<a id="xsjbxxAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="xsjbxxAdd();">新增</a>
						    </td>
						</tr>
					</tbody>
		 </table> 
          <table id="xsjbxx" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsXsjbxx?zdryZjhm=${zdryZjhm}',
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			            <th data-options="field:'hssj',width:80,align:'left',halign:'center',sortable:true">核实时间</th>
			            <th data-options="field:'zjzt',width:50,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_ZJZT.js'">在籍状态</th>
			            <th data-options="field:'lksj',width:80,align:'left',halign:'center'">离开时间</th>
			            <th data-options="field:'jzd_dzxz',width:100,align:'left',halign:'center'">居住地址</th>			         
			            <th data-options="field:'qwss',width:80,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XZQHDMLIST.js'">去往省市</th>
			        	<th data-options="field:'zkzt',width:50,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_ZKZT.js'">在控状态</th>
			        	<th data-options="field:'wxjb',width:50,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_WXJB.js'">危险级别</th>
			        	<th data-options="field:'zy',width:60,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_ZYFLYDM.js'">职业</th>
			        	<th data-options="field:'xnsfxx',width:100,align:'left',halign:'center'">虚拟身份信息</th>
			        	<th data-options="field:'sfjdbr',width:40,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_SF.js'">是否见到本人</th>
			        	<th data-options="field:'zklx',width:50,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_ZKLX.js'">在控类型</th>
			        	<th data-options="field:'yjzq',width:90,align:'left',halign:'center'">约见周期</th>
			        	<th data-options="field:'process',align:'center',width:100,halign:'center',formatter:xsjbxxFormater">操作</th>
			        
			        
			        </tr>
			    </thead>
		   </table>
		  
		</div>
		
		<%@include file="/WEB-INF/pages/zdrygl/dtjsZtxxList.jsp"%>
		<%@include file="/WEB-INF/pages/zdrygl/dtjsSwxxList.jsp"%>
		<%@include file="/WEB-INF/pages/zdrygl/dtjsSfxxList.jsp"%>
		<%@include file="/WEB-INF/pages/zdrygl/dtjsZdxsfzqkList.jsp"%>
		<%@include file="/WEB-INF/pages/zdrygl/dtjsShgxrxxbList.jsp"%>
		<%@include file="/WEB-INF/pages/zdrygl/dtjsSaxxList.jsp"%>
		<%@include file="/WEB-INF/pages/zdrygl/dtjsClxxList.jsp"%>

		<div title="涉毒信息" id="sdxx" >
			<input type="radio" name="sdlx" value="xd" checked="checked"> 吸毒信息 </input>
			<input type="radio" name="sdlx" value="fd"> 贩毒信息 </input>
			<input type="radio" name="sdlx" value="zd"> 制毒信息 </input>
			
			<!-- 引入具体的框架信息 -->
			<iframe id="sdxxFrame" name="sdxxFrame" src="<%=contextPath%>/forward/zdrygl|dtjsXdxxList" 
				border="0" frameborder="0" scrolling="no" 
				style="width:100%;height:400px;" > </iframe>
				
		</div>
          
	</div> 
</body>
<script type="text/javascript">
var userOrgCode="<%=userOrgCode%>";

$(function(){
	$("input[name=sdlx]").each(function(i,o){
		$(o).click(function(){
			turnToSdDetail($(this).val());
		});
	});
});

function turnToSdDetail(sdType){
	
	var src = contextPath + "/forward/zdrygl|";
	if(sdType == 'xd'){
		src += "dtjsXdxxList";
	}else if(sdType == 'fd'){
		src += "dtjsFdxxList";
	}else{
		src += "dtjsZdxxList";
	}
	$("#sdxxFrame").attr('src',src);
}

function getUserOrgCode(){
	return userOrgCode;
}

function getZdryzjhm(){
	return '${zdryZjhm}';
}

function getZdryid(){
	return '${zdryid}';
}

</script>
</html>