package cn.tommyyang.workmanagement.controller;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author : TommyYang
 * @Time : 2019-09-11 17:42
 * @Software: IntelliJ IDEA
 * @File : BaseController.java
 */
public class BaseController {

    protected String renderString(HttpServletResponse response, String message) {
        response.setContentType("text/html;charset=UTF-8");
        return message;
    }

}
