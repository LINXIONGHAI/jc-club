package com.itlin.wx.handler;

import com.itlin.wx.enums.WxMsgTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
@Slf4j
public class SubscribeHandle implements  WxChatMsgHandle{
    @Override
    public WxMsgTypeEnum getByType() {
        return WxMsgTypeEnum.SUBSCRIBE;
    }

    @Override
    public String msgHandle(Map<String,String> map) {
        log.info("{}",map);
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String msg="回复 “1“ 获得登录验证码";

        return "<xml><ToUserName><![CDATA["+fromUserName+"]]></ToUserName>\n" +
                    "<FromUserName><![CDATA["+toUserName+"]]></FromUserName>\n" +
                    "<CreateTime>1711300413</CreateTime>\n" +
                    "<MsgType><![CDATA[text]]></MsgType>\n" +
                    "<Content><![CDATA["+msg+"]]></Content>\n" +
                    "<MsgId>24499928714693670</MsgId>\n" +
                    "</xml>";
    }
}
