package br.edu.ifpb.isabelly.projetoweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.isabelly.projetoweb.model.entity.Disciplina;

public interface DisciplinaRepository
		extends JpaRepository<Disciplina, Long> {

	List<Disciplina> findByNome(String nome);
}
