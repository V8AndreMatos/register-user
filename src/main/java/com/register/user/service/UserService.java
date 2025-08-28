package com.register.user.service;

import com.register.user.dto.UserDTO;
import com.register.user.entity.User;
import com.register.user.exceptions.ResourceNotFoundException;
import com.register.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Find all users
    public List<UserDTO> findAll(){
       List<User> users = userRepository.findAll();
        return users.stream().map(x -> new UserDTO(x)).toList();
    }

    public UserDTO findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o id = " +id));
        return new UserDTO(user);
    }

    // Save User
    public UserDTO saveUser(UserDTO userDTO){
        // DTO -> Entity
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(user.getEmail());

        // Salva no banco de dados
        User savedUser = userRepository.save(user);

        // Entity -> DTO
        return new UserDTO(savedUser.getId() , savedUser.getName(), savedUser.getEmail());

    }

    // Delete user by ID
    public void deleteById(Long id ){

        if (!userRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        userRepository.deleteById(id);
    }

}
