package com.example.hcaptcha.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaptchaModel {
    private String user;
    private String email;
    private String captchaResponse;
}
