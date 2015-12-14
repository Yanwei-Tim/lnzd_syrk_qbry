package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
import com.founder.framework.annotation.DBInfoAnnotation;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryXdrynjxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-11 03:08:19
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-11 03:08:19，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@DBInfoAnnotation(tableName = "ZDRY_XDRYNJXXB", pk = "id")
public class ZdryXdrynjxxb extends BaseEntity implements Serializable{
   @FieldDesc("吸毒人员尿检信息ID") private String id;
   @FieldDesc("重点人员ID") private String zdryid;
   @FieldDesc("尿检_日期") private String nj_rq;
   @FieldDesc("尿检结果代码") private String njjgdm;
   @FieldDesc("签到_日期") private String qd_rq;
   @FieldDesc("备注") private String bz;

	public ZdryXdrynjxxb(){
	}

	public ZdryXdrynjxxb(
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
	public void setNj_rq(String value) {
		this.nj_rq = value;
	}
	
	public String getNj_rq() {
		return this.nj_rq;
	}
	public void setNjjgdm(String value) {
		this.njjgdm = value;
	}
	
	public String getNjjgdm() {
		return this.njjgdm;
	}
	public void setQd_rq(String value) {
		this.qd_rq = value;
	}
	
	public String getQd_rq() {
		return this.qd_rq;
	}
	public void setBz(String value) {
		this.bz = value;
	}
	
	public String getBz() {
		return this.bz;
	}


}

