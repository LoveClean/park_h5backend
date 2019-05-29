package com.springboot.framework.service;

import com.springboot.framework.dao.entity.ServeApply;
import com.springboot.framework.util.ResponseEntity;

public interface ServeApplyService {
    ResponseEntity<Integer> insertSelective(ServeApply record);
}
