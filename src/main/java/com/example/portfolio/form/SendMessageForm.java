package com.example.portfolio.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SendMessageForm {

    @NotNull(message = "Please enter your name below.")
    private String SenderName;

    @NotNull(message = "Please enter your contact email address.")
    @Email(message = "Please enter a valid email address (e.g.,  yourname@example.com).")
    private String SenderMailAddress;

    @NotNull(message = "Type your message here.")
    private String MainMessage;

}