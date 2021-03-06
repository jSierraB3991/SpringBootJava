package com.example.hcaptcha.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaptchaResponse {
    private boolean isSuccess;
    private List<String> errorCodes;
    private LocalDateTime challenge;
    private String hostname;
}
