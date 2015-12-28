<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp" %>
<%@ include file="/WEB-INF/pages/commonMap.jsp"%>
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
.nameTable th{line-height:26px; color:#666;font-weight:normal;word-wrap:break-all;}
.nameTable td{line-height:20px; color:#333;word-wrap:break-all; }


/*本页面自定义样式 ******/
.operate-btns{width:400px;margin-left:270px;margin-top:20px;margin-bottom:20px;}
#sendBack,#syrkAdd,#accept{margin-left:25px;}
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
					<table width="100%" style="margin-left:200px;">
							<tr >
								<td valign="top" align="center" style="width:200px; display:none;">
									<div class="pphoto_1" style="text-align: center;" >
										<div>
											<img id="topPhotoid" width="160"
												height="200" alt="" />
										</div>
									</div>
									<div style="padding-left: 15px;">
										<c:if test="${mode != 'view'}">
										    <a href="javascript:void(0);" info="ryid_main,RY_RYJBXXB,ryid_main,人员基本信息表"
											class="addphoto"></a>
										</c:if>
									</div>
								</td>
								
								<td valign="top" style="margin-left:50px;">
									<div class="pinfo1" >
									<ul>
										<li style="padding:0px;" >
										<table cellpadding="0" cellspacing="0" class="nameTable" style="margin-left: 10px" >
										<tr>
											<td colspan="4" align="left" valign="top" >
												<strong><span id="jbxx_xm" style="padding-left: 56px;">${ry.xm }</span>
												<c:if test="${zdry != ''}">
												<span>&nbsp;&nbsp;<a href="javascript:void(0);" onclick="openZdrk('${ry.xm }','${ry.id}','${syrkid}')">
												
												<script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/DL_D_ZDRYGLLXDM.js', "${zdry}"));</script>
												</a></span>
												</c:if>
												</strong>
											</td>
										 </tr>
										 <tbody id="jbxxInfo">
										 <tr>
										      <th  align="right" width="100">姓名：</th>
											  <td width="120"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/KX_D_CYZJDM.js', "${ry.cyzjdm}"));</script></td>
											  <th  align="right" width="100">证件号码：</th>
											  <td width="120"> ${ry.zjhm}</td>
										 </tr>
										 <tr >
										      <th  align="right" width="100">性别：</th>
											  <td width="90">${ry.csrq}</td>
											  <th  align="right" width="100">国籍：</th>
											  <td width="120"><script type="text/javascript"> document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XBDM.js', "${ry.xbdm}"));</script></td>
										 </tr>
										 <tr>
										      <th  align="right" width="100">参考居住地址：</th>
											  <c:choose>
											  <c:when test="${ry.hjd_dzxz !=null}">
											  <td  colspan="3" width="270">${ry.hjd_dzxz }</td>	
											  </c:when>
											  <c:otherwise>
											  <td  colspan="3" width="270">${ry.hjd_mlpxz}</td>	
											  </c:otherwise>
											  </c:choose>
											  </td>
										 </tr>
										 <tr >
										      <th  align="right" width="100">户籍地址：</th>
											  <c:choose>
											  <c:when test="${ry.hjd_dzxz !=null}">
											  <td  colspan="3" width="270">${ry.hjd_dzxz }</td>	
											  </c:when>
											  <c:otherwise>
											  <td  colspan="3" width="270">${ry.hjd_mlpxz}</td>	
											  </c:otherwise>
											  </c:choose>
											  </td>
										 </tr>
										 <tr >
										      <th  align="right" width="100">重点人员类别：</th>
											  <c:choose>
											  <c:when test="${ry.hjd_dzxz !=null}">
											  <td  colspan="3" width="270">${ry.hjd_dzxz }</td>	
											  </c:when>
											  <c:otherwise>
											  <td  colspan="3" width="270">${ry.hjd_mlpxz}</td>	
											  </c:otherwise>
											  </c:choose>
											  </td>
										 </tr>
										 <tr >
										      <th  align="right" width="100">当前级别：</th>
											  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', "${ry.gjdm}"));</script></td>
											  <th  align="right" width="100">下发状态：</th>
											  <td width="120"> ${ry.wwx}  ${ry.wwm}</td>
										 </tr>
										 <tr >
										      <th  align="right" width="100">责任单位：</th>
											  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XZQHDM.js', "${ry.jgssxdm}"));</script></td>
											  <th  align="right" width="100">责任人：</th>
											  <td width="120"><script type="text/javascript"> document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', "${ry.jggjdqdm}"));</script></td>
										 </tr>
										 <tr >
										      <th  align="right" width="100">联系电话：</th>
											  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XZQHDM.js', "${ry.jgssxdm}"));</script></td>
											  <th  align="right" width="100">入部省库时间：</th>
											  <td width="120"><script type="text/javascript"> document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', "${ry.jggjdqdm}"));</script></td>
										 </tr>
										 <tr >
										      <th  align="right" width="100">立案单位：</th>
											  <td width="90"><script type="text/javascript">document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_XZQHDM.js', "${ry.jgssxdm}"));</script></td>
											  <th  align="right" width="100">立案时间：</th>
											  <td width="120"><script type="text/javascript"> document.write(window.top.getDictName(contextPath + '/common/dict/GB_D_GJHDQDM.js', "${ry.jggjdqdm}"));</script></td>
										 </tr>
										 
										 </tbody>
										 
										</table>
									</li>
								    </ul> 	
								   <a href="javascript:void(0);" class="" onclick="moreInfoMethod();" id="moreButton" style="margin-left: 70px;width: 40px">更多</a>													
								</div>
							</td>
						</tr>
					</table>
						<!-- 业务操作记录  start -->
					<div class="operate-track" style="margin-left:175px;">
						<table  class="easyui-datagrid" title='业务操作记录表'
			              	data-options="url:'<%=contextPath%>/qbryManager/queryList'
			              	">
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
					</div>
					<!-- 业务操作记录  end -->
					<!-- 功能按钮 start -->
					<div class="operate-btns">
						<a id="sendDown" href="#" class="easyui-linkbutton" >下发</a>
						<a id="sendBack" href="#" class="easyui-linkbutton" >申请回退</a>
						<a id="syrkAdd" href="#" class="easyui-linkbutton" >新增实有人口</a>
						<a id="accept" href="#" class="easyui-linkbutton" >接受</a>
					</div>			
					<!-- 功能按钮 end-->
					
</div>

</div>
</div>
<!--/框-->
</div>
</div>
</div>
</body>
<script type="text/javascript">

</script>
</html>
    