package com.register.user.controller;

import com.register.user.dto.UserDTO;
import com.register.user.entity.User;
import com.register.user.exceptions.ResourceNotFoundException;
import com.register.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<String> findById(@PathVariable Long id){

        try {
            userService.findById(id);
            return new ResponseEntity<String>("Usuário com o id : " +id+ " encontrado com sucesso" , HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

    }

    @PostMapping
    public ResponseEntity<UserDTO> insertUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@RequestParam Long id){

        try {
            userService.deleteById(id);
            return ResponseEntity.ok().body("Usuario com o id : " +id+ " deletado com sucesso");
        } catch (ResourceNotFoundException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado " +e);
        }
    }

}
