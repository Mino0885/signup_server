package com.aoao.workflow.pojo;

import java.sql.Date;
import java.util.List;

public class GroupBean {
    private String id;
    private String leader_name;
    private String phone_num;
    private String wechat_num;
    private String class_name;
    private String grade_name;
    private Date create_time;
    private List<MemberBean> memberList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeader_name() {
        return leader_name;
    }

    public void setLeader_name(String leader_name) {
        this.leader_name = leader_name;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public List<MemberBean> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<MemberBean> memberList) {
        this.memberList = memberList;
    }

    public GroupBean() {

    }

    public GroupBean(String id, String leader_name, String phone_num, String wechat_num, String class_name, String grade_name, Date create_time, List<MemberBean> memberList) {

        this.id = id;
        this.leader_name = leader_name;
        this.phone_num = phone_num;
        this.wechat_num = wechat_num;
        this.class_name = class_name;
        this.grade_name = grade_name;
        this.create_time = create_time;
        this.memberList = memberList;
    }
}
