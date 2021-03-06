package com.example.hcaptcha.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.hcaptcha.model.CaptchaModel;
import com.example.hcaptcha.model.CaptchaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
@Slf4j
public class CaptchaService {

    private static final int STATUS_CODE_SUCCESS = 200;

    @Value("${hCaptcha.secret.key}")
    private String hCaptchaSecretKey;

    private final ObjectMapper om = new ObjectMapper();

    public CaptchaResponse signUp(CaptchaModel captcha) {
        try {
            String urlString = "https://hcaptcha.com/siteverify?secret=" + hCaptchaSecretKey
                    + "&response=" + captcha.getCaptchaResponse();

            log.info("url: {}", urlString);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != STATUS_CODE_SUCCESS) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            CaptchaResponse captchaResponse = CaptchaResponse.builder()
                    .isSuccess(false)
                    .build();
            String output;
            if ((output = br.readLine()) != null) {
                System.out.println(output);

                JsonNode hCaptchaResponseObject = this.om.readTree(output);
                boolean success = hCaptchaResponseObject.get("success").asBoolean();

                if(success){
                    JsonNode challenge = hCaptchaResponseObject.get("challenge_ts");
                    JsonNode hostname = hCaptchaResponseObject.get("hostname");
                    captchaResponse = CaptchaResponse.builder()
                            .isSuccess(true)
                            .challenge(LocalDateTime.parse(challenge.asText()))
                            .hostname(hostname.asText())
                            .build();
                }else{
                    List<String> errorCodesList = new ArrayList<>();
                    JsonNode errorCodesArray = hCaptchaResponseObject.get("error-codes");
                    for (JsonNode errorCode : errorCodesArray) {
                        errorCodesList.add(errorCode.asText());
                    }
                    captchaResponse = CaptchaResponse.builder()
                            .isSuccess(false)
                            .errorCodes(errorCodesList)
                            .build();
                }
            }
            conn.disconnect();
            return captchaResponse;
        }
        catch (MalformedURLException me){
            log.error("MalformedURLException: {}", me.getMessage());
        }
        catch (Exception ex){
            log.error("General: {}", ex.getMessage());
            ex.printStackTrace();
        }
        return CaptchaResponse.builder()
                .isSuccess(false)
                .build();
    }
}
