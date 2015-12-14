<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	  <div title="社会关系人信息" id="shgxrxxb" style="height: 435px;">
 	   <table cellspacing="0" cellpadding="0" border="0" style="height:35px">
					<tbody>
					     <tr class="dialogTr">

							<td class="toolbarTd" style="width: 100%;" align="right"> 
								<a id='shgxrxxbAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="shgxrxxbAdd();">新增</a>
						    </td>
						</tr>
					</tbody>
		 </table> 
          <table id="shgxrxxbtable" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsShgxrxxb?zdryZjhm=${zdryZjhm}',
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			           	<th data-options="field:'zjlx',width:140,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/KX_D_CYZJDM.js'">证件类型</th>			           
			            <th data-options="field:'zjhm',width:120,align:'center',halign:'center',sortable:true">证件号码</th>
			            <th data-options="field:'xm',width:120,align:'center',halign:'center'">姓名</th>
			            <th data-options="field:'mz',width:120,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_MZDM.js'">民族</th>
			            <th data-options="field:'xb',width:200,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XBDM.js'">性别</th>			         			        	
			        	<th data-options="field:'xg',align:'center',width:100,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_RYGXDM.js'">关系</th>			        
			            <th data-options="field:'hjdxz',width:200,align:'center',halign:'center'">户籍地详址</th>			         			        	
			        	<th data-options="field:'xzdxz',width:200,align:'center',halign:'center'">现住地详址</th>			         			        	
			        	<th data-options="field:'process',align:'center',width:100,halign:'center',formatter:shgxrxxbFormater">操作</th>			        
			        
			        </tr>
			    </thead>
		   </table>
		  
		</div>
  
          

