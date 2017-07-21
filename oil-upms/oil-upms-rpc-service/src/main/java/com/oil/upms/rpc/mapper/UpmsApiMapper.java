package com.oil.upms.rpc.mapper;


import com.oil.upms.dao.model.Admin;
import com.oil.upms.dao.model.Oil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户VOMapper
 * Created by shuzheng on 2017/01/07.
 */
public interface UpmsApiMapper {

    Admin selectForUser(@Param("username") String username);

    public void insertOilList(List<Oil> oilList);

    Oil selectForUserOrderid(@Param("userid") int userid,@Param("useorderid")  String useorderid);
}