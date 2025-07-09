package br.com.emails.envio.service.email.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class MessageMailFactory {
	private Logger log = Logger.getLogger("MessageMailFactory");
	
	public Message factoryMessage(String username,Session session){
		try {			
			Message message = new MimeMessage(session);
			//message.addHeader("Content-type","text/HTML; charset=UTF-8");
			message.setFrom(new InternetAddress(username));
			return message;
		}catch (AddressException addrExcept) {
			addrExcept.printStackTrace();
			log.log(Level.WARNING,"Erro Durante a fabricação da mensagem, endereço formatado incorretamente");
			return null;
		}catch (MessagingException messExcept) {
			messExcept.printStackTrace();
			log.log(Level.WARNING,"Erro Durante a fabricação da Mensagem");
			return null;
		}
	}
	
	public Message factoryMessage(InternetAddress ip,Session session){
		try {			
			Message message = new MimeMessage(session);
			//message.addHeader("Content-type","text/HTML; charset=UTF-8");
			message.setFrom(ip);
			return message;
		}catch (AddressException addrExcept) {
			addrExcept.printStackTrace();
			log.log(Level.WARNING,"Erro Durante a fabricação da mensagem, endereço formatado incorretamente");
			return null;
		}catch (MessagingException messExcept) {
			messExcept.printStackTrace();
			log.log(Level.WARNING,"Erro Durante a fabricação da Mensagem");
			return null;
		}
	}
}
