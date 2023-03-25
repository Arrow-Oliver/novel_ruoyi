package com.ruoyi.person.service;

import java.util.List;
import com.ruoyi.person.domain.AuthorInfo;

/**
 * 作者信息Service接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface IAuthorInfoService 
{
    /**
     * 查询作者信息
     * 
     * @param id 作者信息主键
     * @return 作者信息
     */
    public AuthorInfo selectAuthorInfoById(Long id);

    /**
     * 查询作者信息列表
     * 
     * @param authorInfo 作者信息
     * @return 作者信息集合
     */
    public List<AuthorInfo> selectAuthorInfoList(AuthorInfo authorInfo);

    /**
     * 新增作者信息
     * 
     * @param authorInfo 作者信息
     * @return 结果
     */
    public int insertAuthorInfo(AuthorInfo authorInfo);

    /**
     * 修改作者信息
     * 
     * @param authorInfo 作者信息
     * @return 结果
     */
    public int updateAuthorInfo(AuthorInfo authorInfo);

    /**
     * 批量删除作者信息
     * 
     * @param ids 需要删除的作者信息主键集合
     * @return 结果
     */
    public int deleteAuthorInfoByIds(String ids);

    /**
     * 删除作者信息信息
     * 
     * @param id 作者信息主键
     * @return 结果
     */
    public int deleteAuthorInfoById(Long id);
}
