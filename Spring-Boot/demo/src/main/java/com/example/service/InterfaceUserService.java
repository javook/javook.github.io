package com.example.service;

import com.example.dto.MyDTO;
import com.example.model.User;
import com.example.repository.InterfaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class InterfaceUserService {

    InterfaceRepository interfaceRepository;

    public InterfaceUserService(InterfaceRepository interfaceRepository) {
        this.interfaceRepository = interfaceRepository;
    }

    @Transactional
    public List<MyDTO> saveUser(MyDTO dto) {
        User user = new User(dto.getFirstName(), dto.getLastName());
        interfaceRepository.save(user);
        Iterator<User> userIterator = interfaceRepository.findAll().iterator();
        List<MyDTO> dtoList = new ArrayList<>();
        while (userIterator.hasNext()) {
            user = userIterator.next();
            dtoList.add(new MyDTO(user.getFirstName(), user.getLastName()));
        }
        return dtoList;
    }

    public MyDTO getUser(Integer id){
        User user = interfaceRepository.findById(id).get();
        return new MyDTO(user.getFirstName(), user.getLastName());
    }

    public List<MyDTO> getAllUsers(){
        Iterator<User> userIterator = interfaceRepository.findAll().iterator();
        List<MyDTO> dtoList = new ArrayList<>();
        User user;
        while (userIterator.hasNext()){
            user = userIterator.next();
            dtoList.add(new MyDTO(user.getFirstName(), user.getLastName()));
        }
        return dtoList;
    }

    public void updateUser(Integer id, String firstName, String lastName){
        User user = interfaceRepository.findById(id).get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        interfaceRepository.save(user);
    }

    public void deleteUser(Integer id){
        interfaceRepository.deleteById(id);
    }
}