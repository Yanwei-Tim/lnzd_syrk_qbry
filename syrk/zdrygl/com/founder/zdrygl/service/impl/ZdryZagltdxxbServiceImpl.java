
package com.founder.zdrygl.service.impl;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.utils.EasyUIPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryZagltdxxb;
import com.founder.zdrygl.vo.ZdryZagltdxxbVO;
import com.founder.zdrygl.dao.ZdryZagltdxxbDao;
import com.founder.zdrygl.service.ZdryZagltdxxbService;

import javax.annotation.Resource;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryZagltdxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-03 03:22:39
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-03 03:22:39，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@Service
@Transactional
public class ZdryZagltdxxbServiceImpl implements ZdryZagltdxxbService {

    @Resource
	private ZdryZagltdxxbDao zdryZagltdxxbDao;

	/**
	 * 新增<br>
	 *
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = MethodAnnotation.logType.insert)
	@Override
	public void save(ZdryZagltdxxb entity, SessionBean sessionBean){
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryZagltdxxbDao.save(entity);
	}


	@Override
	public void delete(ZdryZagltdxxb entity,SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryZagltdxxbDao.delete(entity);
	}

	/**
	 * 更新<br>
	 *
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type =MethodAnnotation.logType.update)
	@Override
	public void update(ZdryZagltdxxb entity, SessionBean sessionBean){
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryZagltdxxbDao.update(entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryZagltdxxb 返回类型
	 * @throws
	 */
	@Override
	public ZdryZagltdxxb queryById(String id){
		return zdryZagltdxxbDao.queryById(id);
	}



	/**
	 * 查询列表<br>
	 *
	 * @param page
	 * @param entity
	 * @return
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryZagltdxxbVO entity){
		return zdryZagltdxxbDao.queryList(page, entity);
	}
	
}
