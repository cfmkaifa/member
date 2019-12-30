package org.forbes.comm.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.forbes.comm.constant.UpdateValid;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@ApiModel(description="会员等级传入参数")
@EqualsAndHashCode(callSuper = false)
public class MemberGradeDto implements Serializable{

    private static final long serialVersionUID = -4842654941602874105L;

    /**
     * id
     */
    @ApiModelProperty(value = "id",example = "0")
    private Long id;


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
