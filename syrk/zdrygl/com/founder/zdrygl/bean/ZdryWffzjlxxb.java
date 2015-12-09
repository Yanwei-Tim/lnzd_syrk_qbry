package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
import com.founder.framework.annotation.DBInfoAnnotation;

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


@DBInfoAnnotation(tableName = "ZDRY_WFFZJLXXB", pk = "id")
public class ZdryWffzjlxxb extends BaseEntity implements Serializable{
   @FieldDesc("违法犯罪记录ID") private String id;
   @FieldDesc("重点人员ID") private String zdryid;
	@FieldDesc("身份证号 ") private String sfzh;
   @FieldDesc("案件编号") private String ajbh;
   @FieldDesc("案件名称") private String ajmc;
   @FieldDesc("案件类型代码") private String ajlxdm;
   @FieldDesc("涉刑事_案件类别代码") private String sxs_ajlbdm;
   @FieldDesc("涉行政_案件类别代码") private String sxz_ajlbdm;
   @FieldDesc("人员涉案类型代码") private String rysalxdm;
   @FieldDesc("案发_日期") private String af_rq;
   @FieldDesc("案发地点_行政区划代码") private String afdd_xzqhdm;
   @FieldDesc("案发地点_街路巷/小区/村屯代码") private String afdd_jlxxqctdm;
   @FieldDesc("案发地点详址") private String afddxz;
   @FieldDesc("案发地点_中心点横坐标") private String afddzbx;
   @FieldDesc("案发地点_中心点纵坐标") private String afddzby;
   @FieldDesc("涉案情节及处理结果") private String saqjjcljg;
   @FieldDesc("处理日期") private String clrq;
   @FieldDesc("处理单位机构代码") private String cldwdm;
   @FieldDesc("处理_单位名称") private String cl_dwmc;
   @FieldDesc("办案民警") private String bamj;
   @FieldDesc("问题性质代码") private String wtxzdm;
   @FieldDesc("处罚_时间") private String cfsj;
   @FieldDesc("处罚机关") private String cfjg;
   @FieldDesc("处罚程度代码") private String cfcddm;
   @FieldDesc("执行机关") private String zxjg;
   @FieldDesc("执行地点") private String zxdd;
   @FieldDesc("执行_开始时间") private String zx_kssj;
   @FieldDesc("执行_结束时间") private String zx_jssj;
   @FieldDesc("登记单位机构代码") private String djdwdm;
   @FieldDesc("登记_单位名称") private String dj_dwmc;
   @FieldDesc("登记人") private String djr;
   @FieldDesc("登记人名称") private String djrmc;
   @FieldDesc("登记时间") private String djsj;
   @FieldDesc("备注") private String bz;

	public ZdryWffzjlxxb(){
	}

	public ZdryWffzjlxxb(
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

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public void setAjbh(String value) {
		this.ajbh = value;
	}
	
	public String getAjbh() {
		return this.ajbh;
	}
	public void setAjmc(String value) {
		this.ajmc = value;
	}
	
	public String getAjmc() {
		return this.ajmc;
	}
	public void setAjlxdm(String value) {
		this.ajlxdm = value;
	}
	
	public String getAjlxdm() {
		return this.ajlxdm;
	}
	public void setSxs_ajlbdm(String value) {
		this.sxs_ajlbdm = value;
	}
	
	public String getSxs_ajlbdm() {
		return this.sxs_ajlbdm;
	}
	public void setSxz_ajlbdm(String value) {
		this.sxz_ajlbdm = value;
	}
	
	public String getSxz_ajlbdm() {
		return this.sxz_ajlbdm;
	}
	public void setRysalxdm(String value) {
		this.rysalxdm = value;
	}
	
	public String getRysalxdm() {
		return this.rysalxdm;
	}
	public void setAf_rq(String value) {
		this.af_rq = value;
	}
	
	public String getAf_rq() {
		return this.af_rq;
	}
	public void setAfdd_xzqhdm(String value) {
		this.afdd_xzqhdm = value;
	}
	
	public String getAfdd_xzqhdm() {
		return this.afdd_xzqhdm;
	}
	public void setAfdd_jlxxqctdm(String value) {
		this.afdd_jlxxqctdm = value;
	}
	
	public String getAfdd_jlxxqctdm() {
		return this.afdd_jlxxqctdm;
	}
	public void setAfddxz(String value) {
		this.afddxz = value;
	}
	
	public String getAfddxz() {
		return this.afddxz;
	}
	public void setAfddzbx(String value) {
		this.afddzbx = value;
	}
	
	public String getAfddzbx() {
		return this.afddzbx;
	}
	public void setAfddzby(String value) {
		this.afddzby = value;
	}
	
	public String getAfddzby() {
		return this.afddzby;
	}
	public void setSaqjjcljg(String value) {
		this.saqjjcljg = value;
	}
	
	public String getSaqjjcljg() {
		return this.saqjjcljg;
	}
	public void setClrq(String value) {
		this.clrq = value;
	}
	
	public String getClrq() {
		return this.clrq;
	}
	public void setCldwdm(String value) {
		this.cldwdm = value;
	}
	
	public String getCldwdm() {
		return this.cldwdm;
	}
	public void setCl_dwmc(String value) {
		this.cl_dwmc = value;
	}
	
	public String getCl_dwmc() {
		return this.cl_dwmc;
	}
	public void setBamj(String value) {
		this.bamj = value;
	}
	
	public String getBamj() {
		return this.bamj;
	}
	public void setWtxzdm(String value) {
		this.wtxzdm = value;
	}
	
	public String getWtxzdm() {
		return this.wtxzdm;
	}
	public void setCfsj(String value) {
		this.cfsj = value;
	}
	
	public String getCfsj() {
		return this.cfsj;
	}
	public void setCfjg(String value) {
		this.cfjg = value;
	}
	
	public String getCfjg() {
		return this.cfjg;
	}
	public void setCfcddm(String value) {
		this.cfcddm = value;
	}
	
	public String getCfcddm() {
		return this.cfcddm;
	}
	public void setZxjg(String value) {
		this.zxjg = value;
	}
	
	public String getZxjg() {
		return this.zxjg;
	}
	public void setZxdd(String value) {
		this.zxdd = value;
	}
	
	public String getZxdd() {
		return this.zxdd;
	}
	public void setZx_kssj(String value) {
		this.zx_kssj = value;
	}
	
	public String getZx_kssj() {
		return this.zx_kssj;
	}
	public void setZx_jssj(String value) {
		this.zx_jssj = value;
	}
	
	public String getZx_jssj() {
		return this.zx_jssj;
	}
	public void setDjdwdm(String value) {
		this.djdwdm = value;
	}
	
	public String getDjdwdm() {
		return this.djdwdm;
	}
	public void setDj_dwmc(String value) {
		this.dj_dwmc = value;
	}
	
	public String getDj_dwmc() {
		return this.dj_dwmc;
	}
	public void setDjr(String value) {
		this.djr = value;
	}
	
	public String getDjr() {
		return this.djr;
	}
	public void setDjrmc(String value) {
		this.djrmc = value;
	}
	
	public String getDjrmc() {
		return this.djrmc;
	}
	public void setDjsj(String value) {
		this.djsj = value;
	}
	
	public String getDjsj() {
		return this.djsj;
	}
	public void setBz(String value) {
		this.bz = value;
	}
	
	public String getBz() {
		return this.bz;
	}


}

