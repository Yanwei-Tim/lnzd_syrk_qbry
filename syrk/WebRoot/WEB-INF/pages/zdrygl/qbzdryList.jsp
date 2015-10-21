<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<html>
  <head>
    <title>情报重点人员管理</title>
    <script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/sydw/sydw.js"></script>
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
	<!--  
	<script type="text/javascript">
   		$(function(){
   			var xbmc = window.top.getDictName(contextPath+'/common/dict/D_BZ_XB.js',"1");
   		});
   	</script>
   	-->
  </head>
  <script type="text/javascript" src="<%=contextPath%>/js/zdrygl/qbzdryList.js"></script>
  <body class="easyui-layout" data-options="fit:true,border:false">
       <div data-options="region:'west',border:false" style="width:538px;">
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/zdryQbzdryxxb/list',
	              	    onLoadSuccess:function(data){loadpoints1(data);},
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
				            <th data-options="field:'zdryxl',width:70,align:'left',sortable:true,halign:'center'">重点人员细类</th>
				            <th data-options="field:'xm',align:'left',halign:'center',sortable:true">姓名</th>
				            <th data-options="field:'sfzh',width:70,align:'left',halign:'center',sortable:true">证件号码</th>
				          <!--   
				            <th  data-options="field:'xb',width:120,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
				            <th  data-options="field:'mz',width:120,align:'left',halign:'center',sortable:true,formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_MZ.js'">民族</th>
				            <th  data-options="field:'jg',width:120,align:'left',halign:'center',sortable:true">籍贯</th>
				             -->
				           	<th  data-options="field:'sftjbgsq',width:120,align:'left',halign:'center',sortable:true,hidden:true">sftjbgsq</th>
				           	<th  data-options="field:'sjsfjjbgsq',width:120,align:'left',halign:'center',sortable:true,hidden:true">sjsfjjbgsq</th>
				           	<th  data-options="field:'xjspsfty',width:120,align:'left',halign:'center',sortable:true,hidden:true">xjspsfty</th>
				           	
				           	<th  data-options="field:'gxdw',width:70,align:'left',halign:'center',sortable:true">管辖单位</th>
				            <th  data-options="field:'process',align:'center',width:100,halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
			       </thead>
	       </table>
	        <div id="datagridToolbar" style="padding:5px;height:auto">
				<table border="0" cellpadding="0" cellspacing="10" width="100%"	align="center">
					<tr>
						<td align="right" >
							<input type="text" class="searchText" name="condition"  id="condition" value="请输入重点人员证件号码、姓名或居住地址" 
									style="color:gray;height:32px;font-size:13px;width:220px" charSet="halfUpper" onclick="setDzqc(this)" onkeydown="passwordOnkeyPress(this)" />
						</td>
						<td align="left">
							<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px" onclick="searchMain();"/>
						</td>
						<td  width="200px;">
							<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="detailSearch()">精确查询</a>
						</td>						
					</tr>
				</table>
			</div>
	        
	  </div>
	  <div id="win" class="easyui-window" title="情报重点人员精确查询" style="width:400px;height:300px;top:20px"   
		        data-options="iconCls:'icon-search',
		        collapsible:false,
		        minimizable:false,
		        maximizable:false,
		        modal:true,
		        closed:true,
		        top:100,
		        width:400,
		        height:260,
		        left:50">   
	          <div data-options="region:'left'">  
		        <form id ="queryForm" >
			        <table border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center">
				       <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">重点人员类型：</td>
					    	<td width="70%" class="dialogTd">
								<input class="easyui-combobox" type="text" id="zdrygllxdm" name="zdrygllxdm" style="width:150px;"
								data-options="url: contextPath +'/zdryzb/queryZdryTopLbList',valueField:'lbdm',textField:'bz',selectOnNavigation:false,method:'get'"/>
								</td>
					   	</tr>	
				        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">姓名：</td>
					    	<td width="70%" class="dialogTd"><input type="text" name="xm" id ="xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"  style="width:150px;" /></td>
					    </tr>
					    <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">身份证号码：</td>
					    	<td width="70%" class="dialogTd"><input type="text" id="sfzh" name="sfzh" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  style="width:150px;" /></td>
					    </tr>	
					    <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">性别：</td>
					    	<td width="70%" class="dialogTd"><input class="easyui-combobox" type="text" id="xbdm" name="xbdm" style="width:150px;"
								data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
					    </tr>	  
					    <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">居住地址：</td>
					    	<td width="70%" class="dialogTd"><input type="text" name="dz_jzdzxz" id ="dz_jzdzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"  style="width:150px;" /></td>
					    </tr>	
					    <tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td width="100%" colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="queryButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
					    	</td>
					    </tr>
			         </table>
			       </form>
	        </div> 
	   </div>
	  <div data-options="region:'center',border:false">
	       <div id="mapDiv"></div>
	       <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
	  </div>
   </body>
</html>
