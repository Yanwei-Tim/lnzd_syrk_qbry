<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	  <div title="车辆信息" id="sfxx" style="height: 435px;">
 	   <table cellspacing="0" cellpadding="0" border="0" style="height:35px">
					<tbody>
					     <tr class="dialogTr">

							<td class="toolbarTd" style="width: 100%;" align="right"> 
								<a id='clxxAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="clxxAdd();">新增</a>
						    </td>
						</tr>
					</tbody>
		 </table> 
          <table id="clxxtable" class="easyui-datagrid"  style="height:200px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsClxx?zdryZjhm=${zdryZjhm}',
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			           	<th data-options="field:'zjhm',width:140,align:'center',halign:'center'">证件号码</th>			           
			            <th data-options="field:'clpp',width:120,align:'center',halign:'center',sortable:true">车辆品牌</th>
			            <th data-options="field:'cllx',width:120,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_CL_CLLX.js'">车辆类型</th>		         			        	
			            <th data-options="field:'clys',width:80,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_CL_CSYS.js'">车辆颜色</th>			         			        	
			        	<th data-options="field:'clhm',width:200,align:'center',halign:'center'">车辆号码</th>			         			        				            		         			        	
			        	<th data-options="field:'clly',width:200,align:'center',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_DW_CLHDFS.js'">车辆来源</th>			         			        				            		         			        	
			        	<th data-options="field:'gsr',width:120,align:'center',halign:'center'">归属人</th>			         			        				            		         			        	
			        	<th data-options="field:'clxxbh',width:120,align:'center',halign:'center'">车辆信息编号</th>			         			        				            		         			        				
			        	<th data-options="field:'process',align:'center',width:100,halign:'center',formatter:clxxFormater">操作</th>			        
			        </tr>
			    </thead>
		   </table>
		  
		</div>
  
          

