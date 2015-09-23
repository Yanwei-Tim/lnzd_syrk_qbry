<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ page import="com.founder.framework.config.SystemConfig" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单位治安管理</title>
	<script type="text/javascript">
       var userOrgCode = "<%=userOrgCode%>"; 
       var bjzbz = "<%=bjzbz%>";
       var chAddress = "<%=SystemConfig.getString("chAddress")%>";
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
	.searchIcon {
		width:28px;
		height:28px;
   		background: url('<%=contextPath%>/images/search_icon.png') no-repeat center;
   		cursor: pointer;
	}
	.imgStyle{
		height:19px;
		width:19px;
	}
</style>
</head>
<script type="text/javascript" src="<%=contextPath%>/js/sydw/dwzajcList.js"></script>
<body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'west',border:false" style="width:540px;">
          	<table id="dg" class="easyui-datagrid" 
            		data-options="url:'<%=basePath %>sydw/list',
            		selectOnCheck:true,
            		checkOnSelect:true,
            		border:false,
            		sortName:'',
            		sortOrder:'desc',
            		idField:'id',
            		pageSize:getAutoPageSize(120),
            		pageList:[getAutoPageSize(120),
            		getAutoPageSize(120) * 2],
            		onLoadSuccess:function(data){ loadpoints1(data);},
            		onSelect:onSelectRow,
            		singleSelect:true,
            		fitColumns:true,
            		rownumbers:true,
            		toolbar:'#datagridToolbar'">
				    <thead>
				        <tr>
				            <th data-options="field:'dwlbdm',	width:80,align:'left',halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/BD_D_DWLXDM.js',sortable:true">类别</th>
				            <th data-options="field:'dwmc',		width:120,align:'left',halign:'center',sortable:true">单位名称</th>
				            <th data-options="field:'dz_dwdzxz',	width:200,align:'right',halign:'center',formatter:subjzdz,sortable:true">单位地址</th>
				            <th data-options="field:'process',width:100,align:'center',halign:'center',formatter:datagridProcessFormater">操作</th>
				        </tr>
				    </thead>
				</table>
				<div id="datagridToolbar" style="padding:5px;height:auto">
					<table border="0" cellpadding="0" cellspacing="2" width="100%"	align="center">
						<tr>
							<td align="left" width="40%">
								<input type="text" class="searchText" name="condition"  id="condition" value="请输入单位名称、地址信息" 
										style="color:gray;height:32px;font-size:13px;width:240px"  onclick="setDzqc(this)" onkeydown="passwordOnkeyPress(this)" />
							</td>
							<td align="left" width="15%">
								<img src ="<%=contextPath%>/images/search_btn_sousuo_01.png" style="cursor: pointer;height:32px;margin-top: 4px;" onclick="searchMain();"/>
							</td>
							<td width="45%">
								<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-search" onclick="detailSearch()">精确查询</a>
							</td>
						</tr>
						<tr>
							<td align="left" width="100%" colspan="3">
								<a href="javascript:void(0)" class="easyui-linkbutton"   onclick="doAllCheck();">所有检查列表</a>&nbsp;
								<a href="javascript:void(0)" class="easyui-linkbutton"   onclick="doAllPunish();">所有处罚列表</a>
								<a href="javascript:void(0)" class="easyui-linkbutton"   onclick="doJcFormatPrint();">检查模板打印</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
    <!-- 精确查询框 -->
	<div id="win" class="easyui-window" title="实有单位精确查询"
		style="width:400px;height:350px;top:20px;display:none;"
		data-options="iconCls:'icon-search',collapsible:false,minimizable:false,maximizable:false,modal:true,closed:true,top:100,width:400,height:280,left:50">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'left'">
				<form id="queryForm">
					<table border="0" cellpadding="0" cellspacing="10" width="100%"
						height="100%" align="center">
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">单位类型：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-combotree" type="text" id="dwlbdm" name="dwlbdm"
								style="width:150px;"
								data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:210,
									method:'get',editable:true,lines:true" />
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">单位名称：</td>
							<td width="70%" class="dialogTd">
								<!-- data-options="url: contextPath + '/common/dict/D_RK_ZDRYLX.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" -->
								<input type="text" id="dwmc" name="dwmc" style="width:150px;"
								class="easyui-validatebox"
								data-options="required:false,validType:'maxLength[20]'" /></td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">单位地址：</td>
							<td width="70%" class="dialogTd"><input type="text"
								id="dz_dwdzxz" name="dz_dwdzxz" class="easyui-validatebox"
								data-options="required:false,validType:'maxLength[30]'"
								style="width:150px;" /></td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">经营范围(主营)：</td>
							<!-- data-options="url: contextPath + '/common/dict/D_BZ_MZ.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" -->
							<td width="70%" class="dialogTd"><input type="text"
								id="jyfwzy" name="jyfwzy" style="width:150px;"
								class="easyui-validatebox"
								data-options="required:false,validType:'maxLength[30]'" /></td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">经营性质：</td>
							<td width="70%" class="dialogTd"><input
								class="easyui-combobox" type="text" id="jyxzdm" name="jyxzdm"
								style="width:150px;"
								data-options="url: contextPath + '/common/dict/D_BZ_JYXZDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'" />
							</td>
						</tr>
						<tr class="dialogTr">
							<td width="30%" class="dialogTd" align="right">单位地址状态：</td>
							<td width="70%" class="dialogTd"><input type='checkbox'
								id='ybzdz' />有标准地址 <input type='checkbox' id='wbzdz' />无标准地址</td>
						</tr>
						<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
							<td width="100%" colspan="2" align="right">
							<a class="easyui-linkbutton" iconCls="icon-ok"onclick="queryButton();">确定</a> 
							<a class="easyui-linkbutton" iconCls="icon-reset" onclick="resetButton()">重置</a> 
							<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWindow();">关闭</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<!-- 检查模板打印 -->
	<div id="print" class="easyui-window" title="检查模板打印"
		style="width:600px;height:300px;top:20px;display:none;"
		data-options="collapsible:false,minimizable:false,maximizable:false,modal:true,closed:true,top:50,width:600,height:300,left:50">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'left'">
				<form id="queryPrintForm">
					<table border="0" cellpadding="0" cellspacing="5" width="100%" height="100%" align="center">
						<tr class="dialogTr">
							<td width="15%" class="dialogTd" align="right">单位类型：</td>
							<td width="30%" class="dialogTd" align="left">
								<input class="easyui-combotree" type="text" id="dwlbdm_p" name="dwlbdm_p"
								style="width:180px;" data-options="url: contextPath + '/common/dict/BD_D_DWLXDM.js',onlyLeaf:true,multiple:false,panelWidth:250,panelHeight:190,
								method:'get',editable:true,lines:true,required:true,tipPosition:'left'"/>
							</td>
							<!-- 
							<td width="15%" class="dialogTd" align="right">单位名称：</td>
							<td width="35%" class="dialogTd" align="left">
								<input class="easyui-combobox" type="text" id="dwmc_p" data-options="mode:'remote',method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false,required:true"
								style="width:180px;" />
							</td>
							 -->
						</tr>
						<tr class="dialogTr">
						<td width="15%" class="dialogTd" align="right" >检查模板：</td>
						<td width="70%" class="dialogTd" colspan="3">
							<span style="display: none;"></span>
							<input type="radio" name="ywlbdm" id="ywlbdm" checked value="04" openurl="dwjcxxb/add"/>治安/内保 
							<input type="radio" name="ywlbdm" id="ywlbdm" value="11" openurl="dwjcxxb/addXf"/>三级消防单位
							<input type="radio" name="ywlbdm" id="ywlbdm" value="12" openurl="dwjcxxb/add"/>环保单位 
							<input type="radio" name="ywlbdm" id="ywlbdm" value="13" openurl="dwjcxxb/add"/>保安单位 
							<input type="radio" name="ywlbdm" id="ywlbdm" value="14" openurl="dwjcxxb/addJf"/>技防单位
						</td>
						</tr>
						<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
							<td width="100%" colspan="4" align="center">
							<a class="easyui-linkbutton" iconCls="icon-print" onclick="queryPrint()">打印</a>
							<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="closePrint();">关闭</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	
	<div data-options="region:'center',border:false">
      <div id="mapDiv"></div>
      <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
   </div>
</body>
<script type="text/javascript">
//---------------框查-----
var addressPrefix = "<%=SystemConfig.getString("addressPrefix")%>";
var addressPrefixArray = addressPrefix.split(",");

//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}
</script>  

</html>