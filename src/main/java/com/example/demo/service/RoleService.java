package com.example.demo.service;

import com.example.demo.exception.RoleNotFoundException;
import com.example.demo.model.Roles;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Roles> getRole(Integer id) {
        Optional<Roles> roles = roleRepository.findById(id);
        return roles;
    }

    public Roles createRole (Roles roles) {

        Roles existingRoles = roleRepository.findRoleByRoleName(roles.getRoleName());

        if (existingRoles != null) {
            return null;
        }

        roles = roleRepository.save(roles);
        return roles;
    }

    public Roles updateRoles(Roles roles) {

        Optional<Roles> existingRole = roleRepository.findById(roles.getId());

        if (existingRole.isPresent()) {
            roles = roleRepository.save(roles);

            return roles;
        }
        return null;
    }


    public void deleteRole(Integer id) throws RoleNotFoundException{

        Roles roles = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with the id: " + id + " does not exist"));

        roleRepository.delete(roles);
    }

}
