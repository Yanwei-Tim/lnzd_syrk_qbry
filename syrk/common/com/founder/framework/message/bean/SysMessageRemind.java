package com.founder.framework.message.bean;



public class SysMessageRemind extends SysMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**提醒日期*/
	private String txrq;
	/**业务id*/
	private String ywid;
	/**业务类型 ——存业务表的表名*/ 
	private String ywlx; 

	public String getTxrq() {
		return txrq;
	}

	public void setTxrq(String txrq) {
		this.txrq = txrq;
	}

	public String getYwid() {
		return ywid;
	}

	public void setYwid(String ywid) {
		this.ywid = ywid;
	}

	public String getYwlx() {
		return ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	
	
	
}
