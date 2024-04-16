package com.itlin.wx.handler;

import com.itlin.wx.enums.WxMsgTypeEnum;
import com.itlin.wx.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class TextMsgHandle implements WxChatMsgHandle {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public WxMsgTypeEnum getByType() {
        return WxMsgTypeEnum.TEXT;
    }

    @Override
    public String msgHandle(Map<String, String> map) {

        if ("1".equals(map.get("Content"))) {
            log.info("{}", map);
            String toUserName = map.get("ToUserName");
            String fromUserName = map.get("FromUserName");
            String codeAll = "23456789qwertTYUIPKJyupkjhgfdHGFDsazCVxcvbnmQWERSAZXBNM";
            Random random = new Random();
            String code = "";
            for (int j = 0; j < 4; j++) {
                int i = random.nextInt(56);
                code = code + codeAll.charAt(i);
            }
            String key = code.toUpperCase();
            redisUtil.setNx(key, fromUserName, 5L, TimeUnit.MINUTES);
            return "<xml><ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[" + toUserName + "]]></FromUserName>\n" +
                    "<CreateTime>1711300413</CreateTime>\n" +
                    "<MsgType><![CDATA[text]]></MsgType>\n" +
                    "<Content><![CDATA[" + "验证码：" + code + " 五分钟有效" + "]]></Content>\n" +
                    "<MsgId>24499928714693670</MsgId>\n" +
                    "</xml>";
        }

        return null;

    }
}
