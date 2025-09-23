package com.example.portfolio.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SendMessageForm {

    @NotBlank(message = "Please enter your name below.")
    private String senderName;

    @NotBlank(message = "Please enter your contact email address.")
    @Email(message = "Please enter a valid email address (e.g.,  yourname@example.com).")
    private String senderMailAddress;

    @NotBlank(message = "Type your message here.")
    private String mainMessage;

}