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
import com.ruoyi.book.domain.NewsContent;
import com.ruoyi.book.service.INewsContentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻内容Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/book/newsContent")
public class NewsContentController extends BaseController
{
    private String prefix = "book/newsContent";

    @Autowired
    private INewsContentService newsContentService;

    @RequiresPermissions("book:newsContent:view")
    @GetMapping()
    public String newsContent()
    {
        return prefix + "/newsContent";
    }

    /**
     * 查询新闻内容列表
     */
    @RequiresPermissions("book:newsContent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NewsContent newsContent)
    {
        startPage();
        List<NewsContent> list = newsContentService.selectNewsContentList(newsContent);
        return getDataTable(list);
    }

    /**
     * 导出新闻内容列表
     */
    @RequiresPermissions("book:newsContent:export")
    @Log(title = "新闻内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NewsContent newsContent)
    {
        List<NewsContent> list = newsContentService.selectNewsContentList(newsContent);
        ExcelUtil<NewsContent> util = new ExcelUtil<NewsContent>(NewsContent.class);
        return util.exportExcel(list, "新闻内容数据");
    }

    /**
     * 新增新闻内容
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存新闻内容
     */
    @RequiresPermissions("book:newsContent:add")
    @Log(title = "新闻内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NewsContent newsContent)
    {
        return toAjax(newsContentService.insertNewsContent(newsContent));
    }

    /**
     * 修改新闻内容
     */
    @RequiresPermissions("book:newsContent:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NewsContent newsContent = newsContentService.selectNewsContentById(id);
        mmap.put("newsContent", newsContent);
        return prefix + "/edit";
    }

    /**
     * 修改保存新闻内容
     */
    @RequiresPermissions("book:newsContent:edit")
    @Log(title = "新闻内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NewsContent newsContent)
    {
        return toAjax(newsContentService.updateNewsContent(newsContent));
    }

    /**
     * 删除新闻内容
     */
    @RequiresPermissions("book:newsContent:remove")
    @Log(title = "新闻内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(newsContentService.deleteNewsContentByIds(ids));
    }
}
