//列表格式化[显示核实/注销]
datagridProcessFormater = function(val,row,index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var hs_status = rowData.hs_status;
	var xt_zxbz = rowData.xt_zxbz;
	if ("1" == xt_zxbz) {
		return '&nbsp;<a class="link" href="javascript:javascript:void(0)" disabled="disabled">核实</a>&nbsp;'+
		'&nbsp;<a class="link" href="javascript:javascript:void(0)" disabled="disabled">注销</a>&nbsp;';
	} else {
		if ("01" == hs_status) {
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doEdit1(this, '+index+')">核实</a>&nbsp;'+
			'&nbsp;<a class="link" href="javascript:javascript:void(0)" onclick="doCancel(this, '+index+')">注销</a>&nbsp;';
		} else if ("02" == hs_status) {
			return '&nbsp;<a class="link" href="javascript:javascript:void(0)" disabled="disabled">核实</a>&nbsp;'+
			'&nbsp;<a class="link" href="javascript:javascript:void(0)" disabled="disabled">注销</a>&nbsp;';
		}
	}
};
//重置  
function clearCase(){
 	$("#queryForm").form("reset");
}
//查询按钮
function queryButton(){
	var dwlbdm = document.getElementById("dwlbdm").value;
	var dwmc = document.getElementById("dwmc").value;
	var dz_dwdzxz = document.getElementById("dz_dwdzxz").value;
	var jyfwzy = document.getElementById("jyfwzy").value;
	var jyxzdm = document.getElementById("jyxzdm").value;
	var hs_status = document.getElementById("hs_status").value;
	dz_dwdzxz= $.trim(dz_dwdzxz);
	dwmc= $.trim(dwmc);
	jyfwzy= $.trim(jyfwzy);
	var reloadUrl = contextPath + '/sydwcx/queryDwHs';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid('load',{
		'dwlbdm':dwlbdm,
		'dwmc':dwmc,
		'dz_dwdzxz':dz_dwdzxz,
		'jyfwzy':jyfwzy,
		'jjlxdm':jyxzdm,
		'hs_status':hs_status
	});
}
//编辑
function doEdit1(linkObject, index){
	cancelBubble();
	var hsUrl = "/dwjbxxb/createHs?";
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	hsUrl+="dwidString="+rowData.id+"&mainTabID="+getMainTabID();
	menu_open("实有单位核实",hsUrl);
}
//重新加载	
function reloadDg(){
	$("#dg").datagrid("clearSelections");
	$('#dg').datagrid('load');
}
//注销action
function doCancel(linkObject, index){
	var datagrid_ID = getDatagrid_ID(0, linkObject);
	var opts = $('#' + datagrid_ID).datagrid("options");
	var rows = $('#' + datagrid_ID).datagrid('getData');
	var rowData = rows.rows[index];
	document.getElementById("xt_zxyy").value ="请输入注销原因...";
	document.getElementById("id").value =rowData.id;
	$("#win").window("open"); 
}
//注销后台操作
function updateHs(){
	var sydwHsUrl= contextPath+"/sydwcx/updateHs";
	var xt_zxyy = document.getElementById("xt_zxyy").value;
	var id = document.getElementById("id").value;
	if(xt_zxyy!="" ){
		if(xt_zxyy.length>100){
			return;
		}else{
			$.ajax({
				type:"GET",
				sync:true,
				url:sydwHsUrl,
				data:{'id':id,'xt_zxyy':xt_zxyy,'xt_zxbz':1},
				dataType:'json',
				success:function(json){
					if(json==1){
						$.messager.alert("提示","实有单位注销成功","info");
						$("#win").window("close");
						$("#dg").datagrid("load");
					}else{
						$.messager.alert("提示","实有单位注销失败","info");
					}
				}
			
			});	
		}
	}else{
		$.messager.alert("提示","请输入注销原因","info");
	}
}
//关闭窗口	  
function closeWindow(){
	var zxyy = document.getElementById("xt_zxyy").value;
	if(zxyy!="请输入注销原因..." && zxyy!=""){
		if(confirm("数据还未保存，确定要关闭吗?")){
			$("#win").window("close");
		}
	}else{
		$("#win").window("close");
	}
}