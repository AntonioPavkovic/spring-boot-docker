package com.example.demo.service;

import com.example.demo.exception.PrivilegeNotFoundException;
import com.example.demo.model.Privileges;
import com.example.demo.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    public Optional<Privileges> getPrivilege(Integer id) {
        Optional<Privileges> privileges = privilegeRepository.findById(id);

        return privileges;
    }


    public Privileges createPrivilege (Privileges privileges) {

        Privileges existingPrivileges = privilegeRepository.findByPrivilegeName(privileges.getPrivilegeName());

        if(existingPrivileges != null) {
            return null;
        }

        privileges = privilegeRepository.save(privileges);
        return privileges;
    }

    public Privileges updatePrivilege (Privileges privileges) {

        Optional<Privileges> existingPrivileges = privilegeRepository.findById(privileges.getId());

        if (existingPrivileges.isPresent()) {
            privileges = privilegeRepository.save(privileges);

            return privileges;
        }

        return null;
    }

    public void deletePrivilege (Integer id) throws PrivilegeNotFoundException {

        Privileges privileges = privilegeRepository.findById(id)
                .orElseThrow(() -> new PrivilegeNotFoundException("Privilege with the id: " + id + " does not exist"));

        privilegeRepository.delete(privileges);
    }
}
