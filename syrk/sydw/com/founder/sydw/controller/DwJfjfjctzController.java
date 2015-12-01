package com.founder.sydw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.Dwjcdata;
import com.founder.sydw.bean.Dwjctype;
import com.founder.sydw.bean.Dwjcxxb;
import com.founder.sydw.bean.Dwjffctzs;
import com.founder.sydw.bean.Dwjffctzscg;
import com.founder.sydw.bean.Dwjfjfjctzs;
import com.founder.sydw.bean.Dwjfjfjctzscg;
import com.founder.sydw.bean.Dwjfzltzs;
import com.founder.sydw.dao.DwjcxxbDao;
import com.founder.sydw.dao.DwjffctzsDao;
import com.founder.sydw.dao.DwjffctzscgDao;
import com.founder.sydw.dao.DwjfjfjctzsDao;
import com.founder.sydw.dao.DwjfjfjctzscgDao;
import com.founder.sydw.dao.DwjfzltzsDao;
import com.founder.sydw.service.DwjbxxbService;
import com.founder.sydw.service.DwjcxxbService;
import com.founder.sydw.service.DwjfjfjctzService;
import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.controller.DwJfjfjctzController.java]  
 * @ClassName:    [DwJfjfjctzController]   
 * @Description:  技防检查 整改 
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-29 下午3:03:22]   
 * @UpdateUser:   [xuhaibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-29 下午3:03:22，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping(value = "/jfjfjctz")
public class DwJfjfjctzController extends BaseController{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="dwjfjfjctzsDao")
	private DwjfjfjctzsDao dwjfjfjctzsDao;
	@Resource(name="dwjfjfjctzscgDao")
	private DwjfjfjctzscgDao dwjfjfjctzscgDao;
	@Resource(name="dwjfjfjctzService")
	private DwjfjfjctzService dwjfjfjctzService;
	@Resource(name="dwjbxxbService")
	private DwjbxxbService dwjbxxbService;
	@Resource(name="dwjcxxbService")
	private DwjcxxbService dwjcxxbService;
	@Resource(name= "dwjfzltzsDao")
	private DwjfzltzsDao dwjfzltzsDao;
	@Resource(name="dwjffctzsDao")
	private DwjffctzsDao dwjffctzsDao;
	@Resource(name="dwjffctzscgDao")
	private DwjffctzscgDao dwjffctzscgDao;
	@Resource(name="dwjcxxbDao")
	private DwjcxxbDao dwjcxxbDao;
	
	@RequestMapping(value = "/fjxxUpload", method = RequestMethod.GET)
	public @ResponseBody ModelAndView fjxxUpload(String jcid) {
		ModelAndView mv = new ModelAndView("syrkgl/syrkfjEdit");
		mv.addObject("lybm", "DW_DWJCXXB");
		mv.addObject("lyid", jcid);
		mv.addObject("lyms", "单位检查记录-附件");
		mv.addObject("fileType", "");
		mv.addObject("fileOnly", 0);
		return mv;
	}
	
	@RequestMapping(value = "/showPrintView", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showPrintView(String jcid,String type,String mainTabID) {
		
		String viewName = "sydw/";
		Object entity = null;
		List<Dwjctype> list = null;
		if("jfjfjctzs".equals(type)){
			//检查通知
			viewName += "jfjfjctzsDetail";
			Dwjfjfjctzs dwjfjfjctzs = new Dwjfjfjctzs();
			dwjfjfjctzs.setJcid(jcid);
			dwjfjfjctzs = this.dwjfjfjctzsDao.query(dwjfjfjctzs);
			entity = dwjfjfjctzs;
		}else if("jfjfjctzscg".equals(type)){
			//检查通知书存根
			viewName += "jfjfjctzscgDetail";
			Dwjfjfjctzscg dwjfjfjctzscg = new Dwjfjfjctzscg();
			dwjfjfjctzscg.setJcid(jcid);
			dwjfjfjctzscg = this.dwjfjfjctzscgDao.query(dwjfjfjctzscg);
			entity = dwjfjfjctzscg;
		}else if("jfdwjcjl".equals(type)){
			//检查记录
			viewName += "jfdwjcjlDetail";
			Dwjcxxb dwjcxxb = this.dwjcxxbDao.query(jcid);
			Dwjbxxb dw = new Dwjbxxb();
			dw.setId(dwjcxxb.getDwid());
			dw = this.dwjbxxbService.query(dw);
			dwjcxxb.setDwmc(dw.getDwmc());
			entity = dwjcxxb;
		}else if("jfdwjcjlb".equals(type)){
			//检查记录表
			viewName += "jfdwjcjlbDetail";
			Dwjcxxb dwjcxxb = this.dwjcxxbDao.query(jcid);
			
			list = new ArrayList<Dwjctype>();
			list= dwjcxxb.getList();
			if (list == null || list.isEmpty()) {
				Map<String,Object> param = new HashMap<String,Object>();
				
				Dwjbxxb dw = new Dwjbxxb();
				dw.setId(dwjcxxb.getDwid());
				dw = this.dwjbxxbService.query(dw);
				
				param.put("sydwlx", dw.getDwlbdm());
				param.put("ywlbdm", "14");
				list = dwjcxxbService.queryDwjctype(param);
			}
		}else if("jffctzs".equals(type)){
			//复查意见书
			viewName += "jffctzsDetail";
			Dwjffctzs dwjffctzs = new Dwjffctzs();
			dwjffctzs.setJcid(jcid);
			dwjffctzs = this.dwjffctzsDao.query(dwjffctzs);
			entity = dwjffctzs;
		}else if("jffctzscg".equals(type)){
			//复查意见书存根
			viewName += "jffctzscgDetail";
			Dwjffctzscg dwjffctzscg = new Dwjffctzscg();
			dwjffctzscg.setJcid(jcid);
			dwjffctzscg = this.dwjffctzscgDao.query(dwjffctzscg);
			entity = dwjffctzscg;
		}else if("jfzltzs".equals(type)){
			//责令整改通知书
			viewName += "jfzltzsDetail";
			Dwjfzltzs dwjfzltzs = new Dwjfzltzs();
			dwjfzltzs.setJcid(jcid);
			dwjfzltzs = this.dwjfzltzsDao.query(dwjfzltzs);
			entity = dwjfzltzs;
		}
		
		ModelAndView mv = new ModelAndView(viewName);
		mv.addObject("entity", entity);
		if(list != null){
			mv.addObject("list", list);
		}
		mv.addObject("mainTabID", mainTabID);
		return mv;
	
	}
	
	/**
	 * 
	 * @Title: saveJfjctzs
	 * @Description: 保存、更新技防通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return JFDwzlzgtzs    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveJfjfjctzs", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveJfjctzs(Dwjfjfjctzs entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			
			if (StringUtils.isBlank(entity.getId())) {
				this.dwjfjfjctzService.saveJfjfjctzs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "保存成功！");
			} else {
				this.dwjfjfjctzService.updateJfjfjctzs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改成功！");
			}
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveJfdwjcjl", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveJfdwjcjl(Dwjcxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			
			this.dwjfjfjctzService.saveJfdwjctjl(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "保存成功！");
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveJfdwjcjlb", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveJfdwjcjlb(Dwjcxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		
		JSONArray  jcxmxJsonArray =JSONArray.fromObject(entity.getJcxmx());
		List<Dwjctype> list = new ArrayList<Dwjctype>();
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setRootClass(Dwjctype.class);
		Map<String, Class> classMap = new HashMap<String, Class>();  
		classMap.put("list", Dwjcdata.class); // 指定JsonRpcRequest的request字段的内部类型  
		jsonConfig.setClassMap(classMap);
		list = (List<Dwjctype>)jcxmxJsonArray.toCollection(jcxmxJsonArray, jsonConfig);
		entity.setList(list);
		
		try {
			if("checkOk".equals(entity.getStatusFlag())){
				//检查通过
				entity.setZt("3");
			}else if("zlzg".equals(entity.getStatusFlag())){
				//责令限期整改通知书
				entity.setZt("80");
			}
			dwjcxxbService.update(entity, sessionBean);//更新了检查记录与检查项的关系
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "保存成功！");
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 
	 * @Title: saveJfjctzs
	 * @Description: 保存、更新技防通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return JFDwzlzgtzs    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveJfjfjctzscg", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveJfjctzscg(Dwjfjfjctzscg entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			
			if (StringUtils.isBlank(entity.getId())) {
				this.dwjfjfjctzService.saveJfjfjctzscg(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "保存成功！");
			} else {
				this.dwjfjfjctzService.updateJfjfjctzscg(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改成功！");
			}
			
			// 返回主键
			model.put(AppConst.SAVE_ID, entity.getId()); 
			
			//更新检查状态:日常检查
			this.dwjcxxbService.updateZt(entity.getJcid(), "99", sessionBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	
	@RequestMapping(value = "/showWorkflow", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showWorkflow(String mainTabID,String jcid) {
		ModelAndView mv = new ModelAndView("sydw/jfjcWorkflow");
		
		SessionBean sessionBean = getSessionBean();
		Dwjcxxb dwjcxxb = new Dwjcxxb();
		dwjcxxb.setId(jcid);
		dwjcxxb = dwjcxxbService.query(dwjcxxb);
		
		mv.addObject("entity", dwjcxxb);
		mv.addObject("mainTabID", mainTabID);
		return mv;
	}
	
	@RequestMapping(value = "/addJfjfjctzs", method = RequestMethod.GET)
	public @ResponseBody ModelAndView addJfjfjctzs(String id, String dwid,String mainTabID,String jcid) {
		ModelAndView mv = new ModelAndView("sydw/jfjfjctzsAdd");
		
		SessionBean sessionBean = getSessionBean();
		Dwjcxxb dwjcxxb = null;
		if(StringUtils.isBlank(jcid)){
			//检查信息id空，代表需要初始化新建一条 检查信息
			dwjcxxb = this.createInitJfDwjcxxbByDwid(dwid, sessionBean);
		}else{
			dwjcxxb = new Dwjcxxb();
			dwjcxxb.setId(jcid);
			dwjcxxb = dwjcxxbService.query(dwjcxxb);
		}
		
		jcid = dwjcxxb.getId();
		
		Dwjfjfjctzs entity = new Dwjfjfjctzs();
		if(StringUtils.isBlank(id)){
			entity.setJcid(jcid);
			entity = this.dwjfjfjctzsDao.query(entity);
			if(entity == null){
				entity = new Dwjfjfjctzs(); 
				entity.setWh(this.dwjfjfjctzService.getWhHead(sessionBean)+"公（技）责通字["+DateUtils.getSystemYearString()+"]"+this.dwjfjfjctzsDao.queryXh()+"号");
				entity.setZzjgid(sessionBean.getExtendValue("ssFsxCode"));
				entity.setZzjgmc(sessionBean.getExtendValue("ssFsxName"));
				entity.setJcid(dwjcxxb.getId());
				entity.setDwid(dwid);
				
				Dwjbxxb dw = new Dwjbxxb();
				dw.setId(dwid);
				dw = this.dwjbxxbService.query(dw);
				if(dw != null){
					entity.setDwmc(dw.getDwmc());
				}
			}
		}else{
			entity = this.dwjfjfjctzsDao.queryEntityById(id);
		}
		
		mv.addObject("entity", entity);
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("rwid", null);
		return mv;
	}
	
	@RequestMapping(value = "/addJffctzs", method = RequestMethod.GET)
	public @ResponseBody ModelAndView addJffctzs(String id,String mainTabID,String jcid) {
		ModelAndView mv = new ModelAndView("sydw/jffctzsAdd");
		
		Dwjffctzs entity = null;
		if(!StringUtils.isBlank(id)){
			entity = this.dwjffctzsDao.queryEntityById(id);
		}else{
			Dwjcxxb dwjcxxb = new Dwjcxxb();
			dwjcxxb.setId(jcid);
			dwjcxxb = dwjcxxbService.query(dwjcxxb);
			
			entity = new Dwjffctzs();
			entity.setJcid(dwjcxxb.getId());
			entity = this.dwjffctzsDao.query(entity);
			if(entity == null){
				entity = new Dwjffctzs();
				SessionBean sessionBean = getSessionBean();
				entity.setWh(this.dwjfjfjctzService.getWhHead(sessionBean)+"公（技）责通字["+DateUtils.getSystemYearString()+"]"+this.dwjffctzsDao.queryXh()+"号");
				entity.setJcid(dwjcxxb.getId());
				entity.setDwid(dwjcxxb.getDwid());
				
				Dwjbxxb dw = new Dwjbxxb();
				dw.setId(dwjcxxb.getDwid());
				dw = this.dwjbxxbService.query(dw);
				if(dw != null){
					entity.setDwmc(dw.getDwmc());
				}
				entity.setDwmc(dw.getDwmc());
				
				Dwjfjfjctzs dwjfjfjctzs = new Dwjfjfjctzs();
				dwjfjfjctzs.setJcid(jcid);
				dwjfjfjctzs = this.dwjfjfjctzsDao.query(dwjfjfjctzs);
				entity.setJctzswh(dwjfjfjctzs.getWh());
			}
		}
		
		mv.addObject("entity", entity);
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("rwid", null);
		return mv;
	}
	
	@RequestMapping(value = "/addJffctzscg", method = RequestMethod.GET)
	public @ResponseBody ModelAndView addJffctzscg(String id,String mainTabID,String jcid) {
		ModelAndView mv = new ModelAndView("sydw/jffctzscgAdd");
		
		Dwjffctzscg entity = null;
		if(!StringUtils.isBlank(id)){
			entity = this.dwjffctzscgDao.queryEntityById(id);
		}else{
			
			Dwjcxxb dwjcxxb = new Dwjcxxb();
			dwjcxxb.setId(jcid);
			dwjcxxb = dwjcxxbService.query(dwjcxxb);
			
			entity = new Dwjffctzscg();
			entity.setJcid(dwjcxxb.getId());
			entity = this.dwjffctzscgDao.query(entity);
			if(entity == null){
				entity = new Dwjffctzscg();
				SessionBean sessionBean = getSessionBean();
				entity.setWh(this.dwjfjfjctzService.getWhHead(sessionBean)+"公（技）责通字["+DateUtils.getSystemYearString()+"]"+this.dwjffctzscgDao.queryXh()+"号");
				entity.setJcid(dwjcxxb.getId());
				entity.setDwid(dwjcxxb.getDwid());
				
				entity.setZzjgmc(sessionBean.getExtendValue("ssFsxName"));
				
				Dwjbxxb dw = new Dwjbxxb();
				dw.setId(dwjcxxb.getDwid());
				dw = this.dwjbxxbService.query(dw);
				if(dw != null){
					entity.setDwmc(dw.getDwmc());
				}
				entity.setDwmc(dw.getDwmc());
				
				Dwjffctzs dwjffctzs = new Dwjffctzs();
				dwjffctzs.setJcid(jcid);
				dwjffctzs = this.dwjffctzsDao.query(dwjffctzs);
				entity.setFcyjswh(dwjffctzs.getWh());
				entity.setFcsj(dwjffctzs.getFcrq());
				
				Dwjfzltzs dwjfzltzs = new Dwjfzltzs();
				dwjfzltzs.setJcid(jcid);
				dwjfzltzs = this.dwjfzltzsDao.query(dwjfzltzs);
				entity.setZltzswh(dwjfzltzs.getWh());
			}
		}
		
		mv.addObject("entity", entity);
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("rwid", null);
		return mv;
	}
	
	@RequestMapping(value = "/addJfzltzs", method = RequestMethod.GET)
	public @ResponseBody ModelAndView addJfzltzs(String mainTabID,String jcid) {
		
		ModelAndView mv = new ModelAndView("sydw/jfzltzsAdd");
		SessionBean sessionBean = getSessionBean();
		Dwjcxxb dwjcxxb =  new Dwjcxxb();
		dwjcxxb.setId(jcid);
		dwjcxxb = dwjcxxbService.query(dwjcxxb);
		
		Dwjfzltzs entity = new Dwjfzltzs();
		entity.setJcid(dwjcxxb.getId());
		entity.setDwid(dwjcxxb.getDwid());
		entity = this.dwjfzltzsDao.query(entity);
		
		if(entity == null){
			entity = new Dwjfzltzs();
			entity.setJcid(dwjcxxb.getId());
			entity.setDwid(dwjcxxb.getDwid());
			entity.setWh(this.dwjfjfjctzService.getWhHead(sessionBean)+"公（技）责通字["+DateUtils.getSystemYearString()+"]"+this.dwjfzltzsDao.queryXh()+"号");
			entity.setZzjgmc(sessionBean.getExtendValue("ssFsxName"));
			
			Dwjbxxb dw = new Dwjbxxb();
			dw.setId(dwjcxxb.getDwid());
			dw = this.dwjbxxbService.query(dw);
			if(dw != null){
				entity.setDwmc(dw.getDwmc());
			}
		}
		
		entity.setGzsjStrArray(this.dwjfjfjctzService.getGzsjStrArray(dwjcxxb.getJcsj()));
		
		mv.addObject("entity", entity);
		mv.addObject("mainTabID", mainTabID);
		mv.addObject("rwid", null);
		return mv;
	}
	
	@RequestMapping(value = "/saveJfzltzs", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveJfzltzs(Dwjfzltzs entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if (StringUtils.isBlank(entity.getId())) {
				this.dwjfjfjctzService.saveJfzltzs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "保存成功！");
			} else {
				this.dwjfjfjctzService.updateJfzltzs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改成功！");
			}
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
			
			//用户选择进入复查环节
			if(!StringUtils.isBlank(entity.getOperation())){
				//更新检查记录状态为：复查
				this.dwjcxxbService.updateZt(entity.getJcid(), "40", sessionBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveJffctzs", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveJffctzs(Dwjffctzs entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			if (StringUtils.isBlank(entity.getId())) {
				this.dwjfjfjctzService.saveJffctzs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "保存成功！");
			} else {
				this.dwjfjfjctzService.updateJffctzs(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改成功！");
			}
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	@RequestMapping(value = "/saveJffctzscg", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveJffctzscg(Dwjffctzscg entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			
			if (StringUtils.isBlank(entity.getId())) {
				this.dwjfjfjctzService.saveJffctzscg(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "保存成功！");
			} else {
				this.dwjfjfjctzService.updateJffctzscg(entity, sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, "修改成功！");
			}
			model.put(AppConst.SAVE_ID, entity.getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	private Dwjcxxb createInitJfDwjcxxbByDwid(String dwid,SessionBean sessionBean){
		Dwjbxxb dw = new Dwjbxxb();
		dw.setId(dwid);
		dw = this.dwjbxxbService.query(dw);
		
		Dwjcxxb dwjcxxb = new Dwjcxxb();
		dwjcxxb.setId(UUID.create());
		dwjcxxb.setZt("0");
		dwjcxxb.setYwlbdm("14");//技防的写死
		dwjcxxb.setDwid(dwid);
		//dwjcxxb.setDwmc(dw.getDwmc());
		dwjcxxb.setJjlxdm(dw.getJjlxdm());
		
		dwjcxxb.setDz_dwdzdm(dw.getDz_dwdzdm());
		dwjcxxb.setDz_dwdzssxdm(dw.getDz_dwdzssxdm());
		dwjcxxb.setDz_dwdzmlpdm(dw.getDz_dwdzmlpdm());
		dwjcxxb.setDz_dwdzmlpxz(dw.getDz_dwdzmlpxz());
		dwjcxxb.setDz_dwdzxz(dw.getDz_dwdzxz());
		
		dwjcxxb.setDwlbdm(dw.getDwlbdm());
		this.dwjcxxbService.save(dwjcxxb, sessionBean);
		return dwjcxxb;
	}
	
	@RequestMapping(value = "/addJfjfjctzscg", method = RequestMethod.GET)
	public @ResponseBody ModelAndView addJfjfjctzscg(String tzsid,String jcid, String mainTabID) {
		
		ModelAndView mv = new ModelAndView("sydw/jfjfjctzscgAdd");
		
		Dwjfjfjctzs dwjfjfjctzs = null;
		if(StringUtils.isBlank(tzsid)){
			dwjfjfjctzs = new Dwjfjfjctzs();
			dwjfjfjctzs.setJcid(jcid);
			dwjfjfjctzs = this.dwjfjfjctzsDao.query(dwjfjfjctzs);
		}else{
			dwjfjfjctzs = this.dwjfjfjctzsDao.queryEntityById(tzsid);
		}
		
		Dwjfjfjctzscg entity = new Dwjfjfjctzscg();
		entity.setJcid(dwjfjfjctzs.getJcid());
		entity = this.dwjfjfjctzscgDao.query(entity);
		
		if(entity == null){
			entity = new Dwjfjfjctzscg();
			entity.setTzid(tzsid);
			entity.setJcid(dwjfjfjctzs.getJcid());
			entity.setDwid(dwjfjfjctzs.getDwid());
			entity.setDwmc(dwjfjfjctzs.getDwmc());
			entity.setWh(dwjfjfjctzs.getWh());
			SessionBean sessionBean = getSessionBean();
			entity.setJbr(sessionBean.getUserName());
			entity.setTfr(sessionBean.getUserName());
			entity.setZzjgid(sessionBean.getExtendValue("ssFsxCode"));
			entity.setZzjgmc(sessionBean.getExtendValue("ssFsxName"));
		}

		mv.addObject("entity", entity);
		mv.addObject("mainTabID", mainTabID);
		return mv;
	}
	
}
