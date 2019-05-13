package com.springboot.framework.controller;

import com.springboot.framework.annotation.ACS;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.AppDetail;
import com.springboot.framework.service.AppService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.vo.AppDetailForContactVO;
import com.springboot.framework.vo.AppDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = {"应用操作接口"}, produces = "application/json")
@RestController
@RequestMapping("/app/")
public class AppController extends BaseController {
    @Resource
    private AppService appService;

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "查看", notes = "查看应用")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<AppDetailVO> selectByPrimaryKey(@RequestParam Integer id) {
        return appService.selectByPrimaryKey(id);
    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "查看列表", notes = "查看应用列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return appService.selectList(pageNum, pageSize);
    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "根据parkId查看列表", notes = "根据parkId查看列表")
    @GetMapping(value = "selectListByParkId")
    public PageResponseBean selectListByParkId(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Integer parkId) {
        return appService.selectListByParkId(pageNum, pageSize, parkId);
    }

    /////////////////应用详情/////////////////
    @ACS(allowAnonymous = true)
    @ApiOperation(value = "查看应用详情", notes = "查看应用详情")
    @GetMapping(value = "selectByPrimaryKeyForDetail")
    public ResponseEntity<AppDetailForContactVO> selectByPrimaryKeyForDetail(@RequestParam Integer appId, @RequestParam Integer parkId) {
        return appService.selectByPrimaryKeyForDetail(appId, parkId);
    }
}
