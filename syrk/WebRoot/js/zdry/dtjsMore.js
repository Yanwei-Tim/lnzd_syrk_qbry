
$(document).ready(function(){
	
});
         
function xsjbxxAdd() {
	var zdryZjhm=$("#zdry_zjhm").val();
	var url=contextPath+'/dtjsMore/addDtjsXsjbxx?zdryZjhm='+zdryZjhm;
	window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
			{title: '写实基本信息新增',url: url,width: 880,inline:true,height:500}, 
		   		null, "query",null
		   	);
	
	
}

function query(){
	var zdryZjhm=$("#zdry_zjhm").val();
	$('#dg').datagrid('load',{    
		
		'zdry_zjhm':zdryZjhm
	});
}

function datagridProcessFormater(val,row,index){
	 var html="";
		 html='&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="edit(this, '+index+')">编辑</a>&nbsp;'

		 html=html+'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doDelete(this, '+index+')">删除</a>&nbsp;' 
	 
	return html ;
}

function edit(linkObject, index){

	cancelBubble();
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var url=contextPath+'/dtjsMore/editDtjsXsjbxx?id='+rowData.id;
	window.top.openWindowWithSave(false, null, window, {'_p':$('dtjsMore')},
			{title: '写实基本信息编辑',url: url,width: 880,inline:true,height:500}, 
		   		null, "query",null
		   	);
	
	
	
	/* menu_open(rowData.xm + '', '/zdryzb/' + rowData.ryid + '/' + rowData.syrkid
			+ '/view' + '?mainTabID=' + getMainTabID()); */
   // menu_open(rowData.xm +'','/zdryzb/shbzdry/edit?zdryid='+rowData.id+"&type="+rowData.qx+"&mainTabID="+getMainTabID());
  //  menu_open('涉环保重点人员编辑','/syrkGl/add?mainTabID='+getMainTabID()+'&invokeJSMethod=SyrkGl.queryButton');
}

function doDelete(linkObject, index){
    alert(2);
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var deleteUrl = contextPath + '/dtjsMore/deleteDtjsXsjbxx';
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	topMessager.confirm('','您确认要删除数据吗？',function(r) {    
		if (r) {	
			var opts = $('#' + datagrid_ID).datagrid("options");
			var rows = $('#' + datagrid_ID).datagrid('getData');
			var rowData = rows.rows[index];
	/*		var postFieldArray = [];
			postFieldArray.push(opts.idField);
		
			var postData = {};
			for (var i = 0; i < postFieldArray.length; i++) {
				var postField = postFieldArray[i];
				if (rowData[postField]) {
					postData[postField] = rowData[postField];
				}
			}*/
			$.ajax({
				url: deleteUrl,
				type: 'POST',
				data: {id:rowData.id}
			}).done(function(result) {
				query();
			});
		}
	});
}

