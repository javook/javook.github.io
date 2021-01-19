package com.example.controller;

import com.example.dao.MyDAO;
import com.example.dto.MyDTO;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/test")
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/save/{firstName}/{lastName}")
    public List<MyDAO> saveUser(@PathVariable String firstName, @PathVariable String lastName){
        MyDTO dto = new MyDTO(firstName, lastName);
        return userService.saveUser(dto);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/{id}")
    public MyDTO getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getusers")
    public String getAllUsers(){
        return userService.getUsersList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}