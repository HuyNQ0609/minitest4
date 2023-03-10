package com.example.minitest4.service;

import com.example.minitest4.model.Province;
import com.example.minitest4.model.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUsers();
    Province getProvinceById(int id);
}
