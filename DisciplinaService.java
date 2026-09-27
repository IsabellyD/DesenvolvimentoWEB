package br.edu.ifpb.isabelly.projetoweb.business.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.edu.ifpb.isabelly.projetoweb.business.dto.DisciplinaDTO;
import br.edu.ifpb.isabelly.projetoweb.model.entity.Disciplina;
import br.edu.ifpb.isabelly.projetoweb.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public DisciplinaDTO cadastrar(DisciplinaDTO dto) {

        Disciplina disciplina = new Disciplina(
                dto.getNome(),
                dto.getProfessor(),
                dto.getCargaHoraria()
        );

        Disciplina salva = repository.save(disciplina);

        return converterParaDTO(salva);
    }

    public DisciplinaDTO buscar(Long id) {

        return repository.findById(id)
                .map(this::converterParaDTO)
                .orElse(null);
    }

    public List<DisciplinaDTO> listar(String nome) {

        List<Disciplina> disciplinas;

        if (nome != null && !nome.isBlank()) {
            disciplinas = repository.findByNome(nome);
        } else {
            disciplinas = repository.findAll();
        }

        return disciplinas.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public DisciplinaDTO editar(Long id, DisciplinaDTO dto) {

        Disciplina disciplina = repository.findById(id).orElse(null);

        if (disciplina == null) {
            return null;
        }

        disciplina.setNome(dto.getNome());
        disciplina.setProfessor(dto.getProfessor());
        disciplina.setCargaHoraria(dto.getCargaHoraria());

        Disciplina atualizada = repository.save(disciplina);

        return converterParaDTO(atualizada);
    }

    public boolean excluir(Long id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }

    private DisciplinaDTO converterParaDTO(Disciplina disciplina) {

        return new DisciplinaDTO(
                disciplina.getId(),
                disciplina.getNome(),
                disciplina.getProfessor(),
                disciplina.getCargaHoraria()
        );
    }
}
