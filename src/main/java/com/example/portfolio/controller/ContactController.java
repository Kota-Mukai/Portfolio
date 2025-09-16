package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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
    public String showContactPage() {
        return "contact";
    }

    @PostMapping("/confirm-contact-message")
    public String confirmContactMessage(@ModelAttribute
                        SendMessageForm form, Model model) {

        model.addAttribute("sendMessageForm", form);

        return "confirm-contact-message";
    }

    @PostMapping("/complete")
    public String sendContactMessage(SendMessageForm form,
                    RedirectAttributes redirectAttributes) {
        
        service.send(form);

        redirectAttributes.addFlashAttribute("msg", "Thank you for contacting me.I'll respond after reveiwing it.");
        
        return "redirect:/complete";
    }
    
}