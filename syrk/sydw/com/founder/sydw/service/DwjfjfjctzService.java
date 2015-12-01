package com.founder.sydw.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.bean.Dwjffctzs;
import com.founder.sydw.bean.Dwjffctzscg;
import com.founder.sydw.bean.Dwjfjfjctzs;
import com.founder.sydw.bean.Dwjfjfjctzscg;
import com.founder.sydw.bean.Dwjfzltzs;

public interface DwjfjfjctzService {

	public void saveJfjfjctzs(Dwjfjfjctzs entity,SessionBean sessionBean);
	
	public void updateJfjfjctzs(Dwjfjfjctzs entity,SessionBean sessionBean);
	
	public void saveJfjfjctzscg(Dwjfjfjctzscg entity,SessionBean sessionBean);
	
	public void updateJfjfjctzscg(Dwjfjfjctzscg entity,SessionBean sessionBean);
	
	public void saveJfdwjctjl(Dwjcxxb entity,SessionBean sessionBean);
	
	public void saveJfzltzs(Dwjfzltzs entity,SessionBean sessionBean);
	
	public void updateJfzltzs(Dwjfzltzs entity,SessionBean sessionBean);
	
	public void saveJffctzs(Dwjffctzs entity,SessionBean sessionBean);
	
	public void updateJffctzs(Dwjffctzs entity,SessionBean sessionBean);
	
	public void saveJffctzscg(Dwjffctzscg entity,SessionBean sessionBean);
	
	public void updateJffctzscg(Dwjffctzscg entity,SessionBean sessionBean);
	
	public String getWhHead(SessionBean sessionBean);
	
	public String getGzsjStrArray(String jcsj);
}
