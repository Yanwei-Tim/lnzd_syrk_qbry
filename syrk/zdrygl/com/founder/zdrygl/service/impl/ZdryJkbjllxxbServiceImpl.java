package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryJkbjllxxb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.dao.ZdryJkbjllxxbDao;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.service.ZdryJkbjllxxbService;

/**
* ****************************************************************************
* @Package:      [com.founder.zdrygl.service.ZdryJkbjllxxbService.java]  
* @ClassName:    [ZdryJkbjllxxbService]   
* @Description:  [监控帮教力量 服务类]   
* @Author:       [zhang.hai@founder.com.cn]  
* @CreateDate:   [2015年9月6日 下午3:29:01]   
* @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
* @UpdateDate:   [2015年9月6日 下午3:29:01，(如多次修改保留历史记录，增加修改记录)]   
* @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
* @Version:      [v1.0]
*/
@Service("zdryJkbjllxxbService")
@Transactional
public class ZdryJkbjllxxbServiceImpl implements ZdryJkbjllxxbService {

	@Resource(name = "zdryJkbjllxxbDao")
	private ZdryJkbjllxxbDao zdryJkbjllxxbDao;
	
	@Resource(name = "zdryZdryzbDao")
	private ZdryZdryzbDao zdryZdryzbDao;

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
//	public EasyUIPage queryList(EasyUIPage page, ZdryJkbjllxxb entity) {
//		return zdryJkbjllxxbDao.queryList(page, entity);
//	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJkbjllxxb 返回类型
	 * @throws
	 */
	@Override
	public ZdryJkbjllxxb queryById(String id) {
		return zdryJkbjllxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@Override
	public void save(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryJkbjllxxbDao.save(entity);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@Override
	public void update(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryJkbjllxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
//	public void delete(ZdryJkbjllxxb entity, SessionBean sessionBean) {
//		BaseService.setCrossoutProperties(entity, sessionBean);
//		zdryJkbjllxxbDao.delete(entity, sessionBean);
//	}

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
//	public void deletePatch(ZdryJkbjllxxb[] entityArray, SessionBean sessionBean) {
//		for (int i = 0; i < entityArray.length; i++) {
//			BaseService.setCrossoutProperties(entityArray[i], sessionBean);
//			zdryJkbjllxxbDao.delete(entityArray[i], sessionBean);
//		}
//	}

	/**
	 * @Title: queryBjryIsExist
	 * @Description: TODO(帮教人员是否存在，对于同一个重点人员)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return ZdryJkbjllxxb 返回类型
	 * @throws
	 */
//	public boolean existBjry(ZdryJkbjllxxb entity) {
//		return zdryJkbjllxxbDao.existBjry(entity);
//	}
	
	/**
	 * 
	 * @Title: saveFirst
	 * @Description: TODO(重点人员列管成功后，将录入员添加为 第一个帮教力量 相关人员)
	 * @param @param zdryId    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@Override
	public void saveFirst(String zdryId){
		ZdryZdryzb zdryZdryzb=(ZdryZdryzb) zdryZdryzbDao.queryById(zdryId);		
		
		String systemDateTime = DateUtils.getSystemDateTimeString();
		
		ZdryJkbjllxxb entity = new ZdryJkbjllxxb();
		entity.setId(UUID.create()); // 生成主键
		entity.setJkbjry_xm(zdryZdryzb.getXt_lrrxm());
		entity.setJkbjry_gmsfhm(zdryZdryzb.getXt_lrrid());
		entity.setZdryid(zdryId);
		
		entity.setXt_cjsj(systemDateTime);
		entity.setXt_lrsj(systemDateTime);	
		entity.setXt_zxbz("0");
		entity.setXt_lrrxm("System");
		//add by zhoulj 2015-11-27 系統字段补全
		entity.setXt_zhxgsj(systemDateTime);
		entity.setXt_zhxgrxm("System");
		entity.setXt_zhxgrbm("System");
		// 2015-11-27 end
		zdryJkbjllxxbDao.save(entity);
	}
}
