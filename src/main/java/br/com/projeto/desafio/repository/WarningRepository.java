package br.com.projeto.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.desafio.model.Warning;

@Repository
public interface WarningRepository extends JpaRepository<Warning, Long> {

}
