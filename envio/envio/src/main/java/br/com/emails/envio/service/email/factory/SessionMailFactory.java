package br.com.emails.envio.service.email.factory;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.stereotype.Component;


@Component
public class SessionMailFactory {
	private Logger log = Logger.getLogger("SessionMailFactory");
	
	public Session factorySessionSimpleAuth(Properties props,final String username,final String password) {
		try {			
			Session session = Session.getInstance(props,
					new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			return session;
		}catch(Exception e) {
			e.printStackTrace();
			log.log(Level.WARNING,"Erro Durante a fabricação da Sessão com autenticação Basica");
			return null;
		}
	}
	
}
