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
	@RequestMapping(value = "/qbryget", method = RequestMethod.POST)
	public ModelAndView qbryget(ZdryQbxxb qbzdrymsg){
		//验证字段、
		 /**
		  * 1.实有人口是否存在？
		  * 2.管辖部门是否包含？
		  * 3.立案部门是否包含？
		  * 4.管理状态？（默认为待接收、、还未设置）
		  * 5.
		  * */
		//验证分两个步骤：一个是填写的东西是否包含有，一个是信息是否正确（）？
		  // String  gmsfhm =  qbzdrymsg.getGmsfhm();
		  // String  xm= qbzdrymsg.getXm();
		 //  String id= qbzdrymsg.getId();
		 //核实人口是否存在，不存在则添加信息
/*		if(validationqbrybygmfhm( id,gmsfhm, xm)){			
			//存在			 
		 }
		 else{
		 //不存在,就添加
			 try{
				 zdryQbxxbService.save(qbzdrymsg);				 
			 }catch(Exception e){
				 e.printStackTrace();
			 }
			
		   } */
	
		 System.out.println("部级重点人员编号:"+qbzdrymsg.getBjzdrybh());
		 //不做验证直接存（目前）
		 ModelAndView mv;
		   try{
			   zdryQbxxbService.save(qbzdrymsg);
			   System.out.println("保存成功！");
				 mv = new ModelAndView("qbry/manager/qbryManage");
				 //具体化
		   }catch(Exception e){
			   e.printStackTrace();
			   System.out.println("保存失败！"); 
				 mv = new ModelAndView("qbry/getqbry/qbryGet");
		   }		       										
		return mv;
	}
	
	/**
	 * @Description: TODO(验证是否存在该实有人口)
	 * */
	public boolean  validationqbrybygmfhm(String id ,String gmsfhm,String xm){
		
/*		    boolean  cz=false;		
		    ZdryQbxxb  realmsg =  zdryQbxxbService.queryById(id);		    		    
		if(realmsg!=null){		
			return true;			
		}else{
			return false;		
		}	*/	
		return false;	
	}
	
}
