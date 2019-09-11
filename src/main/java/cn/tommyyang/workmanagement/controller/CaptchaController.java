package cn.tommyyang.workmanagement.controller;

import cn.tommyyang.workmanagement.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author : TommyYang
 * @Time : 2019-09-11 18:00
 * @Software: IntelliJ IDEA
 * @File : CaptchaController.java
 */
@Controller
public class CaptchaController {

    @RequestMapping(value = "/captcha.do", method = RequestMethod.GET)
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CaptchaUtil.outputCaptcha(request, response);
    }

    @RequestMapping(value = "/checkcaptcha.do", method = RequestMethod.POST)
    @ResponseBody
    public String checkCaptcha(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(value="code") String code)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String existCode = session.getAttribute("code").toString();
        if(code.equalsIgnoreCase(existCode)){
            return "1";
        }else {
            return "2";
        }
    }

}
