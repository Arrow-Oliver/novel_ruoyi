package com.ruoyi.person.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.person.mapper.UserCommentReplyMapper;
import com.ruoyi.person.domain.UserCommentReply;
import com.ruoyi.person.service.IUserCommentReplyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户评论回复Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class UserCommentReplyServiceImpl implements IUserCommentReplyService 
{
    @Autowired
    private UserCommentReplyMapper userCommentReplyMapper;

    /**
     * 查询用户评论回复
     * 
     * @param id 用户评论回复主键
     * @return 用户评论回复
     */
    @Override
    public UserCommentReply selectUserCommentReplyById(Long id)
    {
        return userCommentReplyMapper.selectUserCommentReplyById(id);
    }

    /**
     * 查询用户评论回复列表
     * 
     * @param userCommentReply 用户评论回复
     * @return 用户评论回复
     */
    @Override
    public List<UserCommentReply> selectUserCommentReplyList(UserCommentReply userCommentReply)
    {
        return userCommentReplyMapper.selectUserCommentReplyList(userCommentReply);
    }

    /**
     * 新增用户评论回复
     * 
     * @param userCommentReply 用户评论回复
     * @return 结果
     */
    @Override
    public int insertUserCommentReply(UserCommentReply userCommentReply)
    {
        userCommentReply.setCreateTime(DateUtils.getNowDate());
        return userCommentReplyMapper.insertUserCommentReply(userCommentReply);
    }

    /**
     * 修改用户评论回复
     * 
     * @param userCommentReply 用户评论回复
     * @return 结果
     */
    @Override
    public int updateUserCommentReply(UserCommentReply userCommentReply)
    {
        userCommentReply.setUpdateTime(DateUtils.getNowDate());
        return userCommentReplyMapper.updateUserCommentReply(userCommentReply);
    }

    /**
     * 批量删除用户评论回复
     * 
     * @param ids 需要删除的用户评论回复主键
     * @return 结果
     */
    @Override
    public int deleteUserCommentReplyByIds(String ids)
    {
        return userCommentReplyMapper.deleteUserCommentReplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户评论回复信息
     * 
     * @param id 用户评论回复主键
     * @return 结果
     */
    @Override
    public int deleteUserCommentReplyById(Long id)
    {
        return userCommentReplyMapper.deleteUserCommentReplyById(id);
    }
}
