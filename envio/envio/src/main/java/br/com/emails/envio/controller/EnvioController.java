package br.com.emails.envio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emails.envio.service.email.MailSenderService;
import br.com.emails.envio.service.email.pojo.SenderMailDTO;

@RestController
@RequestMapping(value="/")
public class EnvioController {
	
	@Autowired
	private MailSenderService service;
	
	@PostMapping(value="/simple")
	public ResponseEntity<Void> sendMessage(@RequestBody SenderMailDTO dto) {
		try {
			service.sendMessage(dto);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}
