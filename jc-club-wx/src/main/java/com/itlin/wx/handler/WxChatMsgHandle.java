package com.itlin.wx.handler;

import com.itlin.wx.enums.WxMsgTypeEnum;

import java.util.Map;

public interface WxChatMsgHandle {
    WxMsgTypeEnum getByType();
    String msgHandle(Map<String,String> map);
}
