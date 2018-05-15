/**
 * 
 */
package com.chenmeikai.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenmeikai.modal.weixin.AccessToken;
import com.chenmeikai.modal.weixin.UserInfo;
import com.chenmeikai.util.HttpClientUtil;
import com.chenmeikai.util.WeiXinUtils;
import com.chenmeikai.util.WeixinCheckUtils;

/**
 * 微信公众号校验
 * 
 * @author Administrator
 * 
 */

@Controller
@RequestMapping("weixin")
public class LoginController {

	@RequestMapping("loginPage")
	public void loginPage(HttpServletRequest request, HttpServletResponse response) {

		try {
			response.sendRedirect("https://open.weixin.qq.com/connect/qrconnect?appid=wx2271787cf957c3af&redirect_uri=http%3a%2f%2fwww.chenmeikai.com%2fweixin%2flogin&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request,String code,String state) {
		
		
		AccessToken token =WeiXinUtils.getAccessToken(code);
		
		String accessToken  =token.getToken();
		
		String openid=  token.getOpenid();
		
		UserInfo userInfo=  WeiXinUtils.getUserInfo(accessToken, openid);
		
		String nickName=userInfo.getNickname();
		
		if(StringUtils.isBlank(nickName)) {
			nickName="获取为空";
		}
		
		return nickName;
	}

}
