package com.founder.xlpc.vo;

import java.io.Serializable;

import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * @类名: PcryVO
 * @描述: 盘查人员VO
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-11-22 下午4:10:43
 */
public class PcryVO extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 6458346650098513819L;
	@FieldDesc("人员id")
	private String ryid;
	@FieldDesc("人员姓名")
	private String ryxm;
	@FieldDesc("性别")
	private String xb;
	@FieldDesc("身份证号")
	private String sfzh;
	@FieldDesc("民族")
	private String mz;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("现居住地")
	private String xjzd;
	@FieldDesc("籍贯")
	private String jg;
	@FieldDesc("暂住证情况")
	private String zzzqk;
	@FieldDesc("是否在逃")
	private String sfzt;
	@FieldDesc("是否负案")
	private String sffa;
	@FieldDesc("是否盘查对象")
	private String sfpcdx;
	@FieldDesc("关联盘查id")
	private String glpcid;
	@FieldDesc("盘查原因")
	private String pcyy;
	@FieldDesc("盘查id")
	private String pcid;
	@FieldDesc("发生时间")
	private String fssj;
	@FieldDesc("处理状态")
	private String clzt;
	@FieldDesc("采集人")
	private String cjr;
	@FieldDesc("x坐标点")
	private String xpoint;
	@FieldDesc("y坐标点")
	private String ypoint;
	@FieldDesc("盘查任务ID")
	private String gzxxbh;

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getRyxm() {
		return ryxm;
	}

	public void setRyxm(String ryxm) {
		this.ryxm = ryxm;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getXjzd() {
		return xjzd;
	}

	public void setXjzd(String xjzd) {
		this.xjzd = xjzd;
	}

	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	public String getZzzqk() {
		return zzzqk;
	}

	public void setZzzqk(String zzzqk) {
		this.zzzqk = zzzqk;
	}

	public String getSfzt() {
		return sfzt;
	}

	public void setSfzt(String sfzt) {
		this.sfzt = sfzt;
	}

	public String getSffa() {
		return sffa;
	}

	public void setSffa(String sffa) {
		this.sffa = sffa;
	}

	public String getSfpcdx() {
		return sfpcdx;
	}

	public void setSfpcdx(String sfpcdx) {
		this.sfpcdx = sfpcdx;
	}

	public String getGlpcid() {
		return glpcid;
	}

	public void setGlpcid(String glpcid) {
		this.glpcid = glpcid;
	}

	public String getPcyy() {
		return pcyy;
	}

	public void setPcyy(String pcyy) {
		this.pcyy = pcyy;
	}

	public String getPcid() {
		return pcid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	public String getFssj() {
		return fssj;
	}

	public void setFssj(String fssj) {
		this.fssj = fssj;
	}

	public String getClzt() {
		return clzt;
	}

	public void setClzt(String clzt) {
		this.clzt = clzt;
	}

	public String getCjr() {
		return cjr;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	public String getXpoint() {
		return xpoint;
	}

	public void setXpoint(String xpoint) {
		this.xpoint = xpoint;
	}

	public String getYpoint() {
		return ypoint;
	}

	public void setYpoint(String ypoint) {
		this.ypoint = ypoint;
	}

	public String getGzxxbh() {
		return gzxxbh;
	}

	public void setGzxxbh(String gzxxbh) {
		this.gzxxbh = gzxxbh;
	}

}