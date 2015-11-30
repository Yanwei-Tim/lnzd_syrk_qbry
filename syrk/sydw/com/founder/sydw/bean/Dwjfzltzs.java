package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_JFZLTZS", pk = "id")
public class Dwjfzltzs extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4531142113090867430L;
	
	@FieldDesc("主键")
	private String id;
	@FieldDesc("检查ID")
	private String jcid;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("组织机构名称")
	private String zzjgmc;
	@FieldDesc("TITLE")
	private String title;
	@FieldDesc("文号")
	private String wh;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("WFXW")
	private String wfxw;
	@FieldDesc("FG")
	private String fg;
	@FieldDesc("GZFS")
	private String gzfs;
	@FieldDesc("GZNR")
	private String gznr;
	@FieldDesc("GZSJ")
	private String gzsj;
	@FieldDesc("ZGSX")
	private String zgsx;
	@FieldDesc("FYDWMC")
	private String fydwmc;
	@FieldDesc("FYMC")
	private String fymc;
	@FieldDesc("FHRQ")
	private String fhrq;
	@FieldDesc("WFXWR")
	private String wfxwr;
	@FieldDesc("函告日期")
	private String hgrq;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getWfxw() {
		return wfxw;
	}
	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}
	public String getFg() {
		return fg;
	}
	public void setFg(String fg) {
		this.fg = fg;
	}
	public String getGzfs() {
		return gzfs;
	}
	public void setGzfs(String gzfs) {
		this.gzfs = gzfs;
	}
	public String getGznr() {
		return gznr;
	}
	public void setGznr(String gznr) {
		this.gznr = gznr;
	}
	public String getGzsj() {
		return gzsj;
	}
	public void setGzsj(String gzsj) {
		this.gzsj = gzsj;
	}
	public String getZgsx() {
		return zgsx;
	}
	public void setZgsx(String zgsx) {
		this.zgsx = zgsx;
	}
	public String getFydwmc() {
		return fydwmc;
	}
	public void setFydwmc(String fydwmc) {
		this.fydwmc = fydwmc;
	}
	public String getFymc() {
		return fymc;
	}
	public void setFymc(String fymc) {
		this.fymc = fymc;
	}
	public String getFhrq() {
		return fhrq;
	}
	public void setFhrq(String fhrq) {
		this.fhrq = fhrq;
	}
	public String getWfxwr() {
		return wfxwr;
	}
	public void setWfxwr(String wfxwr) {
		this.wfxwr = wfxwr;
	}
	public String getHgrq() {
		return hgrq;
	}
	public void setHgrq(String hgrq) {
		this.hgrq = hgrq;
	}
}
