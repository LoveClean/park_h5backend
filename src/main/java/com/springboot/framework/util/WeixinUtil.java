package com.springboot.framework.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.framework.annotation.ACS;
import com.springboot.framework.config.WechatAccountConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author SWF
 * @Date 2019/4/19 16:17
 **/
@Component
public class WeixinUtil {

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Autowired
    private RedisUtil redisUtil;

    private Log logger = LogFactory.getLog(WeixinUtil.class);

    @ACS(allowAnonymous = true)
    public String getWeiXinTicket() throws Exception {
        String access_token = "";
        String ticket = "";
        Object act = redisUtil.get("access_token");
        Object apiTicket = redisUtil.get("api_ticket");
        logger.debug("[act] = " + act + " [apiticket] = " + apiTicket);
        if (null == act) {

            String url = "https://api.weixin.qq.com/cgi-bin/token";
            String jsonStrToken = ToolsUtil.sendGet(url, "grant_type=client_credential&appid="+ wechatAccountConfig.getMpAppId() + "&secret=" + wechatAccountConfig.getMpAppSecret());

            logger.debug("[jsonStrToken] = " + jsonStrToken);

            JSONObject json = JSON.parseObject(jsonStrToken);
            access_token = json.getString("access_token");
            if (access_token == null) {
                return null;
            }
            redisUtil.set("access_token",access_token,7200);
        } else {
            access_token = (String) act;
        }

        if (null == apiTicket) {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
            String jsonStrTicket = ToolsUtil.sendGet(url, "access_token=" + access_token + "&type=jsapi");

            logger.debug("[jsonStrTicket] = " + jsonStrTicket);

            JSONObject json = JSON.parseObject(jsonStrTicket);
            ticket = (String) json.getString("ticket");
            redisUtil.set("api_ticket",ticket,7200);

        } else {
            ticket = (String) apiTicket;
        }

        return ticket;
        // 断开连接

    }

}
