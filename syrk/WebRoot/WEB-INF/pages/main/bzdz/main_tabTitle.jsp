<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String closeImage = contextPath + "/common/skin/images/tab_close.gif";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>Tab菜单切换</title>
     <script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery1.11.min.js"></script>
     <script type="text/javascript" src="<%=contextPath%>/common/jeasyui/jquery.easyui.min.js"></script>
     <script type="text/javascript" src="<%=contextPath%>/common/jeasyui/mainTab.js"></script>
     <script type="text/javascript" src="<%=contextPath%>/common/jeasyui/tools.js"></script>
     <script type="text/javascript" src="<%=contextPath%>/common/jeasyui/global.js"></script>
     <script type="text/javascript" src="<%=contextPath%>/common/jeasyui/easyloader.js"></script>
     <link href="<%=contextPath%>/common/skin/tabnew.css" type="text/css" rel="stylesheet">
     <script type="text/javascript">
        var contextPath = "<%=contextPath%>";
        var blankURL = "about:blank";
     	function tabTitleBody_onload(){
     		init();
     	};
     </script>
  </head>
  <body class="tabBody" onload="tabTitleBody_onload()" onselect="document.selection.empty();" onselectstart="return false;" oncontextmenu="return false;">
      <noscript><iframe src="*.htm"></iframe></noscript>
      <table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" class="tabTable1">
		<tbody>
		   <tr><td height="1"></td></tr>
		</tbody>
	  </table>
	  <table border="0" cellpadding="0" cellspacing="0" align="center" width="100%" class="tabTable2">
	    <tbody>
	       <tr><td height="12">&nbsp;</td></tr>
	    </tbody>
	  </table>
	  <div id="divTitles" class="divTitles" style="left:0;">
	  
	     <table id="table0" border="0" cellpadding="0" cellspacing="0" style="left:4;" class="tableStart" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td0_1" width="12" class="tab_titleFirst3" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td0_2" width="54" class="tab_title32" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap ><div class="div_title2"></div><span id="titleName0">我的首页&nbsp;</span></td>
			  <td id="td0_3" width="5" class="tab_title33" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div style="width: 5px;"></div></td>
			</tr>
		 </table>
		 
		 <table id="table1" border="0" cellpadding="0" cellspacing="0" style="left:0;" class="tableOther" style="display: none;" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td1_1" width="12" class="tab_title11" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td1_2" width="54" class="tab_title12" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap><div class="div_title2"></div><span id="titleName1"></span></td>
			  <td id="td1_3" width="16" class="tab_title13" valign="top" onclick="tabTitle_close(this.id)" ondblclick="tabTitle_ondbClick()" onmouseover="close_onMouseOver(this.id);" onmouseout="close_onMouseOut(this.id);"><div class="div_title3"></div><div id="table1_close" class="div_close1" style="display:none;"></td>
			</tr>
		 </table>
		 
		 <table id="table2" border="0" cellpadding="0" cellspacing="0" style="left:0;" class="tableOther" style="display: none;" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td2_1" width="12" class="tab_title11" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td2_2" width="54" class="tab_title12" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap><div class="div_title2"></div><span id="titleName2"></span></td>
			  <td id="td2_3" width="16" class="tab_title13" valign="top" onclick="tabTitle_close(this.id)" ondblclick="tabTitle_ondbClick()" onmouseover="close_onMouseOver(this.id);" onmouseout="close_onMouseOut(this.id);"><div class="div_title3"></div><div id="table2_close" class="div_close1" style="display:none;"></td>
			</tr>
		</table>
		
		<table id="table3" border="0" cellpadding="0" cellspacing="0" style="left:0;" class="tableOther" style="display: none;" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td3_1" width="12" class="tab_title11" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td3_2" width="54" class="tab_title12" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap><div class="div_title2"></div><span id="titleName3"></span></td>
			  <td id="td3_3" width="16" class="tab_title13" valign="top" onclick="tabTitle_close(this.id)" ondblclick="tabTitle_ondbClick()" onmouseover="close_onMouseOver(this.id);" onmouseout="close_onMouseOut(this.id);"><div class="div_title3"></div><div id="table3_close" class="div_close1" style="display:none;"></td>
			</tr>
		</table>
		
		<table id="table4" border="0" cellpadding="0" cellspacing="0" style="left:0;" class="tableOther" style="display: none;" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td4_1" width="12" class="tab_title11" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td4_2" width="54" class="tab_title12" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap><div class="div_title2"></div><span id="titleName4"></span></td>
			  <td id="td4_3" width="16" class="tab_title13" valign="top" onclick="tabTitle_close(this.id)" ondblclick="tabTitle_ondbClick()" onmouseover="close_onMouseOver(this.id);" onmouseout="close_onMouseOut(this.id);"><div class="div_title3"></div><div id="table4_close" class="div_close1" style="display:none;"></td>
			</tr>
		</table>
			
		<table id="table5" border="0" cellpadding="0" cellspacing="0" style="left:0;" class="tableOther" style="display: none;" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td5_1" width="12" class="tab_title11" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td5_2" width="54" class="tab_title12" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap><div class="div_title2"></div><span id="titleName5"></span></td>
			  <td id="td5_3" width="16" class="tab_title13" valign="top" onclick="tabTitle_close(this.id)" ondblclick="tabTitle_ondbClick()" onmouseover="close_onMouseOver(this.id);" onmouseout="close_onMouseOut(this.id);"><div class="div_title3"></div><div id="table5_close" class="div_close1" style="display:none;"></td>
			</tr>
		</table>
			
		<table id="table6" border="0" cellpadding="0" cellspacing="0" style="left:0;" class="tableOther" style="display: none;" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td6_1" width="12" class="tab_title11" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td6_2" width="54" class="tab_title12" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap><div class="div_title2"></div><span id="titleName6"></span></td>
			  <td id="td6_3" width="16" class="tab_title13" valign="top" onclick="tabTitle_close(this.id)" ondblclick="tabTitle_ondbClick()" onmouseover="close_onMouseOver(this.id);" onmouseout="close_onMouseOut(this.id);"><div class="div_title3"></div><div id="table6_close" class="div_close1" style="display:none;"></td>
			</tr>
		</table>
			
		<table id="table7" border="0" cellpadding="0" cellspacing="0" style="left:0;" class="tableOther" style="display: none;" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td7_1" width="12" class="tab_title11" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td7_2" width="54" class="tab_title12" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap><div class="div_title2"></div><span id="titleName7"></span></td>
			  <td id="td7_3" width="16" class="tab_title13" valign="top" onclick="tabTitle_close(this.id)" ondblclick="tabTitle_ondbClick()" onmouseover="close_onMouseOver(this.id);" onmouseout="close_onMouseOut(this.id);"><div class="div_title3"></div><div id="table7_close" class="div_close1" style="display:none;"></td>
			</tr>
		</table>
			
		<table id="table8" border="0" cellpadding="0" cellspacing="0" style="left:0;" class="tableOther" style="display: none;" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td8_1" width="12" class="tab_title11" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td8_2" width="54" class="tab_title12" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap><div class="div_title2"></div><span id="titleName8"></span></td>
			  <td id="td8_3" width="16" class="tab_title13" valign="top" onclick="tabTitle_close(this.id)" ondblclick="tabTitle_ondbClick()" onmouseover="close_onMouseOver(this.id);" onmouseout="close_onMouseOut(this.id);"><div class="div_title3"></div><div id="table8_close" class="div_close1" style="display:none;"></td>
			</tr>
		</table>
			
		<table id="table9" border="0" cellpadding="0" cellspacing="0" style="left:0;" class="tableOther" style="display: none;" onmouseover="tabTitle_onMouseOver(this.id);" onmouseout="tabTitle_onMouseOut(this.id);">
			<tr>
			  <td id="td9_1" width="12" class="tab_title11" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()"><div class="div_title1"></div></td>
			  <td id="td9_2" width="54" class="tab_title12" valign="top" onclick="tabTitle_onClick(this.id)" ondblclick="tabTitle_ondbClick()" nowrap><div class="div_title2"></div><span id="titleName9"></span></td>
			  <td id="td9_3" width="16" class="tab_title13" valign="top" onclick="tabTitle_close(this.id)" ondblclick="tabTitle_ondbClick()" onmouseover="close_onMouseOver(this.id);" onmouseout="close_onMouseOut(this.id);"><div class="div_title3"></div><div id="table9_close" class="div_close1" style="display:none;"></td>
			</tr>
		</table>
	 </div>		
	 <div id="divScrollLeft" onmouseover="scrollLeft_mouseOver(this.className);" onmouseout="scrollLeft_mouseOut();" style="z-index: 3; position: absolute; top: 2px; left: 1px; width: 20px; height: 22px; font-size: 1px; display: none;" class="tab_scrollLeft1"></div>
	 <div id="divScrollRight" onmouseover="scrollRight_mouseOver(this.className);" onmouseout="scrollRight_mouseOut();" style="z-index: 3; position: absolute; top: 2px; left: 0px; width: 20px; height: 22px; font-size: 1px; display: none;" class="tab_scrollRight1"></div>
  </body>
</html>