package com.ruoyi.book.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.book.mapper.NewsInfoMapper;
import com.ruoyi.book.domain.NewsInfo;
import com.ruoyi.book.service.INewsInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 新闻信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class NewsInfoServiceImpl implements INewsInfoService 
{
    @Autowired
    private NewsInfoMapper newsInfoMapper;

    /**
     * 查询新闻信息
     * 
     * @param id 新闻信息主键
     * @return 新闻信息
     */
    @Override
    public NewsInfo selectNewsInfoById(Long id)
    {
        return newsInfoMapper.selectNewsInfoById(id);
    }

    /**
     * 查询新闻信息列表
     * 
     * @param newsInfo 新闻信息
     * @return 新闻信息
     */
    @Override
    public List<NewsInfo> selectNewsInfoList(NewsInfo newsInfo)
    {
        return newsInfoMapper.selectNewsInfoList(newsInfo);
    }

    /**
     * 新增新闻信息
     * 
     * @param newsInfo 新闻信息
     * @return 结果
     */
    @Override
    public int insertNewsInfo(NewsInfo newsInfo)
    {
        newsInfo.setCreateTime(DateUtils.getNowDate());
        return newsInfoMapper.insertNewsInfo(newsInfo);
    }

    /**
     * 修改新闻信息
     * 
     * @param newsInfo 新闻信息
     * @return 结果
     */
    @Override
    public int updateNewsInfo(NewsInfo newsInfo)
    {
        newsInfo.setUpdateTime(DateUtils.getNowDate());
        return newsInfoMapper.updateNewsInfo(newsInfo);
    }

    /**
     * 批量删除新闻信息
     * 
     * @param ids 需要删除的新闻信息主键
     * @return 结果
     */
    @Override
    public int deleteNewsInfoByIds(String ids)
    {
        return newsInfoMapper.deleteNewsInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除新闻信息信息
     * 
     * @param id 新闻信息主键
     * @return 结果
     */
    @Override
    public int deleteNewsInfoById(Long id)
    {
        return newsInfoMapper.deleteNewsInfoById(id);
    }
}
