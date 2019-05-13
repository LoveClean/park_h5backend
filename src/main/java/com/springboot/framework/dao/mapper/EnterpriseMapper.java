package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Enterprise;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EnterpriseMapper extends Mapper<Enterprise> {
    @Select("SELECT * FROM tb_enterprise WHERE status = 1 AND park_id = #{parkId} ORDER BY create_date DESC")
    List<Enterprise> selectListByParkId(@Param("parkId")Integer parkId);
}