package com.oil.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * 启动解压zhengAdmin-x.x.x.jar到resources目录
 * Created by shuzheng on 2016/12/18.
 */
public class OilAdminUtil implements InitializingBean, ServletContextAware {

    private static Logger _log = LoggerFactory.getLogger(OilAdminUtil.class);

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        _log.info("===== 开始解压oil-admin =====");
        String version = PropertiesFileUtil.getInstance("oil-admin-client").get("oil.admin.version");
        _log.info("oil-admin.jar 版本: {}", version);
        String jarPath = servletContext.getRealPath("/WEB-INF/lib/oil-admin-" + version + ".jar");
        _log.info("oil-admin.jar 包路径: {}", jarPath);
        String resources = servletContext.getRealPath("/") + "/resources/oil-admin";
        _log.info("oil-admin.jar 解压到: {}", resources);
        JarUtil.decompress(jarPath, resources);
        _log.info("===== 解压oil-admin完成 =====");
    }

}
