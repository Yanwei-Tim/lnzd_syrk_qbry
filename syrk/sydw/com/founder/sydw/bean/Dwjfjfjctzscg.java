package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.bean.DWJfjfjctzs.java]  
 * @ClassName:    [DWJfjfjctzs]   
 * @Description:  技防检查通知书存根
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-29 下午1:28:12]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-29 下午1:28:12，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_JFJFJCTZSCG", pk = "id")
public class Dwjfjfjctzscg extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7223148766844708642L;
	
	@FieldDesc("主键")
	private String id;
	@FieldDesc("检查ID")
	private String jcid;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("通知ID")
	private String tzid;
	@FieldDesc("组织机构名称")
	private String zzjgmc;
	@FieldDesc("组织机构id")
	private String zzjgid;
	@FieldDesc("文号")
	private String wh;
	@FieldDesc("案由")
	private String ay;
	@FieldDesc("通知原因")
	private String tzyy;
	@FieldDesc("经办人")
	private String jbr;
	@FieldDesc("批准人")
	private String pzr;
	@FieldDesc("填发人")
	private String tfr;
	@FieldDesc("批准日期")
	private String pzrq;
	@FieldDesc("填发日期")
	private String tfrq;
	
	public String getTzid() {
		return tzid;
	}
	public void setTzid(String tzid) {
		this.tzid = tzid;
	}
	public String getAy() {
		return ay;
	}
	public void setAy(String ay) {
		this.ay = ay;
	}
	public String getTzyy() {
		return tzyy;
	}
	public void setTzyy(String tzyy) {
		this.tzyy = tzyy;
	}
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
	}
	public String getPzr() {
		return pzr;
	}
	public void setPzr(String pzr) {
		this.pzr = pzr;
	}
	public String getTfr() {
		return tfr;
	}
	public void setTfr(String tfr) {
		this.tfr = tfr;
	}
	public String getPzrq() {
		return pzrq;
	}
	public void setPzrq(String pzrq) {
		this.pzrq = pzrq;
	}
	public String getTfrq() {
		return tfrq;
	}
	public void setTfrq(String tfrq) {
		this.tfrq = tfrq;
	}
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
	public String getZzjgmc() {
		return zzjgmc;
	}
	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}
	public String getZzjgid() {
		return zzjgid;
	}
	public void setZzjgid(String zzjgid) {
		this.zzjgid = zzjgid;
	}
	public String getWh() {
		return wh;
	}
	public void setWh(String wh) {
		this.wh = wh;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	
}
