package com.example.demo.controller;

import com.example.demo.model.GroupUserDTO;
import com.example.demo.model.GroupUser;
import com.example.demo.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/groupuser")
public class GroupUserController {
    @Autowired
    GroupUserService userService;

    @GetMapping("/pagging")
    public ResponseEntity<GroupUserDTO> pagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                                   @RequestParam(defaultValue = "5") Integer pageSize,
                                                   @RequestParam(defaultValue = "id") String sortBy) {
        GroupUserDTO groupUserDTO = userService.getAllGroupUser(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(groupUserDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateRole(@RequestBody GroupUser user) {
        return new ResponseEntity<>(userService.updateGU(user), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRole(@RequestBody GroupUser user) {
        return new ResponseEntity<>(userService.insertGU(user), HttpStatus.OK);
    }

    @GetMapping("/roleAtId")
    public ResponseEntity<?> getOneRole(@RequestParam int id) {
        return new ResponseEntity<>(userService.getGUById(id), HttpStatus.OK);
    }

    @PostMapping("/disableRole")
    public ResponseEntity<?> disableRole(@RequestParam int id) {
        return new ResponseEntity<>(userService.disableGU(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(userService.ListOfGR(), HttpStatus.OK);
    }
}
