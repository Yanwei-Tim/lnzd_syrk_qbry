<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String orglevel = "";
    String bjzbz = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        orglevel = userInfo.getUserOrgLevel();
        bjzbz = userInfo.getBjzbz();
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>涉公安访人员管理</title>
    <script type="text/javascript">
       var bjzbz = "<%=bjzbz%>";
       var orglevel = "<%=orglevel%>";
    </script>

    <script type="text/javascript" src="<%=contextPath%>/js/zdrygl/zdrySgafzdryGl.js"></script>
    <script type="text/javascript">

    $(function(){
    	if(orglevel == '32'){
    		$("#status_xfz").hide();
    		$("#query_searchStatus").combobox({
        		data:[{    
    	    	    "id":'dcl',    
    	    	    "text":"待处理"   
    	    	},{    
    	    	    "id":'yxf',    
    	    	    "text":"已下发"   
    	    	}]  
        	});
    	}else{
    		$("#query_searchStatus").combobox({
        		data:[{    
    	    	    "id":'dcl',    
    	    	    "text":"待处理"   
    	    	},{    
    	    	    "id":'yxf',    
    	    	    "text":"已下发"   
    	    	},{    
    	    	    "id":'xfz',    
    	    	    "text":"下发中"  
    	    	}]  
        	});
    	}
    	
    	
    })
    
	
    </script>
  </head>
  <body class="easyui-layout" data-options="fit:true,border:false">
     <div data-options="region:'west',border:false" style="width:540px;">
           <!-- 管理列表 -->
           <!-- onLoadSuccess:function(data){SgafzdryGl.loadPoint(data,'dg');}
						,onClickRow:SgafzdryGl.onClickRow -->
           <table id="dg" class="easyui-datagrid"
	              	data-options="url:'<%=contextPath%>/zdrySgafzdryGl/queryList',
	              		onLoadSuccess:function(data){SgafzdryGl.loadPoint(data,'dg');},
	              		onClickRow:SgafzdryGl.onClickRow,
						selectOnCheck:true,
		        		checkOnSelect:true,
		        		rownumbers:true,
		        		border:false,
		        		sortName:'xt_zhxgsj',
		        		sortOrder:'desc',
		        		pageSize:getAutoPageSize(105),
		        		pageList:[getAutoPageSize(105),
		        		getAutoPageSize(105) * 2],
		        		singleSelect:true,
		        		fitColumns:false,
		        		nowrap:true,
						toolbar:'#datagridToolbar'">
			        <thead>
			          <tr>
				        <th data-options="field:'xm',width:60,align:'center',sortable:true,halign:'center'">姓名</th>
				        <th data-options="field:'gmsfhm',width:120,align:'center',sortable:true,halign:'center'">身份证</th>
				        <th data-options="field:'jzd_dzxz',width:240,align:'left',sortable:true,halign:'center',formatter:SgafzdryGl.subjzddzxz">居住地址</th>
				        <th data-options="field:'process',width:80,align:'center',halign:'center',formatter:SgafzdryGl.datagridProcessFormater">操作</th>
			          </tr>
			       </thead>
	       </table>
           <!-- 查询条件 -->
           <div id="datagridToolbar" style="padding:5px;height:auto;">
				<table cellspacing="0" cellpadding="0" border="0" >
					<tbody>
					     <tr class="dialogTr">
							<td class="dialogTd" style="width: 60%;" align="center">
							    <input id="searchbox" class="easyui-searchbox" data-options="height:24,prompt:'请输入人员姓名、证件号码或居住地址',searcher:SgafzdryGl.doSearch,menu:'#mm'" style="width:340px"></input>
								<div id="mm" style="width:120px"> 
									<div data-options="name:'dcl'">待处理</div>
									<div id="status_xfz" data-options="name:'xfz'">下发中</div>
									<div data-options="name:'yxf'">已下发</div> 
								</div> 
							</td>
							<td class="dialogTd" style="width: 23%;" align="center">
								<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="SgafzdryGl.detailSearch()">精确查询</a>
							</td>
							<td class="toolbarTd" style="width: 17%;" align="center">
								<a id="dzaddid" class="easyui-linkbutton" iconCls="icon-add" onclick="SgafzdryGl.zdryAdd();">新增</a>
							</td>
						</tr>
					</tbody>
				</table>
           </div>
           <div id="win" class="easyui-window" title="涉公安访重点人员精确查询"  data-options="iconCls:'icon-search',
                collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:380,height:300">
		        <form id ="queryForm" >
			        <table id="jqcxTable" border="0" cellpadding="0" cellspacing="10" width="100%" height="100%" align="center" delayParse="true">
				        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">人员类型：</td>
					    	<td width="70%" class="dialogTd">
								<input class="easyui-combobox" id = "query_searchStatus" name ="searchStatus" 
								data-options="required:true,selectOnNavigation:false,isTopLoad:false,
									valueField: 'id',textField: 'text'"  style="width:180px;"/>
							</td>
					   	</tr>	
				        <tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">姓名：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input type="text" name="xm" id="query_xm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[20]'" style="width:180px;"/>
					    	</td>
				    	</tr>
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">身份证：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input type="text" name="gmsfhm" id ="query_gmsfhm" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:180px;"/>
					    	</td>
				    	</tr>	
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">性别：</td>
					    	<td width="70%" class="dialogTd">
					    	    <input class="easyui-combobox-delay" type="text" id="query_xbdm" name="xbdm" style="width:180px;"
									data-options="url: contextPath + '/common/dict/GB_D_XBDM.js',valueField:'id',textField:'text',selectOnNavigation:false,method:'get'"/>
						    </td>
				    	</tr>
				    	<tr class="dialogTr">
					    	<td width="30%" class="dialogTd" align="right">居住地：</td>
					    	<td width="70%" class="dialogTd">
					            <input type="text" name="jzd_dzxz" id ="query_jzd_dzxz" class="easyui-validatebox" data-options="required:false,validType:'maxLength[30]'" style="width:180px;"/>
					        </td>
				    	</tr>	
				    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
					    	<td colspan="2" align="right">
					    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="SgafzdryGl.queryButton();">确定</a>
					    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="SgafzdryGl.closeWindow('win');">关闭</a>
					    	</td>
				    	</tr>
			         </table>
		        </form>
		   </div>
		   
		   <!-- 市局下发页面 -->
		   <div id="ddtest">Dialog Content.</div> 
		   
		   <!-- 市局下发页面 -->
		   <div id="sjXiaFa" class="easyui-window" title="涉公安访人员下发"  data-options="collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:600,height:500">
		        <form id ="sjXiaFaForm" >
		        	市局下发页面
		        </form>
		   </div>
		   <!-- 分县局下发页面 -->
		   <div id="fxjXiaFa" class="easyui-window" title="涉公安访人员下发"  data-options="collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:600,height:500">
		        <form id ="fxjXiaFaForm" >
		        	分县局下发页面
		        </form>
		   </div>
		   <!-- 派出所下发页面 -->
		   <div id="pcsXiaFa" class="easyui-window" title="涉公安访人员下发"  data-options="collapsible:false,minimizable:false,maximizable:false,
		        modal:true,closed:true,width:600,height:500">
		        <form id ="pcsXiaFaForm" >
		        	派出所下发页面
		        </form>
		   </div>
     </div>
     <div data-options="region:'center',border:false">
	       <div id="mapDiv"></div>
	       <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
	  </div>
  </body>
</html>