package org.forbes.comm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@ApiModel(description = "会员等级对象")
@EqualsAndHashCode(callSuper = false)
public class MemberGradeVo implements Serializable{

    private static final long serialVersionUID = -8440718161724490388L;
    /**
     * 等级名称
     * Table:     f_member_grade
     * Column:    grade_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "等级名称")
    private String gradeName;
    /**
     * 会员姓名
     * Table:     f_member
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty(value = "会员姓名")
    private String name;
    /**
     * 用户id
     * Table:     f_member_grade
     * Column:    user_id
     * Nullable:  true
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 等级
     * Table:     f_member_grade
     * Column:    grade
     * Nullable:  true
     */
    @ApiModelProperty(value = "等级")
    private String grade;
    /**
     * 会员等级编码
     * Table:     f_member_grade
     * Column:    code
     * Nullable:  true
     */
    @ApiModelProperty(value = "会员等级编码")
    private String code;
}
