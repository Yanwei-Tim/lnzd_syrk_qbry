package com.founder.zdrygl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 *
 * @Package: [com.founder.zdrygl.bean]
 * @ClassName: ZdryZagltdxxb
 * @Description: [一句话描述该类的功能]
 * @Author: [zhoulijun@founder.com.cn]
 * @CreateDate:  2015-12-03 03:22:39
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [ 2015-12-03 03:22:39，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */


@DBInfoAnnotation(tableName = "ZDRY_ZAGLTDXXB", pk = "id")
public class ZdryZagltdxxb extends BaseEntity implements Serializable{
   @FieldDesc("作案规律特点ID") private String id;
   @FieldDesc("重点人员ID") private String zdryid;
   @FieldDesc("案件类别代码") private String ajlbdm;
   @FieldDesc("选择对象代码") private String xzdxdm;
   @FieldDesc("选择物品代码") private String xzwpdm;
   @FieldDesc("作案手段代码") private String zasddm;
   @FieldDesc("作案工具代码") private String zagjdm;
   @FieldDesc("销赃方式代码") private String xyrxzfsdm;
   @FieldDesc("作案特点代码") private String zatddm;
   @FieldDesc("选择时机代码") private String xzsjdm;
   @FieldDesc("选择处所代码") private String xzcsdm;
   @FieldDesc("备注") private String bz;

	public ZdryZagltdxxb(){
	}

	public ZdryZagltdxxb(
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
	public void setAjlbdm(String value) {
		this.ajlbdm = value;
	}
	
	public String getAjlbdm() {
		return this.ajlbdm;
	}
	public void setXzdxdm(String value) {
		this.xzdxdm = value;
	}
	
	public String getXzdxdm() {
		return this.xzdxdm;
	}
	public void setXzwpdm(String value) {
		this.xzwpdm = value;
	}
	
	public String getXzwpdm() {
		return this.xzwpdm;
	}
	public void setZasddm(String value) {
		this.zasddm = value;
	}
	
	public String getZasddm() {
		return this.zasddm;
	}
	public void setZagjdm(String value) {
		this.zagjdm = value;
	}
	
	public String getZagjdm() {
		return this.zagjdm;
	}
	public void setXyrxzfsdm(String value) {
		this.xyrxzfsdm = value;
	}
	
	public String getXyrxzfsdm() {
		return this.xyrxzfsdm;
	}
	public void setZatddm(String value) {
		this.zatddm = value;
	}
	
	public String getZatddm() {
		return this.zatddm;
	}
	public void setXzsjdm(String value) {
		this.xzsjdm = value;
	}
	
	public String getXzsjdm() {
		return this.xzsjdm;
	}
	public void setXzcsdm(String value) {
		this.xzcsdm = value;
	}
	
	public String getXzcsdm() {
		return this.xzcsdm;
	}
	public void setBz(String value) {
		this.bz = value;
	}
	
	public String getBz() {
		return this.bz;
	}


}

