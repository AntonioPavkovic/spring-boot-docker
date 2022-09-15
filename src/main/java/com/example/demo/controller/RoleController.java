package com.example.demo.controller;

import com.example.demo.exception.RoleNotFoundException;
import com.example.demo.model.Roles;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping()
    public List<Roles> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> getPrivilegeById(@PathVariable(name = "id") Integer id) throws RoleNotFoundException {
        Roles role = roleService.getRoleById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with id: " +id+ " not found"));

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Roles> createRole(@RequestBody Roles roles) {
        return new ResponseEntity<>(roleService.createRole(roles), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRole(@RequestBody Roles roles) {
        return new ResponseEntity<>(roleService.updateRole(roles), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Roles> deleteRole(@PathVariable(name = "id") Integer id) throws RoleNotFoundException {
        Roles roles = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with id: " + id + " not found"));

        roleRepository.delete(roles);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
