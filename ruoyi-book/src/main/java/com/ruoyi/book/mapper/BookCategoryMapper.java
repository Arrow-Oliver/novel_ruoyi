package com.ruoyi.book.mapper;

import java.util.List;
import com.ruoyi.book.domain.BookCategory;

/**
 * 小说类别Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface BookCategoryMapper 
{
    /**
     * 查询小说类别
     * 
     * @param id 小说类别主键
     * @return 小说类别
     */
    public BookCategory selectBookCategoryById(Long id);

    /**
     * 查询小说类别列表
     * 
     * @param bookCategory 小说类别
     * @return 小说类别集合
     */
    public List<BookCategory> selectBookCategoryList(BookCategory bookCategory);

    /**
     * 新增小说类别
     * 
     * @param bookCategory 小说类别
     * @return 结果
     */
    public int insertBookCategory(BookCategory bookCategory);

    /**
     * 修改小说类别
     * 
     * @param bookCategory 小说类别
     * @return 结果
     */
    public int updateBookCategory(BookCategory bookCategory);

    /**
     * 删除小说类别
     * 
     * @param id 小说类别主键
     * @return 结果
     */
    public int deleteBookCategoryById(Long id);

    /**
     * 批量删除小说类别
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBookCategoryByIds(String[] ids);
}
