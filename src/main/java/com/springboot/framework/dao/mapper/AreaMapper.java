package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Area;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface AreaMapper extends Mapper<Area> {
    @Select("SELECT * FROM tb_area WHERE area_code = #{areaCode}")
    Area selectByAreaCode(@Param("areaCode") String areaCode);
}