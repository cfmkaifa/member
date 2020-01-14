package org.forbes.comm.vo;

import lombok.Data;
import org.forbes.comm.constant.CommonConstant;

import java.io.Serializable;

/***
 * Result概要说明：统一返回错误
 * @author Huanghy
 */
@Data
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	private String message = "操作成功！";
	/******查询所有地址信息****/
	public static final  String ADDRESS_LIST_MSG="查询所有地址成功";
	public static final  String ADDRESS_LIST_ERROR_MSG="查询所有地址失败";

	/*****公共操作结果信息*****/
	public static final  String COMM_ACTION_MSG = "操作成功";
	public static final  String COMM_ACTION_ERROR_MSG = "操作失败";

	/*****会员登录*****/
	public static final  String LOGIN_MSG = "会员登录成功";
	public static final  String LOGIN_MSG_ERROR = "会员登录失败";

	/*****会员注册*****/
	public static final  String REGIST_MSG = "会员注册成功";
	public static final  String REGIST_MSG_ERROR = "会员注册失败";

	/*****会员详情*****/
	public static final  String MEMBER_MSG = "查看会员详情成功";
	public static final  String MEMBER_MSG_ERROR = "查看会员详情失败";

	/*****多条件查询会员集合*****/
	public static final  String SELECT_LIST_MEMBER_AND_ROLE_MSG = "多条件查询会员成功";
	public static final  String SELECT_LIST_MEMBER_AND_ROLE_ERROR_MSG = "多条件查询会员失败";

	/*****会员修改*****/
	public static final  String UPD_MEMBER_MSG = "会员修改成功";
	public static final  String UPD_MEMBER_MSG_ERROR = "会员修改失败";

	/*****会员分页查询*****/
	public static final  String PAGE_MSG = "会员分页查询成功";
	public static final  String PAGE_MSG_ERROR = "会员分页查询失败";

	/*****会员等级*****/
	public static final  String MEMBER_GRADE_MSG = "会员等级查询成功";
	public static final  String MEMBER_GRADE_ERROR_MSG = "会员等级查询失败";

	public static final  String ADD_MEMBER_GRADE_MSG = "会员等级添加成功";
	public static final  String ADD_MEMBER_GRADE_ERROR_MSG = "会员等级添加失败";

	public static final  String UPDATE_MEMBER_GRADE_MSG = "会员等级修改成功";
	public static final  String UPDATE_MEMBER_GRADE_ERROR_MSG = "会员等级修改失败";

	public static final  String DELETE_MEMBER_GRADE_MSG = "会员等级删除成功";
	public static final  String DELETE_MEMBER_GRADE_ERROR_MSG = "会员等级删除失败";


	/**
	 * 返回代码
	 */
	private Integer code = CommonConstant.SC_OK_200;
	private String  bizCode = "";
	
	/**
	 * 返回数据对象 data
	 */
	private T result;

	public Result() {
		
	}
	
	/**
	 * 时间戳
	 */
	private long timestamp = System.currentTimeMillis();

	public void error500(String message) {
		this.message = message;
		this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
		this.success = false;
	}

	public void success(String message) {
		this.message = message;
		this.code = CommonConstant.SC_OK_200;
		this.success = true;
	}
	
	public static Result<Object> error(String msg) {
		return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
	}
	
	public static Result<Object> error(int code, String msg) {
		Result<Object> r = new Result<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		return r;
	}
	
	/***
	 * error方法慨述:
	 * @param bizCode
	 * @param msg
	 * @return Result<Object>
	 * @创建人 huanghy
	 * @创建时间 2019年12月7日 下午4:07:04
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public  void error(String bizCode, String msg) {
		this.bizCode = bizCode;
		this.message = msg;
		this.success = false;
	}
	
	public static Result<Object> ok(String msg) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setMessage(msg);
		return r;
	}
	
	public static Result<Object> ok(Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		return r;
	}
}

