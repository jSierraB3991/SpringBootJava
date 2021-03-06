package com.example.simplecaptcha.controller;

import com.example.simplecaptcha.model.CaptchaResponse;
import com.example.simplecaptcha.model.CaptchaValidate;
import com.example.simplecaptcha.service.CaptchaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class CaptchaController {

    private final CaptchaService captchaService;

        @GetMapping("/captchaImg")
    public CaptchaResponse getCaptchaImage() {
        String[] captchaData = captchaService.generateCaptchaImage(null);
        log.info("Id of captcha Image: {}", captchaData[1]);
        return CaptchaResponse.builder()
                .captchaId(captchaData[1])
                .captchaImg(captchaData[0])
                .build();
    }

    @GetMapping("/reloadCaptchaImg/{previous-captcha-id}")
    public CaptchaResponse reloadCaptchaImage(@PathVariable("previous-captcha-id") String previousCaptchaId){
        String[] captchaData = captchaService.generateCaptchaImage(previousCaptchaId);
        log.info("Id of captcha Image: {}", captchaData[1]);
        return CaptchaResponse.builder()
                .captchaId(captchaData[1])
                .captchaImg(captchaData[0])
                .build();
    }

    @PostMapping("/validateCaptcha/{captcha-id}")
    public CaptchaValidate challangeCaptcha(@PathVariable("captcha-id") String captchaId,
                                            @RequestParam(value="captcha-answer",required=false) String captchaAnswer){
        log.info("Id of captcha Image: {}", captchaId);
        log.info("Answer: {}", captchaAnswer);
        boolean isSuccess = false;
        if((captchaAnswer!=null && captchaAnswer.trim().length()!=0) && (captchaId!=null && captchaId.trim().length()!=0))
            isSuccess = captchaService.validateCaptcha(captchaId, captchaAnswer);

        return CaptchaValidate.builder()
                .isChallenge(isSuccess)
                .build();
    }
}
