package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Information;

import java.util.List;

public interface PublicService {
    PageResponseBean listSlideshow(Integer pageNum, Integer pageSize, Integer parkId);

    PageResponseBean listEnterprise(Integer pageNum, Integer pageSize, Integer parkId);

    PageResponseBean listHouse(Integer pageNum, Integer pageSize, Integer parkId);

    PageResponseBean listInformation(Integer pageNum, Integer pageSize, Integer parkId);

    List<Information> listInformation2(Integer pageNum, Integer pageSize, Integer parkId);
}
