package cn.tommyyang.workmanagement.service;

import cn.tommyyang.workmanagement.model.Admin;

/**
 * @Author : TommyYang
 * @Time : 2019-09-16 14:27
 * @Software: IntelliJ IDEA
 * @File : IAdminService.java
 */
public interface IAdminService {

    String getJson(int page, int rows);

    Admin checkAdmin(String account, String password);

    int addAdmin(String name, String account, String password, String salt, int type);

}
