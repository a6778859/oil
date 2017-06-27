package com.oil.upms.web.controller;

import com.oil.common.base.BaseController;
import com.oil.common.util.MD5Util;
import com.oil.upms.dao.model.AdminExample;
import com.oil.upms.rpc.api.AdminService;
import com.oil.upms.rpc.api.UpmsApiService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/19.
 */
@Controller
@RequestMapping("/home")
@Api(value = "后台管理", description = "前台登陆")
public class HomeController extends BaseController {

    private static Logger _log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    AdminService adminService;
    @Autowired
    UpmsApiService upmsApiService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "/home/login.jsp";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap modelMap) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, MD5Util.MD5(password)));
        }catch (UnknownAccountException e){
            write("账号或密码错误");
            return null;
        }catch (LockedAccountException e){
            write("帐号已锁定！");
            return null;
        }
        return "redirect:/home/user";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(ModelMap modelMap) {
        AdminExample admin = new AdminExample();
        admin.createCriteria().andUseridEqualTo(1);
        adminService.deleteBy();
        System.out.println(adminService.countUpsByExample(admin));
        return "/home/user.jsp";
    }


}