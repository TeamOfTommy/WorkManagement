package cn.tommyyang.workmanagement.dao;

import cn.tommyyang.workmanagement.model.Admin;

import java.util.List;

/**
 * @Author : TommyYang
 * @Time : 2019-09-16 12:17
 * @Software: IntelliJ IDEA
 * @File : IAdminDao.java
 */
public interface IAdminDao {

    List<Admin> get();

    Admin checkAdmin(Admin currentAdmin);

    int addAdmin(Admin admin);

}
