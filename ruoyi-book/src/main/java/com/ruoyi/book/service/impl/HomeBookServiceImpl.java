package com.ruoyi.book.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.ruoyi.book.domain.BookInfo;
import com.ruoyi.book.domain.dto.HomeBookDto;
import com.ruoyi.book.mapper.BookInfoMapper;
import com.ruoyi.common.utils.DateUtils;
import org.apache.commons.math3.analysis.function.Identity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.book.mapper.HomeBookMapper;
import com.ruoyi.book.domain.HomeBook;
import com.ruoyi.book.service.IHomeBookService;
import com.ruoyi.common.core.text.Convert;

/**
 * 小说推荐Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-25
 */
@Service
public class HomeBookServiceImpl implements IHomeBookService {

    @Autowired
    private HomeBookMapper homeBookMapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;


    /**
     * 查询小说推荐
     *
     * @param id 小说推荐主键
     * @return 小说推荐
     */
    @Override
    public HomeBook selectHomeBookById(Long id) {
        return homeBookMapper.selectHomeBookById(id);
    }

    /**
     * 查询小说推荐列表
     *
     * @param homeBook 小说推荐
     * @return 小说推荐
     */
    @Override
    public List<HomeBookDto> selectHomeBookList(HomeBook homeBook) {
        List<HomeBook> homeBooks = homeBookMapper.selectHomeBookList(homeBook);
        List<BookInfo> bookInfos = bookInfoMapper.selectBookInfoList(new BookInfo());
        Map<Long, String> bookNameById = bookInfos.stream()
            .collect(Collectors.toMap(BookInfo::getId, BookInfo::getBookName));
        return homeBooks.stream().map(v -> {
            String bookName = bookNameById.get(v.getBookId());
            HomeBookDto homeBookDto = new HomeBookDto();
            BeanUtils.copyProperties(v, homeBookDto);
            homeBookDto.setBookName(bookName);
            return homeBookDto;
        }).collect(Collectors.toList());
    }

    /**
     * 新增小说推荐
     *
     * @param homeBook 小说推荐
     * @return 结果
     */
    @Override
    public int insertHomeBook(HomeBook homeBook) {
        homeBook.setCreateTime(DateUtils.getNowDate());
        return homeBookMapper.insertHomeBook(homeBook);
    }

    /**
     * 修改小说推荐
     *
     * @param homeBook 小说推荐
     * @return 结果
     */
    @Override
    public int updateHomeBook(HomeBook homeBook) {
        homeBook.setUpdateTime(DateUtils.getNowDate());
        return homeBookMapper.updateHomeBook(homeBook);
    }

    /**
     * 批量删除小说推荐
     *
     * @param ids 需要删除的小说推荐主键
     * @return 结果
     */
    @Override
    public int deleteHomeBookByIds(String ids) {
        return homeBookMapper.deleteHomeBookByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小说推荐信息
     *
     * @param id 小说推荐主键
     * @return 结果
     */
    @Override
    public int deleteHomeBookById(Long id) {
        return homeBookMapper.deleteHomeBookById(id);
    }
}
