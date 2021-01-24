package vn.funix.prj321x.project5.bll.service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public interface MailService {

    public boolean isLoggedIn(
            String username,
            String password) throws MessagingException;

    public Message[] getMessages(String username,
            String password) throws MessagingException;

    public MimeMessage createEmailMessage(
            String emailTo,
            String emailCC,
            String emailSubject,
            String emailMessage)
            throws MessagingException;

    public void sendEmail(
            String username,
            String password,
            MimeMessage emailMessage)
            throws MessagingException;

}