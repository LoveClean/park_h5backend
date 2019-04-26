package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.House;
import com.springboot.framework.dao.entity.HousePicture;
import com.springboot.framework.dao.mapper.HouseMapper;
import com.springboot.framework.dao.mapper.HousePictureMapper;
import com.springboot.framework.service.HouseService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import com.springboot.framework.vo.HouseVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Resource
    private HouseMapper houseMapper;
    @Resource
    private HousePictureMapper housePictureMapper;

    @Override
    public PageResponseBean selectListByParkId(Integer pageNum, Integer pageSize, Integer parkId) {
        PageHelper.startPage(pageNum, pageSize);
        List<House> houseList = houseMapper.selectListByParkId(parkId);
        List<HouseVO> houseVOList = Lists.newArrayList();
        for (House house : houseList) {
            List<HousePicture> pictureList = housePictureMapper.selectListByHouseId(house.getId());
            HouseVO houseVO = new HouseVO(house, pictureList);
            houseVOList.add(houseVO);
        }
        PageInfo pageInfo = new PageInfo(houseList);
        pageInfo.setList(houseVOList);
        PageResponseBean page = new PageResponseBean<House>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }
}
