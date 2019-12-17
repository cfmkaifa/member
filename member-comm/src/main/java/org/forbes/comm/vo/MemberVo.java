package org.forbes.comm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName
 * @Description TODO
 * @Author
 * @Date 2019/12/17 16:51
 * @Version 1.0
 **/
@Data
@ApiModel(description = "会员对象")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MemberVo implements Serializable {

    private static final long serialVersionUID = -5103724371461871793L;


    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String mid;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
    private String email;

    /**
     * 联系方式
     */
    @Pattern(regexp ="^[1][3,4,5,7,8][0-9]{9}$")
    @ApiModelProperty(value = "电话")
    private String phone;

    /**
     * 传真
     */
    @Pattern(regexp = " /^((0\\d{2,3}-)?\\d{7,8})$/")
    @ApiModelProperty(value = "传真")
    private String fax;

    /**
     * 机构代码
     */
    @ApiModelProperty(value = "机构代码",required = true)
    private String orgCode;

    /**
     * 法人
     */
    @ApiModelProperty(value = "法人",required = true)
    private String legalPerson;

    @ApiModelProperty(value = "会员附件集合")
    private List<MemberAttachVo> memberAttachVos;

}
