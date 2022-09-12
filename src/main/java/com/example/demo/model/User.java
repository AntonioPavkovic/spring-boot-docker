package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * User class represents user table in database
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * user ID
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private Integer id;

    /**
     * users first name
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * users last name
     */
    @Column(name = "last_name")
    private String lastName;
    /**
     * users email
     */
    @Column(name = "email")
    private String email;

    @Column(name = "role_id", nullable = true)
    private Integer roleId;

    @Column(name = "privilege_id", nullable = true)
    private Integer privilegeId;
}
