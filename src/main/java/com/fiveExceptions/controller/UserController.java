package com.fiveExceptions.controller;

import com.fiveExceptions.dto.AuthRequest;
import com.fiveExceptions.dto.UserRequest;
import com.fiveExceptions.service.JwtService;
import com.fiveExceptions.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("create")
    public Map<String, String> createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return Collections.emptyMap();
    }

    @PostMapping("authentication")
    public String authenticateUser(@RequestBody AuthRequest authRequest) {
        return jwtService.generateToken(authRequest.getUsername());
    }

}
