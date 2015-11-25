package com.founder.framework.message.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.bean.SysMessageRemind;
import com.founder.framework.utils.StringUtils;

@Repository("sysMessageDao")
public class SysMessageRemindDao extends BaseDaoImpl {


	/**
	 * 只给某个部门发送，按部门发送
	 * @param entity
	 * @param orgCodeString
	 * @param inculdeSubOrg
	 * @param noRepeatUser
	 * @return
	 */
	public Long[] saveMessageByOrg(SysMessageRemind entity, String orgCodeString) {
		Long[] returnArray = new Long[2]; 
		if (entity != null && !StringUtils.isBlank(orgCodeString)) {
			String orgCodeCondition = "'"
					+ orgCodeString.replaceAll(",", "','") + "'";
			SysMessageRemind sysMessageRemind = new SysMessageRemind();
			String xxnr = StringUtils.nullToStr(entity.getXxnr());
			if (xxnr.length() > 200) {
				sysMessageRemind.setXxnr(xxnr.substring(0, 200));
			} else {
				sysMessageRemind.setXxnr(xxnr);
			}

			sysMessageRemind.setJslx("1"); // 接收类型为部门
			sysMessageRemind.setSfck("0");

			String ywurl = entity.getYwurl();
			if (!StringUtils.isBlank(ywurl)) {
				if (ywurl.indexOf("?") == -1) {
					ywurl = ywurl + "?messageid=";
				} else {
					ywurl = ywurl + "&messageid=";
				}
				sysMessageRemind.setYwurl(ywurl);
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sysMessageRemind", sysMessageRemind);
			map.put("orgCodeCondition", orgCodeCondition);
		
			insert("sysMessageRemind.saveByOrgcode", map);
			
			returnArray[0] = Long.parseLong("1");
		}

		return returnArray;
	}

}
