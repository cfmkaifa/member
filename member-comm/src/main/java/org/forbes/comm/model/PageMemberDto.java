package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author lzw
 * @date 2019/12/18 9:34
 */
@Data
@ApiModel(description="会员分页信息")
@EqualsAndHashCode(callSuper = false)
public class PageMemberDto implements Serializable{

    private static final long serialVersionUID = -3614387184293686783L;

    /**
     * 会员状态
     * Table:     f_member
     * Column:    state
     * Nullable:  true
     */
    @ApiModelProperty("会员状态")
    private String state;

    /**
     * 会员姓名
     * Table:     f_member
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty("会员姓名")
    private String name;
}
