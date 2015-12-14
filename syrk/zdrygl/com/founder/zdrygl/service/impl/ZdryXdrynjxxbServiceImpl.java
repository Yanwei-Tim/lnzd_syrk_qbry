
package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.utils.EasyUIPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryXdrynjxxb;
import com.founder.zdrygl.vo.ZdryXdrynjxxbVO;
import com.founder.zdrygl.dao.ZdryXdrynjxxbDao;
import com.founder.zdrygl.service.ZdryXdrynjxxbService;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryXdrynjxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-11 03:08:19
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-11 03:08:19，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@Service
@Transactional
public class ZdryXdrynjxxbServiceImpl implements ZdryXdrynjxxbService {

    @Resource
	private ZdryXdrynjxxbDao zdryXdrynjxxbDao;

	/**
	 * 新增<br>
	 *
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type =MethodAnnotation.logType.insert)
	@Override
	public void save(ZdryXdrynjxxb entity, SessionBean sessionBean){
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryXdrynjxxbDao.save(entity);
	}

	@Override
	public void delete(ZdryXdrynjxxb entity,SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryXdrynjxxbDao.delete(entity);
	}

	/**
	 * 更新<br>
	 *
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type =MethodAnnotation.logType.update)
	@Override
	public void update(ZdryXdrynjxxb entity, SessionBean sessionBean){
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryXdrynjxxbDao.update(entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryXdrynjxxb 返回类型
	 * @throws
	 */
    @Override
	public ZdryXdrynjxxb queryById(String id){
		return zdryXdrynjxxbDao.queryById(id);
	}

	/**
	 * 查询列表<br>
	 *
	 * @param page
	 * @param entity
	 * @return
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryXdrynjxxbVO entity){
		return zdryXdrynjxxbDao.queryList(page, entity);
	}
	
}
