package com.ruoyi.book.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.book.mapper.NewsContentMapper;
import com.ruoyi.book.domain.NewsContent;
import com.ruoyi.book.service.INewsContentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 新闻内容Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class NewsContentServiceImpl implements INewsContentService 
{
    @Autowired
    private NewsContentMapper newsContentMapper;

    /**
     * 查询新闻内容
     * 
     * @param id 新闻内容主键
     * @return 新闻内容
     */
    @Override
    public NewsContent selectNewsContentById(Long id)
    {
        return newsContentMapper.selectNewsContentById(id);
    }

    /**
     * 查询新闻内容列表
     * 
     * @param newsContent 新闻内容
     * @return 新闻内容
     */
    @Override
    public List<NewsContent> selectNewsContentList(NewsContent newsContent)
    {
        return newsContentMapper.selectNewsContentList(newsContent);
    }

    /**
     * 新增新闻内容
     * 
     * @param newsContent 新闻内容
     * @return 结果
     */
    @Override
    public int insertNewsContent(NewsContent newsContent)
    {
        newsContent.setCreateTime(DateUtils.getNowDate());
        return newsContentMapper.insertNewsContent(newsContent);
    }

    /**
     * 修改新闻内容
     * 
     * @param newsContent 新闻内容
     * @return 结果
     */
    @Override
    public int updateNewsContent(NewsContent newsContent)
    {
        newsContent.setUpdateTime(DateUtils.getNowDate());
        return newsContentMapper.updateNewsContent(newsContent);
    }

    /**
     * 批量删除新闻内容
     * 
     * @param ids 需要删除的新闻内容主键
     * @return 结果
     */
    @Override
    public int deleteNewsContentByIds(String ids)
    {
        return newsContentMapper.deleteNewsContentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除新闻内容信息
     * 
     * @param id 新闻内容主键
     * @return 结果
     */
    @Override
    public int deleteNewsContentById(Long id)
    {
        return newsContentMapper.deleteNewsContentById(id);
    }
}
