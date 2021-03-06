package com.example.simplecaptcha.service;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.gimpy.FishEyeGimpyRenderer;
import cn.apiclub.captcha.noise.StraightLineNoiseProducer;
import cn.apiclub.captcha.text.producer.NumbersAnswerProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import net.jodah.expiringmap.ExpiringMap;

@Component
@Slf4j
public class CaptchaService {

    private static final int CAPTCHA_WIDTH=200,CAPTCHA_HEIGHT=50;
    private static final long CAPTCHA_EXPIRY_TIME=60;

    private static Map<String, String> captchaCodeMap = ExpiringMap.builder().expiration(new Long(CAPTCHA_EXPIRY_TIME), TimeUnit.SECONDS).build();

    private SecureRandom random = new SecureRandom();
    public String nextCaptchaId() {
        return new BigInteger(130, random).toString(32);
    }

    public String[] generateCaptchaImage(String previousCaptchaId) {

        if(Optional.ofNullable(previousCaptchaId).isPresent())
            removeCaptcha(previousCaptchaId);

        Captcha captcha = new Captcha.Builder(CAPTCHA_WIDTH, CAPTCHA_HEIGHT)
                .addText(new NumbersAnswerProducer())
                .addBackground(new GradiatedBackgroundProducer())
                .addNoise(new StraightLineNoiseProducer())
                .gimp(new FishEyeGimpyRenderer())
                .addBorder()
                .build();
        String captchaPngImage = null;

        try {
            BufferedImage buf = captcha.getImage();
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(buf, "png", bao);
            bao.flush();
            byte[] imageBytes = bao.toByteArray();
            bao.close();
            captchaPngImage = new String(Base64.getEncoder().encode(imageBytes), "UTF-8");
        }
        catch(IOException ex){
            log.error("IOException ex: {}", ex.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String captchaId=this.nextCaptchaId();
        String[] imageParams = {captchaPngImage,captchaId};

        addCaptcha(captchaId, captcha.getAnswer());
        return imageParams;
    }


    public boolean validateCaptcha(String captchaId,String captchaAnswer){
        boolean result=false;
        if(captchaCodeMap.containsKey(captchaId) && captchaCodeMap.get(captchaId).equals(captchaAnswer))
            result= true;

        removeCaptcha(captchaId);
        return result;
    }

    private  static void addCaptcha(String captchaId,String captchaAnswer) {
        captchaCodeMap.putIfAbsent(captchaId, captchaAnswer);
        log.info("+++++ Element added to captchaCodeMap: {} => {}", captchaId, captchaAnswer);
        printElement();
    }

    private static void removeCaptcha(String captchaId){
        if(captchaCodeMap.containsKey(captchaId)){
            captchaCodeMap.remove(captchaId);
        }
        printElement();
    }


    private static void printElement() {
        log.info("captchaCodeMap Size: {}", captchaCodeMap.size());
        for (Map.Entry<String, String> entry : captchaCodeMap.entrySet()) {
            log.info("{} => {}", entry.getKey(), entry.getValue());
        }
    }


}
