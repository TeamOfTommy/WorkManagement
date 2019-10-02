package cn.tommyyang.workmanagement.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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

    protected void writeResponseContent(HttpServletResponse response, String responseContent) throws IOException {
        //返回数据
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(responseContent);
        response.getWriter().flush();
        response.getWriter().close();
    }

    protected void download(HttpServletResponse response, File file, String contentType) throws IOException {
        if (contentType.equals("")) {
            contentType = "multipart/form-data";
        }
        //返回数据
        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setContentType(contentType);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.addHeader("Content-Length", String.valueOf(file.length()));
//        response.setContentType(ContentType.APPLICATION_OCTET_STREAM.getMimeType());
        FileInputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[2048];
        int length;
        while ((length = inputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }

}
