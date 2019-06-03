package com.springboot.framework.controller;


import com.alibaba.fastjson.JSON;
import com.springboot.framework.annotation.ACS;
import com.springboot.framework.config.WechatAccountConfig;
import com.springboot.framework.util.WeixinSign;
import com.springboot.framework.util.WeixinUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by 廖师兄
 * 2017-07-03 01:20
 */
@Api(tags = {"微信测试"}, produces = "application/json")
@RestController
@RequestMapping("/wechat/")
public class WechatController {

//    @Resource
//    private WxMpService wxMpService;

//    @Autowired
//    private ProjectUrlConfig projectUrlConfig;
//
//    @Autowired
//    private UserService userService;

    @Resource
    private WeixinUtil weixinUtil;

    @Resource
    private WeixinSign weixinSign;

    @Resource
    private WechatAccountConfig wechatAccountConfig;

//    private final String minePage = "pages/mine/mine";
//    private final String joinPage = "pages/promotion/join/join";
//    private final String promotionPage = "pages/promotion/promotion";
//    private final String applyPage = "pages/promotion/applyLoan/applyLoan";
//    private final String identity = "pages/identity/identity";

//    /**
//     *
//     * @param type 授权完成后以及获取到openid后的跳转页面
//     * @return
//     */
//    @ACS(allowAnonymous = true)
//    @ApiOperation(value = "",notes = "")
//    @GetMapping("/authorize")
//    public String authorize(@RequestParam("type") String type,
//                             String sid) {
//        // 授权成功后跳转到的url，此时会携带code，state两个参数
//        String url = projectUrlConfig.getWechatMpAuthorizeUrl() + "/wechat/userInfo";
//        WechatAuthRequestBean bean = new WechatAuthRequestBean();
//        bean.setSid(sid);
//        bean.setType(type);
//        String state = JSON.toJSONString(bean);
//        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(state));
//        return "redirect:" + redirectUrl;
//    }

//    /**
//     * 获取access token 以及 openid
//     * @param code
//     * @param state
//     * @return
//     */
//    @ACS(allowAnonymous = true)
//    @ApiOperation(value = "as",notes = "as")
//    @GetMapping("/userInfo")
//    public String userInfo(@RequestParam("code") String code,
//                         @RequestParam("state") String state) {
//        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
//        try {
//            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
//        } catch (WxErrorException e) {
//            log.error("【微信网页授权】{}", e);
//            throw new BusinessException(Errors.SYSTEM_DATA_ERROR, e.getError().getErrorMsg());
//        }
//        String openId = wxMpOAuth2AccessToken.getOpenId();
//        // 校验该微信是否已经进行了注册
//        User user = userService.wechatCheck(openId);
//        boolean check = false;
//        if(user!=null){
//            check = true;
//        }
//        WechatAuthRequestBean bean = JSON.parseObject(state,WechatAuthRequestBean.class);
//        String type = bean.getType();
//        String superId = bean.getSid();
//        String webUrl = projectUrlConfig.getWebUrl();
//        if(type.equals("login")){
//            if(check){
//                // 跳转到我的页面进行登录
//                return "redirect:" + webUrl + minePage + "?openId=" + openId ;
//            }else {
//                // 授权方式为登录，用户未注册，授权后跳转到加入平台,携带openID
//                return "redirect:" + webUrl + joinPage + "?openId=" + openId ;
//            }
//        }else if(type.equals("apply")){
//            if(check){
//                // 授权方式为申请，且已经注册，跳转到个人资质页面
//                return "redirect:" + webUrl + identity + "?openId=" + openId;
//            }else {
//                // 未注册，跳转到申请页面，携带openID与superId
//                return "redirect:" + webUrl + applyPage + "?openId=" + openId + "&sid=" + superId;
//            }
//
//        }else if(type.equals("join")){
//            if(check){
//               // 授权方式为加入，且已经注册，跳转到主页并登录
//                return "redirect:" + webUrl + minePage + "?openId=" + openId ;
//            }else {
//                // 授权方式为加入平台，用户未注册，跳转到加入平台,携带openID与superId
//                return "redirect:" + webUrl + joinPage + "?openId=" + openId + "&sid=" + superId ;
//            }
//
//        }
//        // 直接将openid返回到前端，由前端处理
//        return "redirect:" + webUrl + "/page/index/index";
//    }

    @ACS(allowAnonymous = true)
    @ApiOperation(value = "获取微信jssdk配置", notes = "获取微信jssdk配置")
    @GetMapping(value = "config")
    public Map<String, String> getWeixinApiConfig() throws Exception {
        String url = wechatAccountConfig.getUrl();
        //获取ticket
        String jsapi_ticket = weixinUtil.getWeiXinTicket();

        Map<String, String> ret = weixinSign.sign(jsapi_ticket, url);

        ret.put("appId", wechatAccountConfig.getMpAppId());

        return ret;
    }
}
