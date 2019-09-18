package cn.tommyyang.workmanagement.controller.admin;

import cn.tommyyang.slf4j4json.Logger;
import cn.tommyyang.slf4j4json.LoggerFactory;
import cn.tommyyang.workmanagement.controller.BaseController;
import cn.tommyyang.workmanagement.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author : TommyYang
 * @Time : 2019-09-11 17:42
 * @Software: IntelliJ IDEA
 * @File : AdminController.java
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private IAdminService adminService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "name") String name,
                        @RequestParam(value = "passwd") String passwd) {
        HttpSession session = request.getSession();

        if (name.equals("admin") && passwd.equals("123456")) {
            session.setAttribute("admin", "TommyYang");
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

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "name") String name, @RequestParam(value = "account") String account,
                        @RequestParam(value = "passwd") String password, @RequestParam(value = "salt") String salt,
                        @RequestParam(value = "type") int type) {
        int res = this.adminService.addAdmin(name, account, password, salt, type);
        if (res == 0) {
            return "0";
        } else {
            return "1";
        }
    }

    @RequestMapping(value = "/manage.do", method = RequestMethod.GET)
    public String manage(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "adminmanagement");
    }

    @RequestMapping(value = "/getdata.do", method = RequestMethod.GET)
    @ResponseBody
    public void getData(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam(value = "page") int page,
                        @RequestParam(value = "rows") int rows) {
        try {
            this.writeResponseContent(response, adminService.getJson(page, rows));
        } catch (IOException e) {
            LOG.info().strField("event", "get-admin-data").strField("error", e.getMessage())
                    .exception("\nexception:\n", e).log();
        }
    }

}
