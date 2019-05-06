package com.springboot.framework.controller;

import com.springboot.framework.annotation.ACS;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.service.EnterpriseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "企业入驻操作接口", produces = "application/json")
@RestController
@RequestMapping("/enterprise/")
public class EnterpriseController {
    @Resource
    private EnterpriseService enterpriseService;

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "根据parkId查看列表", notes = "根据parkId查看租房列表")
    @GetMapping(value = "selectListByParkId")
    public PageResponseBean selectListByParkId(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer parkId) {
        return enterpriseService.selectListByParkId(pageNum, pageSize, parkId);
    }
}
