<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

    <form  id ="addForm"
     action="qbryManager/qbryget" method="post">

     <table>
     <tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">情报人员ID：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="id" name="id" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">部级重点人员编号：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bjzdrybh" name="bjzdrybh" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">姓名：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xm" name="xm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">姓名拼音：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xmhypy" name="xmhypy" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">外文姓名：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="wwxm" name="wwxm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">性别：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xbdm" name="xbdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">出生日期：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="csrq" name="csrq" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">国籍：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="gjdm" name="gjdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
	<td width="20%" class="dialogTd" align="right">身份证号：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="gmsfhm" name="gmsfhm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">其他证件号码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="qtzjhm" name="qtzjhm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">民族：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="mzdm" name="mzdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">籍贯：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jgssxdm" name="jgssxdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">户籍地：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="hjd" name="hjd" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">现住地：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xzd" name="xzd" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">现住地派出所名称：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xzdpcsmc" name="xzdpcsmc" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">现住地派出所代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="xzdpcsdm" name="xzdpcsdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">居住地：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="jzd" name="jzd" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">管辖单位：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="gxdwmc" name="gxdwmc" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">管辖单位机构代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="gxdwdm" name="gxdwdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">立案单位:</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ladwmc" name="ladwmc" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">立案单位机构代码：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="ladwdm" name="ladwdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">立案时间:</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="lasj" name="lasj" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">部级重点人员入库时间：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bjzdryrksj" name="bjzdryrksj" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">情报人员类别（小类）:</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zdrylb" name="zdrylb" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">情报人员管理类型代码（大类）：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="zdrygllxdm" name="zdrygllxdm" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">有效性:</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="yxx" name="yxx" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">ETL时间：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="etldate" name="etldate" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">实有人口ID：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="syrkid" name="syrkid" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">情报人员所属支队:</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="qbzd" name="qbzd" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">情报人员所属大队：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="qbdd" name="qbdd" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">情报人员所属派出所:</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="qbpcs" name="qbpcs" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">情报人员所属责任区：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="qbzrq" name="qbzrq" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">当前级别:</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="dqjb" name="dqjb" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>
<tr class="dialogTr">
<td width="20%" class="dialogTd" align="right">管理状态：</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="glzt" name="glzt" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
	<td width="20%" class="dialogTd" align="right">备注:</td>
	<td width="30%" class="dialogTd"><input class="easyui-validatebox" type="text" id="bz" name="bz" maxlength="20" style="width:200px;" data-options="charSet:'halfUpper'"  value=""/></td>
</tr>

</table>
<input type="submit" value="提交">
<input type="reset"  value="重置">
</form>
</body>




</html>