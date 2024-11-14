package com.gdgline.mulmung.domain.user.service;

import com.gdgline.mulmung.domain.user.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface UserService {
    ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto);
    ResponseEntity<String> signUp(UserDto userDto);
    ResponseEntity<Boolean> isEmailEmpty(String email);
    ResponseEntity<Boolean> deleteAccount(Authentication authentication);
}