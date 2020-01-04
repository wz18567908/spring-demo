//package com.wz.demo.service;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Service;
//
//import com.wz.demo.message.MessageHandler;
//
//@Service("sendMsgService")
//public class SendMsgService {
//    private static Logger logger = Logger.getLogger(SendMsgService.class);
//
//    public String sendMsg(HttpServletRequest request) {
//        String respMessage = null;
//        try {
//            Map<String,String> map = MessageHandler.parseXml(request);
//
//            respMessage = MessageHandler.buildXml(map);
//            System.out.println(respMessage);
//
//            if(respMessage.equals("")){
//                respMessage = "error";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//            System.out.println(e.getMessage());
//        }
//        return respMessage;
//}
//}