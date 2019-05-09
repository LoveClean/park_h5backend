package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Slideshow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SlideshowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Slideshow record);

    int insertSelective(Slideshow record);

    Slideshow selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_slideshow WHERE status = 1 AND park_id = #{parkId} ORDER BY create_date DESC")
    List<Slideshow> selectListByParkId(@Param("parkId")Integer parkId);

    int updateByPrimaryKeySelective(Slideshow record);

    int updateByPrimaryKey(Slideshow record);
}