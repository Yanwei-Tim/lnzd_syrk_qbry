package com.founder.framework.newmain.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.organization.right.service.OrgRightPublic;
@Controller
@RequestMapping("/newmain")
public class newmain extends BaseController {
	/**
	 * 系统主页导航
	 * @return
	 */
	@RequestMapping(value = "/getaccord", method = RequestMethod.GET)
	public ModelAndView addOrEditjhyxswjbxxb(){
		ModelAndView mv = new ModelAndView("newmain/main_lefttest");
		SessionBean sessionBean = getSessionBean();
		String userid = sessionBean.getUserId();
		OrgRightPublic orgRightPublic = new OrgRightPublic();
		Object json = orgRightPublic.getUserMenuJson(userid,"dhxt",false);
		mv.addObject("jsondata",json);
		return mv;
	}
	/**
	 * 标准地址导航
	 * @return
	 */
	@RequestMapping(value = "/getaccord_bzdz", method = RequestMethod.GET)
	public ModelAndView getaccord_bzdz(){
		ModelAndView mv = new ModelAndView("main/bzdz/main_lefttest");
		SessionBean sessionBean = getSessionBean();
		String userid = sessionBean.getUserId();
		OrgRightPublic orgRightPublic = new OrgRightPublic();
		Object json = orgRightPublic.getUserMenuJson(userid,"dhxt",false);
		mv.addObject("jsondata",json);
		return mv;
	}
}