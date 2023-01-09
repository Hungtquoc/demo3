package com.example.demo.controller;

import com.example.demo.service.JoinGroupRoleUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/joingrouprole")
public class JoinGroupRoleUserController {
    @Autowired
    JoinGroupRoleUserService joinGroupRoleUserService;

    @GetMapping("/list")
    public ResponseEntity<?> listofUser(@RequestParam int id) {
        return new ResponseEntity<>(joinGroupRoleUserService.getJoinGroupRoleUserById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewUser(@RequestParam int userId, @RequestParam int groupRoleId) throws Exception {
        return new ResponseEntity<>(joinGroupRoleUserService.addNewUser(userId, groupRoleId), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam int id) {
        return new ResponseEntity<>(joinGroupRoleUserService.deletUser(id), HttpStatus.OK);
    }
}
