package com.example.demo.controller;

import com.example.demo.model.GroupUser;
import com.example.demo.model.JoinGroupUser;
import com.example.demo.service.JoinGroupUserService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/joingroupuser")
public class JoinGroupUserController {
    @Autowired
    JoinGroupUserService joinGroupUserService;

    @GetMapping("/list")
    public ResponseEntity<?> listofUser(@RequestParam int id) {
        return new ResponseEntity<>(joinGroupUserService.getJoinGroupUserById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewUser(@RequestParam int userId, @RequestParam int groupUserId) throws Exception {
        return new ResponseEntity<JoinGroupUser>(joinGroupUserService.addNewUser(userId, groupUserId), HttpStatus.OK);
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUserById(@RequestParam int id) {
        return new ResponseEntity<JoinGroupUser>(joinGroupUserService.getGroupUserbById(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody JoinGroupUser user) throws Exception {
        return new ResponseEntity<JoinGroupUser>(joinGroupUserService.updateUser(user), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam int id) {
        return new ResponseEntity<String>(joinGroupUserService.deletUser(id), HttpStatus.OK);
    }

    @GetMapping("/listUser")
    public ResponseEntity<?> listofUserById(@RequestParam int id) {
        return new ResponseEntity<>(joinGroupUserService.listOfUserInGroup(id), HttpStatus.OK);
    }
}
