package com.founder.xlpc.service;
import java.util.List;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xlpc.vo.PcclVO;
import com.founder.xlpc.vo.PcrwVO;
import com.founder.xlpc.vo.PcryVO;
/**
 * @类名: XlpcService 
 * @描述: 巡逻盘查Service 
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-11-22 下午3:56:43 
 */
@TypeAnnotation("巡逻盘查")
public interface XlpcService {
	/**
	 * @Title: queryPcrwList
	 * @描述: 盘查任务列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-11-24 下午3:11:52 
	 * @返回值: EasyUIPage  返回类型 
	 * @throws
	 */
	public EasyUIPage queryPcrwList(EasyUIPage page, PcrwVO entity);
	/**
	 * @Title: queryPcryList
	 * @描述: 盘查人员列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-11-22 下午3:57:32 
	 * @返回值: EasyUIPage  返回类型 
	 * @throws
	 */
	public EasyUIPage queryPcryList(EasyUIPage page, PcryVO entity);
	/**
	 * @Title: queryPcclList
	 * @描述: 盘查车辆列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-12-08 下午2:43:31 
	 * @返回值: EasyUIPage  返回类型 
	 * @throws
	 */
	public EasyUIPage queryPcclList(EasyUIPage page, PcclVO entity);
	/**
	 * @Title: queryPcry
	 * @描述: 根据盘查任务查询盘查人员
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-12-09  上午9:35:53
	 * @返回值: List<PcryVO> 返回类型 
	 * @throws
	 */
	public List<PcryVO> queryPcry(PcryVO entity);
	/**
	 * @Title: queryPccl
	 * @描述: 根据盘查任务查询盘查车辆
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-12-09  上午11:32:13
	 * @返回值: List<PcclVO> 返回类型 
	 * @throws
	 */
	public List<PcclVO> queryPccl(PcclVO entity);
}