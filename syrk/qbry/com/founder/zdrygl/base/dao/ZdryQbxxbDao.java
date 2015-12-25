package com.founder.zdrygl.base.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryQbxxb;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryQbxxbDao.java]  
 * @ClassName:    [ZdryQbxxbDao]   
 * @Description:  [情报重点人员DAO]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月25日 上午10:17:14]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月25日 上午10:17:14，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ZdryQbxxbDao")
public class ZdryQbxxbDao extends BaseDaoImpl {

	public void save(ZdryQbxxb entity) {
		insert("ZdryQbxxb.save", entity);
	}
	
	public void update(ZdryQbxxb entity) {
		update("ZdryQbxxb.update", entity);
	}

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryQbxxb    返回类型
	 * @throw
	 */
	public ZdryQbxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			ZdryQbxxb entity=new ZdryQbxxb();
			entity.setId(id);
			return (ZdryQbxxb) queryForObject("ZdryQbxxb.queryByEntity", entity);
		}
	}
	
	
}
