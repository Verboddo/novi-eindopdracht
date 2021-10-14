package com.smeekens.eindopdracht.eindopdracht.service;

import com.smeekens.eindopdracht.eindopdracht.dto.request.UserPostRequest;
import com.smeekens.eindopdracht.eindopdracht.exception.BadRequestException;
import com.smeekens.eindopdracht.eindopdracht.exception.RecordNotFoundException;
import com.smeekens.eindopdracht.eindopdracht.model.User;
import com.smeekens.eindopdracht.eindopdracht.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    public String createUser(UserPostRequest userPostRequest) {
        try {
            String encryptedPassword = passwordEncoder.encode(userPostRequest.getPassword());

            User user = new User();
            user.setUsername(userPostRequest.getUsername());
            user.setPassword(encryptedPassword);
            user.setEnabled(true);
            user.addAuthority("ROLE_USER");
            for (String s : userPostRequest.getAuthorities()) {
                if (!s.startsWith("ROLE_")) {
                    s = "ROLE_" + s;
                }
                user.addAuthority(s);
            }

            User newUser = userRepository.save(user);
            return newUser.getUsername();
        }
        catch (Exception ex) {
            throw new BadRequestException("Cannot create user.");
        }

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
