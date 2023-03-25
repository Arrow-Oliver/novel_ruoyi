package com.ruoyi.person.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 作者信息对象 author_info
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public class AuthorInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    /** 邀请码 */
    @Excel(name = "邀请码")
    private String inviteCode;

    /** 笔名 */
    @Excel(name = "笔名")
    private String penName;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String telPhone;

    /** QQ或微信账号 */
    @Excel(name = "QQ或微信账号")
    private String chatAccount;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 作品方向;0-男频 1-女频 */
    @Excel(name = "作品方向;0-男频 1-女频")
    private Integer workDirection;

    /** 0：正常;1-封禁 */
    @Excel(name = "0：正常;1-封禁")
    private Integer status;

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
    public void setInviteCode(String inviteCode) 
    {
        this.inviteCode = inviteCode;
    }

    public String getInviteCode() 
    {
        return inviteCode;
    }
    public void setPenName(String penName) 
    {
        this.penName = penName;
    }

    public String getPenName() 
    {
        return penName;
    }
    public void setTelPhone(String telPhone) 
    {
        this.telPhone = telPhone;
    }

    public String getTelPhone() 
    {
        return telPhone;
    }
    public void setChatAccount(String chatAccount) 
    {
        this.chatAccount = chatAccount;
    }

    public String getChatAccount() 
    {
        return chatAccount;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setWorkDirection(Integer workDirection) 
    {
        this.workDirection = workDirection;
    }

    public Integer getWorkDirection() 
    {
        return workDirection;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("inviteCode", getInviteCode())
            .append("penName", getPenName())
            .append("telPhone", getTelPhone())
            .append("chatAccount", getChatAccount())
            .append("email", getEmail())
            .append("workDirection", getWorkDirection())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
