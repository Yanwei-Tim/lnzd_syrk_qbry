<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>左侧导航菜单</title>
	 <script type="text/javascript" src="<%=request.getContextPath()%>/common/jeasyui/jquery1.11.min.js"></script>
	 <script type="text/javascript" src="<%=request.getContextPath()%>/common/jeasyui/jquery.easyui.min.js"></script>
	 <script type="text/javascript" src="<%=request.getContextPath()%>/common/jeasyui/jquery.easyui.extend.js"></script>
	 <script type="text/javascript" src="<%=request.getContextPath()%>/common/jeasyui/mainFrame.js"></script>
	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/common/jeasyui/themes/default/easyui.css"/>
	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/common/skin/mainMenunew.css">
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/common/ztree/zTreeStyle.css"/>
     <style type="text/css">
	 .accordion-collapse {
		background: url("../images/arrow_02.png") no-repeat scroll 0 0;
	 }
	 .accordion-expand {
		background: url('../images/arrow_01.png') no-repeat 0 0;
	 }
	 .TreeExpandoLeaf {
		background: url("../images/t_08.png") no-repeat scroll 0 0;
		height: 30px;
		width: 30px;
		margin-left: 10px;
	 }
	 .dijitTreeExpandoLeaf {
		background: url("../images/t_10.png") no-repeat scroll 0 0;
	 }
     </style>
     <script type="text/javascript" >
	 $(function(){
			var listmenu = eval('${jsondata}')
			for(var i=0;i<listmenu.length;i++){
				var menuacc = eval(listmenu[i].children);
				for(var j = 0;j<menuacc.length;j++){
					var menunode = eval(menuacc[j].children);
					var menuone = eval(menuacc[j]);
					var text = menuone.text;
					var ID = menuone.id;
					var Str = "";
					if(text=="标准地址"){
						$('#westaction').accordion('add', {title: text,id :ID,selected: true});
						for(var k =0;k<menunode.length;k++){
							var menu = eval(menunode[k]);
							if(menu.openURL!=""){
							   var text = menu.text;
							   var ID1 = menu.id +"ztree";
							   if(text!="标准地址管理"){
								   Str = Str +"<ul  class=\"ztree\" id="+ID1+">";
								   if(menu.openMode=="new"){
									   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"window.open('"+menu.openURL+"')\"><a style='margin-left: 28px;margin-top: 8px;' >";
								   }else{
									   Str = Str +"<li class=\"TreeExpandoLeaf\" id="+menu.id+" onclick=\"menu_openClass('"+text+"','"+menu.openURL+"','"+menu.id+"')\"><a style='margin-left: 28px;margin-top: 8px;' >"; 
								   }
								   Str = Str +menu.text +"";
								   Str = Str +"</a></li>";
								   Str = Str +"</ul>";
								   $("#"+ID).html(Str); 
							   }
							}
						}
					}
				}
			}
			//移入菜单项换色
			$("ul").hover( function(event){
			    $(this).addClass("dijitTreeLabelFocused");    
			},function(event){
			    $(this).removeClass("dijitTreeLabelFocused");
			});
	  });
	  //打开菜单连接
	  function menu_openClass(text,URL,ID){
		menu_open(text,URL);
		var itemli = document.getElementsByTagName("li");
		var itemul = document.getElementsByTagName("ul");
		for(var i = 0;i<itemul.length;i++){
			var itemu = itemul[i];
			if(itemu.className != "ztree"){
				itemu.className = "ztree";
			}
		}
		for(var i =0;i<itemli.length;i++){
			var item = itemli[i];
			if(item.className != "TreeExpandoLeaf"){
				item.className = "TreeExpandoLeaf";
			}
		}
		var id = ID +"ztree";
		$("#"+ID).addClass("dijitTreeExpandoLeaf");
		$("#"+id).addClass("dijitTreeLabelFocused1");
	  }
  </script>
  </head>
  <body class="menuBody" onselectstart="return false;" oncontextmenu="return false;">
     <div class="menuTitle">
        <div class="menu_text" data-options="region:'west',split:true">菜单导航</div>
     </div>
     <div class="easyui-accordion" fit="true" border="false" id="westaction" animate="false"></div>
  </body>
</html>