<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	 <div title="在逃属性" id="dwxx" style="height: 435px;">
          <table id="ztxx" class="easyui-datagrid"  style="height:400px"
           	data-options="url:'<%=basePath %>dtjsMore/moreDtjsZtxxb?zdryZjhm=${zdryZjhm}',
	           		selectOnCheck:true,
	        		checkOnSelect:true,
	        		rownumbers:true,
	        		border:false,
	        		singleSelect:true,
	        		fitColumns:false,
	        		nowrap:true">
			    <thead>
			        <tr>
			            <th data-options="field:'sslb',width:80,align:'left',halign:'center',sortable:false,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_ZDRYLBDM.js'">所属类别</th>
			            <th data-options="field:'ztlx',width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_ZTRYLBDM.js'">在逃类型</th>
			            <th data-options="field:'lasj',width:80,align:'left',halign:'center'">立案时间</th>
			            <th data-options="field:'ladwmc',width:120,align:'left',halign:'center'">立案单位</th>			         
			            <th data-options="field:'tpsj',width:80,align:'center',halign:'center'">逃跑时间</th>
			        	<th data-options="field:'tpfx',width:100,align:'left',halign:'center'">逃跑方向</th>
			        	<th data-options="field:'ltrq',width:80,align:'left',halign:'center'">立逃日期</th>
			        	<th data-options="field:'ltdwmc',width:100,align:'left',halign:'center'">立逃单位</th>
			        	<th data-options="field:'ajlbdm',width:120,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/XZ_D_AJLBDM.js'">案件类别</th>
			            <th data-options="field:'dbjb',width:100,align:'left',halign:'center'">督捕级别</th>
			        	<th data-options="field:'aqms',width:150,align:'left',halign:'center'">案情描述</th>			        
			        </tr>
			    </thead>
		   </table>
		  
		</div>
  
          

