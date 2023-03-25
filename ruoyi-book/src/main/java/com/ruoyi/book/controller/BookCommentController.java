package com.ruoyi.book.controller;

import java.util.List;

import com.ruoyi.book.domain.dto.BookCommentDto;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.book.domain.BookComment;
import com.ruoyi.book.service.IBookCommentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小说评论Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/book/bookComment")
public class BookCommentController extends BaseController
{
    private String prefix = "book/bookComment";

    @Autowired
    private IBookCommentService bookCommentService;

    @RequiresPermissions("book:bookComment:view")
    @GetMapping()
    public String bookComment()
    {
        return prefix + "/bookComment";
    }

    /**
     * 查询小说评论列表
     */
    @RequiresPermissions("book:bookComment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BookComment bookComment)
    {
        startPage();
        List<BookCommentDto> list = bookCommentService.selectBookCommentList(bookComment);
        return getDataTable(list);
    }

    /**
     * 导出小说评论列表
     */
    @RequiresPermissions("book:bookComment:export")
    @Log(title = "小说评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BookComment bookComment)
    {
        List<BookCommentDto> list = bookCommentService.selectBookCommentList(bookComment);
        ExcelUtil<BookCommentDto> util = new ExcelUtil<BookCommentDto>(BookCommentDto.class);
        return util.exportExcel(list, "小说评论数据");
    }

    /**
     * 新增小说评论
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小说评论
     */
    @RequiresPermissions("book:bookComment:add")
    @Log(title = "小说评论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BookComment bookComment)
    {
        return toAjax(bookCommentService.insertBookComment(bookComment));
    }

    /**
     * 修改小说评论
     */
    @RequiresPermissions("book:bookComment:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BookComment bookComment = bookCommentService.selectBookCommentById(id);
        mmap.put("bookComment", bookComment);
        return prefix + "/edit";
    }

    /**
     * 修改保存小说评论
     */
    @RequiresPermissions("book:bookComment:edit")
    @Log(title = "小说评论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BookComment bookComment)
    {
        return toAjax(bookCommentService.updateBookComment(bookComment));
    }

    /**
     * 删除小说评论
     */
    @RequiresPermissions("book:bookComment:remove")
    @Log(title = "小说评论", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bookCommentService.deleteBookCommentByIds(ids));
    }
}
