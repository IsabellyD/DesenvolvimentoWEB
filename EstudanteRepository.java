package br.edu.ifpb.isabelly.projetoweb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpb.isabelly.projetoweb.model.entity.Estudante;
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}

