package ar.edu.unlam.tallerweb1.servicios;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class ServicioEmailImpl implements ServicioEmail {

	@Override
	public String enviarEmail(String to, String subject, String body) throws Exception {
		
		String from="cumelenlibreria@gmal.com";
		String pass="Cumelen2020";
		String ret="ok";
		Properties properties = new Properties();
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, pass);
                    }
                });

		try{
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
			message.setSubject(subject); 
			message.setText(body);
			Transport.send(message);
			
		}catch(MessagingException mex){
			ret=mex.getMessage();
		}

		return ret;
	}
}
