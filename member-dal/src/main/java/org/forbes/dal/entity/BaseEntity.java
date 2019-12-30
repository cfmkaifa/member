package org.forbes.dal.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.forbes.comm.constant.UpdateValid;

@Data
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5526949198055162338L;


	/**
     * id
     */
    @TableId(type = IdType.AUTO)
    @JSONField(format="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
    @NotNull(message="主键ID为空",groups=UpdateValid.class)
    private Long id;
    
    
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人",example = "0")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",example = "0")
    private Date createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人",example = "0")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间",example = "0")
    private Date updateTime;
}
