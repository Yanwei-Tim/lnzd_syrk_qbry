<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人员档案</title>
<%-- <script type="text/javascript" src="<%=contextPath%>/js/syrkinfo-mould.js"></script> --%>
<%-- <script type="text/javascript" src="<%=contextPath%>/js/infoEdit.js"></script> --%>

<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/trace.css"></link>

<%-- <script type="text/javascript" src="<%=contextPath%>/common/jeasyui/windowTopPage.js"></script> --%>
<style>
.nameTable{ width:500px;height:auto;overflow:hidden;}
.nameTable tr{height:auto;}
.nameTable th{line-height:26px; color:#666;font-weight:normal;word-wrap:break-all;font-size:1.2rem;}
.nameTable td{line-height:20px; color:#333;word-wrap:break-all;font-size:1.2rem; }


/*本页面自定义样式 ******/
.operate-btns{width:400px;margin-left:180px;margin-top:20px;margin-bottom:20px;text-align:center}
#sendBack,#syrkAdd,#accept{margin-left:25px;}
#operate-track{width:400px;height:400px;margin:0 auto;}
/********************/

</style>
</head>

<body class="bodybg">
<div class="head"><div class="logo"></div></div>
<div class="bodydiv">
<div class="bodyer">
<div class="lf">
<!--框-->
<div class="lf_conta">
<div class="lf_contb">
<div class="lf_contc">
					<table width="100%" style="margin-left:100px;">
							<tr >
								<td valign="top" >
									<div class="pinfo1" >
									<ul>
										<li style="padding:0px;" >
										<table cellpadding="0" cellspacing="0" class="nameTable"  >
										 <tbody id="jbxxInfo">
											 <tr>
											      <th  align="right" >姓名：</th>
												  <td >${qbry.xm}</td>
												  <th  align="right" >证件号码：</th>
												  <td > ${qbry.gmsfhm}</td>
											 </tr>
											 <tr >
											      <th  align="right" >性别：</th>
												  <td width="90"><script type="text/javascript">  document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', "${qbry.xbdm}"));</script></td>
												  <th  align="right" >国籍：</th>
												  <td width="120"><script type="text/javascript">  document.write(window.top.getDictName(contextPath + '/common/dict/D_BZ_SJGGHDQMCDM.js', "${qbry.gjdm}"));</script></td>
											 </tr>
											 <tr>
											      <th  align="right" >参考居住地址(居住地)：</th>
												  <td  colspan="3" width="270">${qbry.jzd}</td>
											 </tr>
											 <tr>
											      <th  align="right" >实际居住地址(现住地)：</th>
												  <td  colspan="3" width="270">${qbry.xzd}</td>
											 </tr>
											 <tr >
											      <th  align="right" >户籍地址：</th>
												  <td  colspan="3" width="270">${qbry.hjd}</td>
											 </tr>
											 <tr >
											      <th  align="right" >当前级别：</th>
											      <td><script type="text/javascript">  document.write(window.top.getDictName(contextPath + '/common/dict/D_ORG_ORGLEVEL.js', "${qbry.dqjb}"));</script></td>
												  <th  align="right" >下发状态(管理状态)：</th>
												  <td><script type="text/javascript">  document.write(window.top.getDictName(contextPath + '/common/dict/BD_D_QBRYGLZT.js', "${qbry.glzt}"));</script></td>
											 </tr>
											 <tr >
											      <th  align="right" >责任单位：</th>
												  <c:if test="${qbry.dqjb == '10'}">
											      	<td width="90">${qbry.qbzd}</td>
											      </c:if>
												  <c:if test="${qbry.dqjb == '21'}">
											      	<td width="90">${qbry.qbdd}</td>
											      </c:if>
											      <c:if test="${qbry.dqjb == '32'}">
											      	<td width="90">${qbry.qbpcs}</td>
											      </c:if>
											      <c:if test="${qbry.dqjb == '50'}">
											      	<td width="90">${qbry.qbzrq}</td>
											      </c:if>
												  <th  align="right" >责任人：</th>
												  <td width="120">无字段</td>
											 </tr>
											 <tr >
											      <th  align="right" >联系电话：</th>
												  <td width="90">无字段</td>
												  <th  align="right" >入部省库时间：</th>
												  <td width="120">${qbry.bjzdryrksj}</td>
											 </tr>
											 <tr >
											      <th  align="right" >立案单位：</th>
												  <td width="90">${qbry.ladwmc}</td>
												  <th  align="right" >立案时间：</th>
												  <td width="120">${qbry.lasj}</td>
											 </tr>
										 </tbody>
										</table>
									</li>
								    </ul> 	
								</div>
							</td>
						</tr>
					</table>
					<div style="width:600px;height:210px;margin-left:110px;border:1px solid #ccc;">
						<!-- 业务操作记录  start -->
						<table id="operate-track"  class="easyui-datagrid" style="width:100%;height:200px;margin-left:20px;" title='业务操作记录表' 
			              	data-options="url:'<%=contextPath%>/qbryManager/ywList/${qbry.gmsfhm}',
			              	selectOnCheck:true,
			        		checkOnSelect:true,
			        		rownumbers:true,
			        		border:false,
			        		sortName:'',
			        		sortOrder:'desc',
			        		pageSize:5,
			        		pageList:[5],
			        		singleSelect:true,
			        		fitColumns:true">
					        <thead>
					          	<tr>
						            <th data-options="field:'czlb',width:100,align:'center',halign:'center',sortable:true">操作类别</th>
						            <th data-options="field:'gmsfhm',width:100,align:'center',sortable:true,halign:'center'">操作时间</th>
						            <th data-options="field:'bz',width:200,align:'center',sortable:true,halign:'center'">操作原因</th>
						            <th  data-options="field:'mbbmmc',width:100,align:'center',halign:'center',sortable:true">操作部门</th>
						            <th  data-options="field:'bz',width:100,align:'center',halign:'center',sortable:true">操作人</th>
						        </tr>
					       </thead>
				       </table>
					<!-- 业务操作记录  end -->
					</div>
					
					<!-- 功能按钮 start -->
					<div class="operate-btns">
						<a id="sendDown" href="#" class="easyui-linkbutton" >下发</a>
						<a id="sendBack" href="#" class="easyui-linkbutton"  onclick="sendBack()">申请回退</a>
						
						<!-- 责任区民警才能 添加实有人口以及 接收 -->
						<c:if test="${orgLevel == '50' }" >
						
						<c:if test="${qbry.syrkid == null }" >
						<a id="syrkAdd" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addSyrk()">新增实有人口</a>
						</c:if>
						
						<c:if test="${qbry.glzt != '9'}" >
						<a id="accept" href="#" class="easyui-linkbutton" onclick="acceptQbryWin()">接收</a>
						</c:if>
						</c:if>
					</div>			
					<!-- 功能按钮 end-->
					
					<!-- 情报人员接收窗口 -->
					<div id="acceptQbryDiv" class="easyui-window" title="情报人员接收"  data-options="iconCls:'icon-search',
		                collapsible:false,minimizable:false,maximizable:false,
				        modal:true,closed:true,width:600,height:200">
				        <div id="datagridToolbar" style="padding: 0px; height: 150px; width: 100%; vertical-align: top;">
				        <form id ="acceptForm" >		 
				        	<input type="hidden" name="id" id="id" value="${qbry.id }" />
				               
					        <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
						        
						        <tr class="dialogTr">
							    	<td width="20%" class="dialogTd" align="right">接收备注：</td>
							    	<td width="80%" class="dialogTd">
							    	    <textarea name="acceptBz" id="acceptBz" class="easyui-validatebox" style="width: 100%; height:48px;" data-options="required:false,validType:['maxLength[500]'],tipPosition:'left'"></textarea>
							    	</td>				    	
						    	</tr>	
						    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
							    	<td align="center" colspan="2">
							    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="acceptQbry();">确定</a>
							    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="acceptQbryWinClose()">关闭</a>
							    	</td>
						    	</tr>
					         </table>
					         
				        </form>
				        </div>
				   </div> 
				  <div id="sendBackDiv" class="easyui-window" title="申请退回"  data-options="iconCls:'icon-search',
		                collapsible:false,minimizable:false,maximizable:false,
				        modal:true,closed:true,width:600,height:200">				        
					    <form id="sendBackForm">  
					    <input type="hidden" name="id" id="id" value="${qbry.id }" /> 
					    <table border="0" cellpadding="0" cellspacing="10" width="100%" align="center">
						        
						        <tr class="dialogTr">
							    	<td width="20%" class="dialogTd" align="right">退回原因：</td>
							    	<td width="80%" class="dialogTd">
							    	    <textarea name="thyy" id="thyy" class="easyui-validatebox" style="width: 100%; height:48px;" data-options="required:false,validType:['maxLength[500]'],tipPosition:'left'"></textarea>
							    	</td>				    	
						    	</tr>	
						    	<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
							    	<td align="center" colspan="2">
							    		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="sendBackupdate()">确定</a>
							    		<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="sendBackWinClose()">关闭</a>
							    	</td>
						    	</tr>
					         </table>                  				        				                     
				        </form>   				        
				  </div> 
</div>

</div>
</div>
<!--/框-->
</div>
</div>
</div>
</body>
<script type="text/javascript">
	function addSyrk(){
		 menu_open('实有人口新增','/syrkGl/add?mainTabID='+getMainTabID()+'&zjhm=210211198906132911');
	}
	
	function acceptQbryWin(){//接收情报人员窗口
		$("#acceptBz").val("");
		$("#acceptQbryDiv").window("open");
	}
	
	function acceptQbryWinClose(){
		$("#acceptQbryDiv").window("close");
	}
	function acceptQbry(){
		var qbryId=$("#id").val();
		var qbryBz=$("#acceptBz").val();
		$.ajax({
			type: "POST",
			url: contextPath + "/qbryManager/saveLg",
			dataType: "json",
			data:"id=" + qbryId + "&bz=" + qbryBz,
			success: function(data) {
				if (data) {				
					if(data.status && data.status=="success"){
						alert("接收成功");
						acceptQbryWinClose();
						$("#accept").hide();
					}else{
						if(data.message){
							alert("接收失败："+data.message);
						}else{
							alert("接收失败："+data);
						}
						
					}
				}else{
					alert("接收失败："+data);
				}
			},		
			error: function(data) {
				alert("接收失败："+data);
			}
		});	
	}
 //申请回退	
  function sendBack(){	
		$("#sendBackDiv").window("open");		 
 }	
 function sendBackWinClose(){
	 $("#sendBackDiv").window("close");
 }
 function sendBackupdate(){
		var qbryId=$("#id").val();
		var thyy=$("#thyy").val();
		$.ajax({
			type: "POST",
			url: contextPath + "/qbryManager/htsq",
			dataType: "json",
			data:"id=" + qbryId + "&thyy=" + thyy,
			success: function(data) {
				if (data) {				
					if(data.status && data.status=="success"){
						alert("退回成功");
						acceptQbryWinClose();
						$("#accept").hide();
					}else{
						if(data.message){
							alert("退回失败："+data.message);
						}else{
							alert("退回失败："+data);
						}
						
					}
				}else{
					alert("退回失败："+data);
				}
			},		
			error: function(data) {
				alert("退回失败："+data);
			}
		});		 
 }
</script>
</html>
    