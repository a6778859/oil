package com.oil.upms.rpc.mapper;


import com.oil.upms.dao.model.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * 用户VOMapper
 * Created by shuzheng on 2017/01/07.
 */
public interface UpmsApiMapper {


	Admin selectForUser(@Param("username") String username);

	
}