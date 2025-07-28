package com.zqy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class WeChatTokenController {
    @GetMapping("/wechat")
    public String wechat(HttpServletRequest request, HttpServletResponse response){
        return request.getParameter("echostr");
    }
}
