package com.example.demo.controller;

import com.example.demo.exception.PrivilegeNotFoundException;
import com.example.demo.model.Privileges;
import com.example.demo.repository.PrivilegeRepository;
import com.example.demo.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/privileges")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @GetMapping()
    public List<Privileges> getAllPrivileges() {
        return privilegeService.getAllPrivileges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Privileges> getPrivilegeById(@PathVariable(value = "id") Integer id) throws PrivilegeNotFoundException {

        Privileges privilege = privilegeService.getPrivilegeById(id)
                .orElseThrow(() -> new PrivilegeNotFoundException("Privilege with id: " + id + " not found"));

        return new ResponseEntity<>(privilege, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Privileges> createPrivilege(@RequestBody Privileges privilege) {
        return new ResponseEntity<>(privilegeService.createPrivilege(privilege), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Privileges> updatePrivilege(@RequestBody Privileges privilege) {
        return new ResponseEntity<>(privilegeService.updatePrivilege(privilege), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Privileges> deletePrivilege(@PathVariable(name = "id") Integer id) throws PrivilegeNotFoundException{
        Privileges privilege = privilegeRepository.findById(id)
                .orElseThrow(() -> new PrivilegeNotFoundException("Privilege with the id: " + id + " does not exist"));

        privilegeRepository.delete(privilege);
        return new ResponseEntity<>(privilege, HttpStatus.OK);
    }

}
