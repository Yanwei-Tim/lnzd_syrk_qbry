package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.service.activitytrace.dao.RkRyhdgjbDao;
import com.founder.service.provinceservice.bean.ServiceLkxxBean;
import com.founder.service.provinceservice.service.ServiceHttpClient;
import com.founder.zdrygl.bean.ZdryTrailJkxxb;
import com.founder.zdrygl.dao.ZdryTrailJkbDao;
import com.founder.zdrygl.service.ZdryCarTrailService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryCarTrailService.java]  
 * @ClassName:    [ZdryCarTrailService]   
 * @Description:  [评审鉴定 服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月6日 下午3:29:27]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月6日 下午3:29:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryCarTrailService")
@Transactional
public class ZdryCarTrailServiceImpl implements ZdryCarTrailService {

	@Resource(name = "zdryTrailJkbDao")
	private ZdryTrailJkbDao zdryTrailJkbDao;
	
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	
	@Resource(name = "rkRyhdgjbDao")
	private RkRyhdgjbDao rkRyhdgjbDao;
	
	@Override
	public void save(ZdryTrailJkxxb entity, SessionBean sessionBean) {
		//发送手机号通知监控该手机用户
		String lxdh = entity.getLxdh();
		if (!StringUtils.isBlank(lxdh) && entity.getXt_jkbz().equals("1")) {
			ServiceHttpClient client = new ServiceHttpClient();
			String serviceList = client.QueryCarTrailBysfzh(lxdh); // 调用热点服务
		}
		//操作表
		String xt_jkbz = entity.getXt_jkbz();
		if (!StringUtils.isBlank(xt_jkbz) && xt_jkbz.equals("0")) {
			zdryTrailJkbDao.deleteTrailJkb(lxdh);
		} else {
			String flag = zdryTrailJkbDao.queryTrailJkb(lxdh);
			entity.setSfzh(lxdh);
			if (!StringUtils.isBlank(flag)) {
				zdryTrailJkbDao.uptTrailJkb(entity);
			} else {
				zdryTrailJkbDao.insertTrailJkb(entity);
			}
		}
	}
	
	@Override
	public void saveTrail(ServiceLkxxBean entity, SessionBean sessionBean) {
		rkRyhdgjbDao.saveTrail(entity);
		sendMessage(entity, sessionBean);
	}

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送车辆轨迹消息推送)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendMessage(ServiceLkxxBean entity, SessionBean sessionBean) {
		if (entity != null) {
			//发送内容
			SysMessage sysMsg = new SysMessage();
			String xxnr = "重点人员产生一条【车辆轨迹信息】";
			sysMsg.setXxnr(xxnr);
			sysMsg.setXxlb("1");
			sysMsg.setYwurl("");
			sysMsg.setFsr(sessionBean.getUserName());
			sysMsg.setFsrdm(sessionBean.getUserId());
			sysMsg.setFsrssdw(sessionBean.getUserOrgName());
			sysMsg.setFsrssdwdm(sessionBean.getUserOrgCode());
			sysMsg.setFssj(DateUtils.getSystemDateTimeString());
			sysMsg.setSfck("0");
			sysMsg.setXxbt("重点人员");
			//发送消息提醒
			sysMessageDao.saveMessageByOrg(sysMsg, sessionBean.getUserOrgCode(), false, false);
		}
	}

	@Override
	public String queryTrailJkb(String zjhm) {
		return zdryTrailJkbDao.queryTrailJkb(zjhm);
	}
	
}
