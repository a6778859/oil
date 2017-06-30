package com.oil.upms.rpc.service.impl;

import com.oil.common.annotation.BaseService;
import com.oil.common.base.BaseServiceImpl;
import com.oil.common.db.DataSourceEnum;
import com.oil.common.db.DynamicDataSource;
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

    @Cacheable(value = "base", key = "'selectUpmsPermissionByUpmsUserId_'")
    public long countUpsByExample(AdminExample example) {
        //DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
        return adminMapper.countByExample(example);

    }

    @CacheEvict(value = "base", key = "'selectUpmsPermissionByUpmsUserId_'", beforeInvocation = true)
    public void deleteBy() {

    }


    public Admin selectByPrimaryKey2(Integer id) {
        DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
        return adminMapper.selectByPrimaryKey(id);
    }


}