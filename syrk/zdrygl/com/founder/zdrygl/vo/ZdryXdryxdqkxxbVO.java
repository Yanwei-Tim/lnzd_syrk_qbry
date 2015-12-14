package com.founder.zdrygl.vo;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;

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


public class ZdryXdryxdqkxxbVO  implements Serializable {

    @FieldDesc("吸毒人员ID ") private String id;
    @FieldDesc("重点人员ID ") private String zdryid;
    @FieldDesc("吸食情况代码 ") private String xsqkdm;
    @FieldDesc("初次吸毒种类代码 ") private String ccxdzldm;
    @FieldDesc("吸毒原因代码 ") private String xdyydm;
    @FieldDesc("吸毒方式代码 ") private String xdfsdm;
    @FieldDesc("毒品来源代码 ") private String dplydm;
    @FieldDesc("毒资来源代码 ") private String dzlydm;
    @FieldDesc("危害社会后果 ") private String whshhg;
    @FieldDesc("初次吸毒_日期 ") private String ccxd_rq;
    @FieldDesc("初次查获_日期 ") private String ccch_rq;
    @FieldDesc("初次查获详址 ") private String ccchxz;
    @FieldDesc("查获机构名称 ") private String chjgmc;
    @FieldDesc("初次查获处置情况代码 ") private String ccchczqkdm;
    @FieldDesc("吸毒人员现状代码 ") private String xdryxzdm;
    @FieldDesc("共同吸毒情况 ") private String gtxdqk;
    @FieldDesc("戒毒情况 ") private String jdqk;
    @FieldDesc("复吸_日期 ") private String fxrq;
    @FieldDesc("复吸次数 ") private String fxcs;
    @FieldDesc("复吸查获处置情况代码 ") private String fxchczqkdm;
    @FieldDesc("复吸查获处置单位代码 ") private String fxchczdwdm;
    @FieldDesc("复吸查获处置单位名称 ") private String fxchczdwmc;
    @FieldDesc("复吸_毒品种类代码 ") private String fxdpzldm;
    @FieldDesc("复吸查获详址 ") private String fxchxz;
    @FieldDesc("备注 ") private String bz;
    @FieldDesc("采集时间 ") private String xt_cjsj;
    @FieldDesc("录入时间 ") private String xt_lrsj;
    @FieldDesc("录入人姓名 ") private String xt_lrrxm;
    @FieldDesc("录入人ID ") private String xt_lrrid;
    @FieldDesc("录入人部门 ") private String xt_lrrbm;
    @FieldDesc("录入人部门ID ") private String xt_lrrbmid;
    @FieldDesc("录入IP ") private String xt_lrip;
    @FieldDesc("最后修改时间 ") private String xt_zhxgsj;
    @FieldDesc("最后修改人姓名 ") private String xt_zhxgrxm;
    @FieldDesc("最后修改人ID ") private String xt_zhxgrid;
    @FieldDesc("最后修改人部门 ") private String xt_zhxgrbm;
    @FieldDesc("最后修改人部门ID ") private String xt_zhxgrbmid;
    @FieldDesc("最后修改IP ") private String xt_zhxgip;
    @FieldDesc("注销标志 ") private String xt_zxbz;
    @FieldDesc("注销原因 ") private String xt_zxyy;

	public String getId() {
		return this.id;
	}
	
	public void setId(String value) {
		this.id = value;
	}
	
	public String getZdryid() {
		return this.zdryid;
	}
	
	public void setZdryid(String value) {
		this.zdryid = value;
	}
	
	public String getXsqkdm() {
		return this.xsqkdm;
	}
	
	public void setXsqkdm(String value) {
		this.xsqkdm = value;
	}
	
	public String getCcxdzldm() {
		return this.ccxdzldm;
	}
	
	public void setCcxdzldm(String value) {
		this.ccxdzldm = value;
	}
	
	public String getXdyydm() {
		return this.xdyydm;
	}
	
	public void setXdyydm(String value) {
		this.xdyydm = value;
	}
	
	public String getXdfsdm() {
		return this.xdfsdm;
	}
	
	public void setXdfsdm(String value) {
		this.xdfsdm = value;
	}
	
	public String getDplydm() {
		return this.dplydm;
	}
	
	public void setDplydm(String value) {
		this.dplydm = value;
	}
	
	public String getDzlydm() {
		return this.dzlydm;
	}
	
	public void setDzlydm(String value) {
		this.dzlydm = value;
	}
	
	public String getWhshhg() {
		return this.whshhg;
	}
	
	public void setWhshhg(String value) {
		this.whshhg = value;
	}
	
	public String getCcxd_rq() {
		return this.ccxd_rq;
	}
	
	public void setCcxd_rq(String value) {
		this.ccxd_rq = value;
	}
	
	public String getCcch_rq() {
		return this.ccch_rq;
	}
	
	public void setCcch_rq(String value) {
		this.ccch_rq = value;
	}
	
	public String getCcchxz() {
		return this.ccchxz;
	}
	
	public void setCcchxz(String value) {
		this.ccchxz = value;
	}
	
	public String getChjgmc() {
		return this.chjgmc;
	}
	
	public void setChjgmc(String value) {
		this.chjgmc = value;
	}
	
	public String getCcchczqkdm() {
		return this.ccchczqkdm;
	}
	
	public void setCcchczqkdm(String value) {
		this.ccchczqkdm = value;
	}
	
	public String getXdryxzdm() {
		return this.xdryxzdm;
	}
	
	public void setXdryxzdm(String value) {
		this.xdryxzdm = value;
	}
	
	public String getGtxdqk() {
		return this.gtxdqk;
	}
	
	public void setGtxdqk(String value) {
		this.gtxdqk = value;
	}
	
	public String getJdqk() {
		return this.jdqk;
	}
	
	public void setJdqk(String value) {
		this.jdqk = value;
	}
	
	public String getFxrq() {
		return this.fxrq;
	}
	
	public void setFxrq(String value) {
		this.fxrq = value;
	}
	
	public String getFxcs() {
		return this.fxcs;
	}
	
	public void setFxcs(String value) {
		this.fxcs = value;
	}
	
	public String getFxchczqkdm() {
		return this.fxchczqkdm;
	}
	
	public void setFxchczqkdm(String value) {
		this.fxchczqkdm = value;
	}
	
	public String getFxchczdwdm() {
		return this.fxchczdwdm;
	}
	
	public void setFxchczdwdm(String value) {
		this.fxchczdwdm = value;
	}
	
	public String getFxchczdwmc() {
		return this.fxchczdwmc;
	}
	
	public void setFxchczdwmc(String value) {
		this.fxchczdwmc = value;
	}
	
	public String getFxdpzldm() {
		return this.fxdpzldm;
	}
	
	public void setFxdpzldm(String value) {
		this.fxdpzldm = value;
	}
	
	public String getFxchxz() {
		return this.fxchxz;
	}
	
	public void setFxchxz(String value) {
		this.fxchxz = value;
	}
	
	public String getBz() {
		return this.bz;
	}
	
	public void setBz(String value) {
		this.bz = value;
	}
	
	public String getXt_cjsj() {
		return this.xt_cjsj;
	}
	
	public void setXt_cjsj(String value) {
		this.xt_cjsj = value;
	}
	
	public String getXt_lrsj() {
		return this.xt_lrsj;
	}
	
	public void setXt_lrsj(String value) {
		this.xt_lrsj = value;
	}
	
	public String getXt_lrrxm() {
		return this.xt_lrrxm;
	}
	
	public void setXt_lrrxm(String value) {
		this.xt_lrrxm = value;
	}
	
	public String getXt_lrrid() {
		return this.xt_lrrid;
	}
	
	public void setXt_lrrid(String value) {
		this.xt_lrrid = value;
	}
	
	public String getXt_lrrbm() {
		return this.xt_lrrbm;
	}
	
	public void setXt_lrrbm(String value) {
		this.xt_lrrbm = value;
	}
	
	public String getXt_lrrbmid() {
		return this.xt_lrrbmid;
	}
	
	public void setXt_lrrbmid(String value) {
		this.xt_lrrbmid = value;
	}
	
	public String getXt_lrip() {
		return this.xt_lrip;
	}
	
	public void setXt_lrip(String value) {
		this.xt_lrip = value;
	}
	
	public String getXt_zhxgsj() {
		return this.xt_zhxgsj;
	}
	
	public void setXt_zhxgsj(String value) {
		this.xt_zhxgsj = value;
	}
	
	public String getXt_zhxgrxm() {
		return this.xt_zhxgrxm;
	}
	
	public void setXt_zhxgrxm(String value) {
		this.xt_zhxgrxm = value;
	}
	
	public String getXt_zhxgrid() {
		return this.xt_zhxgrid;
	}
	
	public void setXt_zhxgrid(String value) {
		this.xt_zhxgrid = value;
	}
	
	public String getXt_zhxgrbm() {
		return this.xt_zhxgrbm;
	}
	
	public void setXt_zhxgrbm(String value) {
		this.xt_zhxgrbm = value;
	}
	
	public String getXt_zhxgrbmid() {
		return this.xt_zhxgrbmid;
	}
	
	public void setXt_zhxgrbmid(String value) {
		this.xt_zhxgrbmid = value;
	}
	
	public String getXt_zhxgip() {
		return this.xt_zhxgip;
	}
	
	public void setXt_zhxgip(String value) {
		this.xt_zhxgip = value;
	}
	
	public String getXt_zxbz() {
		return this.xt_zxbz;
	}
	
	public void setXt_zxbz(String value) {
		this.xt_zxbz = value;
	}
	
	public String getXt_zxyy() {
		return this.xt_zxyy;
	}
	
	public void setXt_zxyy(String value) {
		this.xt_zxyy = value;
	}
	
}

