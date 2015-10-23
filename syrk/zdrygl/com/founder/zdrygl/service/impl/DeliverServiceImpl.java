package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.zdrygl.dao.DeliverDao;
import com.founder.zdrygl.service.DeliverService;
@Service("deliverService")
@Transactional
public class DeliverServiceImpl implements DeliverService {
	
	@Resource(name="deliverDao")
	private DeliverDao deliverDao;

}
