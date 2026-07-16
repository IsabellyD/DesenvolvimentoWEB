package br.edu.ifpb.isabelly.projetoweb.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.isabelly.projetoweb.business.dto.DisciplinaDTO;
import br.edu.ifpb.isabelly.projetoweb.model.entity.Disciplina;
import br.edu.ifpb.isabelly.projetoweb.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	private final DisciplinaRepository repo;

	@Autowired
	public DisciplinaService(DisciplinaRepository repo) {
		super();
		this.repo = repo;
	}

	public void cadastrar(DisciplinaDTO dto) {

		Disciplina disciplina = new Disciplina(dto.getNome(), dto.getProfessor(), dto.getCargaHoraria());

		repo.save(disciplina);
	}

	public void editar(Long id, DisciplinaDTO dto) {

		Disciplina disciplina = repo.findById(id).orElse(null);

		if (disciplina != null) {
			disciplina.setNome(dto.getNome());
			disciplina.setProfessor(dto.getProfessor());
			disciplina.setCargaHoraria(dto.getCargaHoraria());
			repo.save(disciplina);
		}
	}

	public Disciplina buscar(Long id) {
		return repo.findById(id).orElse(null);
	}

	public void listar(PrinterService printer) {

		for (Disciplina disciplina : repo.findAll()) {

			DisciplinaDTO dto = new DisciplinaDTO(disciplina.getId(), disciplina.getNome(), disciplina.getProfessor(),
					disciplina.getCargaHoraria());

			printer.print(dto.toString());

			if (disciplina.getEstudantes() != null) {
				disciplina.getEstudantes().forEach(estudante -> printer.print(" - Estudante: " + estudante.getNome()));
			}
		}
	}

	public void listarSimples(PrinterService printer) {
		for (Disciplina disciplina : repo.findAll()) {
			printer.print("ID: " + disciplina.getId() + " | Nome: " + disciplina.getNome());
		}
	}
}
