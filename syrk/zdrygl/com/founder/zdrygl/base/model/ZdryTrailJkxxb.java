package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.Zdry_trail_jkxxb.java]
 * @ClassName: [Psjdb]
 * @Description: [一句话描述该类的功能]
 * @CreateDate: [2015-3-11 下午6:19:11]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:19:11，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_TRAIL_JKB", pk = "id")
public class ZdryTrailJkxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String xt_jkbz;
	private String lxdh;
	private String sfzh;
	
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXt_jkbz() {
		return xt_jkbz;
	}
	public void setXt_jkbz(String xt_jkbz) {
		this.xt_jkbz = xt_jkbz;
	}
	
}
