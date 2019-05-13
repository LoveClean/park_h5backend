package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.AppDetail;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface AppDetailMapper extends Mapper<AppDetail> {
    @Select("SELECT * FROM tb_app_detail WHERE app_id = #{appId} AND park_id = #{parkId}")
    AppDetail selectByAppIdAndParkId(Integer appId, Integer parkId);
}