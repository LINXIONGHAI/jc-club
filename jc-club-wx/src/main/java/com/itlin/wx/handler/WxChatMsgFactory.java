package com.itlin.wx.handler;

import com.itlin.wx.enums.WxMsgTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class WxChatMsgFactory implements InitializingBean {

    @Resource
    private List<WxChatMsgHandle> list;

    private Map<WxMsgTypeEnum,WxChatMsgHandle> map=new HashMap<>();

    public  WxChatMsgHandle getWxchatHandle(String wxType) {
        WxMsgTypeEnum byWxType = WxMsgTypeEnum.getByWxType(wxType);
        return map.get(byWxType);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        for (WxChatMsgHandle wxChatMsgHandle : list) {
            WxMsgTypeEnum typeEnum = wxChatMsgHandle.getByType();
            map.put(typeEnum,wxChatMsgHandle);
        }

    }
}
