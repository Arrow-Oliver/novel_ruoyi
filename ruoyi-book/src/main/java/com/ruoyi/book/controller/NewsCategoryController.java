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
import com.ruoyi.book.domain.NewsCategory;
import com.ruoyi.book.service.INewsCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻类别Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/book/newsCategory")
public class NewsCategoryController extends BaseController
{
    private String prefix = "book/newsCategory";

    @Autowired
    private INewsCategoryService newsCategoryService;

    @RequiresPermissions("book:newsCategory:view")
    @GetMapping()
    public String newsCategory()
    {
        return prefix + "/newsCategory";
    }

    /**
     * 查询新闻类别列表
     */
    @RequiresPermissions("book:newsCategory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NewsCategory newsCategory)
    {
        startPage();
        List<NewsCategory> list = newsCategoryService.selectNewsCategoryList(newsCategory);
        return getDataTable(list);
    }

    /**
     * 导出新闻类别列表
     */
    @RequiresPermissions("book:newsCategory:export")
    @Log(title = "新闻类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NewsCategory newsCategory)
    {
        List<NewsCategory> list = newsCategoryService.selectNewsCategoryList(newsCategory);
        ExcelUtil<NewsCategory> util = new ExcelUtil<NewsCategory>(NewsCategory.class);
        return util.exportExcel(list, "新闻类别数据");
    }

    /**
     * 新增新闻类别
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存新闻类别
     */
    @RequiresPermissions("book:newsCategory:add")
    @Log(title = "新闻类别", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NewsCategory newsCategory)
    {
        return toAjax(newsCategoryService.insertNewsCategory(newsCategory));
    }

    /**
     * 修改新闻类别
     */
    @RequiresPermissions("book:newsCategory:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NewsCategory newsCategory = newsCategoryService.selectNewsCategoryById(id);
        mmap.put("newsCategory", newsCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存新闻类别
     */
    @RequiresPermissions("book:newsCategory:edit")
    @Log(title = "新闻类别", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NewsCategory newsCategory)
    {
        return toAjax(newsCategoryService.updateNewsCategory(newsCategory));
    }

    /**
     * 删除新闻类别
     */
    @RequiresPermissions("book:newsCategory:remove")
    @Log(title = "新闻类别", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(newsCategoryService.deleteNewsCategoryByIds(ids));
    }
}
