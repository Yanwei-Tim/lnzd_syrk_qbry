package com.founder.zdrygl.controller;

import javax.annotation.Resource;

import com.founder.framework.utils.EasyUIPage;
import org.apache.commons.beanutils.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.utils.DateUtils;

import com.founder.zdrygl.service.ZdryZdrykcxxbService;
import com.founder.zdrygl.vo.ZdryZdrykcxxbVO;
import com.founder.zdrygl.bean.ZdryZdrykcxxb;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryZdrykcxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-03 03:47:25
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-03 03:47:25，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@Controller
@RequestMapping("/zdryZdrykcxxb")
public class ZdryZdrykcxxbController extends BaseController{
   	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private ZdryZdrykcxxbService zdryZdrykcxxbService;



	/**
	 *
	 * @Title: add
	 * @Description: 跳转添加页面
	 * @param @param zdryid
	 * @param @return
	 * @param @throws BussinessException 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String zdryid) throws BussinessException {
		ModelAndView mv = new ModelAndView("/zdrygl/edit/zdryZdrykcxxb");
		SessionBean sessionBean = getSessionBean();
		ZdryZdrykcxxb entity = new ZdryZdrykcxxb();
		entity.setZdryid(zdryid);
		entity.setKcmjid(sessionBean.getUserId());
		entity.setKcmjxm(sessionBean.getUserName());
		mv.addObject("entity", entity);
		return mv;
	}

	/***
	 *
	 * @Title: saveZd
	 * @Description: TODO重点人员转递保存逻辑
	 * @param @param zdryLczywblb
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryZdrykcxxb entity,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try{
			zdryZdrykcxxbService.save(entity,sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
			map.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/***
	 *
	 * @Title: saveZd
	 * @Description: TODO重点人员转递保存逻辑
	 * @param @param zdryLczywblb
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(ZdryZdrykcxxb entity,SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryZdrykcxxbService.update(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getUpdateSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}

	/** 编辑 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(@RequestParam String id) throws Exception {
		ModelAndView mv = new ModelAndView("/zdrygl/edit/zdryZdrykcxxb");
		ZdryZdrykcxxb zdryZdrykcxxb = (ZdryZdrykcxxb)zdryZdrykcxxbService.queryById(id);
		mv.addObject("entity",zdryZdrykcxxb);
		return mv;
	}

	
	/** 删除 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView delete(String url,String id) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		ZdryZdrykcxxb entity =new ZdryZdrykcxxb();
		entity.setId(id);
		zdryZdrykcxxbService.delete(entity,sessionBean);
		model.put(AppConst.STATUS, AppConst.SUCCESS);
		model.put(AppConst.MESSAGES, "注销成功！");
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}


	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public  EasyUIPage queryList(EasyUIPage page,@RequestParam(value = "rows", required = false) Integer rows,	ZdryZdrykcxxbVO vo, SessionBean sessionBean) {
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		//entity.setGxzrqdm(sessionBean.getUserOrgCode());
		EasyUIPage pages= zdryZdrykcxxbService.queryList(page,vo);
		List<?> list=pages.getRows();
		return pages;
	}
	
}

