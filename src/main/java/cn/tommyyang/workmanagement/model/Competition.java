package cn.tommyyang.workmanagement.model;

/**
 * @Author : TommyYang
 * @Time : 2019-09-15 15:44
 * @Software: IntelliJ IDEA
 * @File : Competition.java
 */
public class Competition {

    private int id;
    private String name;
    private String birth;
    private String headImg;
    private String nationality;
    private String sex;
    private String level;
    private String project;
    private String org;
    private String musicUrl;
    private String division;
    private String group;
    private String instrument;
    private String address;
    private String phone;
    private String teacher;
    private String mobile;
    private String type;
    private String orderNo;
    private int pid;
    private float orderAmount;
    private int payStatus;
    private String createTime;

    public Competition() {
    }

    public Competition(int id) {
        this.id = id;
    }

    public Competition(String name) {
        this.name = name;
    }

    public Competition(int id, String name, String birth, String headImg, String nationality, String sex, String level, String project, String org, String musicUrl, String division, String group, String instrument, String address, String phone, String teacher, String mobile, String type, String orderNo, int pid, float orderAmount, int payStatus, String createTime) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.headImg = headImg;
        this.nationality = nationality;
        this.sex = sex;
        this.level = level;
        this.project = project;
        this.org = org;
        this.musicUrl = musicUrl;
        this.division = division;
        this.group = group;
        this.instrument = instrument;
        this.address = address;
        this.phone = phone;
        this.teacher = teacher;
        this.mobile = mobile;
        this.type = type;
        this.orderNo = orderNo;
        this.pid = pid;
        this.orderAmount = orderAmount;
        this.payStatus = payStatus;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", headImg='" + headImg + '\'' +
                ", nationality='" + nationality + '\'' +
                ", sex='" + sex + '\'' +
                ", level='" + level + '\'' +
                ", project='" + project + '\'' +
                ", musicUrl='" + musicUrl + '\'' +
                ", division='" + division + '\'' +
                ", group='" + group + '\'' +
                ", instrument='" + instrument + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", teacher='" + teacher + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type='" + type + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", pid=" + pid +
                ", orderAmount=" + orderAmount +
                ", payStatus=" + payStatus +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
