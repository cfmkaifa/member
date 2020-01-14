package org.forbes.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_member_cart
 */
@Data
@ApiModel(description="购物车")
@EqualsAndHashCode(callSuper = false)
@TableName("f_member_cart")
public class MemberCart extends BaseEntity {
    private static final long serialVersionUID = -6850494794270191277L;

    /**
     * 购物车key
     * Table:     f_member_cart
     * Column:    cart_key
     * Nullable:  true
     */
    private String cartKey;

    /**
     * Table:     f_member_cart
     * Column:    member_id
     * Nullable:  true
     */
    private Long memberId;

    /**
     * 商品总数量
     * Table:     f_member_cart
     * Column:    total_quantity
     * Nullable:  true
     */
    private Integer totalQuantity;

    /**
     * 总额
     * Table:     f_member_cart
     * Column:    total_amount
     * Nullable:  true
     */
    private BigDecimal totalAmount;

    /**
     * 优惠金额
     * Table:     f_member_cart
     * Column:    discount_amount
     * Nullable:  true
     */
    private BigDecimal discountAmount;

    /**
     * 支付金额
     * Table:     f_member_cart
     * Column:    pay_amount
     * Nullable:  true
     */
    private BigDecimal payAmount;

    /**
     * Table:     f_member_cart
     * Column:    expi_time
     * Nullable:  true
     */
    private Date expiTime;
}