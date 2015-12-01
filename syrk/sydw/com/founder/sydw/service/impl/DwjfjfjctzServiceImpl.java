package com.founder.sydw.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessageRemind;
import com.founder.framework.message.service.SysMessageRemindService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.bean.Dwjffctzs;
import com.founder.sydw.bean.Dwjffctzscg;
import com.founder.sydw.bean.Dwjfjfjctzs;
import com.founder.sydw.bean.Dwjfjfjctzscg;
import com.founder.sydw.bean.Dwjfzltzs;
import com.founder.sydw.dao.DwjcxxbDao;
import com.founder.sydw.dao.DwjffctzsDao;
import com.founder.sydw.dao.DwjffctzscgDao;
import com.founder.sydw.dao.DwjfjfjctzsDao;
import com.founder.sydw.dao.DwjfjfjctzscgDao;
import com.founder.sydw.dao.DwjfzltzsDao;
import com.founder.sydw.service.DwjcxxbService;
import com.founder.sydw.service.DwjfjfjctzService;

@Transactional
@Service("dwjfjfjctzService")
public class DwjfjfjctzServiceImpl extends BaseService implements DwjfjfjctzService {

	@Resource(name="dwjfjfjctzsDao")
	private DwjfjfjctzsDao dwjfjfjctzsDao;
	@Resource(name="dwjfjfjctzscgDao")
	private DwjfjfjctzscgDao dwjfjfjctzscgDao;
	@Resource(name="dwjcxxbService")
	private DwjcxxbService dwjcxxbService;
	@Resource(name="dwjcxxbDao")
	private DwjcxxbDao dwjcxxbDao;
	@Resource(name="dwjfzltzsDao")
	private DwjfzltzsDao dwjfzltzsDao;
	@Resource(name="dwjffctzsDao")
	private DwjffctzsDao dwjffctzsDao;
	@Resource(name="dwjffctzscgDao")
	private DwjffctzscgDao dwjffctzscgDao;
	@Resource
	private SysMessageRemindService sysMessageRemindService;
	
	
	@Override
	public void saveJfjfjctzs(Dwjfjfjctzs entity,SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		this.dwjfjfjctzsDao.saveEntity(entity);
		
		//更新检查时间
		Dwjcxxb dwjcxxb = this.dwjcxxbDao.query(entity.getJcid());
		dwjcxxb.setJcsj(entity.getJcrq());
		this.dwjcxxbDao.update(dwjcxxb, sessionBean);
		
		try {
			//生成系统定时消息
			String mess = "您于"+DateUtils.getSystemDateString()+"对 "+dwjcxxb.getDwmc()+" 单位下发的单位检查通知书，检查日期为"
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
	
	private String getSendDate(String tzDateStr,int preDateCount){
		SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日");
		Date d = null;
		try {
			d = df.parse(tzDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(d == null){
			return null;
		}
		Calendar cal=Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, preDateCount);
		return df.format(cal.getTime());
	}

	@Override
	public void saveJfjfjctzscg(Dwjfjfjctzscg entity,SessionBean sessionBean) {
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
		
//		//生成定时消息
//		//生成系统定时消息
//		String mess = "您于"+DateUtils.getSystemDateString()+"对 "+dwjcxxb.getDwmc()+" 单位下发的单位检查通知书，检查日期为"
//				+ entity.getf + ",请做好对该单位的检查准备！";
//		SysMessageRemind message = this.buildMessage("单位技防检查提醒", mess, sessionBean);
//		this.sysMessageRemindService.saveMessageByOrg(message, sessionBean.getUserOrgCode());
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
		
		//后续操作不为空，更新对应的检查记录状态
		if(!StringUtils.isBlank(entity.getOperation())){
			if ("0".equals(entity.getOperation())) {
				//复查合格
				this.dwjcxxbService.updateZt(entity.getJcid(), "5", sessionBean);
			}else if ("1".equals(entity.getOperation())) {
				//转行政案件
				this.dwjcxxbService.updateZt(entity.getJcid(), "100", sessionBean);
			}
		}
	}

	@Override
	public void updateJffctzscg(Dwjffctzscg entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		this.dwjffctzscgDao.update(entity);
		
		//后续操作不为空，更新对应的检查记录状态
		if(!StringUtils.isBlank(entity.getOperation())){
			if ("0".equals(entity.getOperation())) {
				//复查合格
				this.dwjcxxbService.updateZt(entity.getJcid(), "5", sessionBean);
			}else if ("1".equals(entity.getOperation())) {
				//转行政案件
				this.dwjcxxbService.updateZt(entity.getJcid(), "100", sessionBean);
			}
		}
	}
	
	private SysMessageRemind buildMessage(String bt,String nr, SessionBean sessionBean){
		SysMessageRemind entity = new SysMessageRemind();
		entity.setXxbt(bt);
		entity.setXxnr(nr);
		entity.setXxlb("1");//1是消息提醒
		entity.setSfck("0");//是否查看
		entity.setJslx("1"); //0 按人  1按部门
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
		if("01".equals(codeHead)){
			return "沈";
		}else if("02".equals(codeHead)){
			return "大";
		}else if("03".equals(codeHead)){
			return "鞍";
		}else if("04".equals(codeHead)){
			return "抚";
		}else if("05".equals(codeHead)){
			return "本";
		}else if("06".equals(codeHead)){
			return "丹";
		}else if("07".equals(codeHead)){
			return "锦";
		}else if("08".equals(codeHead)){
			return "营";
		}else if("09".equals(codeHead)){
			return "阜";
		}else if("10".equals(codeHead)){
			return "辽";
		}else if("11".equals(codeHead)){
			return "铁";
		}else if("12".equals(codeHead)){
			return "盘";
		}else if("13".equals(codeHead)){
			return "朝";
		}else if("14".equals(codeHead)){
			return "葫";
		}else{
			return null;
		}
		
	}

	@Override
	public String getGzsjStrArray(String jcsj) {
		//getSendDate
		String zgsjArray = this.getSendDate(jcsj, 10);
		zgsjArray += ","+this.getSendDate(jcsj, 20);
		zgsjArray += ","+this.getSendDate(jcsj, 30);
		zgsjArray += ","+this.getSendDate(jcsj, 60);
		zgsjArray += ","+this.getSendDate(jcsj, 90);
		
		return zgsjArray;
	}

}
