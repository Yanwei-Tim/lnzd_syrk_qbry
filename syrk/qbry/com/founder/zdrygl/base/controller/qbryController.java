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
	public ModelAndView qbryget(ZdryQbxxb qbzdrymsg){
		 /*验证字段
		  * 1.身份证号是否存在以及各式是否正确（18位）
		  * 2.情报人员是否已存在
		  * 2.管辖单位是否存在
		  * 3.立案单位是否存在
		  * 4.管理状态（默认为待接收、还未设置）调用字典
		  */	
/*		   System.out.println("保存成功！");	
			try{								  			   
				   zdryQbxxbService.save(qbzdrymsg);
				   System.out.println("保存成功！");					
		   ModelAndView	   mv = new ModelAndView("qbry/manager/qbryManage");
			return mv;
			   }catch(Exception e){
				   logger.error(e.getLocalizedMessage(), e);							   
				   System.out.println("保存失败");
	     ModelAndView	  mv=new ModelAndView("qbry/getqbry/qbryGet");
	  	return mv;
			    }	*/
			
		  ModelAndView mv =new ModelAndView("qbry/getqbry/qbryGet");;
           String  gmsfhm = qbzdrymsg.getGmsfhm();
		   String  xm= qbzdrymsg.getXm();	
		   String  gxdwmc=qbzdrymsg.getGxdwmc();
		   String  ladwmc=qbzdrymsg.getLadwmc();
		   String  glzt=qbzdrymsg.getGlzt();
		   qbzdrymsg.setXt_zxbz("0");
		 //验证身份号码
		if(validationqbrygmsfhm(gmsfhm)){						
			//验证情报人员是否已存在
		   if(validationqbryexitbygmsfhm(gmsfhm, xm)){				 
				String erromsg="该人员已经存在！";			    			   					  			  
				throw new RuntimeException(erromsg);
		     } 	
		    else{
		    	//不存在 ，就验证管辖单位 			
		        if(validationqbrygxdw(gxdwmc)){
		        	//存在，就验证立案单位 
		          if(validationqbryladw(ladwmc)){
		            //存在，就验证管理状态		
		        	if(valiodationqbryglzt(glzt)){
                       //待下发状态，才开始新增情报人员信息
		        		try{				
							  			   
							   zdryQbxxbService.save(qbzdrymsg);
							   System.out.println("保存成功！");					
							   mv = new ModelAndView("qbry/manager/qbryManage");					 
						   }catch(Exception e){
							   logger.error(e.getLocalizedMessage(), e);							   
							   System.out.println("保存失败!");
							   							  
						    }		        		
		        	 }else{
		        		 //管理状态不是带下发状态
		        		      String erromsg="管理状态不是带下发状态";			
		        		      throw new RuntimeException(erromsg);
		        	  }		        			        		
		        	 }else{
			        	//立案单位不存在
			        	String erromsg="立案单位不能为空";			
			        	throw new RuntimeException(erromsg);
			         }		        	
		         }else{
		        	//管辖单位不存在
		        	String erromsg="管辖单位不能为空";			
		        	throw new RuntimeException(erromsg);
		        }		    	 		    		 					    					
		    }	
		}
		else{			
			//公民身份证号码各式不正确
			String erromsg="公民身份证号码格式不正确或者为空";			
			throw new RuntimeException(erromsg);
		}	
		
	return mv;
	}
	
	/**
	 * @Description: TODO(验证是否已存在该情报人员)
	 * */
	public boolean  validationqbryexitbygmsfhm(String gmsfhm,String xm){
		
/*	    boolean  cz=false;		
		   ZdryQbxxb  realmsg =  zdryQbxxbService.queryById(gmsfhm);		    		    
		if(realmsg==null){		
			return true;			
		}else{
			return false;		
		}	*/
		
		return false;	
	}
   /**
    * 
    * @Title: validationqbrygxdw
    * @Description: TODO(验证管辖单位)
    * @param @return    设定文件
    * @return boolean    返回类型
    * @throws
    */
	public boolean validationqbrygxdw( String  gxdwmc ){		
      if(gxdwmc!=null){   	  
    	  return true;	 
      }else{
    	  return false;	
      }				
	}	
	/**
	 * 
	 * @Title: validationqbrygmsfhm
	 * @Description: TODO(验证身份证号码)
	 * @param @param gmsfhm
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public boolean validationqbrygmsfhm(String gmsfhm){		
		if(gmsfhm.length()==18){
			return true;	
		}		
		else{
			return false;	
		}	
	}	
	/**
	 * 
	 * @Title: validationqbryladw
	 * @Description: TODO(验证立案单位)
	 * @param @param ladwmc
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public boolean validationqbryladw(String  ladwmc){
		
		if(ladwmc!=null){
			return true;	
		}		
		else{
			return false;	
		}
	}
	/**
	 * 
	 * @Title: valiodationqbryglzt
	 * @Description: TODO(验证管理状态)
	 * @param @param glzt
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	public boolean valiodationqbryglzt(String glzt){
		if( ZdryQbDict.GLZT_DXF.equals(glzt)){
			return true;	
		}		
		else{
			return false;	
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
