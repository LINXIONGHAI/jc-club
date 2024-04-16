package com.itlin.wx.enums;

import lombok.Getter;

@Getter
public enum WxMsgTypeEnum {
    SUBSCRIBE("event", "微信关注事件"),
    TEXT("text", "用户发送消息");
    String wxType;
    String desc;

    WxMsgTypeEnum(String wxType,
                  String desc) {
        this.desc = desc;
        this.wxType = wxType;

    }

    public static WxMsgTypeEnum getByWxType(String wxType) {
        for (WxMsgTypeEnum wxMsgTypeEnum: WxMsgTypeEnum.values()){
            if(wxMsgTypeEnum.wxType.equals(wxType)){
                return wxMsgTypeEnum;
            }

        }
        return null;
    }


}
