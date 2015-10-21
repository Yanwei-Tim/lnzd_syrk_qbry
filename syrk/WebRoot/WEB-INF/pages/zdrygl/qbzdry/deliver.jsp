<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		style="width: 400px; height: 300px; top: 5px; display: none;"
		data-options="iconCls:'icon-user',collapsible:false,
        minimizable:false,maximizable:true,
        modal:true,
        closed:true,
        width:750,
        height:550,
        left:50">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north'",split:true" style="height: 280px; border-style: none;">
				<form id="queryForm">
					<table border="0" cellpadding="0" cellspacing="10" width="100%"
						height="100%" align="center">
						<tr class="dialogTr">
							<th align="right" width="20%">姓名：</th>
							<td width="30%" class="dialogTd"></td>
							<th align="right" width="20%">证件号码：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
						<tr>
							<th align="right" width="20%">性别：</th>
							<td width="30%"></td>
							<th align="right" width="20%">国籍：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
						<tr>
							<th align="right" width="20%">民族：</th>
							<td width="30%"></td>
							<th align="right" width="20%">籍贯：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
						<tr>
							<th align="right" width="20%">出生日期：</th>
							<td width="30%" class="dialogTd"></td>
							<th align="right" width="20%">外文名称：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
						<tr>
							<th align="right" width="20%">现居住地址：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
						<tr>
							<th align="right" width="20%">户籍地址：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
						<tr>
							<th align="right" width="20%">重点人员类别：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
						<tr>
							<th align="right" width="20%">当前级别：</th>
							<td width="30%" class="dialogTd"></td>
							<th align="right" width="20%">当前状态：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
						<tr>
							<th align="right" width="20%">责任单位：</th>
							<td width="30%" class="dialogTd"></td>
							<th align="right" width="20%">责任人：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
						<tr>
							<th align="right" width="20%">立案单位：</th>
							<td width="30%"></td>
							<th align="right" width="20%">立案时间：</th>
							<td width="30%" class="dialogTd"></td>
						</tr>
					</table>
				</form>
			</div>
		  <div data-options="region:'south'",split:true" style="height: 100px; border-style: none;"id="operation"></div>
		  <div id="panel_center" border="0" data-options="region:'center',border:false" style="width:700px;border:none;">
			<table id="baryxxbDetailGrid" class="easyui-datagrid" style="width:700px;height:170px;" 
				data-options="url:'',
				fitColumns:true,
				singleSelect:true,
	    		delayCountUrl:'<%=basePath%>',
	    		toolbar:'#baryxxbDetailGridToolbar',
	    		pageSize:getAutoPageSize(300),
	    		pageList:[getAutoPageSize(300),
	    		getAutoPageSize(300) * 2]">
    			<thead>   
			        <tr>   
			            <th data-options="field:'xm',width:120,align:'center',fixed:true">操作时间</th>
			        	<th data-options="field:'zjhm',width:140,align:'center',fixed:true">操作人</th>
			            <th data-options="field:'lxdh',width:140,align:'center',fixed:true">操作部门</th>
			            <th data-options="field:'lxdh',width:140,align:'center',fixed:true">操作类型</th>   
			            <th data-options="field:'lxdh',width:140,align:'center',fixed:true">说明</th>   
			        </tr>   
			    </thead>
    		</table>
		 </div>
		</div>
	</div>
</body>
</html>