package com.ruoyi.person.mapper;

import java.util.List;
import com.ruoyi.person.domain.UserCommentReply;

/**
 * 用户评论回复Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface UserCommentReplyMapper 
{
    /**
     * 查询用户评论回复
     * 
     * @param id 用户评论回复主键
     * @return 用户评论回复
     */
    public UserCommentReply selectUserCommentReplyById(Long id);

    /**
     * 查询用户评论回复列表
     * 
     * @param userCommentReply 用户评论回复
     * @return 用户评论回复集合
     */
    public List<UserCommentReply> selectUserCommentReplyList(UserCommentReply userCommentReply);

    /**
     * 新增用户评论回复
     * 
     * @param userCommentReply 用户评论回复
     * @return 结果
     */
    public int insertUserCommentReply(UserCommentReply userCommentReply);

    /**
     * 修改用户评论回复
     * 
     * @param userCommentReply 用户评论回复
     * @return 结果
     */
    public int updateUserCommentReply(UserCommentReply userCommentReply);

    /**
     * 删除用户评论回复
     * 
     * @param id 用户评论回复主键
     * @return 结果
     */
    public int deleteUserCommentReplyById(Long id);

    /**
     * 批量删除用户评论回复
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserCommentReplyByIds(String[] ids);
}
