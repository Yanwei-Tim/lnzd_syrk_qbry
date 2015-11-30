<!--  
	@Author: [xu_haibo@founder.com]
	@CreateDate:   [2015-6-29 上午8:51:54]
-->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技防检查工作流程查看</title>
<style>
	td{
		width: 90px;
		font-size:13px;
		text-align:center;
		font-size:12px;
		line-height:20px;
		font-weight:bold;
	}
	
	.workflow_done{
		height: 90px;
		background: url(/syrk/images/sydw/workflow_status_done.png) center;
		background-repeat: no-repeat;
	}
	
	.workflow_next{
		height: 90px;
		background: url(/syrk/images/sydw/workflow_status_next.png) center;
		background-repeat: no-repeat;
	}
	
	.workflow_yet{
		height: 90px;
		background: url(/syrk/images/sydw/workflow_status_yet.png) center;
		background-repeat: no-repeat;
	}
	
	.workflow_right{
		background: url(/syrk/images/sydw/workflow_right.png) center;
		background-repeat: no-repeat;
	}
	
	.workflow_bellow{
		height: 70px;
		background: url(/syrk/images/sydw/workflow_bellow.png) center;
		background-repeat: no-repeat;
	}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<table cellpadding="0" cellspacing="6" width="100%" style="margin-top: 50px">
			<tr class="dialogTr">
				<td id="td_jctz" class="workflow_yet" onMouseOver="showMenu('jctz',0,0)" >
					检查通知
				</td>
				<td class="workflow_right"></td>
				<td id="td_kzjc" class="workflow_yet" onMouseOver="showMenu('kzjc',0,180)">开展检查</td>
				<td class="workflow_right"></td>
				<td id="td_zlzg" class="workflow_yet" onMouseOver="showMenu('zlzg',0,360)">责令整改</td>
				<td class="workflow_right"></td>
				<td id="td_fc" class="workflow_yet" onMouseOver="showMenu('fc',0,540)">复查</td>
				<td class="workflow_right"></td>
				<td  id="td_zxzaj"class="workflow_yet" onMouseOver="showMenu('zxzaj',0,720)">转行政案件</td>
			</tr>
			
			<tr class="dialogTr">
				<td></td>
				<td></td>
				<td class="workflow_bellow"></td>
				<td></td>
				<td></td>
				<td></td>
				<td class="workflow_bellow"></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr class="dialogTr">
				<td></td>
				<td></td>
				<td id="td_jcyj" class="workflow_yet" onMouseOver="showMenu('jcyj',170,180)">检查意见</td>
				<td></td>
				<td></td>
				<td></td>
				<td id="td_fcjcyj" class="workflow_yet" onMouseOver="showMenu('fcjcyj',170,560)">复查意见</td>
				<td></td>
				<td></td>
			</tr>
			
		</table>
	</div>
	
	
	<!-- 流程菜单，默认都是隐藏的 -->
	
	<!-- 检查通知 -->
	<div id="m_jctz" class="easyui-menu" style="width:150px;" data-options="">  
	</div>
	
	<!-- 开展检查 -->
	<div id="m_kzjc" class="easyui-menu" style="width:150px;">   
	</div>
	
	<!-- 责令整改 -->
	<div id="m_zlzg" class="easyui-menu" style="width:150px;">   
	</div>
	
	<!-- 复查 -->
	<div id="m_fc" class="easyui-menu" style="width:150px;">   
	</div>
	
	<!-- 转行政案件 -->
	<div id="m_zxzaj" class="easyui-menu" style="width:150px;">   
	</div>
	
	<!-- 检查意见 -->
	<div id="m_jcyj" class="easyui-menu" style="width:150px;">   
	</div>
	
	<!-- 复查检查意见 -->
	<div id="m_fcjcyj" class="easyui-menu" style="width:150px;">   
	</div>
</body>
</html>
<script type="text/javascript">
	var mainTabID = "${mainTabID}";
	var jcid = null;
	var jczt = null;
	var menuNameArray = ["m_jctz","m_kzjc","m_zlzg","m_fc","m_zxzaj","m_jcyj","m_fcjcyj"];
	var winId = null;
	var dwid = null;
	var dwlbdm = null;
	function doInit(paramArray) {
		jcid = paramArray.jcid;
		jczt = paramArray.jczt;
		dwid = paramArray.dwid;
		dwlbdm = paramArray.dwlbdm;
		winId = paramArray.winId;
		initWorkflowStatus();
		initMenus();
	}
	
	function beforeSubmit() {
		
	}
	
	function afterSubmit(arr) {
		executeTabPageMethod(mainTabID, "queryButton()");
		if (arr["saveID"]) {
			
		}
	}
	
	function closeWin(){
		window.parent.$('#'+winId).dialog('close');
	}
	
	function initMenus(){
		
		if($('#td_jctz').attr('class') == 'workflow_next'){
			$('#m_jctz').menu('appendItem', {
				text: '新增检查通知',
				onclick: function(){
					
					var editUrl = basePath+"jfjfjctz/addJfjfjctzs?dwid="+dwid+"&dwlbdm="+dwlbdm+"&ywlbdm=14"+"&mainTabID="+mainTabID+"&jcid="+jcid;
					window.top.openWindowWithSave(false, null, window, null, 
				   		{title: '单位检查通知书',url: editUrl,width: 880,inline:true,height:500}, 
				   		null, null,null
				   	);
					closeWin();
				}
			});
			$('#m_jctz').menu('appendItem', {
				text: '新增通知书存根',
				onclick: function(){
					
					var editUrl = basePath+"jfjfjctz/addJfjfjctzscg?mainTabID="+mainTabID+"&jcid="+'${entity.id}';
					window.top.openWindowWithSave(false, null, window, null, 
				   		{title: '单位检查通知书存根',url: editUrl,width: 880,inline:true,height:500}, 
				   		null, null,null
				   	);
					closeWin();
				}
			});
		}else{
			$('#m_jctz').menu('appendItem', {
				text: '预览检查通知',
				onclick: function(){
					
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jfjfjctzs";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					
					closeWin();
				}
			});
			$('#m_jctz').menu('appendItem', {
				text: '预览通知书存根',
				onclick: function(){
					
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jfjfjctzscg";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					
					closeWin();
				}
			});
		}
		
		//开展检查
		if($('#td_kzjc').attr('class') == 'workflow_next'){
			$('#m_kzjc').menu('appendItem', {
				text: '新增检查记录',
				onclick: function(){
					var editUrl = basePath+"dwjcxxb/addJfdwjcjl?dwid="+dwid+"&dwlbdm="+dwlbdm+"&ywlbdm=14"+"&mainTabID="+mainTabID+"&jcid="+jcid;
					window.top.openWindowWithSave(false, null, window, null, 
				   		{title: '单位技防检查记录',url: editUrl,width: 880,inline:true,height:500}, 
				   		null, null,null
				   	);
					closeWin();
				}
			});
			$('#m_kzjc').menu('appendItem', {
				text: '新增检查记录表',
				onclick: function(){
					var editUrl = basePath+"dwjcxxb/addJfdwjcjlb?dwid="+dwid+"&dwlbdm="+dwlbdm+"&ywlbdm=14"+"&mainTabID="+mainTabID+"&jcid="+jcid;
					window.top.openWindowWithSave(false, null, window, null, 
				   		{title: '单位技防检查记录表',url: editUrl,width: 880,inline:true,height:500}, 
				   		null, null,null
				   	);
				}
			});
		}else{
			$('#m_kzjc').menu('appendItem', {
				text: '预览检查记录',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jfdwjcjl";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					closeWin();
				}
			});
			$('#m_kzjc').menu('appendItem', {
				text: '预览检查记录表',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jfdwjcjlb";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					closeWin();
				}
			});
		}
		
		//责令整改
		if($('#td_zlzg').attr('class') == 'workflow_next'){
			$('#m_zlzg').menu('appendItem', {
				text: '新增整改通知',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/addJfzltzs?mainTabID="+mainTabID+"&jcid="+jcid;
					window.top.openWindowWithSave(false, null, window, null, 
				   		{title: '责令整改通知书',url: editUrl,width: 880,inline:true,height:500}, 
				   		null, null,null
				   	);
					closeWin();
				}
			});
		}else{
			$('#m_zlzg').menu('appendItem', {
				text: '预览整改通知',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jfzltzs";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					closeWin();
				}
			});
		}
		
		//复查
		if($('#td_fc').attr('class') == 'workflow_next'){
			$('#m_fc').menu('appendItem', {
				text: '新增复查意见书',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/addJffctzs?mainTabID="+mainTabID+"&jcid="+jcid;
					window.top.openWindowWithSave(false, null, window, null, 
				   		{title: '复查意见书',url: editUrl,width: 880,inline:true,height:500}, 
				   		null, null,null
				   	);
					closeWin();
				}
			});
			$('#m_fc').menu('appendItem', {
				text: '新增意见书存根',
				onclick: function(){
					var editUrl = basePath+'jfjfjctz/addJffctzscg?jcid='+jcid+"&mainTabID="+mainTabID;
					window.top.openWindowWithSave(false, null, window, null,
					{title: '复查意见书存根',url: editUrl,width: 880,inline:true,height:500}, 
				   		null, null,null
				   	);
					closeWin();
				}
			});
		}else{
			$('#m_fc').menu('appendItem', {
				text: '预览复查意见书',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jffctzs";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					closeWin();
				}
			});
			$('#m_fc').menu('appendItem', {
				text: '预览意见书存根',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jffctzscg";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					closeWin();
				}
			});
		}
		
		//检查意见 m_jcyj
		if($('#td_jcyj').attr('class') == 'workflow_next'){
			$('#m_jcyj').menu('appendItem', {
				text: '预览检查记录',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jfdwjcjl";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					closeWin();
				}
			});
			$('#m_jcyj').menu('appendItem', {
				text: '预览检查记录表',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jfdwjcjlb";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					closeWin();
				}
			});
		}
		
		//复查意见 m_fcjcyj
		if($('#td_fcjcyj').attr('class') == 'workflow_next'){
			$('#m_fcjcyj').menu('appendItem', {
				text: '预览复查意见书',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jffctzs";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					closeWin();
				}
			});
			$('#m_fcjcyj').menu('appendItem', {
				text: '预览意见书存根',
				onclick: function(){
					var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+mainTabID+"&jcid="+jcid+"&type=jffctzscg";
					window.open(editUrl,"详情","height=1054,width=924,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");;
					closeWin();
				}
			});
		}
	}
	
	function initWorkflowStatus(){
		if(jczt == "0"){
			//未下发通知
			$("#td_jctz").attr("class","workflow_next");
		}else if(jczt == "99"){
			//开展检查
			$("#td_jctz").attr("class","workflow_done");
			$("#td_kzjc").attr("class","workflow_next");
		}else if(jczt == "3"){
			//检查合格
			$("#td_jctz").attr("class","workflow_done");
			$("#td_kzjc").attr("class","workflow_done");
			$("#td_jcyj").attr("class","workflow_next");
		}else if(jczt == "80"){
			//责令整改
			$("#td_jctz").attr("class","workflow_done");
			$("#td_kzjc").attr("class","workflow_done");
			$("#td_zlzg").attr("class","workflow_next");
		}else if(jczt == "40"){
			//复查
			$("#td_jctz").attr("class","workflow_done");
			$("#td_kzjc").attr("class","workflow_done");
			$("#td_zlzg").attr("class","workflow_done");
			$("#td_fc").attr("class","workflow_next");
		}else if(jczt == "5"){
			//复查合格
			$("#td_jctz").attr("class","workflow_done");
			$("#td_kzjc").attr("class","workflow_done");
			$("#td_zlzg").attr("class","workflow_done");
			$("#td_fc").attr("class","workflow_done");
			$("#td_fcjcyj").attr("class","workflow_next");
			
		}else if(jczt == "100"){
			//转行政案件
			$("#td_jctz").attr("class","workflow_done");
			$("#td_kzjc").attr("class","workflow_done");
			$("#td_zlzg").attr("class","workflow_done");
			$("#td_fc").attr("class","workflow_done");
			$("#td_zxzaj").attr("class","workflow_next");
		}
	}
	
	function showMenu(menuType,floatTop,floatLeft){
		
		for(var i = 0;i<menuNameArray.length;i++){
			$("#"+menuNameArray[i]).menu('hide');
		}
		
		if($("#td_"+menuType).attr('class') == 'workflow_yet'){
			return;
		}
		
		$('#m_'+menuType).menu('show',{top:(150+floatTop),left:(10+floatLeft)});
	}
	
	
</script>