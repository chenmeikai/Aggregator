/**
 * Copyright © 2018
 *
 * @Package: asdf.java
 * @author: Administrator
 * @date: 2018年5月15日 下午9:39:46
 */
package com.chenmeikai.modal.weixin;

/**
 * @Description:微信返回数据模板
 * @author: cmk
 * @date: 2018年5月15日 下午9:39:46
 */

public class AccessToken {
    //错误码
    public Integer errcode;
    //错误描述
    public String errmsg;
    //接口调用凭证
    public String token;
    //access_token接口调用凭证超时时间，单位（秒）
    public Integer expiresIn;
    //用户刷新access_token
    public String refreshToken;
    //授权用户唯一标识
    public String openid;
    //用户授权的作用域，使用逗号（,）分隔
    public String scope;
    //当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。
    public String unionid;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

}

