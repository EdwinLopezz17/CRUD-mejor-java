package com.api.crud.controllers;


import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping("/add")
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping("{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @PutMapping("{id}")
    public UserModel updateUser(@RequestBody UserModel request,  @PathVariable("id") Long id){
        return this.userService.update(request,id);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);

        if(ok){
            return "Usario con id "+id +" eliminado";
        }else{
            return "Error al eliminar "+ id;
        }
    }

}
