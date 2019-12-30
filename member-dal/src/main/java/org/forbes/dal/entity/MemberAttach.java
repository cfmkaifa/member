package org.forbes.dal.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_member_attach
 */
@Data
@ApiModel(description="会员附件")
@EqualsAndHashCode(callSuper = false)
@TableName("f_member_attach")
public class MemberAttach extends BaseEntity {
    private static final long serialVersionUID = -5916701445037160192L;
    /**
     * id
     * Table:     f_member_attach
     * Column:    id
     * Nullable:  false
     */
    private Long id;

    /**
     * 创建人
     * Table:     f_member_attach
     * Column:    create_by
     * Nullable:  true
     */
    private String createBy;

    /**
     * 创建时间
     * Table:     f_member_attach
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新人
     * Table:     f_member_attach
     * Column:    update_by
     * Nullable:  true
     */
    private String updateBy;

    /**
     * 更新时间
     * Table:     f_member_attach
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

    /**
     * 数据id
     * Table:     f_member_attach
     * Column:    data_id
     * Nullable:  true
     */
    private Long dataId;

    /**
     * 排序
     * Table:     f_member_attach
     * Column:    orders_sort
     * Nullable:  true
     */
    private Integer ordersSort;

    /**
     * 后缀
     * Table:     f_member_attach
     * Column:    suffix
     * Nullable:  true
     */
    private String suffix;

    /**
     * 中文名称
     * Table:     f_member_attach
     * Column:    cn_name
     * Nullable:  true
     */
    private String cnName;

    /**
     * Table:     f_member_attach
     * Column:    en_name
     * Nullable:  true
     */
    private String enName;

    /**
     * 文件地址
     * Table:     f_member_attach
     * Column:    file_path
     * Nullable:  true
     */
    private String filePath;

    /**
     * 0-大图，1-小图，3-中图
     * Table:     f_member_attach
     * Column:    type
     * Nullable:  true
     */
    private String type;

    /**
     * 0-会员身份证，1-法人身份证，2-营业执照
     * Table:     f_member_attach
     * Column:    data_type
     * Nullable:  true
     */
    private String dataType;
}