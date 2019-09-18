package cn.tommyyang.workmanagement.service;

import java.io.File;

/**
 * @Author : TommyYang
 * @Time : 2019-09-16 17:36
 * @Software: IntelliJ IDEA
 * @File : ICompetitionService.java
 */
public interface ICompetitionService {

    String getJson(int page, int rows, String nationality, String sex, String division, String group);

    File exportData(String nationality, String sex, String division, String group);

}
