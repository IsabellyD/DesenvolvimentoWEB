package br.edu.ifpb.isabelly.projetoweb.business.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.edu.ifpb.isabelly.projetoweb.business.dto.EstudanteDTO;
import br.edu.ifpb.isabelly.projetoweb.model.entity.Estudante;
import br.edu.ifpb.isabelly.projetoweb.repository.EstudanteRepository;

@Service
public class EstudanteService {

    private final EstudanteRepository repository;

    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

    public EstudanteDTO cadastrar(EstudanteDTO dto) {

        Estudante estudante = new Estudante(
                dto.getNome(),
                dto.getIdade(),
                dto.getMatricula()
        );

        Estudante salvo = repository.save(estudante);

        return converterParaDTO(salvo);
    }

    public EstudanteDTO buscar(Long id) {

        return repository.findById(id)
                .map(this::converterParaDTO)
                .orElse(null);
    }

    public List<EstudanteDTO> listar(String nome) {

        List<Estudante> estudantes;

        if (nome != null && !nome.isBlank()) {
            estudantes = repository.findByNome(nome);
        } else {
            estudantes = repository.findAll();
        }

        return estudantes.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public EstudanteDTO editar(Long id, EstudanteDTO dto) {

        Estudante estudante = repository.findById(id).orElse(null);

        if (estudante == null) {
            return null;
        }

        estudante.setNome(dto.getNome());
        estudante.setIdade(dto.getIdade());
        estudante.setMatricula(dto.getMatricula());

        Estudante atualizado = repository.save(estudante);

        return converterParaDTO(atualizado);
    }

    public boolean excluir(Long id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }

    private EstudanteDTO converterParaDTO(Estudante estudante) {

        return new EstudanteDTO(
                estudante.getId(),
                estudante.getNome(),
                estudante.getIdade(),
                estudante.getMatricula()
        );
    }
}
