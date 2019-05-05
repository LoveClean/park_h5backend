package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Park;
import com.springboot.framework.util.ResponseEntity;

public interface ParkService {
    ResponseEntity<Park> selectByPrimaryKey(Integer id);

    ResponseEntity<Park> selectByName(String name);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListByLocation(Integer pageNum, Integer pageSize, String location);
}
