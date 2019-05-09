package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Enterprise;
import com.springboot.framework.dao.entity.House;
import com.springboot.framework.dao.entity.HousePicture;
import com.springboot.framework.dao.entity.Slideshow;
import com.springboot.framework.dao.mapper.EnterpriseMapper;
import com.springboot.framework.dao.mapper.HouseMapper;
import com.springboot.framework.dao.mapper.HousePictureMapper;
import com.springboot.framework.dao.mapper.SlideshowMapper;
import com.springboot.framework.service.PublicService;
import com.springboot.framework.util.PageUtil;
import com.springboot.framework.vo.HouseVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PublicServiceImpl implements PublicService {
    @Resource
    private SlideshowMapper slideshowMapper;
    @Resource
    private EnterpriseMapper enterpriseMapper;
    @Resource
    private HouseMapper houseMapper;
    @Resource
    private HousePictureMapper housePictureMapper;

    @Override
    public PageResponseBean listSlideshow(Integer pageNum, Integer pageSize, Integer parkId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Slideshow> recordList = slideshowMapper.selectListByParkId(parkId);
        return PageUtil.page(recordList);
    }

    @Override
    public PageResponseBean listEnterprise(Integer pageNum, Integer pageSize, Integer parkId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Enterprise> recordList = enterpriseMapper.selectListByParkId(parkId);
        return PageUtil.page(recordList);
    }

    @Override
    public PageResponseBean listHouse(Integer pageNum, Integer pageSize, Integer parkId) {
        PageHelper.startPage(pageNum, pageSize);
        List<House> recordList = houseMapper.selectListByParkId(parkId);
        List<HouseVO> houseVOList = Lists.newArrayList();
        for (House house : recordList) {
            List<HousePicture> pictureList = housePictureMapper.selectListByHouseId(house.getId());
            HouseVO houseVO = new HouseVO(house, pictureList);
            houseVOList.add(houseVO);
        }
        return PageUtil.page(recordList, houseVOList);
    }
}
