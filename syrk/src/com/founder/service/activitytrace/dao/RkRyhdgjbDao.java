package com.founder.service.activitytrace.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.service.activitytrace.bean.RkRyhdgjb;
import com.founder.service.provinceservice.bean.ServiceLkxxBean;

@Repository("rkRyhdgjbDao")
public class RkRyhdgjbDao extends BaseDaoImpl {

	/**
	 * 查询人员轨迹（返回最新10条数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjb(String zjhm) {
		List<RkRyhdgjb> list = null;
		if (!StringUtils.isBlank(zjhm)) {
			list = queryForList("activitytrace.queryRkRyhdgjb", zjhm);
		}
		return list;
	}

	/**
	 * 查询人员轨迹（返回所有数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjbAll(String zjhm) {
		List<RkRyhdgjb> list = null;
		if (!StringUtils.isBlank(zjhm)) {
			list = queryForList("activitytrace.queryRkRyhdgjb", zjhm);
		}
		return list;
	}
	
	/**
	 * 查询车辆轨迹（返回最新10条数据）<br>
	 * 
	 * @return
	 */
	public List<ServiceLkxxBean> queryCarTrail(String sfzh) {
		List<ServiceLkxxBean> list = null;
		if (!StringUtils.isBlank(sfzh)) {
			list = queryForList("activitytrace.queryCarTrail", sfzh);
		}
		return list;
	}
	
	/**
	 * 查询车辆轨迹（返回最新10条数据）<br>
	 * 
	 * @return
	 */
	public void saveTrail(ServiceLkxxBean entity) {
		entity.setId(UUID.create());
		insert("activitytrace.saveTrail", entity);
	}
	

}
