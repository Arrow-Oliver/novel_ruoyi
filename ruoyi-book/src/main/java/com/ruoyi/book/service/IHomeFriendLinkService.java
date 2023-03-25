package com.ruoyi.book.service;

import java.util.List;
import com.ruoyi.book.domain.HomeFriendLink;

/**
 * 友情链接Service接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface IHomeFriendLinkService 
{
    /**
     * 查询友情链接
     * 
     * @param id 友情链接主键
     * @return 友情链接
     */
    public HomeFriendLink selectHomeFriendLinkById(Long id);

    /**
     * 查询友情链接列表
     * 
     * @param homeFriendLink 友情链接
     * @return 友情链接集合
     */
    public List<HomeFriendLink> selectHomeFriendLinkList(HomeFriendLink homeFriendLink);

    /**
     * 新增友情链接
     * 
     * @param homeFriendLink 友情链接
     * @return 结果
     */
    public int insertHomeFriendLink(HomeFriendLink homeFriendLink);

    /**
     * 修改友情链接
     * 
     * @param homeFriendLink 友情链接
     * @return 结果
     */
    public int updateHomeFriendLink(HomeFriendLink homeFriendLink);

    /**
     * 批量删除友情链接
     * 
     * @param ids 需要删除的友情链接主键集合
     * @return 结果
     */
    public int deleteHomeFriendLinkByIds(String ids);

    /**
     * 删除友情链接信息
     * 
     * @param id 友情链接主键
     * @return 结果
     */
    public int deleteHomeFriendLinkById(Long id);
}
