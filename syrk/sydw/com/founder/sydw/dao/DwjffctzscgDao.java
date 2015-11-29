package com.founder.sydw.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjffctzscg;
@Repository("dwjffctzscgDao")
public class DwjffctzscgDao extends BaseDaoImpl {

	public Dwjffctzscg queryEntityById(String id) {
		Dwjffctzscg entity = new Dwjffctzscg();
		entity.setId(id);
		return (Dwjffctzscg)queryForObject("Dwjffctzscg.query", entity);
	}

	public Dwjffctzscg query(Dwjffctzscg entity){
		return (Dwjffctzscg)queryForObject("Dwjffctzscg.query", entity);
	}
	
	public String queryXh(){
		return (String)queryForObject("Dwjffctzscg.queryXh", null);
	}
	
	public void saveEntity(Dwjffctzscg entity) {
		entity.setId(UUID.create());
		super.insert("Dwjffctzscg.save", entity);
	}

	public void update(Dwjffctzscg entity) {
		super.update("Dwjffctzscg.update", entity);
	}

}
