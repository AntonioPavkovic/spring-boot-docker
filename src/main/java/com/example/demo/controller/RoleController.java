package com.example.demo.controller;

import com.example.demo.model.Roles;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public ResponseEntity<Roles> getRole(@PathVariable Integer id) throws Exception{

        Roles roles = new Roles();

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

}
