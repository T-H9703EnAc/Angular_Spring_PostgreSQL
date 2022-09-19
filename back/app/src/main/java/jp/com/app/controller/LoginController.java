package jp.com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.com.app.dto.LoginRequestDto;
import jp.com.app.dto.LoginResponseDto;

@RestController
public class LoginController {
    @PostMapping("/login")
    @CrossOrigin(origins = {"http://localhost:4200"})
    public ResponseEntity<LoginResponseDto> callGetUserData(LoginRequestDto requestDto){
        return ResponseEntity.ok(new LoginResponseDto(true,"成功"));
    }
}
