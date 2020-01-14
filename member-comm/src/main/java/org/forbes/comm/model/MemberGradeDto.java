package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(description = "会员等级传入参数")
@EqualsAndHashCode(callSuper = false)
public class MemberGradeDto implements Serializable {

    private static final long serialVersionUID = -4842654941602874105L;

    /**
     * id
     */
    @ApiModelProperty(value = "id,添加操作不填", example = "0")
    private Long id;

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
