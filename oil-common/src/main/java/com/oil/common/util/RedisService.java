package com.oil.common.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/6 0006.
 */

public class RedisService {

    // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private Jedis jedis;

    @Resource(name = "jedisConnectionFactory")
    private JedisConnectionFactory jedisConnectionFactory;
    private static Logger _log = LoggerFactory.getLogger(RedisService.class);


    /**
     * 获取一个jedis 客户端
     *
     * @return
     */
    private  synchronized Jedis getJedis() {
        if (jedis == null) {
            jedis=jedisConnectionFactory.getShardInfo().createResource();
            return jedis;
        }
        return jedis;
    }


    public  void set(String key, String value, long liveTime) {
        try {
            if(liveTime<=0){
                liveTime=86400;
            }
            value = StringUtils.isBlank(value) ? "" : value;
            Jedis jedis = getJedis();
            jedis.setex(key, (int) liveTime, value);
            //jedis.close();
        } catch (Exception e) {
            _log.error("Set keyex error : " + e);
        }
    }


    public String get(String key) {
        Jedis jedis = getJedis();
        if (null == jedis) {
            return null;
        }
        String value = jedis.get(key);
        jedis.close();
        return value;
    }


    public void del(String key) {
        try {
            Jedis jedis = getJedis();
            jedis.del(key);
            jedis.close();
        } catch (Exception e) {
            _log.error("Remove keyex error : " + e);
        }
    }
}



