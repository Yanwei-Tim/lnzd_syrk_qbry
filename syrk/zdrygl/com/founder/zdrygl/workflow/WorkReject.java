package com.founder.zdrygl.workflow;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.zdrygl.bean.ZdryGzb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.dao.ZdryGzbDao;
import com.founder.zdrygl.service.ZdryZdryzbService;
import com.founder.zdrygl.until.ZdryUntil;



/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.BmjsWorkflow.java]  
 * @ClassName:    [WorkReject]   
 * @Description:  [列撤管流程审批拒绝通用实现类]   
 * @Author:       [he_minxi@founder.com.cn]  
 * @CreateDate:   [2015年8月4日 下午3:14:40]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月4日 下午3:14:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Component
public class WorkReject implements JavaDelegate{

	@Resource(name="ZdryUntil")
	private ZdryUntil zdryUntil;

	
	
	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
				
		
		
	
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		SessionBean sessionBean=(SessionBean)WebUtils.getSessionAttribute(request, AppConst.USER_SESSION);
		
		String sqlxdm=(String) arg0.getVariable("sqlxdm");//申请类型
		String zdryId=(String) arg0.getVariable("zdryId");
		String zdryxm=(String) arg0.getVariable("xm");
		String ywsqrId=(String) arg0.getVariable("applyUserId");
		String cghZdryId=(String) arg0.getVariable("cghZdryId");
		String spyj=(String) arg0.getVariable("spyj");
		String spr=sessionBean.getUserId();
		String spbm=sessionBean.getUserOrgCode();
		
		if(sqlxdm.equals("01")){//列管
			zdryUntil.lgFail(zdryId, zdryxm, ywsqrId, spr, spbm, cghZdryId);
		}
		if(sqlxdm.equals("02")){//撤管
			zdryUntil.cgFail(zdryId, zdryxm, ywsqrId, spr, spbm, cghZdryId);
		}
		if(sqlxdm.equals("04")){//请假
			String qjId=(String) arg0.getVariable("qjId");			
			zdryUntil.qjFail(qjId,sessionBean.getUserName(),spr,sessionBean.getRemoteAddr(),spyj);
		}
		
	}
	
	
}
