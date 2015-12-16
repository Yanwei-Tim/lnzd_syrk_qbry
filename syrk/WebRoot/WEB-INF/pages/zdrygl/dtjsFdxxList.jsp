<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贩毒信息</title>
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
					<a id="sdfdxxbAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="window.parent.sdfdxxbAdd();">新增</a>
			    </td>
			</tr>
		</tbody>
 	</table> 
	
	<table id="sdfdxxbtable" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsSdfdxxb',
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
			        	<th data-options="field:'zdryzjhm',width:150,align:'left',halign:'center'">证件号码</th>
			            <th data-options="field:'fmdpzl',width:120,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_DPZL.js'">贩卖毒品种类</th>
			            <th data-options="field:'dply',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_XDDPLY.js'">毒品来源</th>
			            <th data-options="field:'fmdpqd',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_FDQD.js'">贩卖毒品渠道</th>
			            <th data-options="field:'shdzqx',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_DZQX.js'">毒资去向</th>
			            <th data-options="field:'lyd',width:150,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XZQHDMLIST.js'">来源地</th>

			            <th data-options="field:'process',width:120,align:'center',align:'center',formatter:window.parent.sdxdxxbFormater">操作</th>
			        </tr>
			    </thead>
		   </table>
	
</body>
</html>