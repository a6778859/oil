package com.oil.upms.rpc.service.impl;


import com.oil.upms.dao.model.Admin;
import com.oil.upms.rpc.api.UpmsApiService;
import com.oil.upms.rpc.mapper.UpmsApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户service实现
 * Created by shuzheng on 2016/01/19.
 */
@Service
@Transactional
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



}