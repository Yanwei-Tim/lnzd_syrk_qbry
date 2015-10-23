package com.founder.zdrygl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryQbZdryxxb;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;
import com.founder.zdrygl.service.ZdryQbzdryxxbService;

@Controller
@RequestMapping("/zdryQbzdryxxb")
public class ZdryQbzdryxxbController extends BaseController {

	
	@Resource
	private ZdryQbzdryxxbService zdryQbzdryxxbService;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;	
	
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
	
	
	
	/**
	 * 
	 * @Title: operation
	 * @Description: 根据重点人员id 查询操作记录
	 * @param @param zdryid
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
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
	
	/**
	 * 
	 * @Title: deliver
	 * @Description: 情报重点人员下发
	 * @param @param zdryid，下发组织部门，下发说明
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deliver", method = RequestMethod.POST)
	public @ResponseBody
	String deliver(String zdryid,String xfczyj,String orgcode) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("zdryid", zdryid);
		param.put("xfczyj", xfczyj);
		param.put("orgcode", orgcode);
		String userType = getSessionBean().getUserOrgLevel();
		String noworgcode = getSessionBean().getUserOrgCode();
		//查看本用户是否有操作记录
	    //int NUM = zdryQbzdryxxbService.queryBenOperation(param);
		//不是责任区民警
		if(!userType.equals("50")){
			// 查询状态
		 if(userType.equals("20")){
			 //当前用户为市局,更新信息表的派出所代码，插入操作
			//boolean Updatexx = zdryQbzdryxxbService.Updatexx(param);
			 
		 }
		 if(userType.equals("32")){
			 
		 }
			
		}
		return null;
	}
	
}
