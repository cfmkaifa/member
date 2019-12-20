package org.forbes.dal.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_member
 */
@Data
@ApiModel(description="会员信息")
@EqualsAndHashCode(callSuper = false)
@TableName("f_member")
public class Member extends BaseEntity {
    /**
     * 主键id
     * Table:     f_member
     * Column:    id
     * Nullable:  false
     */
    private Long id;

    /**
     * 创建人
     * Table:     f_member
     * Column:    create_by
     * Nullable:  true
     */
    private String createBy;

    /**
     * 创建时间
     * Table:     f_member
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新人
     * Table:     f_member
     * Column:    update_by
     * Nullable:  true
     */
    private String updateBy;

    /**
     * 更新时间
     * Table:     f_member
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

    /**
     * 姓名
     * Table:     f_member
     * Column:    name
     * Nullable:  true
     */
    private String name;

    /**
     * 邮箱
     * Table:     f_member
     * Column:    email
     * Nullable:  true
     */
    private String email;

    /**
     * 联系方式
     * Table:     f_member
     * Column:    phone
     * Nullable:  true
     */
    private String phone;

    /**
     * 传真
     * Table:     f_member
     * Column:    fax
     * Nullable:  true
     */
    private String fax;

    /**
     * 机构代码
     * Table:     f_member
     * Column:    org_code
     * Nullable:  true
     */
    private String orgCode;

    /**
     * 法人
     * Table:     f_member
     * Column:    legal_person
     * Nullable:  true
     */
    private String legalPerson;

    /**
     * 会员状态
     * Table:     f_member
     * Column:    state
     * Nullable:  true
     */
    private String state;
}