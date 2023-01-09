package com.example.demo.controller;


import com.example.demo.model.JoinRoleUser;
import com.example.demo.service.JoinRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/joinroleuser")
public class JoinRoleUserController {
    @Autowired
    JoinRoleUserService joinRoleUserService;
    @GetMapping("/list")
    public ResponseEntity<?> listofUser(@RequestParam int id) {
        return new ResponseEntity<>(joinRoleUserService.getJoinRoleUserById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<JoinRoleUser> addNewUser(@RequestParam int userId, @RequestParam int roleId) throws Exception{
        return new ResponseEntity<JoinRoleUser>(joinRoleUserService.addNewUser(userId, roleId), HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam int id){
        return new ResponseEntity<String>(joinRoleUserService.deletUser(id), HttpStatus.OK);
    }
    @GetMapping("/listUser")
    public ResponseEntity<?> listOfUserByUserId(@RequestParam int id) {
        return new ResponseEntity<>(joinRoleUserService.getListUserByUserId(id), HttpStatus.OK);
    }
}
