package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName
 * @Description TODO
 * @Author
 * @Date 2019/12/17 17:01
 * @Version 1.0
 **/
@Data
@ApiModel(description="会员附件")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MemberAttachDto implements Serializable{

    private static final long serialVersionUID = 3621288127146822406L;

    /**
     * 数据id
     */
    @ApiModelProperty(value = "会员id",required = true)
    private Long dataId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序",required = true)
    private Integer ordersSort;

    /**
     * 后缀
     */
    @ApiModelProperty(value = "后缀",required = true)
    private String suffix;

    /**
     * 中文名称
     */
    @ApiModelProperty(value = "中文名称",required = true)
    private String cnName;

    /**
     * 英文名称
     * Table:
     */
    @ApiModelProperty(value = "英文名称",required = true)
    private String enName;

    /**
     * 文件地址
     */
    @ApiModelProperty(value = "文件地址",required = true)
    private String filePath;

    /**
     * 0-大图，1-小图，3-中图
     */
    @ApiModelProperty(value = "图片类型 0-大图，1-小图，3-中图",required = true)
    private String type;

    /**
     * 0-会员身份证，1-法人身份证，2-营业执照
     */
    @ApiModelProperty(value = "图片类型",required = true)
    private String dataType;

}
