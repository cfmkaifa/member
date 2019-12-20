package org.forbes.comm.enums;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * MemberStausEnum概要说明：会员状态
 * @author Huanghy
 */
public enum MemberStausEnum {

	NORMAL("1","正常"),
	FREEZE("2","冻结");

	/***编码
	 */
	private String code;

	/***名称
	 */
	private String name;


	/***
	 * existsUserStausEnum方法慨述:
	 * @param code
	 * @return boolean
	 * @创建人 huanghy
	 * @创建时间 2019年12月7日 上午11:19:13
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public static boolean existsMemberStausEnum(String code){
		return Arrays.asList(MemberStausEnum.values()).stream()
		.filter(memberStaus -> ((MemberStausEnum)memberStaus).getCode().equals(code)).count() > 0 ;
	}


	/***
	 * receUserStaus方法慨述:
	 * @return List<Map<String,String>>
	 * @创建人 huanghy
	 * @创建时间 2019年12月7日 上午11:22:07
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public static List<Map<String,String>> receMemberStaus(){
		return Arrays.asList(MemberStausEnum.values()).stream().map(memberStaus -> {
			Map<String,String> reponseMap = Maps.newHashMap();
			MemberStausEnum membertStaus = ((MemberStausEnum)memberStaus);
			reponseMap.put("code", membertStaus.getCode());
			reponseMap.put("name", membertStaus.getName());
			return reponseMap;
		}).collect(Collectors.toList());
	}

	/***
	 *
	 * 构造函数:
	 * @param code
	 * @param name
	 */
	MemberStausEnum(String code, String name){
		this.code = code;
		this.name = name;
	}

	
	

	/** 
	 * @return code 
	 */
	public String getCode() {
		return code;
	}


	/** 
	 * @param code 要设置的 code 
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/** 
	 * @return name 
	 */
	public String getName() {
		return name;
	}

	/** 
	 * @param name 要设置的 name 
	 */
	public void setName(String name) {
		this.name = name;
	}

}
