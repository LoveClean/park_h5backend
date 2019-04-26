package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.HousePicture;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HousePictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HousePicture record);

    int insertSelective(HousePicture record);

    HousePicture selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_house_picture WHERE house_id = #{houseId}")
    List<HousePicture> selectListByHouseId(@Param("houseId")Integer houseId);

    int updateByPrimaryKeySelective(HousePicture record);

    int updateByPrimaryKey(HousePicture record);
}