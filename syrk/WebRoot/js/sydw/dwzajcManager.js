var markerArr = new Array();
var dz_dwdzdmArr = new Array();
//----------查询功能页方法--------------
//精确查询
function closeWindow(){
	$("#win").window("close"); 
}

function detailSearch(){
	$("#win").show();
	$("#win").window("open"); 
}
//操作列
function datagridProcessFormater(val, row, index) { // 自定义操作生成
	return '<a class="link" href="javascript:javascript:void(0)" onclick="doView(this,'+index+')">详情</a>&nbsp;'+
		   '<a class="link" href="javascript:javascript:void(0)" onclick="doCheck('+index+',\''+row.dwmc+'\',\''+row.dwlbdm+'\')">检查</a>&nbsp;'+
		   '<a class="link" href="javascript:javascript:void(0)" onclick="doPunish('+index+',\''+row.dwmc+'\',\''+row.dwlbdm+'\');">处罚</a>';
}
// 修改单条
function doView(linkObject, index) {
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/sydwgl/view?id="+rowData.id+"&mode=partview";
	menu_open("实有单位详情",editUrl);
}

//检查管理窗口
function doCheck(index,dwmc,dwlbdm){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/forward/sydw|rcjcMain?dwid="+rowData.id+"&dwmc="+encodeURI(dwmc)+"&dwlbdm="+dwlbdm;
	menu_open("日常检查管理",editUrl);
}

//所有检查管理窗口
function doAllCheck(){
	var editUrl = "/forward/sydw|rcjcMain";
	menu_open("所有检查列表",editUrl);
}

//处罚管理窗口
function doPunish(index,dwmc,dwlbdm){
	cancelBubble(); // 阻止冒泡，不然要执行onClickRow
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/forward/sydw|punishMain?dwid="+rowData.id+"&dwmc="+encodeURI(dwmc)+"&dwlbdm="+dwlbdm;
	menu_open("单位处罚管理",editUrl);
}

//所有处罚管理窗口
function doAllPunish(){
	var editUrl = "/forward/sydw|punishMain";
	menu_open("所有处罚列表",editUrl);
}
//按下enter
function passwordOnkeyPress(obj) {
	obj.style.color = "black";
	var keycode = event.keyCode;
	if (keycode == 13) {
		searchMain();
	}
}
//按下enter,清空
function setDzqc(obj){
	obj.value="";
}
//搜索功能
function searchMain(){
	var condition = $.trim($('#condition').searchbox('getValue'));
	var reloadUrl = contextPath + '/sydwcx/queryDw';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid('load',{condition:condition});
	$('#dg').datagrid("clearSelections");
}
//----精确查询框方法---------
//单击行地图定位
function onSelectRow(rowIndex, data){
	if(typeof(markerArr[data.dz_dwdzmlpdm])!="undefined" && markerArr[data.dz_dwdzmlpdm]!="" && markerArr[data.dz_dwdzmlpdm]!=null){
		if(IE){
			parent.frames["biz_center"].SydwMap.centerByPoint(markerArr[data.dz_dwdzmlpdm],19,dz_dwdzdmArr[data.dz_dwdzmlpdm]);
		}else{
			var obj = parent.frames.document.getElementById("biz_center").contentWindow;
			obj.SydwMap.centerByPoint(markerArr[data.dz_dwdzmlpdm],19,dz_dwdzdmArr[data.dz_dwdzmlpdm]);
		}
	}else{
		topMessager.show({
			title: MESSAGER_TITLE,
			msg: "单位地址无坐标。",
			timeout:3500
		});
	}
}
//查询按钮
function queryButton(){
	var dwlbdm = document.getElementById("dwlbdm").value;
	var dwmc = document.getElementById("dwmc").value;
	var dz_dwdzxz = document.getElementById("dz_dwdzxz").value;
	var jyfwzy = document.getElementById("jyfwzy").value;
	var jyxzdm = document.getElementById("jyxzdm").value;
	dwmc= $.trim(dwmc);
	dz_dwdzxz= $.trim(dz_dwdzxz);
	var reloadUrl = contextPath + '/sydw/list';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	var dwdzzt = "0";
	var ybzdz = document.getElementById("ybzdz");
	var wbzdz = document.getElementById("wbzdz");
	if(ybzdz.checked==true&&wbzdz.checked==false){
		dwdzzt = "1";
	}else if(ybzdz.checked==false&&wbzdz.checked==true){
		dwdzzt = "2";
	}
	$('#dg').datagrid('load',{'dwlbdm':dwlbdm,'dwmc':dwmc,'dz_dwdzxz':dz_dwdzxz,'jyfwzy':jyfwzy,'jjlxdm':jyxzdm,'dwdzzt':dwdzzt});
	closeWindow("win");
}

//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
}
//datagrid加载完成后事件，地图定位
function loadpoints1(data){
	//延迟加载统计
	beforeTableLoad(data,'dg');
	var mapWindow = null;
	if (IE) {
		mapWindow = parent.frames["biz_center"];
	}else {
		mapWindow = parent.frames.document.getElementById("biz_center").contentWindow;
	}
	if ("undefined" != typeof mapWindow && mapWindow != null) {
		if (mapWindow.SydwMap) {
			mapPoint(mapWindow);
		}else {
			setTimeout(function() {mapPoint(mapWindow);}, 3000);
		}
	}
}
//地图定位
function mapPoint(mapWindow) {
	//markerArr = new Array();
	if (mapWindow.SydwMap) {
		mapWindow.SydwMap.clearMarkers();
		var rows = $('#dg').datagrid("getRows");
		var len = rows.length;
		var dwidsArray = [];
		for (var i = 0; i < len; i++) {
			dwidsArray.push("'" + rows[i].id + "'");
			if (rows[i].dz_dwdzdm != "undefined" && rows[i].dz_dwdzdm != "") {
				dz_dwdzdmArr[rows[i].dz_dwdzdm] = rows[i].dz_dwdzdm;
			}
		}
		if (len > 0) {
			$.ajax({
				type:"GET",
				sync:true,
				url:contextPath+"/sydwcx/queryZbByDzId",
				data:{dwids:dwidsArray.join(",")},
				dataType:'json',
				success:function(json){
					var len = json.length;
					for (var i = 0; i < len; i++) {
						
						if (json[i].zbx!=null && json[i].zbx!=""){
							var marker = null;
							if (IE) {
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							} else{
								marker = mapWindow.addMarker(json[i].dwmc,json[i].zbx,json[i].zby,"location.png",null,null,34,34,false,json[i].dz_dwdzdm,null);
							}
							markerArr[json[i].dz_dwdzdm] = marker;
							dz_dwdzdmArr[json[i].dz_dwdzdm] = json[i].dz_dwdzdm;
							console.log(json[i].dz_dwdzdm);
						}
					}
				}
			});
		}
	}
}
function doJcFormatPrint() {
	$("#print").show();
	$("#print").window("open"); 
}

function closePrint(){
	$("#print").window("close"); 
}

function queryPrint(){
	var ywlbdm;
	var dwlbdm = document.getElementById("dwlbdm_p").value;
	var obj=document.getElementsByName("ywlbdm");
	for (i=0;i<obj.length;i++){  //遍历Radio  
		if(obj[i].checked){
			ywlbdm=obj[i].value;//获取Radio的值
		} 
	}
	var openFlag = false;
	if(dwlbdm == null || dwlbdm == ""){
		openFlag = false
		alert("请选择要打印的单位类型");
	}else{
	if(ywlbdm=="04" || ywlbdm=="12" || ywlbdm=="13"){
		editUrl = contextPath+"/dwjcxxb/printPreView?dwlbdm="+dwlbdm+"&ywlbdm="+ywlbdm;
		openFlag = true;
	}
	if(ywlbdm=="11"){
		editUrl = contextPath+"/dwjcxxb/printPreXfView?dwlbdm="+dwlbdm;
		openFlag = true;
	}
	if(ywlbdm=="14"){
		editUrl = contextPath+"/dwjcxxb/printPreJfView?dwlbdm="+dwlbdm;
		openFlag = true;
	}
	if(openFlag){
		window.open(editUrl,"检查打印预览","height=1054,width=1024,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no");
   	}
	}
}
var addressPrefixArray = addressPrefix.split(",");
//截地址字段
function subjzdz(val, row, index){
	for (var i = 0; i < addressPrefixArray.length; i++) {
		val = val.replace(addressPrefixArray[i], "");
	}
	return val;
}