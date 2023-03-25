package com.ruoyi.book.mapper;

import java.util.List;
import com.ruoyi.book.domain.HomeBook;

/**
 * 小说推荐Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface HomeBookMapper 
{
    /**
     * 查询小说推荐
     * 
     * @param id 小说推荐主键
     * @return 小说推荐
     */
    public HomeBook selectHomeBookById(Long id);

    /**
     * 查询小说推荐列表
     * 
     * @param homeBook 小说推荐
     * @return 小说推荐集合
     */
    public List<HomeBook> selectHomeBookList(HomeBook homeBook);

    /**
     * 新增小说推荐
     * 
     * @param homeBook 小说推荐
     * @return 结果
     */
    public int insertHomeBook(HomeBook homeBook);

    /**
     * 修改小说推荐
     * 
     * @param homeBook 小说推荐
     * @return 结果
     */
    public int updateHomeBook(HomeBook homeBook);

    /**
     * 删除小说推荐
     * 
     * @param id 小说推荐主键
     * @return 结果
     */
    public int deleteHomeBookById(Long id);

    /**
     * 批量删除小说推荐
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHomeBookByIds(String[] ids);
}
