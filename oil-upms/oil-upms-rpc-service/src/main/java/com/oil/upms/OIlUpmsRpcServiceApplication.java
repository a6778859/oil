package com.oil.upms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by ZhangShuzheng on 2017/2/3.
 */
public class OIlUpmsRpcServiceApplication {

	private static Logger _log = LoggerFactory.getLogger(OIlUpmsRpcServiceApplication.class);

	public static void main(String[] args) {
		try {
			_log.info(">>>>> oil-upms-rpc-service 正在启动 <<<<<");
			new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
			_log.info(">>>>> oil-upms-rpc-service 启动完成 <<<<<");
		}catch (Exception e){
			System.out.println(e.toString());
		}
		}

}
