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
import com.ruoyi.book.domain.HomeFriendLink;
import com.ruoyi.book.service.IHomeFriendLinkService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 友情链接Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/book/link")
public class HomeFriendLinkController extends BaseController
{
    private String prefix = "book/link";

    @Autowired
    private IHomeFriendLinkService homeFriendLinkService;

    @RequiresPermissions("book:link:view")
    @GetMapping()
    public String link()
    {
        return prefix + "/link";
    }

    /**
     * 查询友情链接列表
     */
    @RequiresPermissions("book:link:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HomeFriendLink homeFriendLink)
    {
        startPage();
        List<HomeFriendLink> list = homeFriendLinkService.selectHomeFriendLinkList(homeFriendLink);
        return getDataTable(list);
    }

    /**
     * 导出友情链接列表
     */
    @RequiresPermissions("book:link:export")
    @Log(title = "友情链接", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HomeFriendLink homeFriendLink)
    {
        List<HomeFriendLink> list = homeFriendLinkService.selectHomeFriendLinkList(homeFriendLink);
        ExcelUtil<HomeFriendLink> util = new ExcelUtil<HomeFriendLink>(HomeFriendLink.class);
        return util.exportExcel(list, "友情链接数据");
    }

    /**
     * 新增友情链接
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存友情链接
     */
    @RequiresPermissions("book:link:add")
    @Log(title = "友情链接", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HomeFriendLink homeFriendLink)
    {
        return toAjax(homeFriendLinkService.insertHomeFriendLink(homeFriendLink));
    }

    /**
     * 修改友情链接
     */
    @RequiresPermissions("book:link:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HomeFriendLink homeFriendLink = homeFriendLinkService.selectHomeFriendLinkById(id);
        mmap.put("homeFriendLink", homeFriendLink);
        return prefix + "/edit";
    }

    /**
     * 修改保存友情链接
     */
    @RequiresPermissions("book:link:edit")
    @Log(title = "友情链接", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HomeFriendLink homeFriendLink)
    {
        return toAjax(homeFriendLinkService.updateHomeFriendLink(homeFriendLink));
    }

    /**
     * 删除友情链接
     */
    @RequiresPermissions("book:link:remove")
    @Log(title = "友情链接", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(homeFriendLinkService.deleteHomeFriendLinkByIds(ids));
    }
}
