package br.com.emails.envio.service.email;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emails.envio.service.email.factory.MessageMailFactory;
import br.com.emails.envio.service.email.factory.PropertiesFactory;
import br.com.emails.envio.service.email.factory.SessionMailFactory;
import br.com.emails.envio.service.email.pojo.SenderMailDTO;
import br.com.emails.envio.service.email.pojo.TypeMailMessage;

@Service
public class MailSenderService {
	private Logger log = Logger.getLogger("PropertiesFactory");
	@Autowired
	private MessageMailFactory messageFac;
	
	@Autowired
	private PropertiesFactory propsFac;
	
	@Autowired
	private SessionMailFactory sessionFac;
	
	public void sendMessage(SenderMailDTO dto) { 
		Properties props = this.castingProperties(dto.getFrom().getUsername());
		Session session = sessionFac.factorySessionSimpleAuth(props,dto.getFrom().getUsername(), dto.getFrom().getPassword());
		Message message = messageFac.factoryMessage(dto.getFrom().getUsername(), session);
		try {
			message.setSubject(dto.getMail().getSubject());
			if(dto.getMail().getMessage().getType() == TypeMailMessage.TEXT) {
				message.setText(dto.getMail().getMessage().getMessage());
			}else if(dto.getMail().getMessage().getType() == TypeMailMessage.HTML){
				MimeBodyPart messageBodyPart = new MimeBodyPart();
				Multipart multp = new MimeMultipart();
				multp.addBodyPart(messageBodyPart);
				messageBodyPart.setContent(dto.getMail().getMessage().getMessage(), "text/html; charset=utf-8");
				message.setContent(multp,"text/html; charset=utf-8");
			}
			for(String user :dto.getTo().getUsers()) {
				message.addRecipient(RecipientType.TO, new InternetAddress(user));
			}
			Transport.send(message);			
		}catch(Exception e) {
			log.log(Level.WARNING,"Erro Durante tentativa de envio de mensagem");
			e.printStackTrace();
		}
	}
	/**
	 * Método utilitario para diferencias e ininicar o smpt host corretamente com base no email
	 * Para os e-mails não identificados é utilizado o host zoho.
	 * **/
	public Properties castingProperties(String username) {
		if(username.split("@")[1].split("[.]")[0].equals("gmail")) {
			return propsFac.factoryGmail(true, true, true);
		}else if(username.split("@")[1].split("[.]")[0].equals("outlook") || username.split("@")[1].split("[.]")[0].equals("hotmail")) {
			return propsFac.factoryMicrosoftOffice365(true, true, true);
		}else {
			return propsFac.factoryZoho(true, true, true);
		}
	}
}
