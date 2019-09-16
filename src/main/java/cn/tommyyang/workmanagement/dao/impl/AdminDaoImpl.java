package cn.tommyyang.workmanagement.dao.impl;

import cn.tommyyang.workmanagement.dao.BaseDao;
import cn.tommyyang.workmanagement.dao.IAdminDao;
import cn.tommyyang.workmanagement.model.Admin;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : TommyYang
 * @Time : 2019-09-16 12:17
 * @Software: IntelliJ IDEA
 * @File : AdminDaoImpl.java
 */
@Repository("adminDao")
public class AdminDaoImpl extends BaseDao implements IAdminDao {

    @Override
    public List<Admin> get() {
        try (SqlSession session = this.getSqlSessionFactory().openSession()) {
            List<Admin> admins = session.selectList("cn.tommyyang.workmanagement.mapping.admin.selectAllAdmin");
            session.commit();
            return admins;
        }
    }

    @Override
    public Admin checkAdmin(Admin currentAdmin) {
        try (SqlSession session = this.getSqlSessionFactory().openSession()) {
            Admin admin = session.selectOne("cn.tommyyang.workmanagement.mapping.admin.checkAdmin", currentAdmin);
            session.commit();
            return admin;
        }

    }

    @Override
    public int addAdmin(Admin admin) {
        try (SqlSession session = this.getSqlSessionFactory().openSession()) {
            int res = session.insert("cn.tommyyang.workmanagement.mapping.admin.addAdmin", admin);
            session.commit();
            return res;
        }

    }

}
