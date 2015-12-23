package com.founder.zdrygl.base.vo;

import java.io.Serializable;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.zdryVO.java]
 * @ClassName: [zdryVO]
 * @Description: [重点人口视图对象，用于重点人员业务提交等]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-12 上午9:30:08]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午9:30:08，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public class ZdryWorkflowVO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	String zdryId;// 重点人员id
	
	String zdryName;// 重点人员名称
	
	String workflowId; // 任务id
	
	String executionId; //流程实例id
	
	String processInstanceId; //流程实例id
	
	String pocessDefinitionId;
	
	String splx;  //审批类型
	
	String sqlx;  //审批类型
	
	String sqlxdm;  //审批类型
	
	String zdrylx;//人员管理类型
	
	String createTime;//申请时间
	
	String sqrId;  //申请人ID
	
	String sqrName;  //申请人名称
	
	String spjg;  //审批结果
	
	String spyj;  //审批结果
	
	String sqyj;  //申请意见
	
	String nextSpOrgCode;//下级审批部门Code
	
	String nextSpposId;//下级审批岗位id
	
	String nextSppos;//下级审批岗位编码
	
	String nextSpUserId;//下级审批人员id

	
	public String getNextSppos() {
		return nextSppos;
	}

	public void setNextSppos(String nextSppos) {
		this.nextSppos = nextSppos;
	}

	public String getNextSpOrgCode() {
		return nextSpOrgCode;
	}

	public void setNextSpOrgCode(String nextSpOrgCode) {
		this.nextSpOrgCode = nextSpOrgCode;
	}

	public String getNextSpposId() {
		return nextSpposId;
	}

	public void setNextSpposId(String nextSpposId) {
		this.nextSpposId = nextSpposId;
	}

	public String getNextSpUserId() {
		return nextSpUserId;
	}

	public void setNextSpUserId(String nextSpUserId) {
		this.nextSpUserId = nextSpUserId;
	}

	String approvalMethod  ;//审批执行方法名称




	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getPocessDefinitionId() {
		return pocessDefinitionId;
	}

	public void setPocessDefinitionId(String pocessDefinitionId) {
		this.pocessDefinitionId = pocessDefinitionId;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getSpyj() {
		return spyj;
	}

	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}

	public String getSqlx() {
		return sqlx;
	}

	public void setSqlx(String sqlx) {
		this.sqlx = sqlx;
	}

	public String getSqlxdm() {
		return sqlxdm;
	}

	public void setSqlxdm(String sqlxdm) {
		this.sqlxdm = sqlxdm;
	}

	public String getApprovalMethod() {
		return approvalMethod;
	}

	public void setApprovalMethod(String approvalMethod) {
		this.approvalMethod = approvalMethod;
	}

	public String getSpjg() {
		return spjg;
	}

	public void setSpjg(String spjg) {
		this.spjg = spjg;
	}

	public String getZdryName() {
		return zdryName;
	}

	public void setZdryName(String zdryName) {
		this.zdryName = zdryName;
	}

	public String getSqrName() {
		return sqrName;
	}

	public void setSqrName(String sqrName) {
		this.sqrName = sqrName;
	}

	public String getZdryId() {
		return zdryId;
	}

	public void setZdryId(String zdryId) {
		this.zdryId = zdryId;
	}

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getSplx() {
		return splx;
	}

	public void setSplx(String splx) {
		this.splx = splx;
	}

	public String getZdrylx() {
		return zdrylx;
	}

	public void setZdrylx(String zdrylx) {
		this.zdrylx = zdrylx;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSqrId() {
		return sqrId;
	}

	public void setSqrId(String sqrId) {
		this.sqrId = sqrId;
	}

	public String getSqyj() {
		return sqyj;
	}

	public void setSqyj(String sqyj) {
		this.sqyj = sqyj;
	}
	
	
	
}
