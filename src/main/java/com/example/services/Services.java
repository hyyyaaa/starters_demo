package com.example.services;

import com.example.domain.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by bugrahansahin on 14/07/16.
 */
@Service
public class Services {
    @Autowired
    private UserRepository userRepository;

    public Collection<User> allUsers() {
        return this.userRepository.findAll();
    }

    public User findUserWithId(Long id) {
        return this.userRepository.findOne(id);
    }

    public User addUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    public String replace(String str1, String str2) {
        this.userRepository.findByNameStartingWith(str1).forEach(user -> {
            user.setName(str2);
            this.userRepository.save(user);
        });
        return "Replacement done!";
    }

    public String deleteUserWithId(Long id) {
        this.userRepository.delete(id);
        return "User Removed Successfully!";
    }

    public Collection<User> findUsersWithName(String name) {
        return this.userRepository.findAllByName(name);
    }

    public String deleteUsersWithName(String name) {
        this.userRepository.findAllByName(name).forEach(user -> {
            this.userRepository.delete(user);
        });
        return "Users deleted successfully";
    }
}
