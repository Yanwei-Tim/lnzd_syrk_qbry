package com.founder.syfw.vo;

import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

public class SyfwListVo extends BaseEntity {
 
	    //实有房屋核实 begin
		//syfw_fwjbxxb,syfw_czfwxxb
		private String isCheck;
		private String hs_status;
		private String hs_person;
		private String hs_sj;
		private String hsid;
		
		@FieldDesc("FWCQXZZLDM")private String fwcqxzzldm;
		@FieldDesc("FWJS")private Long fwjs;
		@FieldDesc("FWMJ_MJPFM")private Long fwmj_mjpfm;
		@FieldDesc("FWCQZH")private String fwcqzh;
		@FieldDesc("FZ_RYID")private String fz_ryid;
		@FieldDesc("FZ_CYZJDM")private String fz_cyzjdm;
		@FieldDesc("FZ_WWX")private String fz_wwx;
		@FieldDesc("FZ_WWM")private String fz_wwm;
		@FieldDesc("FZ_LXDH")private String fz_lxdh;
		@FieldDesc("TGR_RYID")private String tgr_ryid;
		@FieldDesc("TGR_CYZJDM")private String tgr_cyzjdm;
		@FieldDesc("TGR_WWX")private String tgr_wwx;
		@FieldDesc("TGR_WWM")private String tgr_wwm;
		@FieldDesc("TGR_LXDH")private String tgr_lxdh;
		@FieldDesc("TGR_YFZGX_RYGXDM")private String tgr_yfzgx_rygxdm;
		@FieldDesc("FWSSDW_DWID")private String fwssdw_dwid;
		@FieldDesc("FWDZ_DZID")private String fwdz_dzid;
		@FieldDesc("FWDZ_XZQHDM")private String fwdz_xzqhdm;
		@FieldDesc("FWDZ_MLPDM")private String fwdz_mlpdm;
		@FieldDesc("FWDZ_MLPXZ")private String fwdz_mlpxz;
		@FieldDesc("SS2JBMDM")private String ss2jbmdm;
		@FieldDesc("SS3JBMDM")private String ss3jbmdm;
		@FieldDesc("备注")private String bz;
		@FieldDesc("XT_CJSJ")private String xt_cjsj;
		@FieldDesc("XT_LRSJ")private String xt_lrsj;
		@FieldDesc("XT_LRRXM")private String xt_lrrxm;
		@FieldDesc("XT_LRRID")private String xt_lrrid;
		@FieldDesc("XT_LRRBM")private String xt_lrrbm;
		@FieldDesc("XT_LRRBMID")private String xt_lrrbmid;
		@FieldDesc("XT_LRIP")private String xt_lrip;
		@FieldDesc("XT_ZHXGSJ")private String xt_zhxgsj;
		@FieldDesc("XT_ZHXGRXM")private String xt_zhxgrxm;
		@FieldDesc("XT_ZHXGRID")private String xt_zhxgrid;
		@FieldDesc("XT_ZHXGRBM")private String xt_zhxgrbm;
		@FieldDesc("XT_ZHXGRBMID")private String xt_zhxgrbmid;
		@FieldDesc("XT_ZHXGIP")private String xt_zhxgip;
		@FieldDesc("XT_ZXBZ")private String xt_zxbz;
		@FieldDesc("XT_ZXYY")private String xt_zxyy;
		@FieldDesc("房屋ID")private String fwid;
		@FieldDesc("出租人_人员ID")private String czur_ryid;
		@FieldDesc("出租人_姓名")private String czur_xm;
		@FieldDesc("出租人_证件种类")private String czur_cyzjdm;
		@FieldDesc("出租人_证件号码")private String czur_zjhm;
		@FieldDesc("出租人_外文姓")private String czur_wwx;
		@FieldDesc("出租人_外文名")private String czur_wwm;
		@FieldDesc("出租人_联系电话")private String czur_lxdh;
		@FieldDesc("出租人_与房主关系_人员关系代码")private String czur_yfzgx_rygxdm;
		@FieldDesc("治安责任人_姓名")private String zazrr_xm;
		@FieldDesc("治安责任人_ID")private String zazrr_id;
		@FieldDesc("责任书_签订_日期")private String zrs_qd_rq;
		@FieldDesc("出租_面积（平方米）")private Long cz_mjpfm;
		@FieldDesc("出租_房间数")private Long cz_fjs;
		@FieldDesc("出租_居住人数")private Long cz_jzrs;
		@FieldDesc("出租_日期")private String cz_rq;
		@FieldDesc("租金(元/月)")private Long zj;
		//实有房屋核实 end
		
	private String id;
	private String fwlbdm;
	private String sfczfw;
	private String fwdz_dzxz;
	private String ss4jbmdm;
	private String fwytdm;
	
	private String fz_zjhm;
	private String fz_xm;
	private String tgr_zjhm;
	private String tgr_xm;
	private String fwssdw_dwmc;
	private String fwdz_zbx;
	private String fwdz_zby;
	//地图查询的相关字段
	private String zbx;
	private String zby;
	private String mapRadius;
	private String zbz;
	//空间查询坐标值
    private String drawZbz;
	//空间查询类型
    //   drawCircle  设置当前地图操作状态为绘制圆形状态
    //	 drawRect    设置当前地图操作状态为绘制矩形状态
    //   drawPolygon 设置当前地图操作状态为绘制多边形状态
	private String drawType;
	//空间查询半径弧度值
    private String drawRadius;
	//地图图层ID
	private int drawSrid;
	//标准地址表的一些信息
	private String sfcj;
	private String dzqc;
	private String dzqcpy;
	private String jzwid;
	private String bzdzid;
	private String condition;
	
	public String getHsid() {
		return hsid;
	}
	public void setHsid(String hsid) {
		this.hsid = hsid;
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
	public String getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
	public String getFwcqxzzldm() {
		return fwcqxzzldm;
	}
	public void setFwcqxzzldm(String fwcqxzzldm) {
		this.fwcqxzzldm = fwcqxzzldm;
	}
	public Long getFwjs() {
		return fwjs;
	}
	public void setFwjs(Long fwjs) {
		this.fwjs = fwjs;
	}
	public Long getFwmj_mjpfm() {
		return fwmj_mjpfm;
	}
	public void setFwmj_mjpfm(Long fwmj_mjpfm) {
		this.fwmj_mjpfm = fwmj_mjpfm;
	}
	public String getFwcqzh() {
		return fwcqzh;
	}
	public void setFwcqzh(String fwcqzh) {
		this.fwcqzh = fwcqzh;
	}
	public String getFz_ryid() {
		return fz_ryid;
	}
	public void setFz_ryid(String fz_ryid) {
		this.fz_ryid = fz_ryid;
	}
	public String getFz_cyzjdm() {
		return fz_cyzjdm;
	}
	public void setFz_cyzjdm(String fz_cyzjdm) {
		this.fz_cyzjdm = fz_cyzjdm;
	}
	public String getFz_wwx() {
		return fz_wwx;
	}
	public void setFz_wwx(String fz_wwx) {
		this.fz_wwx = fz_wwx;
	}
	public String getFz_wwm() {
		return fz_wwm;
	}
	public void setFz_wwm(String fz_wwm) {
		this.fz_wwm = fz_wwm;
	}
	public String getFz_lxdh() {
		return fz_lxdh;
	}
	public void setFz_lxdh(String fz_lxdh) {
		this.fz_lxdh = fz_lxdh;
	}
	public String getTgr_ryid() {
		return tgr_ryid;
	}
	public void setTgr_ryid(String tgr_ryid) {
		this.tgr_ryid = tgr_ryid;
	}
	public String getTgr_cyzjdm() {
		return tgr_cyzjdm;
	}
	public void setTgr_cyzjdm(String tgr_cyzjdm) {
		this.tgr_cyzjdm = tgr_cyzjdm;
	}
	public String getTgr_wwx() {
		return tgr_wwx;
	}
	public void setTgr_wwx(String tgr_wwx) {
		this.tgr_wwx = tgr_wwx;
	}
	public String getTgr_wwm() {
		return tgr_wwm;
	}
	public void setTgr_wwm(String tgr_wwm) {
		this.tgr_wwm = tgr_wwm;
	}
	public String getTgr_lxdh() {
		return tgr_lxdh;
	}
	public void setTgr_lxdh(String tgr_lxdh) {
		this.tgr_lxdh = tgr_lxdh;
	}
	public String getTgr_yfzgx_rygxdm() {
		return tgr_yfzgx_rygxdm;
	}
	public void setTgr_yfzgx_rygxdm(String tgr_yfzgx_rygxdm) {
		this.tgr_yfzgx_rygxdm = tgr_yfzgx_rygxdm;
	}
	public String getFwssdw_dwid() {
		return fwssdw_dwid;
	}
	public void setFwssdw_dwid(String fwssdw_dwid) {
		this.fwssdw_dwid = fwssdw_dwid;
	}
	public String getFwdz_dzid() {
		return fwdz_dzid;
	}
	public void setFwdz_dzid(String fwdz_dzid) {
		this.fwdz_dzid = fwdz_dzid;
	}
	public String getFwdz_xzqhdm() {
		return fwdz_xzqhdm;
	}
	public void setFwdz_xzqhdm(String fwdz_xzqhdm) {
		this.fwdz_xzqhdm = fwdz_xzqhdm;
	}
	public String getFwdz_mlpdm() {
		return fwdz_mlpdm;
	}
	public void setFwdz_mlpdm(String fwdz_mlpdm) {
		this.fwdz_mlpdm = fwdz_mlpdm;
	}
	public String getFwdz_mlpxz() {
		return fwdz_mlpxz;
	}
	public void setFwdz_mlpxz(String fwdz_mlpxz) {
		this.fwdz_mlpxz = fwdz_mlpxz;
	}
	public String getSs2jbmdm() {
		return ss2jbmdm;
	}
	public void setSs2jbmdm(String ss2jbmdm) {
		this.ss2jbmdm = ss2jbmdm;
	}
	public String getSs3jbmdm() {
		return ss3jbmdm;
	}
	public void setSs3jbmdm(String ss3jbmdm) {
		this.ss3jbmdm = ss3jbmdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXt_cjsj() {
		return xt_cjsj;
	}
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	public String getXt_lrip() {
		return xt_lrip;
	}
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}
	public String getFwid() {
		return fwid;
	}
	public void setFwid(String fwid) {
		this.fwid = fwid;
	}
	public String getCzur_ryid() {
		return czur_ryid;
	}
	public void setCzur_ryid(String czur_ryid) {
		this.czur_ryid = czur_ryid;
	}
	public String getCzur_xm() {
		return czur_xm;
	}
	public void setCzur_xm(String czur_xm) {
		this.czur_xm = czur_xm;
	}
	public String getCzur_cyzjdm() {
		return czur_cyzjdm;
	}
	public void setCzur_cyzjdm(String czur_cyzjdm) {
		this.czur_cyzjdm = czur_cyzjdm;
	}
	public String getCzur_zjhm() {
		return czur_zjhm;
	}
	public void setCzur_zjhm(String czur_zjhm) {
		this.czur_zjhm = czur_zjhm;
	}
	public String getCzur_wwx() {
		return czur_wwx;
	}
	public void setCzur_wwx(String czur_wwx) {
		this.czur_wwx = czur_wwx;
	}
	public String getCzur_wwm() {
		return czur_wwm;
	}
	public void setCzur_wwm(String czur_wwm) {
		this.czur_wwm = czur_wwm;
	}
	public String getCzur_lxdh() {
		return czur_lxdh;
	}
	public void setCzur_lxdh(String czur_lxdh) {
		this.czur_lxdh = czur_lxdh;
	}
	public String getCzur_yfzgx_rygxdm() {
		return czur_yfzgx_rygxdm;
	}
	public void setCzur_yfzgx_rygxdm(String czur_yfzgx_rygxdm) {
		this.czur_yfzgx_rygxdm = czur_yfzgx_rygxdm;
	}
	public String getZazrr_xm() {
		return zazrr_xm;
	}
	public void setZazrr_xm(String zazrr_xm) {
		this.zazrr_xm = zazrr_xm;
	}
	public String getZazrr_id() {
		return zazrr_id;
	}
	public void setZazrr_id(String zazrr_id) {
		this.zazrr_id = zazrr_id;
	}
	public String getZrs_qd_rq() {
		return zrs_qd_rq;
	}
	public void setZrs_qd_rq(String zrs_qd_rq) {
		this.zrs_qd_rq = zrs_qd_rq;
	}
	public Long getCz_mjpfm() {
		return cz_mjpfm;
	}
	public void setCz_mjpfm(Long cz_mjpfm) {
		this.cz_mjpfm = cz_mjpfm;
	}
	public Long getCz_fjs() {
		return cz_fjs;
	}
	public void setCz_fjs(Long cz_fjs) {
		this.cz_fjs = cz_fjs;
	}
	public Long getCz_jzrs() {
		return cz_jzrs;
	}
	public void setCz_jzrs(Long cz_jzrs) {
		this.cz_jzrs = cz_jzrs;
	}
	public String getCz_rq() {
		return cz_rq;
	}
	public void setCz_rq(String cz_rq) {
		this.cz_rq = cz_rq;
	}
	public Long getZj() {
		return zj;
	}
	public void setZj(Long zj) {
		this.zj = zj;
	}
	public String getFwytdm() {
		return fwytdm;
	}
	public void setFwytdm(String fwytdm) {
		this.fwytdm = fwytdm;
	}
	public String getFz_zjhm() {
		return fz_zjhm;
	}
	public void setFz_zjhm(String fz_zjhm) {
		this.fz_zjhm = fz_zjhm;
	}
	public String getTgr_zjhm() {
		return tgr_zjhm;
	}
	public void setTgr_zjhm(String tgr_zjhm) {
		this.tgr_zjhm = tgr_zjhm;
	}
	public String getFwdz_zbx() {
		return fwdz_zbx;
	}
	public void setFwdz_zbx(String fwdz_zbx) {
		this.fwdz_zbx = fwdz_zbx;
	}
	public String getFwdz_zby() {
		return fwdz_zby;
	}
	public void setFwdz_zby(String fwdz_zby) {
		this.fwdz_zby = fwdz_zby;
	}
	public String getTgr_xm() {
		return tgr_xm;
	}
	public void setTgr_xm(String tgr_xm) {
		this.tgr_xm = tgr_xm;
	}
	public String getFwssdw_dwmc() {
		return fwssdw_dwmc;
	}
	public void setFwssdw_dwmc(String fwssdw_dwmc) {
		this.fwssdw_dwmc = fwssdw_dwmc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFwlbdm() {
		return fwlbdm;
	}
	public void setFwlbdm(String fwlbdm) {
		this.fwlbdm = fwlbdm;
	}
	public String getFz_xm() {
		return fz_xm;
	}
	public void setFz_xm(String fz_xm) {
		this.fz_xm = fz_xm;
	}
	public String getSfczfw() {
		return sfczfw;
	}
	public void setSfczfw(String sfczfw) {
		this.sfczfw = sfczfw;
	}
	
	public String getFwdz_dzxz() {
		return fwdz_dzxz;
	}
	public void setFwdz_dzxz(String fwdz_dzxz) {
		this.fwdz_dzxz = fwdz_dzxz;
	}
	public String getSs4jbmdm() {
		return ss4jbmdm;
	}
	public void setSs4jbmdm(String ss4jbmdm) {
		this.ss4jbmdm = ss4jbmdm;
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
	public String getDrawZbz() {
		return drawZbz;
	}
	public void setDrawZbz(String drawZbz) {
		this.drawZbz = drawZbz;
	}
	public String getDrawType() {
		return drawType;
	}
	public void setDrawType(String drawType) {
		this.drawType = drawType;
	}
	public String getDrawRadius() {
		return drawRadius;
	}
	public void setDrawRadius(String drawRadius) {
		this.drawRadius = drawRadius;
	}
	public int getDrawSrid() {
		return drawSrid;
	}
	public void setDrawSrid(int drawSrid) {
		this.drawSrid = drawSrid;
	}
	public String getSfcj() {
		return sfcj;
	}
	public void setSfcj(String sfcj) {
		this.sfcj = sfcj;
	}
	public String getDzqc() {
		return dzqc;
	}
	public void setDzqc(String dzqc) {
		this.dzqc = dzqc;
	}
	public String getDzqcpy() {
		return dzqcpy;
	}
	public void setDzqcpy(String dzqcpy) {
		this.dzqcpy = dzqcpy;
	}
	public String getJzwid() {
		return jzwid;
	}
	public void setJzwid(String jzwid) {
		this.jzwid = jzwid;
	}
	public String getBzdzid() {
		return bzdzid;
	}
	public void setBzdzid(String bzdzid) {
		this.bzdzid = bzdzid;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}
