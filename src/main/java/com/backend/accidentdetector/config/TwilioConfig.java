package com.backend.accidentdetector.config;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioConfig {

    @Value("${twilio.accountSid:}")
    private String accountSid;

    @Value("${twilio.authToken:}")
    private String authToken;

    @PostConstruct
    public void init() {
        if (!accountSid.isBlank() && !authToken.isBlank()) {
            Twilio.init(accountSid, authToken);
            System.out.println("✅ Twilio initialized successfully");
        } else {
            System.out.println("⚠️ Twilio not initialized (missing env vars)");
        }
    }
}

