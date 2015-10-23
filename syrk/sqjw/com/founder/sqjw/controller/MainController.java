package com.founder.sqjw.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sqjw.service.MainService;
import com.founder.sqjw.vo.CountMapVO;
import com.founder.sqjw.vo.MainVo;
import com.founder.syfw.vo.SyfwListVo;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
/**
 * @类名: MainController 
 * @描述: 主页Controller
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-8-14 下午6:20:53
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController{
	@Resource(name = "mainService")
	private MainService mainService;
	/**
	 * @Title: queryPcsXqgkTj
	 * @描述: 查询派出所辖区组织机构概况统计
	 * @作者: wu_ping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPcsXqgkTj",method = RequestMethod.POST)
	public @ResponseBody EasyUIPage queryPcsXqgkTj(EasyUIPage page,@RequestParam(value = "rows",required=false) Integer rows,MainVo entity){
		String orgcode = getSessionBean().getUserOrgCode();
		orgcode = orgcode.substring(0,8);
		entity.setOrgcode(orgcode);
		EasyUIPage pageui = mainService.queryPcsXqgkTj(page, entity);
		List<?> pages = pageui.getRows();
		int syrknum = 0, bzdznum = 0, sydwnum = 0, syfwnum = 0;
		for (int i = 0; i < pages.size(); i++) {
			MainVo mainvo = (MainVo) pages.get(i);
			String orgCode = mainvo.getOrgcode();
			if (!orgCode.substring(8, orgCode.length()).equals("0000")) {
				syrknum = syrknum + Integer.parseInt(mainvo.getSyrknum());
				bzdznum = bzdznum + Integer.parseInt(mainvo.getBzdznum());
				sydwnum = sydwnum + Integer.parseInt(mainvo.getSydwnum());
				syfwnum = syfwnum + Integer.parseInt(mainvo.getSyfwnum());
			}
			
		}
		for (int i = 0; i < pages.size(); i++) {
			MainVo mainvo = (MainVo) pages.get(i);
			String orgCode = mainvo.getOrgcode();
			if (orgCode.substring(8, orgCode.length()).equals("0000")) {
				mainvo.setBzdznum(bzdznum + "");
				mainvo.setSydwnum(sydwnum + "");
				mainvo.setSyfwnum(syfwnum + "");
				mainvo.setSyrknum(syrknum + "");
			}
		}

		return pageui;
	}
	/**
	 * @Title: queryListsyfw 
	 * @描述: 查询派出所辖区和责任区实有房屋地图描点
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<SyfwListVo>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListsyfw", method = RequestMethod.POST)
	public @ResponseBody
	List<SyfwListVo> queryListsyfw(String syfwlb) {
		List<SyfwListVo> listVo = null;
		Map<String, String> param = new HashMap<String, String>();
		String orgid = getSessionBean().getUserOrgCode();
		param.put("orgCode", orgid);
		if(syfwlb.equals("1")){
			 listVo = mainService
					.queryListczf(param);
		}else if(syfwlb.equals("2")){
			 listVo = mainService
					.queryListcheckczf(param);
		}else {
			listVo =  mainService.queryListuncheckczf(param);
		}
	
		return listVo;
	}
	/**
	 * @Title: queryListzdrk 
	 * @描述: 查询责任区辖区重点人口地图描点
	 * @作者: wu_ping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值:List<CountMapVO>   返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListzdrk", method = RequestMethod.POST)
	public @ResponseBody
	List<CountMapVO> queryListzdrk(String zdrybm) {
		List<CountMapVO> listVo = null;
		Map<String, String> param = new HashMap<String, String>();
		String orgid = getSessionBean().getUserOrgCode();
		param.put("orgCode", orgid);
		param.put("zdrydm", zdrybm);
		listVo = mainService.queryListzdry(param);
		return listVo;
	
		
	}
	/**
	 * @Title: queryczf 
	 * @描述: 查询派出所辖区概况详情
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryczf",method = RequestMethod.POST)
	public @ResponseBody List<MainVo> queryczf(MainVo entity){
		
		return mainService.queryPcsXqgkXq(entity);
	}
	
	/**
	 * @Title: queryListByRyidYwlx
	 * @描述: 派出所实有人口统计
	 * @作者: wuping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<SyrkSyrkxxzb>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListByRyidYwlx", method = RequestMethod.POST)
	public @ResponseBody
	List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity) {
		List<SyrkSyrkxxzb> listVo = mainService
				.queryListByRyidYwlx(entity);
		return listVo;
	}
	/**
	 * @Title: queryListMapsyrk
	 * @描述: 派出所首页实有人口描点
	 * @作者: wuping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值: List<CountMapVO>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListMapsyrk", method = RequestMethod.POST)
	public @ResponseBody
	List<CountMapVO> queryListMapsyrk(String syrkywlxdm,String gxpcsdm,String gxzrqdm) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("syrkywlxdm", syrkywlxdm);
		param.put("gxpcsdm", gxpcsdm);
		param.put("gxzrqdm", gxzrqdm);
		List<CountMapVO> listVo = mainService
				.queryListMap(param);
		return listVo;
	}
	
	/**
	 * @Title: queryListMapzdrk
	 * @描述: 查询人员派出所重点人员描点
	 * @作者: wuping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值:List<CountMapVO>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryListMapzdrk", method = RequestMethod.POST)
	public @ResponseBody
	List<CountMapVO> queryListMapzdrk(String zdrybm,String orgid) {
		List<CountMapVO> listVo = null;
		Map<String, String> param = new HashMap<String, String>();
		if(orgid.substring(8,orgid.length()).equals("0000")){
			param.put("orgCode", orgid.substring(0, 8));
			param.put("zdrydm", zdrybm);
			listVo = mainService.queryListszzdry(param);
		}else{
			param.put("orgCode", orgid);
			param.put("zdrydm", zdrybm);
			listVo = mainService.queryListzdry(param);
		}
		
		return listVo;
	
		
	}
	
	
	
	/**
	 * @Title: countPcs
	 * @描述: 查询人员派出所首页统计
	 * @作者: wuping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值:Map<String,Object>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/countPcs" ,method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> countPcs(String orgid){
		Map<String,Object> paramMap=new HashMap<String, Object>();
		Map<String,Object> resMap = new HashMap<String,Object>();
		String level = getSessionBean().getUserOrgLevel();
		if(!orgid.equals("XT")){
			 if(orgid.substring(8, orgid.length()).equals("0000")){
			    	paramMap.put("lx", 14);
			    	paramMap.put("orgCode", orgid);
			    	paramMap.put("orgszCode", orgid.substring(0, 8));
			    	//所长统计
			    	resMap = mainService.querypcsSztj(paramMap);
			    	
			    }else{
			    	//责任区统计
			    	paramMap.put("lx", 15);
			    	 paramMap.put("orgCode", orgid);
			    	resMap = mainService.querypcstj(paramMap);
			    }
		}
	   
	   
		return resMap;
	}
	/**
	 * @Title: zdryDetails
	 * @描述: 查询重点人员详情
	 * @作者: wuping@founder.com 
	 * @参数: 传入参数定义 
	 * @返回值:Map<String,Object>    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/zdryDetails" ,method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> zdryDetails(String ryid){
		Map<String,Object> paramMap=new HashMap<String, Object>();
		Map<String,Object> resMap = new HashMap<String,Object>();
		paramMap.put("ryid", ryid);
		resMap = mainService.zdryDetails(paramMap);
		return resMap;
		
	}
	
}