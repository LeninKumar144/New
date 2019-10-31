package Sample;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
public class Sendmail {
 
	public static void main(String[] args) {
 
		// Create object of Property file
		// this will set host of server- you can change based on your requirement 
		// set the port of socket factory 
		// set socket factory
		// set the authentication to true
		// set the port of SMTP server
		// This will handle the complete authentication
		// Create object of MimeMessage class
		// Set the from address
		// Set the recipient address
		 // Add the subject link
		// Create object to add multimedia type content
		// Set the body of email
		// Create another object to add another content
		// Mention the file which you want to send
		// Create data source and pass the filename
		// set the handler
		// set the file
		// Create object of MimeMultipart class
		// add body part 1
		// add body part 2
		// set the content
		// finally send the email
		
		
		
		email();
 
	}

	/**
	 * 
	 */
	public static void email() {
		Properties props = new Properties();
 
		
		props.put("mail.smtp.host", "smtp.gmail.com");
 
		
		props.put("mail.smtp.socketFactory.port", "465");
 
		
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
 
		
		props.put("mail.smtp.auth", "true");
 
		
		props.put("mail.smtp.port", "465");
 
		
		Session session = Session.getDefaultInstance(props,
 
				new javax.mail.Authenticator() {
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication("seleniumtest144@gmail.com", "Selenium@123");
 
					}
 
				});
 
		try {
 
			
			Message message = new MimeMessage(session);
 
			
			message.setFrom(new InternetAddress("seleniumtest144@gmail.com"));
 
			
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("sreekanthr@idiq.com"));
            
                       
			message.setSubject("Testing Subject");
 
			
			BodyPart messageBodyPart1 = new MimeBodyPart();

			messageBodyPart1.setText("Report");
 
		
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
 
			
			String filename = "C:\\Users\\lenin.a\\workspace\\IDIQProject\\test-output\\emailable-report.html";
 
			
			DataSource source = new FileDataSource(filename);
 
			
			messageBodyPart2.setDataHandler(new DataHandler(source));
 
			
			messageBodyPart2.setFileName(filename);
 
			
			Multipart multipart = new MimeMultipart();
 
			
			multipart.addBodyPart(messageBodyPart2);
 
			
			multipart.addBodyPart(messageBodyPart1);
 
			
			message.setContent(multipart);
 
			
			Transport.send(message);
 
			System.out.println("=====Email Sent=====");
 
		} catch (MessagingException e) {
 
			throw new RuntimeException(e);
 
		}
	}
 
}

