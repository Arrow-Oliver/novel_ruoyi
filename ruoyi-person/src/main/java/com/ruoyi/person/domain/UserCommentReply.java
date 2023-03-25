package com.ruoyi.person.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户评论回复对象 user_comment_reply
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public class UserCommentReply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 评论ID */
    @Excel(name = "评论ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long commentId;

    /** 回复用户ID */
    @Excel(name = "回复用户ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    /** 回复内容 */
    @Excel(name = "回复内容")
    private String replyContent;

    /** 审核状态;0-待审核 1-审核通过 2-审核不通过 */
    @Excel(name = "审核状态;0-待审核 1-审核通过 2-审核不通过")
    private Integer auditStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCommentId(Long commentId) 
    {
        this.commentId = commentId;
    }

    public Long getCommentId() 
    {
        return commentId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setReplyContent(String replyContent) 
    {
        this.replyContent = replyContent;
    }

    public String getReplyContent() 
    {
        return replyContent;
    }
    public void setAuditStatus(Integer auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus() 
    {
        return auditStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("commentId", getCommentId())
            .append("userId", getUserId())
            .append("replyContent", getReplyContent())
            .append("auditStatus", getAuditStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
