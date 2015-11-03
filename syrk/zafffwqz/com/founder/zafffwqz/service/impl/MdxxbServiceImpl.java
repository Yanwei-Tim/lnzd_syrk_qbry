package com.founder.zafffwqz.service.impl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Dsrxxzb;
import com.founder.zafffwqz.bean.Gzjzqkzb;
import com.founder.zafffwqz.bean.Mdxxb;
import com.founder.zafffwqz.bean.Tjxxzb;
import com.founder.zafffwqz.dao.DsrxxzbDao;
import com.founder.zafffwqz.dao.GzjzqkzbDao;
import com.founder.zafffwqz.dao.MdxxbDao;
import com.founder.zafffwqz.dao.TjxxzbDao;
import com.founder.zafffwqz.service.DsrxxzbService;
import com.founder.zafffwqz.service.GzjzqkzbService;
import com.founder.zafffwqz.service.MdxxbService;
import com.founder.zafffwqz.service.TjxxzbService;

@Service("mdxxbService")
@Transactional
public class MdxxbServiceImpl extends BaseService implements MdxxbService {
	
	@Resource(name = "mdxxbDao")
	private MdxxbDao mdxxbDao;
	@Resource
	private DsrxxzbDao  dsrxxzbDao;
	@Resource
	private TjxxzbDao tjxxzbDao;
	@Resource
	private GzjzqkzbDao gzjzqkzbDao;
	@Resource
	private DsrxxzbService  dsrxxzbService;
	@Resource
	private TjxxzbService tjxxzbService;
	@Resource
	private GzjzqkzbService gzjzqkzbService;
	@Override
	public void delete(Mdxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		mdxxbDao.delete(entity);
		//删除当事人信息子表
		Dsrxxzb dsqEntity=new Dsrxxzb();
		dsqEntity.setMdjfxxid(entity.getId());
		List<Dsrxxzb> dsrs=dsrxxzbDao.queryDsrxxzbList(dsqEntity);
		if(dsrs!=null && dsrs.size()>0){
			for(Dsrxxzb dsr:dsrs){
				this.dsrxxzbService.delete(dsr,sessionBean);
			}
		}
		
		//删除调解信息字表
		Tjxxzb tjxxEntity=new Tjxxzb();
		tjxxEntity.setMdjfxxid(entity.getId());
		List<Tjxxzb> tjxxs=this.tjxxzbDao.queryTjxxzbList(tjxxEntity);
		if(tjxxs!=null && tjxxs.size()>0){
			for(Tjxxzb tjxx:tjxxs){
				this.tjxxzbService.delete(tjxx, sessionBean);
			}
		}
		
		
		//删除跟踪进展情况子表
		Gzjzqkzb gzjzEntity=new Gzjzqkzb();
		gzjzEntity.setMdjfxxid(entity.getId());
		List<Gzjzqkzb> gzjzqks=this.gzjzqkzbDao.queryGzjzqkzbList(gzjzEntity);
		if(gzjzqks!=null && gzjzqks.size()>0){
			for(Gzjzqkzb gzjzqk:gzjzqks){
				this.gzjzqkzbService.delete(gzjzqk, sessionBean);
			}
		}
		
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return mdxxbDao.queryList(page, map);
	}

	@Override
	public Mdxxb queryMdxxb(Mdxxb entity) {
		return mdxxbDao.queryMdxxb(entity);
	}

	@Override
	public void saveMdxxb(Mdxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		mdxxbDao.saveMdxxb(entity);
		
	}

	@Override
	public void updateMdxxb(Mdxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		mdxxbDao.updateMdxxb(entity);
	}

}
