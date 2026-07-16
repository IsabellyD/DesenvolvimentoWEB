package br.edu.ifpb.isabelly.projetoweb.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifpb.isabelly.projetoweb.business.dto.EstudanteDTO;
import br.edu.ifpb.isabelly.projetoweb.model.entity.Estudante;
import br.edu.ifpb.isabelly.projetoweb.repository.EstudanteRepository;

@Service
public class EstudanteService {
	private final EstudanteRepository repo;
	
	@Autowired
	public EstudanteService(EstudanteRepository repo) {
		super();
		this.repo = repo;
	}

	public void cadastrar(EstudanteDTO dto) {
		Estudante estudante = new Estudante(dto.getNome(), dto.getIdade(), dto.getMatricula());
		repo.save(estudante);
	}

	public void editar(Long id, EstudanteDTO dto) {
		Estudante estudante = repo.findById(id).orElse(null);

		if (estudante != null) {
			estudante.setNome(dto.getNome());
			estudante.setIdade(dto.getIdade());
			estudante.setMatricula(dto.getMatricula());
			repo.save(estudante);
		}
	}

	public Estudante buscar(Long id) {
		return repo.findById(id).orElse(null);
	}

	public void listar(PrinterService printer) {

		for (Estudante estudante : repo.findAll()) {

			EstudanteDTO dto = new EstudanteDTO(estudante.getId(), estudante.getNome(), estudante.getIdade(),
					estudante.getMatricula());

			printer.print(dto.toString());

			if (estudante.getDisciplinas() != null) {
				estudante.getDisciplinas()
						.forEach(disciplina -> printer.print(" - Disciplina: " + disciplina.getNome()));
			}
		}
	}

	public void listarSimples(PrinterService printer) {
		for (Estudante estudante : repo.findAll()) {
			printer.print("ID: " + estudante.getId() + " | Nome: " + estudante.getNome());
		}
	}
}
