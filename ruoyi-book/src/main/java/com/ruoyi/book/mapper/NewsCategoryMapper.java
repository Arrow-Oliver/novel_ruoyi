package com.ruoyi.book.mapper;

import java.util.List;
import com.ruoyi.book.domain.NewsCategory;

/**
 * 新闻类别Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface NewsCategoryMapper 
{
    /**
     * 查询新闻类别
     * 
     * @param id 新闻类别主键
     * @return 新闻类别
     */
    public NewsCategory selectNewsCategoryById(Long id);

    /**
     * 查询新闻类别列表
     * 
     * @param newsCategory 新闻类别
     * @return 新闻类别集合
     */
    public List<NewsCategory> selectNewsCategoryList(NewsCategory newsCategory);

    /**
     * 新增新闻类别
     * 
     * @param newsCategory 新闻类别
     * @return 结果
     */
    public int insertNewsCategory(NewsCategory newsCategory);

    /**
     * 修改新闻类别
     * 
     * @param newsCategory 新闻类别
     * @return 结果
     */
    public int updateNewsCategory(NewsCategory newsCategory);

    /**
     * 删除新闻类别
     * 
     * @param id 新闻类别主键
     * @return 结果
     */
    public int deleteNewsCategoryById(Long id);

    /**
     * 批量删除新闻类别
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNewsCategoryByIds(String[] ids);
}
