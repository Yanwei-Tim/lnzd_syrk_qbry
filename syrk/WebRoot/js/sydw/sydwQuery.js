var initMarkerArr = new Array();//放点对象
var dz_dwdzdmArr = new Array();
var setInt = "";//记录延时
var initMarker = "";//记录点击列表点
var ezmap = "";//加载地图
var initMarker = "";//记录点击列表点
//初始化单位管理
$(function(){
	onloadMap();
});
//加载地图
function onloadMap(){
	/*地图对象*/
	ezmap = new FrameTools.Map();
	/*设置地图代理*/
	ezmap.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	ezmap.setMapDiv("mapDiv");
	/*加载地图*/
	ezmap.onloadMap();
	/*显示鹰眼*/
	ezmap.addOverView();
	/*隐藏自带矢量影像图层对象*/
	ezmap._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	ezmap.showNewMapServer("mapDiv","ezmap");
	/*加载地图工具条*/
	ezmap.buildTools("mapDiv","toolDiv","ezmap");
	/*加载边界坐标值*/
	ezmap.moveMapToBjzbz(bjzbz);
};
//列表操作列
function datagridProcessFormater(val, row, index) {
	return '<a class="link" href="javascript:javascript:void(0)" onclick="inFo(this,'+index+')">详情</a>';
};
//打开详情
function inFo(linkObject, index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var editUrl = "/sydwgl/view?id="+rowData.id+"&mode=view";
	menu_open("实有单位信息--"+rowData.dwmc,editUrl);
};
//1关注：绿；2重点关注：红；3重点管理：黄
function jgjbdm(value,row,index){
	if(value==1){
		return '<img src= '+contextPath+'/images/lamp_green.png class=imgStyle title=关注/>';
	}else if(value==2){
		return '<img src= '+contextPath+'/images/lamp_red.png class=imgStyle title=重点关注/>';
	}else if(value==3){
		return '<img src= '+contextPath+'/images/lamp.png class=imgStyle title=重点管理/>';
	}
	return "";
};
//单击行地图定位
function addClickMarker(row){
	//关闭所有器已经打开的气泡框
	ezmap._MapApp.closeInfoWindow();
	if(initMarker!=""){
		//清除之前的坐标点
		ezmap._MapApp.removeOverlay(initMarker);
	}
	//获取基本信息内容
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[row];
	var zbx = rowData.dz_dwzbx;
	var zby = rowData.dz_dwzby;
	var title = rowData.dwmc;
	if(zbx!=""&&zby!=""){
		initMarker = ezmap.initMarker(title,zbx,zby,'jzw1.png',null,null,43,37);
		ezmap._MapApp.addOverlay(initMarker);
		initMarkerArr.push(initMarker);
		//鼠标移动到点上列表选中
		$('#dg').datagrid("selectRow",row);
		//打开气泡
		queryDwByDzDm(initMarker,rowData.dz_dwdzdm,row);
	}
};
//datagrid加载完成后事件，地图定位
function loadpoints(data){
	//延迟加载列表统计
	beforeTableLoad(data,'dg');
	//关闭所有器已经打开的气泡框
	ezmap._MapApp.closeInfoWindow();
	//判断延时是否执行完，没执行完终止此方法
	if(setInt!=""){
		clearInterval(setInt);
	}
	//判断地图上已经存在点图层清除
	if(initMarkerArr!=null){
		var markerLen = initMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			ezmap._MapApp.removeOverlay(initMarkerArr[j]);
		}
	}
	//清除记录点击列表点
	if(initMarker!=""){
		//清除之前的坐标点
		ezmap._MapApp.removeOverlay(initMarker);
	}
	//延时加载点图层
	var rows = $('#dg').datagrid("getRows");
	var len = rows.length;
	var count = 0;
	setInt = setInterval(function(){
		if(count<len){
			var zbx = rows[count].dz_dwzbx;
			var zby = rows[count].dz_dwzby;
			var title = rows[count].dwmc;
			if(zbx!=""&&zby!=""){
				var initMarker = ezmap.initMarker(title,zbx,zby,'jzw2.png',null,null,43,37);
				ezmap._MapApp.addOverlay(initMarker);
				initMarkerArr.push(initMarker);
				//地图元素和列表联动
				addMapToListFun(initMarker,count);
			}
		}else{
			clearInterval(setInt);
		}
		count++;
	},90);
};
//重置加载
function loadGrid(){
	$('#dg').datagrid('load',{zbz:null,type:null,mapRadius:null,rows:21});  
	$('#dg').datagrid("clearSelections");
};
//重新加载列表
function reloadGrid(){
	$('#dg').datagrid("clearSelections");
	var zbz = document.getElementById("zbz").value;
	var type = document.getElementById("type").value;
	var mapRadius = document.getElementById("mapRadius").value;
	var reloadUrl = contextPath + '/sydwcx/queryDwDzOnPT';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid('load',
	{    
		'zbz': zbz,   
		'type': type ,
		'mapRadius':mapRadius
	});
};
//重置按钮
function resetButton(){
	$("#queryForm").form("reset");
};
//截地址字段
function subjzdz(val, row, index){
	var xzqhmc = window.top.getDictName(contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',row.dz_dwdzssxdm);
	return val.replace(xzqhmc, "");
};
//查询按钮
function queryButton(){
	var dwlbdm = document.getElementById("dwlbdm").value;
	var dwmc = document.getElementById("dwmc").value;
	var dz_dwdzxz = document.getElementById("dz_dwdzxz").value;
	var jyfwzy = document.getElementById("jyfwzy").value;
	var jyxzdm = document.getElementById("jyxzdm").value;
	dwmc= $.trim(dwmc);
	dz_dwdzxz= $.trim(dz_dwdzxz);
	var gxsxj = $("#gxsxj").val();
	var gxpcs =  $("#gxpcs").val(); 
	var reloadUrl = contextPath + '/sydwcx/queryDw?flag=jsq';
	var opt = $('#dg').datagrid('options');
	opt.url = reloadUrl;
	$('#dg').datagrid('load',
	{    
		'dwlbdm':dwlbdm,
		'dwmc':dwmc,
		'dz_dwdzxz':dz_dwdzxz,
		'jyfwzy':jyfwzy,
		'jjlxdm':jyxzdm,
		'glfxjid': gxsxj,
		'glpcsid': gxpcs
	});
};
//坐标点添加点击事件
function addMapToListFun(PMarker,row){
	PMarker.addListener("click",function(){
		addClickMarker(row);
	});
};
//点击列表事件
function onClickRow(rowIndex,rowData){
	addClickMarker(rowIndex);
};
//气泡框数据
function queryDwByDzDm(marker,dz_dwdzdm,row){
	$.ajax({
		type:"GET",
		sync:true,
		url:contextPath+"/sydwcx/queryDwByDzDm",
		data:{dz_dwdzdm:dz_dwdzdm},
		dataType:'json',
		success:function(json){
			var len = json.length;
			var idVaule='infoDiv'+dz_dwdzdm;
			$("#"+idVaule).remove();
			var msgHtml="<div style='width:490px;' cellpadding='0' cellspacing='10'  align='right'>";
				msgHtml+='<div id="'+idVaule+'">';
				for(var i=0;i<len;i++){
					var lb = window.top.getDictName(contextPath + '/common/dict/BD_D_DWLXDM.js', json[i].dwlbdm);
					msgHtml+='<div title="'+json[i].dwmc+'['+lb+']"   style="overflow:false;padding:10px;height:auto"> '
					msgHtml+="<table style='width:100%' ><tr><td>";
					msgHtml+="<table   border='0'  cellpadding='0' cellspacing='10'  align='center' >";
					msgHtml+="<tr><td style='width:90px'>实有单位名称:</td><td>"+json[i].dwmc+"</td></tr>" ;
					msgHtml+="<tr><td>单位类别:</td><td>"+lb+"</td></tr>" ;
					msgHtml+="<tr><td>联系电话:</td><td>"+json[i].lxdh+"</td></tr>";
					var jzdz = "";
					if(json[i].dz_dwdzxz!=null){
						jzdz = json[i].dz_dwdzxz;
					}else{
						jzdz = json[i].dz_dwdzmlpxz;
					}
					if(json[i].dz_dwdzmlpdm!=""&&json[i].dz_dwdzmlpxz!=""){
					   msgHtml += "<tr><td>单位地址：</td><td><a class='infoTable' style='text-decoration:underline;' href='javascript:void(0)' onclick='doBuildingShow("+row+")'>"+jzdz+"</a></td></tr>";
			        }else{
			    	   msgHtml += "<tr><td>单位地址：</td><td>"+jzdz+"</td></tr>";
			        }
					msgHtml+="<tr><td></td><td></td></tr>" ;
					msgHtml+="</table>" ;
					console.log(contextPath+"/zpfjFjxxb/queryZpByLyid.jpg?id="+json[i].id);
					msgHtml+="</td><td><img   width='140px' height='110' src='"+contextPath+"/zpfjFjxxb/queryZpByLyid.jpg?id="+json[i].id+"' /></td>";
					msgHtml+="</tr></table></div>";
				}
			marker.openInfoWindowHtml(msgHtml);
			$("#"+idVaule).accordion({
				multiple:false,
				animate:true
			});
		}
	});
};
//层户结构【展现】
function doBuildingShow(index){
	var rows = $('#dg').datagrid('getData');
	var rowData = rows.rows[index];
	var title = "层户结构";
	if(rowData.dz_dwdzmlpdm!=""){
		var xzqhmc = window.top.getDictName(contextPath+'/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',rowData.dz_dwdzssxdm);
		var mlpxz = rowData.dz_dwdzxz.replace(xzqhmc, "");
		title = "【"+mlpxz+"】层户结构";
	}
	//层户结构URL
	menu_open(title, "/dz/dzBuildingShow?mldzid="+rowData.dz_dwdzmlpdm+"&chdzid="+rowData.dz_dwdzdm+"&mainTabID="+getMainTabID());
};