package com.oil.upms.rpc.service.impl;

import com.oil.common.annotation.BaseService;
import com.oil.common.base.BaseServiceImpl;
import com.oil.upms.dao.mapper.AdminMapper;
import com.oil.upms.dao.model.Admin;
import com.oil.upms.dao.model.AdminExample;
import com.oil.upms.rpc.api.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * AdminService实现
 * Created by shuzheng on 2017/6/21.
 */
@Service
@Transactional
@BaseService
public class AdminServiceImpl extends BaseServiceImpl<AdminMapper, Admin, AdminExample> implements AdminService {

    private static Logger _log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    AdminMapper adminMapper;


    @Cacheable(value="base", key = "'selectUpmsPermissionByUpmsUserId_'")
    public long countUpsByExample(AdminExample example) {
        return adminMapper.countByExample(example);

    }

    @CacheEvict(value="base",key="'selectUpmsPermissionByUpmsUserId_'")
    public void deleteBy() {

    }

    @Override
    public Admin test(Integer id) {
        Admin admin=insert2(id);
        System.out.println(admin+"sla");
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin insert2(Integer id) {
//        Admin admin=test(id);
//        System.out.println(admin);
        return adminMapper.selectByPrimaryKey(id);
    }




    public Admin selectByPrimaryKey2(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin insertByPrimaryKey3(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }


}