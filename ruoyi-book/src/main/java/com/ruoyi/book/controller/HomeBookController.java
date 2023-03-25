package com.ruoyi.book.controller;

import java.util.List;

import com.ruoyi.book.domain.dto.HomeBookDto;
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
import com.ruoyi.book.domain.HomeBook;
import com.ruoyi.book.service.IHomeBookService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小说推荐Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/book/homeBook")
public class HomeBookController extends BaseController
{
    private String prefix = "book/homeBook";

    @Autowired
    private IHomeBookService homeBookService;

    @RequiresPermissions("book:homeBook:view")
    @GetMapping()
    public String homeBook()
    {
        return prefix + "/homeBook";
    }

    /**
     * 查询小说推荐列表
     */
    @RequiresPermissions("book:homeBook:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HomeBook homeBook)
    {
        startPage();
        List<HomeBook> list = homeBookService.selectHomeBookList(homeBook);
        return getDataTable(list);
    }

    /**
     * 导出小说推荐列表
     */
    @RequiresPermissions("book:homeBook:export")
    @Log(title = "小说推荐", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HomeBook homeBook)
    {
        List<HomeBook> list = homeBookService.selectHomeBookList(homeBook);
        ExcelUtil<HomeBook> util = new ExcelUtil<HomeBook>(HomeBook.class);
        return util.exportExcel(list, "小说推荐数据");
    }

    /**
     * 新增小说推荐
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存小说推荐
     */
    @RequiresPermissions("book:homeBook:add")
    @Log(title = "小说推荐", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HomeBook homeBook)
    {
        return toAjax(homeBookService.insertHomeBook(homeBook));
    }

    /**
     * 修改小说推荐
     */
    @RequiresPermissions("book:homeBook:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HomeBook homeBook = homeBookService.selectHomeBookById(id);
        mmap.put("homeBook", homeBook);
        return prefix + "/edit";
    }

    /**
     * 修改保存小说推荐
     */
    @RequiresPermissions("book:homeBook:edit")
    @Log(title = "小说推荐", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HomeBook homeBook)
    {
        return toAjax(homeBookService.updateHomeBook(homeBook));
    }

    /**
     * 删除小说推荐
     */
    @RequiresPermissions("book:homeBook:remove")
    @Log(title = "小说推荐", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(homeBookService.deleteHomeBookByIds(ids));
    }
}
