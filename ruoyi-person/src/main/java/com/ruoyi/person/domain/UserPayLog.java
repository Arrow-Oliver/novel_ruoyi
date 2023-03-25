package com.ruoyi.person.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户充值记录对象 user_pay_log
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public class UserPayLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 充值用户ID */
    @Excel(name = "充值用户ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    /** 充值方式;0-支付宝 1-微信 */
    @Excel(name = "充值方式;0-支付宝 1-微信")
    private Integer payChannel;

    /** 商户订单号 */
    @Excel(name = "商户订单号")
    private String outTradeNo;

    /** 充值金额;单位：分 */
    @Excel(name = "充值金额;单位：分")
    private Integer amount;

    /** 充值商品类型;0-屋币 1-包年VIP */
    @Excel(name = "充值商品类型;0-屋币 1-包年VIP")
    private Integer productType;

    /** 充值商品ID */
    @Excel(name = "充值商品ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long productId;

    /** 充值商品名;示例值：屋币 */
    @Excel(name = "充值商品名;示例值：屋币")
    private String productName;

    /** 充值商品值;示例值：255 */
    @Excel(name = "充值商品值;示例值：255")
    private Integer productValue;

    /** 充值时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "充值时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setPayChannel(Integer payChannel) 
    {
        this.payChannel = payChannel;
    }

    public Integer getPayChannel() 
    {
        return payChannel;
    }
    public void setOutTradeNo(String outTradeNo) 
    {
        this.outTradeNo = outTradeNo;
    }

    public String getOutTradeNo() 
    {
        return outTradeNo;
    }
    public void setAmount(Integer amount) 
    {
        this.amount = amount;
    }

    public Integer getAmount() 
    {
        return amount;
    }
    public void setProductType(Integer productType) 
    {
        this.productType = productType;
    }

    public Integer getProductType() 
    {
        return productType;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductValue(Integer productValue) 
    {
        this.productValue = productValue;
    }

    public Integer getProductValue() 
    {
        return productValue;
    }
    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("payChannel", getPayChannel())
            .append("outTradeNo", getOutTradeNo())
            .append("amount", getAmount())
            .append("productType", getProductType())
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("productValue", getProductValue())
            .append("payTime", getPayTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
