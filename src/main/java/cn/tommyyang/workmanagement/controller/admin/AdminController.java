package cn.tommyyang.workmanagement.controller.admin;

import cn.tommyyang.workmanagement.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author : TommyYang
 * @Time : 2019-09-11 17:42
 * @Software: IntelliJ IDEA
 * @File : AdminController.java
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "passwd", required = false) String passwd) {
        HttpSession session = request.getSession();

        if (name.equals("admin") && passwd.equals("123456")) {
            session.setAttribute("admin", "杨挺");
            return renderString(response, "admin");
        } else {
            request.setAttribute("loginerror", "用户名或密码错误");
            return "login";
        }


    }

    @RequestMapping(value = "/gologin.do", method = RequestMethod.GET)
    public String goLogin(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "login");
    }

}
