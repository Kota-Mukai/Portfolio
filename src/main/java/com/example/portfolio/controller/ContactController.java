package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.portfolio.form.SendMessageForm;
import com.example.portfolio.service.SendMessageService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequiredArgsConstructor
public class ContactController {

    private final SendMessageService service;

    @GetMapping("/contact")
    public String showContactPage(@ModelAttribute SendMessageForm form) {
        return "contact";
    }

    @PostMapping("/contact-ret")
    public String showContactPageRet(@ModelAttribute SendMessageForm form){
        return "contact";
    }
        
    @PostMapping("/confirm-contact-message")
    public String confirmContactMessage(@Validated @ModelAttribute
                        SendMessageForm form, BindingResult result) {

        if(result.hasErrors()){
            return "contact";
        }

        return "confirm-contact-message";
    }

    @PostMapping("/send-message")
    public String sendContactMessage(@Validated SendMessageForm form,
                    BindingResult result,
                    RedirectAttributes redirectAttributes) {
        
        if (result.hasErrors()) {
            return "contact";
        }

        service.send(form);

        redirectAttributes.addFlashAttribute("msg", "Thank you for contacting me.");
        redirectAttributes.addFlashAttribute("msg2", "I'll respond after reviewing it.");
        
        return "redirect:/complete";
    }

    @GetMapping("/complete")
    public String complete() {
        
    	return "complete";
    }
    
}