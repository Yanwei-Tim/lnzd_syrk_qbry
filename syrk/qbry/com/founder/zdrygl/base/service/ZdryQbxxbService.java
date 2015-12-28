package com.founder.zdrygl.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.base.dao.ZdryQbxxbDao;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdryQbxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.founder.zdrygl.core.utils.ZdryQbDict;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryQbxxbService.java]  
 * @ClassName:    [ZdryQbxxbService]   
 * @Description:  [情报人员服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月25日 上午10:58:50]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月25日 上午10:58:50，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryQbxxbService")
public class ZdryQbxxbService {
	
	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;
	
	@Autowired
	private ZdryQbxxbDao zdryQbxxbDao;
	
	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryQbxxbDao    返回类型
	 * @throw
	 */
	public ZdryQbxxb queryById(String id) {
		// TODO Auto-generated method stub
		return zdryQbxxbDao.queryById(id);
	}
	
	public EasyUIPage queryList(ZdryQbxxb entity, EasyUIPage page) {
		return zdryQbxxbDao.queryList(entity, page);
	}
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(新增zdry)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZdryQbxxb entity){		
		entity.setId(UUID.create());
		zdryQbxxbDao.save(entity);
	}


	/**
	 * 
	 * @Title: saveLg
	 * @Description: TODO(情报人员接收，列管)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	public void saveLg(ZdryQbxxb entity,SessionBean sessionBean){
		ZdryZb zdryzb = new ZdryZb();
		zdryzb.setId(entity.getId());//列管后，情报人员信息表 作为重点人员总表的子表，两者Id要保持一致
		zdryzb.setGlzt(ZdryConstant.YLG);
		zdryzb.setGlbm(sessionBean.getUserOrgCode());//管理部门
		BaseService.setSaveProperties(zdryzb, sessionBean);		
		
		zdryzb.setXm(entity.getXm());
		zdryzb.setXbdm(entity.getXbdm());
		zdryzb.setZjhm(entity.getGmsfhm());
		zdryzb.setCsrq(entity.getCsrq());
		zdryzb.setMzdm(entity.getMzdm());
		zdryzb.setZdrygllxdm(entity.getZdrygllxdm());
		zdryzb.setZdrylb(entity.getZdrylb());
		zdryZdryZbDao.insert(zdryzb);//列管重点人员
		
		//修改情报人员状态为“已接收”
		entity.setGlzt(ZdryQbDict.GLZT_YJS);
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryQbxxbDao.update(entity);
	}
}
