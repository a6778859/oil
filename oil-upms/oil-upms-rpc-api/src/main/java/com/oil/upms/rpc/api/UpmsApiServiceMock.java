package com.oil.upms.rpc.api;

import com.oil.upms.dao.model.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 降级实现UpmsApiService接口
 * Created by shuzheng on 2017/2/14.
 */
public class UpmsApiServiceMock implements UpmsApiService {

    private static Logger _log = LoggerFactory.getLogger(UpmsApiServiceMock.class);


    @Override
    public Admin selectForUser(String username) {
        return null;
    }
}
