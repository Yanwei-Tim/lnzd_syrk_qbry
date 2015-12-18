package com.founder.zdrygl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.zdrygl.bean.ZdryDtjsXsxxb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.service.ZdryDtjsService;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.google.gson.Gson;
@Controller
@RequestMapping("dtjsMore")
public class ZdryDtjsXsMoreController extends BaseController {
	@Resource(name = "zdryDtjsService")
	private ZdryDtjsService zdryDtjsService;
	@Resource
	private ZdryZdryzbService zdryZdryzbService;
	@Resource
	private RyRyjbxxbService ryRyjbxxbService;
	
	@RequestMapping(value = "/dtjsMorePage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView dtjsMorePage(String zdryid,String mode) {
		ModelAndView mv = new ModelAndView("zdrygl/dtjsMore");
		Map<String, Object> model = new HashMap<String, Object>();
	    ZdryZdryzb zb=this.zdryZdryzbService.queryById(zdryid);
	    RyRyjbxxb ryjbxxb=this.ryRyjbxxbService.queryById(zb.getRyid());
		mv.addObject("zdryZjhm",ryjbxxb.getZjhm());
		mv.addObject("zdryid",zb.getId());
		mv.addObject("mode",mode);
		return mv;
	}
	
	@RequestMapping(value = "/moreDtjsXsjbxx", method = RequestMethod.POST)	
	public @ResponseBody EasyUIPage queryDtjsZtxxList(EasyUIPage page,
			@RequestParam(value = "rows", required=false) Integer rows, 
			String zdryZjhm,
			SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		ZdryDtjsXsxxb entity=new ZdryDtjsXsxxb();
		entity.setZdry_zjhm(zdryZjhm);
		return zdryDtjsService.queryRyxsList(page, entity);
	}
	

	@RequestMapping(value = "/addDtjsXsjbxx", method = RequestMethod.GET)
	public ModelAndView addDtjsXsjbxx( String zdryZjhm,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsMoreXsjbxxAdd");		
			ZdryDtjsXsxxb entity=new ZdryDtjsXsxxb();
			entity.setZdry_zjhm(zdryZjhm);
			mv.addObject("entity", entity);
			return mv;
		
	}
	
	@RequestMapping(value = "/editDtjsXsjbxx", method = RequestMethod.GET)
	public ModelAndView editDtjsXsjbxx( String id,String type,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsMoreXsjbxxAdd");		
			ZdryDtjsXsxxb entity=this.zdryDtjsService.queryXsjbxxById(id);
			mv.addObject("entity", entity);
			mv.addObject("type", type);
			return mv;
		
	}
	
	@RequestMapping(value = "/deleteDtjsXsjbxx", method = RequestMethod.POST)
	public ModelAndView deleteDtjsXsjbxx(ZdryDtjsXsxxb entity,
			SessionBean sessionBean) throws BussinessException {
		    sessionBean = getSessionBean(sessionBean);
			ModelAndView mv = new ModelAndView("zdrygl/dtjsMoreXsjbxxAdd");		
			Map<String, Object> map = new HashMap<String, Object>();
		    try {
			    this.zdryDtjsService.deleteDtjsXsjbxx(entity, sessionBean);;
				map.put(AppConst.STATUS, AppConst.SUCCESS);
				map.put(AppConst.MESSAGES, getDeleteSuccess());
			} catch (Exception e) {
				e.printStackTrace();
				map.put(AppConst.STATUS, AppConst.FAIL);
				map.put(AppConst.MESSAGES, getDeleteFail());
			}
			mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		    
		    
			return mv;
		
	}
}
