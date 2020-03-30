package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {

	@Autowired
	private MailSender javaMailSender;

	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@RequestMapping("/mail.do")
	public String mail() {
		String r = "";
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("회원가입 안내");
		mailMessage.setFrom("");
		mailMessage.setText("회원가입을 원하시면 로그인하세요");
		mailMessage.setTo("");
		try {
			javaMailSender.send(mailMessage);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return r;
	}
	
}
