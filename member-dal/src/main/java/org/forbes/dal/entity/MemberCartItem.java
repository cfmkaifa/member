package org.forbes.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_member_cart_item
 */
@Data
@ApiModel(description="购物车详情")
@EqualsAndHashCode(callSuper = false)
@TableName("f_member_cart_item")
public class MemberCartItem extends BaseEntity {
    private static final long serialVersionUID = 2333767483134544316L;
    /**
     * id
     * Table:     f_member_cart_item
     * Column:    id
     * Nullable:  false
     */
    private Long id;

    /**
     * 创建人
     * Table:     f_member_cart_item
     * Column:    create_by
     * Nullable:  true
     */
    private String createBy;

    /**
     * 创建时间
     * Table:     f_member_cart_item
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新人
     * Table:     f_member_cart_item
     * Column:    update_by
     * Nullable:  true
     */
    private String updateBy;

    /**
     * 更新时间
     * Table:     f_member_cart_item
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

    /**
     * 购物车id
     * Table:     f_member_cart_item
     * Column:    cart_id
     * Nullable:  true
     */
    private Long cartId;

    /**
     * 商家id
     * Table:     f_member_cart_item
     * Column:    merchant_id
     * Nullable:  true
     */
    private Long merchantId;

    /**
     * 商品id
     * Table:     f_member_cart_item
     * Column:    pro_id
     * Nullable:  true
     */
    private Long proId;

    /**
     * 商品编码
     * Table:     f_member_cart_item
     * Column:    pro_sn
     * Nullable:  true
     */
    private String proSn;

    /**
     * 商品名称
     * Table:     f_member_cart_item
     * Column:    pro_name
     * Nullable:  true
     */
    private String proName;

    /**
     * 规格id
     * Table:     f_member_cart_item
     * Column:    spec_id
     * Nullable:  true
     */
    private Long specId;

    /**
     * 规格编码
     * Table:     f_member_cart_item
     * Column:    spec_sn
     * Nullable:  true
     */
    private String specSn;

    /**
     * 单价
     * Table:     f_member_cart_item
     * Column:    price
     * Nullable:  true
     */
    private BigDecimal price;

    /**
     * Table:     f_member_cart_item
     * Column:    quantity
     * Nullable:  true
     */
    private Integer quantity;

    /**
     * 总价
     * Table:     f_member_cart_item
     * Column:    total_amount
     * Nullable:  true
     */
    private BigDecimal totalAmount;
}