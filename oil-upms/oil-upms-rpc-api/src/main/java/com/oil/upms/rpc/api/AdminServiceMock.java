package com.oil.upms.rpc.api;

import com.oil.common.base.BaseServiceMock;
import com.oil.upms.dao.mapper.AdminMapper;
import com.oil.upms.dao.model.Admin;
import com.oil.upms.dao.model.AdminExample;

/**
 * 降级实现AdminService接口
 * Created by shuzheng on 2017/6/21.
 */
public class AdminServiceMock extends BaseServiceMock<AdminMapper, Admin, AdminExample> implements AdminService {

    public long countUpsByExample(AdminExample example) {
        return 0;
    }

    @Override
    public Admin selectByPrimaryKey2(Integer id) {
        return null;
    }

    @Override
    public Admin insertByPrimaryKey3(Integer id) {
        return null;
    }

    @Override
    public void deleteBy() {

    }

    @Override
    public Admin test(Integer id) {
        return null;
    }

    @Override
    public Admin insert2(Integer id) {
        return null;
    }
}
