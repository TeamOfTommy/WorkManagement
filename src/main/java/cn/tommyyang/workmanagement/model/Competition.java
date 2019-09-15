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

    public Competition(int id) {
        this.id = id;
    }

    public Competition(String name) {
        this.name = name;
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
