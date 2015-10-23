package com.founder.zdrygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdryQbZdryxxb;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;
import com.founder.zdrygl.bean.ZdryShbzdryxxb;
@Repository("zdryQbzdryxxbDao")
public class ZdryQbzdryxxbDao extends BaseDaoImpl {
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;





	/***
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询对象)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryShbzdryxxb    返回类型
	 * @throws
	 */
	public ZdryQbZdryxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			return (ZdryQbZdryxxb) queryForObject("ZdryQbZdryxxb.queryById", id);
		}
	}
	
	
	/**
	 * 
	 * @Title: querySyrk
	 * @Description: TODO(查询列表，涉环保重点人员单独查询)
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdryQbZdryxxb entity, EasyUIPage page,SessionBean sessionBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "zdryid";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryQbZdryxxb", entity);

		page.setTotal((Integer) queryForObject("ZdryQbZdryxxb.queryListCount", map)==null?0:(Integer) queryForObject("ZdryQbZdryxxb.queryListCount", map));
		List<ZdryQbZdryxxb> list =queryForList("ZdryQbZdryxxb.queryList", map);

		page.setRows(list);
		return page;
		
	}


	public EasyUIPage queryOperation(ZdryQbzdryYwczb entity, EasyUIPage page, Map<String, String> param) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String zdryid = param.get("zdryid");
		map.put("zdryid", zdryid);
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "czrq";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryQbzdryYwczb", entity);
		page.setTotal((Integer) queryForObject("ZdryQbZdryxxb.queryOperationCount", map)==null?0:(Integer) queryForObject("ZdryQbZdryxxb.queryOperationCount", map));
		List<ZdryQbzdryYwczb> list =queryForList("ZdryQbZdryxxb.queryOperationList", map);
		page.setRows(list);
		return page;
	}


	public int queryBenOperation(Map<String, String> param) {
		// TODO Auto-generated method stub
		return (Integer) queryForObject("ZdryQbZdryxxb.queryBenOperation",param);
	}


	
}
