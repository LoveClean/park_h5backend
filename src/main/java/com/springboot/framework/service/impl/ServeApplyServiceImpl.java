package com.springboot.framework.service.impl;

import com.springboot.framework.dao.entity.ServeApply;
import com.springboot.framework.dao.mapper.ServeApplyMapper;
import com.springboot.framework.service.ServeApplyService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServeApplyServiceImpl implements ServeApplyService {
    @Resource
    private ServeApplyMapper serveApplyMapper;

    @Override
    public ResponseEntity<Integer> insertSelective(ServeApply record) {
        return ResponseEntityUtil.success(serveApplyMapper.insertSelective(record));
    }
}
