package com.ruoyi.book.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.book.mapper.HomeFriendLinkMapper;
import com.ruoyi.book.domain.HomeFriendLink;
import com.ruoyi.book.service.IHomeFriendLinkService;
import com.ruoyi.common.core.text.Convert;

/**
 * 友情链接Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class HomeFriendLinkServiceImpl implements IHomeFriendLinkService 
{
    @Autowired
    private HomeFriendLinkMapper homeFriendLinkMapper;

    /**
     * 查询友情链接
     * 
     * @param id 友情链接主键
     * @return 友情链接
     */
    @Override
    public HomeFriendLink selectHomeFriendLinkById(Long id)
    {
        return homeFriendLinkMapper.selectHomeFriendLinkById(id);
    }

    /**
     * 查询友情链接列表
     * 
     * @param homeFriendLink 友情链接
     * @return 友情链接
     */
    @Override
    public List<HomeFriendLink> selectHomeFriendLinkList(HomeFriendLink homeFriendLink)
    {
        return homeFriendLinkMapper.selectHomeFriendLinkList(homeFriendLink);
    }

    /**
     * 新增友情链接
     * 
     * @param homeFriendLink 友情链接
     * @return 结果
     */
    @Override
    public int insertHomeFriendLink(HomeFriendLink homeFriendLink)
    {
        homeFriendLink.setCreateTime(DateUtils.getNowDate());
        return homeFriendLinkMapper.insertHomeFriendLink(homeFriendLink);
    }

    /**
     * 修改友情链接
     * 
     * @param homeFriendLink 友情链接
     * @return 结果
     */
    @Override
    public int updateHomeFriendLink(HomeFriendLink homeFriendLink)
    {
        homeFriendLink.setUpdateTime(DateUtils.getNowDate());
        return homeFriendLinkMapper.updateHomeFriendLink(homeFriendLink);
    }

    /**
     * 批量删除友情链接
     * 
     * @param ids 需要删除的友情链接主键
     * @return 结果
     */
    @Override
    public int deleteHomeFriendLinkByIds(String ids)
    {
        return homeFriendLinkMapper.deleteHomeFriendLinkByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除友情链接信息
     * 
     * @param id 友情链接主键
     * @return 结果
     */
    @Override
    public int deleteHomeFriendLinkById(Long id)
    {
        return homeFriendLinkMapper.deleteHomeFriendLinkById(id);
    }
}
