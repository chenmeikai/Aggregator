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
 */

@Controller
@RequestMapping("weixin")
public class WeixinVilidataController {

    @RequestMapping("validata")
    @ResponseBody
    public String validata(HttpServletRequest request, HttpServletResponse response) {

        String signature = request.getParameter("signature");

        String timestamp = request.getParameter("timestamp");

        String nonce = request.getParameter("nonce");

        String echostr = request.getParameter("echostr");

        if (WeixinCheckUtils.checkSignature(signature, timestamp, nonce)) {
            // 如果校验成功，将得到的随机字符串原路返回
            return echostr;
        }
        return "refuse";
    }

}
