package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


/**
 * Table: f_member_grade
 */
@Data
@ApiModel(description = "会员等级")
@EqualsAndHashCode(callSuper = false)
@TableName("f_member_grade")
public class MemberGrade extends BaseEntity {

    private static final long serialVersionUID = -2147218125440652092L;

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
