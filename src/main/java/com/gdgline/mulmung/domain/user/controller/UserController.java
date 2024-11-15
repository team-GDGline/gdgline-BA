package com.gdgline.mulmung.domain.user.controller;

import com.gdgline.mulmung.domain.user.dto.*;
import com.gdgline.mulmung.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "이메일 중복 확인",
            description = "\"True: 회원가입 가능\" \"False: 회원가입 불가능\""
    )
    @GetMapping("/email/{email}")
    public ResponseEntity<Boolean> isEmailEmpty(@PathVariable String email){
        return userService.isEmailEmpty(email);
    }

    @Operation(
            summary = "회원가입",
            description = "Body에 회원정보(임시) 담아서 요청보내면 회원가입을 시켜줌. 이메일 중복 확인 후 호출해야함.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "회원가입 완료. 성공적으로 회원가입 되었습니다."),
                    @ApiResponse(responseCode = "400", description = "회원가입 실패. 이메일 중복되었을 가능성 있음.")
            }
    )
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserDto userDto){
        return userService.signUp(userDto);
    }

    @Operation(
            summary = "로그인",
            description = "Email, Password를 확인하고 AccessToken 발행함.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 로그인 되었습니다."),
                    @ApiResponse(responseCode = "404", description = "이메일이 틀렸습니다."),
                    @ApiResponse(responseCode = "401", description = "비밀번호가 틀렸습니다.")
            }
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return userService.login(loginRequestDto);
    }

    @Operation(
            summary = "회원 탈퇴",
            description = "현재 인증된 사용자의 계정을 삭제합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "회원 탈퇴가 성공적으로 완료되었습니다."),
                    @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없습니다.")
            }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteAccount(Authentication authentication) {
        return userService.deleteAccount(authentication);
    }
}