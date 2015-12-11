package com.founder.xlpc.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xlpc.dao.XlpcDao;
import com.founder.xlpc.service.XlpcService;
import com.founder.xlpc.vo.PcrwVO;
import com.founder.xlpc.vo.PcryVO;
/**
 * @类名: XlpcServiceImpl
 * @描述: 巡逻盘查ServiceImpl
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-1	1-22 下午3:59:45 
 */
@Service("xlpcService")
@Transactional
public class XlpcServiceImpl extends BaseService implements XlpcService {
	@Resource(name = "xlpcDao")
	private XlpcDao xlpcDao;
	/**
     * @Title: queryPcryList 
     * @描述: 盘查人员列表
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-11-22 下午2:48:35 
     * @throws
     */
	public EasyUIPage queryPcryList(EasyUIPage page, PcryVO entity) {
		return xlpcDao.queryPcryList(page,entity);
	}
	/**
     * @Title: queryPcrwList 
     * @描述: 盘查任务列表
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-11-24 下午2:12:35 
     * @throws
     */
	public EasyUIPage queryPcrwList(EasyUIPage page, PcrwVO entity) {
		return xlpcDao.queryPcrwList(page,entity);
	}
}