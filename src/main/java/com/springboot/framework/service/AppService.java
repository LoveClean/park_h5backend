package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.AppDetail;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.vo.AppDetailVO;

import java.util.List;

public interface AppService {
    ResponseEntity<AppDetailVO> selectByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListByParkId(Integer pageNum, Integer pageSize, Integer parkId);

    /////////////////应用详情/////////////////
    ResponseEntity<AppDetail> selectByPrimaryKeyForDetail(Integer appId, Integer parkId);
}
