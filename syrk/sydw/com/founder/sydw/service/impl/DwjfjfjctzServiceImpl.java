package com.founder.sydw.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.cxf.aegis.databinding.AegisDatabinding;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessageRemind;
import com.founder.framework.message.service.SysMessageRemindService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.Dwjcdata;
import com.founder.sydw.bean.Dwjctype;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.bean.Dwjffctzs;
import com.founder.sydw.bean.Dwjffctzscg;
import com.founder.sydw.bean.Dwjfjfjctzs;
import com.founder.sydw.bean.Dwjfjfjctzscg;
import com.founder.sydw.bean.Dwjfzltzs;
import com.founder.sydw.dao.DwjbxxbDao;
import com.founder.sydw.dao.DwjcxxbDao;
import com.founder.sydw.dao.DwjffctzsDao;
import com.founder.sydw.dao.DwjffctzscgDao;
import com.founder.sydw.dao.DwjfjfjctzsDao;
import com.founder.sydw.dao.DwjfjfjctzscgDao;
import com.founder.sydw.dao.DwjfzltzsDao;
import com.founder.sydw.html2jpg.Base64;
import com.founder.sydw.html2jpg.GraphUtils;
import com.founder.sydw.service.DwjcxxbService;
import com.founder.sydw.service.DwjfjfjctzService;
import com.neusoft.webservice.webserviceserver.bo.cj.CjWebServiceBO;

@Transactional
@Service("dwjfjfjctzService")
public class DwjfjfjctzServiceImpl extends BaseService implements DwjfjfjctzService {

	@Resource(name = "dwjfjfjctzsDao")
	private DwjfjfjctzsDao dwjfjfjctzsDao;
	@Resource(name = "dwjfjfjctzscgDao")
	private DwjfjfjctzscgDao dwjfjfjctzscgDao;
	@Resource(name = "dwjcxxbService")
	private DwjcxxbService dwjcxxbService;
	@Resource(name = "dwjcxxbDao")
	private DwjcxxbDao dwjcxxbDao;
	@Resource(name = "dwjfzltzsDao")
	private DwjfzltzsDao dwjfzltzsDao;
	@Resource(name = "dwjffctzsDao")
	private DwjffctzsDao dwjffctzsDao;
	@Resource(name = "dwjffctzscgDao")
	private DwjffctzscgDao dwjffctzscgDao;
	@Resource
	private SysMessageRemindService sysMessageRemindService;
	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;

	@Override
	public void saveJfjfjctzs(Dwjfjfjctzs entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		this.dwjfjfjctzsDao.saveEntity(entity);

		// 更新检查时间
		Dwjcxxb dwjcxxb = this.dwjcxxbDao.query(entity.getJcid());
		dwjcxxb.setJcsj(entity.getJcrq());
		this.dwjcxxbDao.update(dwjcxxb, sessionBean);

		try {
			// 生成系统定时消息
			String mess = "您于" + DateUtils.getSystemDateString() + "对 " + dwjcxxb.getDwmc() + " 单位下发的单位检查通知书，检查日期为"
					+ entity.getJcrq() + ",请做好对该单位的检查准备！";

			SysMessageRemind message = this.buildMessage("单位技防检查提醒", mess, sessionBean);
			String sendDateStr = this.getSendDate(entity.getJcrq(), -10);
			sendDateStr = sendDateStr.replace("年", "-");
			sendDateStr = sendDateStr.replace("月", "-");
			sendDateStr = sendDateStr.replace("日", "-");
			message.setTxrq(sendDateStr);
			message.setYwid(entity.getId());

			this.sysMessageRemindService.saveMessageByOrg(message, sessionBean.getUserOrgCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getSendDate(String tzDateStr, int preDateCount) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		Date d = null;
		try {
			d = df.parse(tzDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (d == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, preDateCount);
		return df.format(cal.getTime());
	}

	@Override
	public void saveJfjfjctzscg(Dwjfjfjctzscg entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		this.dwjfjfjctzscgDao.saveEntity(entity);
	}

	@Override
	public void updateJfjfjctzs(Dwjfjfjctzs entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		dwjfjfjctzsDao.update(entity);
	}

	@Override
	public void updateJfjfjctzscg(Dwjfjfjctzscg entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		dwjfjfjctzscgDao.update(entity);
	}

	@Override
	public void saveJfdwjctjl(Dwjcxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		this.dwjcxxbDao.update(entity, sessionBean);
	}

	@Override
	public void saveJfzltzs(Dwjfzltzs entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		this.dwjfzltzsDao.saveEntity(entity);

		// //生成定时消息
		// //生成系统定时消息
		// String mess = "您于"+DateUtils.getSystemDateString()+"对
		// "+dwjcxxb.getDwmc()+" 单位下发的单位检查通知书，检查日期为"
		// + entity.getf + ",请做好对该单位的检查准备！";
		// SysMessageRemind message = this.buildMessage("单位技防检查提醒", mess,
		// sessionBean);
		// this.sysMessageRemindService.saveMessageByOrg(message,
		// sessionBean.getUserOrgCode());
	}

	@Override
	public void updateJfzltzs(Dwjfzltzs entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		this.dwjfzltzsDao.update(entity);
	}

	@Override
	public void saveJffctzs(Dwjffctzs entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		this.dwjffctzsDao.saveEntity(entity);
	}

	@Override
	public void updateJffctzs(Dwjffctzs entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		this.dwjffctzsDao.update(entity);
	}

	@Override
	public void saveJffctzscg(Dwjffctzscg entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		this.dwjffctzscgDao.saveEntity(entity);

	}

	@Override
	public void updateJffctzscg(Dwjffctzscg entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		this.dwjffctzscgDao.update(entity);

	}

	private SysMessageRemind buildMessage(String bt, String nr, SessionBean sessionBean) {
		SysMessageRemind entity = new SysMessageRemind();
		entity.setXxbt(bt);
		entity.setXxnr(nr);
		entity.setXxlb("1");// 1是消息提醒
		entity.setSfck("0");// 是否查看
		entity.setJslx("1"); // 0 按人 1按部门
		entity.setFsr(sessionBean.getUserName());
		entity.setFsrdm(sessionBean.getUserId());
		entity.setFssj(DateUtils.getSystemDateTimeString());
		entity.setFsrssdw(sessionBean.getUserOrgCode());
		entity.setFsrssdwdm(sessionBean.getUserOrgCode());
		return entity;
	}

	@Override
	public String getWhHead(SessionBean sessionBean) {

		String userOrgcode = sessionBean.getUserOrgCode();
		String codeHead = userOrgcode.substring(2, 4);
		if ("01".equals(codeHead)) {
			return "沈";
		} else if ("02".equals(codeHead)) {
			return "大";
		} else if ("03".equals(codeHead)) {
			return "鞍";
		} else if ("04".equals(codeHead)) {
			return "抚";
		} else if ("05".equals(codeHead)) {
			return "本";
		} else if ("06".equals(codeHead)) {
			return "丹";
		} else if ("07".equals(codeHead)) {
			return "锦";
		} else if ("08".equals(codeHead)) {
			return "营";
		} else if ("09".equals(codeHead)) {
			return "阜";
		} else if ("10".equals(codeHead)) {
			return "辽";
		} else if ("11".equals(codeHead)) {
			return "铁";
		} else if ("12".equals(codeHead)) {
			return "盘";
		} else if ("13".equals(codeHead)) {
			return "朝";
		} else if ("14".equals(codeHead)) {
			return "葫";
		} else {
			return null;
		}

	}

	@Override
	public String getGzsjStrArray(String jcsj) {

		if (StringUtils.isBlank(jcsj)) {
			return null;
		}

		// getSendDate
		String zgsjArray = this.getSendDate(jcsj, 10);
		zgsjArray += "," + this.getSendDate(jcsj, 20);
		zgsjArray += "," + this.getSendDate(jcsj, 30);
		zgsjArray += "," + this.getSendDate(jcsj, 60);
		zgsjArray += "," + this.getSendDate(jcsj, 90);

		return zgsjArray;
	}

	@Override
	public String createAjxxid(String jcid, SessionBean sessionBean) {

		// 检查信息
		Dwjcxxb jcxx = this.dwjcxxbDao.query(jcid);
		String ajxxid = jcxx.getAjxxid();
		if (StringUtils.isBlank(ajxxid)) {
			String xmlData = this.buidXmlData(jcxx);
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println(xmlData);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
			factory.setServiceClass(CjWebServiceBO.class);
			factory.setAddress(
					"http://10.79.188.144:8080/lnxjz/ws/webService/webServiceServer/cj/CjWebService?eap_username=u023&eap_password=1");
			factory.getServiceFactory().setDataBinding(new AegisDatabinding());
			CjWebServiceBO service1 = (CjWebServiceBO) factory.create();
			ajxxid = service1.saveJfCjxx(xmlData);

			// 更新案件信息
			jcxx.setAjxxid(ajxxid);
			setUpdateProperties(jcxx, sessionBean);
			this.dwjcxxbDao.update(jcxx, sessionBean);
		}
		return ajxxid;
	}
	
	private String buidXmlData(Dwjcxxb jcxx) {

		Dwjbxxb dw = new Dwjbxxb();
		dw.setId(jcxx.getDwid());
		dw = this.dwjbxxbDao.query(dw);

		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='utf-8'?>");
		sb.append("<jwzhdata><jqxx><rows><row>");

		// -------------案件基本信息
		// TODO 警情发生地详址(责任区???????)
		sb.append("<filed label=\"JQFSDXZ\">"+this.dwjbxxbDao.queryXzqhNamebyXzqhdm(dw.getDz_dwdzssxdm())+"</filed>");
		// 简要警情
		sb.append("<filed label=\"JYJQ\">检查不合格</filed>");
		// 街景时间
		sb.append("<filed label=\"JJSJ\">");
		sb.append(DateUtils.getSystemDateString());
		sb.append("</filed>");

		sb.append("</row></rows></jqxx><sadwxx><rows><row>");

		// -----------单位信息
		// 单位id
		sb.append("<filed label=\"DWID\">");
		sb.append(jcxx.getDwid());
		sb.append("</filed>");
		// 单位名称
		sb.append("<filed label=\"DWMC\">");
		sb.append(jcxx.getDwmc());
		sb.append("</filed>");
		// TODO 单位性质(国营，私企？？？？？什么性质？？？？？？？、)
		sb.append("<filed label=\"DWXZ\">");
		//sb.append(dw.getJjlxdm());
		sb.append("</filed>");
		// 单位类别
		sb.append("<filed label=\"DWLX\">");
		//sb.append(dw.getDwlbdm());
		sb.append("</filed>");
		// 单位联系方式
		sb.append("<filed label=\"DWLXFS\">");
		sb.append(dw.getLxdh());
		sb.append("</filed>");
		// 营业执照号
		sb.append("<filed label=\"YYDWH\">");
		sb.append(dw.getYyzzh());
		sb.append("</filed>");
		// 税务登记号
		sb.append("<filed label=\"SWDJH\">");
		// sb.append();
		sb.append("</filed>");
		// 单位经营状态
		sb.append("<filed label=\"DWJYZT\">");
		// sb.append();
		sb.append("</filed>");
		// 单位所在地详址
		sb.append("<filed label=\"DWSZDXZ\">");
		sb.append(dw.getDz_dwdzxz());
		sb.append("</filed>");
		// 法定代表人姓名
		sb.append("<filed label=\"FDDBRXM\">");
		// sb.append();
		sb.append("</filed>");
		// 法定代表人证件类别
		sb.append("<filed label=\"FDDBRZJLB\">");
		// sb.append();
		sb.append("</filed>");
		// 法定代表人证件号码
		sb.append("<filed label=\"FDDBRZJHM\">");
		// sb.append();
		sb.append("</filed>");

		sb.append("</row></rows></sadwxx><wsxx><rows>");

		String jcid = jcxx.getId();
		
		// -------------插入具体文书信息
		sb.append("<row>");
		sb.append("<filed label=\"WSMC\">检查通知书</filed>");
		sb.append("<filed label=\"WSNR\">");
		 sb.append(this.getDwjfjfjctzsJpg(jcid));
		sb.append("</filed>");
		sb.append("</row>");

		// -------------插入具体文书信息
		sb.append("<row>");
		sb.append("<filed label=\"WSMC\">检查通知书存根</filed>");
		sb.append("<filed label=\"WSNR\">");
		sb.append(this.getDwjfjfjctzscgJpg(jcid));
		sb.append("</filed>");
		sb.append("</row>");
		
		// -------------插入具体文书信息
		sb.append("<row>");
		sb.append("<filed label=\"WSMC\">检查记录</filed>");
		sb.append("<filed label=\"WSNR\">");
		sb.append(this.getDwjfdwjcjlJpg(jcid));
		sb.append("</filed>");
		sb.append("</row>");
		
		// -------------插入具体文书信息
		sb.append("<row>");
		sb.append("<filed label=\"WSMC\">检查记录表</filed>");
		sb.append("<filed label=\"WSNR\">");
		sb.append(this.getDwjfdwjcjlbJbg(jcid));
		sb.append("</filed>");
		sb.append("</row>");
		
		// -------------插入具体文书信息
		sb.append("<row>");
		sb.append("<filed label=\"WSMC\">责令限期整改通知书</filed>");
		sb.append("<filed label=\"WSNR\">");
		sb.append(this.getDwjfzltzsJpg(jcid));
		sb.append("</filed>");
		sb.append("</row>");
		
		// -------------插入具体文书信息
		sb.append("<row>");
		sb.append("<filed label=\"WSMC\">复查通知书</filed>");
		sb.append("<filed label=\"WSNR\">");
		sb.append(this.getDwjffctzsJpg(jcid));
		sb.append("</filed>");
		sb.append("</row>");
		
		// -------------插入具体文书信息
		sb.append("<row>");
		sb.append("<filed label=\"WSMC\">复查通知书存根</filed>");
		sb.append("<filed label=\"WSNR\">");
		sb.append(this.getDwjffctzscgJpg(jcid));
		sb.append("</filed>");
		sb.append("</row>");
		
		sb.append("</rows></wsxx></jwzhdata>");
		
		
		return sb.toString();
	}

	private String getDwjfdwjcjlbJbg(String jcid) {

		Dwjcxxb dwjcxxb = new Dwjcxxb();
		dwjcxxb.setId(jcid);
		dwjcxxb = dwjcxxbService.query(dwjcxxb);

		List<Dwjctype> list = dwjcxxb.getList();

		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>技防检查通知书</title>");
		sb.append("<style>");
		sb.append("td{");
		sb.append("	font-family:楷体;");
		sb.append("	font-size:15px;");
		sb.append("	word-break : break-all;");
		sb.append("	vertical-align: top;");
		sb.append("}");
		sb.append(".title1{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".title2{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".wh{");
		sb.append("	text-align:right;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".thhead {");
		sb.append("	text-align: center;");
		sb.append("	background: #e1e1e1;");
		sb.append("	border: 1px solid #cccccc;");
		sb.append("}");
		sb.append(".tdbr {");
		sb.append("	border-right: 1px solid #cccccc;");
		sb.append("	border-bottom: 1px solid #cccccc;");
		sb.append("}");
		sb.append(".tdb {");
		sb.append("	border-bottom: 1px solid #cccccc;");
		sb.append("}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("	<div style='width:700px;height:978px;padding: 20px;border:1px solid #000000;margin:20px;'>");
		sb.append("		<table style='width:594px;' width='100%' align='center' border='0' cellpadding='0' cellspacing='6';>");
		sb.append("			<tr >");
		sb.append("				<td class='title2'>");
		sb.append("					公共安全技术防范系统检查记录表");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr style='margin-top: 50px'>");
		sb.append("				<td align='center'>");
		sb.append("					<table style='width:620px;border:  1px solid #cccccc;' cellpadding='0' cellspacing='0'>");
		sb.append("						<tr style='height: 25px;'>");
		sb.append("							<td style='width:130px;' class='thhead'>类目</td>");
		sb.append("							<td style='width:343px;' class='thhead'>检查项目</td>");
		sb.append("							<td style='width:20px;' class='thhead'>是</td>");
		sb.append("							<td style='width:20px;' class='thhead'>否</td>");
		sb.append("							<td style='width:97px;' class='thhead'>备注</td>");
		sb.append("						</tr>");

		if (list == null || list.isEmpty()) {
			sb.append("<tr>");
				sb.append("<td style='border-left:1px solid #cccccc;height:30px;color: red;text-align: center;font-size: 13px;' class='tdbr' colspan='5'>");
					sb.append("无配置检查项信息,请联系管理员...");
				sb.append("</td>");
			sb.append("</tr>");
		} else {
			int typeCount = 1;
			for (Dwjctype type : list) {
				sb.append("<tr>");
					sb.append("<td style='width:130px;' class='tdbr'>");
						sb.append(typeCount++);
						sb.append("、 ");
						sb.append(type.getName());
					sb.append("</td>");
					sb.append("<td colspan='4' style='width:490px;'>");
						sb.append("<table style='width:100%' cellpadding='0' cellspacing='0'>");
									int dataCount = 1;
									for (Dwjcdata data : type.getList()) {
										sb.append("<tr>");
											sb.append("<td style='width:400px;' class='tdbr'>");
												sb.append(dataCount++);
												sb.append("）");
												sb.append(data.getName());
											sb.append("</td>");
						
											if ("1".equals(data.getDef())) {
												sb.append("<td style='width:10px;' class='tdbr'>");
													sb.append("☑");
												sb.append("</td>");
												sb.append("<td style='width:10px;' class='tdbr'>");
													sb.append("□");
												sb.append("</td>");
											} else if (data.getDef() == "0") {
												sb.append("<td style='width:10px;' class='tdbr'>");
													sb.append("□");
												sb.append("</td>");
												sb.append("<td style='width:10px;' class='tdbr'>");
													sb.append("☑");
												sb.append("</td>");
											} else {
												sb.append("<td style='width:10px;' class='tdbr'>");
													sb.append("□");
												sb.append("</td>");
												sb.append("<td style='width:10px;' class='tdbr'>");
													sb.append("□");
												sb.append("</td>");
											}
											sb.append("<td style='width:100px;height: 100%;' class='tdb'>");
												sb.append(data.getBz());
											sb.append("</td>");
										sb.append("</tr>");
									}
								sb.append("</table>");
							sb.append("</td>");
						sb.append("</tr>");
			}
		}
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("		</table>");
		sb.append("	</div>");
		sb.append("</body>");
		sb.append("</html>");
		
		return this.converToBase64Str(sb.toString());
	}

	private String getDwjffctzscgJpg(String jcid) {
		Dwjffctzscg cg = new Dwjffctzscg();
		cg.setJcid(jcid);
		cg = this.dwjffctzscgDao.query(cg);

		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>复查意见书（存根）</title>");
		sb.append("<style>");
		sb.append("td{");
		sb.append("	font-family:楷体;");
		sb.append("	font-size:15px;");
		sb.append("	word-break : break-all;");
		sb.append("	vertical-align: top;");
		sb.append("}");
		sb.append(".title1{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".title2{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".wh{");
		sb.append("	text-align:right;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append("table{");
		sb.append("	border='0' cellpadding='0' cellspacing='6';");
		sb.append("}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("	<div style='width:700px;height:978px;padding: 20px;border:1px solid #000000;margin:20px;'>");
		sb.append("		<table style='width:594px;' width='100%' align='center'>");
		sb.append("			<tr >");
		sb.append("				<td class='title1'>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(cg.getZzjgmc());
		sb.append("					</span>公安（分）局");
		sb.append("				</td>");
		sb.append("				<td class='title2'>");
		sb.append("					复查意见书 <br>（存根）");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td style='text-align: right;'>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(cg.getWh());
		sb.append("					</span>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>《复查意见书文号》</td>");
		sb.append("							<td style='width:320px;border-bottom:1px solid #000;'>");
		sb.append(cg.getFcyjswh());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>复查单位</td>");
		sb.append("							<td style='width:400px;border-bottom:1px solid #000;'>");
		sb.append(cg.getDwmc());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>复查时间</td>");
		sb.append("							<td style='width:400px;border-bottom:1px solid #000;'>");
		sb.append(cg.getFcsj());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>监督检查人员</td>");
		sb.append("							<td style='width:350px;'>jcry cjry");
		if (StringUtils.isBlank(cg.getJcry())) {
			sb.append("__________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append(cg.getJcry());
			sb.append("</span>");
		}
		sb.append("、");
		if (StringUtils.isBlank(cg.getCjry())) {
			sb.append("__________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append(cg.getCjry());
			sb.append("</span>");
		}
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>责令限期整改通知书文号</td>");
		sb.append("							<td style='width:300px;border-bottom:1px solid #000;'>");
		sb.append(cg.getZltzswh());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>承办部门</td>");
		sb.append("							<td style='width:400px;border-bottom:1px solid #000;'>");
		sb.append(cg.getCbbm());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>批准人</td>");
		sb.append("							<td style='width:410px;border-bottom:1px solid #000;'>");
		sb.append(cg.getPzr());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>批准时间</td>");
		sb.append("							<td style='width:400px;border-bottom:1px solid #000;'>");
		sb.append(cg.getPzsj());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>送达时间</td>");
		sb.append("							<td style='width:400px;border-bottom:1px solid #000;'>");
		sb.append(cg.getSdrq());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td style='width:auto;'>抄送单位</td>");
		sb.append("							<td style='width:400px;border-bottom:1px solid #000;'>");
		sb.append(cg.getCsdw());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("		</table>");
		sb.append("	</div>");
		sb.append("</body>");
		sb.append("</html>");
		return this.converToBase64Str(sb.toString());
	}

	private String getDwjfdwjcjlJpg(String jcid) {
		Dwjcxxb jc = this.dwjcxxbDao.query(jcid);
		Dwjbxxb dw = new Dwjbxxb();
		dw.setId(jc.getDwid());
		dw = this.dwjbxxbDao.query(dw);
		jc.setDwmc(dw.getDwmc());

		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>技防检查通知书</title>");
		sb.append("<style>");
		sb.append(
				"td{                                                                                                                                    ");
		sb.append(
				"	font-family:楷体;                                                                                                                     ");
		sb.append(
				"	font-size:15px;                                                                                                                       ");
		sb.append(
				"	word-break : break-all;                                                                                                               ");
		sb.append(
				"	vertical-align: top;                                                                                                                  ");
		sb.append(
				"}                                                                                                                                      ");
		sb.append(
				".title1{                                                                                                                               ");
		sb.append(
				"	text-align:center;                                                                                                                    ");
		sb.append(
				"	font-size: 18px;                                                                                                                      ");
		sb.append(
				"	font-weight:700;                                                                                                                      ");
		sb.append(
				"}                                                                                                                                      ");
		sb.append(
				".title2{                                                                                                                               ");
		sb.append(
				"	text-align:center;                                                                                                                    ");
		sb.append(
				"	font-size: 18px;                                                                                                                      ");
		sb.append(
				"	font-weight:700;                                                                                                                      ");
		sb.append(
				"}                                                                                                                                      ");
		sb.append(
				".wh{                                                                                                                                   ");
		sb.append(
				"	text-align:right;                                                                                                                     ");
		sb.append(
				"	font-size: 18px;                                                                                                                      ");
		sb.append(
				"	font-weight:700;                                                                                                                      ");
		sb.append(
				"}                                                                                                                                      ");
		sb.append(
				"table{                                                                                                                                 ");
		sb.append(
				"	border='0' cellpadding='0' cellspacing='6';                                                                                           ");
		sb.append(
				"}                                                                                                                                      ");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("	<div style='width:700px;height:978px;padding: 20px;border:1px solid #000000;margin:20px;'>");
		sb.append("		<table style='width:594px;' width='100%' align='center'>");
		sb.append("			<tr >");
		sb.append("				<td class='title2'>");
		sb.append(
				"					公共安全技术防范检查记录                                                                                              ");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;监督检查人员：");
		if (StringUtils.isBlank(jc.getJcry())) {
			sb.append("__________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getJcry() + "  ");
			sb.append("</span>");
		}
		sb.append("、");
		if (StringUtils.isBlank(jc.getCjry())) {
			sb.append("__________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getCjry() + "  ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;监督检查时间：");
		if (StringUtils.isBlank(jc.getJcsj())) {
			sb.append("_________________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append(" " + jc.getJcsj() + " ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;被检查单位（场所）名称：");
		if (StringUtils.isBlank(jc.getDwmc())) {
			sb.append("____________________________________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getDwmc() + "  ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;地址：");
		if (StringUtils.isBlank(jc.getDz_dwdzxz())) {
			sb.append("________________________________________________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getDz_dwdzxz() + "  ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;被检查单位法定代表人姓名：");
		if (StringUtils.isBlank(jc.getFddbrxm())) {
			sb.append("_______________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getFddbrxm() + "  ");
			sb.append("</span>");
		}
		sb.append("&nbsp;&nbsp;     ");
		sb.append("				联系电话：");
		if (StringUtils.isBlank(jc.getFddbrlxdh())) {
			sb.append("____________________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append(" " + jc.getFddbrlxdh() + " ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;被检查单位分管负责人姓名：");
		if (StringUtils.isBlank(jc.getDwfgfzrxm())) {
			sb.append("_______________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getDwfgfzrxm() + "  ");
			sb.append("</span>");
		}
		sb.append("&nbsp;&nbsp;   ");
		sb.append("				联系电话：");
		if (StringUtils.isBlank(jc.getDwfgfzrlxdh())) {
			sb.append("____________________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append(" " + jc.getDwfgfzrlxdh() + " ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append(
				"				&nbsp;&nbsp;&nbsp;&nbsp;检查情况：                                                                                        ");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td style='padding-left: 50px;padding-right: 50px;height: 400px;' valign='top'>");
		sb.append(jc.getJcjg());
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;被检查单位（协助检查）人员签名（单位章）：");
		if (StringUtils.isBlank(jc.getXzjcrxm())) {
			sb.append("_______________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getXzjcrxm() + "  ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;联系电话&nbsp;&nbsp;&nbsp;&nbsp;：");
		if (StringUtils.isBlank(jc.getXzjcrlxdh())) {
			sb.append("_______________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getXzjcrlxdh() + "  ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;被检查人签名：");
		if (StringUtils.isBlank(jc.getBjcryxm())) {
			sb.append("_______________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getBjcryxm() + "  ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;联系电话&nbsp;&nbsp;&nbsp;&nbsp;：");
		if (StringUtils.isBlank(jc.getBjcrylxdh())) {
			sb.append("_______________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + jc.getBjcrylxdh() + "  ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td style='padding-top: 50px;'>");
		sb.append(
				"				&nbsp;&nbsp;&nbsp;&nbsp;此记录附卷                                                                                        ");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("		</table>");
		sb.append("	</div>");
		sb.append("</body>");
		sb.append("</html>");
		return this.converToBase64Str(sb.toString());
	}

	private String getDwjfjfjctzscgJpg(String jcid) {

		Dwjfjfjctzscg cg = new Dwjfjfjctzscg();
		cg.setJcid(jcid);
		cg = this.dwjfjfjctzscgDao.query(cg);

		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>技防检查通知书</title>");
		sb.append("<style>");
		sb.append("td{");
		sb.append("	font-family:楷体;");
		sb.append("	font-size:15px;");
		sb.append("	word-break : break-all;");
		sb.append("	vertical-align: top;");
		sb.append("}");
		sb.append(".title1{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".title2{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".wh{");
		sb.append("	text-align:right;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append("table{");
		sb.append("	border='0' cellpadding='0' cellspacing='6';");
		sb.append("}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("	<div style='width:700px;height:978px;padding: 20px;border:1px solid #000000;margin:20px;'>");
		sb.append("		<table style='width:594px;' width='100%' align='center'>");
		sb.append("			<tr >");
		sb.append("				<td class='title1'>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(cg.getZzjgmc());
		sb.append("</span>公安（分）局");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td class='title2'>");
		sb.append("					公共安全技术防范（系统）检查通知书 <br>（存根）");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td style='text-align: right;'>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(cg.getWh());
		sb.append("</span>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr>");
		sb.append("				<td>");
		sb.append(
				"				<table><tr><td style='width:70px;'>案由</td><td style='width:500px;border-bottom:1px solid #000;'>");
		sb.append(cg.getAy());
		sb.append("</td><tr></table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr>");
		sb.append("				<td>");
		sb.append(
				"				<table><tr><td style='width:70px;'>通知对象</td><td style='width:500px;border-bottom:1px solid #000;'>");
		sb.append(cg.getDwmc());
		sb.append("</td><tr></table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr>");
		sb.append("				<td>");
		sb.append(
				"				<table><tr><td style='width:70px;'>通知原因</td><td style='width:500px;border-bottom:1px solid #000;'>");
		sb.append(cg.getTzyy());
		sb.append("</td><tr></table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr>");
		sb.append("				<td>");
		sb.append(
				"				<table><tr><td style='width:70px;'>经办人</td><td style='width:500px;border-bottom:1px solid #000;'>");
		sb.append(cg.getJbr());
		sb.append("</td><tr></table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr>");
		sb.append("				<td>");
		sb.append(
				"				<table><tr><td style='width:70px;'>批准人</td><td style='width:500px;border-bottom:1px solid #000;'>");
		sb.append(cg.getPzr());
		sb.append("</td><tr></table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr>");
		sb.append("				<td>");
		sb.append(
				"				<table><tr><td style='width:70px;'>批准时间</td><td style='width:500px;border-bottom:1px solid #000;'>");
		sb.append(cg.getPzrq());
		sb.append("</td><tr></table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr>");
		sb.append("				<td>");
		sb.append(
				"				<table><tr><td style='width:70px;'>填发人</td><td style='width:500px;border-bottom:1px solid #000;'>");
		sb.append(cg.getTfr());
		sb.append("</td><tr></table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr>");
		sb.append("				<td>");
		sb.append(
				"				<table><tr><td style='width:70px;'>填发时间</td><td style='width:500px;border-bottom:1px solid #000;'>");
		sb.append(cg.getTfrq());
		sb.append("</td><tr></table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("		</table>");
		sb.append("	</div>");
		sb.append("</body>");
		sb.append("</html>");
		return this.converToBase64Str(sb.toString());
	}

	private String getDwjffctzsJpg(String jcid) {
		Dwjffctzs tzs = new Dwjffctzs();
		tzs.setJcid(jcid);
		tzs = this.dwjffctzsDao.query(tzs);

		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>复查意见书</title>");
		sb.append("<style>");
		sb.append("td{");
		sb.append("	font-family:楷体;");
		sb.append("	font-size:15px;");
		sb.append("	word-break : break-all;");
		sb.append("	vertical-align: top;");
		sb.append("}");
		sb.append(".title1{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".title2{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".wh{");
		sb.append("	text-align:right;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append("table{");
		sb.append("	border='0' cellpadding='0' cellspacing='6';");
		sb.append("}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("	<div style='width:700px;height:978px;padding: 20px;border:1px solid #000000;margin:20px;'>");
		sb.append("		<table style='width:594px;' width='100%' align='center'>");
		sb.append("			<tr >");
		sb.append("				<td class='title2'>");
		sb.append("					复查意见书");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td style='text-align: right;'>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(tzs.getWh());
		sb.append("					</span>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(tzs.getDwmc());
		sb.append("					</span>：");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("	　　			根据 ");
		sb.append(tzs.getJctzswh());
		sb.append("				责令通知书，我局（分局）于");
		if (StringUtils.isBlank(tzs.getFcrq())) {
			sb.append("__________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append(tzs.getFcrq());
			sb.append("</span>");
		}
		sb.append("					派员对你单位整改情况进行了复查。复查意见如下： ");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td style='padding-left: 50px;padding-right: 50px;height: 400px;' valign='top'>");
		sb.append(tzs.getFcyj());
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr  style='padding-top: 300px;'>");
		sb.append("				<td>");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;（对逾期未改的违法行为，将依法予以处罚。你单位应当继续整改，并确保安全，防止发生事故。） ");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr  align='right' >");
		sb.append("				<td>");
		sb.append("				　　 （公安机关印章）");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr  align='right'>");
		sb.append("				<td>");
		sb.append("				　　<span style='text-decoration:underline;'>");
		sb.append("						hgrq ");
		sb.append("					</span>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("		</table>");
		sb.append("	</div>");
		sb.append("</body>");
		sb.append("</html>");
		return this.converToBase64Str(sb.toString());
	}

	private String getDwjfzltzsJpg(String jcid) {

		Dwjfzltzs tzs = new Dwjfzltzs();
		tzs.setJcid(jcid);
		tzs = this.dwjfzltzsDao.query(tzs);

		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>技防检查通知书</title>");
		sb.append("<style>");
		sb.append("td{");
		sb.append("	font-family:楷体;");
		sb.append("	font-size:15px;");
		sb.append("	word-break : break-all;");
		sb.append("	vertical-align: top;");
		sb.append("}");
		sb.append(".title1{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".title2{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append(".wh{");
		sb.append("	text-align:right;");
		sb.append("	font-size: 18px;");
		sb.append("	font-weight:700;");
		sb.append("}");
		sb.append("table{");
		sb.append("	border='0' cellpadding='0' cellspacing='6';");
		sb.append("}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("	<div style='width:700px;height:978px;padding: 20px;border:1px solid #000000;margin:20px;'>");
		sb.append("		<table style='width:594px;' width='100%' align='center'>");
		sb.append("			<tr >");
		sb.append("				<td class='title1'>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(tzs.getZzjgmc());
		sb.append("					</span>公安（分）局");
		sb.append("				</td>");
		sb.append("         </tr>");
		sb.append("				<td class='title2'>公共安全技术防范检查记录");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td style='text-align: right;'>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(tzs.getWh());
		sb.append("					</span>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(tzs.getDwmc());
		sb.append("					</span>：");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;经调查，发现你单（位）存在下述违法行为：");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td style='padding-left: 50px;padding-right: 50px;height: 200px;' valign='top''>");
		sb.append(tzs.getWfxw());
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td >&nbsp;&nbsp;&nbsp;根据：</td>");
		sb.append("							<td style='width:350px;border-bottom:1px solid #000;'>");
		sb.append(tzs.getFg());
		sb.append("</td>");
		sb.append("						    <td >");
		sb.append("							之规定，现责令你（单位）");
		sb.append("							</td>");
		sb.append("						</tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("				&nbsp;&nbsp;&nbsp;&nbsp;");
		
		if(org.apache.commons.lang.StringUtils.isBlank(tzs.getGzfs())){
			tzs.setGzfs("2");
		}
		
		if (tzs.getGzfs().equals("0")) {
			sb.append("□");
		} else {
			sb.append("☑");
		}
		sb.append("立即予以改正");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("			    &nbsp;&nbsp;&nbsp;&nbsp;");
		if (tzs.getGzfs().equals("1")) {
			sb.append("□");
		} else {
			sb.append("☑");
		}
		sb.append("立即");
		if (StringUtils.isBlank(tzs.getGznr())) {
			sb.append("______________________________________________。");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + tzs.getGznr() + "  ");
			sb.append("</span>");
		}
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				 &nbsp;&nbsp;&nbsp;&nbsp;");
		if (tzs.getGzfs().equals("2")) {
			sb.append("□");
		} else {
			sb.append("☑");
		}
		sb.append(" 在");
		if (StringUtils.isBlank(tzs.getGzsj())) {
			sb.append("________________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + tzs.getGzsj() + "  ");
			sb.append("</span>");
		}
		sb.append("						前改正或者整改完毕，并将结果函告我单位。在期限届满之前，你（单位）必须");
		if (StringUtils.isBlank(tzs.getZgsx())) {
			sb.append("_________________________________________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + tzs.getZgsx() + "  ");
			sb.append("</span>");
		}
		sb.append("				             。");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("				如不服本决定，可在收到本通知书之日起六十日内向");
		if (StringUtils.isBlank(tzs.getFydwmc())) {
			sb.append("_______________________________________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + tzs.getFydwmc() + "  ");
			sb.append("</span>");
		}
		sb.append("				申请行政复议或者在六个月内依法向");
		if (StringUtils.isBlank(tzs.getFymc())) {
			sb.append("_______________________________");
		} else {
			sb.append("<span style='text-decoration:underline;'>");
			sb.append("  " + tzs.getFymc() + "  ");
			sb.append("</span>");
		}
		sb.append("				人民法院提起行政诉讼。");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr  align='right' style='padding-top: 260px'>");
		sb.append("				<td>");
		sb.append("				　　 公安机关（印）");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr  align='right'>");
		sb.append("				<td>");
		sb.append("				　　<span style='text-decoration:underline;'>fhrq</span>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<table>");
		sb.append("						<tr>");
		sb.append("							<td >　　违法行为人</td>");
		sb.append("							<td style='width:200px;border-bottom:1px solid #000;'>");
		sb.append(tzs.getWfxwr());
		sb.append("</td>");
		sb.append("						<tr>");
		sb.append("					</table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("					<table style='width:200px;border-bottom:1px solid #000;'><tr><td>");
		sb.append(tzs.getHgrq());
		sb.append("</td></tr></table>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("		</table>");
		sb.append("	</div>");
		sb.append("</body>");
		sb.append("</html>");
		return this.converToBase64Str(sb.toString());
	}

	private String getDwjfjfjctzsJpg(String jcid) {
		Dwjfjfjctzs tzs = new Dwjfjfjctzs();
		tzs.setJcid(jcid);
		tzs = this.dwjfjfjctzsDao.query(tzs);

		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>技防检查通知书</title>");
		sb.append("<style>");
		sb.append("td{");
		sb.append("	font-family:楷体;");
		sb.append("	font-size:15px;");
		sb.append("	word-break : break-all;");
		sb.append("	vertical-align: top; ");
		sb.append("}");
		sb.append(".date{ ");
		sb.append("	font-family:楷体;");
		sb.append("	font-size:15px;");
		sb.append("	width: 500px;");
		sb.append("	text-align:left;");
		sb.append("	border-top: 0px;");
		sb.append("	border-left: 0px;");
		sb.append("	border-right: 0px;");
		sb.append("	border-color: #333333;");
		sb.append("	text-indent:5px;");
		sb.append("}");
		sb.append(".text{");
		sb.append("	font-family:楷体;");
		sb.append("	font-size:15px;");
		sb.append("	width: 500px;");
		sb.append("	text-align:left;");
		sb.append("	border-top: 0px;");
		sb.append("	border-left: 0px;");
		sb.append("	border-right: 0px;");
		sb.append("	border-color: #333333;");
		sb.append("	text-indent:5px;");
		sb.append("}");
		sb.append(".title1{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 18px;");
		sb.append(" font-weight:700;");
		sb.append("}");
		sb.append(".wh{");
		sb.append("	text-align:right;");
		sb.append("	font-size: 18px;");
		sb.append(" font-weight:700;");
		sb.append("}");
		sb.append(".title2{");
		sb.append("	text-align:center;");
		sb.append("	font-size: 26px;");
		sb.append(" font-weight:700;");
		sb.append("}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("	<div style='width:700px;height:978px;padding: 20px;border:1px solid #000000;margin:20px;'>");
		sb.append(
				"		<table style='width:594px;' border='0' cellpadding='0' cellspacing='6' width='100%' align='center'>");
		sb.append("			<tr >");
		sb.append("				<td class='title1'>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(tzs.getZzjgmc());
		sb.append("</span>公安（分）局");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td class='title2'>");
		sb.append("					公共安全技术防范（系统）检查通知书");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td class='wh'>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(tzs.getWh());
		sb.append("</span>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("					<span style='text-decoration:underline;'>");
		sb.append(tzs.getDwmc());
		sb.append("</span>：");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("				　　根据《辽宁省公共安全技术防范条例》，第<span style='text-decoration:underline;'>&nbsp;");
		sb.append(tzs.getTs());
		sb.append("&nbsp;</span>条之规定，我局（分局）于<span style='text-decoration:underline;'>");
		sb.append(tzs.getJcrq());
		sb.append("</span>对你（单位）进行检查。");
		sb.append("					<br/>检查内容如下： ");
		sb.append("					<br/>1. 公共安全技术防范系统工作落实情况 ");
		sb.append("					<br/>2. 公共安全技术防范系统防范效能 ");
		sb.append("					<br/>3. 公共安全技术防范系统操作人员使用熟练度");
		sb.append("					<br/>4. 其他：");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td style='padding-left: 50px;padding-right: 50px;height: 400px;' valign='top'>");
		sb.append(tzs.getQt());
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td >");
		sb.append("				　　请你单位派员协助检查。");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr class='dialogTr' align='right'>");
		sb.append("				<td>");
		sb.append("				　　 （公安机关印章）");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr class='dialogTr' align='right'>");
		sb.append("				<td>");
		sb.append("				　　<span style='text-decoration:underline;'>");
		sb.append(tzs.getHgrq());
		sb.append("</span>");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("			<tr >");
		sb.append("				<td>");
		sb.append("				　　此联交被检查单位");
		sb.append("				</td>");
		sb.append("			</tr>");
		sb.append("		</table>");
		sb.append("	</div>");
		sb.append("</body>");
		sb.append("</html>");

		return this.converToBase64Str(sb.toString());
	}

	private String converToBase64Str(String htmlStr) {

		byte[] imageBuff = null;
		try {
			imageBuff = GraphUtils.toImages(htmlStr);
		} catch (Exception e) {
			return null;
		}
		
		return Base64.getBase64(imageBuff);
	}

}
