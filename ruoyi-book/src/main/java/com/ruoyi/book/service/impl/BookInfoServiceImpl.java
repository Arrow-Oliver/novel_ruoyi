package com.ruoyi.book.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.book.mapper.BookInfoMapper;
import com.ruoyi.book.domain.BookInfo;
import com.ruoyi.book.service.IBookInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 小说信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class BookInfoServiceImpl implements IBookInfoService 
{
    @Autowired
    private BookInfoMapper bookInfoMapper;

    /**
     * 查询小说信息
     * 
     * @param id 小说信息主键
     * @return 小说信息
     */
    @Override
    public BookInfo selectBookInfoById(Long id)
    {
        return bookInfoMapper.selectBookInfoById(id);
    }

    /**
     * 查询小说信息列表
     * 
     * @param bookInfo 小说信息
     * @return 小说信息
     */
    @Override
    public List<BookInfo> selectBookInfoList(BookInfo bookInfo)
    {
        return bookInfoMapper.selectBookInfoList(bookInfo);
    }

    /**
     * 新增小说信息
     * 
     * @param bookInfo 小说信息
     * @return 结果
     */
    @Override
    public int insertBookInfo(BookInfo bookInfo)
    {
        bookInfo.setCreateTime(DateUtils.getNowDate());
        return bookInfoMapper.insertBookInfo(bookInfo);
    }

    /**
     * 修改小说信息
     * 
     * @param bookInfo 小说信息
     * @return 结果
     */
    @Override
    public int updateBookInfo(BookInfo bookInfo)
    {
        bookInfo.setUpdateTime(DateUtils.getNowDate());
        return bookInfoMapper.updateBookInfo(bookInfo);
    }

    /**
     * 批量删除小说信息
     * 
     * @param ids 需要删除的小说信息主键
     * @return 结果
     */
    @Override
    public int deleteBookInfoByIds(String ids)
    {
        return bookInfoMapper.deleteBookInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小说信息信息
     * 
     * @param id 小说信息主键
     * @return 结果
     */
    @Override
    public int deleteBookInfoById(Long id)
    {
        return bookInfoMapper.deleteBookInfoById(id);
    }
}
