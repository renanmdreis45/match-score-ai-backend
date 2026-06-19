package com.matchscoreai.auth.controller;

import com.matchscoreai.auth.dto.LoginRequest;
import com.matchscoreai.auth.dto.LoginResponse;
import com.matchscoreai.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody
            @Valid
            LoginRequest request
    ) {
        return authService.login(request);
    }
}
