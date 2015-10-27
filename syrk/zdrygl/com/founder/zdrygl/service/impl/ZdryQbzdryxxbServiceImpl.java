package com.founder.zdrygl.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryQbZdryxxb;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;
import com.founder.zdrygl.dao.ZdryQbzdryxxbDao;
import com.founder.zdrygl.service.ZdryQbzdryxxbService;

@Service
@Transactional
public class ZdryQbzdryxxbServiceImpl implements ZdryQbzdryxxbService {

	@Resource
	private ZdryQbzdryxxbDao ZdryQbzdryxxbDao;
	
	@Override
	public EasyUIPage queryList(ZdryQbZdryxxb entity, EasyUIPage page, SessionBean sessionBean) {
		
		return ZdryQbzdryxxbDao.queryList(entity, page, sessionBean);
	}

	@Override
	public ZdryQbZdryxxb queryById(String id) {
		
		return ZdryQbzdryxxbDao.queryById(id);
	}

	@Override
	public EasyUIPage queryOperation(ZdryQbzdryYwczb entity, EasyUIPage page, Map<String, String> param) {
		// TODO Auto-generated method stub
		return ZdryQbzdryxxbDao.queryOperation(entity,page,param);
	}

	@Override
	public int queryBenOperation(Map<String, String> param) {
		// TODO Auto-generated method stub
		return (int) ZdryQbzdryxxbDao.queryBenOperation(param);
	}

	@Override
	public boolean Updatexx(ZdryQbZdryxxb entity) {
		// TODO Auto-generated method stub
		return ZdryQbzdryxxbDao.Updatexx(entity);
	}

	@Override
	public void saveZdryqbxxyw(ZdryQbzdryYwczb entityyw, Map<String, String> param) {
		// TODO Auto-generated method stub
		entityyw.setId(UUID.create());
		entityyw.setXt_zxbz("0");
		entityyw.setCzrq(DateUtils.getSystemDateTimeString());
		if(param.get("userType").equals("50")){
			entityyw.setDqzt("06");
			entityyw.setCzlb("06");
		}else{
			entityyw.setCzlb("01");
			entityyw.setDqzt("02");
		}
		
		entityyw.setCzbmdm(param.get("noworgcode"));
		entityyw.setCzr(param.get("userName"));
		entityyw.setCzbm(param.get("orgName"));
		entityyw.setCzyj(param.get("xfczyj"));
		this.ZdryQbzdryxxbDao.saveZdryqbxxyw(entityyw);
	}

	@Override
	public void acceptZdryqbxxyw(ZdryQbzdryYwczb entityyw, Map<String, String> param) {
		// TODO Auto-generated method stub
		entityyw.setId(UUID.create());
		entityyw.setXt_zxbz("0");
		entityyw.setCzrq(DateUtils.getSystemDateTimeString());
		entityyw.setCzlb("100");
		if(param.get("userType").equals("32")){
			entityyw.setDqzt("05");
		}else{
			entityyw.setDqzt("01");
		}
		entityyw.setCzbmdm(param.get("orgcode"));
		entityyw.setCzr(param.get("userName"));
		entityyw.setCzbm(param.get("orgcodetext"));
		entityyw.setCzyj(param.get("xfczyj"));
		this.ZdryQbzdryxxbDao.saveZdryqbxxyw(entityyw);
	}

	@Override
	public boolean querySyrk(Map<String, String> param) {
		// TODO Auto-generated method stub
		return this.ZdryQbzdryxxbDao.querySyrk(param);
	}

}
