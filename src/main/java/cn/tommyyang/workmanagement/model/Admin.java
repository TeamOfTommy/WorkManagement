package cn.tommyyang.workmanagement.model;

/**
 * @Author : TommyYang
 * @Time : 2019-09-15 23:34
 * @Software: IntelliJ IDEA
 * @File : Admin.java
 */
public class Admin {

    private int id;
    private String name;
    private String account;
    private String password;
    private String salt;
    private int status;
    private int type;
    private String createTime;

    public Admin(int id) {
        this.id = id;
    }

    public Admin(String account) {
        this.account = account;
    }

    public Admin(int id, String name, String account, String password, String salt, int status, int type, String createTime) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.salt = salt;
        this.status = status;
        this.type = type;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
