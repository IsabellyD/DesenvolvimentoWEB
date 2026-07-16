package br.edu.ifpb.isabelly.projetoweb.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.edu.ifpb.isabelly.projetoweb.business.dto.EstudanteDTO;
import br.edu.ifpb.isabelly.projetoweb.business.service.EstudanteService;
import br.edu.ifpb.isabelly.projetoweb.business.service.PrinterService;

@Controller
public class EstudanteController {
	private final EstudanteService service;

	@Autowired
	public EstudanteController(EstudanteService service) {
		super();
		this.service = service;
	}

	public void cadastrar(EstudanteDTO dto) {
		service.cadastrar(dto);
	}

	public void editar(Long id, EstudanteDTO dto) {
		service.editar(id, dto);
	}

	public void listar(PrinterService printer) {
		service.listar(printer);
	}

	public void listarSimples(PrinterService printer) {
		service.listarSimples(printer);
	}
}
