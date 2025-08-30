package com.register.user.controller;

import com.register.user.dto.UserDTO;
import com.register.user.entity.User;
import com.register.user.exceptions.ResourceNotFoundException;
import com.register.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<String> findById(@PathVariable Long id){
         userService.findById(id);
         return new ResponseEntity<String>("Usuário com o id : " +id+ " encontrado com sucesso" , HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserDTO> insertUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<String> findByEmail(@PathVariable String email) {
        userService.findByEmail(email);
        return ResponseEntity.ok("Usuário com o email: " + email + " encontrado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Usuário com o id " + id + " deletado com sucesso");
    }


}
