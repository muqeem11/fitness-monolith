package com.project.fitness.service;


import com.project.fitness.dto.LoginRequest;
import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.model.UserRole;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
     private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;
    public UserResponse register(RegisterRequest request) {
         UserRole role = request.getRole()!=null?request.getRole(): UserRole.USER;
        User user = User.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)

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

    public UserResponse mapToResponse(User savedUser) {
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

    public User authenticate(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if(user==null){
            throw new RuntimeException("Invalid Credentials");
        }
        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid Credentials");
        }
        return user;
    }
}




