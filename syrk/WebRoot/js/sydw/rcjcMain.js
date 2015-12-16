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

Workflow.showAjxx = function(index){
	var row = $('#dg').datagrid('getRows')[index];
	window.open("http://10.79.188.144:8080/lnxjz/zfba/index.jsp?jqxh="+row.ajxxid+"&cslx=saxx");
}

Workflow.createAjxxid = function(index){
	
	$('#dg').datagrid('loading');
	
	var row = $('#dg').datagrid('getRows')[index];
	$.ajax({
		type:"POST",
		sync:true,
		url:basePath+"jfjfjctz/createAjxxid",
		data:{id:row.id},
		dataType:'json',
		success:function(json){
			$('#dg').datagrid('loaded');
			
			var dwlbdm = $("#dwlbdm").combotree("getValue");
			var dwmc = $("#dwmc").val();
			var jcsj = $("#jcsj").val();
			var jcsjz = $("#jcsjz").val();
			var ywlbdm =  $("#ywlbdm").combobox("getValue");
			//设置后续数据状态
			var status = $("input[name=checkStatus]:checked ").val();
			$('#dg').datagrid('reload',{'dwlbdm':dwlbdm,'dwmc':dwmc,'jcsj':jcsj,'jcsjz':jcsjz,'ywlbdm':ywlbdm,'status':status});
		},
		error:function(e){
			$('#dg').datagrid('loaded');
		}
	});
}

function createWindowId(){
	var myTime = (new Date()).getTime();
	return "win_" + myTime;
}



