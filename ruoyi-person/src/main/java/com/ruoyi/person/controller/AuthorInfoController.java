package com.ruoyi.person.controller;

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
import com.ruoyi.person.domain.AuthorInfo;
import com.ruoyi.person.service.IAuthorInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 作者信息Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/person/authorInfo")
public class AuthorInfoController extends BaseController
{
    private String prefix = "person/authorInfo";

    @Autowired
    private IAuthorInfoService authorInfoService;

    @RequiresPermissions("person:authorInfo:view")
    @GetMapping()
    public String authorInfo()
    {
        return prefix + "/authorInfo";
    }

    /**
     * 查询作者信息列表
     */
    @RequiresPermissions("person:authorInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AuthorInfo authorInfo)
    {
        startPage();
        List<AuthorInfo> list = authorInfoService.selectAuthorInfoList(authorInfo);
        return getDataTable(list);
    }

    /**
     * 导出作者信息列表
     */
    @RequiresPermissions("person:authorInfo:export")
    @Log(title = "作者信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuthorInfo authorInfo)
    {
        List<AuthorInfo> list = authorInfoService.selectAuthorInfoList(authorInfo);
        ExcelUtil<AuthorInfo> util = new ExcelUtil<AuthorInfo>(AuthorInfo.class);
        return util.exportExcel(list, "作者信息数据");
    }

    /**
     * 新增作者信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存作者信息
     */
    @RequiresPermissions("person:authorInfo:add")
    @Log(title = "作者信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AuthorInfo authorInfo)
    {
        return toAjax(authorInfoService.insertAuthorInfo(authorInfo));
    }

    /**
     * 修改作者信息
     */
    @RequiresPermissions("person:authorInfo:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AuthorInfo authorInfo = authorInfoService.selectAuthorInfoById(id);
        mmap.put("authorInfo", authorInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存作者信息
     */
    @RequiresPermissions("person:authorInfo:edit")
    @Log(title = "作者信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AuthorInfo authorInfo)
    {
        return toAjax(authorInfoService.updateAuthorInfo(authorInfo));
    }

    /**
     * 删除作者信息
     */
    @RequiresPermissions("person:authorInfo:remove")
    @Log(title = "作者信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(authorInfoService.deleteAuthorInfoByIds(ids));
    }
}
