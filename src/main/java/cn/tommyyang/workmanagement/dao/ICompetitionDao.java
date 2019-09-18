package cn.tommyyang.workmanagement.dao;

import cn.tommyyang.workmanagement.model.Competition;

import java.util.List;

/**
 * @Author : TommyYang
 * @Time : 2019-09-16 17:34
 * @Software: IntelliJ IDEA
 * @File : ICompetitionDao.java
 */
public interface ICompetitionDao {

    List<Competition> get();

    List<Competition> get(Competition competition);

}
