package com.ruoyi.book.service;

import java.util.List;
import com.ruoyi.book.domain.BookComment;

/**
 * 小说评论Service接口
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
public interface IBookCommentService 
{
    /**
     * 查询小说评论
     * 
     * @param id 小说评论主键
     * @return 小说评论
     */
    public BookComment selectBookCommentById(Long id);

    /**
     * 查询小说评论列表
     * 
     * @param bookComment 小说评论
     * @return 小说评论集合
     */
    public List<BookComment> selectBookCommentList(BookComment bookComment);

    /**
     * 新增小说评论
     * 
     * @param bookComment 小说评论
     * @return 结果
     */
    public int insertBookComment(BookComment bookComment);

    /**
     * 修改小说评论
     * 
     * @param bookComment 小说评论
     * @return 结果
     */
    public int updateBookComment(BookComment bookComment);

    /**
     * 批量删除小说评论
     * 
     * @param ids 需要删除的小说评论主键集合
     * @return 结果
     */
    public int deleteBookCommentByIds(String ids);

    /**
     * 删除小说评论信息
     * 
     * @param id 小说评论主键
     * @return 结果
     */
    public int deleteBookCommentById(Long id);
}
