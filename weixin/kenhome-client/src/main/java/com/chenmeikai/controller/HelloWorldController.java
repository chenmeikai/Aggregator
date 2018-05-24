/**
 * 
 */
package com.chenmeikai.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 权限鉴定
 * @author Administrator
 */

@Controller
public class HelloWorldController {

	@RequestMapping("hello")
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request,HttpServletResponse response) {
		
		Map<String,Object> result =new HashMap<>();
		
		
		result.put("code", 200);
		result.put("desc", "helloWorld");
		
		return result;
	}

}
