package com.wz.demo.access;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
 
@WebServlet(name = "accessTokenServlet")
public class AccessTokenServlet extends HttpServlet {
 
    public void init() throws ServletException {
        TokenThread.appId = getInitParameter("appid");
        TokenThread.appSecret = getInitParameter("appsecret");
        System.out.println("appid:"+TokenThread.appId);
        System.out.println("appSecret:"+TokenThread.appSecret);
        new Thread(new TokenThread()).start();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    }
}