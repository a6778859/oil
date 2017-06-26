package com.oil.upms.rpc.api;

import com.oil.upms.dao.model.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * upms系统接口
 * Created by shuzheng on 2017/2/11.
 */
public interface UpmsApiService {
    Admin selectForUser(@Param("username") String username);
}
