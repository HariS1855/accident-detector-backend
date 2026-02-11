package com.backend.accidentdetector.controller;

import com.backend.accidentdetector.dto.AccidentRequest;
import com.backend.accidentdetector.service.TwilioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accident")
public class AccidentController {

    private final TwilioService twilioService;

    public AccidentController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }


    @PostMapping("/detect")
    public String detectAccident(@RequestBody AccidentRequest request) {

        String message = "🚨 ACCIDENT DETECTED 🚨\n"
                + "Location: " + request.getLocation() + "\n"
                + "Severity: " + request.getSeverity();

        twilioService.sendSms(message);
        twilioService.makeCall();

        return "Ambulance alerted successfully";
    }
}
