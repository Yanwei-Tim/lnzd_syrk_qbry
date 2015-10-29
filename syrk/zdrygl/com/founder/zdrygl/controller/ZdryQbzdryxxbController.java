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
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.zdrygl.bean.ZdryQbZdryxxb;
import com.founder.zdrygl.bean.ZdryQbzdryYwczb;
import com.founder.zdrygl.bean.ZdryZdryzb;
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
		EasyUIPage pages= this.zdryQbzdryxxbService.queryList(entity, page,sessionBean);
		String userType = getSessionBean().getUserOrgLevel();
		if(userType.equals("50")){
			List<?> list=pages.getRows();
			Map<String, String> param = new HashMap<String, String>();
			boolean b = false;
			for(int i=0;i<list.size();i++){
				ZdryQbZdryxxb zdryxxb = (ZdryQbZdryxxb) list.get(i);
				param.put("shjh", zdryxxb.getSfzh());
				param.put("orgcode", getSessionBean().getUserOrgCode());
				b = zdryQbzdryxxbService.querySyrk(param);
				if(b){
					zdryxxb.setSfsyrk("0");
				}else{
					zdryxxb.setSfsyrk("1");
				}
				
			}	
		}
		return pages;
		
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
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/deliver", method = RequestMethod.POST)
	public @ResponseBody
	String deliver(String zdryid,String xfczyj,String orgcode,String orgcodetext,ZdryQbZdryxxb entity,ZdryQbzdryYwczb entityyw ) {
		Map<String, String> param = new HashMap<String, String>();
		String SUCCESS = "0";
		String userType = getSessionBean().getUserOrgLevel();
		String noworgcode = getSessionBean().getUserOrgCode();
		String userName = getSessionBean().getUserName();
		String orgName = getSessionBean().getUserOrgName();
		String userid = getSessionBean().getUserId();
		param.put("userid", userid);
		param.put("userName", userName);
		param.put("zdryid", zdryid);
		param.put("xfczyj", xfczyj);
		param.put("noworgcode", noworgcode);
		param.put("orgName", orgName);
		param.put("orgcode", orgcode);
		param.put("userType", userType);
		System.out.println(userType);
		//查看本用户是否有操作记录
	    //int NUM = zdryQbzdryxxbService.queryBenOperation(param);
		//不是责任区民警
		if(!userType.equals("50")){
			// 查询状态
		 if(userType.equals("20")){
			 //当前用户为市局,分县局更新信息表的派出所代码，插入操作
			entity.setZdryid(zdryid);
			entity.setGxdwjgdm(orgcode);
			entity.setGxdw(orgcodetext);
			//entity.setSjbmdm(noworgcode);
			entity.setPcsbmdm(orgcode);
			boolean Updatexx = zdryQbzdryxxbService.Updatexx(entity);
			if(Updatexx){
				this.zdryQbzdryxxbService.saveZdryqbxxyw(entityyw,param);
				this.zdryQbzdryxxbService.acceptZdryqbxxyw(entityyw,param);
			
			}
			
			 
		 }
		 if(userType.equals("32")){
			 entity.setZdryid(zdryid);
				entity.setGxdwjgdm(orgcode);
				entity.setGxdw(orgcodetext);
				entity.setZrqbmdm(orgcode);
				boolean Updatexx = zdryQbzdryxxbService.Updatexx(entity);
				if(Updatexx){
					//本业务下发
					this.zdryQbzdryxxbService.saveZdryqbxxyw(entityyw,param);
					//下级接受
					this.zdryQbzdryxxbService.acceptZdryqbxxyw(entityyw,param);
				}
			 
		 }
			
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @Title: accept
	 * @Description: 情报重点人员责任民警接收
	 * @param @param zdryid，shjh情报重点人员id，身份证
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public @ResponseBody
	String accept(String zdryid,String shjh,String zdrylb,ZdryQbzdryYwczb entityyw,ZdryZdryzb zdryzdryzb) {
		String SUCCESS = "0";
		String FIAL = "1";
		Map<String, String> param = new HashMap<String, String>();
		String orgcode = getSessionBean().getUserOrgCode();
		String userName = getSessionBean().getUserName();
		String orgName = getSessionBean().getUserOrgName();
		String userid = getSessionBean().getUserId();
		String userType = getSessionBean().getUserOrgLevel();
		param.put("userType", userType);
		param.put("zdrylb", zdrylb);
		param.put("userid", userid);
		param.put("shjh", shjh);
		param.put("zdryid", zdryid);
		param.put("orgcode", orgcode);
		param.put("userName", userName);
		param.put("zdryid", zdryid);
		param.put("xfczyj", "");
		param.put("noworgcode", orgcode);
		param.put("orgName", orgName);
		try {
			//根据身份证查询实有人口综表的信息
			SyrkSyrkxxzb syrkSyrkxxb = this.zdryQbzdryxxbService.querySyrkxxzb(param);
			//插入重点人员信息总表列管
			this.zdryQbzdryxxbService.InsertZdryzdryzb(syrkSyrkxxb,zdryzdryzb,param);
		} catch (Exception e) {
			return FIAL;
		}
		this.zdryQbzdryxxbService.saveZdryqbxxyw(entityyw,param);
		
		return SUCCESS;
	}
	
	
}
