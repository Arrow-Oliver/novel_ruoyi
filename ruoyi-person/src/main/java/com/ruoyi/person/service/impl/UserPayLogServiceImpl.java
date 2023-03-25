package com.ruoyi.person.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.person.mapper.UserPayLogMapper;
import com.ruoyi.person.domain.UserPayLog;
import com.ruoyi.person.service.IUserPayLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户充值记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class UserPayLogServiceImpl implements IUserPayLogService 
{
    @Autowired
    private UserPayLogMapper userPayLogMapper;

    /**
     * 查询用户充值记录
     * 
     * @param id 用户充值记录主键
     * @return 用户充值记录
     */
    @Override
    public UserPayLog selectUserPayLogById(Long id)
    {
        return userPayLogMapper.selectUserPayLogById(id);
    }

    /**
     * 查询用户充值记录列表
     * 
     * @param userPayLog 用户充值记录
     * @return 用户充值记录
     */
    @Override
    public List<UserPayLog> selectUserPayLogList(UserPayLog userPayLog)
    {
        return userPayLogMapper.selectUserPayLogList(userPayLog);
    }

    /**
     * 新增用户充值记录
     * 
     * @param userPayLog 用户充值记录
     * @return 结果
     */
    @Override
    public int insertUserPayLog(UserPayLog userPayLog)
    {
        userPayLog.setCreateTime(DateUtils.getNowDate());
        return userPayLogMapper.insertUserPayLog(userPayLog);
    }

    /**
     * 修改用户充值记录
     * 
     * @param userPayLog 用户充值记录
     * @return 结果
     */
    @Override
    public int updateUserPayLog(UserPayLog userPayLog)
    {
        userPayLog.setUpdateTime(DateUtils.getNowDate());
        return userPayLogMapper.updateUserPayLog(userPayLog);
    }

    /**
     * 批量删除用户充值记录
     * 
     * @param ids 需要删除的用户充值记录主键
     * @return 结果
     */
    @Override
    public int deleteUserPayLogByIds(String ids)
    {
        return userPayLogMapper.deleteUserPayLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户充值记录信息
     * 
     * @param id 用户充值记录主键
     * @return 结果
     */
    @Override
    public int deleteUserPayLogById(Long id)
    {
        return userPayLogMapper.deleteUserPayLogById(id);
    }
}
