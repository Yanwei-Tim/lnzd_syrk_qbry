<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>情报重点人员下发</title>
<script type="text/javascript">

</script>
</head>
<body>
	 <!--  情报下发弹框 -->
	  <div id="deliverd" class="easyui-window" title="情报下发"
		style="width:400px;height:300px;top:20px;display:none;"
		data-options="iconCls:'icon-user',collapsible:false,
        minimizable:false,maximizable:true,
        modal:true,
        closed:true,
        top:100,
        width:700,
        height:480,
        left:50">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north'",split:true" style="height:280px;border-style: none;">
				<form id="queryForm">
					<table border="0" cellpadding="0" cellspacing="10" width="100%"
						height="100%" align="center">
			<tr class="dialogTr">
  	        <th  align="right"  width="20%">姓名：</th>
    	    <td width="30%"></td>
    	    <th  align="right" width="20%">证件号码：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	     <tr >
  	        <th  align="right"  width="20%">性别：</th>
    	    <td width="30%"></td>
    	    <th  align="right" width="20%">国籍：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	     <tr >
    	    <th  align="right" width="20%">参考居住地址：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	     <tr >
    	    <th  align="right" width="20%">户籍地址：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	     <tr >
  	        <th  align="right"  width="20%">当前级别：</th>
    	    <td width="30%"></td>
    	    <th  align="right" width="20%">下发状态：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	     <tr >
  	        <th  align="right"  width="20%">责任单位：</th>
    	    <td width="30%"></td>
    	    <th  align="right" width="20%">责任人：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	     <tr >
  	        <th  align="right"  width="20%">联系电话：</th>
    	    <td width="30%"></td>
    	    <th  align="right" width="20%">入部省库时间：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	       <tr >
  	        <th  align="right"  width="20%">立案单位：</th>
    	    <td width="30%"></td>
    	    <th  align="right" width="20%">立案时间：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	      <tr >
  	        <th  align="right"  width="20%">所属分局：</th>
    	    <td width="30%"></td>
    	    <th  align="right" width="20%">责任人：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	      <tr >
  	        <th  align="right"  width="20%">操作日期：</th>
    	    <td width="30%"></td>
    	    <th  align="right" width="20%">操作人：</th>
    	    <td width="30%" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" title=""></td>
   	    </tr>
   	    
   	 
					
					</table>
				</form>
			</div>
			 <div data-options="region:'south'",split:true" style="height:50px;border-style: none;">
		 	<table border="0" cellpadding="0" cellspacing="10" width="100%"
						height="100%" align="center">
						  <tr >
  	        <th  align="right"  width="20%">管辖地市：</th>
    	    <td width="30%"><input></td>
    	    <th  align="right"  width="20%">操作意见：</th>
    	    <td width="30%"></td>
   	    </tr>
							<tr class="dialogTr" style="padding-bottom:0px;margin-bottom:0px;">
							<td width="100%" colspan="2" align="right"><a
								class="easyui-linkbutton" iconCls="icon-ok"
								onclick="queryButton();">下发</a><a
								class="easyui-linkbutton" iconCls="icon-cancel"
								onclick="closeWindowdeverd();">关闭</a></td>
						</tr>
						</table>
		 </div>
 <div data-options="region:'center'",split:true" style="border-style: none;">
			<table class="easyui-datagrid"> 

<thead> 

<tr> 

<th data-options="field:'code',width:80" >操作时间</th> 

<th data-options="field:'name',width:50">操作人</th> 

<th data-options="field:'price',width:50">操作部门</th> 
<th data-options="field:'price',width:50">操作类型</th> 
<th data-options="field:'price',width:50">说明</th> 

</tr> 

</thead> 

<tbody> 

<tr> 

<td>001</td>

<td>name1</td>

<td>2323</td> 
<td>2323</td> 
<td>2323</td> 
</tr> 

<tr> 

<td>002</td>

<td>name2</td>

<td>4612</td> 
<td>2323</td> 
<td>2323</td> 
</tr> 

</tbody> 

</table> 
			
			</div>
		</div>
		
	</div>
</body>
</html>