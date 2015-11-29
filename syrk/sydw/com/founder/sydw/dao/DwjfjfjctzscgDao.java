package com.founder.sydw.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjfjfjctzscg;
@Repository("dwjfjfjctzscgDao")
public class DwjfjfjctzscgDao extends BaseDaoImpl {

	public Dwjfjfjctzscg queryEntityById(String id) {
		Dwjfjfjctzscg entity = new Dwjfjfjctzscg();
		entity.setId(id);
		return (Dwjfjfjctzscg)queryForObject("Dwjfjfjctzscg.query", entity);
	}

	public Dwjfjfjctzscg query(Dwjfjfjctzscg entity){
		return (Dwjfjfjctzscg)queryForObject("Dwjfjfjctzscg.query", entity);
	}
	
	public void saveEntity(Dwjfjfjctzscg entity) {
		if(StringUtils.isBlank(entity.getId())){
			entity.setId(UUID.create());
		}
		super.insert("Dwjfjfjctzscg.save", entity);
	}

	public void update(Dwjfjfjctzscg entity) {
		super.update("Dwjfjfjctzscg.update", entity);
	}

}
