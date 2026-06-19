package com.matchscoreai.user.controller;

import com.matchscoreai.user.dto.CreateUserRequest;
import com.matchscoreai.user.dto.UserResponse;
import com.matchscoreai.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(
            @RequestBody
            @Valid
            CreateUserRequest request
    ) {
        return userService.create(request);
    }
}
