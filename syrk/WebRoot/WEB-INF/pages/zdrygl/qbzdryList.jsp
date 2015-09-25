<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>

<html>
  <head>
    <title>情报重点人员管理</title>
  <%--   <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "";
    </script> --%>
    <style type="text/css">
	.searchText {
	   font-size: 13px;
	   font-color: #222222;
	   height: 32px;
	   border: 1px solid #95B8E7;
	   line-height：32px;
	   padding-left: 5px;
	   padding-top: 8px;
	   width:200px;
	}
	
	</style>
	<script type="text/javascript">
	   		$(function(){
	   			alert(contextPath);
	   			//    /common/dict/GB_D_XBDM.js
	   			var xbmc = window.top.getDictName(contextPath+'/common/dict/D_BZ_XB.js',"1");
	   			alert(xbmc);
	   		});
	   	</script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'center',border:false" style="width:538px;">
       
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/zdryQbzdryxxb/list',
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(335),
		        		pageList:[getAutoPageSize(335),
		        		getAutoPageSize(335) * 2],
		        		singleSelect:true,
		        		fitColumns:true,
						toolbar:'#datagridToolbar'">
			        <thead>
			          <tr>
				            <th data-options="field:'zt',width:70,align:'left',sortable:true,halign:'center'">状态</th>
				            <th data-options="field:'zdryxl',width:120,align:'left',sortable:true,halign:'center'">重点人员细类</th>
				            <th  data-options="field:'xm',align:'left',halign:'center',sortable:true">姓名</th>
				            <th  data-options="field:'sfzh',width:120,align:'left',halign:'center',sortable:true">证件号码</th>
				            <th  data-options="field:'xb',width:120,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
				            <th  data-options="field:'mz',width:120,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_MZ.js'">民族</th>
				            <th  data-options="field:'jg',width:120,align:'left',halign:'center',sortable:true">籍贯</th>
				           	<th  data-options="field:'xzdxz',width:120,align:'left',halign:'center',sortable:true">现住地详址</th>
				           	<th  data-options="field:'hjdxz',width:120,align:'left',halign:'center',sortable:true">户籍地详址</th>
				           	<th  data-options="field:'gxdw',width:120,align:'left',halign:'center',sortable:true">管辖单位</th>
				           	<th  data-options="field:'bjzdrybh',width:120,align:'left',halign:'center',sortable:true">部级编号</th>
				           
				            <th data-options="field:'process',align:'center',width:100,halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
			       </thead>
	       </table>
	       <div id="datagridToolbar" style="padding:5px;height:auto">
				<form id="queryForm">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr class="dialogTr">
							    <td width="5%" class="dialogTd" align="right">姓名：</td>
						    	<td width="10%" class="dialogTd"><input type="text" name="xm" id ="xm" style="width:130px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]',url: contextPath + '/common/dict/BD_D_SYRKYWLXDM.js'"   /></td>
								<td width="8%" class="dialogTd" align="right">证件号码：</td>
						    	<td width="12%" class="dialogTd">
								<input class="easyui-validatebox" type="text" id="sfzh" name="sfzh" style="width:150px;"  data-options="required:false,validType:'maxLength[20]'" />
								</td>	
								<td width="5%" class="dialogTd" align="right">现居住地：</td>
						    	<td width="15%" class="dialogTd"><input type="text" name="xzdxz" id ="xzdxz" style="width:150px;" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"   /></td>

						       <td  width="45%"  class="dialogTd" align="left" colspan="4">
						                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton()">查询</a>
							            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
							           
					          </td>
					</tr>					
				</table>
				</form>
			</div>
	        
	  </div>
	  
   </body>
</html>
<script type="text/javascript">
 function datagridProcessFormater(val,row,index){
	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateAndXq(this, '+index+')">查看</a>&nbsp;' ;
};

 function doUpdateAndXq(linkObject, index){
	 alert(1);
	//阻止冒泡，不然要执行onClickRow
  /*   cancelBubble(); 
    var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
    menu_open(rowData.xm +'','/zdry/'+rowData.ryid+'/'+rowData.syrkid+'/view'+'?mainTabID='+getMainTabID()+'&mode=view'); */
};
//查询按钮
function queryButton(){
	
	var xm =$("#xm").val();
	var zjhm =$("#sfzh").val();
	var xzdxz =$("#xzdxz").val();
	$('#dg').datagrid(
			'load',
			{    
				'xm': xm,   
				'sfzh': zjhm ,
				'xzdxz':xzdxz
			});
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}

</script>