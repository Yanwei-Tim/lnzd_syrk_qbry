package com.founder.zdrygl.controller;

import java.util.HashMap;
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
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.zdrygl.bean.ZdryQbZdryxxb;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;
import com.founder.zdrygl.service.ZdryQbzdryxxbService;
import com.founder.zdrygl.service.ZdryQbzdryxxbUpService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/zdryQbzdryxxbUp")
public class ZdryQbzdryxxbUpController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private ZdryQbzdryxxbUpService zdryQbzdryxxbUpService;
	@Resource
	private ZdryQbzdryxxbService zdryQbzdryxxbService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;	
	
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
	
	/**
	 * 
	 * @Title: deliver
	 * @Description: 情报重点人员重新下发
	 * @param @param zdryid，下发组织部门，下发说明
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/agdeliver", method = RequestMethod.POST)
	public @ResponseBody
	String deliver(String zdryid,String orgcode,String orgcodetext,String xjbmdm,ZdryQbZdryxxb entity,ZdryQbzdryYwczb entityyw ) {
		Map<String, String> param = new HashMap<String, String>();
		String SUCCESS = "0";
		String userType = getSessionBean().getUserOrgLevel();
		String noworgcode = getSessionBean().getUserOrgCode();
		String userName = getSessionBean().getUserName();
		String orgName = getSessionBean().getUserOrgName();
		param.put("userName", userName);
		param.put("zdryid", zdryid);
//		param.put("xfczyj", xfczyj);
		param.put("noworgcode", noworgcode);
		param.put("orgName", orgName);
		param.put("orgcode", orgcode);
		param.put("userType", userType);
		
		//查看本用户是否有操作记录
	    //int NUM = zdryQbzdryxxbService.queryBenOperation(param);
		//不是责任区民警
		if(!userType.equals("50")){
			// 查询状态
		 if(userType.equals("20")){
			 //当前userType为市 则把orgcode存到分县局中
			entity.setFxjbmdm(orgcode);
		 }else if(userType.equals("32")){
			 //当前userType为派出所 则把orgcode存到责任区中
			entity.setZrqbmdm(orgcode);
		 }
			entity.setZdryid(zdryid);
			entity.setGxdwjgdm(orgcode);
			entity.setGxdw(orgcodetext);
			//entity.setSjbmdm(noworgcode);
			boolean Updatexx = zdryQbzdryxxbService.Updatexx(entity);
			if(Updatexx){
				this.zdryQbzdryxxbService.saveZdryqbxxyw(entityyw,param);
				this.zdryQbzdryxxbService.acceptZdryqbxxyw(entityyw,param);
				
				//修改下级属性<sjsfjjbgsq 上级是否拒绝变更申请字段>为1 1表示下级提交变更申请之后，上级同意并且再次下发
				entityyw.setCzbmdm(xjbmdm);
				ZdryQbzdryYwczb entity_s = new ZdryQbzdryYwczb();
				//通过下级czbmdm、zdryid字段查找业务操作表中最新的一条记录并将 sjsfjjbgsq字段修改为1 目的是让原属下级不在有这条重口人员信息
				entity_s = zdryQbzdryxxbUpService.queryXjZx(entityyw);
				entity_s.setSjsfjjbgsq("1");
				zdryQbzdryxxbUpService.updateSj(entity_s);
			}
		}
		return SUCCESS;
	}
	
	
	/***
	 * 上级拒绝变更申请
	 * @Title: updateCxQb
	 * @Description: TODO(上级拒绝下级申请退回操作)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/jjbgsq", method = RequestMethod.POST)
	public ModelAndView jjbgsq(ZdryQbzdryYwczb entity){
		ModelAndView mv = new ModelAndView("redirect:/forward/"	+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			zdryQbzdryxxbUpService.updateJjBg(entity, sessionBean);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, "【拒绝管辖权变更申请】成功！");
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
