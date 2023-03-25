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
import com.ruoyi.person.domain.UserCommentReply;
import com.ruoyi.person.service.IUserCommentReplyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户评论回复Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/person/userCommentReply")
public class UserCommentReplyController extends BaseController
{
    private String prefix = "person/userCommentReply";

    @Autowired
    private IUserCommentReplyService userCommentReplyService;

    @RequiresPermissions("person:userCommentReply:view")
    @GetMapping()
    public String userCommentReply()
    {
        return prefix + "/userCommentReply";
    }

    /**
     * 查询用户评论回复列表
     */
    @RequiresPermissions("person:userCommentReply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserCommentReply userCommentReply)
    {
        startPage();
        List<UserCommentReply> list = userCommentReplyService.selectUserCommentReplyList(userCommentReply);
        return getDataTable(list);
    }

    /**
     * 导出用户评论回复列表
     */
    @RequiresPermissions("person:userCommentReply:export")
    @Log(title = "用户评论回复", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserCommentReply userCommentReply)
    {
        List<UserCommentReply> list = userCommentReplyService.selectUserCommentReplyList(userCommentReply);
        ExcelUtil<UserCommentReply> util = new ExcelUtil<UserCommentReply>(UserCommentReply.class);
        return util.exportExcel(list, "用户评论回复数据");
    }

    /**
     * 新增用户评论回复
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户评论回复
     */
    @RequiresPermissions("person:userCommentReply:add")
    @Log(title = "用户评论回复", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserCommentReply userCommentReply)
    {
        return toAjax(userCommentReplyService.insertUserCommentReply(userCommentReply));
    }

    /**
     * 修改用户评论回复
     */
    @RequiresPermissions("person:userCommentReply:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UserCommentReply userCommentReply = userCommentReplyService.selectUserCommentReplyById(id);
        mmap.put("userCommentReply", userCommentReply);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户评论回复
     */
    @RequiresPermissions("person:userCommentReply:edit")
    @Log(title = "用户评论回复", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserCommentReply userCommentReply)
    {
        return toAjax(userCommentReplyService.updateUserCommentReply(userCommentReply));
    }

    /**
     * 删除用户评论回复
     */
    @RequiresPermissions("person:userCommentReply:remove")
    @Log(title = "用户评论回复", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userCommentReplyService.deleteUserCommentReplyByIds(ids));
    }
}
