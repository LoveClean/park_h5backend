package com.springboot.framework.controller;

import com.springboot.framework.annotation.ACS;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Information;
import com.springboot.framework.service.PublicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = {"公共操作接口"}, produces = "application/json")
@RestController
@RequestMapping("/public/")
public class PublicController {
    @Resource
    private PublicService publicService;

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "轮播图列表", notes = "轮播图列表")
    @GetMapping(value = "listSlideshow")
    public PageResponseBean listSlideshow(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer parkId) {
        return publicService.listSlideshow(pageNum, pageSize, parkId);
    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "入驻企业列表", notes = "入驻企业列表")
    @GetMapping(value = "listEnterprise")
    public PageResponseBean listEnterprise(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer parkId) {
        return publicService.listEnterprise(pageNum, pageSize, parkId);
    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "租房列表", notes = "租房列表")
    @GetMapping(value = "listHouse")
    public PageResponseBean listHouse(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer parkId) {
        return publicService.listHouse(pageNum, pageSize, parkId);
    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "资讯列表", notes = "资讯列表")
    @GetMapping(value = "listInformation")
    public PageResponseBean listInformation(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer parkId) {
        return publicService.listInformation(pageNum, pageSize, parkId);
    }
}
