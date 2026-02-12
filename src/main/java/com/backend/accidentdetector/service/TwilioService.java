package com.backend.accidentdetector.service;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class TwilioService {

    @Value("${twilio.fromNumber}")
    private String fromNumber;

    @Value("${twilio.toNumber}")
    private String ambulanceNumber;

    @Value("${twilio.appBaseUrl}")
    private String baseUrl;

    public void sendSms(String text) {
        Message message = Message.creator(
                new PhoneNumber(ambulanceNumber),
                new PhoneNumber(fromNumber),
                text
        ).create();

        System.out.println("SMS sent, SID: " + message.getSid());
    }

    public void makeCall() {
        try {
            String url = baseUrl.endsWith("/") ? baseUrl + "voice" : baseUrl + "/voice";

            Call call = Call.creator(
                new PhoneNumber(ambulanceNumber),
                new PhoneNumber(fromNumber),
                URI.create(url)
                ).create();

            System.out.println("Call triggered successfully, SID: " + call.getSid());
        } catch (Exception e) {
            System.err.println("Failed to make call: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

