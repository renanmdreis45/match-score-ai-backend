package com.matchscoreai.auth.service;

import com.matchscoreai.auth.dto.LoginRequest;
import com.matchscoreai.auth.dto.LoginResponse;
import com.matchscoreai.shared.exception.InvalidCredentialsException;
import com.matchscoreai.user.entity.UserEntity;
import com.matchscoreai.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(
            LoginRequest request
    ) {
        UserEntity user = userRepository.findByEmail(
                request.email()
        ).orElseThrow(
                InvalidCredentialsException::new
        );

        if(!passwordEncoder.matches(
                request.password(),
                user.getPassword()
        )) {
            throw new InvalidCredentialsException();
        }

        return new LoginResponse("Login successful");
    }

}
