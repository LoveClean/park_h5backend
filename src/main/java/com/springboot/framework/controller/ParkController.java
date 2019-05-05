package com.springboot.framework.controller;

import com.springboot.framework.annotation.ACS;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Park;
import com.springboot.framework.service.ParkService;
import com.springboot.framework.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(description = "园区操作接口", produces = "application/json")
@RestController
@RequestMapping("/park/")
public class ParkController extends BaseController {
    @Resource
    private ParkService parkService;

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "根据id查看", notes = "根据id查看")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<Park> selectByPrimaryKey(@RequestParam Integer id) {
        return parkService.selectByPrimaryKey(id);
    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "根据名称查看", notes = "根据名称查看")
    @GetMapping(value = "selectByName")
    public ResponseEntity<Park> selectByName(@RequestParam String name) {
        return parkService.selectByName(name);
    }

    @ApiOperation(value = "查看列表", notes = "查看列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return parkService.selectList(pageNum, pageSize);
    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "根据location查看列表", notes = "根据location查看列表")
    @GetMapping(value = "selectListByLocation")
    public PageResponseBean selectListByLocation(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String location) {
        return parkService.selectListByLocation(pageNum, pageSize, location);
    }
}
