/**
 * 
 */
package com.chenmeikai.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String login(HttpServletRequest request, HttpServletResponse response) {

		return "refuse";
	}

}
