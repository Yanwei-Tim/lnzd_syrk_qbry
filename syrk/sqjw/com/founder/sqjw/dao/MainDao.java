package com.founder.sqjw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.vo.CountMapVO;
import com.founder.sqjw.vo.MainVo;
import com.founder.sqjw.vo.YdjwBbrwVO;
import com.founder.sqjw.vo.YdjwCountVO;
import com.founder.sqjw.vo.ZdryCountVo;
import com.founder.sqjw.vo.ZzjgVo;
import com.founder.syfw.vo.SyfwListVo;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;

/**
 * @类名: MainDao
 * @描述: 主页Dao
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-8-14 下午6:23:41
 */
@Repository("mainDao")
public class MainDao extends BaseDaoImpl {
	/**
	 * @Title: queryPcsXqgkTj
	 * @描述: 查询派出所辖区概况统计
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryPcsXqgkTj(EasyUIPage page, MainVo entity) {
		page.setRows(queryForList("Main.queryPcsXqgkTj", entity));
		return page;
	}

	/**
	 * @Title: queryPcsXqgkXq
	 * @描述: 查询派出所辖区概况详情
	 * @作者: zhang_guoliang@founder.com
	 * @参数: 传入参数定义
	 * @返回值: List<MainVo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<MainVo> queryPcsXqgkXq(MainVo entity) {
		return queryForList("Main.queryPcsXqgkXq", entity);
	}

	@SuppressWarnings("unchecked")
	public List<SyfwListVo> queryListczf(Map<String, String> param) {

		return queryForList("Main.queryListczf", param);
	}

	@SuppressWarnings("unchecked")
	public List<SyfwListVo> queryListcheckczf(Map<String, String> param) {
		return queryForList("Main.queryListcheckczf", param);
	}

	@SuppressWarnings("unchecked")
	public List<SyfwListVo> queryListuncheckczf(Map<String, String> param) {
		return queryForList("Main.queryListuncheckczf", param);
	}

	@SuppressWarnings("unchecked")
	public List<CountMapVO> queryListzdry(Map<String, String> param) {
		return queryForList("Main.queryListzdry", param);
	}

	@SuppressWarnings("unchecked")
	public List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		return queryForList("Main.queryListByRyidYwlx", entity);
	}

	@SuppressWarnings("unchecked")
	public List<ZzjgVo> queryPcsTj(Map<String, Object> paramMap) {
		return queryForList("Main.queryPcsTj", paramMap);
	}

	@SuppressWarnings("unchecked")
	public List<ZdryCountVo> queryZdryTj(Map<String, Object> paramMap) {
		return queryForList("Main.queryZdryTj", paramMap);
	}

	public long queryCzfTj(Map<String, Object> paramMap) {
		return (long) queryForObject("Main.queryCzfTj", paramMap);
	}

	public long queryCheckTj(Map<String, Object> paramMap) {
		return (long) queryForObject("Main.queryCheckTj", paramMap);
	}

	@SuppressWarnings("unchecked")
	public List<ZdryCountVo> queryDwtj(Map<String, Object> paramMap) {
		return queryForList("Main.queryDwtj", paramMap);
	}

	@SuppressWarnings("unchecked")
	public List<CountMapVO> queryListMap(Map<String, String> param) {
		return queryForList("Main.queryListMapsyrk", param);
	}

	public long querySyfwTj(Map<String, Object> paramMap) {

		return (long) queryForObject("Main.querySyfwTj", paramMap);
	}

	@SuppressWarnings("unchecked")
	public List<ZdryCountVo> queryZdrySzTj(Map<String, Object> paramMap) {
		return queryForList("Main.queryZdrySzTj", paramMap);
	}

	@SuppressWarnings("unchecked")
	public List<CountMapVO> queryListszzdry(Map<String, String> param) {
		return queryForList("Main.queryListszzdry", param);
	}

	@SuppressWarnings("unchecked")
	public List<SyrkSyrkxxzb> zdryDetails(Map<String, Object> paramMap) {
		return queryForList("Main.zdryDetails", paramMap);
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
		YdjwCountVO returnValue = null;
		List<?> list = queryForList("Main.queryEntityCount",paramMap);
		if (list != null && list.size() > 0) {
			returnValue = (YdjwCountVO) list.get(0);
		}
		return returnValue;
	}
	/**
	 * @Title: queryBbrw
	 * @描述: 报备任务-提供给两实移动端调用【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: YdjwCountVO 返回类型 
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<YdjwBbrwVO> queryBbrw(Map<String, Object> paramMap) {
		return queryForList("Main.queryBbrw", paramMap);
	}
}