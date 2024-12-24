package com.cradletechnologies.transportation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendOtpMessage(String to, String subject, String message) throws MessagingException {
		MimeMessage msg = javaMailSender.createMimeMessage();		
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(message, true);
		javaMailSender.send(msg);
	}

	@Override
	public void sendCashPaidMessage(String to, String subject, String message) throws MessagingException {
		MimeMessage msg = javaMailSender.createMimeMessage();		
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(message, true);
		javaMailSender.send(msg);		
	}

	@Override
	public void sendPupilBillingMessage(String to, String subject, String message) throws MessagingException {
		MimeMessage msg = javaMailSender.createMimeMessage();		
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(message, true);
		javaMailSender.send(msg);		
	}

}
