package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
import com.founder.framework.annotation.DBInfoAnnotation;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryXdryxdqkxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-11 03:10:48
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-11 03:10:48，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@DBInfoAnnotation(tableName = "ZDRY_XDRYXDQKXXB", pk = "id")
public class ZdryXdryxdqkxxb extends BaseEntity implements Serializable{
   @FieldDesc("吸毒人员ID") private String id;
   @FieldDesc("重点人员ID") private String zdryid;
   @FieldDesc("吸食情况代码") private String xsqkdm;
   @FieldDesc("初次吸毒种类代码") private String ccxdzldm;
   @FieldDesc("吸毒原因代码") private String xdyydm;
   @FieldDesc("吸毒方式代码") private String xdfsdm;
   @FieldDesc("毒品来源代码") private String dplydm;
   @FieldDesc("毒资来源代码") private String dzlydm;
   @FieldDesc("危害社会后果") private String whshhg;
   @FieldDesc("初次吸毒_日期") private String ccxd_rq;
   @FieldDesc("初次查获_日期") private String ccch_rq;
   @FieldDesc("初次查获详址") private String ccchxz;
   @FieldDesc("查获机构名称") private String chjgmc;
   @FieldDesc("初次查获处置情况代码") private String ccchczqkdm;
   @FieldDesc("吸毒人员现状代码") private String xdryxzdm;
   @FieldDesc("共同吸毒情况") private String gtxdqk;
   @FieldDesc("戒毒情况") private String jdqk;
   @FieldDesc("复吸_日期") private String fxrq;
   @FieldDesc("复吸次数") private String fxcs;
   @FieldDesc("复吸查获处置情况代码") private String fxchczqkdm;
   @FieldDesc("复吸查获处置单位代码") private String fxchczdwdm;
   @FieldDesc("复吸查获处置单位名称") private String fxchczdwmc;
   @FieldDesc("复吸_毒品种类代码") private String fxdpzldm;
   @FieldDesc("复吸查获详址") private String fxchxz;
   @FieldDesc("备注") private String bz;

	public ZdryXdryxdqkxxb(){
	}

	public ZdryXdryxdqkxxb(
		String id
	){
		this.id = id;
	}

	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return this.id;
	}
	public void setZdryid(String value) {
		this.zdryid = value;
	}
	
	public String getZdryid() {
		return this.zdryid;
	}
	public void setXsqkdm(String value) {
		this.xsqkdm = value;
	}
	
	public String getXsqkdm() {
		return this.xsqkdm;
	}
	public void setCcxdzldm(String value) {
		this.ccxdzldm = value;
	}
	
	public String getCcxdzldm() {
		return this.ccxdzldm;
	}
	public void setXdyydm(String value) {
		this.xdyydm = value;
	}
	
	public String getXdyydm() {
		return this.xdyydm;
	}
	public void setXdfsdm(String value) {
		this.xdfsdm = value;
	}
	
	public String getXdfsdm() {
		return this.xdfsdm;
	}
	public void setDplydm(String value) {
		this.dplydm = value;
	}
	
	public String getDplydm() {
		return this.dplydm;
	}
	public void setDzlydm(String value) {
		this.dzlydm = value;
	}
	
	public String getDzlydm() {
		return this.dzlydm;
	}
	public void setWhshhg(String value) {
		this.whshhg = value;
	}
	
	public String getWhshhg() {
		return this.whshhg;
	}
	public void setCcxd_rq(String value) {
		this.ccxd_rq = value;
	}
	
	public String getCcxd_rq() {
		return this.ccxd_rq;
	}
	public void setCcch_rq(String value) {
		this.ccch_rq = value;
	}
	
	public String getCcch_rq() {
		return this.ccch_rq;
	}
	public void setCcchxz(String value) {
		this.ccchxz = value;
	}
	
	public String getCcchxz() {
		return this.ccchxz;
	}
	public void setChjgmc(String value) {
		this.chjgmc = value;
	}
	
	public String getChjgmc() {
		return this.chjgmc;
	}
	public void setCcchczqkdm(String value) {
		this.ccchczqkdm = value;
	}
	
	public String getCcchczqkdm() {
		return this.ccchczqkdm;
	}
	public void setXdryxzdm(String value) {
		this.xdryxzdm = value;
	}
	
	public String getXdryxzdm() {
		return this.xdryxzdm;
	}
	public void setGtxdqk(String value) {
		this.gtxdqk = value;
	}
	
	public String getGtxdqk() {
		return this.gtxdqk;
	}
	public void setJdqk(String value) {
		this.jdqk = value;
	}
	
	public String getJdqk() {
		return this.jdqk;
	}
	public void setFxrq(String value) {
		this.fxrq = value;
	}
	
	public String getFxrq() {
		return this.fxrq;
	}
	public void setFxcs(String value) {
		this.fxcs = value;
	}
	
	public String getFxcs() {
		return this.fxcs;
	}
	public void setFxchczqkdm(String value) {
		this.fxchczqkdm = value;
	}
	
	public String getFxchczqkdm() {
		return this.fxchczqkdm;
	}
	public void setFxchczdwdm(String value) {
		this.fxchczdwdm = value;
	}
	
	public String getFxchczdwdm() {
		return this.fxchczdwdm;
	}
	public void setFxchczdwmc(String value) {
		this.fxchczdwmc = value;
	}
	
	public String getFxchczdwmc() {
		return this.fxchczdwmc;
	}
	public void setFxdpzldm(String value) {
		this.fxdpzldm = value;
	}
	
	public String getFxdpzldm() {
		return this.fxdpzldm;
	}
	public void setFxchxz(String value) {
		this.fxchxz = value;
	}
	
	public String getFxchxz() {
		return this.fxchxz;
	}
	public void setBz(String value) {
		this.bz = value;
	}
	
	public String getBz() {
		return this.bz;
	}


}

