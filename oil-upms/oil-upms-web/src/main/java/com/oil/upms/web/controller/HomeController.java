package com.oil.upms.web.controller;

import com.oil.common.base.BaseController;
import com.oil.common.util.MD5Util;
import com.oil.common.util.RedisUtil;
import com.oil.upms.dao.model.Admin;
import com.oil.upms.dao.model.AdminExample;
import com.oil.upms.rpc.api.AdminService;
import com.oil.upms.rpc.api.OilService;
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
    @Autowired
    OilService oilService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(ModelMap modelMap) throws IOException {
          Admin test = adminService.test(1);
        System.out.println(test+"master");
        test = adminService.insert2(1);
        System.out.println(test+"master");
        return null;
//
//        AdminExample admin = new AdminExample();
//        admin.createCriteria().andUseridEqualTo(1);
        //adminService.deleteBy();
//        System.out.println( adminService.countUpsByExample(admin));
//        System.out.println( adminService.selectByPrimaryKey2(1));
//        System.out.println( adminService.insertByPrimaryKey3(1));
        // System.out.println(adminService.countByExample(admin));


//        Admin test = adminService.test(1);
//        System.out.println(test);
//        Admin test = adminService.selectByPrimaryKey(1);
//        System.out.println(test);


//        Admin test=adminService.selectByPrimaryKey(1);
//        System.out.println(test);


//        Admin a = upmsApiService.selectForUser("admin");
//        //Admin b = upmsApiService.selectForUser2("admin");
//        String sessionId = session.getId().toString();
//
//        session.setAttribute("8859", "8859");
//
//
//        System.out.println((RedisUtil.get(OIL_UPMS_SHIRO_SESSION_ID + "_" + sessionId)));
//
//        write(sessionId);
//        return null;
    }

    class MutliThread extends Thread{
        private int ticket=10;//每个线程都拥有5张票
        MutliThread(String name){
            super(name);//调用父类带参数的构造方法
        }
        public void run(){
            while(ticket>0){
                System.out.println(ticket--+" is saled by "+Thread.currentThread().getName());
                RedisUtil.set(Thread.currentThread().getName(),ticket+"");
                System.out.println("=====");
                System.out.println(ticket+RedisUtil.get(Thread.currentThread().getName())+"11");
                System.out.println(RedisUtil.get(Thread.currentThread().getName())+8859);
                System.out.println("=====");
            }
        }
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2(ModelMap modelMap) throws IOException {
        java.util.Enumeration e = request.getSession().getAttributeNames();
        while (e.hasMoreElements()) {
            String sessionName = (String) e.nextElement();
            System.out.println("\nsession item name=" + sessionName);
            System.out.println("\nsession item value=" + request.getSession().getAttribute(sessionName));
        }
        write(session.getAttribute("8859") + "");
        return null;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        String sessionId = session.getId().toString();
        System.out.println(sessionId);
        return "/home/login.jsp";
    }

    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public String out(ModelMap modelMap) throws IOException {
        SecurityUtils.getSubject().logout();
        return "redirect:/home/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap modelMap) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, MD5Util.MD5(password)));
        } catch (UnknownAccountException e) {
            write("账号或密码错误");
            return null;
        } catch (LockedAccountException e) {
            write("帐号已锁定！请等待20分钟");
            return null;
        }
        return "redirect:/home/user";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(ModelMap modelMap) {
        System.out.println(session.getAttribute("user")+"用户sesson");
        AdminExample admin = new AdminExample();
        admin.createCriteria().andUseridEqualTo(1);
        adminService.deleteBy();
        System.out.println(adminService.countUpsByExample(admin));
        return "/home/user.jsp";
    }


    /**
     * 油卡充值
     * @return
     */
    @RequestMapping(value = "/recharge", method = RequestMethod.GET)
    public String recharge(String useorderid,String userid,String money){
//        Oil oil=new Oil();
//        oil.setUserid(1);
//        oil.setUseorderid(UUID.randomUUID().toString());
//        oil.setAddtime(new Date());
//        oilService.insert(oil);
        return null;
    }






}