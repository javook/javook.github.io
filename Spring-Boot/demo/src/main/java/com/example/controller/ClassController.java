package com.example.controller;

import com.example.dao.MyDAO;
import com.example.dto.MyDTO;
import com.example.service.ClassUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/class")
public class ClassController {

    private final ClassUserService classUserService;

    public ClassController(ClassUserService classUserService) {
        this.classUserService = classUserService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")//{firstName}/{lastName}")
    public List<MyDAO> saveUser(@RequestBody MyDTO dto){
        //MyDTO dto = new MyDTO(firstName, lastName);
        return classUserService.saveUser(dto);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/{id}")
    public MyDTO getUser(@PathVariable Integer id){
        return classUserService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getallusers")
    public List<MyDAO> getAllUsers(){
        return classUserService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        classUserService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}/{firstName}/{lastName}")
    public void updateUser(@PathVariable Integer id, @PathVariable String firstName, @PathVariable String lastName){
        classUserService.updateUser(id, firstName, lastName);
    }
}
