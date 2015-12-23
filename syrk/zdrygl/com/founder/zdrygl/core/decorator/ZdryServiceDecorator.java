package com.founder.zdrygl.core.decorator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.message.MessageDict;
import com.founder.zdrygl.core.inteface.JwzhMessageService;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.ZOBean;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.decorator.ZdryServiceDecorator.java]  
 * @ClassName:    [ZdryServiceDecorator]   
 * @Description:  [重点人员业务服务装饰器]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年8月31日 下午3:52:17]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月31日 下午3:52:17，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Transactional
public abstract class ZdryServiceDecorator implements ZdryService{

	protected ZdryService zdryService;

	/**
	 * 流程启动对象
	 */
	private StartProcessInstance processInstance;
		
    @Autowired
	private JProcessDefinitionService processDefinitionService;
    
    @Autowired
    private JwzhMessageService jwzhMessageService;
    
    @Autowired
	private ZdryConstant zdryConstant;

	public ZdryServiceDecorator(ZdryService zdryService){
		this.zdryService = zdryService;
	}
	
	@Override
	public final void lg(SessionBean sessionBean , ZOBean entity){
		zdryService.lg(sessionBean, entity);
		setZdrylbdxId(entity);
		lg_(sessionBean,entity.getZdrylbdx());
		if(entity.getStartProcessInstance()!=null){
			entity.setProcessInstanceBusinessKey(entity.getZdryzb().getId());
			entity.getStartProcessInstance().getVariables().put("zdryId", entity.getZdryzbId());
			entity.getStartProcessInstance().getVariables().put("zdryZb", entity.getZdryzb());
			entity.getStartProcessInstance().getVariables().put("zdrycx", entity.getZdrycx());
			entity.getStartProcessInstance().getVariables().put("zdrylbdx", entity.getZdrylbdx());
			startProcessInstance(entity.getStartProcessInstance());
		}
	}

	@Override
	public final void lgSuccess(SessionBean sessionBean , ZOBean entity){
		zdryService.lgSuccess(sessionBean,entity);	
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());
		paraObj.put("result", "lgSuccess");
		paraObj.put("zdryId", entity.getZdryzbId());
		jwzhMessageService.sendMessage(MessageDict.ZDRYGL.LGSPJG,paraObj);
	}
	
	@Override
	public final void lgFail(SessionBean sessionBean, ZOBean entity) {
		zdryService.lgFail(sessionBean,entity);
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());
		paraObj.put("result", "lgFail");
		paraObj.put("zdryId", entity.getZdryzbId());
		jwzhMessageService.sendMessage(MessageDict.ZDRYGL.LGSPJG,paraObj);
	}
	
	@Override
	public final void cg(SessionBean sessionBean , ZOBean entity){
		zdryService.cg(sessionBean, entity);
		setZdrylbdxId(entity);
		cg_(sessionBean,entity.getZdrylbdx());
		if(entity.getStartProcessInstance()!=null){
			entity.setProcessInstanceBusinessKey(entity.getZdryzb().getId());
			entity.getStartProcessInstance().getVariables().put("zdryId", entity.getZdryzbId());
			entity.getStartProcessInstance().getVariables().put("zdryZb", entity.getZdryzb());
			entity.getStartProcessInstance().getVariables().put("zdrycx", entity.getZdrycx());
			entity.getStartProcessInstance().getVariables().put("zdrylbdx", entity.getZdrylbdx());
			startProcessInstance(entity.getStartProcessInstance());
		}
	}
	
	@Override
	public final void cgSuccess(SessionBean sessionBean , ZOBean entity) {
		zdryService.cgSuccess(sessionBean,entity);
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());
		paraObj.put("result", "cgSuccess");
		//jwzhMessageService.sendMessage(MessageDict.ZDRYGL.CGSPJG,paraObj);
	}

	@Override
	public final void cgFail(SessionBean sessionBean , ZOBean entity) {
		zdryService.cgFail(sessionBean,entity);
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());
		paraObj.put("result", "cgFail");
		//jwzhMessageService.sendMessage(MessageDict.ZDRYGL.CGSPJG,paraObj);
	}

	@Override
	public final void zl(SessionBean sessionBean, ZOBean entity) {
		//转类（小类）不涉及子表的修改
		zdryService.zl(sessionBean, entity);//新加，改变状态
		if(entity.getStartProcessInstance()!= null){
			entity.setProcessInstanceBusinessKey(entity.getZdryzb().getId());
			entity.getStartProcessInstance().getVariables().put("zdryId", entity.getZdryzbId());
			startProcessInstance(entity.getStartProcessInstance());
		}
	}

	@Override
	public final void zlSuccess(SessionBean sessionBean, ZOBean entity) {
		//转类（小类）不涉及子表的修改
		zdryService.zlSuccess(sessionBean ,entity);
	}

	@Override
	public final void zlFail(SessionBean sessionBean, ZOBean entity) {
		//转类（小类）不涉及子表的修改
		zdryService.zlFail(sessionBean , entity);
	}

	@Override
	public final void zd(SessionBean sessionBean , ZOBean entity) {
		//转递不涉及子表的修改
		zdryService.zd(sessionBean,entity);//新加，改变状态
		setZdrylbdxId(entity);
		zd_(sessionBean,entity.getZdrylbdx());
		if(entity.getStartProcessInstance()!=null){
			entity.setProcessInstanceBusinessKey(entity.getZdryzb().getId());
			entity.getStartProcessInstance().getVariables().put("zdryId", entity.getZdryzbId());
			entity.getStartProcessInstance().getVariables().put("zdryZb", entity.getZdryzb());
			entity.getStartProcessInstance().getVariables().put("zdrycx", entity.getZdrycx());
			entity.getStartProcessInstance().getVariables().put("zdrylbdx", entity.getZdrylbdx());
			startProcessInstance(entity.getStartProcessInstance());
		}
	}

	@Override
	public final void zdSuccess(SessionBean sessionBean , ZOBean entity) {
		//转递不涉及子表的修改
		zdryService.zdSuccess(sessionBean ,entity);
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());//获取消息的参数
		paraObj.put("result", "zdSuccess");
		jwzhMessageService.sendMessage(MessageDict.ZDRYGL.ZDSPJG,paraObj);
	}

	@Override
	public final void zdFail(SessionBean sessionBean , ZOBean entity) {
		//转递不涉及子表的修改
		zdryService.zdFail(sessionBean,entity);
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());//获取消息的参数
		paraObj.put("result", "zdFail");
		jwzhMessageService.sendMessage(MessageDict.ZDRYGL.ZDSPJG,paraObj);
	}

	@Override
	public final void zd(SessionBean sessionBean) {
	}

	@Override
	public final void zdSuccess(SessionBean sessionBean) {
	}

	@Override
	public final void zdFail(SessionBean sessionBean) {
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: (修改，重点人员编辑页面用)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	@Override
	public final void update(SessionBean sessionBean) {
		zdryService.update(sessionBean);//总表修改
		update_(sessionBean);//子表修改		
	}
	
	@Override
	public final void update(SessionBean sessionBean, ZOBean zdry) {
		zdryService.update(sessionBean,zdry);//总表修改
		update_(sessionBean,zdry.getZdrylbdx());
	}

	
	@Override
	public Zdry getZdry() {
		return zdryService.getZdry();
	}
	
	@Override
	public String getZdryId() {
		return getZdry().getId();
	}
	
	
	@Override
	public final void setStartProcessInstance(String processKey, String applyUserId, Map<String,Object> variables){
		if(processInstance == null) 
			processInstance = new StartProcessInstance();
		processInstance.setProcessKey(processKey);
		processInstance.setApplyUserId(applyUserId);
		processInstance.setVariables(variables);
	}
		
	
	protected abstract void lg_(SessionBean sessionBean,Zdry zdrylbdx);
	
	protected abstract void lgFail_(SessionBean sessionBean,Zdry zdrylbdx);

	protected abstract void cg_(SessionBean sessionBean,Zdry zdrylbdx);
	
//	TODO 待实现 
//	protected abstract void cgFail_(SessionBean sessionBean,Zdry zdrylbdx);
//	TODO 待实现 
	protected abstract void zd_(SessionBean sessionBean,Zdry zdrylbdx);
//	TODO 待实现 
	protected abstract void zdFail_(SessionBean sessionBean,Zdry zdrylbdx);
	
	protected abstract void update_(SessionBean sessionBean);
	
//	TODO 待实现 
	protected abstract void update_(SessionBean sessionBean,Zdry zdrylbdx);
	
	
	/**
	 * 
	 * @Title: getMessageParam
	 * @Description: (获取消息生产需要的参数)
	 * @param @param sessionBean
	 * @param @param zdry
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	protected Map<String,Object> getMessageParam(SessionBean sessionBean , Zdry zdry){
        //私有参数处理
        Map<String,Object> paramObj = new HashMap<String,Object>();
        paramObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paramObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码	
        paramObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paramObj.putAll(getZdryXmAndZdrylxName(zdry));
        return paramObj;
	}
	
	@Override
	public final Map<String,String> getZdryXmAndZdrylxName(Zdry zdry){
		return zdryService.getZdryXmAndZdrylxName(zdry);
	}
	
	public void setZdrylbdxId(ZOBean entity){
		if(entity.getZdrylbdx() != null)
			entity.getZdrylbdx().setId(entity.getZdryzb().getId());
	}
	
	@Deprecated
	private void startProcessInstance(){
		if(processInstance == null){
			return ;//没有流程
		}
		if(processInstance != null && StringUtils.isEmpty(processInstance.getProcessKey())){
			throw new BussinessException("缺少流程启动参数！");
		}else{
			//put zdryId & name to variables
			processInstance.setBusinessKey(zdryService.getZdryId());
			processInstance.getVariables().put("zdryId", zdryService.getZdryId());
			processDefinitionService.startProcessInstance(processInstance.getApplyUserId(),processInstance.getProcessKey(), processInstance.getBusinessKey(), processInstance.getVariables());
		}
	}
	
	private void startProcessInstance(StartProcessInstance startProcessInstance){
		if(startProcessInstance != null && StringUtils.isEmpty(startProcessInstance.getProcessKey())){
			throw new BussinessException("缺少流程启动参数！");
		}else{
			processDefinitionService.startProcessInstance(startProcessInstance.getApplyUserId(),startProcessInstance.getProcessKey(), startProcessInstance.getBusinessKey(), startProcessInstance.getVariables());
		}
	}
}
