package com.founder.zdrygl.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.base.dao.ZdryQbxxbDao;
import com.founder.zdrygl.base.model.ZdryQbxxb;

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

}
