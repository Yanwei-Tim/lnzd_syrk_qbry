package com.founder.zdrygl.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.framework.base.controller.BaseController;
import com.founder.zdrygl.service.DeliverService;
@Controller
@RequestMapping("deliver")
public class DeliverController extends BaseController{
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "deliverService")
	private DeliverService deliverService;
	
}
