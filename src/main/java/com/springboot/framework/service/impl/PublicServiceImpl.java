package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.*;
import com.springboot.framework.dao.mapper.*;
import com.springboot.framework.service.PublicService;
import com.springboot.framework.util.PageUtil;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import com.springboot.framework.vo.HouseVO;
import com.springboot.framework.vo.InformationVO;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    @Resource
    private InformationMapper informationMapper;
    @Resource
    private InformationInfoMapper informationInfoMapper;


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

    @Override
    public PageResponseBean listInformation(Integer pageNum, Integer pageSize, Integer parkId) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Information.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parkId", parkId);
        List<Information> recordList = informationMapper.selectByExample(example);
        return PageUtil.page(recordList);
    }

    @Override
    public ResponseEntity<InformationVO> selectInformation(Integer informationId) {
        Information information = informationMapper.selectByPrimaryKey(informationId);
        InformationInfo informationInfo = informationInfoMapper.selectByPrimaryKey(informationId);
        InformationVO informationVO = new InformationVO(information, informationInfo);
        return ResponseEntityUtil.success(informationVO);
    }
}
