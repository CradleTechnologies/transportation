package com.cradletechnologies.transportation.service;

import jakarta.mail.MessagingException;

public interface EmailService {

	void sendOtpMessage(String to, String subject, String message) throws MessagingException;

	void sendCashPaidMessage(String to, String subject, String message) throws MessagingException;

	void sendPupilBillingMessage(String to, String subject, String message) throws MessagingException;
}
