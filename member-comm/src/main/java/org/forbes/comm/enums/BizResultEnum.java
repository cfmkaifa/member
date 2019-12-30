package org.forbes.comm.enums;
/***
 * BizResultEnum概要说明：业务系统错误代码
 * @author Huanghy
 */
public enum BizResultEnum {
	/***
	 * 003-会员中心系统
	 * 功能暂无-表示通用异常
	 * 001-为空判断
	 */
	EMPTY("001001","参数为空","%s为空"),
	ENTITY_EMPTY("001001000","对象为空",""),

	/*******会员*************/
	USERNAME_EXISTS("003001001","用户已存在","s%对应用户已存在"),
	USER_EMAIL_EXISTS("003001002","邮箱已存在","s%对应邮箱已存在"),
	PHONE_EXISTS("003001003","电话已存在","s%对应电话已存在"),
	FAX("003001004","邮箱已存在","s%对应邮箱已存在"),
	ORG_CODE("003001005","机构代码已存在","s%对应机构代码已存在"),
	MEMBER_EXIST("003001006","会员不存在","s%对应会员不存在"),
	USER_EXIST("003001007","该用户名对应用户不存在","s%该用户名对应用户不存在"),


	/*******地址(002)******/
	ADRESS_STATUS_NO_EXISTS("003002001","地址状态不存在","%s对应地址状态不存在"),

	/*******地址(003)******/
	USER_GRADE_IN_USE("003003001","改会员等级正在被使用中","%s对应改会员等级正在被使用中");



	
	/**错误编码业务系统代码+功能编码+错误代码**/
	private String bizCode;
	/**错误描述****/
	private String bizMessage;
	/**带格式错误描述****/
	private String bizFormateMessage;

	/***
	 * 构造函数:
	 * @param bizCode
	 * @param bizMessage
	 * @param bizFormateMessage
	 */
	BizResultEnum(String bizCode, String bizMessage, String bizFormateMessage){
		this.bizCode = bizCode;
		this.bizMessage = bizMessage;
		this.bizFormateMessage = bizFormateMessage;
	}

	/** 
	 * @return bizCode 
	 */
	public String getBizCode() {
		return bizCode;
	}

	/** 
	 * @param bizCode 要设置的 bizCode 
	 */
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	/** 
	 * @return bizMessage 
	 */
	public String getBizMessage() {
		return bizMessage;
	}

	/** 
	 * @param bizMessage 要设置的 bizMessage 
	 */
	public void setBizMessage(String bizMessage) {
		this.bizMessage = bizMessage;
	}

	/** 
	 * @return bizFormateMessage 
	 */
	public String getBizFormateMessage() {
		return bizFormateMessage;
	}

	/** 
	 * @param bizFormateMessage 要设置的 bizFormateMessage 
	 */
	public void setBizFormateMessage(String bizFormateMessage) {
		this.bizFormateMessage = bizFormateMessage;
	}
}
