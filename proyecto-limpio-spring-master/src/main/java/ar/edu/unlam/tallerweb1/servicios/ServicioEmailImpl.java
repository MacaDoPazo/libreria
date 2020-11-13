package ar.edu.unlam.tallerweb1.servicios;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class ServicioEmailImpl implements ServicioEmail {

	@Override
	public String enviarEmail(String to, String subject, String body) throws Exception {
		
		String from="lala@gmail.com";
		String pass="lalala";
		String ret="ok";
		Properties properties=System.getProperties();
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		Session sesion = Session.getInstance(properties,new javax.mail.Authenticator(){
		protected PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(from,pass);
			}
		});
		Transport transport=null;
	  try {
		  MimeMessage msg = new MimeMessage(sesion);
		  transport = sesion.getTransport("smtp");

		  msg.setFrom(from);
		  msg.setRecipients(Message.RecipientType.TO, to);
		  msg.setSubject(subject);
		  msg.setSentDate(new java.util.Date());
		  msg.setText(body, "utf-8", "html");
		
		  

		    transport.connect();
		    msg.saveChanges();
		    transport.sendMessage(msg, msg.getAllRecipients());
    
	   }catch (MessagingException e) {
		   ret=e.getMessage();
		   transport.close();
	   }
	  	transport.close();
	  	return ret;
	}

}
