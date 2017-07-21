package com.oil.upms.web.controller;

import com.oil.common.base.BaseController;
import com.oil.upms.client.session.SerializableUtil;
import com.oil.upms.dao.model.Oil;
import com.oil.upms.rpc.api.OilService;
import com.oil.upms.rpc.api.UpmsApiService;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Created by Administrator on 2017/7/14 0014.
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController extends BaseController {

    private static Logger _log = LoggerFactory.getLogger(ActivemqController.class);
    static java.util.Queue<Oil> queue = new ConcurrentLinkedQueue<Oil>();

    @Autowired
    UpmsApiService upmsApiService;
    @Autowired
    OilService oilService;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private static int test_i=0;
    /**
     * 发送消息到队列
     *
     * @return String
     */
    @RequestMapping("/index")
    public String index() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//      queue.add(session.getId()+"100"+df.format(new Date()));
        Oil oil = null;
        for (int i = 0; i < 1; i++) {
            oil = new Oil();
            oil.setUserid(test_i++);
            oil.setUseorderid(UUID.randomUUID() + "");
            oil.setAddtime(new Date());
            oil.setRemark(i + "");
            queue.add(oil);
        }

//        oil = new Oil();
//        oil.setUserid(1);
//        oil.setUseorderid("1");
//        oil.setAddtime(new Date());
//        //oil.setRemark(i + "");
//        queue.add(oil);
//        queue.add(oil);

        //oilService.insert(oil);
        return "/activemq/index.jsp";
    }


    /**
     * 发送消息到队列
     *
     * @param message
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "/queueSender")
    public String queueSender(@RequestParam("message") String message) {
        String opt = "";
        try {
//            queueSender.send("test.queue", message);
            opt = "suc";
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }

    /**
     * 油卡充值批量插入
     *
     * @return
     */
    @RequestMapping(value = "/recharge", method = RequestMethod.GET)
    public synchronized String recharge() {
        System.exit(0);

        try {
            //没1000条插入
            List<Oil> oilList = new ArrayList();
            int batchCount = 1000;// 每批commit的个数
            int batchLastIndex = batchCount;// 每批最后一个的下标
            Oil oil;
            while (!queue.isEmpty()) {
                oil = queue.poll();
                oilList.add(oil);
            }
            int total_size = 0;
            if (!oilList.isEmpty() && oilList.size() > 0) {
                total_size = oilList.size();
            }
            if (total_size > 0) {
                for (int index = 0; index < total_size; ) {
                    if (batchLastIndex >= total_size) {
                        batchLastIndex = total_size;
                        upmsApiService.insertOilList(oilList.subList(index, batchLastIndex));
                        break;
                    } else {
                        upmsApiService.insertOilList(oilList.subList(index, batchLastIndex));
                        index = batchLastIndex;
                        batchLastIndex = index + (batchCount - 1);
                    }
                }
            }
        } catch (Exception e) {
            _log.info("系统异常");
        }
        return null;
    }


    //多线程插入数据库
    @ResponseBody
    @RequestMapping(value = "/threadInsert")
    public synchronized String threadInsert() {
        Map<String, List> map = new HashMap<>();
        Oil oil;
        while (!queue.isEmpty()) {
            oil = queue.poll();
            if (map.containsKey(oil.getUserid() + "")) {
                map.get(oil.getUserid() + "").add(oil);
            } else {
                List vals = new ArrayList();
                vals.add(oil);
                map.put(oil.getUserid() + "", vals);
            }

        }
        //开始处理
        if (!map.isEmpty()) {
            //根据用户数量创建线程
            for (final Map.Entry<String, List> entry : map.entrySet()) {
                threadPoolTaskExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        Iterator it = entry.getValue().iterator();
                        while (it.hasNext()) {
                            Oil oil_ = (Oil) it.next();
                            //查找判断当前是否入库
                            Oil oil_2 = upmsApiService.selectForUserOrderid(oil_.getUserid(), oil_.getUseorderid());
                            if (oil_2 == null) {
                                //开始插入
                                oilService.insert(oil_);
                            } else {
                                oil_2.setRemark("订单已经入库请不要重复提交");
                                oilService.updateByPrimaryKeySelective(oil_2);
                            }
                        }
                    }
                });
            }
        }
        return null;
    }


}