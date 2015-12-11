<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	  <div title="维稳信息" id="swxx" style="height: 435px;">
 	   <table cellspacing="0" cellpadding="0" border="0" style="height:35px">
					<tbody>
					     <tr class="dialogTr">

							<td class="toolbarTd" style="width: 100%;" align="right"> 
								<a id='swxxAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="swxxAdd();">新增</a>
						    </td>
						</tr>
					</tbody>
		 </table> 
          <table id="swxxtable" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsSwxx?zdryZjhm=${zdryZjhm}',
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			           	<th data-options="field:'zdryzjhm',width:140,align:'center',halign:'center'">重点人员证件号码</th>			           
			            <th data-options="field:'sslb',width:120,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'">所属类别</th>
			            <th data-options="field:'sslbxl',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'">所属类别细类</th>
			            <th data-options="field:'sszzmc',width:120,align:'left',halign:'center'">所属组织名称</th>
			            <th data-options="field:'qkgs',width:200,align:'left',halign:'center'">情况概述</th>			         			        	
			        	<th data-options="field:'process',align:'center',width:100,halign:'center',formatter:swxxFormater">操作</th>			        
			        </tr>
			    </thead>
		   </table>
		  
		</div>
  
          

