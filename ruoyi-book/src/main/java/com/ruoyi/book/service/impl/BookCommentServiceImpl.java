package com.ruoyi.book.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.book.mapper.BookCommentMapper;
import com.ruoyi.book.domain.BookComment;
import com.ruoyi.book.service.IBookCommentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 小说评论Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class BookCommentServiceImpl implements IBookCommentService 
{
    @Autowired
    private BookCommentMapper bookCommentMapper;

    /**
     * 查询小说评论
     * 
     * @param id 小说评论主键
     * @return 小说评论
     */
    @Override
    public BookComment selectBookCommentById(Long id)
    {
        return bookCommentMapper.selectBookCommentById(id);
    }

    /**
     * 查询小说评论列表
     * 
     * @param bookComment 小说评论
     * @return 小说评论
     */
    @Override
    public List<BookComment> selectBookCommentList(BookComment bookComment)
    {
        return bookCommentMapper.selectBookCommentList(bookComment);
    }

    /**
     * 新增小说评论
     * 
     * @param bookComment 小说评论
     * @return 结果
     */
    @Override
    public int insertBookComment(BookComment bookComment)
    {
        bookComment.setCreateTime(DateUtils.getNowDate());
        return bookCommentMapper.insertBookComment(bookComment);
    }

    /**
     * 修改小说评论
     * 
     * @param bookComment 小说评论
     * @return 结果
     */
    @Override
    public int updateBookComment(BookComment bookComment)
    {
        bookComment.setUpdateTime(DateUtils.getNowDate());
        return bookCommentMapper.updateBookComment(bookComment);
    }

    /**
     * 批量删除小说评论
     * 
     * @param ids 需要删除的小说评论主键
     * @return 结果
     */
    @Override
    public int deleteBookCommentByIds(String ids)
    {
        return bookCommentMapper.deleteBookCommentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小说评论信息
     * 
     * @param id 小说评论主键
     * @return 结果
     */
    @Override
    public int deleteBookCommentById(Long id)
    {
        return bookCommentMapper.deleteBookCommentById(id);
    }
}
