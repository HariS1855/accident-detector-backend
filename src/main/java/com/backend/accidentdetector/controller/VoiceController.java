package com.backend.accidentdetector.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoiceController {

    @PostMapping(value = "/voice", produces = "application/xml")
    public String voiceMessage() {
        return """
            <Response>
                <Say voice="alice">
                    Accident detected. Please send ambulance immediately.
                </Say>
            </Response>
        """;
    }
}
