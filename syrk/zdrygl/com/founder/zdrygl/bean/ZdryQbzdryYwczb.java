package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Clxxb.java]  
 * @ClassName:    [Clxxb]   
 * @Description:  [重点人员业务操作表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-8 上午9:39:28]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 上午9:39:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_QBZDRYYWCZB", pk = "ID")
public class ZdryQbzdryYwczb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("id")
	private String id;
	@FieldDesc("操作类别")
	private String czlb;
	@FieldDesc("操作日期")
	private String czrq;
	@FieldDesc("操作意见")
	private String czyj;
	@FieldDesc("操作部门")
	private String czbm;
	@FieldDesc("操作人")
	private String czr;
	@FieldDesc("重点人员ID")
	private String zdryid;
	@FieldDesc("重点人员当前状态")
	private String dqzt;
	
	public String getZdryid() {
		return zdryid;
	}
	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}
	public String getDqzt() {
		return dqzt;
	}
	public void setDqzt(String dqzt) {
		this.dqzt = dqzt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCzlb() {
		return czlb;
	}
	public void setCzlb(String czlb) {
		this.czlb = czlb;
	}
	public String getCzrq() {
		return czrq;
	}
	public void setCzrq(String czrq) {
		this.czrq = czrq;
	}
	public String getCzyj() {
		return czyj;
	}
	public void setCzyj(String czyj) {
		this.czyj = czyj;
	}
	public String getCzbm() {
		return czbm;
	}
	public void setCzbm(String czbm) {
		this.czbm = czbm;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}


}
