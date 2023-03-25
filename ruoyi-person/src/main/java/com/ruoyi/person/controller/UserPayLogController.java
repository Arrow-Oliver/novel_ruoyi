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
import com.ruoyi.person.domain.UserPayLog;
import com.ruoyi.person.service.IUserPayLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户充值记录Controller
 * 
 * @author ruoyi
 * @date 2023-03-25
 */
@Controller
@RequestMapping("/person/userPayLog")
public class UserPayLogController extends BaseController
{
    private String prefix = "person/userPayLog";

    @Autowired
    private IUserPayLogService userPayLogService;

    @RequiresPermissions("person:userPayLog:view")
    @GetMapping()
    public String userPayLog()
    {
        return prefix + "/userPayLog";
    }

    /**
     * 查询用户充值记录列表
     */
    @RequiresPermissions("person:userPayLog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserPayLog userPayLog)
    {
        startPage();
        List<UserPayLog> list = userPayLogService.selectUserPayLogList(userPayLog);
        return getDataTable(list);
    }

    /**
     * 导出用户充值记录列表
     */
    @RequiresPermissions("person:userPayLog:export")
    @Log(title = "用户充值记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserPayLog userPayLog)
    {
        List<UserPayLog> list = userPayLogService.selectUserPayLogList(userPayLog);
        ExcelUtil<UserPayLog> util = new ExcelUtil<UserPayLog>(UserPayLog.class);
        return util.exportExcel(list, "用户充值记录数据");
    }

    /**
     * 新增用户充值记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户充值记录
     */
    @RequiresPermissions("person:userPayLog:add")
    @Log(title = "用户充值记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserPayLog userPayLog)
    {
        return toAjax(userPayLogService.insertUserPayLog(userPayLog));
    }

    /**
     * 修改用户充值记录
     */
    @RequiresPermissions("person:userPayLog:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UserPayLog userPayLog = userPayLogService.selectUserPayLogById(id);
        mmap.put("userPayLog", userPayLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户充值记录
     */
    @RequiresPermissions("person:userPayLog:edit")
    @Log(title = "用户充值记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserPayLog userPayLog)
    {
        return toAjax(userPayLogService.updateUserPayLog(userPayLog));
    }

    /**
     * 删除用户充值记录
     */
    @RequiresPermissions("person:userPayLog:remove")
    @Log(title = "用户充值记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userPayLogService.deleteUserPayLogByIds(ids));
    }
}
