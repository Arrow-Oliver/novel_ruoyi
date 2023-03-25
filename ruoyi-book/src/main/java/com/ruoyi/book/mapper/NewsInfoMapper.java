package com.ruoyi.book.mapper;

import java.util.List;
import com.ruoyi.book.domain.NewsInfo;

/**
 * 新闻信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface NewsInfoMapper 
{
    /**
     * 查询新闻信息
     * 
     * @param id 新闻信息主键
     * @return 新闻信息
     */
    public NewsInfo selectNewsInfoById(Long id);

    /**
     * 查询新闻信息列表
     * 
     * @param newsInfo 新闻信息
     * @return 新闻信息集合
     */
    public List<NewsInfo> selectNewsInfoList(NewsInfo newsInfo);

    /**
     * 新增新闻信息
     * 
     * @param newsInfo 新闻信息
     * @return 结果
     */
    public int insertNewsInfo(NewsInfo newsInfo);

    /**
     * 修改新闻信息
     * 
     * @param newsInfo 新闻信息
     * @return 结果
     */
    public int updateNewsInfo(NewsInfo newsInfo);

    /**
     * 删除新闻信息
     * 
     * @param id 新闻信息主键
     * @return 结果
     */
    public int deleteNewsInfoById(Long id);

    /**
     * 批量删除新闻信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNewsInfoByIds(String[] ids);
}
