package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.House;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_house WHERE status != -1 AND park_id = #{parkId} ORDER BY create_date DESC")
    List<House> selectListByParkId(@Param("parkId")Integer parkId);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
}