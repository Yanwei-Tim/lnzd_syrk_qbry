<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commonInclude.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style>
.thhead {
	text-align: center;
	background: #333333;
	border: 1px solid #333333;
}

.tdbr {
	border-right: 1px solid #333333;;
	border-bottom: 1px solid #333333;;
}

.tdb {
	border-bottom: 1px solid #333333;
}

.tdr {
	border-right: 1px solid #333333;
}
</style>
</head>
<body>
	<table class="font" width="100%" border="0" cellpadding="2"
		cellspacing="0">
		<tr>
			<td width="100%">
				<div align="center" style="width: 100%;padding: 15px 0 15px 0">
					<span style="font-size: 26px">技防单位检查模板</span>
				</div>
				<table style="border:black 2px solid;" cellpadding="0" cellspacing="10" width="860px" align="center">
					<tr class="dialogTr">
						<td width="16%" class="dialogTd" align="right">监督检查人员：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">监督检查时间：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="16%" class="dialogTd" align="right">被检查单位（场所）名称：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">单位性质：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="16%" class="dialogTd" align="right">被检查单位法定代表人姓名：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">联系电话：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="16%" class="dialogTd" align="right">被检查单位分管负责人姓名：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">联系电话：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="16%" class="dialogTd" align="right">被检查单位（协助检查）人员：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">联系电话：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr>
						<td width="16%" class="dialogTd" align="right">被检查人签名：</td>
						<td width="36%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
						<td width="18%" class="dialogTd" align="right">联系电话：</td>
						<td width="30%" class="dialogTd">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="16%" class="dialogTd" align="right">地址：</td>
						<td width="84%" class="dialogTd" colspan='3'>
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 632px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="23%" class="dialogTd" align="right" style="vertical-align: top;"><br />检查内容和情况记录：</td>
						<td width="78%" class="dialogTd" colspan="3">
						<table style="width:633px;border:  1px solid #333333;" cellpadding="0" cellspacing="0">
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" >
									检查项目
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									检查内容
								</td>
								<td style="text-align: center;font-size: 13px;height: 40px;line-height: 2em;" class="tdbr">
									检查判据
								</td>
								<td style="text-align: center;font-size: 13px;height: 40px;line-height: 2em;" class="tdb">
									存在问题
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="5">
									安全技术防范系统档案
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									值机人员档案
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有档案；档案有人员培训和上、离岗日期
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无档案
									<input type="checkbox" value="1" onclick="return false;"/></br>
									无人员培训记录
									<input type="checkbox" value="1" onclick="return false;"/></br>
									无上、离岗日期
									<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									工程档案
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有档案；档案中有方案论证、工程检验报告、竣工验收文件
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无档案
									<input type="checkbox" value="1" onclick="return false;"/></br>
									档案中无方案论证、工程检验报告、竣工验收文件
									<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									巡检档案
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有档案；档案中有巡检时间，巡检单位及人员
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无
									<input type="checkbox" value="1" onclick="return false;"/></br>
									无时间
									<input type="checkbox" value="1" onclick="return false;"/></br>
									无巡检单位及人员
									<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									监控值班记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有记录；记录不缺页项；不涂改；有签字
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无记录
									<input type="checkbox" value="1" onclick="return false;"/></br>
									记录缺页项
									<input type="checkbox" value="1" onclick="return false;"/></br>
									有涂改
									<input type="checkbox" value="1" onclick="return false;"/></br>
									无签字
									<input type="checkbox" value="1" onclick="return false;"/>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									安全检查记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有记录；记录中签字齐全
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无记录
									<input type="checkbox" value="1" onclick="return false;"/></br>
									记录中无签字
									<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr">
									突发事件处置预案
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									发生抢劫、盗窃、一般治安事件、系统故障等的处置预案
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有前述四种处置预案
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无预案
									<input type="checkbox" value="1" onclick="return false;"/></br>
									预案不全
									<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="5">
									监控值班记录
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									交接班记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有记录；有签字
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无记录
									<input type="checkbox" value="1" onclick="return false;"/></br>
									无签字
									<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									系统布、撤防记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有布、撤时间记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无记录
									<input type="checkbox" value="1" onclick="return false;"/></br>
									记录不全
									<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									报警记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有报警时间、性质；有处置结果记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无报警时间
									<input type="checkbox" value="1" onclick="return false;"/></br>
									无报警性质
									<input type="checkbox" value="1" onclick="return false;"/></br>
									无处置结果记录
									<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									故障记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有故障时间；现象记录；维修时间；恢复使用时间的记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无故障时间<input type="checkbox" value="1" onclick="return false;"/></br>
									无故障现象<input type="checkbox" value="1" onclick="return false;"/></br>
									无维修时间<input type="checkbox" value="1" onclick="return false;"/></br>
									无恢复时间<input type="checkbox" value="1" onclick="return false;"/>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									演练记录
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									有记录；有人防力量处置时间和效果
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									无记录<input type="checkbox" value="1" onclick="return false;"/></br>
									记录中无处置时间<input type="checkbox" value="1" onclick="return false;"/></br>
									记录中无处置效果<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="2">
									重点要害部位
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									探测器防范效果
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									探测器探测灵敏；探测器满足覆盖要求
								</td>
								<td style="text-align: left;font-size: 13px;height: 60px;line-height: 2em;" class="tdb">
									探测器不灵敏<input type="checkbox" value="1" onclick="return false;"/></br>
									探测器不满足覆盖要求<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									摄像机监控效果
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									摄像机布设满足防范要求；图像清晰可辨
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									摄像机布设不满足防范要求<input type="checkbox" value="1" onclick="return false;"/></br>
									图像不清晰<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="3">
									主要通道
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									探测器防范效果
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									探测器探测灵敏；探测器满足覆盖要求
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									探测器不灵敏<input type="checkbox" value="1" onclick="return false;"/></br>
									探测器不满足覆盖要求<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									出入口控制
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									满足设防要求
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									不满足设防要求<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									摄像机监控效果
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									摄像机布设满足防范要求；图像清晰可辨
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									摄像机布设不满足防范要求<input type="checkbox" value="1" /></br>
									图像不清晰<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="3">
									周界
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									探测器防范效果
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									探测器探测灵敏；探测器满足覆盖要求
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									探测器不灵敏<input type="checkbox" value="1" onclick="return false;"/></br>
									探测器不满足覆盖要求<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									出入口控制
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									满足设防要求
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									不满足设防要求<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									摄像机监控效果
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									摄像机布设满足防范要求；图像清晰可辨
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									摄像机布设不满足防范要求<input type="checkbox" value="1" /></br>
									图像不清晰<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="3">
									报警监控存储
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr"rowspan="2">
									报警、视频监控资料记录、存储效果
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									记录时间准确，误差在60秒内
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									不准确<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									记录的图像满足公安侦查取证要求
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									不满足公安侦查取证要求<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									图像存储容量
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									图像存储时间满足规定的期限要求
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									不满足规定的存储期限要求<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" >
									监控室
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									报警通信手段和实体防护措施
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									两种报警手段；门、窗实体防护
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									没有两种报警手段<input type="checkbox" value="1" onclick="return false;"/></br>
									没有实体防护<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" rowspan="2">
									操作使用熟练程度
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									布、撤防操作
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									掌握操作程序；熟练完成布、撤防操作任务
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									不掌握操作程序<input type="checkbox" value="1" onclick="return false;"/></br>
									布、撤防不熟练<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									突发事件处置能力
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdbr">
									熟练叙述处置流程；熟记报警电话号码
								</td>
								<td style="text-align: left;font-size: 13px;line-height: 2em;" class="tdb">
									不能熟练叙述<input type="checkbox" value="1" onclick="return false;"/></br>
									不能熟记报警电话<input type="checkbox" value="1" onclick="return false;"/></br>
								</td>
							</tr>
							<tr>
								<td style="width: 70px;text-align: center;font-size: 13px;" class="tdbr" >
									检查结果
								</td>
								<td style="width: 200px;text-align: center;font-size: 13px;" class="tdbr">
									<input type="checkbox" value="1" onclick="return false;"/>合格　
									<input type="checkbox" value="0" onclick="return false;"/>不合格 　　　　　　　　
									<span style="border-left: 1px solid #95B8E7;line-height: 30px;"></span>
								</td>
								<td colspan="2"  style="text-align: left;font-size: 13px;line-height: 2em;">
									检查状态:
									<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 200px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="23%" class="dialogTd" align="right">检查结果：</td>
						<td width="33%" class="dialogTd" colspan="3">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 634px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="23%" class="dialogTd" align="right">整改或处罚意见：</td>
						<td width="33%" class="dialogTd" colspan="3">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 634px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
					<tr class="dialogTr">
						<td width="23%" class="dialogTd" align="right">检查情况：</td>
						<td width="33%" class="dialogTd" colspan="3">
						<textarea  type="text" class="easyui-validatebox" style="line-height: 20px;text-align:center;background:white;border-top: 0px;border-left: 0px;border-right: 0px;width: 634px;border-color: #333333;overflow: hidden;" disabled="disabled"></textarea></br>
						</td>
					</tr>
				</table>
				<table width="90%" height="147" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td class="noprint" align="center"><input
							onclick="javascript:this.style.display = 'none';window.print();"
							type="button" name="打印" value="打  印" id="b12" />&nbsp;&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>