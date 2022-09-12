package com.example.demo.response;

import com.example.demo.model.Privileges;
import com.example.demo.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Privileges privileges;
    private Roles roles;

}
