package com.ruoyi.book.service;

import java.util.List;
import com.ruoyi.book.domain.BookInfo;

/**
 * 小说信息Service接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface IBookInfoService 
{
    /**
     * 查询小说信息
     * 
     * @param id 小说信息主键
     * @return 小说信息
     */
    public BookInfo selectBookInfoById(Long id);

    /**
     * 查询小说信息列表
     * 
     * @param bookInfo 小说信息
     * @return 小说信息集合
     */
    public List<BookInfo> selectBookInfoList(BookInfo bookInfo);

    /**
     * 新增小说信息
     * 
     * @param bookInfo 小说信息
     * @return 结果
     */
    public int insertBookInfo(BookInfo bookInfo);

    /**
     * 修改小说信息
     * 
     * @param bookInfo 小说信息
     * @return 结果
     */
    public int updateBookInfo(BookInfo bookInfo);

    /**
     * 批量删除小说信息
     * 
     * @param ids 需要删除的小说信息主键集合
     * @return 结果
     */
    public int deleteBookInfoByIds(String ids);

    /**
     * 删除小说信息信息
     * 
     * @param id 小说信息主键
     * @return 结果
     */
    public int deleteBookInfoById(Long id);
}
