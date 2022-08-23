package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController - rest controller with custom routes for getting all users, getting users by id,
 * creating and updating users and deleting them.
 *
 * @see User
 * @see UserRepository
 * @see UserNotFoundException
 *
 * @author AntonioPavkovic
 */

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    /**
     * API endpoint - GET method that returns a list of users
     *
     * @return List of all users
     */
    @GetMapping()
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * API endpoint - GET method that returns a user with a given ID
     *
     * @param id
     * @return ResponseEntity with a user and a status code
     * @throws UserNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer id) throws UserNotFoundException {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * API endpoint - POST method that inserts a user into database
     *
     * @param user
     * @return new ResponseEntity with an appropriate HTTP status code
     */
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    /**
     * API endpoint - PUT method that updates a user based on his id
     *
     * @param id
     * @param u
     * @return Response Entity with an appropriate HTTP status code
     * @throws UserNotFoundException
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Integer id,
            @RequestBody User u
    ) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " +id+ " not found"));

        user.setId(u.getId());
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setEmail(u.getEmail());

        final User updatedUser = userRepository.save(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * API endpoint - DELETE method that deletes a user based on his id
     *
     * @param id
     * @return Response Entity with an appropriate HTTP status code
     * @throws UserNotFoundException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Integer id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));

        userRepository.delete(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
