package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.App;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppMapper extends Mapper<App> {
    @Select("SELECT * FROM tb_app WHERE status = 1 ORDER BY create_date DESC")
    List<App> selectList();
}