package com.founder.zdrygl.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.base.dao.ZdryQbxxbDao;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdryQbxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.founder.zdrygl.core.utils.ZdryQbDict;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryQbxxbService.java]  
 * @ClassName:    [ZdryQbxxbService]   
 * @Description:  [情报人员服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月25日 上午10:58:50]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月25日 上午10:58:50，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("zdryQbxxbService")
public class ZdryQbxxbService {
	
	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;
	
	@Autowired
	private ZdryQbxxbDao zdryQbxxbDao;
	
	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryQbxxbDao    返回类型
	 * @throw
	 */
	public ZdryQbxxb queryById(String id) {
	
		return zdryQbxxbDao.queryById(id);
	}
	
	public EasyUIPage queryList(ZdryQbxxb entity, EasyUIPage page) {
		return zdryQbxxbDao.queryList(entity, page);
	}
	
	/**
	 * 
	 * @Title: save
	 * @Description: TODO(新增zdry)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(ZdryQbxxb entity,SessionBean sessionBean){	
		  String  gmsfhm = entity.getGmsfhm();		  		
		   String  glzt=entity.getGlzt();
		   //验证身份号码
			if(validationqbrygmsfhm(gmsfhm)){												   			    			        
			            //验证管理状态		
			        	if(validationqbryglzt(glzt)){
	                       //待下发状态，才开始新增情报人员信息
			        		 entity.setId(UUID.create());
			        		 BaseService.setSaveProperties(entity, sessionBean);
			        		 zdryQbxxbDao.save(entity);
			        	 }else{			        		 
			        		      String erromsg="管理状态不是带下发状态";			
			        		      throw new RuntimeException(erromsg);
			        	 }		        			        					        	         				        	    	 		    		 					    								 
			    }
			else{						
				String erromsg="公民身份证号码位数不正确或者为空";			
				throw new RuntimeException(erromsg);
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
		 * @Title: validationqbryglzt
		 * @Description: TODO(验证管理状态)
		 * @param @param glzt
		 * @param @return    设定文件
		 * @return boolean    返回类型
		 * @throws
		 */
		public boolean validationqbryglzt(String glzt){
			if( ZdryQbDict.GLZT_DXF.equals(glzt)){
				return true;	
			}		
			else{
				return false;	
			}
		}	
	/**
	 * 
	 * @Title: saveLg
	 * @Description: TODO(情报人员接收，列管)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	public void saveLg(ZdryQbxxb entity,SessionBean sessionBean){
		ZdryZb zdryzb = new ZdryZb();
		zdryzb.setId(entity.getId());//列管后，情报人员信息表 作为重点人员总表的子表，两者Id要保持一致
		zdryzb.setGlzt(ZdryConstant.YLG);
		zdryzb.setGlbm(sessionBean.getUserOrgCode());//管理部门
		BaseService.setSaveProperties(zdryzb, sessionBean);		
		
		zdryzb.setXm(entity.getXm());
		zdryzb.setXbdm(entity.getXbdm());
		zdryzb.setZjhm(entity.getGmsfhm());
		zdryzb.setCsrq(entity.getCsrq());
		zdryzb.setMzdm(entity.getMzdm());
		zdryzb.setZdrygllxdm(entity.getZdrygllxdm());
		zdryzb.setZdrylb(entity.getZdrylb());
		zdryZdryZbDao.insert(zdryzb);//列管重点人员
		
		//修改情报人员状态为“已接收”
		entity.setGlzt(ZdryQbDict.GLZT_YJS);
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryQbxxbDao.update(entity);
	}
}
