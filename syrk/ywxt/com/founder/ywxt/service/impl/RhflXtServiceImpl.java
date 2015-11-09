package com.founder.ywxt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.dao.SyrkCzrkxxbDao;
import com.founder.ywxt.bean.YwxtYwxtxxb;
import com.founder.ywxt.bean.Ywxtcyryxxb;
import com.founder.ywxt.dao.YwxtYwxtxxbDao;
import com.founder.ywxt.dao.YwxtcyryxxbDao;
import com.founder.ywxt.service.AbstractXtTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.ywxt.service.impl.RhflXtServiceImpl.java]
 * @ClassName: [RhflXtServiceImpl]
 * @Description: [人户分离协同业务]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-5-29 上午10:54:34]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-5-29 上午10:54:34，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Service("rhflXtServiceImpl")
@Transactional
public class RhflXtServiceImpl extends AbstractXtTask {
	private final String XTLX = "常住人口人户分离协同";
	@Resource(name = "ywxtcyryxxbDao")
	private YwxtcyryxxbDao ywxtcyryxxbDao;
	@Resource(name = "ywxtYwxtxxbDao")
	private YwxtYwxtxxbDao ywxtYwxtxxbDao;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource(name = "syrkCzrkxxbDao")
	private SyrkCzrkxxbDao SyrkCzrkxxbDao;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;

	@Override
	public void createTask(Map<String, Object> paramMap) {
		// 这里保存信息表和参与人表
		Map<String, Object> jsonMap = (Map<String, Object>) paramMap
				.get("json");
		Map fqMap = (Map) jsonMap.get("fq");
		String jsonStr = new Gson().toJson(jsonMap);
		List<Ywxtcyryxxb> listCyr = (List<Ywxtcyryxxb>) paramMap.get("users");
		String messageContent = "";
		String orgCode = "";
		Ywxtcyryxxb fqrxxb = null;
		YwxtYwxtxxb ywxtYwxtxxb = new YwxtYwxtxxb();
		ywxtYwxtxxb.setDatajson(jsonStr);
		ywxtYwxtxxb.setYwlx(XTLX);
		ywxtYwxtxxb.setXt_cjsj(DateUtils.getSystemDateTimeString());
		ywxtYwxtxxb.setXt_zhxgsj(DateUtils.getSystemDateTimeString());
		ywxtYwxtxxbDao.save(ywxtYwxtxxb);
		for (int i = 0; i < listCyr.size(); i++) {
			Ywxtcyryxxb ywxtcyryxxb = listCyr.get(i);
			ywxtcyryxxb.setXtywid(ywxtYwxtxxb.getId());
			ywxtcyryxxbDao.save(ywxtcyryxxb);
			if ("发起".equals(ywxtcyryxxb.getXtdz())) {// 如果是发送方取出内容拼接消息内容
				messageContent += orgOrganizationService
						.queryOrgNameByOrgcodes(ywxtcyryxxb.getSspcs())
						+ "、"
						+ orgOrganizationService
								.queryOrgNameByOrgcodes(ywxtcyryxxb.getSszrq())
						+ ywxtcyryxxb.getCyrxm()
						+ "把"
						+ fqMap.get("xm")
						+ "录入为该辖区实有人口，是否把本辖区人户一至改为人户分离";
				fqrxxb = ywxtcyryxxb;
			}
			if ("接收".equals(ywxtcyryxxb.getXtdz())) {
				orgCode = ywxtcyryxxb.getSszrq();
			}

		}
		ywxtYwxtxxb.setYwnr(messageContent);
		ywxtYwxtxxb.setXt_zhxgsj(DateUtils.getSystemDateTimeString());
		ywxtYwxtxxbDao.update(ywxtYwxtxxb);

		// 发起协同任务通过message功能组件
		String url = "/ywxt/creatRyxt?xtId=" + ywxtYwxtxxb.getId()
				+ "&approvalLevel=1";
		super.sendMessage(messageContent, XTLX, fqrxxb, url, orgCode);
	}

	@Override
	public void updateXtjgByCyr(Map<String, Object> map, int approvalLevel,
			SessionBean sessionBean, String xtType) throws BussinessException {
		String xtjg = (String) map.get("xtjg");
		super.updateXtjgByCyr(map, approvalLevel, sessionBean, XTLX);
		if ("1".equals(xtjg)) {
			doBusinessOpration((String) map.get("xtId"), sessionBean);
		}else if ("0".equals(xtjg)&&approvalLevel==2) {
			doBusinessRefuse((String) map.get("xtId"), sessionBean);
		}
		//清理协同业务数据
		super.receiveXtywxx(map, approvalLevel, sessionBean, XTLX);
	}

	/***
	 * 
	 * @Title: doBusinessOpration
	 * @Description: TODO这里同意后，自动修改为分户分离
	 * @param @param xtid
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	@Override
	public void doBusinessOpration(String xtid, SessionBean sessionBean) {
		YwxtYwxtxxb ywxtYwxtxxb = ywxtYwxtxxbDao.queryById(xtid);
		String dataJson = ywxtYwxtxxb.getDatajson();
		Map<String, Object> jsonMap = new Gson().fromJson(dataJson,
				new TypeToken<Map<String, Map<String, String>>>() {
				}.getType());
		Map jsMap = (Map) jsonMap.get("js");
		String czrkid = (String) jsMap.get("id");
		SyrkCzrkxxb syrkCzrkxxb = new SyrkCzrkxxb();
		syrkCzrkxxb.setId(czrkid);
		syrkCzrkxxb.setSfrhyzdm("0");
		BaseService.setUpdateProperties(syrkCzrkxxb, sessionBean);
		SyrkCzrkxxbDao.update(syrkCzrkxxb);
	}

	/***
	 * 
	 * @Title: doBusinessOpration
	 * @Description: TODO这里拒绝后，发送代办任务，弹出修改页面
	 * @param @param xtid
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public void doBusinessRefuse(String xtid, SessionBean sessionBean) {
		YwxtYwxtxxb ywxtYwxtxxb = ywxtYwxtxxbDao.queryById(xtid);
		String dataJson = ywxtYwxtxxb.getDatajson();
		Map<String, Object> jsonMap = new Gson().fromJson(dataJson,
				new TypeToken<Map<String, Map<String, String>>>() {
				}.getType());
		Map<String, String> fqMap = (Map<String, String>) jsonMap.get("fq");
		// 查询接收人的部门，发送协同待办到部门
		List<Ywxtcyryxxb> cyrList = ywxtcyryxxbDao.queryByXtid(xtid);
		// 这里适用大连情况，取得发起和接收人
		Ywxtcyryxxb jsCyr = null;
		for (int i = 0; i < cyrList.size(); i++) {
			Ywxtcyryxxb ywxtcyryxxb = cyrList.get(i);
			if ("发起".equals(ywxtcyryxxb.getXtdz())) {
				jsCyr = ywxtcyryxxb;
			}
		}
		// 这里根据5类人，打开不同的编辑页面
		SysMessage message = new SysMessage();
		message.setXxnr("请注销实有人口" + fqMap.get("xm") + "。");
		message.setXxbt("分离协同待办");
		message.setXxlb("6");
		message.setYwurl("/syrkGl/syrkGl");
		message.setFsr(sessionBean.getUserName());
		message.setFsrdm(sessionBean.getUserId());
		message.setFssj(DateUtils.getSystemDateTimeString());
		message.setFsrssdw(sessionBean.getUserOrgName());
		message.setFsrssdwdm(sessionBean.getUserOrgCode());
		sysMessageDao.saveMessageByOrg(message, jsCyr.getSszrq(), false, false);
	}
}
