package com.founder.framework.message.service;

import com.founder.framework.message.bean.SysMessageRemind;

public interface SysMessageRemindService {

	
	public Long[] saveMessageByOrg(SysMessageRemind entity, String orgCodeString);
}
