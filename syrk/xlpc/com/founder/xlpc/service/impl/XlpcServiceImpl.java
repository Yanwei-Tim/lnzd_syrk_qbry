package com.founder.xlpc.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xlpc.dao.XlpcDao;
import com.founder.xlpc.service.XlpcService;
import com.founder.xlpc.vo.PcclVO;
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
     * @Title: queryPcclList 
     * @描述: 盘查车辆列表
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-12-08 下午2:42:12 
     * @throws
     */
	public EasyUIPage queryPcclList(EasyUIPage page, PcclVO entity) {
		return xlpcDao.queryPcclList(page,entity);
	}
	/**
     * @Title: queryPcry 
     * @描述: 根据盘查任务查询盘查人员
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-12-09  上午9:35:53 
     * @throws
     */
	public List<PcryVO> queryPcry(PcryVO entity) {
		return xlpcDao.queryPcry(entity);
	}
	/**
     * @Title: queryPccl 
     * @描述: 根据盘查任务查询盘查车辆
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-12-09 上午11:32:13
     * @返回值: List<PcclVO> 返回类型
     * @throws
     */
	public List<PcclVO> queryPccl(PcclVO entity) {
		return xlpcDao.queryPccl(entity);
	}
}