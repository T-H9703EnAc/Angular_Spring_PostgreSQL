package jp.com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.com.app.dto.TestRequestDto1;
import jp.com.app.dto.TestResponseDto1;
import jp.com.app.service.TestService1;

@RestController
@RequestMapping(value = "/api/get")
public class TestController1 {
    @Autowired
    TestService1 service;

    @GetMapping("/getUserData")
    public ResponseEntity<List<TestResponseDto1>> callGetUserData(TestRequestDto1 requestDto){
        return ResponseEntity.ok(service.getUserData(requestDto));
    }

    @GetMapping("/addUserData")
    public void callAddUserData(TestRequestDto1 requestDto){
        service.addUserData(requestDto);
    }
}
