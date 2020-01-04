package com.wz.demo.controller;
 
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wz.demo.message.MessageHandler;
import com.wz.demo.utils.SignUtil;

 
@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
    private static Logger logger = Logger.getLogger(WechatSecurity.class);
 
    @RequestMapping(value = "security", method = RequestMethod.GET)
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "signature", required = true) String signature,
            @RequestParam(value = "timestamp", required = true) String timestamp,
            @RequestParam(value = "nonce", required = true) String nonce,
            @RequestParam(value = "echostr", required = true) String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {
                logger.info("error");
            }
        } catch (Exception e) {
            logger.error(e, e);
        }
    }
 
    @RequestMapping(value = "security", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8"); //设置输出编码格式
        System.out.println("请求进入");
        String result = "";
        try {
            Map map = MessageHandler.parseXml(request);
            System.out.println("开始构造消息");
            result = MessageHandler.buildXml(map);
            System.out.println(result);
            if(result.equals(""))
                result = "error";
            response.getWriter().println(result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发生异常："+ e.getMessage());
        }
        System.out.println("==============post");
    }
}