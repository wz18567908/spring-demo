package com.wz.demo.access;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TokenThread implements Runnable {
    public static String appId = "";
 
    public static String appSecret= "";
    public static AccessToken accessToken = null;
 
    public void run(){
        while (true){
            try{
                accessToken = this.getAccessToken();
                if(null!=accessToken){
                    System.out.println(accessToken.getTokenName());
                    Thread.sleep(7000 * 1000);
 
                }else{
                    Thread.sleep(1000*3);
                }
            }catch(Exception e){
                System.out.println("accessToken error"+e.getMessage());
                e.printStackTrace();
                try{
                    Thread.sleep(1000*10);
                }catch (Exception e1){
 
                }
            }
        }
    }
 
    private AccessToken getAccessToken(){
        NetWorkUtil netHelper = new NetWorkUtil();
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",this.appId,this.appSecret);
        String result = netHelper.getHttpsResponse(Url,"");
        System.out.println(result);
        //response.getWriter().println(result);
        JSONObject json = JSON.parseObject(result);
        AccessToken token = new AccessToken();
        token.setTokenName(json.getString("access_token"));
        token.setExpireSecond(json.getInteger("expires_in"));
        return token;
    }
}