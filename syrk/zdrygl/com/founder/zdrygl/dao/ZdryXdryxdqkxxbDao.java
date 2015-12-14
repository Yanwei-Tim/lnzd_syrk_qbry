package com.founder.zdrygl.dao;



import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.vo.ZdryXdryxdqkxxbVO;
import com.founder.zdrygl.bean.ZdryXdryxdqkxxb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


@Repository
public class ZdryXdryxdqkxxbDao extends BaseDaoImpl{

	public void save(ZdryXdryxdqkxxb entity){
		insert("ZdryXdryxdqkxxb.insert", entity);
	}

	public void update(ZdryXdryxdqkxxb entity){
		update("ZdryXdryxdqkxxb.update", entity);
	}

	public void delete(ZdryXdryxdqkxxb entity){
		update("ZdryXdryxdqkxxb.delete", entity);
	}

	public ZdryXdryxdqkxxb queryById(String id){
		return (ZdryXdryxdqkxxb) queryForObject("ZdryXdryxdqkxxb.queryById", id);
	}

    public EasyUIPage queryList(EasyUIPage page, ZdryXdryxdqkxxbVO entity){
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
		map.put("zdryXdryxdqkxxbVO", entity);

		page.setTotal((Integer) queryForObject("ZdryXdryxdqkxxb.queryCount", map));
		page.setRows(queryForList("ZdryXdryxdqkxxb.query", map));
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
	public List<ZdryXdryxdqkxxb> queryViewList(Map<String, Object> map) {
		List<ZdryXdryxdqkxxb> list = null;
		if (map != null) {
			String zdryid = (String) map.get("zdryid");
			if (!StringUtils.isBlank(zdryid)) {
				list = queryForList("ZdryXdryxdqkxxb.queryViewList", map);
			}
		}
		return list;
	}

}
