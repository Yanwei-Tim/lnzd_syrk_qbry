package com.founder.sqjw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.dao.MainDao;
import com.founder.sqjw.service.MainService;
import com.founder.sqjw.vo.CountMapVO;
import com.founder.sqjw.vo.MainVo;
import com.founder.sqjw.vo.YdjwBbrwVO;
import com.founder.sqjw.vo.YdjwCountVO;
import com.founder.sqjw.vo.ZdryCountVo;
import com.founder.sqjw.vo.ZzjgVo;
import com.founder.syfw.vo.SyfwListVo;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;

/**
 * @类名: MainServiceImpl
 * @描述: 主页ServiceImpl
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-8-14 下午6:22:26
 */
@Transactional
@Service("mainService")
public class MainServiceImpl implements MainService {
	@Resource(name = "mainDao")
	private MainDao mainDao;

	/**
	 * @Title: queryPcsXqgkTj
	 * @Description: 查询派出所辖区概况统计
	 * @author zhang_guoliang@founder.com
	 * @param 传入参数定义
	 * @throws
	 */
	public EasyUIPage queryPcsXqgkTj(EasyUIPage page, MainVo entity) {
		return mainDao.queryPcsXqgkTj(page, entity);
	}

	/**
	 * @Title: queryPcsXqgkXq
	 * @Description: 查询派出所辖区概况详情
	 * @author zhang_guoliang@founder.com
	 * @param 传入参数定义
	 * @throws
	 */
	public List<MainVo> queryPcsXqgkXq(MainVo entity) {
		return mainDao.queryPcsXqgkXq(entity);
	}

	public List<SyfwListVo> queryListczf(Map<String, String> param) {
		return mainDao.queryListczf(param);
	}

	public List<SyfwListVo> queryListcheckczf(Map<String, String> param) {
		return mainDao.queryListcheckczf(param);
	}

	public List<SyfwListVo> queryListuncheckczf(Map<String, String> param) {
		return mainDao.queryListuncheckczf(param);
	}

	public List<CountMapVO> queryListzdry(Map<String, String> param) {
		return mainDao.queryListzdry(param);
	}

	public List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		return mainDao.queryListByRyidYwlx(entity);
	}

	public Map<String, Object> querypcstj(Map<String, Object> paramMap) {
		// 统计实有人口
		List<ZzjgVo> zzjg = mainDao.queryPcsTj(paramMap);
		// 统计实有重点人口
		List<ZdryCountVo> zdry = mainDao.queryZdryTj(paramMap);
		// 统计房屋的
		long czf = mainDao.queryCzfTj(paramMap);
		long checkf = mainDao.queryCheckTj(paramMap);
		// 实有房屋
		long syfwnum = mainDao.querySyfwTj(paramMap);
		// 统计治安管理的
		List<ZdryCountVo> dwtj = mainDao.queryDwtj(paramMap);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("zzjg", zzjg);
		resMap.put("zdry", zdry);
		resMap.put("czf", czf);
		resMap.put("checkf", checkf);
		resMap.put("dwtj", dwtj);
		resMap.put("syfwnum", syfwnum);
		return resMap;

	}

	public Map<String, Object> querypcsSztj(Map<String, Object> paramMap) {
		// 统计实有人口
		List<ZzjgVo> zzjg = mainDao.queryPcsTj(paramMap);

		// 统计实有重点人口
		List<ZdryCountVo> zdry = mainDao.queryZdrySzTj(paramMap);
		// 统计房屋的
		long czf = mainDao.queryCzfTj(paramMap);
		long checkf = mainDao.queryCheckTj(paramMap);
		// 实有房屋
		long syfwnum = mainDao.querySyfwTj(paramMap);
		// 统计治安管理的
		List<ZdryCountVo> dwtj = mainDao.queryDwtj(paramMap);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("zzjg", zzjg);
		resMap.put("zdry", zdry);
		resMap.put("czf", czf);
		resMap.put("checkf", checkf);
		resMap.put("dwtj", dwtj);
		resMap.put("syfwnum", syfwnum);
		return resMap;

	}

	public List<CountMapVO> queryListMap(Map<String, String> param) {
		return mainDao.queryListMap(param);
	}

	public List<CountMapVO> queryListszzdry(Map<String, String> param) {
		return mainDao.queryListszzdry(param);
	}

	public Map<String, Object> zdryDetails(Map<String, Object> paramMap) {
		List<SyrkSyrkxxzb> syrkxxb = mainDao.zdryDetails(paramMap);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("syrkxxb", syrkxxb);
		return resMap;
	}
	/**
	 * @Title: queryEntityCount
	 * @描述: 获取辖区统计信息-提供给两实移动端调用【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: YdjwCountVO 返回类型 
	 * @throws
	 */
	public YdjwCountVO queryEntityCount(Map<String, Object> paramMap) {
		return mainDao.queryEntityCount(paramMap);
	}
	/**
	 * @Title: qqueryBbrw
	 * @描述: 报备任务-提供给两实移动端调用【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: YdjwCountVO 返回类型 
	 * @throws
	 */
	public List<YdjwBbrwVO> queryBbrw(Map<String, Object> paramMap) {
		return mainDao.queryBbrw(paramMap);
	}
}