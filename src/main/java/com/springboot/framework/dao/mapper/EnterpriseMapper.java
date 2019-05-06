package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Enterprise;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_enterprise WHERE status = 1 AND park_id = #{parkId} ORDER BY create_date DESC")
    List<Enterprise> selectListByParkId(@Param("parkId")Integer parkId);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
}