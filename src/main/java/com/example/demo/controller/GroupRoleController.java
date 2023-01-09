package com.example.demo.controller;

import com.example.demo.model.GroupRole;
import com.example.demo.model.GroupRoleDTO;

import com.example.demo.service.GroupRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/grouprole")
public class GroupRoleController {
    @Autowired
    GroupRoleService roleService;
    @GetMapping("/pagging")
    public ResponseEntity<GroupRoleDTO> pagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                                   @RequestParam(defaultValue = "5") Integer pageSize,
                                                   @RequestParam(defaultValue = "id") String sortBy){
        GroupRoleDTO groupRoleDTO = roleService.getAllGroupRole(pageNo, pageSize, sortBy);
        return new ResponseEntity<GroupRoleDTO>(groupRoleDTO, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateRole(@RequestBody GroupRole role){
        return new ResponseEntity<GroupRole>(roleService.updateGR(role), HttpStatus.OK );
    }
    @PostMapping("/add")
    public ResponseEntity<?> addRole(@RequestBody GroupRole role){
        return new ResponseEntity<GroupRole>(roleService.insertGR(role), HttpStatus.OK);
    }
    @GetMapping("/roleAtId")
    public ResponseEntity<?> getOneRole(@RequestParam int id){
        return new ResponseEntity<GroupRole>(roleService.getGRById(id), HttpStatus.OK);
    }
    @PostMapping("/disableRole")
    public ResponseEntity<?> disableRole(@RequestParam int id){
        return new ResponseEntity<GroupRole>(roleService.disableGR(id), HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<GroupRole>> getAll(){
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }
}
