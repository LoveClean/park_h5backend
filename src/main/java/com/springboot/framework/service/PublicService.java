package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.vo.InformationVO;

public interface PublicService {
    PageResponseBean listSlideshow(Integer pageNum, Integer pageSize, Integer parkId);

    PageResponseBean listEnterprise(Integer pageNum, Integer pageSize, Integer parkId);

    PageResponseBean listHouse(Integer pageNum, Integer pageSize, Integer parkId);

    PageResponseBean listInformation(Integer pageNum, Integer pageSize, Integer parkId);

    ResponseEntity<InformationVO> selectInformation(Integer informationId);
}
