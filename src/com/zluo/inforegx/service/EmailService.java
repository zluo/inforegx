package com.zluo.inforegx.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService implements IService {

	@Override
	public void serve() {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = "Your infoRegx account send the test email";

		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("luozhanqing@gmail.com",
					"Example.com Admin"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"luozhanqing@gamil.com", "Mr. Master"));
			msg.setSubject("Your infoRegx account send the test email");
			msg.setText(msgBody);
			Transport.send(msg);
			
			System.out.println("email sended at " + new Date());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
