package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(userService.ListOfUser(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody User u) {
        return new ResponseEntity<>(userService.updateUser(u), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody User u) {
        return new ResponseEntity<>(userService.insertUser(u), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserById(@RequestParam int id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/pagging")
    public ResponseEntity<UserDTO> getAllEmployees(
            @RequestParam(defaultValue = "1") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        UserDTO user = userService.getAllEmployees(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) throws Exception {



        return new ResponseEntity<>(userService.logging(username, password), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User u) throws Exception {
        return new ResponseEntity<>(userService.register(u), HttpStatus.OK);
    }

    @PostMapping("/updatestatus")
    public ResponseEntity<?> updateStatus(@RequestParam int id) throws Exception {
        return new ResponseEntity<>(userService.disableUser(id), HttpStatus.OK);
    }

    @GetMapping("/listdiff")
    public ResponseEntity<List<User>> listdiff(@RequestParam int id) {
        return new ResponseEntity<>(userService.listDiff(id), HttpStatus.OK);
    }
    @GetMapping("/userinfo")
    public ResponseEntity<?> userInfor(@RequestParam String username){
        return new ResponseEntity<>(userService.userInfo(username), HttpStatus.OK);
    }
}
