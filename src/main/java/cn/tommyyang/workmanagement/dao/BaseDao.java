package cn.tommyyang.workmanagement.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

/**
 * @Author : TommyYang
 * @Time : 2019-09-16 12:13
 * @Software: IntelliJ IDEA
 * @File : BaseDao.java
 */
public class BaseDao {

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    protected SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
