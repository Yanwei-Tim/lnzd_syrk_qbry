package com.founder.zdrygl.dao;



import com.founder.zdrygl.bean.ZdryZdrykcxxb;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.vo.ZdryWffzjlxxbVO;
import com.founder.zdrygl.bean.ZdryWffzjlxxb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryWffzjlxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-03 03:41:42
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-03 03:41:42，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@Repository
public class ZdryWffzjlxxbDao extends BaseDaoImpl{

	public void save(ZdryWffzjlxxb entity){
		insert("ZdryWffzjlxxb.save", entity);
	}

	public void update(ZdryWffzjlxxb entity){
		update("ZdryWffzjlxxb.update", entity);
	}

	public void delete(ZdryWffzjlxxb entity){
		update("ZdryWffzjlxxb.delete", entity);
	}

	public ZdryWffzjlxxb queryById(String id){
		return (ZdryWffzjlxxb) queryForObject("ZdryWffzjlxxb.queryById", id);
	}

    public EasyUIPage queryList(EasyUIPage page, ZdryWffzjlxxbVO entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
		sort = "id";
		order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdryWffzjlxxbVO", entity);

		page.setTotal((Integer) queryForObject("ZdryWffzjlxxb.queryCount", map));
		page.setRows(queryForList("ZdryWffzjlxxb.query", map));
		return page;
	}

	/**
	 *
	 * @Title: queryViewList
	 * @Description: TODO(查询下方菜单显示的信息，有最大条数限制)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryPsjdb>    返回类型
	 * @throws
	 */
	public List<ZdryWffzjlxxbVO> queryViewList(Map<String, Object> map) {
		List<ZdryWffzjlxxbVO> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryWffzjlxxb.queryViewList", map);
			}
		}
		return list;
	}
}
