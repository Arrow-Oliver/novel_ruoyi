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
import com.ruoyi.book.domain.BookInfo;
import com.ruoyi.book.service.IBookInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小说信息Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/book/bookInfo")
public class BookInfoController extends BaseController
{
    private String prefix = "book/bookInfo";

    @Autowired
    private IBookInfoService bookInfoService;

    @RequiresPermissions("book:bookInfo:view")
    @GetMapping()
    public String bookInfo()
    {
        return prefix + "/bookInfo";
    }

    /**
     * 查询小说信息列表
     */
    @RequiresPermissions("book:bookInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BookInfo bookInfo)
    {
        startPage();
        List<BookInfo> list = bookInfoService.selectBookInfoList(bookInfo);
        return getDataTable(list);
    }

    /**
     * 导出小说信息列表
     */
    @RequiresPermissions("book:bookInfo:export")
    @Log(title = "小说信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BookInfo bookInfo)
    {
        List<BookInfo> list = bookInfoService.selectBookInfoList(bookInfo);
        ExcelUtil<BookInfo> util = new ExcelUtil<BookInfo>(BookInfo.class);
        return util.exportExcel(list, "小说信息数据");
    }

    /**
     * 新增小说信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小说信息
     */
    @RequiresPermissions("book:bookInfo:add")
    @Log(title = "小说信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BookInfo bookInfo)
    {
        return toAjax(bookInfoService.insertBookInfo(bookInfo));
    }

    /**
     * 修改小说信息
     */
    @RequiresPermissions("book:bookInfo:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BookInfo bookInfo = bookInfoService.selectBookInfoById(id);
        mmap.put("bookInfo", bookInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存小说信息
     */
    @RequiresPermissions("book:bookInfo:edit")
    @Log(title = "小说信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BookInfo bookInfo)
    {
        return toAjax(bookInfoService.updateBookInfo(bookInfo));
    }

    /**
     * 删除小说信息
     */
    @RequiresPermissions("book:bookInfo:remove")
    @Log(title = "小说信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bookInfoService.deleteBookInfoByIds(ids));
    }
}
