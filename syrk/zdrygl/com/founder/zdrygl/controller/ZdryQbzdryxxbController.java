package com.founder.zdrygl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryQbZdryxxb;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;
import com.founder.zdrygl.service.ZdryQbzdryxxbService;

@Controller
@RequestMapping("/zdryQbzdryxxb")
public class ZdryQbzdryxxbController extends BaseController {

	
	@Resource
	private ZdryQbzdryxxbService zdryQbzdryxxbService;
		
	
	@RequestMapping(value="/qbzdryManage",method = RequestMethod.GET)
	public String shbManage(){
		return "zdrygl/qbzdryList";
	}
	
	
	@RestfulAnnotation(serverId = "3")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			ZdryQbZdryxxb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		//entity.setGxzrqdm(sessionBean.getUserOrgCode());
		return this.zdryQbzdryxxbService.queryList(entity, page,sessionBean);
	}
	
	
	
	
	@RequestMapping(value = "/operation", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage operation(EasyUIPage page,
			@RequestParam(value = "rows", required = false) Integer rows,
			ZdryQbzdryYwczb entity, String zdryid) {
		page.setPagePara(rows);
		Map<String, String> param = new HashMap<String, String>();
		param.put("zdryid", zdryid);
		//entity.setGxzrqdm(sessionBean.getUserOrgCode());
		return this.zdryQbzdryxxbService.queryOperation(entity, page,param);
	}
	

	
}
