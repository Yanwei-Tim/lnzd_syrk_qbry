package com.founder.xlpc.dao;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xlpc.vo.PcrwVO;
import com.founder.xlpc.vo.PcryVO;
/**
 * @类名: xlpcDao
 * @描述: 巡逻盘查Dao
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-11-22 下午4:03:30
 */
@Repository("xlpcDao")
public class XlpcDao extends BaseDaoImpl{
	/**
	 * @Title: queryPcryList
	 * @描述: 盘查人员列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-11-22 下午4:04:11
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryPcryList(EasyUIPage page, PcryVO entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("pcryvo", entity);
		page.setTotal((Integer) queryForObject("com.founder.xlpc.sqlmap.xlpc.queryPcryCount", map));
		page.setRows(queryForList("com.founder.xlpc.sqlmap.xlpc.queryPcryList", map));
		return page;
	}
	/**
	 * @Title: queryPcrwList
	 * @描述: 盘查任务列表
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @日期： 2015-11-24 下午2:12:35 
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryPcrwList(EasyUIPage page, PcrwVO entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("pcrwvo", entity);
		page.setTotal((Integer) queryForObject("com.founder.xlpc.sqlmap.xlpc.queryPcrwCount", map));
		page.setRows(queryForList("com.founder.xlpc.sqlmap.xlpc.queryPcrwList", map));
		return page;
	}
}