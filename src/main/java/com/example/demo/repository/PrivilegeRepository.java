package com.example.demo.repository;

import com.example.demo.model.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privileges, Integer> {

}
