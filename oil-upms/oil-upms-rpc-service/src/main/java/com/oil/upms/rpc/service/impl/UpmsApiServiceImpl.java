package com.oil.upms.rpc.service.impl;


import com.oil.upms.dao.model.Admin;
import com.oil.upms.dao.model.Oil;
import com.oil.upms.rpc.api.UpmsApiService;
import com.oil.upms.rpc.mapper.UpmsApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户service实现
 * Created by shuzheng on 2016/01/19.
 */
@Transactional
@Service
public class UpmsApiServiceImpl implements UpmsApiService {

    private static Logger _log = LoggerFactory.getLogger(UpmsApiServiceImpl.class);

    @Autowired
    UpmsApiMapper upmsApiMapper;

    @Override
    public Admin selectForUser(String username) {
        return upmsApiMapper.selectForUser(username);
    }

    @Override
    public Admin selectForUser2(String username) {
        return upmsApiMapper.selectForUser(username);
    }

    @Override
    public void insertOilList(List<Oil> oilList) {
        try {
            upmsApiMapper.insertOilList(oilList);
        } catch (Exception e) {
            _log.error(e+"错误"+oilList.toString());
            throw new RuntimeException();
        }
    }

    @Override
    public Oil selectForUserOrderid(int userid, String useorderid) {
        return upmsApiMapper.selectForUserOrderid(userid,useorderid);
    }


}