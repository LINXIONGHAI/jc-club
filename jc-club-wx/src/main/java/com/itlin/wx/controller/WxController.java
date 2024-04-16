package com.itlin.wx.controller;

import com.itlin.wx.handler.WxChatMsgFactory;
import com.itlin.wx.handler.WxChatMsgHandle;
import com.itlin.wx.util.MessageUtil;
import com.itlin.wx.util.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@Slf4j
public class WxController {
    private static final String token="dsvfsdffdfsdfd";

    @Resource
    private WxChatMsgFactory wxChatMsgFactory;

    @GetMapping("/collback")
    public String collback(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
                           @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {

        log.info("WxController : collback : {},{},{},{}",signature,timestamp,nonce,echostr);
        String shaStr = SHA1.getSHA1(token, timestamp, nonce, "");
        if (signature.equals(shaStr)) {
            return echostr;
        }
        return "unknown";
    }

    @PostMapping(value = "/collback",produces = "application/xml;charset=UTF-8")
    public String collbackTwo(
                            @RequestBody String requestBody,
                            @RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
                           @RequestParam("nonce") String nonce, @RequestParam(value = "echostr",required = false) String echostr) {

        log.info("WxController : collback : {},{},{},{}",signature,timestamp,nonce,echostr);
        log.info(requestBody);
        Map<String, String> map = MessageUtil.parseXml(requestBody);
//        String toUserName = map.get("ToUserName");
//        String fromUserName = map.get("FromUserName");
        String msgType = map.get("MsgType");
//        if("subscribe".equals(event)){
//            String msg="<xml><ToUserName><![CDATA["+fromUserName+"]]></ToUserName>\n" +
//                    "<FromUserName><![CDATA["+toUserName+"]]></FromUserName>\n" +
//                    "<CreateTime>1711300413</CreateTime>\n" +
//                    "<MsgType><![CDATA[text]]></MsgType>\n" +
//                    "<Content><![CDATA["+"回复1 获取验证码"+"]]></Content>\n" +
//                    "<MsgId>24499928714693670</MsgId>\n" +
//                    "</xml>";
//            return msg;
//        }
//
//        String msg="<xml><ToUserName><![CDATA["+fromUserName+"]]></ToUserName>\n" +
//                "<FromUserName><![CDATA["+toUserName+"]]></FromUserName>\n" +
//                "<CreateTime>1711300413</CreateTime>\n" +
//                "<MsgType><![CDATA[text]]></MsgType>\n" +
//                "<Content><![CDATA[你好啊！！！！！！！！！！]]></Content>\n" +
//                "<MsgId>24499928714693670</MsgId>\n" +
//                "</xml>";
//        return msg;

        WxChatMsgHandle wxchatHandle = wxChatMsgFactory.getWxchatHandle(msgType);
        return wxchatHandle.msgHandle(map);
//        String msg="<xml><ToUserName><![CDATA["+fromUserName+"]]></ToUserName>\n" +
//                    "<FromUserName><![CDATA["+toUserName+"]]></FromUserName>\n" +
//                    "<CreateTime>1711300413</CreateTime>\n" +
//                    "<MsgType><![CDATA[text]]></MsgType>\n" +
//                    "<Content><![CDATA["+s+"]]></Content>\n" +
//                    "<MsgId>24499928714693670</MsgId>\n" +
//                    "</xml>";
//            return msg;


    }
                //    关注：
                //    <xml><ToUserName><![CDATA[gh_e646aaad50b8]]></ToUserName>
                //<FromUserName><![CDATA[obWLD6oJ45QbG2YEFDnfz0KJrDmo]]></FromUserName>
                //<CreateTime>1711301046</CreateTime>
                //<MsgType><![CDATA[event]]></MsgType>
                //<Event><![CDATA[subscribe]]></Event>
                //<EventKey><![CDATA[]]></EventKey>
                //</xml>

                //发消息：
                //    <xml><ToUserName><![CDATA[gh_e646aaad50b8]]></ToUserName>
                //<FromUserName><![CDATA[obWLD6oJ45QbG2YEFDnfz0KJrDmo]]></FromUserName>
                //<CreateTime>1711301115</CreateTime>
                //<MsgType><![CDATA[text]]></MsgType>
                //<Content><![CDATA[1]]></Content>
                //<MsgId>24499941569009148</MsgId>
                //</xml>



}
