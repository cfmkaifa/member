package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Pattern;

/**
 * Table: f_member_address
 */
@Data
@ApiModel(description="地址信息")
@EqualsAndHashCode(callSuper = false)
@TableName("f_member_address")
public class MemberAddress extends BaseEntity {

    private static final long serialVersionUID = -2425478923407804604L;

    /**
     * 会员id
     * Table:     f_member_address
     * Column:    member_id
     * Nullable:  true
     */
    @ApiModelProperty("会员id")
    private Long memberId;

    /**
     * 收货人
     * Table:     f_member_address
     * Column:    consignee
     * Nullable:  true
     */
    @ApiModelProperty(value = "收货人",required = true)
    private String consignee;

    /**
     * Table:     f_member_address
     * Column:    province
     * Nullable:  true
     */
    @ApiModelProperty(value = "省",required = true)
    private String province;

    /**
     * Table:     f_member_address
     * Column:    city
     * Nullable:  true
     */
    @ApiModelProperty(value = "市",required = true)
    private String city;

    /**
     * Table:     f_member_address
     * Column:    area
     * Nullable:  true
     */
    @ApiModelProperty(value = "区",required = true)
    private String area;

    /**
     * 详细地址
     * Table:     f_member_address
     * Column:    address
     * Nullable:  true
     */
    @ApiModelProperty(value = "详细地址",required = true)
    private String address;

    /**
     * 邮编
     * Table:     f_member_address
     * Column:    zip_code
     * Nullable:  true
     */
    @ApiModelProperty("邮编")
    private String zipCode;

    /**
     * 电话
     * Table:     f_member_address
     * Column:    phone
     * Nullable:  true
     */
    @ApiModelProperty(value = "电话",required = true)
    @Pattern(regexp ="^[1][3,4,5,7,8][0-9]{9}$")
    private String phone;

    /**
     * 0-否,1-是
     * Table:     f_member_address
     * Column:    is_default
     * Nullable:  true
     */
    @ApiModelProperty("0-否,1-是")
    private String isDefault;
}