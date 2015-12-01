package com.founder.sydw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dictxxb;
import com.founder.sydw.bean.Dwcyjcrwxxb;
import com.founder.sydw.bean.Dwjcdata;
import com.founder.sydw.bean.Dwjctype;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.dao.CyjhDao;
import com.founder.sydw.dao.DwjcxxbDao;
import com.founder.sydw.service.DwjcxxbService;
@Service("dwjcxxbService")
@Transactional
public class DwjcxxbServiceImpl implements DwjcxxbService {
	
	@Resource(name = "dwjcxxbDao")
	private DwjcxxbDao dwjcxxbDao;
	
	@Resource(name = "cyjhDao")
	private CyjhDao cyjhDao;
	
	@Override
	public void save(Dwjcxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		dwjcxxbDao.save(entity, sessionBean);
		List<Dwjctype> list = entity.getList();
		for(Dwjctype dt:list){
			dt.setJcid(entity.getId());
			dt.setId(UUID.create());
			dt.setXt_zxbz("0");
			dwjcxxbDao.saveDwjctype(dt, sessionBean);
			List<Dwjcdata> rows = dt.getList();
			for(Dwjcdata dd:rows){
				dd.setTypeid(dt.getId());
				dd.setJcid(entity.getId());
				dd.setXt_zxbz("0");
				dwjcxxbDao.saveDwjcdata(dd, sessionBean);
			}
		}
		//任务检查时删除任务同时更新任务对应的检查记录
		String rwid = entity.getRwid();
		if(rwid!=null&&!"".equals(rwid)){
			Dwcyjcrwxxb dwcyjcrwxxb = new Dwcyjcrwxxb();
			dwcyjcrwxxb.setId(rwid);
			dwcyjcrwxxb.setJcid(entity.getId());
			dwcyjcrwxxb.setXt_zxbz("1");
			cyjhDao.modifyDwcyjcrwxxb(dwcyjcrwxxb, sessionBean);
		}
	}

	@Override
	public Dwjcxxb query(Dwjcxxb entity) {
		Dwjcxxb dwjcxxb = dwjcxxbDao.query(entity.getId());
		if(dwjcxxb == null){
			return null;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("jcid", entity.getId());
		List<Dwjctype> list = dwjcxxbDao.queryDwjcxxbtype(map);
		for(Dwjctype dt:list){
			map.put("typeid", dt.getJcid());
			List<Dwjcdata> rows = dwjcxxbDao.queryDwjcxxbdata(map);
			dt.setList(rows);
		}
		dwjcxxb.setList(list);
		return dwjcxxb;
	}

	@Override
	public void update(Dwjcxxb entity, SessionBean sessionBean) {
		
		if(StringUtils.isBlank(entity.getXt_cjsj())&& "14".equals(entity.getYwlbdm())){
			BaseService.setSaveProperties(entity, sessionBean);
		}else{
			BaseService.setUpdateProperties(entity, sessionBean);
		}
		
		//技防的需要做特殊的业务处理
		if("14".equals(entity.getYwlbdm())){
			//业务状态为99的，应该是检查通过的，更改状态码
			if("99".equals(entity.getZt())){
				entity.setZt("2");
			}
		}
		
		dwjcxxbDao.update(entity, sessionBean);
		dwjcxxbDao.deleteDwjctype(entity, sessionBean);
		dwjcxxbDao.deleteDwjcdata(entity, sessionBean);
		List<Dwjctype> list = entity.getList();
		for(Dwjctype dt:list){
			dt.setJcid(entity.getId());
			dt.setId(UUID.create());
			dwjcxxbDao.saveDwjctype(dt, sessionBean);
			List<Dwjcdata> rows = dt.getList();
			for(Dwjcdata dd:rows){
				dd.setTypeid(dt.getId());
				dd.setJcid(entity.getId());
				dd.setXt_zxbz("0");
				dwjcxxbDao.saveDwjcdata(dd, sessionBean);
			}
		}
	}
	
	@Override
	public void updateZt(String id,String zt, SessionBean sessionBean) {
		
		Dwjcxxb entity = this.dwjcxxbDao.query(id);
		entity.setZt(zt);
//		String oldZt = entity.getZt();
//		
//		if("1".equals(zt) && !"0".equals(oldZt)){
//			throw new BussinessException("请重新刷新数据");
//		}else if("2".equals(zt) && !"1".equals(oldZt)){
//			throw new BussinessException("请重新刷新数据");
//		}else if("3".equals(zt) && !"2".equals(oldZt)){
//			throw new BussinessException("请重新刷新数据");
//		}
		
		BaseService.setUpdateProperties(entity, sessionBean);
		dwjcxxbDao.update(entity, sessionBean);
	}

	@Override
	public List<Dwjctype> queryDwjctype(Map<String, Object> param) {
		List<Dwjctype> list = dwjcxxbDao.queryDwjctype(param);
		if(list!=null&&list.size()>0){
			Map<String,Object> map = new HashMap<String,Object>();
			for(Dwjctype dwjctype:list){
				map.put("typeid", dwjctype.getId());
				List<Dwjcdata> datas = dwjcxxbDao.queryDwjcdata(map);
				dwjctype.setList(datas);
			}
		}
		return list;
	}

	@Override
	public List<Dwjcdata> queryDwjcdata(Map<String, Object> param) {
		return dwjcxxbDao.queryDwjcdata(param);
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Dwjcxxb entity) {
		if("unCheck".equals(entity.getStatus())){
			entity.setStatus("A.ZT in ('0','1')");
		}else if("checked".equals(entity.getStatus())){
			entity.setStatus("A.ZT not in ('0','1')");
		}
		return dwjcxxbDao.queryList(page, entity);
	}

	@Override
	public Dwjcxxb queryDwfsxxByDwid(String dwid) {
		return dwjcxxbDao.queryDwfsxxByDwid(dwid);
	}

	@Override
	public List<Dwjcxxb> dwjcxxb_query(Map<String, Object> map) {
		return dwjcxxbDao.dwjcxxb_query(map);
	}
	@Override
	public Dictxxb getCt(String dwlbdm) {
		return dwjcxxbDao.getCt(dwlbdm);
	}


}
