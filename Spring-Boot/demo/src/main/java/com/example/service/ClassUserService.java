package com.example.service;

import com.example.dao.MyDAO;
import com.example.dto.MyDTO;
import com.example.model.User;
import com.example.repository.ClassRepository;
import com.example.repository.InterfaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassUserService {

    private final ClassRepository classRepository;

    public ClassUserService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<MyDAO> saveUser(MyDTO dto){
        MyDAO newDao = DTOtoDAO(dto);
        classRepository.save(newDao);
        List<MyDAO> daoList = classRepository.findAll();
        return daoList;
    }

    public MyDTO getUser(Integer id){
        MyDAO returnedDAO = classRepository.findById(id);
        return DAOtoDTO(returnedDAO);
    }

    public List<MyDAO> getAllUsers(){
        return classRepository.findAll();
    }

    public void deleteUser(Integer id){
        classRepository.delete(id);
    }

    public void updateUser(Integer id, String firstName, String lastName){
        classRepository.update(id, firstName, lastName);
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
