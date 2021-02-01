package com.example.controller;

import com.example.dto.MyDTO;
import com.example.service.InterfaceUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interface")
public class InterfaceController {
    private final InterfaceUserService interfaceUserService;
    public InterfaceController(InterfaceUserService interfaceUserService) {
        this.interfaceUserService = interfaceUserService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/save")//{firstName}/{lastName}")
    public List<MyDTO> saveUser(@RequestBody MyDTO dto){
        //MyDTO dto = new MyDTO(firstName, lastName);
        return interfaceUserService.saveUser(dto);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/get/{id}")
    public MyDTO getUser(@PathVariable Integer id){
        return interfaceUserService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getusers")
    public List<MyDTO> getAllUsers(){
        return interfaceUserService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        interfaceUserService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}/{firstName}/{lastName}")
    public void updateUser(@PathVariable Integer id, @PathVariable String firstName, @PathVariable String lastName){
        interfaceUserService.updateUser(id, firstName, lastName);
    }


}
