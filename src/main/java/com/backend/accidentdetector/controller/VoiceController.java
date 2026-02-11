package com.backend.accidentdetector.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoiceController {

    @RequestMapping(
        value = "/voice",
        produces = "application/xml"
    )
    public String voice() {
        return """
            <Response>
                <Say voice="alice">
                    Accident detected. Please send ambulance immediately.
                </Say>
            </Response>
        """;
    }
}

