package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.HousePicture;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HousePictureMapper extends Mapper<HousePicture> {
    @Select("SELECT * FROM tb_house_picture WHERE house_id = #{houseId}")
    List<HousePicture> selectListByHouseId(@Param("houseId")Integer houseId);
}