<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		$(function(){
			
		});
		
		function getQueryParams(){
			return {zdryZjhm:window.parent.getZdryzjhm()};
		}
	</script>
</head>
<body >
	<table cellspacing="0" cellpadding="0" border="0" style="height:35px">
		<tbody>
		     <tr class="dialogTr">

				<td class="toolbarTd" style="width: 100%;" align="right"> 
					<a id="sdxdxxbAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="sdxdxxbAdd();">新增</a>
			    </td>
			</tr>
		</tbody>
 	</table> 
	
	<table id="ztxx" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsSdxdxxb',
           			queryParams:getQueryParams(),
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			        	<th data-options="field:'zdryzjhm',width:80,align:'left',halign:'center'">证件号码</th>
			            <th data-options="field:'dpzl',width:80,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLB_DPZL.js'">毒品种类</th>
			            <th data-options="field:'dply',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLB_XDDPLY.js'">毒品来源</th>
			            <th data-options="field:'dzly',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLB_DZLY.js'">毒资来源</th>
			            <th data-options="field:'xscs',width:80,align:'left',halign:'center'">吸食次数</th>
			            <th data-options="field:'whhg',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_XDDZLY.js'">危害后果</th>
			            <th data-options="field:'sffx',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SFDM.js'">是否复吸</th>
			            <th data-options="field:'ryxz',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLB_RYXZ.js'">人员现状</th>
			            <th data-options="field:'process',align:'center',align:'center',formatter:sdxdxxbFormater">操作</th>
			        </tr>
			    </thead>
		   </table>
	
</body>
</html>