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
@DBInfoAnnotation(tableName = "DW_JFJFJCTZS", pk = "id")
public class Dwjfjfjctzs extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8596507401940470799L;
	
	@FieldDesc("主键")
	private String id;
	@FieldDesc("检查ID")
	private String jcid;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("组织机构名称")
	private String zzjgmc;
	@FieldDesc("组织机构id")
	private String zzjgid;
	@FieldDesc("文号")
	private String wh;
	@FieldDesc("检查日期")
	private String jcrq;
	@FieldDesc("其他")
	private String qt;
	@FieldDesc("函告日期")
	private String hgrq;
	@FieldDesc("条数")
	private String ts;
	
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
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
	public String getJcrq() {
		return jcrq;
	}
	public void setJcrq(String jcrq) {
		this.jcrq = jcrq;
	}
	public String getQt() {
		return qt;
	}
	public void setQt(String qt) {
		this.qt = qt;
	}
	public String getHgrq() {
		return hgrq;
	}
	public void setHgrq(String hgrq) {
		this.hgrq = hgrq;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
}
