package com.founder.zdrygl.service;

import java.util.List;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryDtjsClxxb;
import com.founder.zdrygl.bean.ZdryDtjsGxbgxxb;
import com.founder.zdrygl.bean.ZdryDtjsSaxxb;
import com.founder.zdrygl.bean.ZdryDtjsSdfdxxb;
import com.founder.zdrygl.bean.ZdryDtjsSdxdxxb;
import com.founder.zdrygl.bean.ZdryDtjsSdzdxxb;
import com.founder.zdrygl.bean.ZdryDtjsSfxxb;
import com.founder.zdrygl.bean.ZdryDtjsShgxrxxb;
import com.founder.zdrygl.bean.ZdryDtjsSwxxb;
import com.founder.zdrygl.bean.ZdryDtjsXsxxb;
import com.founder.zdrygl.bean.ZdryDtjsZdxsfzqkxxb;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrxxb;
import com.founder.zdrygl.bean.ZdryDtjsZtxxb;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrZdjlxxb;
import com.founder.zdrygl.bean.ZdryDtjsZszhjsbrZszhjlxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.ZdryService.java]  
 * @ClassName:    [ZdryService]   
 * @Description:  [動態紀實 在逃信息接口]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-7 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-7 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("動態紀實在逃信息接口服務")
public interface ZdryDtjsZtxxbService {


	
	
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsZtxxb entity);	


}
