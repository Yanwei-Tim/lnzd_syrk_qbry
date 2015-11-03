if(typeof Lksq =="undefined" || !Lksq){
	Lksq = {};
}
Lksq.listObj;//临控人员查询结果集合

/**
 * @method:initQueryHtml
 * @package:syrk/js/qbld	
 * @description:初始化临控申请页面
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:32:57
 * 
 */
Lksq.initQueryHtml = function(){
	/**
	 * 加载布控执行状态下拉框
	 */
	$("#where_bkzxzt").combobox({
		url: contextPath + '/common/dict/D_QBLD_XXBKZXZT.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bbkrzjlx").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYZJLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bc_bkjb").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYLKZLJB.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bc_cccs").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYCZCSLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bbkrxb").combobox({
		url: contextPath + '/common/dict/GB_D_XBDM.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	$("#lksq_bc_gklx").combobox({
		url: contextPath + '/common/dict/D_QBLD_ZDRYGKLX.js',
		valueField:'id',
		textField:'text',
		selectOnNavigation:false,
		method:'get',
		tipPosition:'left',
		width:'100%'
	});
	var inputObjs = $(".infoOneTable :input")
	var num = inputObjs.length
	/**
	 * 将所有收入框设置为不可编辑状态
	 */
	for(var i = 0;i<num;i++){
			$(inputObjs[i]).attr("disabled",true);
	}
};

/**
 * @method:queryLksqList
 * @package:syrk/js/qbld	
 * @description:查询临控申请记录
 * @param total
 * @param begin
 * @param end
 * @param page
 * @author:Li_Zhenzhong
 * @date:2015-5-11上午10:57:26
 */
Lksq.queryLksqList = function(total,begin,end,page){
	/**
	 * 获取复选框候选信息
	 */
	var checkObj = $("#queryFrom :checkBox");
	var num = checkObj.length
	var gklx = ""; 
	for(var i = 0;i<num;i++){
		if(checkObj[i].checked)
			gklx+=checkObj[i].value+",";
	}
	var param = {  
					"bbkrxm":$("#where_bbkrxm").val(),
					"bbkrzjhm":$("#where_bbkrzjhm").val(),
					"bkzxzt":$("#where_bkzxzt").val(),
					"bc_gklx":gklx.substring(0, gklx.length-1),
					"bkqssjB":$("#where_bkqssjB").val(),
					"bkqssjE":$("#where_bkqssjE").val(),
					"total":total,
					"rownum":10,
					"begin":begin,
					"end":end,
					"page":page}
	var url = contextPath+'/lksq/queryLksqList';
	var fajax = new FrameTools.Ajax(url,Lksq.queryLksqList_back);
	fajax.send(param);
	$(document.body).mask("努力加载中...");
};
/**
 * @method:queryLksqList_back
 * @package:syrk/js/qbld	
 * @description:生成临控申请列表
 * @param json
 * @author:Li_Zhenzhong
 * @date:2015-5-11上午10:57:52
 */
Lksq.queryLksqList_back = function(json){
	$(document.body).unmask();
	Lksq.listObj = json.rows;
	var num = Lksq.listObj.length;
	var  rsHtml = "<table class='listTable'>"+
		"<tr class='countInfo'>" +
		"<td colspan=4 >共有<font color='#17a9ff'>"+json.total+"</font>条临控申请</td>"+
		"</tr>";
	/**
	 * 循环生成结果列表
	 */
	for(var  i = 0;i<num;i++){
		var row = Lksq.listObj[i];
		rsHtml+="<tr class='infoOne_tr' onclick='Main.clickListToChangeColor(this);Lksq.queryOneLksqInfo("+i+")'>"+
				"<td class='infoBody' onclick=''>"+"姓名:"+ row.bbkrxm+"  <br> " +
						"证件号码:"+ row.bbkrzjhm+"<br>" +
						"发布时间:"+row.bc_fbsj+"</div></td>"+
				"</tr>" ;
		}
		rsHtml+="</table>";
	$("#InfoList").html(rsHtml);
	Main.initChangeListColor();
};
/**
 * @method:queryOneLksqInfo
 * @package:syrk/js/qbld	
 * @description:查询单条申请信息
 * @param index
 * @author:Li_Zhenzhong
 * @date:2015-5-13上午10:31:02
 */
Lksq.queryOneLksqInfo = function(index){
	var obj = Lksq.listObj[index];
	for(key in obj){
		var val = obj[key];
		if(val!=""&&val!=null){
			/**
			 * 将字典进行翻译显示
			 */
			switch(key){
			case 'bbkrzjlx':$("#lksq_bbkrzjlx").combobox('setValue', val);break;
			case 'bc_bkjb':$("#lksq_bc_bkjb").combobox('setValue', val);break;
			case 'bc_cccs':$("#lksq_bc_cccs").combobox('setValue', val);break;
			case 'bbkrxb':$("#lksq_bbkrxb").combobox('setValue', val);break;
			case 'bc_gklx':$("#lksq_bc_gklx").combobox('setValue', val);break;
			default:break;
			}
			/**
			 * 将14位时间格式转化为易读的标准格式
			 */
			if('bkqssj,bkjzsj,bc_sqsj,bc_fbsj,'.indexOf(key)!=-1){
				val = val.substring(0,4)+"/"+val.substring(4,6)+"/"+val.substring(6,8)+" "+val.substring(8,10)+":"+val.substring(10,12)+":"+val.substring(12,14) ;
			}
		}
		$("#lksq_"+key).val(val);
	}
	$("#lksq_zp").attr("src",contextPath + "/ckyj/queryQbldZpSingle.jpg?sfzh="+obj.bbkrzjhm );
	
	var inputObjs = $(".infoOneTable :input")
	var num = inputObjs.length
	/**
	 * 将所有文本框设置为只读模式，并隐藏操作行
	 */
	for(var i = 0;i<num;i++){
			$(inputObjs[i]).attr("disabled",true);
			$("#opTr").hide();
	}
};
/**
 * @method:initAddLksqHtml
 * @package:syrk/js/qbld	
 * @description:初始化临控申请表
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:59:48
 */
Lksq.initAddLksqHtml = function(){
	document.forms['infoFrom'].reset();
	$("#lksq_zp").attr("src","");
	var inputObjs = $(".infoOneTable :input")
	var num = inputObjs.length
	for(var i = 0;i<num;i++){
			$(inputObjs[i]).attr("disabled",false);
			$("#opTr").show();
	}
	$("#lksq_bc_fbdw").val(userOrgName);
	$("#lksq_bc_fbr").val(userName);
	$("#lksq_yjdwmc").val(userOrgName);
	$("#lksq_yjrmc").val(userName);
	$("#lksq_bc_fbsj").val(Lksq.show_cur_times());
};
/**
 * @method:addLksqInfo
 * @package:syrk/js/qbld	
 * @description:添加临控申请
 * @author:Li_Zhenzhong
 * @date:2015-5-21下午5:34:06
 */
Lksq.addLksqInfo = function(){
	var inputObjs = $(".infoOneTable .notNull ")
	var num = inputObjs.length
	for(var i = 0;i<num;i++){
		if($(inputObjs[i]).val()==""){
			$.messager.alert("提示","红色标题信息必须填写！");
			return;
		}
	}
	var time1 = $("#lksq_bkqssj").val();
	var time2 = $("#lksq_bkjzsj").val();
	
	time1 = time1.substring(0,4)+"/"+time1.substring(4,6)+"/"+time1.substring(6,8)+" "+time1.substring(8,10)+":"+time1.substring(10,12)+":"+time1.substring(12,14);
 	time2 = time2.substring(0,4)+"/"+time2.substring(4,6)+"/"+time2.substring(6,8)+" "+time2.substring(8,10)+":"+time2.substring(10,12)+":"+time2.substring(12,14);
	var date1 = new Date(time1);
	var date2 = new Date(time2);
	var date3 = date2.getTime()-date1.getTime();
	if(date3<0){
		alert("布控截止时间必须大于布控起始时间！");
		return;
	}
	var days = Math.ceil(date3/(24*3600*1000));
	$("#lksq_bkts").val(days);
	$("#infoFrom").form('submit',{
		dataType:'json',
		url:contextPath +'/lksq/saveLksqb',	
		success:Lksq.addLksqInfo_back
	});
};
/**
 * @method:addLksqInfo_back
 * @package:syrk/js/qbld	
 * @description:申请返回结果
 * @param rsJson
 * @author:Li_Zhenzhong
 * @date:2015-5-27上午10:42:05
 */
Lksq.addLksqInfo_back = function(rsJson){
	rsJson = parseReturn(rsJson);
	if(rsJson.status=="success"){
		$.messager.show({
			title:"提示信息",
			msg:"新增申请成功",
			time:3000,
			showType:'slide'
		});
	}
};

Lksq.show_cur_times = function(){
//获取当前日期
 var date_time = new Date();
 //年
 var year = date_time.getFullYear();
  //判断小于10，前面补0
   if(year<10){
  year="0"+year;
 }
 //月
 var month = date_time.getMonth()+1;
  //判断小于10，前面补0
  if(month<10){
month="0"+month;

 }
 //日
 var day = date_time.getDate();
  //判断小于10，前面补0
   if(day<10){
  day="0"+day;
 }
 //时
 var hours =date_time.getHours();
  //判断小于10，前面补0
    if(hours<10){
  hours="0"+hours;
 }
 //分
 var minutes =date_time.getMinutes();
  //判断小于10，前面补0
    if(minutes<10){
  minutes="0"+minutes;
 }
 //秒
 var seconds=date_time.getSeconds();
  //判断小于10，前面补0
    if(seconds<10){
  seconds="0"+seconds;
 }
 //拼接年月日时分秒
 return ""+year+month+day+hours+minutes+seconds;
}

//电话校验
function checkPhone(mobile){
	var isMobile=/^(?:13\d|15\d)\d{5}(\d{3}|\*{3})$/;   
	var isPhone=/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
	if(!isMobile.test($("#"+mobile).val()) && !isPhone.test($("#"+mobile).val())){
        $("#"+mobile).val(""); 
		$.messager.alert("提示", "联系电话号码格式不正确！");
        return false;
    }

}

//验证身份证
var vcity={ 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",  
        21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",  
        33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",  
        42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",  
        51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",  
        63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"  
       };  

function checkCard(name)
{  
var card = document.getElementById(name).value;
//是否为空  
if(card === '')  
{  
	$.messager.alert('提示', '请输入身份证号，身份证号不能为空');  
    document.getElementById('card_no').focus;  
    return false;  
}  
//校验长度，类型  
if(isCardNo(card) === false)  
{  
	$.messager.alert('提示', '您输入的身份证号码不正确，请重新输入');  
    document.getElementById('card_no').focus;  
    return false;  
}  
//检查省份  
if(checkProvince(card) === false)  
{  
	$.messager.alert('提示', '您输入的身份证号码不正确,请重新输入');  
    document.getElementById('card_no').focus;  
    return false;  
}  
//校验生日  
if(checkBirthday(card) === false)  
{  
	$.messager.alert('提示', '您输入的身份证号码生日不正确,请重新输入');  
    document.getElementById('card_no').focus();  
    return false;  
}  
//检验位的检测  
if(checkParity(card) === false)  
{  
	$.messager.alert('提示', '您的身份证校验位不正确,请重新输入');  
    document.getElementById('card_no').focus();  
    return false;  
}  
return true;  
};  


//检查号码是否符合规范，包括长度，类型  
isCardNo = function(card)  
{  
//身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
var reg = /(^\d{15}$)|(^\d{17}(\d|X)$)/;  
if(reg.test(card) === false)  
{  
    return false;  
}  

return true;  
};  

//取身份证前两位,校验省份  
checkProvince = function(card)  
{  
var province = card.substr(0,2);  
if(vcity[province] == undefined)  
{  
    return false;  
}  
return true;  
};  

//检查生日是否正确  
checkBirthday = function(card)  
{  
var len = card.length;  
//身份证15位时，次序为省（3位）市（3位）年（2位）月（2位）日（2位）校验位（3位），皆为数字  
if(len == '15')  
{  
    var re_fifteen = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;  
    var arr_data = card.match(re_fifteen);  
    var year = arr_data[2];  
    var month = arr_data[3];  
    var day = arr_data[4];  
    var birthday = new Date('19'+year+'/'+month+'/'+day);  
    return verifyBirthday('19'+year,month,day,birthday);  
}  
//身份证18位时，次序为省（3位）市（3位）年（4位）月（2位）日（2位）校验位（4位），校验位末尾可能为X  
if(len == '18')  
{  
    var re_eighteen = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;  
    var arr_data = card.match(re_eighteen);  
    var year = arr_data[2];  
    var month = arr_data[3];  
    var day = arr_data[4];  
    var birthday = new Date(year+'/'+month+'/'+day);  
    return verifyBirthday(year,month,day,birthday);  
}  
return false;  
};  

//校验日期  
verifyBirthday = function(year,month,day,birthday)  
{  
var now = new Date();  
var now_year = now.getFullYear();  
//年月日是否合理  
if(birthday.getFullYear() == year && (birthday.getMonth() + 1) == month && birthday.getDate() == day)  
{  
    //判断年份的范围（3岁到100岁之间)  
    var time = now_year - year;  
    if(time >= 3 && time <= 100)  
    {  
        return true;  
    }  
    return false;  
}  
return false;  
};  

//校验位的检测  
checkParity = function(card)  
{  
//15位转18位  
card = changeFivteenToEighteen(card);  
var len = card.length;  
if(len == '18')  
{  
    var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);  
    var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');  
    var cardTemp = 0, i, valnum;  
    for(i = 0; i < 17; i ++)  
    {  
        cardTemp += card.substr(i, 1) * arrInt[i];  
    }  
    valnum = arrCh[cardTemp % 11];  
    if (valnum == card.substr(17, 1))  
    {  
        return true;  
    }  
    return false;  
}  
return false;  
};  

//15位转18位身份证号  
changeFivteenToEighteen = function(card)  
{  
if(card.length == '15')  
{  
    var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);  
    var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');  
    var cardTemp = 0, i;    
    card = card.substr(0, 6) + '19' + card.substr(6, card.length - 6);  
    for(i = 0; i < 17; i ++)  
    {  
        cardTemp += card.substr(i, 1) * arrInt[i];  
    }  
    card += arrCh[cardTemp % 11];  
    return card;  
}  
return card;  
};  
	
/*
 * 根据证件种类与号码 ，进行人员比对，复用
 * name 模块名称
 */
function checkZjhm(name){
	if(!checkCard(name)){
		alert("不是生份证");
	} else {
		var zjhm = document.getElementById(name).value;
		$("#yrjbxxDiv").show();
		$.ajax({
			type:"POST",
			url: contextPath + "/ryRyjbxxb/dataApply",
			dataType:"json",
			data:"zjhm=" + zjhm + "&cyzjdm=" + $("#lksq_bbkrzjlx").combobox("getValue"),
			success:function(res) {
				if(res.ryRyjbxxb.xm!=''){
					$('#lksq_bbkrxm').val(res.ryRyjbxxb.xm);
				}
				if(res.ryRyjbxxb.xbdm!=''){
					$("#lksq_bbkrxb").combobox("setValue", res.ryRyjbxxb.xbdm);
				}
				if(res.ryRyjbxxb.csrq!=''){
					var csrq = res.ryRyjbxxb.csrq;
					if(csrq!=null && csrq!=''){
						while( csrq.indexOf( "-" ) != -1 ) {
							csrq = csrq.replace("-","");// 每循环一次赋值，否则是死循环
						}
					}
					$('#lksq_bbkrcsrq').val(csrq);
				}
				if(res.ryRyjbxxb.hjd_dzxz!=''){
					$("#lksq_bc_hjzz").val(res.ryRyjbxxb.hjd_dzxz);
				}
				if(res.ryRyjbxxb.jzd_dzxz!=''){
					$("#lksq_bc_xzz").val(res.ryRyjbxxb.jzd_dzxz);
				}
					
				$("#yrjbxxDiv").hide();
			}
		});	
	}
}


