package com.akaxin.signup_server.pojo;

import java.sql.Date;

public class MemberBean {
    private int id;
    private String member_name;
    private String phone_num;
    private String wechat_num;
    private String class_name;
    private String grade_name;
    private Date add_time;
    private int group_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getWechat_num() {
        return wechat_num;
    }

    public void setWechat_num(String wechat_num) {
        this.wechat_num = wechat_num;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public MemberBean() {


    }

    public MemberBean(int id, String member_name, String phone_num, String wechat_num, String class_name, String grade_name, Date add_time, int group_id) {

        this.id = id;
        this.member_name = member_name;
        this.phone_num = phone_num;
        this.wechat_num = wechat_num;
        this.class_name = class_name;
        this.grade_name = grade_name;
        this.add_time = add_time;
        this.group_id = group_id;
    }
}
