package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Clxxb.java]  
 * @ClassName:    [ZdryQbZdryxxb]   
 * @Description:  [情报重点人员信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-9-25 上午9:39:28]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-9-25 上午9:39:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_QBZDRYXXB", pk = "ID")
public class ZdryQbZdryxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("重点人员id")
	private String zdryid;
	@FieldDesc("部级重点人员编号")
	private String bjzdrybh;
	@FieldDesc("状态")	
	private String zt;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("姓名拼音")
	private String xmpy;
	@FieldDesc("外文姓名")
	private String wwxm;
	@FieldDesc("性别")
	private String xb;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("国籍")
	private String gj;
	@FieldDesc("身份证号")
	private String sfzh;
	@FieldDesc("其他证件号码")
	private String qtzjhm;
	@FieldDesc("民族")
	private String mz;
	@FieldDesc("籍贯")
	private String jg;
	@FieldDesc("户籍地区划")
	private String hjdqh;
	@FieldDesc("户籍地详址")
	private String hjdxz;
	@FieldDesc("户籍地派出所")
	private String hjdpcs;
	@FieldDesc("户籍地派出所代码")
	private String hjdpcsdm;
	@FieldDesc("行政地区划代码")
	private String xzdqh;
	@FieldDesc("现住地详址")
	private String xzdxz;
	@FieldDesc("现住地派出所")
	private String xzdpcs;
	@FieldDesc("现住地派出所代码")
	private String xzdpcsdm;
	@FieldDesc("管辖单位")
	private String gxdw;
	@FieldDesc("管辖单位机构代码")
	private String gxdwjgdm;
	@FieldDesc("立案单位")
	private String ladwdm;
	@FieldDesc("立案单位机构代码")
	private String ladwjgdm;
	@FieldDesc("立案时间")
	private String zjlasj;
	@FieldDesc("部级重点人员入库时间")
	private String nrbjzdryksj;
	@FieldDesc("重点人员类别标记")
	private String zdrylbbj;
	@FieldDesc("重点人员细类")
	private String zdryxl;
	@FieldDesc("有效性")
	private String yxx;
	@FieldDesc("记录新增时间")
	private String jlxzsj;
	@FieldDesc("记录撤销时间")
	private String jlcxsj;
	@FieldDesc("记录变更时间")
	private String jlbgsj;
	@FieldDesc("创建时间")
	private String createdate;
	@FieldDesc("ETL时间")
	private String etldate;
	@FieldDesc("18位身份证号")
	private String sfzh18;
	@FieldDesc("写实时间")
	private String xssj;
	@FieldDesc("省厅部门代码")
	private String stbmdm;
	@FieldDesc("市局部门代码")
	private String sjbmdm;
	@FieldDesc("分县局部门代码")
	private String fxjbmdm;
	@FieldDesc("派出所部门代码")
	private String pcsbmdm;
	@FieldDesc("责任区部门代码")
	private String zrqbmdm;
	@FieldDesc("是否提交过管辖权变更申请")
	private String sftjbgsq;
	@FieldDesc("上级是否拒绝过管辖权变更申请")
	private String sjsfjjbgsq;
	@FieldDesc("下级提交的退回申请审批是否同意")
	private String xjspsfty;
	@FieldDesc("操作部门")
	private String czbm;
	@FieldDesc("当前状态")
	private String dqzt;
	@FieldDesc("操作类别")
	private String czlb;
	@FieldDesc("操作日期")
	private String czrq;
	@FieldDesc("操作部门代码")
	private String czbmdm;
	@FieldDesc("是否在实有人口")
	private String sfsyrk;
	
	public String getSfsyrk() {
		return sfsyrk;
	}
	public void setSfsyrk(String sfsyrk) {
		this.sfsyrk = sfsyrk;
	}
	public String getCzbmdm() {
		return czbmdm;
	}
	public void setCzbmdm(String czbmdm) {
		this.czbmdm = czbmdm;
	}
	public String getZrqbmdm() {
		return zrqbmdm;
	}
	public void setZrqbmdm(String zrqbmdm) {
		this.zrqbmdm = zrqbmdm;
	}
	public String getCzbm() {
		return czbm;
	}
	public void setCzbm(String czbm) {
		this.czbm = czbm;
	}
	public String getDqzt() {
		return dqzt;
	}
	public void setDqzt(String dqzt) {
		this.dqzt = dqzt;
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
	public String getStbmdm() {
		return stbmdm;
	}
	public void setStbmdm(String stbmdm) {
		this.stbmdm = stbmdm;
	}
	public String getSjbmdm() {
		return sjbmdm;
	}
	public void setSjbmdm(String sjbmdm) {
		this.sjbmdm = sjbmdm;
	}
	public String getFxjbmdm() {
		return fxjbmdm;
	}
	public void setFxjbmdm(String fxjbmdm) {
		this.fxjbmdm = fxjbmdm;
	}
	public String getPcsbmdm() {
		return pcsbmdm;
	}
	public void setPcsbmdm(String pcsbmdm) {
		this.pcsbmdm = pcsbmdm;
	}
	public String getSftjbgsq() {
		return sftjbgsq;
	}
	public void setSftjbgsq(String sftjbgsq) {
		this.sftjbgsq = sftjbgsq;
	}
	public String getSjsfjjbgsq() {
		return sjsfjjbgsq;
	}
	public void setSjsfjjbgsq(String sjsfjjbgsq) {
		this.sjsfjjbgsq = sjsfjjbgsq;
	}
	public String getXjspsfty() {
		return xjspsfty;
	}
	public void setXjspsfty(String xjspsfty) {
		this.xjspsfty = xjspsfty;
	}
	public String getZdryid() {
		return zdryid;
	}
	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}
	public String getBjzdrybh() {
		return bjzdrybh;
	}
	public void setBjzdrybh(String bjzdrybh) {
		this.bjzdrybh = bjzdrybh;
	}
	
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXmpy() {
		return xmpy;
	}
	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}
	public String getWwxm() {
		return wwxm;
	}
	public void setWwxm(String wwxm) {
		this.wwxm = wwxm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getQtzjhm() {
		return qtzjhm;
	}
	public void setQtzjhm(String qtzjhm) {
		this.qtzjhm = qtzjhm;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getHjdqh() {
		return hjdqh;
	}
	public void setHjdqh(String hjdqh) {
		this.hjdqh = hjdqh;
	}
	public String getHjdxz() {
		return hjdxz;
	}
	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}
	public String getHjdpcs() {
		return hjdpcs;
	}
	public void setHjdpcs(String hjdpcs) {
		this.hjdpcs = hjdpcs;
	}
	public String getHjdpcsdm() {
		return hjdpcsdm;
	}
	public void setHjdpcsdm(String hjdpcsdm) {
		this.hjdpcsdm = hjdpcsdm;
	}
	public String getXzdqh() {
		return xzdqh;
	}
	public void setXzdqh(String xzdqh) {
		this.xzdqh = xzdqh;
	}
	public String getXzdxz() {
		return xzdxz;
	}
	public void setXzdxz(String xzdxz) {
		this.xzdxz = xzdxz;
	}
	public String getXzdpcs() {
		return xzdpcs;
	}
	public void setXzdpcs(String xzdpcs) {
		this.xzdpcs = xzdpcs;
	}
	public String getXzdpcsdm() {
		return xzdpcsdm;
	}
	public void setXzdpcsdm(String xzdpcsdm) {
		this.xzdpcsdm = xzdpcsdm;
	}
	public String getGxdw() {
		return gxdw;
	}
	public void setGxdw(String gxdw) {
		this.gxdw = gxdw;
	}
	public String getGxdwjgdm() {
		return gxdwjgdm;
	}
	public void setGxdwjgdm(String gxdwjgdm) {
		this.gxdwjgdm = gxdwjgdm;
	}
	public String getLadwdm() {
		return ladwdm;
	}
	public void setLadwdm(String ladwdm) {
		this.ladwdm = ladwdm;
	}
	public String getLadwjgdm() {
		return ladwjgdm;
	}
	public void setLadwjgdm(String ladwjgdm) {
		this.ladwjgdm = ladwjgdm;
	}
	public String getZjlasj() {
		return zjlasj;
	}
	public void setZjlasj(String zjlasj) {
		this.zjlasj = zjlasj;
	}
	public String getNrbjzdryksj() {
		return nrbjzdryksj;
	}
	public void setNrbjzdryksj(String nrbjzdryksj) {
		this.nrbjzdryksj = nrbjzdryksj;
	}
	public String getZdrylbbj() {
		return zdrylbbj;
	}
	public void setZdrylbbj(String zdrylbbj) {
		this.zdrylbbj = zdrylbbj;
	}
	public String getZdryxl() {
		return zdryxl;
	}
	public void setZdryxl(String zdryxl) {
		this.zdryxl = zdryxl;
	}
	public String getYxx() {
		return yxx;
	}
	public void setYxx(String yxx) {
		this.yxx = yxx;
	}
	public String getJlxzsj() {
		return jlxzsj;
	}
	public void setJlxzsj(String jlxzsj) {
		this.jlxzsj = jlxzsj;
	}
	public String getJlcxsj() {
		return jlcxsj;
	}
	public void setJlcxsj(String jlcxsj) {
		this.jlcxsj = jlcxsj;
	}
	public String getJlbgsj() {
		return jlbgsj;
	}
	public void setJlbgsj(String jlbgsj) {
		this.jlbgsj = jlbgsj;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getEtldate() {
		return etldate;
	}
	public void setEtldate(String etldate) {
		this.etldate = etldate;
	}
	public String getSfzh18() {
		return sfzh18;
	}
	public void setSfzh18(String sfzh18) {
		this.sfzh18 = sfzh18;
	}
	public String getXssj() {
		return xssj;
	}
	public void setXssj(String xssj) {
		this.xssj = xssj;
	}
	
	

}
