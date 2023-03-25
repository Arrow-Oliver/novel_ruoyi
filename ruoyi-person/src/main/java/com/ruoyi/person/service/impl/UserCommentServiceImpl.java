package com.ruoyi.person.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.person.mapper.UserCommentMapper;
import com.ruoyi.person.domain.UserComment;
import com.ruoyi.person.service.IUserCommentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户评论Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class UserCommentServiceImpl implements IUserCommentService 
{
    @Autowired
    private UserCommentMapper userCommentMapper;

    /**
     * 查询用户评论
     * 
     * @param id 用户评论主键
     * @return 用户评论
     */
    @Override
    public UserComment selectUserCommentById(Long id)
    {
        return userCommentMapper.selectUserCommentById(id);
    }

    /**
     * 查询用户评论列表
     * 
     * @param userComment 用户评论
     * @return 用户评论
     */
    @Override
    public List<UserComment> selectUserCommentList(UserComment userComment)
    {
        return userCommentMapper.selectUserCommentList(userComment);
    }

    /**
     * 新增用户评论
     * 
     * @param userComment 用户评论
     * @return 结果
     */
    @Override
    public int insertUserComment(UserComment userComment)
    {
        userComment.setCreateTime(DateUtils.getNowDate());
        return userCommentMapper.insertUserComment(userComment);
    }

    /**
     * 修改用户评论
     * 
     * @param userComment 用户评论
     * @return 结果
     */
    @Override
    public int updateUserComment(UserComment userComment)
    {
        userComment.setUpdateTime(DateUtils.getNowDate());
        return userCommentMapper.updateUserComment(userComment);
    }

    /**
     * 批量删除用户评论
     * 
     * @param ids 需要删除的用户评论主键
     * @return 结果
     */
    @Override
    public int deleteUserCommentByIds(String ids)
    {
        return userCommentMapper.deleteUserCommentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户评论信息
     * 
     * @param id 用户评论主键
     * @return 结果
     */
    @Override
    public int deleteUserCommentById(Long id)
    {
        return userCommentMapper.deleteUserCommentById(id);
    }
}
