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
	<title>实有单位查询</title>
	<script type="text/javascript">
	  var userOrgCode = "<%=userOrgCode%>"; 
      var bjzbz = "<%=bjzbz%>";
	  var markerArr = new Array();
	  var dz_dwdzdmArr = new Array();
	  var dwmcArr = new Array();
	</script>
	<script type="text/javascript" src="<%=contextPath%>/js/sydw/sydwQuery.js"></script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	 <div data-options="region:'west',border:false" style="width:528px;">
           	<table id="dg" class="easyui-datagrid" 
            		data-options="url:'<%=basePath %>sydwcx/queryDw?flag=jsq',
            		delayCountUrl:'<%=basePath %>sydwcx/queryCountDw?flag=jsq',
            		toolbar:'#datagridToolbar',
            		rownumbers:true,
            		idField:'id',
            		sortOrder:'desc',
            		sortName:'',
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		fitColumns:true,
            		pageSize:getAutoPageSize(230),
            		pageList:[getAutoPageSize(230),getAutoPageSize(230) * 2],
            		onClickRow:onClickRow,
            		onLoadSuccess:function(data){loadpoints(data);},
            		fitColumns:true,
            		singleSelect:true">
				    <thead>
				        <tr>
				            <th data-options="field:'jgjbdm',width:60,align:'left',halign:'center',formatter:jgjbdm">监管级别</th>
				            <th data-options="field:'dwlbdm',width:60,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_SDWLXDM.js',sortable:true">类别</th>
				            <th data-options="field:'dwmc',width:160,align:'left',halign:'center',sortable:true">单位名称</th>
				            <th data-options="field:'dz_dwdzxz',width:160,align:'left',halign:'center',formatter:subjzdz,sortable:true">单位地址</th>
				            <th data-options="field:'process',width:40,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<table cellspacing="0" cellpadding="0" border="0">
						<form id="queryForm"> 
							<tr class="dialogTr">
								<td class="dialogTd" align="right">管辖市(县)局：</td>
								<td class="dialogTd"><input type="text" name="gxsxj" id ="gxsxj" class="easyui-combobox" style="width:170px;"
									data-options="valueField:'id',textField:'text',url:'<%=basePath %>gzjk/queryOrg',onSelect:function(rec){
					            	var url = '<%=basePath %>gzjk/queryOrgLower?orgCode='+rec.id;$('#gxpcs').combobox('reload', url);}" />
					            </td>
					            <td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
								<td class="dialogTd" align="right">管辖派出所：</td>
								<td class="dialogTd">
									<input type="text" id="gxpcs" name="gxpcs" style="width:170px;" class="easyui-combobox"  data-options="valueField:'id',textField:'text',required:false"/>
								</td>
							</tr>
							<tr class="dialogTr">
								<td class="dialogTd" align="right">单位类型：</td>
					    		<td class="dialogTd">
								<input class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
							        style="width:170px;" data-options="url: contextPath + '/common/dict/BD_D_SDWLXDM.js',onlyLeaf:true,multiple:false,
								     method:'get',editable:true,lines:true"/>
								</td>
								<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
						    	<td class="dialogTd" align="right">单位名称：</td>
						    	<td class="dialogTd">
									<input  type="text" id="dwmc" name="dwmc" style="width:170px;"
										class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'"	/>
								</td>
					   		</tr>	
					    <tr class="dialogTr">
					    	<td class="dialogTd" align="right">经营范围(主营)：</td>
					    	<td class="dialogTd"><input type="text" id="jyfwzy" name="jyfwzy"  style="width:170px;"
					    		class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'"/>
					    	<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
					    	<td class="dialogTd" align="right">经济类型：</td>
					    	<td class="dialogTd"><input class="easyui-combobox" type="text" id="jyxzdm" name="jyxzdm" style="width:170px;"
								data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/></td>
					    </tr>							
						<tr class="dialogTr">
					    	<td class="dialogTd" align="right">单位地址：</td>
					    	<td class="dialogTd">
					    		<input type="text" id="dz_dwdzxz" name="dz_dwdzxz" style="width:170px;" class="easyui-validatebox" 
					    			data-options="required:false,validType:'maxLength[30]'"/>
					    	</td>
					    	<td class="toolbarTd"><div class="datagrid-btn-separator"></div></td>
							<td class="dialogTd" align="right"" colspan="2">
								<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="queryButton()">查询</a>
								 &nbsp;&nbsp;
								<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a>
							</td>
						</tr>
					</form>
				</table>
			</div>
	</div>
	<div data-options="region:'center',border:false">
       <div id="mapDiv"></div>
       <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
  	</div>
    <input type="hidden" id ="zbz" value="">
    <input type="hidden" id ="type" value="">
    <input type="hidden" id ="mapRadius" value="">
</body>
</html>