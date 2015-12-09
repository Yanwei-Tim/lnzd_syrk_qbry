package com.founder.zdrygl.vo;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryZdrykcxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-03 03:47:25
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-03 03:47:25，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


public class ZdryZdrykcxxbVO  implements Serializable {

    @FieldDesc("考察ID ") private String id;
    @FieldDesc("重点人员ID ") private String zdryid;
    @FieldDesc("考察周期代码 ") private String kczqdm;
    @FieldDesc("考察年份 ") private String kcnf;
    @FieldDesc("考察季度 ") private String kcjd;
    @FieldDesc("考察月份 ") private String kcyf;
    @FieldDesc("考察情况 ") private String kcqk;
    @FieldDesc("考察民警ID ") private String kcmjid;
    @FieldDesc("考察民警姓名 ") private String kcmjxm;
    @FieldDesc("考察_时间 ") private String kc_sj;
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
	
	public String getKczqdm() {
		return this.kczqdm;
	}
	
	public void setKczqdm(String value) {
		this.kczqdm = value;
	}
	
	public String getKcnf() {
		return this.kcnf;
	}
	
	public void setKcnf(String value) {
		this.kcnf = value;
	}
	
	public String getKcjd() {
		return this.kcjd;
	}
	
	public void setKcjd(String value) {
		this.kcjd = value;
	}
	
	public String getKcyf() {
		return this.kcyf;
	}
	
	public void setKcyf(String value) {
		this.kcyf = value;
	}
	
	public String getKcqk() {
		return this.kcqk;
	}
	
	public void setKcqk(String value) {
		this.kcqk = value;
	}
	
	public String getKcmjid() {
		return this.kcmjid;
	}
	
	public void setKcmjid(String value) {
		this.kcmjid = value;
	}
	
	public String getKcmjxm() {
		return this.kcmjxm;
	}
	
	public void setKcmjxm(String value) {
		this.kcmjxm = value;
	}
	
	public String getKc_sj() {
		return this.kc_sj;
	}
	
	public void setKc_sj(String value) {
		this.kc_sj = value;
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

