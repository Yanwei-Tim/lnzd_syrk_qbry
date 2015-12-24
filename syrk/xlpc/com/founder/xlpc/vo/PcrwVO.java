package com.founder.xlpc.vo;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * @类名: PcrwVO
 * @描述: 盘查任务VO
 * @作者: zhang_guoliang@founder.com
 * @日期: 2015-11-24 上午11:00:21
 */
public class PcrwVO extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 6458346650098513321L;
	@FieldDesc("GZXXBH")
	private String gzxxbh;
	@FieldDesc("盘查开始时间")
	private String kssj;
	@FieldDesc("盘查结束时间")
	private String jssj;
	@FieldDesc("盘查方式")
	private String xffs;
	@FieldDesc("盘查地点")
	private String gzdd;
	@FieldDesc("盘查地点描述")
	private String gzddms;
	@FieldDesc("盘查地点代码_标准地址代码")
	private String gzdddm;
	@FieldDesc("ZBX")
	private String zbx;
	@FieldDesc("ZBY")
	private String zby;
	@FieldDesc("巡逻路线名称")
	private String xlmc;
	@FieldDesc("带班民警姓名")
	private String jyxm;
	@FieldDesc("带班民警警号")
	private String jybh;
	@FieldDesc("协警人数")
	private Long xjrs;
	@FieldDesc("随同民警姓名")
	private String stmjxm;
	@FieldDesc("随同民警编号")
	private String stmjbh;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("登记人")
	private String djr;
	@FieldDesc("登记时间")
	private String djsj;
	@FieldDesc("登记单位")
	private String djdw;
	@FieldDesc("修改人")
	private String xgr;
	@FieldDesc("修改时间")
	private String xgsj;
	@FieldDesc("修改单位")
	private String xgdw;
	@FieldDesc("巡逻路线代码")
	private String xldm;
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

	public String getKssj() {
		return kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
	}

	public String getJssj() {
		return jssj;
	}

	public void setJssj(String jssj) {
		this.jssj = jssj;
	}

	public String getXffs() {
		return xffs;
	}

	public void setXffs(String xffs) {
		this.xffs = xffs;
	}

	public String getGzdd() {
		return gzdd;
	}

	public void setGzdd(String gzdd) {
		this.gzdd = gzdd;
	}

	public String getGzddms() {
		return gzddms;
	}

	public void setGzddms(String gzddms) {
		this.gzddms = gzddms;
	}

	public String getGzdddm() {
		return gzdddm;
	}

	public void setGzdddm(String gzdddm) {
		this.gzdddm = gzdddm;
	}

	public String getZbx() {
		return zbx;
	}

	public void setZbx(String zbx) {
		this.zbx = zbx;
	}

	public String getZby() {
		return zby;
	}

	public void setZby(String zby) {
		this.zby = zby;
	}

	public String getXlmc() {
		return xlmc;
	}

	public void setXlmc(String xlmc) {
		this.xlmc = xlmc;
	}

	public String getJyxm() {
		return jyxm;
	}

	public void setJyxm(String jyxm) {
		this.jyxm = jyxm;
	}

	public String getJybh() {
		return jybh;
	}

	public void setJybh(String jybh) {
		this.jybh = jybh;
	}

	public Long getXjrs() {
		return xjrs;
	}

	public void setXjrs(Long xjrs) {
		this.xjrs = xjrs;
	}

	public String getStmjxm() {
		return stmjxm;
	}

	public void setStmjxm(String stmjxm) {
		this.stmjxm = stmjxm;
	}

	public String getStmjbh() {
		return stmjbh;
	}

	public void setStmjbh(String stmjbh) {
		this.stmjbh = stmjbh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getDjr() {
		return djr;
	}

	public void setDjr(String djr) {
		this.djr = djr;
	}

	public String getDjsj() {
		return djsj;
	}

	public void setDjsj(String djsj) {
		this.djsj = djsj;
	}

	public String getDjdw() {
		return djdw;
	}

	public void setDjdw(String djdw) {
		this.djdw = djdw;
	}

	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	public String getXgsj() {
		return xgsj;
	}

	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}

	public String getXgdw() {
		return xgdw;
	}

	public void setXgdw(String xgdw) {
		this.xgdw = xgdw;
	}

	public String getXldm() {
		return xldm;
	}

	public void setXldm(String xldm) {
		this.xldm = xldm;
	}
}
