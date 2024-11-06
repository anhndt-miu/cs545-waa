package dev.anhndt.lab5.service;

import dev.anhndt.lab5.entity.dto.request.LoginRequest;
import dev.anhndt.lab5.entity.dto.request.RefreshTokenRequest;
import dev.anhndt.lab5.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
