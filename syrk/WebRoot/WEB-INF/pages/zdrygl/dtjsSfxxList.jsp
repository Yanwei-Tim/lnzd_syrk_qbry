<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	  <div title="上访信息" id="sfxx" style="height: 435px;">
 	   <table cellspacing="0" cellpadding="0" border="0" style="height:35px">
					<tbody>
					     <tr class="dialogTr">

							<td class="toolbarTd" style="width: 100%;" align="right"> 
								<a id='sfxxAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="sfxxAdd();">新增</a>
						    </td>
						</tr>
					</tbody>
		 </table> 
          <table id="sfxxtable" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsSfxx?zdryZjhm=${zdryZjhm}',
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
			            <th data-options="field:'ssqt',width:120,align:'left',halign:'center'">所属群体</th>
			            <th data-options="field:'sfdd',width:200,align:'left',halign:'center'">上访地点</th>	
			            <th data-options="field:'bbdwmc',width:200,align:'left',halign:'center'">包保单位名称</th>			         			        	
			            <th data-options="field:'bbld',width:200,align:'left',halign:'center'">包保领导</th>			         			        	
			            <th data-options="field:'sffs',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_SFFS.js'">上访方式</th>			         			        	
			            <th data-options="field:'czjg',width:200,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_CZJG.js'">处置结果</th>			         			        				            		         			        	
			        	<th data-options="field:'czry',width:200,align:'left',halign:'center'">处置人员</th>			         			        				            		         			        	
			        	<th data-options="field:'sqjb',width:200,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_SQJB.js'">诉求级别</th>			         			        				            		         			        	
			        	<th data-options="field:'sfxf',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SFDM.js'">是否息访</th>			         			        				            		         			        	
			        	<th data-options="field:'yjjb',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_YJJB.js'">预警级别</th>			         			        				            		         			        	
			        	<th data-options="field:'lxdh',width:120,align:'left',halign:'center'">联系电话</th>			         			        				            		         			        	
			        	<th data-options="field:'zyyy',width:120,align:'left',halign:'center'">主要原因</th>			         			        				            		         			        	
			        	<th data-options="field:'zysq',width:120,align:'left',halign:'center'">主要事情</th>			         			        				            		         			        	
			        	<th data-options="field:'sfgcms',width:120,align:'left',halign:'center'">上访过程描述</th>			         			        				            		         			        	
			        	
			        	<th data-options="field:'process',align:'center',width:100,halign:'center',formatter:sfxxFormater">操作</th>			        
			        </tr>
			    </thead>
		   </table>
		  
		</div>
  
          

