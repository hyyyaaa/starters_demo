package com.example.web.rest;

import com.example.domain.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by bugrahansahin on 13/07/16.
 */
@RestController
@RequestMapping("/api")
public class users {

    @RequestMapping("/test")
    String test() {
        return "Controllers Working";
    }

    @RequestMapping("/users")
    Collection<User> findAll() {
        System.out.println(this.userRepository.findAll().toString());
        return this.userRepository.findAll();
    }

    @RequestMapping("/users/{id}")
    User findAll(@PathVariable long id) {
        return this.userRepository.findOne(id);
    }

//put id
    //post

    /*  @RequestMapping(value = "/users",method = RequestMethod.POST)
      String addUser() {
          User newComer=new User();
          this.userRepository.save(newComer);
          return "User Added Successfully! <br>" + newComer.toString();
      }*/
   /* @RequestMapping(value = "/users",method = RequestMethod.POST)
    String addUser(@RequestParam("name") String name) {
        User newComer=new User(name);
        this.userRepository.save(newComer);
        return "User Added Successfully! <br>" + newComer.toString();
    }*/
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    User addUser(@RequestBody User user) {
        this.userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/users/find/{initial}/replace/{replacement}", method = RequestMethod.PUT)
    String change(@PathVariable String initial, @PathVariable String replacement) {
        this.userRepository.findByNameStartingWith(initial).forEach(user -> {
            user.setName(replacement);
            this.userRepository.save(user);
        });
        System.out.println(this.userRepository.findByNameStartingWith(initial).toString());
        System.out.println("_______________\n" + this.userRepository.findAll());
        return "Replacement done!";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    String removeUser(@PathVariable Long id) {
        this.userRepository.delete(id);
        return "User Removed Successfully!";
    }

    @RequestMapping("/users/find/{name}")
    Collection<User> findUser(@PathVariable String name) {
        return this.userRepository.findAllByName(name);
    }

    @RequestMapping(value = "/users/find/{name}", method = RequestMethod.DELETE)
    String deleteUsersByName(@PathVariable String name) {
        this.userRepository.findAllByName(name).forEach(user -> {
            this.userRepository.delete(user);
        });
        return "Users deleted successfully";
    }


    @Autowired
    private UserRepository userRepository;
}
