package com.example.repository;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer>{

//    List<User> findAllByFirstName(String firstName);
//    Optional<User> findById(Integer id);
}
