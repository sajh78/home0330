package com.example.demo.controller;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SmtpComponent {

	@Bean 
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl r = new JavaMailSenderImpl();
		r.setHost("smtp.naver.com");
		r.setPort(587);
		r.setUsername("");
		r.setPassword("");
		r.setDefaultEncoding("UTF-8");
		
		Properties prop = new Properties();
		prop.put("mail.smtp.starttl.enable", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.checkserveridenty", true);
		prop.put("mail.smtp.ssl.trust", "*");
		r.setJavaMailProperties(prop);
		return r;
	}
}
