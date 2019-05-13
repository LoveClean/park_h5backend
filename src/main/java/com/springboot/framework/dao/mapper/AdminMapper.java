package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminMapper extends Mapper<Admin> {
//    @Update("UPDATE sys_admin SET status = -1, update_by = #{updateBy} WHERE id = #{id}")
//    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    @Select("SELECT * FROM sys_admin WHERE status != -1 AND (phone = #{phone} OR account = #{phone}) AND password = #{password}")
    Admin login(@Param("phone") String phone, @Param("password") String password);

    @Select("SELECT * FROM sys_admin WHERE status != -1 AND phone = #{phone}")
    Admin selectByPhone(@Param("phone") String phone);

    @Select("SELECT * FROM sys_admin WHERE status != -1 AND account = #{account}")
    Admin selectByAccount(@Param("account") String account);

    @Select("SELECT * FROM sys_admin WHERE status != -1 AND status != 8 ORDER BY create_date DESC")
    List<Admin> selectList();

    @Select("SELECT * FROM sys_admin WHERE status != -1 AND status != 8 AND CONCAT(`phone`,`account`) LIKE CONCAT('%',#{phone},'%') ORDER BY create_date DESC")
    List<Admin> selectListByPhone(@Param("phone") String phone);

    @Update("UPDATE sys_admin SET password = #{newPassword}, update_by = #{updateBy} WHERE id = #{id} AND password = #{oldPassword}")
    int updateByPassword(@Param("id") Integer id, @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword, @Param("updateBy") String updateBy);
}