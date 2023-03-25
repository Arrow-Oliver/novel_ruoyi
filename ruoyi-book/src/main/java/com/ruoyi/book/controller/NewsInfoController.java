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
import com.ruoyi.book.domain.NewsInfo;
import com.ruoyi.book.service.INewsInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻信息Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/book/newsInfo")
public class NewsInfoController extends BaseController
{
    private String prefix = "book/newsInfo";

    @Autowired
    private INewsInfoService newsInfoService;

    @RequiresPermissions("book:newsInfo:view")
    @GetMapping()
    public String newsInfo()
    {
        return prefix + "/newsInfo";
    }

    /**
     * 查询新闻信息列表
     */
    @RequiresPermissions("book:newsInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NewsInfo newsInfo)
    {
        startPage();
        List<NewsInfo> list = newsInfoService.selectNewsInfoList(newsInfo);
        return getDataTable(list);
    }

    /**
     * 导出新闻信息列表
     */
    @RequiresPermissions("book:newsInfo:export")
    @Log(title = "新闻信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NewsInfo newsInfo)
    {
        List<NewsInfo> list = newsInfoService.selectNewsInfoList(newsInfo);
        ExcelUtil<NewsInfo> util = new ExcelUtil<NewsInfo>(NewsInfo.class);
        return util.exportExcel(list, "新闻信息数据");
    }

    /**
     * 新增新闻信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存新闻信息
     */
    @RequiresPermissions("book:newsInfo:add")
    @Log(title = "新闻信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NewsInfo newsInfo)
    {
        return toAjax(newsInfoService.insertNewsInfo(newsInfo));
    }

    /**
     * 修改新闻信息
     */
    @RequiresPermissions("book:newsInfo:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NewsInfo newsInfo = newsInfoService.selectNewsInfoById(id);
        mmap.put("newsInfo", newsInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存新闻信息
     */
    @RequiresPermissions("book:newsInfo:edit")
    @Log(title = "新闻信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NewsInfo newsInfo)
    {
        return toAjax(newsInfoService.updateNewsInfo(newsInfo));
    }

    /**
     * 删除新闻信息
     */
    @RequiresPermissions("book:newsInfo:remove")
    @Log(title = "新闻信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(newsInfoService.deleteNewsInfoByIds(ids));
    }
}
