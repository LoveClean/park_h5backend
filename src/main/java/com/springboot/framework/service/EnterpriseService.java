package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;

public interface EnterpriseService {
    PageResponseBean selectListByParkId(Integer pageNum, Integer pageSize, Integer parkId);
}
