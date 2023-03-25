package com.ruoyi.book.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小说信息对象 book_info
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public class BookInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 作品方向;0-男频 1-女频 */
    @Excel(name = "作品方向;0-男频 1-女频")
    private Integer workDirection;

    /** 类别ID */
    @Excel(name = "类别ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;

    /** 类别名 */
    @Excel(name = "类别名")
    private String categoryName;

    /** 小说封面地址 */
    @Excel(name = "小说封面地址")
    private String picUrl;

    /** 小说名 */
    @Excel(name = "小说名")
    private String bookName;

    /** 作家id */
    @Excel(name = "作家id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long authorId;

    /** 作家名 */
    @Excel(name = "作家名")
    private String authorName;

    /** 书籍描述 */
    @Excel(name = "书籍描述")
    private String bookDesc;

    /** 评分;总分:10 ，真实评分 = score/10 */
    @Excel(name = "评分;总分:10 ，真实评分 = score/10")
    private Integer score;

    /** 书籍状态;0-连载中 1-已完结 */
    @Excel(name = "书籍状态;0-连载中 1-已完结")
    private Integer bookStatus;

    /** 点击量 */
    @Excel(name = "点击量")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long visitCount;

    /** 总字数 */
    @Excel(name = "总字数")
    private Integer wordCount;

    /** 评论数 */
    @Excel(name = "评论数")
    private Integer commentCount;

    /** 最新章节ID */
    @Excel(name = "最新章节ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lastChapterId;

    /** 最新章节名 */
    @Excel(name = "最新章节名")
    private String lastChapterName;

    /** 最新章节更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最新章节更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastChapterUpdateTime;

    /** 是否收费;1-收费 0-免费 */
    @Excel(name = "是否收费;1-收费 0-免费")
    private Integer isVip;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWorkDirection(Integer workDirection)
    {
        this.workDirection = workDirection;
    }

    public Integer getWorkDirection() 
    {
        return workDirection;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName() 
    {
        return categoryName;
    }
    public void setPicUrl(String picUrl) 
    {
        this.picUrl = picUrl;
    }

    public String getPicUrl() 
    {
        return picUrl;
    }
    public void setBookName(String bookName) 
    {
        this.bookName = bookName;
    }

    public String getBookName() 
    {
        return bookName;
    }
    public void setAuthorId(Long authorId) 
    {
        this.authorId = authorId;
    }

    public Long getAuthorId() 
    {
        return authorId;
    }
    public void setAuthorName(String authorName) 
    {
        this.authorName = authorName;
    }

    public String getAuthorName() 
    {
        return authorName;
    }
    public void setBookDesc(String bookDesc) 
    {
        this.bookDesc = bookDesc;
    }

    public String getBookDesc() 
    {
        return bookDesc;
    }
    public void setScore(Integer score) 
    {
        this.score = score;
    }

    public Integer getScore() 
    {
        return score;
    }
    public void setBookStatus(Integer bookStatus) 
    {
        this.bookStatus = bookStatus;
    }

    public Integer getBookStatus() 
    {
        return bookStatus;
    }
    public void setVisitCount(Long visitCount) 
    {
        this.visitCount = visitCount;
    }

    public Long getVisitCount() 
    {
        return visitCount;
    }
    public void setWordCount(Integer wordCount) 
    {
        this.wordCount = wordCount;
    }

    public Integer getWordCount() 
    {
        return wordCount;
    }
    public void setCommentCount(Integer commentCount) 
    {
        this.commentCount = commentCount;
    }

    public Integer getCommentCount() 
    {
        return commentCount;
    }
    public void setLastChapterId(Long lastChapterId) 
    {
        this.lastChapterId = lastChapterId;
    }

    public Long getLastChapterId() 
    {
        return lastChapterId;
    }
    public void setLastChapterName(String lastChapterName) 
    {
        this.lastChapterName = lastChapterName;
    }

    public String getLastChapterName() 
    {
        return lastChapterName;
    }
    public void setLastChapterUpdateTime(Date lastChapterUpdateTime) 
    {
        this.lastChapterUpdateTime = lastChapterUpdateTime;
    }

    public Date getLastChapterUpdateTime() 
    {
        return lastChapterUpdateTime;
    }
    public void setIsVip(Integer isVip) 
    {
        this.isVip = isVip;
    }

    public Integer getIsVip() 
    {
        return isVip;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("workDirection", getWorkDirection())
            .append("categoryId", getCategoryId())
            .append("categoryName", getCategoryName())
            .append("picUrl", getPicUrl())
            .append("bookName", getBookName())
            .append("authorId", getAuthorId())
            .append("authorName", getAuthorName())
            .append("bookDesc", getBookDesc())
            .append("score", getScore())
            .append("bookStatus", getBookStatus())
            .append("visitCount", getVisitCount())
            .append("wordCount", getWordCount())
            .append("commentCount", getCommentCount())
            .append("lastChapterId", getLastChapterId())
            .append("lastChapterName", getLastChapterName())
            .append("lastChapterUpdateTime", getLastChapterUpdateTime())
            .append("isVip", getIsVip())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
