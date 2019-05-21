package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Area;
import com.springboot.framework.dao.entity.Park;
import com.springboot.framework.dao.mapper.AreaMapper;
import com.springboot.framework.dao.mapper.ConnectionMapper;
import com.springboot.framework.dao.mapper.ParkMapper;
import com.springboot.framework.service.ParkService;
import com.springboot.framework.util.PageUtil;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import com.springboot.framework.vo.ParkVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkServiceImpl implements ParkService {
    @Resource
    private ParkMapper parkMapper;
    @Resource
    private AreaMapper areaMapper;

    @Override
    public ResponseEntity<Park> selectByPrimaryKey(Integer id) {
        return ResponseEntityUtil.success(parkMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity<Park> selectByName(String name) {
        return ResponseEntityUtil.success(parkMapper.selectByName(name));
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Park> parkList = parkMapper.selectList();
//        List<ParkVO> parkVOList = Lists.newArrayList();
//        for (Park park : parkList) {
//            Area area = areaMapper.selectByAreaCode(park.getLocation());
//            ParkVO parkVO = new ParkVO(park, area);
//            parkVOList.add(parkVO);
//        }
//        return PageUtil.page(parkList,parkVOList);
        return PageUtil.page(parkList);
    }

    @Override
    public PageResponseBean selectListByLocation(Integer pageNum, Integer pageSize, String location) {
        PageHelper.startPage(pageNum, pageSize);
        List<Park> parkList = parkMapper.selectListByLocation(location);
        return PageUtil.page(parkList);
    }
}
