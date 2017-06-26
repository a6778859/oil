package com.oil.upms.web.controller;

import com.oil.common.base.BaseController;
import com.oil.upms.dao.model.AdminExample;
import com.oil.upms.rpc.api.AdminService;
import com.oil.upms.rpc.api.UpmsApiService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后台controller
 * Created by ZhangShuzheng on 2017/01/19.
 */
@Controller
@RequestMapping("/Home")
@Api(value = "后台管理", description = "前台登陆")
public class HomeController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	AdminService adminService;
	@Autowired
	UpmsApiService upmsApiService;



	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {

		System.out.println(upmsApiService.selectForUser("ad"));



		AdminExample admin= new AdminExample();
		admin.createCriteria().andUseridEqualTo(1);
		adminService.deleteBy();
		System.out.println(adminService.countUpsByExample(admin));
		return "/Home/login.jsp";
	}



	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(ModelMap modelMap) {
		AdminExample admin= new AdminExample();
		admin.createCriteria().andUseridEqualTo(1);
		adminService.deleteBy();
		System.out.println(adminService.countUpsByExample(admin));
		return "/Home/usr.jsp";
	}



}