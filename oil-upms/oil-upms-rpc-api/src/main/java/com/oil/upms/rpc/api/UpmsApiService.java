package com.oil.upms.rpc.api;

import com.oil.upms.dao.model.Admin;
import com.oil.upms.dao.model.Oil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * upms系统接口
 * Created by shuzheng on 2017/2/11.
 */
public interface UpmsApiService {

    Admin selectForUser(@Param("username") String username);

    Admin selectForUser2(@Param("username") String username);

    public void insertOilList(List<Oil> oilList);

    Oil selectForUserOrderid(@Param("userid") int userid,@Param("useorderid") String useorderid);

}
