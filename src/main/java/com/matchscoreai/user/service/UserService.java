package com.matchscoreai.user.service;

import com.matchscoreai.user.dto.CreateUserRequest;
import com.matchscoreai.user.dto.UserResponse;
import com.matchscoreai.user.entity.UserEntity;
import com.matchscoreai.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse create(
            CreateUserRequest request
    ) {
        if(userRepository.existsByEmail(
                request.email()
        )) {
            throw new RuntimeException(
                    "Email already exists"
            );
        }

        UserEntity user = UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .createdAt(LocalDateTime.now())
                .build();

        UserEntity savedUser =
                userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

}
