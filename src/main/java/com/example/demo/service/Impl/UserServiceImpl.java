package com.example.demo.service.Impl;

import com.example.demo.model.JoinGroupUser;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.reposiory.JoinGroupUserRepository;
import com.example.demo.reposiory.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JoinGroupUserRepository joinGroupUserRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setStatus(rs.getBoolean(4));
            user.setRole(rs.getInt(5));
            user.setGroupUser(rs.getInt(6));
            user.setGroup_role_id(rs.getInt(7));
            return user;
        }
    }

    private class JoinGroupUserRowMapper implements RowMapper<JoinGroupUser> {
        @Override
        public JoinGroupUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            JoinGroupUser user = new JoinGroupUser();
            user.setId(rs.getInt(1));
            user.setUserId(rs.getInt(3));
            user.setGroupUserId(rs.getInt(2));
            return user;
        }
    }

    @Override
    public List<User> ListOfUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User u) {
        User user = userRepository.findById(u.getId()).orElse(null);
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        user.setGroupUser(u.getGroupUser());
        user.setRole(u.getRole());
        user.setStatus(u.isStatus());
        return userRepository.save(user);
    }

    @Override
    public User insertUser(User u) {
        return userRepository.save(u);
    }

    public User insertUserByLogin(User u) {
        User user = new User();
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        user.setRole(4);
        user.setGroupUser(3);
        user.setStatus(true);
        user.setGroupUser(3);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    public UserDTO getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<User> pagedResult = userRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return new UserDTO(pagedResult.getContent(), pagedResult.getTotalElements());
        } else {
            return new UserDTO();
        }
    }

    @Override
    public User logging(String username, String password) throws Exception {

        try {
            User user = userRepository.findByUsername(username);
            if (!user.getUsername().equals(username)) {
                throw new Exception("Tài khoản không có trong hệ thống");
            } else {
                if (!user.getPassword().equals(password)) {
                    throw new Exception("Mật khẩu không đúng");
                } else {
                    if (user.isStatus()) {
                        return user;
                    } else {
                        throw new Exception("Tài khoản bị vô hiệu hóa");
                    }
                }
            }
        } catch (EmptyResultDataAccessException e) {
            throw new Exception("User " + username + " is not found");
        } catch (NullPointerException e) {
            throw new NullPointerException("User " + username + ":  is not found");
        }
    }

    @Override
    public User register(User u) throws Exception {
        try {
            List<User> user = userRepository.findAllByUsername(u.getUsername());
            if (user.isEmpty()) {
                return insertUserByLogin(u);
            } else {
                throw new Exception("Tài khoản đã có trong hệ thống");
            }
        } catch (Exception e) {
            throw new Exception(u.getUsername() + " đã có trong hệ thống");
        }
    }

    @Override
    public User disableUser(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user.isStatus()) {
            user.setStatus(false);
        } else {
            user.setStatus(true);
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> listDiff(int id) {
        return jdbcTemplate.query
                ("select * " +
                                "from fis.user u " +
                                "where " +
                                "id not in ( select user_id from fis.join_group_user j " +
                                "where  group_user_id= ? )",
                        new UserRowMapper(), new Object[]{id});
    }

    @Override
    public List<User> userInfo(String username) {
        List<User> user = jdbcTemplate.query("" +
                        "select u.id, u.username, u.password, u.status, r.role_id, u.group_user_id, u.group_role_id " +
                        "from fis.user u join fis.join_role_user r \n" +
                        "on u.id = r.user_id where u.username = ?",
                new UserRowMapper(), new Object[]{username});
        List<User> userList = userRepository.findAll();
//        for (User user1 : user){
//            if (user1.getRole() == 1){
//                if (user1.isStatus()){
//                    for (User user2 : userList)
//                    if (user2.getUsername() == u1.getUsername()){
//                        return updateUser(u1);
//                    }else {
//                        return insertUser(u1);
//                    }
//                }else{
//                    return disableUser(user1.getId());
//                }
//            }else if (user1.getRole() ==2){
//
//            }
//        }
        return user;
    }

    public User addNewUser(String username, User u) throws Exception {
        List<User> user = jdbcTemplate.query("" +
                        "select u.id, u.username, u.password, u.status, r.role_id, u.group_user_id, u.group_role_id " +
                        "from fis.user u join fis.join_role_user r \n" +
                        "on u.id = r.user_id where u.username = ?",
                new UserRowMapper(), new Object[]{username});
        List<User> userList = userRepository.findAll();
        for (User user1 : user) {
            if (user1.getRole() == 1 || user1.getRole() == 2) {
                if (user1.isStatus()) {
                    for (User user2 : userList)
                        if (user2.getUsername() != u.getUsername()) {
                            return insertUser(u);
                        }
                }
            } else {
                throw new Exception("Người dùng không có quyền được thêm người dùng mới");
            }
        }
        return null;
    }
}
