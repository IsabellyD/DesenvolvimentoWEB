package br.edu.ifpb.isabelly.projetoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ifpb.isabelly.projetoweb.model.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
	Estudante findByNome(String nome);
}
