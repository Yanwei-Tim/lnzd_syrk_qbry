package com.founder.zdrygl.vo;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryWffzjlxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-03 03:41:42
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-03 03:41:42，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


public class ZdryWffzjlxxbVO  implements Serializable {

    @FieldDesc("违法犯罪记录ID ") private String id;
    @FieldDesc("重点人员ID ") private String zdryid;
    @FieldDesc("案件编号 ") private String ajbh;
    @FieldDesc("案件名称 ") private String ajmc;
    @FieldDesc("案件类型代码 ") private String ajlxdm;
    @FieldDesc("涉刑事_案件类别代码 ") private String sxs_ajlbdm;
    @FieldDesc("涉行政_案件类别代码 ") private String sxz_ajlbdm;
    @FieldDesc("人员涉案类型代码 ") private String rysalxdm;
    @FieldDesc("案发_日期 ") private String af_rq;
    @FieldDesc("案发地点_行政区划代码 ") private String afdd_xzqhdm;
    @FieldDesc("案发地点_街路巷/小区/村屯代码 ") private String afdd_jlxxqctdm;
    @FieldDesc("案发地点详址 ") private String afddxz;
    @FieldDesc("案发地点_中心点横坐标 ") private String afddzbx;
    @FieldDesc("案发地点_中心点纵坐标 ") private String afddzby;
    @FieldDesc("涉案情节及处理结果 ") private String saqjjcljg;
    @FieldDesc("处理日期 ") private String clrq;
    @FieldDesc("处理单位机构代码 ") private String cldwdm;
    @FieldDesc("处理_单位名称 ") private String cl_dwmc;
    @FieldDesc("办案民警 ") private String bamj;
    @FieldDesc("问题性质代码 ") private String wtxzdm;
    @FieldDesc("处罚_时间 ") private String cfsj;
    @FieldDesc("处罚机关 ") private String cfjg;
    @FieldDesc("处罚程度代码 ") private String cfcddm;
    @FieldDesc("执行机关 ") private String zxjg;
    @FieldDesc("执行地点 ") private String zxdd;
    @FieldDesc("执行_开始时间 ") private String zx_kssj;
    @FieldDesc("执行_结束时间 ") private String zx_jssj;
    @FieldDesc("登记单位机构代码 ") private String djdwdm;
    @FieldDesc("登记_单位名称 ") private String dj_dwmc;
    @FieldDesc("登记人 ") private String djr;
    @FieldDesc("登记人名称 ") private String djrmc;
    @FieldDesc("登记时间 ") private String djsj;
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
	
	public String getAjbh() {
		return this.ajbh;
	}
	
	public void setAjbh(String value) {
		this.ajbh = value;
	}
	
	public String getAjmc() {
		return this.ajmc;
	}
	
	public void setAjmc(String value) {
		this.ajmc = value;
	}
	
	public String getAjlxdm() {
		return this.ajlxdm;
	}
	
	public void setAjlxdm(String value) {
		this.ajlxdm = value;
	}
	
	public String getSxs_ajlbdm() {
		return this.sxs_ajlbdm;
	}
	
	public void setSxs_ajlbdm(String value) {
		this.sxs_ajlbdm = value;
	}
	
	public String getSxz_ajlbdm() {
		return this.sxz_ajlbdm;
	}
	
	public void setSxz_ajlbdm(String value) {
		this.sxz_ajlbdm = value;
	}
	
	public String getRysalxdm() {
		return this.rysalxdm;
	}
	
	public void setRysalxdm(String value) {
		this.rysalxdm = value;
	}
	
	public String getAf_rq() {
		return this.af_rq;
	}
	
	public void setAf_rq(String value) {
		this.af_rq = value;
	}
	
	public String getAfdd_xzqhdm() {
		return this.afdd_xzqhdm;
	}
	
	public void setAfdd_xzqhdm(String value) {
		this.afdd_xzqhdm = value;
	}
	
	public String getAfdd_jlxxqctdm() {
		return this.afdd_jlxxqctdm;
	}
	
	public void setAfdd_jlxxqctdm(String value) {
		this.afdd_jlxxqctdm = value;
	}
	
	public String getAfddxz() {
		return this.afddxz;
	}
	
	public void setAfddxz(String value) {
		this.afddxz = value;
	}
	
	public String getAfddzbx() {
		return this.afddzbx;
	}
	
	public void setAfddzbx(String value) {
		this.afddzbx = value;
	}
	
	public String getAfddzby() {
		return this.afddzby;
	}
	
	public void setAfddzby(String value) {
		this.afddzby = value;
	}
	
	public String getSaqjjcljg() {
		return this.saqjjcljg;
	}
	
	public void setSaqjjcljg(String value) {
		this.saqjjcljg = value;
	}
	
	public String getClrq() {
		return this.clrq;
	}
	
	public void setClrq(String value) {
		this.clrq = value;
	}
	
	public String getCldwdm() {
		return this.cldwdm;
	}
	
	public void setCldwdm(String value) {
		this.cldwdm = value;
	}
	
	public String getCl_dwmc() {
		return this.cl_dwmc;
	}
	
	public void setCl_dwmc(String value) {
		this.cl_dwmc = value;
	}
	
	public String getBamj() {
		return this.bamj;
	}
	
	public void setBamj(String value) {
		this.bamj = value;
	}
	
	public String getWtxzdm() {
		return this.wtxzdm;
	}
	
	public void setWtxzdm(String value) {
		this.wtxzdm = value;
	}
	
	public String getCfsj() {
		return this.cfsj;
	}
	
	public void setCfsj(String value) {
		this.cfsj = value;
	}
	
	public String getCfjg() {
		return this.cfjg;
	}
	
	public void setCfjg(String value) {
		this.cfjg = value;
	}
	
	public String getCfcddm() {
		return this.cfcddm;
	}
	
	public void setCfcddm(String value) {
		this.cfcddm = value;
	}
	
	public String getZxjg() {
		return this.zxjg;
	}
	
	public void setZxjg(String value) {
		this.zxjg = value;
	}
	
	public String getZxdd() {
		return this.zxdd;
	}
	
	public void setZxdd(String value) {
		this.zxdd = value;
	}
	
	public String getZx_kssj() {
		return this.zx_kssj;
	}
	
	public void setZx_kssj(String value) {
		this.zx_kssj = value;
	}
	
	public String getZx_jssj() {
		return this.zx_jssj;
	}
	
	public void setZx_jssj(String value) {
		this.zx_jssj = value;
	}
	
	public String getDjdwdm() {
		return this.djdwdm;
	}
	
	public void setDjdwdm(String value) {
		this.djdwdm = value;
	}
	
	public String getDj_dwmc() {
		return this.dj_dwmc;
	}
	
	public void setDj_dwmc(String value) {
		this.dj_dwmc = value;
	}
	
	public String getDjr() {
		return this.djr;
	}
	
	public void setDjr(String value) {
		this.djr = value;
	}
	
	public String getDjrmc() {
		return this.djrmc;
	}
	
	public void setDjrmc(String value) {
		this.djrmc = value;
	}
	
	public String getDjsj() {
		return this.djsj;
	}
	
	public void setDjsj(String value) {
		this.djsj = value;
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

