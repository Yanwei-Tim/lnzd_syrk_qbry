<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制毒信息</title>
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
					<a id="sdzdxxbAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="window.parent.sdzdxxbAdd();">新增</a>
			    </td>
			</tr>
		</tbody>
 	</table> 
	
	<table id="sdzdxxbtable" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsSdzdxxb',
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
			            <th data-options="field:'dpzl',width:120,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_DPZL.js'">制毒种类</th>
			            <th data-options="field:'zdhxp',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_ZDHXP.js'">制毒化学品</th>
			            <th data-options="field:'dpqx',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_DPQX.js'">毒品去向</th>
			            <th data-options="field:'shdzqx',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_DZQX.js'">毒资去向</th>
			            <th data-options="field:'fmdd',width:120,align:'left',halign:'center'">贩卖地点</th>
			            <th data-options="field:'process',width:120,align:'center',align:'center',formatter:window.parent.sdxdxxbFormater">操作</th>
			        </tr>
			    </thead>
		   </table>
	
</body>
</html>