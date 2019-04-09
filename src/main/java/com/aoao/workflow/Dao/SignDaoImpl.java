package com.aoao.workflow.Dao;

import com.aoao.workflow.pojo.GroupBean;
import com.aoao.workflow.pojo.MemberBean;

import java.sql.*;
import java.util.Map;

public class SignDaoImpl implements SignDao {
    @Override
    public Boolean saveGroup(Map<String, Object> signTable) {
        try {
            Connection connection = SqliteUtil.getConnection();

            GroupBean leader = (GroupBean) signTable.get("leader");
            for (int count = 0; count < (int) signTable.get("size"); count++) {
                MemberBean memberBean = (MemberBean) signTable.get("member_" + count);
                String sql_member = "insert into member values (null ,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql_member);
                preparedStatement.setString(1, leader.getId());
                preparedStatement.setString(2, memberBean.getMember_name());
                preparedStatement.setString(3, memberBean.getPhone_num());
                preparedStatement.setString(4, memberBean.getWechat_num());
                preparedStatement.setString(5, memberBean.getGrade_name());
                preparedStatement.setString(6, memberBean.getClass_name());
                preparedStatement.setDate(7, memberBean.getAdd_time());
                int i = preparedStatement.executeUpdate();
                if (i <= 0) {
                    return false;
                }
            }
            String sql = "insert  into leader values (?,?,?,?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, leader.getId());
            preparedStatement.setString(2, leader.getLeader_name());
            preparedStatement.setString(3, leader.getPhone_num());
            preparedStatement.setString(4, leader.getWechat_num());
            preparedStatement.setString(5, leader.getGrade_name());
            preparedStatement.setString(6, leader.getClass_name());
            preparedStatement.setDate(7, leader.getCreate_time());
            int i = preparedStatement.executeUpdate();
            if (i <= 0) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
