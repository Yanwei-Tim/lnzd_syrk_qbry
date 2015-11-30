if(typeof Workflow == "undefined" || !Workflow){
	var Workflow = {};
};

Workflow.showJfWorkflow = function (index){
	var row = $('#dg').datagrid('getRows')[index];
	var editUrl = basePath+"jfjfjctz/showWorkflow?jcid="+row.id;
	var wid = createWindowId();
	window.top.openWindowNoSave(false, wid, window, {jcid:row.id,jczt:row.zt,winId:wid,dwid:row.dwid,dwlbdm:row.dwlbdm}, 
   		{title: '技防检查工作流程查看',url: editUrl,width: 880,inline:true,height:500}, 
   		null, null,null
   	);
}

Workflow.createJfjctzs = function(index){
	var row = $('#dg').datagrid('getRows')[index];
	var editUrl = basePath+"jfjfjctz/addJfjfjctzs?dwid="+row.dwid+"&dwlbdm="+row.dwlbdm+"&ywlbdm=14"+"&mainTabID="+getMainTabID()+"&jcid="+row.id;
	window.top.openWindowWithSave(false, null, window, null, 
   		{title: '单位检查通知书',url: editUrl,width: 880,inline:true,height:500}, 
   		null, null,null
   	);
}

/** 开展检查 */
Workflow.createJfdwjcjl = function(index){
	var row = $('#dg').datagrid('getRows')[index];
	var editUrl = basePath+"dwjcxxb/addJfdwjcjl?dwid="+row.dwid+"&dwlbdm="+row.dwlbdm+"&ywlbdm=14"+"&mainTabID="+getMainTabID()+"&jcid="+row.id;
	window.top.openWindowWithSave(false, null, window, null, 
   		{title: '单位技防检查记录',url: editUrl,width: 880,inline:true,height:500}, 
   		null, null,null
   	);
}

/** 责令整改 */
Workflow.createJfzltzs = function(index){
	var row = $('#dg').datagrid('getRows')[index];
	var editUrl = basePath+"jfjfjctz/addJfzltzs?mainTabID="+getMainTabID()+"&jcid="+row.id;
	
	window.top.openWindowWithSave(false, null, window, null, 
   		{title: '责令整改通知书',url: editUrl,width: 880,inline:true,height:500}, 
   		null, null,null
   	);
}

/** 责令整改 */
Workflow.createJffctzs = function(index){
	var row = $('#dg').datagrid('getRows')[index];
	var editUrl = basePath+"jfjfjctz/addJffctzs?mainTabID="+getMainTabID()+"&jcid="+row.id;
	window.top.openWindowWithSave(false, null, window, null, 
   		{title: '复查意见书',url: editUrl,width: 880,inline:true,height:500}, 
   		null, null,null
   	);
}

Workflow.printTest = function(index){
	var row = $('#dg').datagrid('getRows')[index];
	var editUrl = basePath+"jfjfjctz/showPrintView?mainTabID="+getMainTabID()+"&jcid="+row.id+"&type=jffctzscg";
	window.open(editUrl,"详情","height=1054,width=1024,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
}

function createWindowId(){
	var myTime = (new Date()).getTime();
	return "win_" + myTime;
}



