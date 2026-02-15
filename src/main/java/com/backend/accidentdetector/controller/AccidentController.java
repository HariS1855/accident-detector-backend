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

        // Build Google Maps link from lat,lng
        String mapLink = "https://www.google.com/maps?q=" + "12.926594,80.117817";

        // SMS + call message
        String message = "🚨 ACCIDENT ALERT 🚨\n"
                       + "Severity: " + request.getSeverity() + "\n"
                       + "View on Map: " + mapLink;

        twilioService.sendSms(message);
        twilioService.makeCall();

        return "Ambulance alerted successfully";
    }
}
