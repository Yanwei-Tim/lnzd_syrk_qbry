package com.founder.zdrygl.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.zdrygl.base.dao.ZdryQbxxbDao;
import com.founder.zdrygl.base.model.ZdryQbxxb;

@Service("ZdryQbxxbService")
public class ZdryQbxxbService {
	
	@Autowired
	private ZdryQbxxbDao zdryQbxxbDao;
	
	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryQbxxbDao    返回类型
	 * @throw
	 */
	public ZdryQbxxb queryById(String id) {
		// TODO Auto-generated method stub
		return zdryQbxxbDao.queryById(id);
	}
	
	

}
