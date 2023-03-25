package com.ruoyi.person.service;

import java.util.List;
import com.ruoyi.person.domain.UserComment;

/**
 * 用户评论Service接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface IUserCommentService 
{
    /**
     * 查询用户评论
     * 
     * @param id 用户评论主键
     * @return 用户评论
     */
    public UserComment selectUserCommentById(Long id);

    /**
     * 查询用户评论列表
     * 
     * @param userComment 用户评论
     * @return 用户评论集合
     */
    public List<UserComment> selectUserCommentList(UserComment userComment);

    /**
     * 新增用户评论
     * 
     * @param userComment 用户评论
     * @return 结果
     */
    public int insertUserComment(UserComment userComment);

    /**
     * 修改用户评论
     * 
     * @param userComment 用户评论
     * @return 结果
     */
    public int updateUserComment(UserComment userComment);

    /**
     * 批量删除用户评论
     * 
     * @param ids 需要删除的用户评论主键集合
     * @return 结果
     */
    public int deleteUserCommentByIds(String ids);

    /**
     * 删除用户评论信息
     * 
     * @param id 用户评论主键
     * @return 结果
     */
    public int deleteUserCommentById(Long id);
}
