package com.example.hcaptcha.controller;


import com.example.hcaptcha.model.CaptchaModel;
import com.example.hcaptcha.model.CaptchaResponse;
import com.example.hcaptcha.service.CaptchaService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class CaptchaController {
    private final CaptchaService captchaService;


    @PostMapping("/signup")
    public CaptchaResponse signUp(@RequestBody CaptchaModel captcha){


        if(StringUtils.hasText(captcha.getCaptchaResponse())){
            return captchaService.signUp(captcha);
        }
        return CaptchaResponse.builder()
                .isSuccess(false)
                .build();
    }
}
