package com.founder.xlpc.vo;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * @类名: PcclVO
 * @描述: 盘查车辆VO
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-12-08 上午12:21:23
 */
public class PcclVO extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 6458146650098513321L;
	@FieldDesc("车辆id")
	private String clid;
	@FieldDesc("所有人姓名")
	private String syrxm;
	@FieldDesc("所有人身份证号")
	private String syrsfzh;
	@FieldDesc("车牌号码")
	private String cphm;
	@FieldDesc("车辆品牌")
	private String clpp;
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

	public String getClid() {
		return clid;
	}

	public void setClid(String clid) {
		this.clid = clid;
	}

	public String getSyrxm() {
		return syrxm;
	}

	public void setSyrxm(String syrxm) {
		this.syrxm = syrxm;
	}

	public String getSyrsfzh() {
		return syrsfzh;
	}

	public void setSyrsfzh(String syrsfzh) {
		this.syrsfzh = syrsfzh;
	}

	public String getCphm() {
		return cphm;
	}

	public void setCphm(String cphm) {
		this.cphm = cphm;
	}

	public String getClpp() {
		return clpp;
	}

	public void setClpp(String clpp) {
		this.clpp = clpp;
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