package com.founder.zdrygl.base.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryQbxxb;
import com.founder.zdrygl.base.service.ZdryQbxxbService;
@Controller
@RequestMapping("/qbryManager")
public class qbryController extends BaseController {
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "zdryQbxxbService")
	private ZdryQbxxbService zdryQbxxbService;
	
	@RequestMapping(value = "/qbryManager", method = RequestMethod.GET)
	public ModelAndView qbryManager() throws BussinessException {
			ModelAndView mv = new ModelAndView("qbry/manager/qbryManage");		
			return mv;
		
	}
	
	@RequestMapping(value = "/qbryQuery", method = RequestMethod.GET)
	public ModelAndView qbryQuery() throws BussinessException {
			ModelAndView mv = new ModelAndView("qbry/query/qbryQuery");		
			return mv;
		
	}
	
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,@RequestParam(value = "rows", required = false) Integer rows,ZdryQbxxb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		
//		if (null != sessionBean&&StringUtils.isBlank(entity.getIsCheck())){
//			OrgOrganization userOrg = orgOrganizationService.queryById(sessionBean.getUserOrgId());
//			String orglevel = userOrg.getOrglevel();
//			if (("21").equals(orglevel)) {
//				entity.setGxfjdm((String) sessionBean.getUserOrgCode());
//			} else if ("32".equals(orglevel)) {
//				entity.setGxpcsdm((String) sessionBean.getUserOrgCode());
//			} else if ("50".equals(orglevel)) {
//				entity.setGxzrqdm((String) sessionBean.getUserOrgCode());
//			}
//		}else{
////			entity.setGxpcsdm(sessionBean.getExtendValue("ssPcsCode"));
//		}
		
		
		return zdryQbxxbService.queryList(entity, page);
	}

}
