<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	  <div title="刑事犯罪前科信息" id="zdxsfzqkxxb" style="height: 435px;">
 	   <table cellspacing="0" cellpadding="0" border="0" style="height:35px">
					<tbody>
					     <tr class="dialogTr">

							<td class="toolbarTd" style="width: 100%;" align="right"> 
								<a id='zdxsfzqkxxbAdd' class="easyui-linkbutton" iconCls="icon-add" onclick="zdxsfzqkxxbAdd();">新增</a>
						    </td>
						</tr>
					</tbody>
		 </table> 
          <table id="zdxsfzqkxxbtable" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsZdxsfzqkxx?zdryZjhm=${zdryZjhm}',
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
			            <th data-options="field:'zasd',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_ZASD.js'">作案特点</th>
			           	<th data-options="field:'zagj',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_ZAGJ.js'">作案工具</th>			          
			            <th data-options="field:'zagjly',width:200,align:'left',halign:'center'">作案工具来源</th>	
			           	<th data-options="field:'zatd',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_ZATD.js'">作案特点</th>			          
			           	<th data-options="field:'xzdx',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XZDXDM.js'">选择对象</th>			          
			           	<th data-options="field:'xzwp',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XZWP.js'">选择物品</th>			          
			           	<th data-options="field:'xzcs',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_XZCS.js'">选择处所</th>			          
			           	<th data-options="field:'xzsj',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_QBLD_XZSJ.js'">选择时机</th>			          
			           	<th data-options="field:'sfthza',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SFDM.js'">是否团伙作案</th>			          
			          
			        	<th data-options="field:'process',align:'center',width:100,halign:'center',formatter:zdxsfzqkxxbFormater">操作</th>			        
			        </tr>                                                                                    
			    </thead>
		   </table>
		  
		</div>
  
          

