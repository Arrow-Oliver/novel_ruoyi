package com.ruoyi.person.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.person.mapper.AuthorInfoMapper;
import com.ruoyi.person.domain.AuthorInfo;
import com.ruoyi.person.service.IAuthorInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 作者信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class AuthorInfoServiceImpl implements IAuthorInfoService 
{
    @Autowired
    private AuthorInfoMapper authorInfoMapper;

    /**
     * 查询作者信息
     * 
     * @param id 作者信息主键
     * @return 作者信息
     */
    @Override
    public AuthorInfo selectAuthorInfoById(Long id)
    {
        return authorInfoMapper.selectAuthorInfoById(id);
    }

    /**
     * 查询作者信息列表
     * 
     * @param authorInfo 作者信息
     * @return 作者信息
     */
    @Override
    public List<AuthorInfo> selectAuthorInfoList(AuthorInfo authorInfo)
    {
        return authorInfoMapper.selectAuthorInfoList(authorInfo);
    }

    /**
     * 新增作者信息
     * 
     * @param authorInfo 作者信息
     * @return 结果
     */
    @Override
    public int insertAuthorInfo(AuthorInfo authorInfo)
    {
        authorInfo.setCreateTime(DateUtils.getNowDate());
        return authorInfoMapper.insertAuthorInfo(authorInfo);
    }

    /**
     * 修改作者信息
     * 
     * @param authorInfo 作者信息
     * @return 结果
     */
    @Override
    public int updateAuthorInfo(AuthorInfo authorInfo)
    {
        authorInfo.setUpdateTime(DateUtils.getNowDate());
        return authorInfoMapper.updateAuthorInfo(authorInfo);
    }

    /**
     * 批量删除作者信息
     * 
     * @param ids 需要删除的作者信息主键
     * @return 结果
     */
    @Override
    public int deleteAuthorInfoByIds(String ids)
    {
        return authorInfoMapper.deleteAuthorInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除作者信息信息
     * 
     * @param id 作者信息主键
     * @return 结果
     */
    @Override
    public int deleteAuthorInfoById(Long id)
    {
        return authorInfoMapper.deleteAuthorInfoById(id);
    }
}
