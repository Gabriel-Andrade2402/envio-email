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
public class FromModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String password;

}
