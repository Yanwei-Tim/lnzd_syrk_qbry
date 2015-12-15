package com.founder.zdrygl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.ZdryDtjsClxxb.java]  
 * @ClassName:    [ZdryDtjsClxxb]   
 * @Description:  [车辆信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-14 上午9:39:28]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-14 上午9:39:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_CLXX", pk = "ID")
public class ZdryDtjsClxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("重点人证件号码")
	private String zjhm;
	@FieldDesc("车辆品牌")
	private String clpp;
	@FieldDesc("车辆类型")
	private String cllx;
	@FieldDesc("车辆颜色")
	private String clys;
	@FieldDesc("车辆号码")
	private String clhm;
	@FieldDesc("车辆来源")
	private String clly;
	@FieldDesc("归属人")
	private String gsr;
	@FieldDesc("车辆信息编号")
	private String clxxbh;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getClpp() {
		return clpp;
	}
	public void setClpp(String clpp) {
		this.clpp = clpp;
	}
	public String getCllx() {
		return cllx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public String getClys() {
		return clys;
	}
	public void setClys(String clys) {
		this.clys = clys;
	}
	public String getClhm() {
		return clhm;
	}
	public void setClhm(String clhm) {
		this.clhm = clhm;
	}
	public String getClly() {
		return clly;
	}
	public void setClly(String clly) {
		this.clly = clly;
	}
	public String getGsr() {
		return gsr;
	}
	public void setGsr(String gsr) {
		this.gsr = gsr;
	}
	public String getClxxbh() {
		return clxxbh;
	}
	public void setClxxbh(String clxxbh) {
		this.clxxbh = clxxbh;
	}

	
	
}
