package org.seckill.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.seckill.entity.SysLog;
import org.seckill.service.SysLogService;
import org.seckill.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: JohnLee
 * <p>Date: 2017-7-4 14:27:24
 * <p>Version: 1.0
 */
@Controller
@RequestMapping("/admin/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequiresPermissions("sysLog:view")
//    @RequestMapping(method = RequestMethod.POST)
    /*@RequestMapping()
    public String list(Model model, @RequestParam("moduleName")String moduleName,@RequestParam("options")String options) {
        model.addAttribute("sysLogList", sysLogService.queryByPage(moduleName,options,1,5));
        return "sysLog/list";
    }*/

    @RequestMapping()
    public String list(HttpServletRequest request,Model model,
                       @RequestParam(value = "moduleName", defaultValue = "")String moduleName,
                       @RequestParam(value = "options", defaultValue = "")String options,
                       @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum) {
        System.out.println("+++++++++++++++");
        System.out.println(moduleName+"-----"+options+"-----"+pageNum);
        model.addAttribute("moduleName",moduleName);
        model.addAttribute("options",options);
        model.addAttribute("pages", sysLogService.queryByPage(moduleName, options,pageNum, Constants.PAGE_SIZE));
        return "sysLog/list";
    }

    @RequiresPermissions("sysLog:view")
    @RequestMapping(value = "/{sysLogId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("sysLogId") Long sysLogId, Model model) {
        if (sysLogId == null) {
            return "redirect:/admin/sysLog/list";
        }
        SysLog sysLog = sysLogService.selectById(sysLogId);
        if (sysLog == null) {
            return "forward:/admin/sysLog/list";
        }
        model.addAttribute("sysLog", sysLog);

        return "sysLog/detail";
    }

}
