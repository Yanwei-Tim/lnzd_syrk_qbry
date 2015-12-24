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
    <title>地址核实和详情页面</title>
    <script type="text/javascript">
   	  var bjzbz = "<%=bjzbz%>";
      //以下参数主要是地图以及点气泡框用
      var zbx = "${entity.zbx}";
	  var zby = "${entity.zby}";
	  var dzmc = "${entity.dzmc}";
	  var xt_cjsj = "${entity.xt_cjsj}";
	  var xt_zxbz = "${entity.xt_zxbz}";
	  var xt_lrrxm = "${entity.xt_lrrxm}";
	  var zrqmc = "${entity.zrqmc}";
	  var pcsmc = "${entity.pcsmc}";
	  var dzbmArr = "${dzBmArray}";
	  var dzBmCount = parseInt("${dzBmArrayLength}");
	  var mlphqc = "${entity.mlphqc}";
	  var mldzid = "${entity.mldzid}";
	  var mainTabID = "${mainTabID}";
	  var type = "${type}";
	  var title = "";
	  if(type=="0"){
		  title = "地址核实";
	  }else{
		  title = "地址详情";
	  }
    </script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bzdz.css"></link>
    <script type="text/javascript" src="<%=contextPath%>/js/bzdz/dzCheck/dzCheckEdit.js"></script>
  </head>
  <body id="panelid" class="easyui-layout" data-options="fit:true">
      <div data-options="region:'west',title:''" style="width:380px;">
      		<form action="<%=basePath%>dz/updateHszt" id="dataForm" name="dataForm" method="post">
          	<table border="0" cellpadding="0" cellspacing="10" width="100%">
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">行政区划：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="text" id="xzqhdm" name="xzqhdm" class="easyui-combobox"
							  data-options="required:true,url: contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dataFilter:'.*[^00]$',
					                        method:'get',valueField:'id',textField:'text',selectOnNavigation:false,
					                        onLoadSuccess:function(){$('#xzqhdm').combobox('setValue','${entity.xzqhdm}');}" style="width:215px;"/>
				   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">地名：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="text" id="dmmc" name="dmmc" class="easyui-validatebox" value="${entity.dmmc}" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌前缀：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="hidden" name="mlphqzmc" id="mlphqzmc" value="">
		    	       <input type="text" id="mlphqz" name="mlphqz" class="easyui-combobox" value="${entity.mlphqz}"
							data-options="url: contextPath + '/common/dict/DZ_BZDZ_MLPHQZ.js',valueField:'id',textField:'text',
							              selectOnNavigation:false,method:'get',tipPosition:'left',
							              onLoadSuccess:function(){$('#mlphqz').combobox('setValue','${entity.mlphqz}');$('#mlphqzmc').val($('#mlphqz').combobox('getText'));},
							              onChange:function(rec,oldValue){$('#mlphqzmc').val($('#mlphqz').combobox('getText'));DzCheckEdit.setMlpqc();},
							              onSelect:function(rec){$('#mlphqzmc').val(rec.text);DzCheckEdit.setMlpqc();}" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌号：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input class="easyui-validatebox" type="text" id="mlph" name="mlph" style="width:215px;" value="${entity.mlph}" />
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌后缀：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="hidden" name="mlphhzmc" id="mlphhzmc">
		    	       <input type="text" id="mlphhz" name="mlphhz" class="easyui-combobox" value="${entity.mlphhz}"
							data-options="required:true,url: contextPath + '/common/dict/D_BZDZ_MLPHHZ.js',valueField:'id',textField:'text',
							              selectOnNavigation:false,method:'get',tipPosition:'left',
							              onLoadSuccess:function(){$('#mlphhz').combobox('setValue','${entity.mlphhz}');$('#mlphhzmc').val($('#mlphhz').combobox('getText'));},
							              onChange:function(rec,oldValue){$('#mlphhzmc').val($('#mlphhz').combobox('getText'));DzCheckEdit.setMlpqc();},
							              onSelect:function(rec){$('#mlphhzmc').val(rec.text);DzCheckEdit.setMlpqc();}" style="width:215px;"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">门楼牌全称：</td>
		    	   <td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" id="mlphqc" name="mlphqc" style="width:215px;" value="${entity.mlphqc}"/></td>
               </tr>
               <tr class="dialogTr">
                   <td class="dialogTd" colspan="2" width="100%">
                       	<table border="0" cellpadding="0" cellspacing="5" style="width: 100%;" align="center" id="dzBmTable">
                       	    <c:forEach items="${dzBmArray}" var="dzbmb" varStatus="status">
                       	         <c:if test="${status.index > 0}">
				                     <tr id="dzBmTr1${status.index}"><td height="5"></td></tr>
				                 </c:if>
				                 <tr class="dialogTr" id="dzBmTr2${status.index}">
				                     <td width="30%" class="dialogTd" align="right">地址别名：</td>
				                     <td width="70%" class="dialogTd">
				                         <input class="easyui-validatebox" type="text" id="dzbm_${status.index}" name="dzBmArray[${status.index}].dzbm" style="width:215px;" value="${dzbmb.dzbm}"/>
				                         <c:choose>
			                              	<c:when test="${status.index == 0}"><a class="addLine_btn" href="javascript:void(0);" title="增加一个地址别名" onclick="DzCheckEdit.addDzBm();"></a></c:when>
			                              	<c:otherwise><a class="delLine_btn" href="javascript:void(0);" title="注销当前地址别名" onclick="DzCheckEdit.delDzBm('${status.index}')"></a></c:otherwise>
			                             </c:choose>
				                     </td>
				                 </tr>
                       	    </c:forEach>
                       	</table>
                   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">责任区：</td>
		    	   <td width="70%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zrqmc" style="width:215px;" value="${entity.zrqmc}"/></td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">社区：</td>
		    	   <td width="70%" class="dialogTd">
		    	       <input type="text" id="sqmc" name="sqmc" class="easyui-validatebox" style="width:215px;" value="${entity.sqmc}"/>
		    	   </td>
               </tr>
               <tr class="dialogTr">
                   <td width="30%" class="dialogTd" align="right">地图错误反馈：</td>
		    	   <td width="70%" class="dialogTd">
		    	      <textarea id="dtcwfk" name="dtcwfk" class="easyui-validatebox" style="width:215px;height:45px;overflow: auto;">${entity.dtcwfk}</textarea>
		    	   </td>
               </tr>
            </table>
            <!-- 地理位置 -->
            <input type='hidden' name='zbx' id="zbx" value="${entity.zbx}"/>
            <input type='hidden' name='zby' id="zby" value="${entity.zby}"/>
            <input type='hidden' name='mldzid' id="mldzid" value="${entity.mldzid}"/>
            <input type='hidden' name='dmdm' id="dmdm" value="${entity.dmdm}"/>
        	</form>
            <div id="buttonDiv" style="text-align: center;">
				<a id="backButton" class="l-btn l-btn-small" href="javascript:void(0)" group="">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">退出</span>
						<span class="l-btn-icon icon-back"></span>
					</span>
				</a>
				<a id="hgButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" style="margin-left: 10px;">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text" id="saveId">核实</span>
						<span class="l-btn-icon icon-ok"></span>
					</span>
				</a>
				<a id="dtbdButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" style="margin-left: 10px;">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">标注</span>
						<span class="l-btn-icon icon-biaodian"></span>
					</span>
				</a>
				<a id="whchButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" style="margin-left: 10px;">
					<span class="l-btn-left l-btn-icon-left">
						<span class="l-btn-text">维护层户</span>
						<span class="l-btn-icon icon-home"></span>
					</span>
				</a>
				<a id="ckchButton" class="l-btn l-btn-small" href="javascript:void(0)" group="" style="margin-left: 10px;">
				<span class="l-btn-left l-btn-icon-left">
					<span class="l-btn-text">查看层户</span>
					<span class="l-btn-icon icon-home"></span>
				</span>
			</a>
			</div>
      </div>
      <div data-options="region:'center',border:false">
         <div id="tt" class="easyui-tabs" data-options="border:false,fit:true">
            <div title="地图">
               <div id="mapDiv"></div>
	           <div id="toolDiv" style="position:absolute;left:0px;top:0px;height:20px;filter:alpha(opacity=90);"></div>
            </div>
            <div title="层户" id="chDivId"></div>
         </div>
      </div>
  </body>
</html>