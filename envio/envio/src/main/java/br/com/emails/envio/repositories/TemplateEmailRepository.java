package br.com.emails.envio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.emails.envio.entities.TemplateEmailEntity;

@Repository
public interface TemplateEmailRepository extends JpaRepository<TemplateEmailEntity, Long>{

}
