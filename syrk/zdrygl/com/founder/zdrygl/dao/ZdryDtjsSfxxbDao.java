package com.founder.zdrygl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryDtjsSfxxb;
import com.founder.zdrygl.bean.ZdryDtjsSwxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.RyxsDao.java]  
 * @ClassName:    [RyxsDao]   
 * @Description:  [動態紀實 涉稳信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-9 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-9 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsSfxxbDao") 
public class ZdryDtjsSfxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsSfxxb entity) {
		insert("ZdryDtjsSfxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsSfxxb entity) {
		update("ZdryDtjsSfxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsSfxxb querById(String id){
		return (ZdryDtjsSfxxb)queryForObject("ZdryDtjsSfxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsSfxxb entity){
		update("ZdryDtjsSfxxb.delete", entity); 

	}
	

	/**
	 * @Title: queryList
	 * @Description: TODO(人员写实列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSfxxb.queryByZdryZjhm", map);
	}

	
	/**
	 * @Title: queryCount
	 * @Description: TODO(人员写实条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSfxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
