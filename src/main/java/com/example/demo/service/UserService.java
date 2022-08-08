package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void updateUser(Integer id, UserRequest newUser) {
        Optional<User> user = userRepository.findById(id);
        UserResponse response = new UserResponse();

        if (user.isPresent()) {
            user.get().setFirstName(newUser.getFirstName());
            user.get().setLastName(newUser.getLastName());
            user.get().setEmail(newUser.getEmail());

            response.setFirstName(user.get().getFirstName());
            response.setLastName(user.get().getLastName());
            response.setEmail(user.get().getEmail());
        }
    }

}
