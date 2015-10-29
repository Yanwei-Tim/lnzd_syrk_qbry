package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;
import com.founder.zdrygl.dao.ZdryQbzdryxxbUpDao;
import com.founder.zdrygl.service.ZdryQbzdryxxbUpService;

@Service("zdryQbzdryxxbUpService")
@Transactional
public class ZdryQbzdryxxbUpServiceImpl extends BaseService implements ZdryQbzdryxxbUpService {

	@Resource
	private SysMessageDao sysMessageDao;
	
	@Resource
	private ZdryQbzdryxxbUpDao zdryQbzdryxxbUpDao;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Override
	public void updateQbBg(ZdryQbzdryYwczb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		entity.setCzrq(DateUtils.getSystemDateTimeString());
		entity.setCzbmdm(sessionBean.getUserOrgCode());
		entity.setCzbm(sessionBean.getUserOrgName());
		entity.setCzr(sessionBean.getUserName());
		entity.setDqzt("04");//01 待下发、02 已下发、03 申请变更中、04 退回申请中
		entity.setCzlb("03");//01下发、02、申请变更、03 申请退回、04撤销变更、05撤销退回、06接收、100 其他
		entity.setXt_zxbz("0");   
		entity.setSftjbgsq("1");
		setUpdateProperties(entity,sessionBean);
		zdryQbzdryxxbUpDao.updateQbBg(entity);
		OrgOrganization org = orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
		String orgcode = org.getOrgcode();
		entity.setCzbmdm(orgcode);
		ZdryQbzdryYwczb entity_s = new ZdryQbzdryYwczb();
		entity_s = zdryQbzdryxxbUpDao.query(entity);
		entity_s.setCzlb("03");
		zdryQbzdryxxbUpDao.updateDqzt(entity_s);
		
		//向上级发送消息
		SysMessage sysMsg = new SysMessage();
		sysMsg.setXxnr("【"+sessionBean.getUserName()+"】向您申请退回一条情报重点人员信息！请查收审批");
		sysMsg.setXxlb("1");
		//sysMsg.setYwurl(jwry.getId()+","+jwry.getRyid()+","+jwry.getDzms()+","+jwry.getDzms_zbx()+","+jwry.getDzms_zby()+",0");
		sysMsg.setFsr(sessionBean.getUserName());
		sysMsg.setFsrdm(sessionBean.getUserId());
		sysMsg.setFsrssdw(sessionBean.getUserOrgName());
		sysMsg.setFsrssdwdm(sessionBean.getUserOrgCode());
		sysMsg.setFssj(DateUtils.getSystemDateTimeString());
		sysMsg.setSfck("0");
		sysMsg.setXxbt("情报重点人员申请退回");
		//发送消息提醒
		sysMessageDao.saveMessageByOrg(sysMsg,orgcode, false, false);
		
		
		
	}
	
	@Override
	public void updateCxQbBg(ZdryQbzdryYwczb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		entity.setCzrq(DateUtils.getSystemDateTimeString());
		entity.setCzbmdm(sessionBean.getUserOrgCode());
		entity.setCzbm(sessionBean.getUserOrgName());
		entity.setCzr(sessionBean.getUserName());
		String orgLevel = sessionBean.getUserOrgLevel();
		if(orgLevel.equals("50")){
			entity.setDqzt("05");//01 待下发、02 已下发、03 申请变更中、04 退回申请中
			entity.setCzlb("05");//01下发、02、申请变更、03 申请退回、04撤销变更、05撤销退回、06接收、100 其他
		}else{
			entity.setDqzt("01");//01 待下发、02 已下发、03 申请变更中、04 退回申请中
			entity.setCzlb("05");//01下发、02、申请变更、03 申请退回、04撤销变更、05撤销退回、06接收、100 其他
		}
		entity.setXt_zxbz("0");   
		entity.setSftjbgsq("1");
		setUpdateProperties(entity,sessionBean);
		zdryQbzdryxxbUpDao.updateQbBg(entity);
		OrgOrganization org = orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
		String orgcode = org.getOrgcode();
		entity.setCzbmdm(orgcode);
		ZdryQbzdryYwczb entity_s = new ZdryQbzdryYwczb();
		entity_s = zdryQbzdryxxbUpDao.query(entity);
		entity_s.setCzlb("01");
		zdryQbzdryxxbUpDao.updateDqzt(entity_s);
		
		//向上级发送消息
		SysMessage sysMsg = new SysMessage();
		sysMsg.setXxnr("【"+sessionBean.getUserName()+"】已撤回情报重点人员退回申请！");
		sysMsg.setXxlb("1");
		//sysMsg.setYwurl(jwry.getId()+","+jwry.getRyid()+","+jwry.getDzms()+","+jwry.getDzms_zbx()+","+jwry.getDzms_zby()+",0");
		sysMsg.setFsr(sessionBean.getUserName());
		sysMsg.setFsrdm(sessionBean.getUserId());
		sysMsg.setFsrssdw(sessionBean.getUserOrgName());
		sysMsg.setFsrssdwdm(sessionBean.getUserOrgCode());
		sysMsg.setFssj(DateUtils.getSystemDateTimeString());
		sysMsg.setSfck("0");
		sysMsg.setXxbt("情报重点人员撤回申请");
		//发送消息提醒
		sysMessageDao.saveMessageByOrg(sysMsg,orgcode, false, false);
	}
	
	//上级拒绝下级管辖权变更申请
	@Override
	public void updateJjBg(ZdryQbzdryYwczb entity, SessionBean sessionBean) {
		ZdryQbzdryYwczb entity_s = new ZdryQbzdryYwczb();
		entity_s = zdryQbzdryxxbUpDao.query(entity);
		String orgLevel = sessionBean.getUserOrgLevel();
		if(orgLevel.equals("32")){ //当前用户如果为派出所 下级责任区只能做接收处理
			entity_s.setDqzt("05");//01 待下发、02 已下发、03 申请变更中、04 退回申请中、05待接收
			entity_s.setCzlb("05");//01下发、02、申请变更、03 申请退回、04撤销变更、05撤销退回、06接收、100 其他
		}else{
			entity_s.setDqzt("01");//01 待下发、02 已下发、03 申请变更中、04 退回申请中、05待接收
			entity_s.setCzlb("05");//01下发、02、申请变更、03 申请退回、04撤销变更、05撤销退回、06接收、100 其他
		}
		entity_s.setSjsfjjbgsq("2");
		zdryQbzdryxxbUpDao.updateZtLb(entity_s);
		
		//向下级发送消息
		SysMessage sysMsg = new SysMessage();
		sysMsg.setXxnr("【"+sessionBean.getUserName()+"】已拒绝对情报重点人员的退回申请！");
		sysMsg.setXxlb("1");
		//sysMsg.setYwurl(jwry.getId()+","+jwry.getRyid()+","+jwry.getDzms()+","+jwry.getDzms_zbx()+","+jwry.getDzms_zby()+",0");
		sysMsg.setFsr(sessionBean.getUserName());
		sysMsg.setFsrdm(sessionBean.getUserId());
		sysMsg.setFsrssdw(sessionBean.getUserOrgName());
		sysMsg.setFsrssdwdm(sessionBean.getUserOrgCode());
		sysMsg.setFssj(DateUtils.getSystemDateTimeString());
		sysMsg.setSfck("0");
		sysMsg.setXxbt("情报重点人员退回申请");
		//发送消息提醒
		sysMessageDao.saveMessageByOrg(sysMsg,entity.getCzbmdm(), false, false);
		
		entity.setId(UUID.create());
		entity.setCzrq(DateUtils.getSystemDateTimeString());
		entity.setCzbmdm(sessionBean.getUserOrgCode());
		entity.setCzbm(sessionBean.getUserOrgName());
		entity.setCzr(sessionBean.getUserName());
		entity.setDqzt("02");//01 待下发、02 已下发、03 申请变更中、04 退回申请中
		entity.setCzlb("01");//01下发、02、申请变更、03 申请退回、04撤销变更、05撤销退回、06接收、100 其他
		entity.setXt_zxbz("0");   
		entity.setSftjbgsq("1");
		setUpdateProperties(entity,sessionBean);
		zdryQbzdryxxbUpDao.updateQbBg(entity);
		
		
	}
	
	
	@Override
	public ZdryQbzdryYwczb queryXjZx(ZdryQbzdryYwczb entity) {
		return  zdryQbzdryxxbUpDao.query(entity);
	}
	
	@Override
	public void updateSj(ZdryQbzdryYwczb entity) {
       zdryQbzdryxxbUpDao.updateSj(entity);
	}
	
	
}
