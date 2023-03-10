package com.example.minitest4.service;

import com.example.minitest4.connection.UserConnection;
import com.example.minitest4.model.Province;
import com.example.minitest4.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceIpml implements UserService {
    UserConnection userConnection = new UserConnection();
    private static final String GET_PROVINCE_BY_ID;
    static {
        GET_PROVINCE_BY_ID = "select * from Provinces where id = ?";
    }

    @Override
    public Province getProvinceById(int id) {
        Province province = null;
        try (Connection con = userConnection.getConnection();
             PreparedStatement pre = con.prepareStatement(GET_PROVINCE_BY_ID)) {
            System.out.println(pre);
            pre.setInt(1, id);
            ResultSet res = pre.executeQuery();
            if (res.next()) {
                String name = res.getString("name");
                province = new Province(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return province;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "{CALL select_all_users()}";
        try (Connection con = userConnection.getConnection();
             CallableStatement callableStatement = con.prepareCall(query)) {
            System.out.println(callableStatement);
            ResultSet res = callableStatement.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("user_name");
                int province_id = res.getInt("province");
                Province province = getProvinceById(province_id);
                users.add(new User(id, name, province));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
