package com.founder.zdrygl.dao;



import com.founder.zdrygl.bean.ZdryZagltdxxb;
import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.vo.ZdryXdrynjxxbVO;
import com.founder.zdrygl.bean.ZdryXdrynjxxb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


@Repository
public class ZdryXdrynjxxbDao extends BaseDaoImpl{

	public void save(ZdryXdrynjxxb entity){
		insert("ZdryXdrynjxxb.insert", entity);
	}

	public void update(ZdryXdrynjxxb entity){
		update("ZdryXdrynjxxb.update", entity);
	}

	public void delete(ZdryXdrynjxxb entity){
		update("ZdryXdrynjxxb.delete", entity);
	}

	public ZdryXdrynjxxb queryById(String id){
		return (ZdryXdrynjxxb) queryForObject("ZdryXdrynjxxb.queryById", id);
	}

    public EasyUIPage queryList(EasyUIPage page, ZdryXdrynjxxbVO entity){
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
		map.put("zdryXdrynjxxbVO", entity);

		page.setTotal((Integer) queryForObject("ZdryXdrynjxxb.queryCount", map));
		page.setRows(queryForList("ZdryXdrynjxxb.query", map));
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
	public List<ZdryXdrynjxxb> queryViewList(Map<String, Object> map) {
		List<ZdryXdrynjxxb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryXdrynjxxb.queryViewList", map);
			}
		}
		return list;
	}

}
