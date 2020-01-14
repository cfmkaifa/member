package org.forbes.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
     * 购物车id
     * Table:     f_member_cart_item
     * Column:    cart_id
     * Nullable:  true
     */
    @ApiModelProperty(value = "购物车id",example = "0")
    private Long cartId;

    /**
     * 商家id
     * Table:     f_member_cart_item
     * Column:    merchant_id
     * Nullable:  true
     */
    @ApiModelProperty(value = "商家id",example = "0")
    private Long merchantId;

    /**
     * 商品id
     * Table:     f_member_cart_item
     * Column:    pro_id
     * Nullable:  true
     */
    @ApiModelProperty(value = "商品id",example = "0")
    private Long proId;

    /**
     * 商品编码
     * Table:     f_member_cart_item
     * Column:    pro_sn
     * Nullable:  true
     */
    @ApiModelProperty(value = "商品编码")
    private String proSn;

    /**
     * 商品名称
     * Table:     f_member_cart_item
     * Column:    pro_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "商品名称")
    private String proName;

    /**
     * 规格id
     * Table:     f_member_cart_item
     * Column:    spec_id
     * Nullable:  true
     */
    @ApiModelProperty(value = "规格id",example = "0")
    private Long specId;

    /**
     * 规格编码
     * Table:     f_member_cart_item
     * Column:    spec_sn
     * Nullable:  true
     */
    @ApiModelProperty(value = "规格编码")
    private String specSn;

    /**
     * 单价
     * Table:     f_member_cart_item
     * Column:    price
     * Nullable:  true
     */
    @ApiModelProperty(value = "单价",example = "0")
    private BigDecimal price;

    /**
     * Table:     f_member_cart_item
     * Column:    quantity
     * Nullable:  true
     */
    @ApiModelProperty(value = "quantity",example = "0")
    private Integer quantity;

    /**
     * 总价
     * Table:     f_member_cart_item
     * Column:    total_amount
     * Nullable:  true
     */
    @ApiModelProperty(value = "总价",example = "0")
    private BigDecimal totalAmount;
}