package org.seckill.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.seckill.util.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = MessageUtils.message("user.not.exists");
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = MessageUtils.message("user.password.not.match");
        } else if(exceptionClassName != null) {
            error = exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }


}
