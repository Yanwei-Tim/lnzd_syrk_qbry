$(document).ready(function(){
	
});
         
function xsjbxxAdd() {
	var zdryZjhm=$("#zdry_zjhm").val();
	var url=contextPath+'/dtjsMore/addDtjsXsjbxx?zdryZjhm='+zdryZjhm;
	window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
			{title: '写实基本信息新增',url: url,width: 880,inline:true,height:500}, 
		   		null, "xsjbxxquery",null
		   	);
	
	
};

function xsjbxxquery(){
	var zdryZjhm=$("#zdry_zjhm").val();
	$('#xsjbxx').datagrid('load',{    
		
		'zdry_zjhm':zdryZjhm
	});
};

function xsjbxxFormater(val,row,index){
	 var html="";
	 if(row.gxdwdm==userOrgCode){
		 html='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="xsjbxxedit(this, '+index+')">编辑</a>&nbsp;'
		 +'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="xsjbxxDelete(this, '+index+')">删除</a>&nbsp;'	 
	 }else{		 
		 html='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="xsjbxxview(this, '+index+')">查看</a>&nbsp;'
	 }	
	return html ;
};

function xsjbxxedit(linkObject, index){

	cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var url=contextPath+'/dtjsMore/editDtjsXsjbxx?id='+rowData.id +"&type=edit";
	window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
			{title: '写实基本信息编辑',url: url,width: 880,inline:true,height:500}, 
		   		null, "xsjbxxquery",null
		   	);
	
};
function xsjbxxview(linkObject, index){

	cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var url=contextPath+'/dtjsMore/editDtjsXsjbxx?id='+rowData.id +"&type=view";

	openWindow(false,null,url,null,{title:'写实基本信息查看',width:880,height:500});

	
};

function xsjbxxDelete(linkObject, index){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dtjsMore/deleteDtjsXsjbxx';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	topMessager.confirm('','您确认要删除数据吗？',function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:rowData.id}
			}).done(function(result) {
				query();
			});
		}
	})
};
	/**
	 * 涉稳信息操作列
	 */
	function swxxFormater(val,row,index){
		 var html="";
		 if(row.xt_lrrbmid==userOrgCode){
			 html='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="swxxedit(this, '+index+')">编辑</a>&nbsp;'
			 +'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="swxxDelete(this, '+index+')">删除</a>&nbsp;'	 
		 }else{		 
			 html='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="swxxview(this, '+index+')">查看</a>&nbsp;'
		 }	
		return html ;
	}
	function swxxAdd() {
		
		var zdryZjhm=$("#zdry_zjhm").val();
		var url=contextPath+'/dtjsMore/addDtjsSwxx?zdryZjhm='+zdryZjhm;
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '维稳信息新增',url: url,width: 880,inline:true,height:500}, 
			   		null, "swxxquery",null);
		
		
	}

	function swxxedit(linkObject, index){

		cancelBubble();
		var rows = $('#swxxtable').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsSwxx?id='+rowData.id +"&type=edit";
		window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
				{title: '维稳信息编辑',url: url,width: 880,inline:true,height:500}, 
			   		null, "swxxquery",null
			   	);
		
	}
	function swxxview(linkObject, index){

		cancelBubble();
		var rows = $('#dg').datagrid('getData');
		var rowData = rows.rows[index];
		var url=contextPath+'/dtjsMore/editDtjsSwxx?id='+rowData.id +"&type=view";

		openWindow(false,null,url,null,{title:'维稳信息查看',width:880,height:500});

		
	}

	function swxxDelete(linkObject, index){
		cancelBubble(); // 阻止冒泡，不然要执行onClickRow
		var deleteUrl = contextPath + '/dtjsMore/deleteDtjsSwxx';
		var datagrid_ID = getDatagrid_ID(0, linkObject);
		topMessager.confirm('','您确认要删除数据吗？',function(r) {    
			if (r) {	
				var opts = $('#' + datagrid_ID).datagrid("options");
				var rows = $('#' + datagrid_ID).datagrid('getData');
				var rowData = rows.rows[index];
				$.ajax({
					url: deleteUrl,
					type: 'POST',
					data: {id:rowData.id}
				}).done(function(result) {
					swxxquery();
				});
			}
		});
	}
	function swxxquery(){
		var zdryZjhm=$("#zdry_zjhm").val();
		$('#swxxtable').datagrid('load',{    
			
			'zdryzjhm':zdryZjhm
		});
	}


