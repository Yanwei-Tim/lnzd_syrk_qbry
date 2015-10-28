package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
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
	}
	
	@Override
	public void updateCxQbBg(ZdryQbzdryYwczb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		entity.setCzrq(DateUtils.getSystemDateTimeString());
		entity.setCzbmdm(sessionBean.getUserOrgCode());
		entity.setCzbm(sessionBean.getUserOrgName());
		entity.setCzr(sessionBean.getUserName());
		entity.setDqzt("01");//01 待下发、02 已下发、03 申请变更中、04 退回申请中
		entity.setCzlb("01");//01下发、02、申请变更、03 申请退回、04撤销变更、05撤销退回、06接收、100 其他
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
	}
	
	//上级拒绝下级管辖权变更申请
	@Override
	public void updateJjBg(ZdryQbzdryYwczb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		entity.setCzrq(DateUtils.getSystemDateTimeString());
		entity.setCzbmdm(sessionBean.getUserOrgCode());
		entity.setCzbm(sessionBean.getUserOrgName());
		entity.setCzr(sessionBean.getUserName());
		entity.setDqzt("01");//01 待下发、02 已下发、03 申请变更中、04 退回申请中
		entity.setCzlb("01");//01下发、02、申请变更、03 申请退回、04撤销变更、05撤销退回、06接收、100 其他
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
