<!--  
	@Author:       [xu_haibo@founder.com.cn]
	@CreateDate:   [2015-6-14 下午13:51:54]
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
    }
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript">
			var mainTabID = "${mainTabID}";
			var zrqdm = "<%=userOrgCode%>";
			var ryList = ${list};
			$(document).ready(function(){
			initAddressSearch('fzd3',  {zrqdm:zrqdm}, 'dz_zzdzmlpdm', 'dz_zzdzmlpxz', 'fzd4', {text:'dz_zzdzxz',dzxzqh:'dz_zzdzssxqdm',id:'dz_zzdzdm'}, null, null);
			//多选框初始化
			initXDZB();
			var flag = document.getElementById("flag").value;
});
		</script>
		<title>人防信息</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/syrk.css"></link>
		<script type="text/javascript" src="<%=contextPath%>/js/aqff/rfxx/aqffRfxxadd.js"></script>
	</head>
	<body class="easyui-layout">
		<div data-options="region:'center', split:true" style="width:80%border-width: 0px;margin:0 0 0;" align="center" class="bodybg">
			<div data-options="region:'north', split:true" >
				<table height="60%" width="80%"  style="margin:0 auto;border: 1" align="center"><tr><td height="100%" valign="top" align="center">
					<div class="pop_conta">
						<div class="pop_contb">
							<div class="pop_contc">
								<form action="<%=basePath%>rfxxb/saveRfxx" id="dataForm" name="dataForm" method="post">
									<input type="hidden" id="flag" value="${flag}">
									<table border="0" cellpadding="0" cellspacing="10" width="width:500px;" align="center" border-collapse="collapse">
										<input type="hidden" id="pk" name="id" value="${entity.id}" />
										<input type="hidden" id="xldx" name="xldx" value="${entity.xldx}" />
										<input type="hidden" id="xldy" name="xldy" value="${entity.xldy}" />
										<input type="hidden" id="xlqy" name="xlqy" value="${entity.xlqy}" />
										<input type="hidden" id="xlqy" name="xlqy" value="${entity.xlqy}" />
										<input type="hidden" id="ryAll" name="ryAll" />
										<tr class="dialogTr" >
											<td width="85px" class="dialogTd" align="right">组织名称：</td>
									    	<td width="" class="dialogTd">
								   	        	<input class="easyui-validatebox" type="text" id="zzmc"  name="zzmc" value="${entity.zzmc}"  onblur="checks(this);"
								   	        	style="width:;" data-options="required:true,validType:['maxLength[100]'],tipPosition:'right'" />
								   	        </td>
									        <td width="85px" class="dialogTd" align="right">组织类别：</td>
									    	<td width="" class="dialogTd">
									    	<input class="easyui-combobox" id="zzlbdm" name="zzlbdm" value="${entity.zzlbdm}" 
									    		style="width:" data-options="required:false,url: contextPath + '/common/dict/BD_D_ZZLB.js',
									    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
											</td> 
										</tr>
										<tr class="dialogTr">
									    	<td  width="" class="dialogTd" align="right">组织地址：</td>
										    <td class="td2">
											    <input class="easyui-combobox" id="fzd3"  style="width:" 
											    value="${entity.dz_zzdzmlpxz}" 
											    data-options="required:false,mode:'remote'
											    ,method:'post',panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
										    	<input type='hidden' name='dz_zzdzmlpdm' id="dz_zzdzmlpdm" value="${entity.dz_zzdzmlpdm}"/>
										    	<input type='hidden' name='dz_zzdzmlpxz' id="dz_zzdzmlpxz" value="${entity.dz_zzdzmlpxz}"/>
										    </td>
										    <td class="td2" align="left" colspan="2">
											    <input class="easyui-combobox"  id="fzd4" style="width:228px;" 
											    value="${fn:replace(entity.dz_zzdzxz,entity.dz_zzdzmlpxz, '')}"
											    data-options="required:false,mode:'remote',method:'post'
											    ,panelHeight: 22,valueField:'id',textField:'text',selectOnNavigation:false">
										    	<input type='hidden' name='dz_zzdzdm' id="dz_zzdzdm" value="${entity.dz_zzdzdm}"/>
										    	<input type='hidden' name='dz_zzdzssxqdm' id="dz_zzdzssxqdm" value="${entity.dz_zzdzssxqdm}"/>
										    	<input type='hidden' name='dz_zzdzxz' id="dz_zzdzxz" value="${entity.dz_zzdzxz}"/>
										    </td>
								    		<td width="85px" class="dialogTd" align="right">隶属关系：</td>
									    	<td width="" class="dialogTd">
									    		<input class="easyui-combobox" id="lsggdm" name="lsggdm" value="${entity.lsggdm}" 
									    		style="width:" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_LSGX.js',
									    		valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>	
											</td> 
										</tr>
										<tr class="dialogTr">
									    	<td width="" class="dialogTd" align="right">防范组织形式：</td>
									    	<td width="" class="dialogTd">
									    		<input class="easyui-combobox" id="ffzzxsdm" name="ffzzxsdm" value="${entity.ffzzxsdm}" 
									    			style="width:" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_ZZXS.js',
									    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',
									    			tipPosition:'right',onSelect:function(newValue,oldValue){}"/>
											</td> 
											<td width="" class="dialogTd" align="right">组建日期：</td>
											<td width="" class="dialogTd">
												<input type="text" name="zjrq" id="zjrq" class="easyui-validatebox " style="width: ;" value="${entity.zjrq}"
													data-options="validType:['date[\'yyyy-MM-dd\']'],tipPosition:'right'" 
													onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" /></td>
											<td width="" class="dialogTd" align="right">经费来源：</td>
									    	<td width="" class="dialogTd">
							    	        	<input class="easyui-combobox" type="text" id="jflydm" name="jflydm" value="${entity.jflydm}"
							    	        	style="width: " maxlength="50" data-options="required:false,url: contextPath + '/common/dict/BD_D_JFLY.js',
									    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
							    	        </td>
										</tr>	
										<tr class="dialogTr">
				    	      			    <td width="" class="dialogTd" align="right">防范方式：</td>
								    		<td width="" class="dialogTd">
								    			<input class="easyui-combobox" id="fffsdm" name="fffsdm" value="${entity.fffsdm}" 
								    			style="width:" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_FFFS.js',
								    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>	</td>
								    		<td width="" class="dialogTd" align="right">是否治安承包：</td>
								    		<td width="" class="dialogTd">
								    			<input class="easyui-combobox" id="sfzacbdm" name="sfzacbdm" value="${entity.sfzacbdm}" 
								    			style="width:;" data-options="required:false,url: contextPath + '/common/dict/D_BZ_SF.js',
								    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'left'"/>	</td>
								    		<td width="" class="dialogTd" align="right">携带装备：</td>
								    		<td width="68px" class="dialogTd" rowspan="3" >
							    	 			<input type="checkbox" name ="xdzbdm" value="1"/>胶皮警棍
							    	 			<input type="checkbox" name ="xdzbdm" value="2"/>齐眉棍
							    	 			<input type="checkbox" name ="xdzbdm" value="3"/>对讲机
							    	 			<input type="checkbox" name ="xdzbdm" value="4"/>警用喷射器
							    	 			<input type="checkbox" name ="xdzbdm" value="5"/>钢叉
							    	 			<input type="checkbox" name ="xdzbdm" value="6"/>手电筒
							    	 			<input type="checkbox" name ="xdzbdm" value="7"/>防刺背心
							    	 			<input type="checkbox" name ="xdzbdm" value="8"/>防割手套
							    	 			<input type="hidden" id="hxdsb" value="${entity.xdzbdm}"/>
											</td> 
										</tr>
										<tr class="dialogTr">
											<td colspan="2" align="left">	 
										    	<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"   onclick="pointbiaozhu();">巡逻点</a>&nbsp;&nbsp;
												<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"   onclick="areabiaozhu();">巡逻区域</a>
											</td>
										 	<td width="" class="dialogTd" align="right" >巡逻区域：</td>
									    	<td width="" class="dialogTd">
									    		<input class="easyui-combobox" id="xlqydm" name="xlqydm" value="${entity.xlqydm}" 
									    			style="width:" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_DYLB.js',
									    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>	
							    	        </td>
										</tr >
										<tr class="dialogTr">
									    	<td width="" class="dialogTd" align="right">组织联系方式：</td>
									    	<td width="" class="dialogTd">
							    	        	<input class="easyui-validatebox" type="text" id="zzlxfs" name="zzlxfs" value="${entity.zzlxfs}"
							    	        	style="width: ;" data-options="validType:['naturalNumber','maxLength[50]'],validType:['phone'],tipPosition:'right'"/>
							    	        </td>
									    	<td width="" class="dialogTd" align="right">组织传真号码：</td>
									    	<td width="" class="dialogTd">
									    		<input class="easyui-validatebox" type="text" id="zzczhm" name="zzczhm"
							    	 			value="${entity.zzczhm}"  style="width:;" data-options="validType:['maxLength[50]'],validType:['phone'],tipPosition:'left'"/>
											</td> 
										</tr>
										<tr class="dialogTr">
									    	<td width="" class="dialogTd" align="right">责任范围：</td>
									    	<td width="" class="dialogTd">
									    	<input class="easyui-combobox" type="text" id="zrfwdm" name="zrfwdm"
							    	 			value="${entity.zrfwdm}" maxlength="200" style="width:;" 
							    	 				data-options="required:false,url: contextPath + '/common/dict/BD_D_ZRFWDM.js',
									    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
											</td> 
											<td width="" class="dialogTd" align="right">防范部位：</td>
									    	<td width="" class="dialogTd">
							    	        	<input class="easyui-combobox" type="text" id="ffbwdm" name="ffbwdm" value="${entity.ffbwdm}"
							    	        	style="width: ;" maxlength="200" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_DYLB.js',
									    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>
							    	        </td>
							    	        <td width="" class="dialogTd" align="right">地域类别：</td>
									    	<td width="" class="dialogTd">
									    		<input class="easyui-combobox" id="dylbdm" name="dylbdm" value="${entity.dylbdm}" 
									    			style="width:;" data-options="required:false,url: contextPath + '/common/dict/D_ZAFF_DYLB.js',
									    			valueField:'id',textField:'text',selectOnNavigation:false,method:'get',tipPosition:'right'"/>	
							    	        </td>
										</tr>
										<tr class="dialogTr">
									    	<td width="85px" class="dialogTd" align="right">作用情况：</td>
									    	<td width="" class="dialogTd"  colspan="5">
									    		<input class="easyui-validatebox" type="text" id="zyqk" name="zyqk"
							    	 				value="${entity.zyqk}"  style="width:716px;" data-options="validType:['maxLength[200]'],tipPosition:'right'"/>
											</td> 
										</tr>
										<tr class="dialogTr">
								    	    <td width="85px" class="dialogTd" align="right">备注：</td>
								    	    <td width="" class="dialogTd" colspan="5">
								    	    	<textarea id="bz" name="bz"  class="easyui-validatebox" rows="1" style="width:716px; height:52px;"
													data-options="validType:['maxLength[1000]'],invalidMessage:'备注不能超过1000个汉字，请重新输入！',tipPosition:'left'">${entity.bz}</textarea>
											</td>
										</tr>
									</table>
								</form>
							</div>
						</div>
					</div> 
			    	<div id="saveDiv" style="text-align:center; height:50px; padding-top: 10px; display:block;">
						<a id="saveBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">保存</span>
								<span class="l-btn-icon icon-save"> </span>
							</span>
						</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="backBotton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
							<span class="l-btn-left l-btn-icon-left">
								<span class="l-btn-text">退出</span>
								<span class="l-btn-icon icon-back"> </span>
							</span>
						</a>
					</div>
				</td>
			</tr>
		</table>
	</div> 
	<div data-options="region:'center', split:true" style="width:870px; margin:0 0 0;border-width: 0px; height:250px;">
		<div class="easyui-tabs" style="height: auto;" id="xxk" style="width:870px;">  
			<div title="组织人员名单"  >
	    		<div id="dg1" data-options="region:'center',split:true,title:'人防成员',border:true" style="height:250px;width:867px;">
    		 		<table id="dg0" class="easyui-datagrid" data-options="
		            		singleSelect:false,
		            		fitColumns:false,
		            		toolbar:'#datagridToolbar',
		            		border:false,
		            		sortName:'xt_zhxgsj',
		            		sortOrder:'asc',
		            		idField:'id',
		            		pageSize:getAutoPageSize(),
		            		selectOnCheck:true,
		            		checkOnSelect:true,
		            		pagination:false,
		            		pageList:[getAutoPageSize(),getAutoPageSize() * 2]">
						<thead>
					        <tr>	        
					        	<th data-options="checkbox:true,align:'center',halign:'center'"></th>
					        	<th data-options="field:'zjhm',width:200,align:'left',sortable:true,halign:'center'">证件号码</th>
					        	<th data-options="field:'xm',width:100,align:'left',sortable:true,halign:'center'">姓名</th>
					        	<th data-options="field:'xbdm',width:100,align:'left',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+'/common/dict/D_BZ_XB.js'">性别</th>
					        	<th data-options="field:'zjlxdm',width:200,align:'left',sortable:true,halign:'center',formatter:dictFormatter,dictName:contextPath+ '/common/dict/D_BZ_CYZJ.js'">证件种类</th>
					        	<th data-options="field:'dz_jzdzxz',width:350,align:'left',sortable:true,halign:'center'">居住地址</th>
					        	<th data-options="field:'process',align:'center',halign:'center',formatter:processFormater">操作</th>
					        	<th data-options="hidden:true,field:'whcddm',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'zzmmdm',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'rylydm',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'zznzw',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'lxfs',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'cjsj',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'dz_jzdzmlpdm',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'dz_jzdzmlpxz',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'dz_jzdzdm',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'dz_jzdzssxqdm',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'cylbdm',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'bz',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'gzdw',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'dwid',width:350,align:'left',sortable:true,halign:'center'"></th>
					        	<th data-options="hidden:true,field:'id',width:350,align:'left',sortable:true,halign:'center'"></th>
					        </tr>
						</thead>
					</table>
					<div id="datagridToolbar"  style="padding:5px;height:20px;width:100%" >
						<!-- 表格工具条按钮 -->
						<form id="queryForm">
							<table cellspacing="0" cellpadding="0" border="0" width="100%">
								<tbody>
									<tr>
										<td class="toolbarTd" align="right" colspan="7" style="padding-right:8px">
											<a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-add"  onclick="rfryxxAdd(this);">新增</a>
										</td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>	
	</body>
	<script type="text/javascript" >

</script>
</html>
