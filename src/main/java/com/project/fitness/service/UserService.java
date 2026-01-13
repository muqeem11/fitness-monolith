package com.project.fitness.service;


import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
     private final UserRepository userRepository;
    public UserResponse register(RegisterRequest request) {

        User user = User.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

//        user.setEmail(request.getEmail());
//        user.setPassword(request.getPassword());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setCreateAt(
//                Instant.parse("2026-01-12T04:52:47.305Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime()
//        );
//        user.setUpdateAt(
//                Instant.parse("2026-01-12T04:52:47.305Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime()
//        );

        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User savedUser) {
        UserResponse response= new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setPassword(savedUser.getPassword());
        response.setCreateAt(savedUser.getCreateAt());
        response.setUpdateAt(savedUser.getUpdateAt());
        return response;

    }
    }




