package com.matchscoreai.auth.service;

import com.matchscoreai.auth.dto.LoginRequest;
import com.matchscoreai.auth.dto.LoginResponse;
import com.matchscoreai.user.entity.UserEntity;
import com.matchscoreai.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public LoginResponse login(
            LoginRequest request
    ) {
        UserEntity user = userRepository.findByEmail(request.email()).orElseThrow(
                () -> new RuntimeException(
                        "Invalid credentials"
                )
        );

        if(!user.getPassword().equals(
                request.password()
        )) {
            throw  new RuntimeException("Invalid credentials");
        }

        return new LoginResponse("Login successful");
    }

}
