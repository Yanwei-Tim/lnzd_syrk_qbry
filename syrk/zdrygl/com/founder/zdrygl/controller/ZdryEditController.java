package com.founder.zdrygl.controller;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.service.ZdryEditService;
import com.founder.zdrygl.service.ZdrySgafzdryxxbService;
import com.founder.zdrygl.vo.ZdryVO;
import com.founder.zdrygl.vo.ZdrygnVO;
import com.founder.zdrygl.vo.ZdryxxzsVO;
import com.google.gson.Gson;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.controller.ZdryEditController.java]  
 * @ClassName:    [ZdryEditController]   
 * @Description:  [重点人员编辑页面控制器]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 上午9:37:09]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 上午9:37:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("zdryEdit")
public class ZdryEditController extends BaseController {
	
	@Resource(name="zdryEditService")
	private ZdryEditService zdryEditService;
	@Resource
	private ZdrySgafzdryxxbService zdrySgafzdryxxbService;
	@Autowired
	private JProcessDefinitionService processDefinitionService;

	/**
	 * 
	 * @Title: queryRyzsxx
	 * @Description: TODO(重点人口展示配置查询)
	 * @param @param zdrylxJson
	 * @param @return    设定文件
	 * @return List<ZdryxxzsVO>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryRyzsxx", method = RequestMethod.POST)
	public @ResponseBody List<ZdryxxzsVO> queryRyzsxx(@RequestParam(value="zdrylxJson")String zdrylxJson) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdrylxJson", zdrylxJson);
		return zdryEditService.queryRyzsxx(map);
	}
	
	
	/**
	 * 
	 * @Title: handleRequest
	 * @Description: TODO(重点人员 具体子类 的查询方法)
	 * @param @param methodName
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/service/{method}")
	public @ResponseBody
	Map<String, Object> handleRequest(
			@PathVariable(value = "method") String methodName) throws Exception {
		Map<String, Object> params = getParams(super.getRequest());
		params.put("sessionBean", getSessionBean());
		Map<String, Object> model = new HashMap<String, Object>();
		if (methodName != null) {
			methodName += "_query";
			try {
				model.put("entity", MethodUtils.invokeMethod(zdryEditService,
						methodName, params));
				// model.put("fields",
				// getFieldDesc(MethodUtils.getAccessibleMethod(syrkService.getClass(),
				// methodName , Map.class)));
			} catch (NoSuchMethodException e) {
			} catch (InvocationTargetException inv) {
				throw new Exception(inv.getTargetException().getCause()
						.getLocalizedMessage(), inv.getTargetException()
						.getCause());
			}
		}
		return model;
	}
	
	/**
	 * 
	 * @Title: queryYwglgn
	 * @Description: TODO(查询业务关联功能)
	 * @param @param zdrylxJson
	 * @param @param gnlxdm
	 * @param @return    设定文件
	 * @return List<ZdrygnVO>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/queryYwglgn", method = RequestMethod.POST)
	public @ResponseBody List<ZdrygnVO> queryYwglgn(String gnlxdm) {
		return zdryEditService.queryYwglgn(gnlxdm);
	}
	
	/**
	 * 
	 * @Title: delete_xxzsnrb
	 * @Description: TODO(下方菜单 删除功能请求)
	 * @param @param url
	 * @param @param id
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delete_xxzsnrb", method = RequestMethod.GET)
	public ModelAndView delete_xxzsnrb(String url, String id) {
		ModelAndView mv = new ModelAndView("zdrygl/edit/zdryDeleteEdit");
		mv.addObject("url", url);
		mv.addObject("id", id);
		return mv;
	}		
	
	
	/**
	 * 
	 * @Title: zdryUpdatePre
	 * @Description: TODO(重点人员编辑更新初始页)
	 * @param @param zdryid
	 * @param @param sessionBean
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryUpdatePre", method = RequestMethod.GET)
	public ModelAndView zdryUpdatePre( String zdryid,
			SessionBean sessionBean) throws BussinessException {
			ModelAndView mv = new ModelAndView("zdrygl/edit/zdryUpdate");
			ZdryVO zdryVO =zdryEditService.queryZdryAllInfo(zdryid);
			mv.addObject("zdryVO", zdryVO);
			return mv;
	}
	
	@RequestMapping(value = "/zdryUpdate", method = RequestMethod.POST)
	public ModelAndView zdryUpdate(ZdryVO zdryVO, SessionBean sessionBean,@RequestParam(value="uploadFile") CommonsMultipartFile[] uploadFile) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryEditService.updateZdryAllInfo(zdryVO,sessionBean,uploadFile);
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		}catch(BussinessException e){
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		catch (Exception e) {
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	
	/**
	 * 
	 * @Title: zdryZLPre
	 * @Description: TODO(重点人员转类 载入页面)
	 * @param @param zdryid
	 * @param @param sessionBean
	 * @param @return
	 * @param @throws BussinessException    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryZLPre", method = RequestMethod.GET)
	public ModelAndView zdryZLPre( String id,
			SessionBean sessionBean) throws BussinessException {
			ModelAndView mv = new ModelAndView("zdrygl/edit/zdryZL");
			ZdryVO zdryVO =zdryEditService.queryZdryAllInfo(id);			
			String glzt=zdryVO.getZdryZdryzb().getGlzt();
			boolean sfkzl=false;
			if(!"7".equals(glzt))//不是 转类申请中，查询是否可转类
				sfkzl=zdryEditService.queryIsZL(zdryVO.getZdryZdryzb().getZdrygllxdm());//是否可转类
			
			mv.addObject("glzt",glzt);
			mv.addObject("sfkzl",sfkzl);
			mv.addObject("zdryVO", zdryVO);
			return mv;
	}
	
	/**
	 * 
	 * @Title: zdryZL
	 * @Description: TODO(重点人员转类)
	 * @param @param zdryVO
	 * @param @param sessionBean
	 * @param @param uploadFile
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/zdryZL", method = RequestMethod.POST)
	public ModelAndView zdryZL(ZdryVO zdryVO, SessionBean sessionBean,String xzdrylbmc) {
		ModelAndView mv = new ModelAndView(getViewName(sessionBean));
		Map<String, Object> model = new HashMap<String, Object>();
		sessionBean = getSessionBean(sessionBean);
		try {
			zdryVO.getZdryZdryzb().setGlzt("7");//转类申请中
			String zdrylb=zdryVO.getZdryZdryzb().getZdrylb();
			zdryVO.getZdryZdryzb().setZdrylb(null);//此时不修改小类，审批通过后修改
			zdryEditService.zdryZl(zdryVO,sessionBean);
			zdryVO.getZdryZdryzb().setZdrylb(zdrylb);//后续流程取用
			
			Map<String, Object> variables =  new HashMap<String, Object>();
			String  lrrzrq= sessionBean.getUserOrgCode();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createTime=formatter.format(new Date());//申请时间
			variables.put("createTime", createTime);
			variables.put("lrrzrq", lrrzrq);//录入人管辖责任区
	 		variables.put("zdryId", zdryVO.getZdryZdryzb().getId()); //重点人员总表Id
			variables.put("zdrylx", zdryVO.getZdryZdryzb().getZdrygllxdm());//人员类型	
			variables.put("zdrylxmc", zdryVO.getZdryZdryzbVO().getZdrygllxmc());//人员类型名称	
			variables.put("yzdrylbmc", zdryVO.getZdryZdryzbVO().getZdrylbmc());//转递前类型
			variables.put("xzdrylbmc", xzdrylbmc);//转递后类型
			
			variables.put("xm", zdryVO.getZdryZdryzbVO().getXm());//被列管人员姓名
			variables.put("zjhm", zdryVO.getZdryZdryzbVO().getZjhm());//证件号码
			variables.put("sqlx", "重点人口转类");//申请类型	  			
		    variables.put("sqyj", zdryVO.getYwsqyy());//申请意见		
			variables.put("sqlxdm", "03");//列管01  撤管02 专类03
			variables.put("approvalMethod", "szzlApproval");
			variables.put("sqyj", "申请将"+zdryVO.getXm()+"转换重点人员类别");
			
			processDefinitionService.startProcessInstance(sessionBean.getUserId(), "zdryzl", zdryVO.getZdryZdryzb().getId(), variables);	

			
			model.put(AppConst.STATUS, AppConst.SUCCESS);
			model.put(AppConst.MESSAGES, getUpdateSuccess());
		}catch(BussinessException e){
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, e.getLocalizedMessage());
		}
		catch (Exception e) {
			e.printStackTrace();			
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getUpdateFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
}
