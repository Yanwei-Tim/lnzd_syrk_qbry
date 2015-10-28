package com.founder.zdrygl.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.DwjbxxbBay;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;

@Repository("zdryQbzdryxxbUpDao")
public class ZdryQbzdryxxbUpDao extends BaseDaoImpl {

	
	public void updateQbBg(ZdryQbzdryYwczb entity) {
		super.insert("ZdryQbZdryxxbUp.updateQbBg", entity);
	}
	
	public ZdryQbzdryYwczb query(ZdryQbzdryYwczb entity) {
		ZdryQbzdryYwczb returnValue = null;
		List<?> list = queryForList("ZdryQbZdryxxbUp.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (ZdryQbzdryYwczb) list.get(0);
		}
		return returnValue;
	}
	
	public void updateDqzt(ZdryQbzdryYwczb entity) {
		super.update("ZdryQbZdryxxbUp.updateDqzt", entity);
	}
	
	public void updateSj(ZdryQbzdryYwczb entity) {
		super.update("ZdryQbZdryxxbUp.updateSj", entity);
	}
	
	public void updateZtLb(ZdryQbzdryYwczb entity) {
		super.update("ZdryQbZdryxxbUp.updateZtLb", entity);
	}
}
