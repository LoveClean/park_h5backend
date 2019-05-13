package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Slideshow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SlideshowMapper extends Mapper<Slideshow> {
    @Select("SELECT * FROM tb_slideshow WHERE status = 1 AND park_id = #{parkId} ORDER BY create_date DESC")
    List<Slideshow> selectListByParkId(@Param("parkId") Integer parkId);
}