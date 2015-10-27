package com.founder.zdrygl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.zdrygl.bean.ZdryQbZdryxxb;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;

@TypeAnnotation("情报重点人员申请变更")
public interface ZdryQbzdryxxbUpService {

	public void updateQbBg(ZdryQbzdryYwczb entity, SessionBean sessionBean);
	
	public void updateCxQbBg(ZdryQbzdryYwczb entity, SessionBean sessionBean);
	
	public ZdryQbzdryYwczb queryXjZx(ZdryQbzdryYwczb entity);
	
	public void updateSj(ZdryQbzdryYwczb entity);
}
