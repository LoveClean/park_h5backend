package com.springboot.framework.controller;

import com.springboot.framework.annotation.ACS;
import com.springboot.framework.controller.request.ServeApplyInsertSelective;
import com.springboot.framework.dao.entity.ServeApply;
import com.springboot.framework.service.ServeApplyService;
import com.springboot.framework.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = {"宽带电话操作接口"}, produces = "application/json")
@RestController
@RequestMapping("/serveApply/")
public class ServeApplyController {
    @Resource
    private ServeApplyService serveApplyService;

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "新增", notes = "")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@RequestBody ServeApplyInsertSelective bean) {
        ServeApply serveApply = new ServeApply();
        serveApply.setContact(bean.getContact());
        serveApply.setName(bean.getName());
        return serveApplyService.insertSelective(serveApply);
    }
}
