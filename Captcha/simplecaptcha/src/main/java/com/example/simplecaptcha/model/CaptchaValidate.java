package com.example.simplecaptcha.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaptchaValidate {
    private boolean isChallenge;
}
