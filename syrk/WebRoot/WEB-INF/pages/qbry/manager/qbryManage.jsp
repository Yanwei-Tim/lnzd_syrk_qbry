<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>重点人员管理</title>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
    </script>
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
	.table-toolbar{
		width:100%;
	}
	.table-toolbar .td-title{
		text-align:right;
		padding-top:15px;
	}
	.table-toolbar .td-value{
		text-align:left;
		padding-top:15px;
	}
	#datagridToolbar{
		padding-bottom:20px;
	}
	.td-btns-container{
		border-top:1px solid #ccc;
		padding-top:20px;
		padding-bottom:20px;
	}
	.td-btns{
		padding-top:15px;
	}
	#reset-btn,
	#dzaddid{
		margin-left:25px;
	}
	.td-value input, 
	.td-value input{
		width:160px;
		height:22px;
	}
	</style>
  </head>
   <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'center',border:false" style="width:538px;height:auto;">
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/qbryManager/queryList',
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'',
		        		sortOrder:'desc',
		        		pageSize:20,
		        		pageList:[10,20,30],
		        		singleSelect:true,
		        		fitColumns:true,
						toolbar:'#datagridToolbar'">
			        <thead>
			          <tr>
				            <th data-options="field:'zdrylb',width:100,align:'center',halign:'center',sortable:true">重点人员细类</th>
				            <th data-options="field:'xm',width:70,align:'center',sortable:true,halign:'center'">姓名</th>
				            <th data-options="field:'gmsfhm',width:100,align:'center',sortable:true,halign:'center'">身份证号码</th>
				            <th  data-options="field:'xbdm',width:30,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/GB_D_XBDM.js'">性别</th>
				            <th  data-options="field:'xzd',width:100,align:'center',halign:'center',sortable:true">现居住地址</th>
				            <th  data-options="field:'hjd',width:100,align:'center',halign:'center',sortable:true">户籍地址</th>
				            <th  data-options="field:'bjzdryrksj',width:100,align:'center',halign:'center',sortable:true">入部省库时间</th>
				            <th  data-options="field:'glzt',width:50,align:'center',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_QBRYGLZT.js'">管理状态</th>
				            <th data-options="field:'process',align:'center',width:100,halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
			       </thead>
	       </table>
	       <div id="datagridToolbar" style="padding:5px;height:auto;">
	       <form id ="queryForm" >
			<table cellspacing = "0" cellpadding="0" class="table-toolbar">
				<tr>
					<td class="td-title">重点人员大类:</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="zdrygllxdm" name="zdrygllxdm" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						<span>*字典未找到(用的性别字典)</span>
					</td>
					<td class="td-title">重点人员大细类:</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="zdrylb" name="zdrylb" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						<span>*字典未找到(用的性别字典)</span>
					</td>
					<td class="td-title">姓名：</td>
					<td class="td-value">
						<input type="text" name="xm" id="xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					</td>
				</tr>
				<tr>
					<td class="td-title">身份证号码:</td>
					<td class="td-value">
						<input type="text" name="gmsfhm" id="gmsfhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					</td>
					<td class="td-title">性别:</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					</td>
					<td class="td-title">国籍：</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="gjdm" name="gjdm" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/GB_D_GJHDQDM.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					</td>
				</tr>
				<tr>
					<td class="td-title">现居住地址:</td>
					<td class="td-value">
						<input type="text" name="xzd" id="xzd" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					</td>
					<td class="td-title">户籍地址:</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="hjd" name="hjd" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						<span>*字典未找到(用的性别字典)</span>
					</td>
					<td class="td-title">责任单位：</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="bjzdrybh" name="bjzdrybh" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						<span>*需求未明确</span>
					</td>
				</tr>
				<tr>
					<td class="td-title">当前级别:</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="dqjb" name="dqjb" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/D_ORG_ORGLEVEL.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					</td>
					<td class="td-title">下发状态:</td>
					<td class="td-value">
						<input class="easyui-combobox" type="text" id="glzt" name="glzt" style="width:180px;" 
								data-options="url: contextPath + '/common/dict/BD_D_QBRYGLZT.js',
								    	   valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
					</td>
					<td class="td-title">纪实时间:</td>
					<td class="td-value">
						<input class="easyui-combobox" data-options="width:180,height:22"/>
						<span>*数据表中未找到字段</span>
					</td>
				</tr>
				<tr>
					<td class="td-title">入部省库时间-开始:</td>
					<td class="td-value">
						<input type="text" name="xzd" id="xzd" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
						<span>*需求未确认</span>
					</td>
					<td class="td-title">入部省库时间-截止:</td>
					<td class="td-value" colspan="3">
						<input type="text" name="xzd" id="xzd" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
						<span>*需求未确认</span>
					</td>
				</tr>
				<tr>
					<td class="td-btns" colspan="6" align="center">
						<div class="td-btns-container">
							<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="queryButton()">查询</a>
							<a id="reset-btn" class="easyui-linkbutton"  href="javascript:void(0);" onclick="resetButton()">重置</a>
							<a id="dzaddid" class="easyui-linkbutton"  data-options="iconCls:'icon-add'" onclick="add()">新增</a>
						</div>
					</td>
				</tr>
			</table>
			</form>
        </div>
	        
	  </div>
	  
	 
   </body>
</html>
<script type="text/javascript">
 function add(){
	 location.href="<%=contextPath%>/qbryManager/qbryadd";
 }
 

 
 /**
  * @title:doUpdateAndXq
  * @description:地址维护
  * @author: zhang_guoliang@founder.com
  * @param type
  *            0为可编辑、1为只读，dzChb地址层户表 0为层户地址对象表、1为层户地址审核表
  * @date:2015-02-04 18:23:35
  */
doUpdateAndXq = function(linkObject, index) {
 	// 阻止冒泡，不然要执行onClickRow
 	cancelBubble();
 	var rows = $('#dg').datagrid('getData');
 	var rowData = rows.rows[index];
 	menu_open(rowData.xm + '', '/qbryManager/' + rowData.id + '/view?mainTabID=' + getMainTabID());
 };
 
 /**
  * @title:datagridProcessFormater
  * @description:列表操作
  * @author: zhang_guoliang@founder.com
  * @param
  * @date:2014-12-26 10:47:21
  */
datagridProcessFormater = function(val, row, index) {
 	return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doUpdateAndXq(this, '
 			+ index + ')">编辑</a>&nbsp;';
 };
 
 /**
  * @title:queryButton
  * @description:精确查询【确定】
  * @author: zhang_guoliang@founder.com
  * @param 
  * @date:2015-04-14 18:42:43
  */
 queryButton = function(){
 	/* //清除【空间查询】图层
 	if(SyrkQuery.drawType == "" || SyrkQuery.drawZbz ==""){
 		SyrkQuery.drawType = "";
 		SyrkQuery.map.clearGraph();
 	} */
 	var zdrygllxdm = document.getElementById("zdrygllxdm").value;
 	var xm = document.getElementById("xm").value;
 	var zdrylb = document.getElementById("zdrylb").value;
 	var gmsfhm = document.getElementById("gmsfhm").value;
 	var xbdm = document.getElementById("xbdm").value;
 	var gjdm = document.getElementById("gjdm").value;
 	var xzd = document.getElementById("xzd").value;
 	var hjd = document.getElementById("hjd").value;
 	//责任单位不确定
 	var bjzdrybh = document.getElementById("bjzdrybh").value;
 	
 	var dqjb = document.getElementById("dqjb").value;
 	var glzt = document.getElementById("glzt").value;
 	
 	//gem 需求说只按照年龄，不按照年龄段
 	/* var ageTemp = document.getElementById("age").value;
 	var year = new Date().getFullYear();
 	var age = "";
 	if (ageTemp!=null && ageTemp!='') {
 		age = year - ageTemp;
 	} */
 	
 	
 	/* var jzd_dzxz = document.getElementById("jzd_dzxz").value; */
 	//var searchbox = $('#searchbox').searchbox('getValue');
 	$('#dg').datagrid('load',{    
 		'dqjb':dqjb,
 		'zdrygllxdm':zdrygllxdm,
 		'xm':xm,
 		'zdrylb':zdrylb,
 		'gmsfhm':gmsfhm,
 		'xbdm':xbdm,
 		'glzt':glzt,
 		'xzd':xzd,
 		'hjd':hjd,
 		'bjzdrybh':bjzdrybh,
 		'gjdm': gjdm
 	});
 	/* alert("a"); */
 	if(zdrygllxdm != null || zdrygllxdm != ""){
 		document.getElementById("zdrygllxdm").value = zdrygllxdm;
 	}
 	if(xm != null || xm != ""){
 		document.getElementById("xm").value = xm;
 	}
	if(zdrylb != null || zdrylb != ""){
		document.getElementById("zdrylb").value = zdrylb;
 	}
 	if(gmsfhm != null || gmsfhm != ""){
 		document.getElementById("gmsfhm").value =  gmsfhm;
 	}
	if(xbdm != null || xbdm != ""){
		document.getElementById("xbdm").value = zdrygllxdm;
 	}
 	if(gjdm != null || gjdm != ""){
 		document.getElementById("gjdm").value = gjdm;
 	}
	if(xzd != null || xzd != ""){
		document.getElementById("xzd").value = xzd;
 	}
 	if(hjd != null || hjd != ""){
 		document.getElementById("hjd").value = hjd;
 	}
	if(bjzdrybh != null || bjzdrybh != ""){
		document.getElementById("bjzdrybh").value = bjzdrybh;
 	}
 	if(dqjb != null || dqjb != ""){
 		document.getElementById("dqjb").value = dqjb;
 	}
	if(glzt != null || glzt != ""){
		document.getElementById("glzt").value = glzt;
 	}
 };
 
resetButton = function(){
		$("#queryForm").form("reset");
	};
</script>