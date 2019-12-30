package org.forbes.comm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(description = "会员等级对象")
@EqualsAndHashCode(callSuper = false)
public class MemberGradeVo implements Serializable {

    private static final long serialVersionUID = -8440718161724490388L;

    /**
     * 会员等级名称
     * Table:     f_member_grade
     * Column:    grade_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "会员等级名称",required = true)
    private String gradeName;

    /**
     * 等级
     * Table:     f_member_grade
     * Column:    grade
     * Nullable:  true
     */
    @ApiModelProperty(value = "等级",required = true)
    private String grade;

    /**
     * 会员等级编码
     * Table:     f_member_grade
     * Column:    code
     * Nullable:  true
     */
    @ApiModelProperty(value = "会员等级编码")
    private String code;

    /**
     * 是否默认
     * Table:     f_member_grade
     * Column:    is_default
     * Nullable:  true
     */
    @ApiModelProperty(value = "是否默认0否1是")
    private String isDefault;

    /**
     * 消费金额
     * Table:     f_member_grade
     * Column:    consumption_amount
     * Nullable:  true
     */
    @ApiModelProperty(value = "消费金额",required = true,example = "0")
    private BigDecimal consumptionAmount;
}
