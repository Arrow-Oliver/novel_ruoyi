package com.ruoyi.person.service;

import java.util.List;
import com.ruoyi.person.domain.UserPayLog;

/**
 * 用户充值记录Service接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface IUserPayLogService 
{
    /**
     * 查询用户充值记录
     * 
     * @param id 用户充值记录主键
     * @return 用户充值记录
     */
    public UserPayLog selectUserPayLogById(Long id);

    /**
     * 查询用户充值记录列表
     * 
     * @param userPayLog 用户充值记录
     * @return 用户充值记录集合
     */
    public List<UserPayLog> selectUserPayLogList(UserPayLog userPayLog);

    /**
     * 新增用户充值记录
     * 
     * @param userPayLog 用户充值记录
     * @return 结果
     */
    public int insertUserPayLog(UserPayLog userPayLog);

    /**
     * 修改用户充值记录
     * 
     * @param userPayLog 用户充值记录
     * @return 结果
     */
    public int updateUserPayLog(UserPayLog userPayLog);

    /**
     * 批量删除用户充值记录
     * 
     * @param ids 需要删除的用户充值记录主键集合
     * @return 结果
     */
    public int deleteUserPayLogByIds(String ids);

    /**
     * 删除用户充值记录信息
     * 
     * @param id 用户充值记录主键
     * @return 结果
     */
    public int deleteUserPayLogById(Long id);
}
