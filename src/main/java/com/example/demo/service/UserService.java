package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserDTO;


import java.util.List;

public interface UserService {
    public List<User> ListOfUser();

    public User updateUser(User u);

    public User insertUser(User u);

    public User getUserById(int id);

    public UserDTO getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);

    public User logging(String username, String password) throws Exception;

    public User register(User u) throws Exception;

    public User disableUser(int id) throws Exception;

    public List<User> listDiff(int id);

    public List<User> userInfo(String username, int roleid);

    public User addorupdateNewUser(String username, User u) throws Exception;
}
