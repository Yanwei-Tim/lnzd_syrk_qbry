package com.founder.framework.message.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.message.bean.SysMessageRemind;
import com.founder.framework.message.dao.SysMessageRemindDao;

@Service
public class SysMessageRemindServiceImpl implements SysMessageRemindService {

	@Resource
	private SysMessageRemindDao sysMessageRemindDao;
	
	@Override
	public Long[] saveMessageByOrg(SysMessageRemind entity, String orgCodeString) {
		
		return sysMessageRemindDao.saveMessageByOrg(entity, orgCodeString);
	}

}
