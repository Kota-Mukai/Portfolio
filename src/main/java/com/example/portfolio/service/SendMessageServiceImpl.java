package com.example.portfolio.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.example.portfolio.form.SendMessageForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendMessageServiceImpl implements SendMessageService{

    private final MailSender ms;
   
    @Override
    public void send(SendMessageForm form) {

        SimpleMailMessage smm = new SimpleMailMessage();
        
        smm.setFrom   (form.getSenderMailAddress() + "/" + form.getSenderName());
        smm.setTo     ("kota1022mukai@gmail.com");
        smm.setSubject("Contact from the portfolio");
        smm.setText   (form.getMainMessage());
        ms.send(smm);
   }

}