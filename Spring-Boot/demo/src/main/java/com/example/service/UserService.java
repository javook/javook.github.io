package com.example.service;

import com.example.dao.MyDAO;
import com.example.dto.MyDTO;
import com.example.model.User;
import com.example.repository.TestRepository;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TestRepository testRepository;

    public UserService(UserRepository userRepository, TestRepository testRepository) {
        this.userRepository = userRepository;
        this.testRepository = testRepository;
    }

    public List<MyDAO> saveUser(MyDTO dto){
        MyDAO newDao = DTOtoDAO(dto);
        testRepository.save(newDao);
        Iterator<User> daoIterator = userRepository.findAll().iterator();
        List<MyDAO> daoList = new ArrayList<>();
        while(daoIterator.hasNext()){daoList.add(UsertoDAO(daoIterator.next()));}
        return daoList;
    }

    public MyDTO getUser(Integer id){
        MyDAO returnedDAO = testRepository.findById(id);
        return DAOtoDTO(returnedDAO);
    }

    public String getUsersList(){
        return userRepository.findAll().toString();
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
    public MyDTO DAOtoDTO(MyDAO dao){
        return new MyDTO(dao.getFirstName(), dao.getLastName());
    }

    public MyDAO DTOtoDAO(MyDTO dto){
        return new MyDAO(dto.getFirstName(), dto.getLastName());
    }

    public MyDAO UsertoDAO(User user){
        return new MyDAO(user.getFirstName(),user.getLastName());
    }
}
