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
import com.ruoyi.person.domain.UserComment;
import com.ruoyi.person.service.IUserCommentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户评论Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/person/userComment")
public class UserCommentController extends BaseController
{
    private String prefix = "person/userComment";

    @Autowired
    private IUserCommentService userCommentService;

    @RequiresPermissions("person:userComment:view")
    @GetMapping()
    public String userComment()
    {
        return prefix + "/userComment";
    }

    /**
     * 查询用户评论列表
     */
    @RequiresPermissions("person:userComment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserComment userComment)
    {
        startPage();
        List<UserComment> list = userCommentService.selectUserCommentList(userComment);
        return getDataTable(list);
    }

    /**
     * 导出用户评论列表
     */
    @RequiresPermissions("person:userComment:export")
    @Log(title = "用户评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserComment userComment)
    {
        List<UserComment> list = userCommentService.selectUserCommentList(userComment);
        ExcelUtil<UserComment> util = new ExcelUtil<UserComment>(UserComment.class);
        return util.exportExcel(list, "用户评论数据");
    }

    /**
     * 新增用户评论
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户评论
     */
    @RequiresPermissions("person:userComment:add")
    @Log(title = "用户评论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserComment userComment)
    {
        return toAjax(userCommentService.insertUserComment(userComment));
    }

    /**
     * 修改用户评论
     */
    @RequiresPermissions("person:userComment:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UserComment userComment = userCommentService.selectUserCommentById(id);
        mmap.put("userComment", userComment);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户评论
     */
    @RequiresPermissions("person:userComment:edit")
    @Log(title = "用户评论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserComment userComment)
    {
        return toAjax(userCommentService.updateUserComment(userComment));
    }

    /**
     * 删除用户评论
     */
    @RequiresPermissions("person:userComment:remove")
    @Log(title = "用户评论", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userCommentService.deleteUserCommentByIds(ids));
    }
}
