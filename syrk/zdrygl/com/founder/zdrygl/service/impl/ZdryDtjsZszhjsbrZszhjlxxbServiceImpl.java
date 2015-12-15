package com.founder.zdrygl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrZszhjlxxb;
import com.founder.zdrygl.dao.ZdryDtjsZszhjsbrZszhjlxxbDao;
import com.founder.zdrygl.service.ZdryDtjsZszhjsbrZszhjlxxbService;

@Service
@Transactional
public class ZdryDtjsZszhjsbrZszhjlxxbServiceImpl extends BaseService implements ZdryDtjsZszhjsbrZszhjlxxbService {

	@Resource
	private ZdryDtjsZszhjsbrZszhjlxxbDao zdryDtjsZszhjsbrZszhjlxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsZszhjsbrZszhjlxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsZszhjsbrZszhjlxxbDao.queryList(page, map);
		int count = (int) zdryDtjsZszhjsbrZszhjlxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsZszhjsbrZszhjlxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsZszhjsbrZszhjlxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsZszhjsbrZszhjlxxb queryById(String id) {
		
		return this.zdryDtjsZszhjsbrZszhjlxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsZszhjsbrZszhjlxxb entity, SessionBean sessionBean) {
		this.setCrossoutProperties(entity, sessionBean);
		this.zdryDtjsZszhjsbrZszhjlxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsZszhjsbrZszhjlxxb entity, SessionBean sessionBean) {
		this.setUpdateProperties(entity, sessionBean);
		this.zdryDtjsZszhjsbrZszhjlxxbDao.update(entity);
		return entity.getId();
	}

}
