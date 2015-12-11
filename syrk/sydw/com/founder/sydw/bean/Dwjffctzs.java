package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.bean.DWJfjfjctzs.java]  
 * @ClassName:    [DWJfjfjctzs]   
 * @Description:  技防检查通知书
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-29 下午1:28:12]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-29 下午1:28:12，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_JFFCTZS", pk = "id")
public class Dwjffctzs extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -2975625908961194857L;
	
	@FieldDesc("主键")
	private String id;
	@FieldDesc("检查ID")
	private String jcid;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("文号")
	private String wh;
	@FieldDesc("复查日期")
	private String fcrq;
	@FieldDesc("复查意见")
	private String fcyj;
	@FieldDesc("函告日期")
	private String hgrq;

	private String jctzswh;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJcid() {
		return jcid;
	}

	public void setJcid(String jcid) {
		this.jcid = jcid;
	}

	public String getDwid() {
		return dwid;
	}

	public void setDwid(String dwid) {
		this.dwid = dwid;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getWh() {
		return wh;
	}

	public void setWh(String wh) {
		this.wh = wh;
	}

	public String getFcrq() {
		return fcrq;
	}

	public void setFcrq(String fcrq) {
		this.fcrq = fcrq;
	}

	public String getFcyj() {
		return fcyj;
	}

	public void setFcyj(String fcyj) {
		this.fcyj = fcyj;
	}

	public String getHgrq() {
		return hgrq;
	}

	public void setHgrq(String hgrq) {
		this.hgrq = hgrq;
	}

	public String getJctzswh() {
		return jctzswh;
	}

	public void setJctzswh(String jctzswh) {
		this.jctzswh = jctzswh;
	}
	
}
