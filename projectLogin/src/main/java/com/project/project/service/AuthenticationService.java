package com.project.project.service;

import com.project.project.entity.OurUsers;
import com.project.project.entity.Role;
import com.project.project.repository.UserRepo;
import com.project.project.responHandler.AuthenticationResponse;
import com.project.project.responHandler.CustomResponse;
import com.project.project.util.AuthenticationRequest;
import com.project.project.util.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public CustomResponse register(RegisterRequest request) {
        try {
            if (request.getUsername() == null || request.getUsername().isEmpty() ||
                    request.getPassword() == null || request.getPassword().isEmpty()) {
                throw new IllegalArgumentException("Username and password cannot be empty");
            }
            if (!request.getUsername().contains("@") || !request.getUsername().contains(".")) {
                throw new IllegalArgumentException("Username must contain '@' and domain");
            }

            // Check if the username already exists in the database
            if (userRepo.existsByUsername(request.getUsername())) {
                throw new IllegalArgumentException("Username is already taken");
            }

            Role role = request.getUsername().contains("@admin.com") ? Role.ADMIN : Role.USER;

            var user = OurUsers.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(role)
                    .build();
            userRepo.save(user);
            var jwtToken = jwtService.generateToken(user);
            AuthenticationResponse response = AuthenticationResponse
                    .builder()
                    .token(jwtToken)
                    .build();
            return new CustomResponse("Register Berhasil", "Token Anda: " +response.getToken());
        }catch(IllegalArgumentException e){
            CustomResponse errorResponse = new CustomResponse();
            errorResponse.setStatus("failed");
            errorResponse.setMessage("Error: " + e.getMessage());
            return new CustomResponse("failed", "Error: " + e.getMessage());
        }
    }

    public CustomResponse authenticate(AuthenticationRequest request) {
        try {
            if (request.getUsername() == null || request.getUsername().isEmpty() ||
                    request.getPassword() == null || request.getPassword().isEmpty()) {
                throw new IllegalArgumentException("Username and password cannot be empty");
            }
            if (!request.getUsername().contains("@") || !request.getUsername().contains(".")) {
                throw new IllegalArgumentException("Username must contain '@' and domain");
            }
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            var user = userRepo.findByUsername(request.getUsername())
                    .orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            AuthenticationResponse response = AuthenticationResponse
                    .builder()
                    .token(jwtToken)
                    .build();
            return new CustomResponse("Login Berhasil","Token Anda: "+response.getToken());
        } catch (IllegalArgumentException e){
            CustomResponse errorResponse = new CustomResponse();
            errorResponse.setStatus("failed");
            errorResponse.setMessage("Error: " + e.getMessage());
            return new CustomResponse("failed", "Error: " + e.getMessage());
        }
    }
}
