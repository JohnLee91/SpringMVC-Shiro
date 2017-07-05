package org.seckill.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.seckill.entity.SysLog;
import org.seckill.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>User: JohnLee
 * <p>Date: 2017-7-4 14:27:24
 * <p>Version: 1.0
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequiresPermissions("sysLog:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("sysLogList", sysLogService.findAll());
        return "sysLog/list";
    }

    @RequiresPermissions("sysLog:view")
    @RequestMapping(value = "/{sysLogId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("sysLogId") Long sysLogId, Model model) {
        if (sysLogId == null) {
            return "redirect:/sysLog/list";
        }
        SysLog sysLog = sysLogService.selectById(sysLogId);
        if (sysLog == null) {
            return "forward:/sysLog/list";
        }
        model.addAttribute("sysLog", sysLog);

        return "sysLog/detail";
    }

}
