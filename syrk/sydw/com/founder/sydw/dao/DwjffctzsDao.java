package com.founder.sydw.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjffctzs;
@Repository("dwjffctzsDao")
public class DwjffctzsDao extends BaseDaoImpl {

	public Dwjffctzs queryEntityById(String id) {
		Dwjffctzs entity = new Dwjffctzs();
		entity.setId(id);
		return (Dwjffctzs)queryForObject("Dwjffctzs.query", entity);
	}

	public Dwjffctzs query(Dwjffctzs entity){
		return (Dwjffctzs)queryForObject("Dwjffctzs.query", entity);
	}
	
	public String queryXh(){
		return (String)queryForObject("Dwjffctzs.queryXh", null);
	}
	
	public void saveEntity(Dwjffctzs entity) {
		entity.setId(UUID.create());
		super.insert("Dwjffctzs.save", entity);
	}

	public void update(Dwjffctzs entity) {
		super.update("Dwjffctzs.update", entity);
	}

}
