package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


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
     * 等级名称
     * Table:     f_member_grade
     * Column:    grade_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "等级名称")
    private String gradeName;
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
