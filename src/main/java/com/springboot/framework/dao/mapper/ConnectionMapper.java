package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Connection;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ConnectionMapper extends Mapper<Connection> {
    @Select("SELECT app_id FROM tb_connection WHERE park_id = #{parkId}")
    List<String> selectListByParkId(@Param("parkId") Integer parkId);

    @Select("SELECT app_id FROM tb_connection WHERE park_id = #{parkId}")
    List<Integer> selectListByParkIdInteger(@Param("parkId") Integer parkId);

    @Select("SELECT park_id FROM tb_connection WHERE app_id = #{appId}")
    List<String> selectListByAppId(@Param("appId") Integer appId);

    @Select("SELECT park_id FROM tb_connection WHERE app_id = #{appId}")
    List<Integer> selectListByAppIdInteger(@Param("appId") Integer appId);
}