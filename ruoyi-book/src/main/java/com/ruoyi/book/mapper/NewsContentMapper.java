package com.ruoyi.book.mapper;

import java.util.List;
import com.ruoyi.book.domain.NewsContent;

/**
 * 新闻内容Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface NewsContentMapper 
{
    /**
     * 查询新闻内容
     * 
     * @param id 新闻内容主键
     * @return 新闻内容
     */
    public NewsContent selectNewsContentById(Long id);

    /**
     * 查询新闻内容列表
     * 
     * @param newsContent 新闻内容
     * @return 新闻内容集合
     */
    public List<NewsContent> selectNewsContentList(NewsContent newsContent);

    /**
     * 新增新闻内容
     * 
     * @param newsContent 新闻内容
     * @return 结果
     */
    public int insertNewsContent(NewsContent newsContent);

    /**
     * 修改新闻内容
     * 
     * @param newsContent 新闻内容
     * @return 结果
     */
    public int updateNewsContent(NewsContent newsContent);

    /**
     * 删除新闻内容
     * 
     * @param id 新闻内容主键
     * @return 结果
     */
    public int deleteNewsContentById(Long id);

    /**
     * 批量删除新闻内容
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNewsContentByIds(String[] ids);
}
