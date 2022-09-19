package jp.com.app.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    String name;
    String email;
    String password;
}
