package com.founder.zdrygl.service;

import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.zdrygl.bean.ZdryQbZdryxxb;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;
import com.founder.zdrygl.bean.ZdryZdryzb;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryShbzdryxxbService.java]  
 * @ClassName:    [ZdryShbzdryxxbService]   
 * @Description:  [情报重点人员service]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-6-15 上午10:44:28]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-15 上午10:44:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("情报重点人员")
public interface ZdryQbzdryxxbService {

	/***
	 * 
	 * @Title: queryList
	 * @Description: TODO
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdryQbZdryxxb entity, EasyUIPage page,SessionBean sessionBean);
	

	
	
	/**
	 * 根据id查询
	 * @param id
	 */
	public ZdryQbZdryxxb queryById(String id);




	public EasyUIPage queryOperation(ZdryQbzdryYwczb entity, EasyUIPage page, Map<String, String> param);




	public int queryBenOperation(Map<String, String> param);




	public boolean Updatexx(ZdryQbZdryxxb entity);




	public void saveZdryqbxxyw(ZdryQbzdryYwczb entityyw, Map<String, String> param);




	public void acceptZdryqbxxyw(ZdryQbzdryYwczb entityyw, Map<String, String> param);




	public boolean querySyrk(Map<String, String> param);




	public SyrkSyrkxxzb querySyrkxxzb(Map<String, String> param);




	public void InsertZdryzdryzb(SyrkSyrkxxzb syrkSyrkxxb, ZdryZdryzb zdryzdryzb, Map<String, String> param);

	
}
