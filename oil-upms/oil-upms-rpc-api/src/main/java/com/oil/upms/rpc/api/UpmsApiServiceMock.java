package com.oil.upms.rpc.api;

import com.oil.upms.dao.model.Admin;
import com.oil.upms.dao.model.Oil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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

    @Override
    public Admin selectForUser2(String username) {
        return null;
    }

    @Override
    public void insertOilList(List<Oil> oilList) {

    }

    @Override
    public Oil selectForUserOrderid(int userid, String useorderid) {
        return null;
    }
}
