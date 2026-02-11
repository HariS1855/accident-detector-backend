package com.backend.accidentdetector.service;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class TwilioService {

    @Value("${TWILIO_FROM_NUMBER}")
    private String fromNumber;

    @Value("${TWILIO_TO_NUMBER}")
    private String ambulanceNumber;

    @Value("${APP_BASE_URL}")
    private String baseUrl;

    public void sendSms(String text) {
        Message.creator(
                new PhoneNumber(ambulanceNumber),
                new PhoneNumber(fromNumber),
                text
        ).create();
    }

    public void makeCall() {
        Call.creator(
                new PhoneNumber(ambulanceNumber),
                new PhoneNumber(fromNumber),
                URI.create(baseUrl + "/voice")
        ).create();
    }
}
