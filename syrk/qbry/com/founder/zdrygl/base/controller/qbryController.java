package com.founder.zdrygl.base.controller;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.base.model.ZdryQbxxb;
import com.founder.zdrygl.base.model.ZdryQbywb;
import com.founder.zdrygl.base.service.ZdryQbxxbService;
import com.founder.zdrygl.base.service.ZdryQbywbService;
import com.founder.zdrygl.core.utils.ZdryQbDict;
import com.google.gson.Gson;
@Controller
@RequestMapping("/qbryManager")
public class qbryController extends BaseController {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "zdryQbxxbService")
	private ZdryQbxxbService zdryQbxxbService;
	
	@Resource(name = "zdryQbywbService")
	private ZdryQbywbService zdryQbywbService;
	
	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService  syrkSyrkxxzbService; 
	
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
	
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public @ResponseBody
	EasyUIPage queryList(EasyUIPage page,@RequestParam(value = "rows", required = false) Integer rows,ZdryQbxxb entity, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return zdryQbxxbService.queryList(entity, page);
	}
	
	@RequestMapping(value = "/qbryadd")
	public  ModelAndView gotoqbryadd(){			
		ModelAndView mv = new ModelAndView("qbry/getqbry/qbryGet");		
		return mv;
	}
/**
 * 
 * @Title: qbryget
 * @Description: TODO(验证信息,新增人口)
 *
 * @param @return    设定文件
 * @return ModelAndView    返回类型
 * @throws
 */
	@RequestMapping(value ="/qbryget", method = RequestMethod.POST)
	public ModelAndView qbryget(ZdryQbxxb qbzdrymsg,SessionBean sessionBean){
		 /*验证字段
		  *调用别的service验证：
		  * 1.情报人员在实有人口表里是否已存在
		  * 自己的service里完成验证功能：
		  * 1.身份证号是否存在以及各式是否正确（18位）	  
		  * 2.管理状态（默认为待接收、还未设置）调用字典
		  */		
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));		
		 sessionBean = getSessionBean(sessionBean); 		          
		 SyrkSyrkxxzb entity=new  SyrkSyrkxxzb();
		  //ZJHM(证件号码)【默认身份证】、
		 //可增加查询条件字段： JZD_DZID（居住地详细地址）、 CYZJDM（证件种类）
		   entity.setZjhm(qbzdrymsg.getGmsfhm());		          		        		          
		   if(validationqbryexitbygmsfhm( entity)!=null){				 	    			   					  			  
	        	try{			        		     
	        		   qbzdrymsg.setSyrkid(validationqbryexitbygmsfhm( entity));
					   zdryQbxxbService.save(qbzdrymsg,sessionBean);
					   System.out.println("保存成功！");					
					   mv = new ModelAndView("qbry/manager/qbryManage");					 
				 }catch(Exception e){
					   logger.error(e.getLocalizedMessage(), e);							   
					   System.out.println("保存失败!");							   							  
			       }			   
		     } 	
		    else{		    	
		        	try{											  			   
						   zdryQbxxbService.save(qbzdrymsg,sessionBean);
						   System.out.println("保存成功！");					
						   mv = new ModelAndView("qbry/manager/qbryManage");					 
					 }catch(Exception e){
						   logger.error(e.getLocalizedMessage(), e);							   
						    System.out.println("保存失败!");							   							  
				       }		        			        			         	    	 		    		 					    					
		         }			  
	return mv;
	}
	
	/**
	 * 
	 * @Title: validationqbryexitbygmsfhm
	 * @Description: TODO(情报人员（根据查询条件：【默认省份证】）是否存在于实有人口总表，有返回)
	 * @param @param syrkid
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */ 	
	public String  validationqbryexitbygmsfhm( SyrkSyrkxxzb entity){
		
	
		   try{
			   return syrkSyrkxxzbService.querySyrkxxzb(entity).getId();   
		   }catch(Exception e){
			   
			   return null;  		  
		   }
		
	}
	
	
	/**
	 * 
	 * @Title: ywList
	 * @Description: 根据身份证号查询业务操作记录
	 * @param @param gmsfhm
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/ywList/{gmsfhm}", method = RequestMethod.POST)
	public @ResponseBody 
		EasyUIPage ywList(EasyUIPage page,@PathVariable(value = "gmsfhm") String gmsfhm, SessionBean sessionBean){
			return zdryQbywbService.queryListByZjhm(gmsfhm,page);
	}		
	/**
	 * 
	 * @Title: view
	 * @Description: 跳转情报人员编辑页面
	 * @param @param qbryid
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/{ryid}/view", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable(value = "ryid") String qbryid){
			ModelAndView mv = new ModelAndView("qbry/manager/qbryEdit");
			ZdryQbxxb qbxxb = zdryQbxxbService.queryById(qbryid);
			mv.addObject("qbry",qbxxb);
			return mv;
	}	
	/**
	 * 
	 * @Title: saveLg
	 * @Description: TODO(情报人员接收，列管)
	 * @param @param id 情报人员ID
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/saveLg", method = RequestMethod.POST)
	public ModelAndView saveLg(String id,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));		
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			
			ZdryQbxxb entity = zdryQbxxbService.queryById(id);//查询情报人员信息
			if(entity==null){
				throw new RuntimeException("未查询到该情报人员信息！");
			}
			
			zdryQbxxbService.saveLg(entity,sessionBean);
			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getAddSuccess());
		} catch (BussinessException e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}

		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;

	}
}