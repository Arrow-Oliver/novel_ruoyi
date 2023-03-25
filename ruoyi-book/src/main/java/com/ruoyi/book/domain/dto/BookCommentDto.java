package com.ruoyi.book.domain.dto;

import com.ruoyi.book.domain.BookComment;

/**
 * @author Arrow
 * @date 2023/3/25 15:55
 */
public class BookCommentDto extends BookComment {

    private static final long serialVersionUID = 1L;

    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
