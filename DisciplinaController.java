package br.edu.ifpb.isabelly.projetoweb.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.edu.ifpb.isabelly.projetoweb.business.dto.DisciplinaDTO;
import br.edu.ifpb.isabelly.projetoweb.business.service.DisciplinaService;
import br.edu.ifpb.isabelly.projetoweb.business.service.PrinterService;

@Controller
public class DisciplinaController {
	private final DisciplinaService service;

	@Autowired
	public DisciplinaController(DisciplinaService service) {
		super();
		this.service = service;
	}

	public void cadastrar(DisciplinaDTO dto) {
		service.cadastrar(dto);
	}

	public void editar(Long id, DisciplinaDTO dto) {
		service.editar(id, dto);
	}

	public void listar(PrinterService printer) {
		service.listar(printer);
	}

	public void listarSimples(PrinterService printer) {
		service.listarSimples(printer);
	}
}
