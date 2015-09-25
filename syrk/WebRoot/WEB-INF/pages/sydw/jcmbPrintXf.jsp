<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/commonInclude.jsp"%>
<%@ page import="com.founder.framework.base.entity.SessionBean"%>
<%
    SessionBean userInfo = (SessionBean)session.getAttribute("userSession");
    String userOrgCode = "";
    String userOrgName = "";
    String bjzbz = "";
    String xzqhdm = "";
    if(userInfo!=null){
        userOrgCode = userInfo.getUserOrgCode();
        userOrgName = userInfo.getUserOrgName();
        bjzbz = userInfo.getBjzbz();
        if(!"".equals(userOrgCode)&&userOrgCode!=null){
        	xzqhdm = userOrgCode.substring(0,6);
        }
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style>
table.all{
 font-size:16px;
 
 }
.table_1 {border: 1px solid #FFF;border-collapse: collapse;}
.table_1 td{border: 1px solid #FFF;}
.table {border: 1px solid #333333;border-collapse: collapse;}
.table td{border: 1px solid #333333;}
</style>
</head>
<body>
	<table width="100%"  cellpadding="2" cellspacing="0">
		<tr>
			<td width="100%">
				<input type='hidden' id="dzvalue" value="<%=xzqhdm%>"/>
				<div align="center" style="width: 100%;padding: 5px 0 5px 0">
					<span id="spanid" style="font-size: 18px"></span>
				</div>
				<div align="center" style="width: 100%;padding: 10px 0 10px 0">
					<span style="font-size: 26px">公安派出所日常消防监督检查记录</span>
				</div>
					<table  class="table" cellpadding="0" cellspacing="0" align="center">
					    <div align="right" style="width: 100%;padding: 8px 0 8px 0">
							<span style="font-size: 15px">编号：[&nbsp;&nbsp;&nbsp;&nbsp;]&nbsp;第&nbsp;&nbsp;&nbsp;号</span>
						</div>
					    <tr>
							<td colspan="3" height="160">
								<table class="table_1" style="text-align:center;width: 100%;" cellpadding="0" cellspacing="0">
									<tr height="40">
										<td>单位(场所)名称</td>
										<td colspan="3">&nbsp;</td>
										<td>法定代表人/主要负责人</td>
										<td>&nbsp;</td>
									</tr>
									<tr height="40">
										<td>地址</td>
										<td colspan="3">&nbsp;</td>
										<td>单位性质</td>
										<td>&nbsp;</td>
									</tr>
									<tr height="40">
										<td style="width: 16%;">
										 使用的建筑面积(㎡)
										</td>
										<td style="width: 16%;">&nbsp;</td>
										<td style="width: 16%;">
										使用的建筑具体层数
										</td>
										<td style="width: 16%;">&nbsp;</td>
										<td style="width: 16%;">
										所在建筑高度(m)
										</td>
										<td style="width: 16%;">&nbsp;</td>
									</tr>
									<tr height="40">
										<td style="width: 16%;">
										 监督检查人员
										  (签名)
										</td>
										<td style="width: 16%;">&nbsp;</td>
										<td style="width: 16%;">
										单位随同检查人员
										   (签名)
										</td>
										<td style="width: 16%;">&nbsp;</td>
										<td style="width: 16%;">
										检查日期
										</td>
										<td style="width: 16%;">&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr style="text-align:center; font-size:20px">
							<td colspan="3" height="40">
								检查内容和情况记录
							</td>
						</tr>
						<tr>
							<td style="width: 50px;text-align: center;font-size: 13px;"  rowspan="5">
								单位履行消防安全职责情况
							</td>
							<td style="width: 25px;text-align: center;font-size: 13px;" >
								合法性
							</td>
							<td style="text-align: left;font-size: 13px;height: 80px;line-height: 2em;" class="tdb">
								被查建筑物名称：
								<textarea  type="text"  class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 250px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
								<input type="checkbox" value="1" onclick="return false;"/>1998年9月1日之前竣工建筑且此后未改建(含装修、用途变更)</br>
								<input type="checkbox" value="1" onclick="return false;"/>依法通过消防验收　 
								<input type="checkbox" value="1" onclick="return false;"/>依法进行竣工验收消防备案</br>
								其他情况：
								<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
								<input type="checkbox" value="1" onclick="return false;"/>是 
								<input type="checkbox" value="0" onclick="return false;"/>否   公众聚集场所</br>
					　			依法通过投入使用、营业前消防安全检查　 
								<input type="checkbox" value="1" onclick="return false;"/>是
								<input type="checkbox" value="0" onclick="return false;"/>否
							</td>
						</tr>
						<tr>
							<td style="width: 25px;text-align: center;font-size: 13px;" class="tdbr">
								消防安全管理
							</td>
							<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
								1.消防安全制度
								<input type="checkbox" value="1" onclick="return false;"/>有　 
								<input type="checkbox" value="0" onclick="return false;"/>无</br>
								2.员工消防安全教育培训　
								<input type="checkbox" value="1" onclick="return false;"/>组织开展  
								<input type="checkbox" value="0" onclick="return false;"/>未组织开展</br>
								3.防火检查　　　　　　　
							    <input type="checkbox" value="1" onclick="return false;"/>组织开展  
							    <input type="checkbox" value="0" onclick="return false;"/>未组织开展</br>
								4.灭火和应急疏散预案　　
							    <input type="checkbox" value="1" onclick="return false;"/>有　  
							    <input type="checkbox" value="0" onclick="return false;"/>无</br>
								5.消防演练　　　　　　　 
								<input type="checkbox" value="1" onclick="return false;"/>组织 
							    <input type="checkbox" value="0" onclick="return false;"/>未组织</br>
								6.其他情况：
							</td>
						</tr>
						<tr>
							<td style="width: 25px;text-align: center;font-size: 13px;" class="tdbr">
								建筑防火
							</td>
							<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
								1.消防车通道　　
								<input type="checkbox" value="0" onclick="return false;"/>畅通　    
							    <input type="checkbox" value="1" onclick="return false;"/>被堵塞、占用　
							    <input type="checkbox" value="2" onclick="return false;"/>无</br>
								2.疏散通道　　　
								<input type="checkbox" value="0" onclick="return false;"/>畅通　     
								<input type="checkbox" value="1" onclick="return false;"/>堵塞　               
								<input type="checkbox" value="2" onclick="return false;"/>锁闭</br>
								3.安全出口　　　
								<input type="checkbox" value="0" onclick="return false;"/>畅通　     
								<input type="checkbox" value="1" onclick="return false;"/>堵塞　                
								<input type="checkbox" value="2" onclick="return false;"/>锁闭 
								<input type="checkbox" value="3" onclick="return false;"/>缺少</br>
								4.防火门　　       　        
								<input type="checkbox" value="0" onclick="return false;"/>完好有效 
								<input type="checkbox" value="1" onclick="return false;"/>常闭式防火门常开  
								<input type="checkbox" value="2" onclick="return false;"/>损坏　
								<input type="checkbox" value="3" onclick="return false;"/>不涉及</br>
								5.疏散指示标志　
								<input type="checkbox" value="0" onclick="return false;"/>完好有效 
								<input type="checkbox" value="1" onclick="return false;"/>损坏                   
							    <input type="checkbox" value="2" onclick="return false;"/>缺少 
							    <input type="checkbox" value="3" onclick="return false;"/>无</br>
								6.应急照明　　　
								<input type="checkbox" value="0" onclick="return false;"/>完好有效 
								<input type="checkbox" value="1" onclick="return false;"/>损坏                   
							    <input type="checkbox" value="2" onclick="return false;"/>缺少 
							    <input type="checkbox" value="3" onclick="return false;"/>无</br>
								7.人员密集场所外墙门窗上是否设置影响逃生、灭火救援的障碍物　　
								<input type="checkbox" value="0" onclick="return false;"/>否 
								<input type="checkbox" value="1" onclick="return false;"/>是
								<input type="checkbox" value="2" onclick="return false;"/>不涉及</br>
								8.其他情况：
							</td>
						</tr>
						<tr>
							<td style="width: 25px;text-align: center;font-size: 13px;" class="tdbr">
								消防设施
							</td>
							<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
								1.室内消火栓　　
								<input type="checkbox" value="0" onclick="return false;"/>未设置
							    <input type="checkbox" value="1" onclick="return false;"/>完好有效 
							    <input type="checkbox" value="2" onclick="return false;"/>损坏 
							    <input type="checkbox" value="3" onclick="return false;"/>无水</br>
								<input type="checkbox" value="4" onclick="return false;"/>配件不齐 
								<input type="checkbox" value="5" onclick="return false;"/>被遮挡、圈占
								<input type="checkbox" value="6" onclick="return false;"/>不涉及</br>
								2.灭火器　　　　
								<input type="checkbox" value="0" onclick="return false;"/>未配置 
								<input type="checkbox" value="1" onclick="return false;"/>完好有效 
								<input type="checkbox" value="2" onclick="return false;"/>失效 
								<input type="checkbox" value="3" onclick="return false;"/>缺少
								<input type="checkbox" value="4" onclick="return false;"/>配置类型错误 
								<input type="checkbox" value="5" onclick="return false;"/>设置地点不当</br>
								3.建筑消防设施　
								<input type="checkbox" value="0" onclick="return false;"/>定期维修保养并记录 
								<input type="checkbox" value="0" onclick="return false;"/>无记录
								<input type="checkbox" value="1" onclick="return false;"/>未定期维修保养　　
							    <input type="checkbox" value="2" onclick="return false;"/>不涉及</br>
								4.物业服务企业对管理区域内共用消防设施是否维护管理　
								<input type="checkbox" value="1" onclick="return false;"/>是　 
								<input type="checkbox" value="0" onclick="return false;"/>否　
							    <input type="checkbox" value="2" onclick="return false;"/>不涉及
							</td>
						</tr>
						<tr>
							<td style="width: 25px;text-align: center;font-size: 13px;" class="tdbr">
								危险品管理
							</td>
							<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									1.是否存在违反规定使用明火作业或在具有火灾、爆炸危险的场所吸烟、使用明火</br>
　　　　　　　　　　　　　　　　　　　　　　　　<input type="checkbox" value="0" onclick="return false;"/>否 
								<input type="checkbox" value="1" onclick="return false;"/>是 
								<input type="checkbox" value="2" onclick="return false;"/>不涉及</br>
								2.是否存在违反消防安全规定进入生产、储存易燃易爆危险品场所　　　　
								<input type="checkbox" value="0" onclick="return false;"/>否 
								<input type="checkbox" value="1" onclick="return false;"/>是 
								<input type="checkbox" value="2" onclick="return false;"/>不涉及</br>
								3.生产、储存、经营易燃易爆危险品的场所是否与居住场所设置在同一建筑物内</br>
								<input type="checkbox" value="0" onclick="return false;"/>否
								<input type="checkbox" value="1" onclick="return false;"/>是 
								<input type="checkbox" value="2" onclick="return false;"/>不涉及</br>
							</td>
						</tr>
						<tr>
							<td colspan="2" style="width: 60px;text-align: center;font-size: 13px;" class="tdbr">
								村(居)民委 员 会履行消防安全职责情况
							</td>
							<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
								1.消防安全管理人　　　
								<input type="checkbox" value="0" onclick="return false;"/>确定 
								<input type="checkbox" value="1" onclick="return false;"/>未确定</br>
								2.消防安全工作制度　　
								<input type="checkbox" value="0" onclick="return false;"/>有　 
								<input type="checkbox" value="1" onclick="return false;"/>无</br>
								3.防火安全公约　　　　
								<input type="checkbox" value="0" onclick="return false;"/>有　 
								<input type="checkbox" value="1" onclick="return false;"/>无</br>
								4.消防宣传教育　　　　
								<input type="checkbox" value="0" onclick="return false;"/>开展 
								<input type="checkbox" value="1" onclick="return false;"/>未开展</br>
								5.防火安全检查　　　　
								<input type="checkbox" value="0" onclick="return false;"/>开展 
								<input type="checkbox" value="1" onclick="return false;"/>未开展</br>
								6.消防水源、消防车通道、消防器材　　　　
								<input type="checkbox" value="0" onclick="return false;"/>维护管理
								<input type="checkbox" value="1" onclick="return false;"/>未维护管理</br>
								7.多种形式消防组织　　
								<input type="checkbox" value="0" onclick="return false;"/>建立 
								<input type="checkbox" value="1" onclick="return false;"/>未建立</br>
							</td>
						</tr>
						<tr>
							<td colspan="2" style="width: 60px;text-align: center;font-size: 13px;" class="tdbr">
								责令改正情况
							</td>
							<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
								制发的法律文书名称和编号：
							</td>
						</tr>
						<tr>
							<td colspan="2" style="width: 60px;text-align: center;font-size: 13px;" class="tdbr">
								移送公安消防机构处理的内容
							</td>
							<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
								发现的下列第
								<input type="text"  id="fxdxld" class="easyui-validatebox" style="text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 40px;border-color: #333333;line-height: 22px;" readOnly="readonly"/>
								项消防安全违法行为，移送
								<textarea   class="easyui-validatebox" style="text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;line-height: 24px;" disabled="disabled"></textarea>依法处理：</br>
								<input type="checkbox" value="0" onclick="return false;"/>1.建筑物未依法通过公安机关消防机构消防验收，擅自投入使用；</br>
								<input type="checkbox" value="1" onclick="return false;"/>2.建筑物未依法进行竣工验收消防备案；</br>
								<input type="checkbox" value="2" onclick="return false;"/>3.公众聚集场所未依法通过使用、营业前消防安全检查，擅自投入使用、营业。</br>
							</td>
						</tr>
						<tr height="80">
							<td colspan="2" style="width: 60px;height:30px;text-align: center;font-size: 13px;" class="tdr">
								备注
							</td>
							<td style="text-align: left;font-size: 13px;line-height: 2em;">
								&nbsp;
							</td>
						</tr>
					</table>
				<table width="90%" height="147" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td class="noprint" align="center">
						<input onclick="javascript:this.style.display = 'none';window.print();"
							type="button" name="打印" value="打  印" id="b12" />&nbsp;&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
var dzvalue = document.getElementById("dzvalue").value;
var isReload = false;
var publicDictArray = new Array(); // 字典管理数组
window.onload=getDictName(contextPath + '/common/dict/D_BZ_XZQHLIST_MUNICIPAL.js',dzvalue);
function getDictName(url, dictID,isReload) {
	var dictName = "";
	if ("undefined" != typeof dictID && dictID != null && dictID != "") {
	
		var data = getPublicDict(url,isReload);
		if (data != null && data.length > 0) {
			var nameArray = [];
			var dictIDArray = dictID.split(",");
			var searchID = "";
			for (var j = 0; j < dictIDArray.length; j++) {
				searchID = dictIDArray[j];
				if (searchID != "") {
					for (var i = 0; i < data.length; i++) {
						if (data[i].id == searchID) {
							nameArray.push(data[i].text);
							break;
						}
						else if (data[i].children) {
							searchChildren(data[i].children, searchID, nameArray);
						}
					}
				}
			}
			dictName = nameArray.join(",");
		}
	}
	document.getElementById("spanid").innerHTML=dictName+"公安消防大队";
}
function getPublicDict(url, isReload) {
	if ("undefined" != typeof url && url != null && url != "") {
		if ("undefined" == typeof isReload) {
			isReload = false;
		}
		if (!isReload) {
			var dictData = publicDictArray[url];
			if (dictData != null) {
				return dictData;
			}
		}
		
		$.ajax({
			url: url,
			cache: false,
			type: "GET",
			async: false, 
			dataType: "json",
			success: function(data) {
				publicDictArray[url] = data;
			},

			error: function() {
				alert("顶层页面字典加载错误：\n\n" + url);
			}
		});
		
		return publicDictArray[url];
	}
	return null;
}
function searchChildren(node, searchID, nameArray) {
	for (var i = 0; i < node.length; i++) {
		if (node[i].id == searchID) {
			nameArray.push(node[i].text);
			return true;
		}
		else if (node[i].children) {
			if (searchChildren(node[i].children, searchID, nameArray)) {
				return true;
			}
		}
	}
	return false;
}
</script>  
</html>