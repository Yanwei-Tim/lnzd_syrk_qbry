package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryQbZdryxxb;
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

}
