package com.founder.sydw.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjfzltzs;
@Repository("dwjfzltzsDao")
public class DwjfzltzsDao extends BaseDaoImpl {

	public Dwjfzltzs queryEntityById(String id) {
		Dwjfzltzs entity = new Dwjfzltzs();
		entity.setId(id);
		return (Dwjfzltzs)queryForObject("Dwjfzltzs.query", entity);
	}

	public Dwjfzltzs query(Dwjfzltzs entity){
		return (Dwjfzltzs)queryForObject("Dwjfzltzs.query", entity);
	}
	
	public String queryXh(){
		return (String)queryForObject("Dwjfzltzs.queryXh", null);
	}
	
	public void saveEntity(Dwjfzltzs entity) {
		if(StringUtils.isBlank(entity.getId())){
			entity.setId(UUID.create());
		}
		super.insert("Dwjfzltzs.save", entity);
	}

	public void update(Dwjfzltzs entity) {
		super.update("Dwjfzltzs.update", entity);
	}

}
