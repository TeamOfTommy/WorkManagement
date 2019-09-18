package cn.tommyyang.workmanagement.service.impl;

import cn.tommyyang.slf4j4json.Logger;
import cn.tommyyang.slf4j4json.LoggerFactory;
import cn.tommyyang.workmanagement.dao.IAdminDao;
import cn.tommyyang.workmanagement.model.Admin;
import cn.tommyyang.workmanagement.service.IAdminService;
import cn.tommyyang.workmanagement.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author : TommyYang
 * @Time : 2019-09-16 14:28
 * @Software: IntelliJ IDEA
 * @File : AdminServiceImpl.java
 */
@Service
public class AdminServiceImpl implements IAdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    @Qualifier("adminDao")
    private IAdminDao adminDao;

    @Override
    public String getJson(int page, int rows) {
        try {
            List<Admin> admins = this.adminDao.get();
            return this.listToJson(admins, page, rows);
        } catch (Exception e) {
            LOG.info().strField("event", "get-admin-data").strField("error", e.getMessage())
                    .exception("\nexception:\n", e).log();
        }
        return "";
    }

    @Override
    public Admin checkAdmin(String account, String password) {
        Admin admin = new Admin(account);
        try{
            this.adminDao.checkAdmin(admin);
            String md5Pass = Md5Utils.md5(Md5Utils.md5(password) + admin.getSalt());
            if (md5Pass.equals(admin.getPassword())) {
                return admin;
            }
        }catch (Exception e) {
            LOG.info().strField("event", "check-admin").strField("error", e.getMessage())
                    .exception("\nexception:\n", e).log();
        }
        return null;
    }

    @Override
    public int addAdmin(String name, String account, String password, String salt, int type) {
        Admin admin = new Admin(account);
        String md5Pass = Md5Utils.md5(Md5Utils.md5(password) + salt);
        admin.setPassword(md5Pass);
        admin.setName(name);
        admin.setSalt(salt);
        admin.setType(type);
        admin.setCreateTime(Instant.now().getEpochSecond() + "");

        try {
            return this.adminDao.addAdmin(admin);
        } catch (Exception e) {
            LOG.info().strField("event", "add-admin").strField("error", e.getMessage())
                    .exception("\nexception:\n", e).log();
        }

        return 0;
    }


    private String listToJson(List<Admin> admins, int page, int rows) {
        int total = admins.size();
        int start = (page - 1) * rows;
        int end = page * rows;
        int currentEnd = end <= total ? end : total;

        StringBuilder sBuilder = new StringBuilder("{");
        sBuilder.append("\"total\":").append(String.format("\"%d\",", total))
                .append("\"rows\":[");
        IntStream.range(start, currentEnd).forEach(index -> {
            Admin a = admins.get(index);
            StringBuilder builder = new StringBuilder();
            builder.append("{\"id\":").append(String.format("\"%d\"", a.getId())).append(",")
                    .append("\"name\":").append(String.format("\"%s\"", a.getName())).append(",")
                    .append("\"account\":").append(String.format("\"%s\"", a.getAccount())).append(",")
                    .append("\"type\":").append(String.format("\"%d\"", a.getType())).append("},");
            sBuilder.append(builder.toString());

        });

        String json = sBuilder.substring(0, sBuilder.length() - 1);
        return  json + "]}";
    }

}
