package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
@ApiModel(description="会员等级查询条件")
@EqualsAndHashCode(callSuper = false)
public class MemberGradePageDto implements Serializable{


    private static final long serialVersionUID = -6136048372455289386L;

    /**
     * 会员名称
     * Table:     f_member
     * Column:    name
     * Nullable:  true
     */
    private String name;
}
