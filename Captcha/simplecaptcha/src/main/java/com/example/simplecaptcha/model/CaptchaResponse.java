package com.example.simplecaptcha.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaptchaResponse {
    private String captchaId;
    private String captchaImg;
}
