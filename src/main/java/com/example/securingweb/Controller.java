package com.example.securingweb;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Data
public class Controller {
private final UserService userService;
private final JWTUtil jwtUtil;
    @GetMapping("/get/")
    public UsersDTO get(@RequestParam Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/post")
    public Map<String, String> post(@RequestBody UsersDTO usersDTO) {
       userService.addUser(usersDTO);
       Map<String, String>map = new HashMap<>();
       String token = jwtUtil.generateToken(usersDTO.getUsername());
       map.put("jwt-token", token);
       return map;

    }
}
