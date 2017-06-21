package com.oil.upms.dao.mapper;

import com.oil.upms.dao.model.Oil;
import com.oil.upms.dao.model.OilExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OilMapper {
    long countByExample(OilExample example);

    int deleteByExample(OilExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(Oil record);

    int insertSelective(Oil record);

    List<Oil> selectByExample(OilExample example);

    Oil selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") Oil record, @Param("example") OilExample example);

    int updateByExample(@Param("record") Oil record, @Param("example") OilExample example);

    int updateByPrimaryKeySelective(Oil record);

    int updateByPrimaryKey(Oil record);
}