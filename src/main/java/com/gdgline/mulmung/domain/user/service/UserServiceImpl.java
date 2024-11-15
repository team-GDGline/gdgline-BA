package com.gdgline.mulmung.domain.user.service;

import com.gdgline.mulmung.domain.jwt.JwtTokenProvider;
import com.gdgline.mulmung.domain.pokedex.entity.Pokedex;
import com.gdgline.mulmung.domain.user.dto.*;
import com.gdgline.mulmung.domain.user.entity.User;
import com.gdgline.mulmung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto) {
        //AccessToken 만들어서 줘야함
        Optional<User> userByEmail = userRepository.findByEmail(loginRequestDto.getEmail());
        if (userByEmail.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (!passwordEncoder.matches(loginRequestDto.getPassword(), userByEmail.get().getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            LoginResponseDto loginResponseDto = LoginResponseDto.builder()
                    .accessToken(jwtTokenProvider.createAccessToken(loginRequestDto.getEmail()))
                    .nickName(userByEmail.get().getNickname())
                    .build();
            return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Boolean> deleteAccount(Authentication authentication) {
        String email = authentication.getName();
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }


    @Override
    public ResponseEntity<String> signUp(UserDto userDto) {
        try {
            // 비밀번호 인코딩
            String encoded = passwordEncoder.encode(userDto.getPassword());

            // Pokedex 생성
            Pokedex pokedex = new Pokedex();

            // 회원 저장
            User saved = userRepository.save(User.builder()
                    .email(userDto.getEmail())
                    .nickname(userDto.getNickName())
                    .password(encoded)
                    .pokedex(pokedex)
                    .build());

            // 저장된 객체가 null인 경우 처리
            return new ResponseEntity<>("회원가입 완료", HttpStatus.OK); // 성공 시 200 반환
        } catch (Exception e) {
            // 예외 발생 시 처리
            log.info("회원가입 중 오류: " + e);
            return new ResponseEntity<>("회원가입 실패", HttpStatus.BAD_REQUEST); // 이메일 조회 후 회원가입 할것
        }
    }

    @Override
    public ResponseEntity<Boolean> isEmailEmpty(String email) {
        return new ResponseEntity<>(userRepository.findByEmail(email).isEmpty(), HttpStatus.OK);
    }
}
