package com.ruoyi.book.controller;

import java.util.List;
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
import com.ruoyi.book.domain.BookCategory;
import com.ruoyi.book.service.IBookCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小说类别Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/book/bookCategory")
public class BookCategoryController extends BaseController
{
    private String prefix = "book/bookCategory";

    @Autowired
    private IBookCategoryService bookCategoryService;

    @RequiresPermissions("book:bookCategory:view")
    @GetMapping()
    public String bookCategory()
    {
        return prefix + "/bookCategory";
    }

    /**
     * 查询小说类别列表
     */
    @RequiresPermissions("book:bookCategory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BookCategory bookCategory)
    {
        startPage();
        List<BookCategory> list = bookCategoryService.selectBookCategoryList(bookCategory);
        return getDataTable(list);
    }

    /**
     * 导出小说类别列表
     */
    @RequiresPermissions("book:bookCategory:export")
    @Log(title = "小说类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BookCategory bookCategory)
    {
        List<BookCategory> list = bookCategoryService.selectBookCategoryList(bookCategory);
        ExcelUtil<BookCategory> util = new ExcelUtil<BookCategory>(BookCategory.class);
        return util.exportExcel(list, "小说类别数据");
    }

    /**
     * 新增小说类别
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小说类别
     */
    @RequiresPermissions("book:bookCategory:add")
    @Log(title = "小说类别", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BookCategory bookCategory)
    {
        return toAjax(bookCategoryService.insertBookCategory(bookCategory));
    }

    /**
     * 修改小说类别
     */
    @RequiresPermissions("book:bookCategory:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BookCategory bookCategory = bookCategoryService.selectBookCategoryById(id);
        mmap.put("bookCategory", bookCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存小说类别
     */
    @RequiresPermissions("book:bookCategory:edit")
    @Log(title = "小说类别", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BookCategory bookCategory)
    {
        return toAjax(bookCategoryService.updateBookCategory(bookCategory));
    }

    /**
     * 删除小说类别
     */
    @RequiresPermissions("book:bookCategory:remove")
    @Log(title = "小说类别", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bookCategoryService.deleteBookCategoryByIds(ids));
    }
}
