package cn.tommyyang.workmanagement.dao.impl;

import cn.tommyyang.workmanagement.dao.BaseDao;
import cn.tommyyang.workmanagement.dao.ICompetitionDao;
import cn.tommyyang.workmanagement.model.Competition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : TommyYang
 * @Time : 2019-09-16 17:34
 * @Software: IntelliJ IDEA
 * @File : CompetitionDaoImpl.java
 */
@Repository("competitionDao")
public class CompetitionDaoImpl extends BaseDao implements ICompetitionDao {
    @Override
    public List<Competition> get() {
        try (SqlSession session = this.getSqlSessionFactory().openSession()) {
            List<Competition> competitions = session.selectList("cn.tommyyang.workmanagement.mapping.competition.selectAllCompetition");
            session.commit();
            return competitions;
        }
    }
}
