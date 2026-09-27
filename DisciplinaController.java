package br.edu.ifpb.isabelly.projetoweb.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.isabelly.projetoweb.business.dto.DisciplinaDTO;
import br.edu.ifpb.isabelly.projetoweb.business.service.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DisciplinaDTO> cadastrar(
            @RequestBody DisciplinaDTO dto) {

        DisciplinaDTO disciplina = service.cadastrar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(disciplina);
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> listar(
            @RequestParam(required = false) String nome) {

        return ResponseEntity.ok(service.listar(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> buscar(
            @PathVariable Long id) {

        DisciplinaDTO disciplina = service.buscar(id);

        if (disciplina == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(disciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> editar(
            @PathVariable Long id,
            @RequestBody DisciplinaDTO dto) {

        DisciplinaDTO disciplina = service.editar(id, dto);

        if (disciplina == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {

        boolean excluiu = service.excluir(id);

        if (!excluiu) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
