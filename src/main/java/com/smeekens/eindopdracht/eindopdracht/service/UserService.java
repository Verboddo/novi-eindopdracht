package com.smeekens.eindopdracht.eindopdracht.service;

import com.smeekens.eindopdracht.eindopdracht.exception.RecordNotFoundException;
import com.smeekens.eindopdracht.eindopdracht.model.User;
import com.smeekens.eindopdracht.eindopdracht.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String username) {
        if (!userRepository.existsById(username)) {
            throw new RecordNotFoundException("User with username " + username + " is not found");
        }
        return userRepository.findById(username);
    }

    public String createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        if (!userRepository.existsById(username)) {
            throw new RecordNotFoundException();
        }
        userRepository.deleteById(username);
    }

    public void updateUser(String username, User newUser) {
        if (!userRepository.existsById(username)) {
            throw new RecordNotFoundException();
        }
        User user = userRepository.findById(username).get();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        userRepository.save(user);
    }

}
