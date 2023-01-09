package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.RoleDTO;

import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping("/pagging")
    public ResponseEntity<RoleDTO> pagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                              @RequestParam(defaultValue = "5") Integer pageSize,
                                              @RequestParam(defaultValue = "id") String sortBy){
        RoleDTO roleDTO = roleService.pagination(pageNo, pageSize, sortBy);
        return new ResponseEntity<RoleDTO>(roleDTO, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateRole(@RequestBody Role role){
        return new ResponseEntity<Role>(roleService.updateRole(role), HttpStatus.OK );
    }
    @PostMapping("/add")
    public ResponseEntity<?> addRole(@RequestBody Role role){
        return new ResponseEntity<Role>(roleService.addNewRole(role), HttpStatus.OK);
    }
    @GetMapping("/roleAtId")
    public ResponseEntity<?> getOneRole(@RequestParam int id){
        return new ResponseEntity<Role>(roleService.getRoleById(id), HttpStatus.OK);
    }
    @PostMapping("/disableRole")
    public ResponseEntity<?> disableRole(@RequestParam int id){
        return new ResponseEntity<Role>(roleService.disableRole(id), HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return new ResponseEntity<List<Role>>(roleService.ListOfRole(), HttpStatus.OK);
    }
    @GetMapping("/listrole")
    public ResponseEntity<?> listrole(@RequestParam int id){
        return new ResponseEntity<List<Role>>(roleService.ListRoleByGroupRoleID(id), HttpStatus.OK);
    }
}
