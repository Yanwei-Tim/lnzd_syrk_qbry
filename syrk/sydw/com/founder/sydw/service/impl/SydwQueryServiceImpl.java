package com.founder.sydw.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
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
	
	@Resource(name="sydwQueryDao")
	private SydwQueryDao sydwQueryDao;
	
	@Resource(name="zpfjFjxxbService")
	private ZpfjFjxxbService zpfjFjxxbService;
	
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

	
	public EasyUIPage queryDwHs(EasyUIPage page, Dwjbxxb entity) {
		return sydwQueryDao.queryDwHs(page, entity);
	}

	
	public EasyUIPage queryDw(EasyUIPage page, Dwjbxxb entity) {
		return sydwQueryDao.queryDw(page, entity);
	}

	
	public List<Dwjbxxb> queryZbByDzId(String dwids) {
		return sydwQueryDao.queryZbByDzId(dwids);
	}

	
	public int updateHs(Dwjbxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		entity.setXt_hssj(entity.getXt_zhxgsj());
		entity.setGlbmid(sessionBean.getUserOrgCode());
		int first=sydwQueryDao.updateDwhsById(entity);
		return first;
	}

	
	public EasyUIPage queryDwDzOnPT(EasyUIPage page, Dwjbxxb entity) {
		return sydwQueryDao.queryDwDzOnPT(page, entity);
	}

	
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Dwjbxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		sydwQueryDao.delete(entity);
		//另存为到DW_DWXZXXB表数据更新
		sydwQueryDao.dwXzDelete(entity.getId());
//		applicationContext.publishEvent(new SydwModifyEvent(new EventObject(entity.getId(), "del")));
//		applicationContext.publishEvent(new TempModifyEvent(new EventObjectTemp(entity.getId(), "delete", "sydw", sessionBean)));
	}

	
	public long queryCountSydw(Dwjbxxb entity) {
		return sydwQueryDao.queryCountSydw(entity);
	}
	
	public long queryCountDw(Dwjbxxb entity) {
		return sydwQueryDao.queryCountDw(entity);
	}

}
