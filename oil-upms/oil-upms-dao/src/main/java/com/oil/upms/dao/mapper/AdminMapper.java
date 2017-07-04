package com.oil.upms.dao.mapper;

import com.oil.upms.dao.model.Admin;
import com.oil.upms.dao.model.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);
    Admin selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}