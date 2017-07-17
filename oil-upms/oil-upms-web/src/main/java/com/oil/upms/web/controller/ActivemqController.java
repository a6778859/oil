package com.oil.upms.web.controller;

import com.oil.common.base.BaseController;

import org.apache.activemq.ScheduledMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import test.QueueSender;

import javax.jms.*;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/7/14 0014.
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController {

    @Resource
    QueueSender queueSender;

    /**
     * 发送消息到队列
     *
     * @return String
     */
    @RequestMapping("/index")
    public String index() {
        return "/activemq/index.jsp";
    }


    /**
     * 发送消息到队列
     *
     * @param message
     * @return String
     */
    @ResponseBody
    @RequestMapping("queueSender")
    public String queueSender(@RequestParam("message") String message, Session session) throws JMSException {
        String opt = "";
//        try {
//
//            int i=0;
//            for(i=0;i<=10;i++){
//                queueSender.send("test.queue", "第条消息"+i);
//            }
//            opt="suc";
//        } catch (Exception e) {
//            opt=e.getCause().toString();
//        }


        Destination destination = session.createQueue("test.queue");
        MessageProducer producer = session.createProducer(destination);
        TextMessage message2 = session.createTextMessage("test msg");
        long time = 5 * 1000;
        for (int i = 0; i < 5; i++) {
            message2.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, time);
        }
        return opt;
    }


}