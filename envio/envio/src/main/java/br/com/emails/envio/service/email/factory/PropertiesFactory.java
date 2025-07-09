package br.com.emails.envio.service.email.factory;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertiesFactory {
	private Logger log = Logger.getLogger("PropertiesFactory");
	@Autowired
	private Environment envs;
	
	
	public Properties factoryGmail(Boolean isBasicAuth,Boolean isTls, Boolean isSsl) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", envs.getProperty("msmail.properties.gmail.smtp.host"));
			props.put("mail.smtp.port", envs.getProperty("msmail.properties.gmail.smtp.port"));
			if(isBasicAuth) {
				props.put("mail.smtp.auth", "true");
			}
			if(isTls) {
				props.put("mail.smtp.starttls.enable", "true");
			}
			if(isSsl) {
				props.put("mail.smtp.socketFactory.port", "587");
				props.put("mail.smtp.socketFactory.fallback", "false");
			}
			return props;
		}catch(Exception e) {
			e.printStackTrace();
			log.log(Level.WARNING,"Erro Durante a fabricação do Properties");
			return null;
		}
	}
	
	public Properties factoryMicrosoftOffice365(Boolean isBasicAuth,Boolean isTls, Boolean isSsl) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", envs.getProperty("msmail.properties.microsoft.smtp.host"));
			props.put("mail.smtp.port", envs.getProperty("msmail.properties.microsoft.smtp.port"));
			if(isBasicAuth) {
				props.put("mail.smtp.auth", "true");
			}
			if(isTls) {
				props.put("mail.smtp.starttls.enable", "true");
			}
			if(isSsl) {
				props.put("mail.smtp.socketFactory.port", "587");
				props.put("mail.smtp.socketFactory.fallback", "false");
			}
			return props;
		}catch(Exception e) {
			e.printStackTrace();
			log.log(Level.WARNING,"Erro Durante a fabricação do Properties");
			return null;
		}
	}
	
	public Properties factoryZoho(Boolean isBasicAuth,Boolean isTls, Boolean isSsl) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", envs.getProperty("msmail.properties.zoho.smtp.host"));
			props.put("mail.smtp.port", envs.getProperty("msmail.properties.zoho.smtp.port"));
			if(isBasicAuth) {
				props.put("mail.smtp.auth", "true");
			}
			if(isTls) {
				props.put("mail.smtp.starttls.enable", "true");
			}
			if(isSsl) {
				props.put("mail.smtp.socketFactory.port", "587");
				props.put("mail.smtp.socketFactory.fallback", "false");
			}
			return props;
		}catch(Exception e) {
			e.printStackTrace();
			log.log(Level.WARNING,"Erro Durante a fabricação do Properties");
			return null;
		}
	}
}
