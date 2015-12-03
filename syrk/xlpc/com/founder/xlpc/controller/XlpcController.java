package com.founder.xlpc.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xlpc.service.XlpcService;
import com.founder.xlpc.vo.PcrwVO;
import com.founder.xlpc.vo.PcryVO;
/**
 * @类名: XlpcController
 * @描述: 移动警务【巡逻盘查】
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-11-22 下午3:48:23
 */
@Controller
@RequestMapping(value = "xlpc")
public class XlpcController extends BaseController {
	@Resource(name = "xlpcService")
	private XlpcService xlpcService;
	/**
	 * @Title: queryPcryList 
	 * @描述: 盘查人员列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-11-22 下午4:08:34 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcryList",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryPcryList(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,PcryVO entity,SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return xlpcService.queryPcryList(page, entity);
	}
	/**
	 * @Title: queryPcrwList 
	 * @描述: 盘查任务列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-11-24 下午4:08:34 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcrwList",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryPcrwList(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,PcrwVO entity,SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return xlpcService.queryPcrwList(page, entity);
	}
}