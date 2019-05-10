package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Park;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ParkMapper extends Mapper<Park> {
    @Select("SELECT * FROM tb_park WHERE status = 1 AND name = #{name}")
    Park selectByName(@Param("name") String name);

    @Select("SELECT * FROM tb_park WHERE status = 1 ORDER BY create_date DESC")
    List<Park> selectList();

    @Select("SELECT * FROM tb_park WHERE status = 1 AND location = #{location} ORDER BY create_date DESC")
    List<Park> selectListByLocation(@Param("location") String location);
}