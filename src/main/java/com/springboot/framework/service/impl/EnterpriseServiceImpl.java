package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Enterprise;
import com.springboot.framework.dao.mapper.EnterpriseMapper;
import com.springboot.framework.service.EnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Override
    public PageResponseBean selectListByParkId(Integer pageNum, Integer pageSize, Integer parkId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Enterprise> enterpriseList = enterpriseMapper.selectListByParkId(parkId);
//        List<HouseVO> houseVOList = Lists.newArrayList();
//        for (Enterprise enterprise : enterpriseList) {
//            List<HousePicture> pictureList = housePictureMapper.selectListByHouseId(enterprise.getId());
//            HouseVO houseVO = new HouseVO(enterprise, pictureList);
//            houseVOList.add(houseVO);
//        }
        PageInfo pageInfo = new PageInfo(enterpriseList);
//        pageInfo.setList(houseVOList);
        pageInfo.setList(enterpriseList);
        PageResponseBean page = new PageResponseBean<Enterprise>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }
}
