package org.forbes.dal.entity;

import java.util.Date;
import lombok.Data;

/**
 * Table: f_member_address
 */
@Data
public class MemberAddress extends BaseEntity {
    /**
     * id
     * Table:     f_member_address
     * Column:    id
     * Nullable:  false
     */
    private Long id;

    /**
     * Table:     f_member_address
     * Column:    create_by
     * Nullable:  true
     */
    private String createBy;

    /**
     * 创建时间
     * Table:     f_member_address
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新人
     * Table:     f_member_address
     * Column:    update_by
     * Nullable:  true
     */
    private String updateBy;

    /**
     * 更新时间
     * Table:     f_member_address
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

    /**
     * 会员id
     * Table:     f_member_address
     * Column:    member_id
     * Nullable:  true
     */
    private Long memberId;

    /**
     * 收货人
     * Table:     f_member_address
     * Column:    consignee
     * Nullable:  true
     */
    private String consignee;

    /**
     * Table:     f_member_address
     * Column:    province
     * Nullable:  true
     */
    private String province;

    /**
     * Table:     f_member_address
     * Column:    city
     * Nullable:  true
     */
    private String city;

    /**
     * Table:     f_member_address
     * Column:    area
     * Nullable:  true
     */
    private String area;

    /**
     * 详细地址
     * Table:     f_member_address
     * Column:    address
     * Nullable:  true
     */
    private String address;

    /**
     * 邮编
     * Table:     f_member_address
     * Column:    zip_code
     * Nullable:  true
     */
    private String zipCode;

    /**
     * 电话
     * Table:     f_member_address
     * Column:    phone
     * Nullable:  true
     */
    private String phone;

    /**
     * 0-否,1-是
     * Table:     f_member_address
     * Column:    is_default
     * Nullable:  true
     */
    private Long isDefault;
}