package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
import com.founder.framework.annotation.DBInfoAnnotation;

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


@DBInfoAnnotation(tableName = "ZDRY_ZDRYKCXXB", pk = "id")
public class ZdryZdrykcxxb extends BaseEntity implements Serializable{
   @FieldDesc("考察ID") private String id;
   @FieldDesc("重点人员ID") private String zdryid;
   @FieldDesc("考察周期代码") private String kczqdm;
   @FieldDesc("考察年份") private String kcnf;
   @FieldDesc("考察季度") private String kcjd;
   @FieldDesc("考察月份") private String kcyf;
   @FieldDesc("考察情况") private String kcqk;
   @FieldDesc("考察民警ID") private String kcmjid;
   @FieldDesc("考察民警姓名") private String kcmjxm;
   @FieldDesc("考察_时间") private String kc_sj;
   @FieldDesc("备注") private String bz;

	public ZdryZdrykcxxb(){
	}

	public ZdryZdrykcxxb(
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
	public void setKczqdm(String value) {
		this.kczqdm = value;
	}
	
	public String getKczqdm() {
		return this.kczqdm;
	}
	public void setKcnf(String value) {
		this.kcnf = value;
	}
	
	public String getKcnf() {
		return this.kcnf;
	}
	public void setKcjd(String value) {
		this.kcjd = value;
	}
	
	public String getKcjd() {
		return this.kcjd;
	}
	public void setKcyf(String value) {
		this.kcyf = value;
	}
	
	public String getKcyf() {
		return this.kcyf;
	}
	public void setKcqk(String value) {
		this.kcqk = value;
	}
	
	public String getKcqk() {
		return this.kcqk;
	}
	public void setKcmjid(String value) {
		this.kcmjid = value;
	}
	
	public String getKcmjid() {
		return this.kcmjid;
	}
	public void setKcmjxm(String value) {
		this.kcmjxm = value;
	}
	
	public String getKcmjxm() {
		return this.kcmjxm;
	}
	public void setKc_sj(String value) {
		this.kc_sj = value;
	}
	
	public String getKc_sj() {
		return this.kc_sj;
	}
	public void setBz(String value) {
		this.bz = value;
	}
	
	public String getBz() {
		return this.bz;
	}


}

