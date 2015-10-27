package com.founder.zdrygl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;
import com.founder.zdrygl.service.ZdryQbzdryxxbUpService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/zdryQbzdryxxbUp")
public class ZdryQbzdryxxbUpController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private ZdryQbzdryxxbUpService zdryQbzdryxxbUpService;

	
	/***
	 * @Title: updateQb
	 * @Description: TODO(管辖权变更申请)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateQb", method = RequestMethod.POST)
	public ModelAndView updateQb(ZdryQbzdryYwczb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			zdryQbzdryxxbUpService.updateQbBg(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "【申请管辖权变更】成功！");
			model.put(AppConst.SAVE_ID, entity.getId()); 
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/***
	 * 
	 * @Title: updateCxQb
	 * @Description: TODO(撤回管辖权变更申请操作)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/updateCxQb", method = RequestMethod.POST)
	public ModelAndView updateCxQb(ZdryQbzdryYwczb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			zdryQbzdryxxbUpService.updateCxQbBg(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "【撤回管辖权变更申请】成功！");
			model.put(AppConst.SAVE_ID, entity.getId()); 
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
}
