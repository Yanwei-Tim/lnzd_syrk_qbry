package com.founder.sydw.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjfjfjctzs;
@Repository("dwjfjfjctzsDao")
public class DwjfjfjctzsDao extends BaseDaoImpl {

	public Dwjfjfjctzs queryEntityById(String id) {
		Dwjfjfjctzs entity = new Dwjfjfjctzs();
		entity.setId(id);
		return (Dwjfjfjctzs)queryForObject("Dwjfjfjctzs.query", entity);
	}

	public Dwjfjfjctzs query(Dwjfjfjctzs entity){
		return (Dwjfjfjctzs)queryForObject("Dwjfjfjctzs.query", entity);
	}
	
	public String queryXh(){
		return (String)queryForObject("Dwjfjfjctzs.queryXh", null);
	}
	
	public void saveEntity(Dwjfjfjctzs entity) {
		entity.setId(UUID.create());
		super.insert("Dwjfjfjctzs.save", entity);
	}

	public void update(Dwjfjfjctzs entity) {
		super.update("Dwjfjfjctzs.update", entity);
	}

}
