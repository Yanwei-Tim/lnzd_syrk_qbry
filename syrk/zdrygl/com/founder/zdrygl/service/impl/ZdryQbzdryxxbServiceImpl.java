package com.founder.zdrygl.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
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
	public boolean Updatexx(Map<String, String> param) {
		// TODO Auto-generated method stub
		return false;
	}

}
