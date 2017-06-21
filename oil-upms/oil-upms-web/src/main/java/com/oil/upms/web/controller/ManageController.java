package com.oil.upms.web.controller;

import com.oil.common.base.BaseController;
import com.oil.upms.dao.model.AdminExample;
import com.oil.upms.rpc.api.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
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
@RequestMapping("/manage")
@Api(value = "后台管理", description = "后台管理")
public class ManageController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(ManageController.class);

	@Autowired
	AdminService adminService;

	@ApiOperation(value = "后台首页")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		AdminExample admin= new AdminExample();
		admin.createCriteria().andUseridEqualTo(1);

		CacheManager manager = CacheManager.create();
		Cache cache = manager.getCache("zheng-upms-rpc-service-ehcache");
		if(cache!=null&&cache.isKeyInCache("selectUpmsPermissionByUpmsUserId_")) {

			cache.remove("selectUpmsPermissionByUpmsUserId_");
		}
		System.out.println(adminService.countUpsByExample(admin));

		return "/manage/index.jsp";
	}

}