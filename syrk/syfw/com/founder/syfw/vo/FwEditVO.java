package com.founder.syfw.vo;

import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.Fwjbxxb;

public class FwEditVO {
	
	//核实
	private String isCheck;
	private String hsid;
	// end
	
	private Fwjbxxb fwjbxxb = new Fwjbxxb();;
	
	public String getHsid() {
		return hsid;
	}

	public void setHsid(String hsid) {
		this.hsid = hsid;
	}

	private Czfwxxb czfwxxb = new Czfwxxb();
	
	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	public Fwjbxxb getFwjbxxb() {
		return fwjbxxb;
	}

	public void setFwjbxxb(Fwjbxxb fwjbxxb) {
		this.fwjbxxb = fwjbxxb;
	}

	public Czfwxxb getCzfwxxb() {
		return czfwxxb;
	}

	public void setCzfwxxb(Czfwxxb czfwxxb) {
		this.czfwxxb = czfwxxb;
	}
	
	

}
