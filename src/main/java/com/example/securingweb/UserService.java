package com.example.securingweb;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UsersDTO getUser(Long id){
        return modelMapper.map(userRepo.findById(id).orElseThrow(RuntimeException::new), UsersDTO.class);
    }

    public void addUser(UsersDTO usersDTO){
        Users users = modelMapper.map(usersDTO, Users.class);
        userRepo.save(users);
    }

}
