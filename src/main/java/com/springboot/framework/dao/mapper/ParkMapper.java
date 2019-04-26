package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Park;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ParkMapper {
    @Update("UPDATE tb_park SET status = -1, update_by = #{updateBy} WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(Park record);

    int insertSelective(Park record);

    Park selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_park WHERE status = 1 AND name = #{name}")
    Park selectByName(@Param("name") String name);

    @Select("SELECT * FROM tb_park WHERE status != -1 ORDER BY create_date DESC")
    List<Park> selectList();

    @Select("SELECT * FROM tb_park WHERE status != -1 AND location = #{location} ORDER BY create_date DESC")
    List<Park> selectListByLocation(@Param("location") String location);

    int updateByPrimaryKeySelective(Park record);

    int updateByPrimaryKey(Park record);
}