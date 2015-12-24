package com.founder.xlpc.controller;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.utils.DateTimeUtils;
import com.founder.xlpc.service.XlpcService;
import com.founder.xlpc.vo.PcclVO;
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
	 * @日期： 2015-12-08 下午2:41:31 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcclList",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryPcclList(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,PcclVO entity,SessionBean sessionBean){
		page.setPagePara(rows);
		sessionBean = getSessionBean(sessionBean);
		return xlpcService.queryPcclList(page, entity);
	}
	/**
	 * @Title: queryPcry 
	 * @描述: 根据盘查任务查询盘查人员
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-12-09  上午9:35:53 
	 * @返回值: List<PcryVO>  返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcry",method = RequestMethod.POST)
	public @ResponseBody List<PcryVO> queryPcry(PcryVO entity){
		return xlpcService.queryPcry(entity);
	}
	/**
	 * @Title: queryPccl
	 * @描述: 根据盘查任务查询盘查车辆
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-12-09  上午11:31:12 
	 * @返回值: List<PcclVO>  返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPccl",method = RequestMethod.POST)
	public @ResponseBody List<PcclVO> queryPccl(PcclVO entity){
		return xlpcService.queryPccl(entity);
	}
	/**
	 * @Title: createXlpc
	 * @描述: 盘查轨迹跳转页面
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: ryxm、sfzh、mainTabID
	 * @日期： 2015-12-11 14:02:43 
	 * @返回值:
	 * @throws
	 */
	@RequestMapping(value = "/createXlpc", method = RequestMethod.GET)
    public ModelAndView createXlpc(String ryxm,String sfzh,String mainTabID){
		ModelAndView mv = new ModelAndView("xlpc/pcgj");
		try {
			if(StringUtils.isBlank(ryxm)&&StringUtils.isBlank(sfzh)){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				mv.addObject("kssj", formatter.format(DateTimeUtils.getTimesmorning()));
				mv.addObject("jssj", formatter.format(DateTimeUtils.getTimesmorning()));
			}else{
				mv.addObject("kssj","");
				mv.addObject("jssj","");
			}
			if(!StringUtils.isBlank(ryxm)){
				mv.addObject("ryxm", java.net.URLDecoder.decode(ryxm,"UTF-8"));
			}
			if(!StringUtils.isBlank(sfzh)){
				mv.addObject("sfzh", sfzh);
			}
			if(!StringUtils.isBlank(mainTabID)){
				mv.addObject("mainTabID", mainTabID);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mv;
    }
	/**
	 * @Title: queryDateTime
	 * @描述: 获取设置时间
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: bz 标志
	 * @日期： 2015-12-11 14:02:43 
	 * @返回值:
	 * @throws
	 */
	@RequestMapping(value = "/queryDateTime", method = RequestMethod.POST)
    public @ResponseBody PcryVO queryDateTime(String bz){
		PcryVO vo = new PcryVO();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if("1".equals(bz)){
			vo.setKssj(formatter.format(DateTimeUtils.getTimesmorning()));
			vo.setJssj(formatter.format(DateTimeUtils.getTimesmorning()));
		}else if("2".equals(bz)){
			vo.setKssj(formatter.format(DateTimeUtils.getStAft()));
			vo.setJssj(formatter.format(DateTimeUtils.getTimesmorning()));
		}else if("3".equals(bz)){
			vo.setKssj(formatter.format(DateTimeUtils.getTimesWeekmorning()));
			vo.setJssj(formatter.format(DateTimeUtils.getTimesmorning()));
		}
		return vo;
	}
}