package com.techelevator.dao;

public interface EmailService {
    public void sendSimpleMessage(String to, String subject, String text);
}
