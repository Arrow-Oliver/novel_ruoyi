package com.ruoyi.book.domain.dto;

import com.ruoyi.book.domain.HomeBook;

/**
 * @author Arrow
 * @date 2023/3/25 14:51
 */
public class HomeBookDto extends HomeBook {

    private static final long serialVersionUID = 1L;

    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
