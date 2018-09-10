/**
 *
 */
package com.chenmeikai.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 权限鉴定
 *
 * @author Administrator
 */

@Controller
@RequestMapping("auth")
public class AuthController {


    @RequestMapping("validate")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response, String name, String validaCode) {

        Map<String, Object> result = new HashMap<>();

        if ("success".equalsIgnoreCase(validaCode)) {

            result.put("code", 200);
            result.put("desc", "鉴权成功");
            response.setStatus(200);
            return result;
        }

        result.put("code", 403);
        result.put("desc", "鉴权失败");
        response.setStatus(403);

        return result;
    }

}
