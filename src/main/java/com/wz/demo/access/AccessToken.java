package com.wz.demo.access;

public class AccessToken {
    private String tokenName; //��ȡ����ƾ֤
    private int expireSecond;    //ƾ֤��Чʱ��  ��λ:��

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public int getExpireSecond() {
        return expireSecond;
    }

    public void setExpireSecond(int expireSecond) {
        this.expireSecond = expireSecond;
    }
}