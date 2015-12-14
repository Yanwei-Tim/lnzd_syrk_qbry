<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	 <div title="涉案信息" id="saxx" style="height: 435px;">
          <table id="saxx" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsSaxxb?zdryZjhm=${zdryZjhm}',
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			            <th data-options="field:'zjhm',width:150,align:'left',halign:'center',sortable:false">证件号码</th>
			            <th data-options="field:'ajbh',width:100,align:'left',halign:'center'">案件编号</th>
			            <th data-options="field:'ajlb',width:120,align:'left',halign:'center'">案件类型</th>			         
			            <th data-options="field:'fasj',width:100,align:'center',halign:'center'">发案时间</th>
			        	<th data-options="field:'fadd',width:140,align:'left',halign:'center'">发案地点</th>
			        	<th data-options="field:'jyaq',width:400,align:'left',halign:'center'">简要案情</th>		        
			        </tr>
			    </thead>
		   </table>
		  
		</div>
  
          

