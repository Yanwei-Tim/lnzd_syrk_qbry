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
		entity.setCzbm(sessionBean.getUserOrgName());
		entity.setCzr(sessionBean.getUserName());
		entity.setDqzt("申请变更中");
		entity.setCzlb("申请变更");
		entity.setXt_zxbz("0");
//		setUpdateProperties(entity,sessionBean);
//		zdryQbzdryxxbUpDao.updateQbBg(entity);
		OrgOrganization org = orgOrganizationService.queryParentOrgByOrgcode(sessionBean.getUserOrgCode());
		String orgcode = org.getOrgcode();
		entity.setCzbm(orgcode);
		ZdryQbzdryYwczb entity_s = new ZdryQbzdryYwczb();
		entity_s = zdryQbzdryxxbUpDao.query(entity);
		entity_s.setDqzt("申请变更中");
		
		zdryQbzdryxxbUpDao.updateDqzt(entity_s);
	}
	
	
	
	
}
