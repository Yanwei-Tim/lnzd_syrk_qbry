package com.founder.zdrygl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.service.provinceservice.bean.ServiceLkxxBean;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.zdrygl.bean.ZdryTrailJkxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryCarTrailService.java]  
 * @ClassName:    [ZdryCarTrailService]   
 * @Description:  [重点人员车辆轨迹监管 服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月6日 下午3:29:27]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月6日 下午3:29:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("重点人员车辆轨迹监控")
public interface ZdryCarTrailService {

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(ZdryTrailJkxxb entity, SessionBean sessionBean);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveTrail(ServiceLkxxBean entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "查询车辆轨迹开关", type = logType.query)
	public String queryTrailJkb(String zjhm);
	
}
