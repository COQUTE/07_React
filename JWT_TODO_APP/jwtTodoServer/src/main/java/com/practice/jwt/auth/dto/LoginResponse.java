package com.practice.jwt.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class LoginResponse {
    private String accessToken;
    private String nickname;
}
