package com.project.project.controller;

import com.project.project.responHandler.AuthenticationResponse;
import com.project.project.responHandler.CustomResponse;
import com.project.project.service.AuthenticationService;
import com.project.project.util.AuthenticationRequest;
import com.project.project.util.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private  final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<CustomResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<CustomResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
