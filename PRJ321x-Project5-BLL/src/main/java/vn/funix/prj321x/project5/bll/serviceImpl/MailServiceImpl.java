package vn.funix.prj321x.project5.bll.serviceImpl;

import java.util.Objects;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import vn.funix.prj321x.project5.bll.service.MailService;

public class MailServiceImpl implements MailService {

	private static final String PROTOCAL_INCOMING  = "imaps";
	private static final String PROTOCAL_OUTCOMING = "smtp";
	private static final String HOST_INCOMING      = "imap.gmail.com";
	private static final String HOST_OUTCOMING     = "smtp.gmail.com";

	private Session mailSession = null;

	public MailServiceImpl() {

		if (mailSession == null) {

			Properties props = new Properties();

			// Config for outgoingMailServer
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			// Config for incomingMailServer
			props.put("mail.store.protocol", "imaps");
			props.put("mail.imaps.port", "993");
			props.put("mail.imaps.starttls.enable", "true");

			mailSession = Session.getInstance(props, null);
		}
	}

	public boolean isLoggedIn(String username, String password)
			throws MessagingException {

		Store     store     = mailSession.getStore(PROTOCAL_INCOMING);
		Transport transport = mailSession.getTransport(PROTOCAL_OUTCOMING);

		store.connect(HOST_INCOMING, username, password);
		transport.connect(HOST_OUTCOMING, username, password);

		return store.isConnected() 
				&& transport.isConnected();
	}

	public Message[] getMessages(String username, String password)
			throws MessagingException {

		// Connect to the server
		Store store = mailSession.getStore(PROTOCAL_INCOMING);
		store.connect(HOST_INCOMING, username, password);

		// open the inbox folder
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		// get a list of javamail messages as an array of messages
		Message[] messages = inbox.getMessages();

		return messages;
	}

	public Message[] getMessages(
			String username,
			String password,
			int start,
			int end) throws MessagingException {

		// Connect to the server
		Store store = mailSession.getStore(PROTOCAL_INCOMING);
		store.connect(HOST_INCOMING, username, password);

		// open the inbox folder
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		Message[] messages = inbox.getMessages(start, end);

		return messages;
	}

	public Message getMessage(
			String username,
			String password,
			int msgnum)
			throws MessagingException {

		Store store = mailSession.getStore(PROTOCAL_INCOMING);
		store.connect(HOST_INCOMING, username, password);

		// open the inbox folder
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		return inbox.getMessage(msgnum);
	}

	public int getCountMessage(String username, String password)
			throws MessagingException {

		Store store = mailSession.getStore(PROTOCAL_INCOMING);
		store.connect(HOST_INCOMING, username, password);

		// open the inbox folder
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		return inbox.getMessageCount();
	}

	public MimeMessage createEmailMessage(
			String emailTo,
			String emailCC,
			String emailSubject,
			String emailContent)
			throws MessagingException {

		MimeMessage emailMessage = new MimeMessage(mailSession);

		emailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(emailTo));

		if (Objects.nonNull(emailCC) 
				&& !emailCC.isEmpty()) {
			
			emailMessage.addRecipient(
					Message.RecipientType.CC,
					new InternetAddress(emailCC));
		}

		emailMessage.setSubject(emailSubject, "text/html; charset=utf-8");
		emailMessage.setContent(emailContent, "text/html; charset=utf-8");
		
		return emailMessage;
	}

	public void sendEmail(
			String username,
			String password,
			MimeMessage emailMessage)
			throws MessagingException {

		Transport transport = mailSession.getTransport(PROTOCAL_OUTCOMING);

		transport.connect(HOST_OUTCOMING, username, password);

		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();

	}

}
