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
@DBInfoAnnotation(tableName = "DW_JFFCTZSCG", pk = "id")
public class Dwjffctzscg extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4558018913787100262L;

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
	@FieldDesc("《复查意见书》文号")
	private String fcyjswh;
	@FieldDesc("复查时间")
	private String fcsj;
	@FieldDesc("检查人员")
	private String jcry;
	@FieldDesc("参检人员")
	private String cjry;
	@FieldDesc("责令通知书文号")
	private String zltzswh;
	@FieldDesc("承办部门")
	private String cbbm;
	@FieldDesc("批准人")
	private String pzr;
	@FieldDesc("批准时间")
	private String pzsj;
	@FieldDesc("填发人")
	private String tfr;
	@FieldDesc("填发时间")
	private String tfrq;
	@FieldDesc("送达时间")
	private String sdrq;
	@FieldDesc("抄送单位")
	private String csdw;
	@FieldDesc("组织机构名称")
	private String zzjgmc;
	
	private String operation;
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
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
	public String getFcyjswh() {
		return fcyjswh;
	}
	public void setFcyjswh(String fcyjswh) {
		this.fcyjswh = fcyjswh;
	}
	public String getFcsj() {
		return fcsj;
	}
	public void setFcsj(String fcsj) {
		this.fcsj = fcsj;
	}
	public String getJcry() {
		return jcry;
	}
	public void setJcry(String jcry) {
		this.jcry = jcry;
	}
	public String getCjry() {
		return cjry;
	}
	public void setCjry(String cjry) {
		this.cjry = cjry;
	}
	public String getZltzswh() {
		return zltzswh;
	}
	public void setZltzswh(String zltzswh) {
		this.zltzswh = zltzswh;
	}
	public String getCbbm() {
		return cbbm;
	}
	public void setCbbm(String cbbm) {
		this.cbbm = cbbm;
	}
	public String getPzr() {
		return pzr;
	}
	public void setPzr(String pzr) {
		this.pzr = pzr;
	}
	public String getPzsj() {
		return pzsj;
	}
	public void setPzsj(String pzsj) {
		this.pzsj = pzsj;
	}
	public String getTfr() {
		return tfr;
	}
	public void setTfr(String tfr) {
		this.tfr = tfr;
	}
	public String getTfrq() {
		return tfrq;
	}
	public void setTfrq(String tfrq) {
		this.tfrq = tfrq;
	}
	public String getSdrq() {
		return sdrq;
	}
	public void setSdrq(String sdrq) {
		this.sdrq = sdrq;
	}
	public String getCsdw() {
		return csdw;
	}
	public void setCsdw(String csdw) {
		this.csdw = csdw;
	}
	public String getZzjgmc() {
		return zzjgmc;
	}
	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}
}
