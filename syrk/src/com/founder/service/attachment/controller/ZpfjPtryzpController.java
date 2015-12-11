package com.founder.service.attachment.controller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Decoder;

import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.ImageUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.service.attachment.bean.ZpfjPtryzpglb;
import com.founder.service.attachment.bean.ZpfjPtryzpxxb;
import com.founder.service.attachment.dao.ZpfjPtryzpDao;
import com.founder.service.attachment.service.ZpfjPtryzpService;

import com.google.gson.Gson;
@Controller
@RequestMapping(value = "zpfjPtryzp")
public class ZpfjPtryzpController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "zpfjPtryzpService")
	private ZpfjPtryzpService zpfjPtryzpService;
	
	@Resource(name = "zpfjPtryzpDao")
	private ZpfjPtryzpDao zpfjPtryzpDao;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(String ryid, String lybm, String lyid, String lyms) {
		ModelAndView mv = new ModelAndView("zpfj/zpfjPtryzpEdit");
		mv.addObject("ryid", ryid);
		mv.addObject("lybm", lybm);
		mv.addObject("lyid", lyid);
		mv.addObject("lyms", lyms);
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam CommonsMultipartFile uploadFile,
			String ryid, String lybm, String lyid, String lyms) {
		ModelAndView mv = new ModelAndView("redirect:/forward/"
				+ AppConst.FORWORD);
		Map<String, Object> model = new HashMap<String, Object>();
		SessionBean sessionBean = getSessionBean();
		try {
			if (!uploadFile.isEmpty()) {
				byte[] imageByte = uploadFile.getBytes();
				ZpfjPtryzpxxb zpfjPtryzpxxb = new ZpfjPtryzpxxb();
				zpfjPtryzpxxb.setZp(imageByte);
				zpfjPtryzpxxb.setZpslt(ImageUtils.convertImageSize(imageByte,
						179, 220, false));
				ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
				zpfjPtryzpglb.setRyid(ryid);
				zpfjPtryzpglb.setLybm(lybm);
				zpfjPtryzpglb.setLyid(lyid);
				zpfjPtryzpglb.setLyms(lyms);
				zpfjPtryzpService.savePtryzpxxb(zpfjPtryzpglb, zpfjPtryzpxxb,
						sessionBean);
				model.put(AppConst.STATUS, AppConst.SUCCESS);
				model.put(AppConst.MESSAGES, getAddSuccess());
			} else {
				model.put(AppConst.STATUS, AppConst.FAIL);
				model.put(AppConst.MESSAGES, "保存失败！由于上传文件为空！");
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			model.put(AppConst.STATUS, AppConst.FAIL);
			model.put(AppConst.MESSAGES, getAddFail());
		}
		mv.addObject(AppConst.MESSAGES, new Gson().toJson(model));
		return mv;
	}
	/**
	 * @Title: queryPtryzpSingle.jpg 
	 * @描述: 获取人员照片--优先本地库再全国人口库
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: lybm、 lyid、ryid
	 * @日期： 2015-11-26 下午4:13:32 
	 * @返回值:HttpEntity<byte[]> 返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/queryPtryzpSingle.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryPtryzpSingle(ZpfjPtryzpglb entity) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjPtryzpxxb zpfjPtryzpxxb = zpfjPtryzpService.queryPtryzpSingle(entity);
		if (zpfjPtryzpxxb != null && zpfjPtryzpxxb.getZp() != null && zpfjPtryzpxxb.getZp().length > 0) {
			headers.setContentLength(zpfjPtryzpxxb.getZp().length);
			return new HttpEntity(zpfjPtryzpxxb.getZp(), headers);
		} else {
			if ("111".equals(entity.getCyzjdm())|| "112".equals(entity.getCyzjdm())|| "335".equals(entity.getCyzjdm())) {
				SessionBean sessionBean = getSessionBean();
				String url = "http://10.78.17.238:9999/lbs";
				String zpParameter = "operation=GetPersonPhotoByID&content=";
				String zpContent = "{\"data\":[{\"rybh\":\""+entity.getZjhm()+"\"}]}";
				try {
					zpContent = zpParameter + java.net.URLEncoder.encode(zpContent,"UTF-8");
					PostMethod postMethod = new PostMethod(url);
					byte[] b = zpContent.getBytes("utf-8");
					InputStream is = new ByteArrayInputStream(b, 0,b.length);
					RequestEntity re = new InputStreamRequestEntity(is,b.length,"application/soap+xml; charset=utf-8");
					postMethod.setRequestEntity(re);
					HttpClient httpClient = new HttpClient();
					HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
					managerParams.setConnectionTimeout(50000);
					int statusCode = httpClient.executeMethod(postMethod);
					if (statusCode == 200) {
						logger.debug("调用成功！");
						String soapResponseData = postMethod.getResponseBodyAsString();
						JSONObject jb = JSONObject.fromObject(soapResponseData);
						if ((Integer) jb.get("datalen") > 0) {
							JSONObject jo = jb.getJSONArray("data").getJSONObject(0);
							byte[] pictureByte = null;
							try {
								pictureByte = new BASE64Decoder().decodeBuffer(jo.getString("photo"));
							} catch (Exception ex) {
								
							}
							if (pictureByte != null) {
								ZpfjPtryzpxxb ryzpxxb = new ZpfjPtryzpxxb();
								ryzpxxb.setId(UUID.create());
								ryzpxxb.setZp(pictureByte);
								ryzpxxb.setZpslt(pictureByte);
								BaseService.setSaveProperties(ryzpxxb, sessionBean);
								zpfjPtryzpDao.savePtryzpxxb(ryzpxxb, null);
								ZpfjPtryzpglb zpfjPtryzpglb = new ZpfjPtryzpglb();
								zpfjPtryzpglb.setId(UUID.create());
								zpfjPtryzpglb.setRyid(entity.getRyid());
								zpfjPtryzpglb.setZpid(ryzpxxb.getId());
								zpfjPtryzpglb.setLyid(entity.getRyid());
								zpfjPtryzpglb.setLyms("人员基本信息表");
								zpfjPtryzpglb.setLybm("RY_RYJBXXB");
								BaseService.setSaveProperties(zpfjPtryzpglb, sessionBean);
								zpfjPtryzpDao.savePtryzpglb(zpfjPtryzpglb, null);
							}
						} else {
							System.out.println("调用照片失败！错误码："+ statusCode);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
		}
	}

	@RequestMapping(value = "/queryPtryzpsltSingle.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryPtryzpsltSingle(ZpfjPtryzpglb entity) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjPtryzpxxb zpfjPtryzpxxb = zpfjPtryzpService
				.queryPtryzpsltSingle(entity);
		if (zpfjPtryzpxxb != null && zpfjPtryzpxxb.getZpslt() != null
				&& zpfjPtryzpxxb.getZpslt().length > 0) {
			headers.setContentLength(zpfjPtryzpxxb.getZpslt().length);
			return new HttpEntity(zpfjPtryzpxxb.getZpslt(), headers);
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
		}
	}

	@RequestMapping(value = "/queryZpById.jpg", method = RequestMethod.GET)
	public HttpEntity<byte[]> queryZpById(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		ZpfjPtryzpxxb zpfjPtryzpxxb = zpfjPtryzpService.queryZpById(StringUtils
				.nullToStr(id));
		if (zpfjPtryzpxxb != null && zpfjPtryzpxxb.getZp() != null
				&& zpfjPtryzpxxb.getZp().length > 0) {
			headers.setContentLength(zpfjPtryzpxxb.getZp().length);
			return new HttpEntity(zpfjPtryzpxxb.getZp(), headers);
		} else {
			byte[] empty_ryzp = SystemConfig.getByteArray("empty_ryzp");
			headers.setContentLength(empty_ryzp.length);
			return new HttpEntity(empty_ryzp, headers);
		}
	}

}
