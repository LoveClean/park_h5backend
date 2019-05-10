package com.springboot.framework.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.App;
import com.springboot.framework.dao.entity.AppDetail;
import com.springboot.framework.dao.mapper.AppDetailMapper;
import com.springboot.framework.dao.mapper.AppMapper;
import com.springboot.framework.dao.mapper.ConnectionMapper;
import com.springboot.framework.service.AppService;
import com.springboot.framework.util.PageUtil;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import com.springboot.framework.vo.AppDetailForContactVO;
import com.springboot.framework.vo.AppDetailVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    @Resource
    private AppMapper appMapper;
    @Resource
    private AppDetailMapper appDetailMapper;
    @Resource
    private ConnectionMapper connectionMapper;

    @Override
    public ResponseEntity<AppDetailVO> selectByPrimaryKey(Integer id) {
        App app = appMapper.selectByPrimaryKey(id);
        AppDetail appDetail = appDetailMapper.selectByPrimaryKey(id);
        AppDetailVO appDetailVO = new AppDetailVO(app, appDetail);
        return ResponseEntityUtil.success(appDetailVO);
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<App> appList = appMapper.selectList();
        return PageUtil.page(appList);
    }

    @Override
    public PageResponseBean selectListByParkId(Integer pageNum, Integer pageSize, Integer parkId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Integer> appIdList = connectionMapper.selectListByParkIdInteger(parkId);
        List<App> appList = Lists.newArrayList();
        for (Integer appId : appIdList) {
            App app = appMapper.selectByPrimaryKey(appId);
            if (app.getStatus() != -1) {
                appList.add(app);
            }
        }
        return PageUtil.page(appIdList, appList);
    }

    @Override
    public ResponseEntity<AppDetailForContactVO> selectByPrimaryKeyForDetail(Integer appId, Integer parkId) {
        AppDetail appDetail = appDetailMapper.selectByAppIdAndParkId(appId, parkId);
        AppDetailForContactVO appDetailForContactVO = new AppDetailForContactVO(appDetail, JSON.parseArray(appDetail.getContact()));
        return ResponseEntityUtil.success(appDetailForContactVO);
    }
}