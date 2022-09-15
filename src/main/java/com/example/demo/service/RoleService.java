package com.example.demo.service;

import com.example.demo.model.Roles;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Roles> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    public Roles createRole(Roles role) {
        return roleRepository.save(role);
    }

    public Roles updateRole(Roles role) {
        Optional<Roles> existingRole = roleRepository.findById(role.getId());
        if (existingRole.isPresent()) {
            role = roleRepository.save(role);
            return role;
        }
        return null;
    }
}
