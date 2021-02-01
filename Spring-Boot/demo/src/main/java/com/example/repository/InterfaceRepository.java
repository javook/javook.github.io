package com.example.repository;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceRepository extends CrudRepository<User, Integer>{

//    List<User> findAllByFirstName(String firstName);
//    Optional<User> findById(Integer id);
}
