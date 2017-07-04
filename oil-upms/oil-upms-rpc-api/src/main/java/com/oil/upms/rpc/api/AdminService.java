package com.oil.upms.rpc.api;

import com.oil.common.base.BaseService;
import com.oil.upms.dao.model.Admin;
import com.oil.upms.dao.model.AdminExample;

/**
* AdminService接口
* Created by shuzheng on 2017/6/21.
*/
public interface AdminService extends BaseService<Admin, AdminExample> {

    public long countUpsByExample(AdminExample example);

    Admin selectByPrimaryKey2(Integer id);


    public void deleteBy();

    Admin test(Integer id);
}