
package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.utils.EasyUIPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryXdryxdqkxxb;
import com.founder.zdrygl.vo.ZdryXdryxdqkxxbVO;
import com.founder.zdrygl.dao.ZdryXdryxdqkxxbDao;
import com.founder.zdrygl.service.ZdryXdryxdqkxxbService;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryXdryxdqkxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-11 03:10:48
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-11 03:10:48，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@Service
@Transactional
public class ZdryXdryxdqkxxbServiceImpl implements ZdryXdryxdqkxxbService {

    @Resource
	private ZdryXdryxdqkxxbDao zdryXdryxdqkxxbDao;

	/**
	 * 新增<br>
	 *
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type =MethodAnnotation.logType.insert)
	@Override
	public void save(ZdryXdryxdqkxxb entity, SessionBean sessionBean){
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryXdryxdqkxxbDao.save(entity);
	}

	@Override
	public void delete(ZdryXdryxdqkxxb entity,SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryXdryxdqkxxbDao.delete(entity);
	}

	/**
	 * 更新<br>
	 *
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type =MethodAnnotation.logType.update)
	@Override
	public void update(ZdryXdryxdqkxxb entity, SessionBean sessionBean){
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryXdryxdqkxxbDao.update(entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryXdryxdqkxxb 返回类型
	 * @throws
	 */
    @Override
	public ZdryXdryxdqkxxb queryById(String id){
		return zdryXdryxdqkxxbDao.queryById(id);
	}

	/**
	 * 查询列表<br>
	 *
	 * @param page
	 * @param entity
	 * @return
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryXdryxdqkxxbVO entity){
		return zdryXdryxdqkxxbDao.queryList(page, entity);
	}
	
}
