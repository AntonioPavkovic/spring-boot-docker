package com.example.demo.service;

import com.example.demo.exception.PrivilegeNotFoundException;
import com.example.demo.model.Privileges;
import com.example.demo.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    public List<Privileges> getAllPrivileges() {
        return privilegeRepository.findAll();
    }
    public Optional<Privileges> getPrivilegeById(Integer id) {
        return privilegeRepository.findById(id);
    }


    public Privileges createPrivilege (Privileges privileges) {
        return privilegeRepository.save(privileges);
    }

    public Privileges updatePrivilege (Privileges privileges) {

        Optional<Privileges> existingPrivileges = privilegeRepository.findById(privileges.getId());

        if (existingPrivileges.isPresent()) {
            privileges = privilegeRepository.save(privileges);

            return privileges;
        }

        return null;
    }
}
