/**   
 * Copyright © 2018 
 * @Package: WeixinUtils.java 
 * @author: Administrator   
 * @date: 2018年5月14日 下午9:47:40 
 */
package com.chenmeikai.util;
/**      
 * @Description:获取微信access_token
 * @author: cmk 
 * @date:   2018年5月14日 下午9:47:40     
 */
import com.alibaba.fastjson.JSONObject;

public class WeiXinUtils {
    //从微信后台拿到APPID和APPSECRET 并封装为常量
    private static final String APPID = "wxfa3d9ef86a840107";
    private static final String APPSECRET = "0aae51fb6b71d8ec04e12e803dbd89d2";
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    
    
    /**
     * 获取AccessToken
     * @return 返回拿到的access_token及有效期
     */
    public static AccessToken getAccessToken(){
        AccessToken token = new AccessToken();
        String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);//将URL中的两个参数替换掉
        String response = HttpClientUtil.doGet(url);
        JSONObject result =JSONObject.parseObject(response);
        if(result!=null){ //如果返回不为空，将返回结果封装进AccessToken实体类
            token.setToken(result.getString("access_token"));//取出access_token
            token.setExpiresIn(result.getInteger("expires_in"));//取出access_token的有效期
        }
        return token;
    }
}


class AccessToken{
	public String token;
	public Integer expiresIn;
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
	
}
