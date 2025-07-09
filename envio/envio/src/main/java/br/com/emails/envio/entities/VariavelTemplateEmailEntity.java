package br.com.emails.envio.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="VARIAVEL_TEMPLATE_EMAIL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VariavelTemplateEmailEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_VARIAVEL_TEMPLATE_EMAIL")
	private Long idVariavelTemplateEmail;
	
	@Column(name="ID_TEMPLATE_EMAIL")
	private Long idTemplateEmail;
	
	@Column(name="NM_TITULO_VARIAVEL")
	private String nmTituloVariavel;
	
	@Column(name="KEY_VARIAVEL")
	private String keyVariavel;
	
	@Column(name="DT_CRIACAO")
	private LocalDateTime dtCriacao;
}
