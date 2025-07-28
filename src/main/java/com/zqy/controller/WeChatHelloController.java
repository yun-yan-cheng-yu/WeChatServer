package com.zqy.controller;


import com.zqy.utils.messagehandle.ParseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
public class WeChatHelloController {

    @ResponseBody
    @RequestMapping("/wechat")
    public void message(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> msg = ParseUtil.requestDecode(request);
        System.out.println(msg);

        String ToUserName = msg.get("ToUserName");
        String FromUserName  = msg.get("FromUserName");
        String CreateTime = msg.get("CreateTime");
        String MsgType  = msg.get("MsgType");
        String Content  = msg.get("Content");
        String MsgId  = msg.get("MsgId");

        ParseUtil.response(response,FromUserName,ToUserName,CreateTime,MsgType,"您发的消息:\""+Content+"\" 我收到了。但现在功能不支持您的操作。感谢您的访问");
    }
}
