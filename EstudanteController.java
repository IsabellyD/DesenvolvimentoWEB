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

import br.edu.ifpb.isabelly.projetoweb.business.dto.EstudanteDTO;
import br.edu.ifpb.isabelly.projetoweb.business.service.EstudanteService;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private final EstudanteService service;

    public EstudanteController(EstudanteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EstudanteDTO> cadastrar(
            @RequestBody EstudanteDTO dto) {

        EstudanteDTO estudante = service.cadastrar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(estudante);
    }

    @GetMapping
    public ResponseEntity<List<EstudanteDTO>> listar(
            @RequestParam(required = false) String nome) {

        return ResponseEntity.ok(service.listar(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteDTO> buscar(
            @PathVariable Long id) {

        EstudanteDTO estudante = service.buscar(id);

        if (estudante == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estudante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudanteDTO> editar(
            @PathVariable Long id,
            @RequestBody EstudanteDTO dto) {

        EstudanteDTO estudante = service.editar(id, dto);

        if (estudante == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estudante);
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
