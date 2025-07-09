package br.com.emails.envio.service.email.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MailModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String subject;
	private MessageModel message;
}
