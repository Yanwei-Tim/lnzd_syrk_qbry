package com.founder.zdrygl.base.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;

/***
 * 	****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryGzbDao.java]  
 * @ClassName:    [zdryTrailJkbDao]   
 * @Description:  [车辆监控DAO]   
 * @CreateDate:   [2015年7月24日 下午3:07:08]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年7月24日 下午3:07:08，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryTrailJkbDao")
public class ZdryTrailJkbDao extends BaseDaoImpl{

	/**
	 * 
	 * @Title: queryByZdrylx
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param @param zdrylx
	 * @param @return    设定文件
	 * @return ZdryGzb    返回类型
	 * @throws
	 */
	public String queryTrailJkb(String sfzh){
		return (String) queryForObject("ZdryTrailJkxxb.queryTrailJkb", sfzh);
	}		
	
	
}
