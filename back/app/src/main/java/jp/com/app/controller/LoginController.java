package jp.com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.com.app.dto.LoginRequestDto;
import jp.com.app.dto.LoginResponseDto;

@RestController
public class LoginController {


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> callGetUserData(HttpServletRequest request, HttpServletResponse response, LoginRequestDto requestDto){
        System.out.println("********************************************************************************");
        System.out.println(request);
        System.out.println("********************************************************************************");
        return ResponseEntity.ok(new LoginResponseDto(true,"成功"));
    }
}
