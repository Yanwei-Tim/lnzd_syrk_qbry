package com.founder.zdrygl.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.StringUtils;
import com.founder.service.provinceservice.bean.ServiceLkxxBean;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.zdrygl.bean.ZdryCarTrail;
import com.founder.zdrygl.bean.ZdryTrailJkxxb;
import com.founder.zdrygl.service.ZdryCarTrailService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "zdryCarTrail")
public class ZdryCarTrailController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zdryCarTrailService")
	private ZdryCarTrailService zdryCarTrailService;

	/**
	 * 
	 * @Title: add
	 * @Description: TODO(重点人员车辆轨迹监管跳转页面)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(String id, String flag) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryCarTrail");
		if ("0".equals(flag)) {
			mv = new ModelAndView("zdrygl/edit/zdryCarTrailCalcel");
		}
		ZdryCarTrail entity = new ZdryCarTrail();
		entity.setZdryid(id);
		mv.addObject("entity", entity);
		return mv;
	}
	
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(重点人员车辆轨迹监管开启、关闭监管功能)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(ZdryTrailJkxxb entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			String lxdh = entity.getLxdh();
			if (StringUtils.isBlank(lxdh)) {
				map.put(AppConst.STATUS, AppConst.FAIL);
				map.put(AppConst.MESSAGES, getAddFail());
				mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
				return mv; 
			}
			zdryCarTrailService.save(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
			map.put(AppConst.SAVE_ID, "" + entity.getId()); // 返回主键
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
	
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(重点人员车辆轨迹保存请求)
	 * @param @param entity
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RestfulAnnotation(valiField = "sfzh, lkdjrzsj, qydzxz, userId", serverId = "3")
	@RequestMapping(value = "/saveTrail", method = RequestMethod.POST)
	public @ResponseBody ModelAndView saveTrail(ServiceLkxxBean entity, SessionBean sessionBean) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> map = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			entity.setTrailtype("car");
			zdryCarTrailService.saveTrail(entity, sessionBean);
			map.put(AppConst.STATUS, AppConst.SUCCESS);
			map.put(AppConst.MESSAGES, getAddSuccess());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			map.put(AppConst.STATUS, AppConst.FAIL);
			map.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(map));
		return mv;
	}
					
}
