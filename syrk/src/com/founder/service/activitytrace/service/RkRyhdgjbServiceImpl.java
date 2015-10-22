package com.founder.service.activitytrace.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.utils.StringUtils;
import com.founder.service.activitytrace.bean.RkRyhdgjb;
import com.founder.service.activitytrace.dao.RkRyhdgjbDao;
import com.founder.service.provinceservice.bean.ServiceLkxxBean;
import com.founder.service.provinceservice.service.ServiceHttpClient;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.dao.RyRyjbxxbDao;
import com.founder.syrkgl.service.RyRylxfsxxbService;
import com.founder.zdrygl.dao.ZdryTrailJkbDao;

@Service("rkRyhdgjbService")
@Transactional
public class RkRyhdgjbServiceImpl implements RkRyhdgjbService {
	
	@Resource(name = "zdryTrailJkbDao")
	private ZdryTrailJkbDao zdryTrailJkbDao;
	
	@Resource(name = "ryRylxfsxxbService")
	private RyRylxfsxxbService ryRylxfsxxbService;
	
	@Resource(name = "rkRyhdgjbDao")
	private RkRyhdgjbDao rkRyhdgjbDao;

	@Resource(name = "ryRyjbxxbDao")
	private RyRyjbxxbDao ryRyjbxxbDao;
	
	/**
	 * 查询人员轨迹（返回最新10条数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjb(String zjhm) {
		List<RkRyhdgjb> list = new ArrayList<RkRyhdgjb>();
		ServiceHttpClient client = new ServiceHttpClient();
		List<ServiceLkxxBean> serviceList = client.QueryLkxxBysfzh(zjhm); // 调用省厅服务
		//1 车辆监控
		RyRyjbxxb jgbz = ryRyjbxxbDao.queryByCyzjdmZjhm("", zjhm);
		if (jgbz != null) {
			String lxdh =ryRylxfsxxbService.queryLastLxfs(jgbz.getId());
			String flag = zdryTrailJkbDao.queryTrailJkb(lxdh);
			if (!StringUtils.isBlank(flag) && !StringUtils.isBlank(lxdh)) {
				List<ServiceLkxxBean> carTrailList = rkRyhdgjbDao.queryCarTrail(lxdh);
				serviceList.addAll(carTrailList);
			}
		}
		//按时间从小到大顺序排序
		//服务方公司日期格式不给修改，故此循环list重置日期格式
		for (int i = 0; i < serviceList.size(); i++) {
			ServiceLkxxBean bean = (ServiceLkxxBean)serviceList.get(i);
			String lkdjrzsj = bean.getLkdjrzsj();
			if (lkdjrzsj.indexOf("-") != -1) {
				lkdjrzsj = lkdjrzsj.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
				lkdjrzsj = lkdjrzsj.substring(0, lkdjrzsj.length()-2);
			}
			bean.setLkdjrzsj(lkdjrzsj);
		}
		java.util.Collections.sort(serviceList, new Comparator<ServiceLkxxBean>(){
			public int compare(ServiceLkxxBean bea1, ServiceLkxxBean bea2){
				return bea2.getLkdjrzsj().compareTo(bea1.getLkdjrzsj());
			}
		});
		if (serviceList != null && serviceList.size() > 0) {
			for (int i = 0; i < serviceList.size(); i++) {
				//前十条
				if (i == 10) {
					return list;
				}
				ServiceLkxxBean serviceLkxxBean = serviceList.get(i);
				String qydzxz = StringUtils.nullToStr(
						serviceLkxxBean.getQydzxz()).trim();
				String qyjbqymc = StringUtils.nullToStr(
						serviceLkxxBean.getQyjbqymc()).trim();
				String lkdjrzfh = StringUtils.nullToStr(
						serviceLkxxBean.getLkdjrzfh()).trim();
				String lkdjrzsj = StringUtils.nullToStr(
						serviceLkxxBean.getLkdjrzsj()).trim();
				String lkdjtfsj = StringUtils.nullToStr(
						serviceLkxxBean.getLkdjtfsj()).trim();
				String trailType = StringUtils.nullToStr(
						serviceLkxxBean.getTrailtype()).trim();
				String sfzh = StringUtils.nullToStr(
						serviceLkxxBean.getSfzh()).trim();
				RkRyhdgjb rkRyhdgjb = new RkRyhdgjb();
				String gjsm = "";
				if ("car".equals(trailType)) {
					gjsm = "手机号：" + sfzh + "<br>地点：" + qydzxz;
					if (!StringUtils.isBlank(lkdjrzsj)) {
						gjsm += "<br>路过时间：" + lkdjrzsj;
					}
				} else {
					gjsm = "入住旅店：" + qyjbqymc + "，房号：" + lkdjrzfh;
					if (!StringUtils.isBlank(lkdjtfsj)) {
						gjsm += "，退房时间：" + lkdjtfsj;
					}
				}
				if (lkdjrzsj.length() > 8) {
					lkdjrzsj = lkdjrzsj.substring(0, 8);
				}
				rkRyhdgjb.setGjkssj(lkdjrzsj);
				rkRyhdgjb.setGjdd(qydzxz);
				rkRyhdgjb.setGjsm(gjsm);
				list.add(rkRyhdgjb);
			}
		}
		// List<RkRyhdgjb> list = rkRyhdgjbDao.queryRkRyhdgjb(zjhm);
		return list;
	}

	/**
	 * 查询人员轨迹（返回所有数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjbAll(String zjhm) {
		return rkRyhdgjbDao.queryRkRyhdgjbAll(zjhm);
	}

}
