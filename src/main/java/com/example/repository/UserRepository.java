package com.example.repository;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by bugrahansahin on 13/07/16.
 */

public interface UserRepository extends JpaRepository<User, Long>{
    Collection<User> findAllByName(String name);
    Collection<User> findByNameStartingWith(String name);
}
