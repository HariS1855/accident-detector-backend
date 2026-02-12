package com.backend.accidentdetector.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class VoiceController {

    @PostMapping(value = "/voice", produces = MediaType.APPLICATION_XML_VALUE)
    public String handleVoiceAlert() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
               "<Response>" +
               "<Say voice=\"alice\" loop=\"2\">" +
               "🚨 Accident detected! Please send ambulance immediately." +
               "</Say>" +
               "</Response>";
    }

    @GetMapping(value = "/voice", produces = MediaType.APPLICATION_XML_VALUE)
    public String testVoiceAlert() {
        return handleVoiceAlert();
    }
}


