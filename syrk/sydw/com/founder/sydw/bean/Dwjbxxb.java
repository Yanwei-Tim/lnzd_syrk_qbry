package com.founder.sydw.bean;

import java.io.Serializable;

import org.springframework.http.HttpEntity;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_DWJBXXB", pk = "id", logQueryField = "id")
public class Dwjbxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("单位ID")
	private String id;
	@FieldDesc("单位类别代码 ")
	private String dwlbdm;
	@FieldDesc("上级单位ID ")
	private String sjdwid;
	@FieldDesc("管理部门ID")
	private String glbmid;
	@FieldDesc("管理派出所ID")
	private String glpcsid;
	@FieldDesc("管理分县局ID")
	private String glfxjid;
	@FieldDesc("单位编号")
	private String zagldwbm;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("是否办理营业执照代码")
	private String sfblyyzzdm;
	@FieldDesc("营业执照号")
	private String yyzzh;
	@FieldDesc("营业执照有效期_起始日期")
	private String yyzzyxq_qsrq;
	@FieldDesc("营业执照有效期_截止日期")
	private String yyzzyxq_jzrq;
	@FieldDesc("营业执照发证机关ID")
	private String yyzzfzjgid;
	@FieldDesc("营业执照发证机关")
	private String yyzzfzjg;
	@FieldDesc("注册资金")
	private String zczb;
	@FieldDesc("组织机构代码")
	private String zzjgdm;
	@FieldDesc("组织机构名称")
	private String zzjgmc;
	@FieldDesc("税务登记号码")
	private String swdjhm;
	@FieldDesc("经营范围（主营）")
	private String jyfwzy;
	@FieldDesc("经营范围（兼营）")
	private String jyfwjy;
	@FieldDesc("经营方式代码")
	private String jyfsdm;
	@FieldDesc("经营面积_面积（平方米）")
	private String jymj_mjpfm;
	@FieldDesc("经济类型代码")
	private String jjlxdm;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("传真")
	private String czhm;
	@FieldDesc("是否有房屋鉴定代码")
	private String sfyfwjddm;
	@FieldDesc("鉴定时间")
	private String jdsj;
	@FieldDesc("是否外资单位代码")
	private String sfwzdwdm;
	@FieldDesc("单位状态代码")
	private String dwztdm;
	@FieldDesc("核定容纳人数")
	private String hdrnrs;
	@FieldDesc("营业时间")
	private String yysj;
	@FieldDesc("是否周期性营业代码")
	private String sfzqxydm;
	@FieldDesc("周期性营业规律")
	private String zqxyygl;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("地址-单位地址代码")
	private String dz_dwdzdm;
	@FieldDesc("地址-单位地址省市县代码")
	private String dz_dwdzssxdm;
	@FieldDesc("地址-单位地址详址")
	private String dz_dwdzxz;
	@FieldDesc("地址-单位地址门楼牌代码")
	private String dz_dwdzmlpdm;
	@FieldDesc("地址-单位地址门楼牌详址")
	private String dz_dwdzmlpxz;
	@FieldDesc("地址-单位坐标X")
	private String dz_dwzbx;
	@FieldDesc("地址-单位坐标Y")
	private String dz_dwzby;
	@FieldDesc("是否涉外单位代码")
	private String sfswdwdm;
	@FieldDesc("是否有消防鉴定代码")
	private String sfyxfjddm;
	@FieldDesc("开业日期")
	private String kyrq;
	@FieldDesc("重点单位标识")
	private String zddwbs;
	@FieldDesc("是否周期性营业代码")
	private String sfzqxyydm;
	@FieldDesc("录入标识   0：系统新增   1：从其他系统抽取     默认：0")
	private String xt_lrbz;
	@FieldDesc("核实时间")
	private String xt_hssj;
	@FieldDesc("单位英文名称")
	private String dwywmc;
	@FieldDesc("单位英文缩写")
	private String dwywsx;
	@FieldDesc("行业类别代码")
	private String hylbdm;
	@FieldDesc("停业日期")
	private String tyrq01;
	@FieldDesc("网址")
	private String wz;
	@FieldDesc("空间图层的srid")
	private int srid;
	@FieldDesc("查询类型")
	private String type;
	@FieldDesc("坐标x")
	private String zbx;
	@FieldDesc("坐标y")
	private String zby;
	@FieldDesc("半径")
	private String mapRadius;
	@FieldDesc("坐标值")
	private String zbz;
	private HttpEntity<byte[]> zpfj;
	private String condition;
	private String cxfs;
	private String dwbm;
	private String sjdwmc;
	@FieldDesc("地址描述_坐标X")
	private String dzms_zbx;
	@FieldDesc("地址描述_坐标Y")
	private String dzms_zby;
	@FieldDesc("地址描述_所属责任区代码")
	private String dzms_sszrqdm;
	private String dzms_sszrqmc;
	@FieldDesc("地址描述_所属派出所代码")
	private String dzms_sspcsdm;
	private String dzms_sspcsmc;
	@FieldDesc("地址描述")
	private String dzms;
	@FieldDesc("层户地址")
	private String dzms_chdz;
	// 地址描述_单位地址门楼牌代码
	private String dzms_dwdzmlpdm;
	// 地址描述_单位地址门楼牌详址
	private String dzms_dwdzmlpxz;
	// 地址状态
	private String dwdzzt;
	/**
	 * @return the sjdwmc
	 */
	// @star新增是否安装治安管理系统开始
	@FieldDesc(" 是否安装治安管理系统")
	private String sfazzaglxxxt;

	private String isCheck;
	private String hs_status;
	private String hs_person;
	private String hs_sj;
	@FieldDesc("房间合并")
	private String shbs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDwlbdm() {
		return dwlbdm;
	}

	public void setDwlbdm(String dwlbdm) {
		this.dwlbdm = dwlbdm;
	}

	public String getSjdwid() {
		return sjdwid;
	}

	public void setSjdwid(String sjdwid) {
		this.sjdwid = sjdwid;
	}

	public String getGlbmid() {
		return glbmid;
	}

	public void setGlbmid(String glbmid) {
		this.glbmid = glbmid;
	}

	public String getGlpcsid() {
		return glpcsid;
	}

	public void setGlpcsid(String glpcsid) {
		this.glpcsid = glpcsid;
	}

	public String getGlfxjid() {
		return glfxjid;
	}

	public void setGlfxjid(String glfxjid) {
		this.glfxjid = glfxjid;
	}

	public String getZagldwbm() {
		return zagldwbm;
	}

	public void setZagldwbm(String zagldwbm) {
		this.zagldwbm = zagldwbm;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getSfblyyzzdm() {
		return sfblyyzzdm;
	}

	public void setSfblyyzzdm(String sfblyyzzdm) {
		this.sfblyyzzdm = sfblyyzzdm;
	}

	public String getYyzzh() {
		return yyzzh;
	}

	public void setYyzzh(String yyzzh) {
		this.yyzzh = yyzzh;
	}

	public String getYyzzyxq_qsrq() {
		return yyzzyxq_qsrq;
	}

	public void setYyzzyxq_qsrq(String yyzzyxq_qsrq) {
		this.yyzzyxq_qsrq = yyzzyxq_qsrq;
	}

	public String getYyzzyxq_jzrq() {
		return yyzzyxq_jzrq;
	}

	public void setYyzzyxq_jzrq(String yyzzyxq_jzrq) {
		this.yyzzyxq_jzrq = yyzzyxq_jzrq;
	}

	public String getYyzzfzjgid() {
		return yyzzfzjgid;
	}

	public void setYyzzfzjgid(String yyzzfzjgid) {
		this.yyzzfzjgid = yyzzfzjgid;
	}

	public String getYyzzfzjg() {
		return yyzzfzjg;
	}

	public void setYyzzfzjg(String yyzzfzjg) {
		this.yyzzfzjg = yyzzfzjg;
	}

	public String getZczb() {
		return zczb;
	}

	public void setZczb(String zczb) {
		this.zczb = zczb;
	}

	public String getZzjgdm() {
		return zzjgdm;
	}

	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}

	public String getZzjgmc() {
		return zzjgmc;
	}

	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}

	public String getSwdjhm() {
		return swdjhm;
	}

	public void setSwdjhm(String swdjhm) {
		this.swdjhm = swdjhm;
	}

	public String getJyfwzy() {
		return jyfwzy;
	}

	public void setJyfwzy(String jyfwzy) {
		this.jyfwzy = jyfwzy;
	}

	public String getJyfwjy() {
		return jyfwjy;
	}

	public void setJyfwjy(String jyfwjy) {
		this.jyfwjy = jyfwjy;
	}

	public String getJyfsdm() {
		return jyfsdm;
	}

	public void setJyfsdm(String jyfsdm) {
		this.jyfsdm = jyfsdm;
	}

	public String getJymj_mjpfm() {
		return jymj_mjpfm;
	}

	public void setJymj_mjpfm(String jymj_mjpfm) {
		this.jymj_mjpfm = jymj_mjpfm;
	}

	public String getJjlxdm() {
		return jjlxdm;
	}

	public void setJjlxdm(String jjlxdm) {
		this.jjlxdm = jjlxdm;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getCzhm() {
		return czhm;
	}

	public void setCzhm(String czhm) {
		this.czhm = czhm;
	}

	public String getSfyfwjddm() {
		return sfyfwjddm;
	}

	public void setSfyfwjddm(String sfyfwjddm) {
		this.sfyfwjddm = sfyfwjddm;
	}

	public String getJdsj() {
		return jdsj;
	}

	public void setJdsj(String jdsj) {
		this.jdsj = jdsj;
	}

	public String getSfwzdwdm() {
		return sfwzdwdm;
	}

	public void setSfwzdwdm(String sfwzdwdm) {
		this.sfwzdwdm = sfwzdwdm;
	}

	public String getDwztdm() {
		return dwztdm;
	}

	public void setDwztdm(String dwztdm) {
		this.dwztdm = dwztdm;
	}

	public String getHdrnrs() {
		return hdrnrs;
	}

	public void setHdrnrs(String hdrnrs) {
		this.hdrnrs = hdrnrs;
	}

	public String getYysj() {
		return yysj;
	}

	public void setYysj(String yysj) {
		this.yysj = yysj;
	}

	public String getSfzqxydm() {
		return sfzqxydm;
	}

	public void setSfzqxydm(String sfzqxydm) {
		this.sfzqxydm = sfzqxydm;
	}

	public String getZqxyygl() {
		return zqxyygl;
	}

	public void setZqxyygl(String zqxyygl) {
		this.zqxyygl = zqxyygl;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getDz_dwdzdm() {
		return dz_dwdzdm;
	}

	public void setDz_dwdzdm(String dz_dwdzdm) {
		this.dz_dwdzdm = dz_dwdzdm;
	}

	public String getDz_dwdzssxdm() {
		return dz_dwdzssxdm;
	}

	public void setDz_dwdzssxdm(String dz_dwdzssxdm) {
		this.dz_dwdzssxdm = dz_dwdzssxdm;
	}

	public String getDz_dwdzxz() {
		return dz_dwdzxz;
	}

	public void setDz_dwdzxz(String dz_dwdzxz) {
		this.dz_dwdzxz = dz_dwdzxz;
	}

	public String getDz_dwdzmlpdm() {
		return dz_dwdzmlpdm;
	}

	public void setDz_dwdzmlpdm(String dz_dwdzmlpdm) {
		this.dz_dwdzmlpdm = dz_dwdzmlpdm;
	}

	public String getDz_dwdzmlpxz() {
		return dz_dwdzmlpxz;
	}

	public void setDz_dwdzmlpxz(String dz_dwdzmlpxz) {
		this.dz_dwdzmlpxz = dz_dwdzmlpxz;
	}

	public String getDz_dwzbx() {
		return dz_dwzbx;
	}

	public void setDz_dwzbx(String dz_dwzbx) {
		this.dz_dwzbx = dz_dwzbx;
	}

	public String getDz_dwzby() {
		return dz_dwzby;
	}

	public void setDz_dwzby(String dz_dwzby) {
		this.dz_dwzby = dz_dwzby;
	}

	public String getSfswdwdm() {
		return sfswdwdm;
	}

	public void setSfswdwdm(String sfswdwdm) {
		this.sfswdwdm = sfswdwdm;
	}

	public String getSfyxfjddm() {
		return sfyxfjddm;
	}

	public void setSfyxfjddm(String sfyxfjddm) {
		this.sfyxfjddm = sfyxfjddm;
	}

	public String getKyrq() {
		return kyrq;
	}

	public void setKyrq(String kyrq) {
		this.kyrq = kyrq;
	}

	public String getZddwbs() {
		return zddwbs;
	}

	public void setZddwbs(String zddwbs) {
		this.zddwbs = zddwbs;
	}

	public String getSfzqxyydm() {
		return sfzqxyydm;
	}

	public void setSfzqxyydm(String sfzqxyydm) {
		this.sfzqxyydm = sfzqxyydm;
	}

	public String getXt_lrbz() {
		return xt_lrbz;
	}

	public void setXt_lrbz(String xt_lrbz) {
		this.xt_lrbz = xt_lrbz;
	}

	public String getXt_hssj() {
		return xt_hssj;
	}

	public void setXt_hssj(String xt_hssj) {
		this.xt_hssj = xt_hssj;
	}

	public String getDwywmc() {
		return dwywmc;
	}

	public void setDwywmc(String dwywmc) {
		this.dwywmc = dwywmc;
	}

	public String getDwywsx() {
		return dwywsx;
	}

	public void setDwywsx(String dwywsx) {
		this.dwywsx = dwywsx;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getTyrq01() {
		return tyrq01;
	}

	public void setTyrq01(String tyrq01) {
		this.tyrq01 = tyrq01;
	}

	public String getWz() {
		return wz;
	}

	public void setWz(String wz) {
		this.wz = wz;
	}

	public int getSrid() {
		return srid;
	}

	public void setSrid(int srid) {
		this.srid = srid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getZbx() {
		return zbx;
	}

	public void setZbx(String zbx) {
		this.zbx = zbx;
	}

	public String getZby() {
		return zby;
	}

	public void setZby(String zby) {
		this.zby = zby;
	}

	public String getMapRadius() {
		return mapRadius;
	}

	public void setMapRadius(String mapRadius) {
		this.mapRadius = mapRadius;
	}

	public String getZbz() {
		return zbz;
	}

	public void setZbz(String zbz) {
		this.zbz = zbz;
	}

	public HttpEntity<byte[]> getZpfj() {
		return zpfj;
	}

	public void setZpfj(HttpEntity<byte[]> zpfj) {
		this.zpfj = zpfj;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCxfs() {
		return cxfs;
	}

	public void setCxfs(String cxfs) {
		this.cxfs = cxfs;
	}

	public String getDwbm() {
		return dwbm;
	}

	public void setDwbm(String dwbm) {
		this.dwbm = dwbm;
	}

	public String getSjdwmc() {
		return sjdwmc;
	}

	public void setSjdwmc(String sjdwmc) {
		this.sjdwmc = sjdwmc;
	}

	public String getDzms_zbx() {
		return dzms_zbx;
	}

	public void setDzms_zbx(String dzms_zbx) {
		this.dzms_zbx = dzms_zbx;
	}

	public String getDzms_zby() {
		return dzms_zby;
	}

	public void setDzms_zby(String dzms_zby) {
		this.dzms_zby = dzms_zby;
	}

	public String getDzms_sszrqdm() {
		return dzms_sszrqdm;
	}

	public void setDzms_sszrqdm(String dzms_sszrqdm) {
		this.dzms_sszrqdm = dzms_sszrqdm;
	}

	public String getDzms_sszrqmc() {
		return dzms_sszrqmc;
	}

	public void setDzms_sszrqmc(String dzms_sszrqmc) {
		this.dzms_sszrqmc = dzms_sszrqmc;
	}

	public String getDzms_sspcsdm() {
		return dzms_sspcsdm;
	}

	public void setDzms_sspcsdm(String dzms_sspcsdm) {
		this.dzms_sspcsdm = dzms_sspcsdm;
	}

	public String getDzms_sspcsmc() {
		return dzms_sspcsmc;
	}

	public void setDzms_sspcsmc(String dzms_sspcsmc) {
		this.dzms_sspcsmc = dzms_sspcsmc;
	}

	public String getDzms() {
		return dzms;
	}

	public void setDzms(String dzms) {
		this.dzms = dzms;
	}

	public String getDzms_chdz() {
		return dzms_chdz;
	}

	public void setDzms_chdz(String dzms_chdz) {
		this.dzms_chdz = dzms_chdz;
	}

	public String getDzms_dwdzmlpdm() {
		return dzms_dwdzmlpdm;
	}

	public void setDzms_dwdzmlpdm(String dzms_dwdzmlpdm) {
		this.dzms_dwdzmlpdm = dzms_dwdzmlpdm;
	}

	public String getDzms_dwdzmlpxz() {
		return dzms_dwdzmlpxz;
	}

	public void setDzms_dwdzmlpxz(String dzms_dwdzmlpxz) {
		this.dzms_dwdzmlpxz = dzms_dwdzmlpxz;
	}

	public String getDwdzzt() {
		return dwdzzt;
	}

	public void setDwdzzt(String dwdzzt) {
		this.dwdzzt = dwdzzt;
	}

	public String getSfazzaglxxxt() {
		return sfazzaglxxxt;
	}

	public void setSfazzaglxxxt(String sfazzaglxxxt) {
		this.sfazzaglxxxt = sfazzaglxxxt;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public String getHs_status() {
		return hs_status;
	}

	public void setHs_status(String hs_status) {
		this.hs_status = hs_status;
	}

	public String getHs_person() {
		return hs_person;
	}

	public void setHs_person(String hs_person) {
		this.hs_person = hs_person;
	}

	public String getHs_sj() {
		return hs_sj;
	}

	public void setHs_sj(String hs_sj) {
		this.hs_sj = hs_sj;
	}

	public String getShbs() {
		return shbs;
	}

	public void setShbs(String shbs) {
		this.shbs = shbs;
	}

}