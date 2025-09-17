package com.example.portfolio.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.example.portfolio.form.SendMessageForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendMessageServiceImpl implements SendMessageService{

    private final SimpleMailMessage msg;

    @Override
    public void send(SendMessageForm form) {
        
        msg.setFrom   (form.getSenderMailAdress() + "/" + form.getSenderName());
        msg.setTo     ("kota1022mukai@gmail.com");
        msg.setSubject("Contact from the portfolio");
        msg.setText   (form.getMainMassage());

        throw new UnsupportedOperationException("Unimplemented method 'send'");
    }

}
