/**
 * Copyright © 2018
 *
 * @Package: WeixinUtils.java
 * @author: Administrator
 * @date: 2018年5月14日 下午9:47:40
 */
package com.chenmeikai.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:获取微信access_token
 * @author: cmk
 * @date: 2018年5月14日 下午9:47:40
 */
import com.alibaba.fastjson.JSONObject;
import com.chenmeikai.modal.weixin.AccessToken;
import com.chenmeikai.modal.weixin.UserInfo;

public class WeiXinUtils {
    //从微信后台拿到APPID和APPSECRET 并封装为常量
    private static final String APPID = "wx2271787cf957c3af";
    private static final String APPSECRET = "162932026b19f971c6dedaa64edf5498";
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";


    /**
     * 获取AccessToken
     * @return 返回拿到的access_token及有效期
     */
    public static AccessToken getAccessToken() {
        AccessToken token = new AccessToken();
        String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);//将URL中的两个参数替换掉
        String response = HttpClientUtil.doGet(url);
        JSONObject result = JSONObject.parseObject(response);
        if (result != null) { //如果返回不为空，将返回结果封装进AccessToken实体类
            token.setToken(result.getString("access_token"));//取出access_token
            token.setExpiresIn(result.getInteger("expires_in"));//取出access_token的有效期
        }
        return token;
    }


    /**
     * 通过回传code获取AccessToken
     * @param code
     * @return
     */
    public static AccessToken getAccessToken(String code) {

        AccessToken token = new AccessToken();

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        Map<String, String> params = new HashMap<>();
        params.put("appid", APPID);
        params.put("secret", APPSECRET);
        params.put("code", code);
        params.put("grant_type", "authorization_code");
        String response = HttpClientUtil.doGet(url, params);
        JSONObject result = JSONObject.parseObject(response);
        if (result != null) { //如果返回不为空，将返回结果封装进AccessToken实体类
            token.setToken(result.getString("access_token"));//取出access_token
            token.setExpiresIn(result.getInteger("expires_in"));//取出access_token的有效期
            token.setRefreshToken(result.getString("refresh_token"));//用户刷新access_token
            token.setOpenid(result.getString("openid"));//授权用户唯一标识
        }
        return token;
    }

    /**
     * 刷新获得AccessToken
     * @param refreshToken
     * @return
     */
    public static AccessToken refleshAccessToken(String refreshToken) {

        AccessToken token = new AccessToken();

        String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
        Map<String, String> params = new HashMap<>();
        params.put("appid", APPID);
        params.put("refresh_token", refreshToken);
        params.put("grant_type", "refresh_token");
        String response = HttpClientUtil.doGet(url, params);
        JSONObject result = JSONObject.parseObject(response);
        if (result != null) { //如果返回不为空，将返回结果封装进AccessToken实体类
            token.setToken(result.getString("access_token"));//取出access_token
            token.setExpiresIn(result.getInteger("expires_in"));//取出access_token的有效期
            token.setRefreshToken(result.getString("refresh_token"));//用户刷新access_token
            token.setOpenid(result.getString("openid"));//授权用户唯一标识
        }
        return token;
    }


    /**
     *
     * @param accessToken  调用凭证
     * @param openid       普通用户的标识，对当前开发者帐号唯一
     * @param lang         国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     * @return
     */
    public static UserInfo getUserInfo(String accessToken, String openid) {

        UserInfo userInfo = new UserInfo();
        String url = "https://api.weixin.qq.com/sns/userinfo";
        Map<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("openid", openid);
        params.put("lang", "zh_CN");

        String response = HttpClientUtil.doGet(url, params);
        JSONObject result = JSONObject.parseObject(response);
        if (result != null) { //如果返回不为空，将返回结果封装进AccessToken实体类
            userInfo.setOpenid(result.getString("openid"));//普通用户的标识，对当前开发者帐号唯一
            userInfo.setNickname(result.getString("nickname"));////昵称
            userInfo.setSex(result.getInteger("sex"));//性别
            userInfo.setProvince(result.getString("province"));//省份
            userInfo.setCity(result.getString("city"));//城市
            userInfo.setCountry(result.getString("country"));//国家
            userInfo.setHeadimgurl(result.getString("headimgurl"));//头像
            userInfo.setPrivilege(result.getString("privilege"));//用户特权信息
            userInfo.setUnionid(result.getString("unionid"));//用户统一标识
        }
        return userInfo;
    }


}


