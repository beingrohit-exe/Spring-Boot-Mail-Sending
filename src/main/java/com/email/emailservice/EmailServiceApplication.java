package com.email.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.emailservice.Service.GmailService;

@SpringBootApplication
@RestController
public class EmailServiceApplication {

	@Autowired
	private GmailService gmailService;

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

	@GetMapping("/mail")
	public String mail(){
		gmailService.send();
		return "Sent";
	}
}
