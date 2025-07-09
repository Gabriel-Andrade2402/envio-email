package br.com.emails.envio.service.email.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	List<String> users;
}
