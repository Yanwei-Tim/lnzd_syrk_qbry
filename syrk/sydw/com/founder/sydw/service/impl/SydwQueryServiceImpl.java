package com.founder.sydw.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.ContextSearchUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.gzjk.event.SydwModifyEvent;
import com.founder.gzjk.event.TempModifyEvent;
import com.founder.gzjk.event.entity.EventObject;
import com.founder.gzjk.event.entity.EventObjectTemp;
import com.founder.service.attachment.bean.ZpfjFjxxb;
import com.founder.service.attachment.service.ZpfjFjxxbService;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.dao.DwjbxxbDao;
import com.founder.sydw.dao.SydwQueryDao;
import com.founder.sydw.service.SydwQueryService;
@Service("sydwQueryService")
@Transactional
public class SydwQueryServiceImpl implements SydwQueryService {
	@Resource(name="dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Resource(name="sydwQueryDao")
	private SydwQueryDao sydwQueryDao;
	
	@Resource(name="zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	@Override
	public List<Dwjbxxb> queryDwByDzDm(Dwjbxxb entity) {
		ZpfjFjxxb zp =null;
		 List<Dwjbxxb> list = dwjbxxbDao.queryDwByDzDm(entity);
		 for (Dwjbxxb dwjbxxb : list) {
			 zp =  zpfjFjxxbService.showZpByLyid(dwjbxxb.getId());
			 	HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.IMAGE_JPEG);
				if(null!=zp&&null!=zp.getWj()){
			 dwjbxxb.setZpfj(new HttpEntity<byte[]>(zp.getWj(), headers));
				}
		}
		return list;
	}

	@Override
	public EasyUIPage queryDwHs(EasyUIPage page, Dwjbxxb entity) {
		return sydwQueryDao.queryDwHs(page, entity);
	}

	@Override
	public EasyUIPage queryDw(EasyUIPage page, Dwjbxxb entity) {
		return sydwQueryDao.queryDw(page, entity);
	}

	@Override
	public List<Dwjbxxb> queryZbByDzId(String dwids) {
		return sydwQueryDao.queryZbByDzId(dwids);
	}

	@Override
	public int updateHs(Dwjbxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		entity.setXt_hssj(entity.getXt_zhxgsj());
		if(!StringUtils.isBlank(entity.getDwmc())){
		}
		entity.setGlbmid(sessionBean.getUserOrgCode());
		int first=sydwQueryDao.updateDwhsById(entity);
//		applicationContext.publishEvent(new SydwModifyEvent(new EventObject(entity.getId(), "update")));
		return first;
	}

	@Override
	public EasyUIPage queryDwDzOnPT(EasyUIPage page, Dwjbxxb entity) {
		return sydwQueryDao.queryDwDzOnPT(page, entity);
	}

	@Override
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Dwjbxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		sydwQueryDao.delete(entity);
		//另存为到DW_DWXZXXB表数据更新
		sydwQueryDao.dwXzDelete(entity.getId());
//		applicationContext.publishEvent(new SydwModifyEvent(new EventObject(entity.getId(), "del")));
//		applicationContext.publishEvent(new TempModifyEvent(new EventObjectTemp(entity.getId(), "delete", "sydw", sessionBean)));
	}

	@Override
	public long queryCountSydw(Dwjbxxb entity) {
		return sydwQueryDao.queryCountSydw(entity);
	}
//
//	@Override
//	public long queryCountSydwHs(Dwjbxxb entity) {
//		return sydwQueryDao.queryCountSydwHs(entity);
//	}

	@Override
	public long queryCountDw(Dwjbxxb entity) {
		return sydwQueryDao.queryCountDw(entity);
	}

}
