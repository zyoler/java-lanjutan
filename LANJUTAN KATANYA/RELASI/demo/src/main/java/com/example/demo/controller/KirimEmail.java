package com.example.demo.controller;

import com.example.demo.dto.MailRequest;
import com.example.demo.dto.MailResponse;
import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KirimEmail {
    @Autowired
    private EmailService emailService;

    @PostMapping("/kirimEmail")
    public MailResponse kirimEmail(@RequestBody MailRequest){
        return emailService.sendEmail(request);
    }
}

