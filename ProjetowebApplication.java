package br.edu.ifpb.isabelly.projetoweb;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import br.edu.ifpb.isabelly.projetoweb.business.dto.DisciplinaDTO;
import br.edu.ifpb.isabelly.projetoweb.business.dto.EstudanteDTO;
import br.edu.ifpb.isabelly.projetoweb.business.service.PrinterService;
import br.edu.ifpb.isabelly.projetoweb.model.entity.Disciplina;
import br.edu.ifpb.isabelly.projetoweb.model.entity.Estudante;
import br.edu.ifpb.isabelly.projetoweb.repository.DisciplinaRepository;
import br.edu.ifpb.isabelly.projetoweb.repository.EstudanteRepository;
import br.edu.ifpb.isabelly.projetoweb.presentation.controller.DisciplinaController;
import br.edu.ifpb.isabelly.projetoweb.presentation.controller.EstudanteController;

@SpringBootApplication
public class ProjetowebApplication implements CommandLineRunner {
	private final DisciplinaController disciplinaController;
	private final EstudanteController estudanteController;
	private final PrinterService printer;
	private final DisciplinaRepository disciplinaRepository;
	private final EstudanteRepository estudanteRepository;
	
	@Autowired
	public ProjetowebApplication(DisciplinaController disciplinaController, EstudanteController estudanteController,
			PrinterService printer, DisciplinaRepository disciplinaRepository,
			EstudanteRepository estudanteRepository) {

		super();
		this.disciplinaController = disciplinaController;
		this.estudanteController = estudanteController;
		this.printer = printer;
		this.disciplinaRepository = disciplinaRepository;
		this.estudanteRepository = estudanteRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetowebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int op;

		do {

			printer.print("\n===== MENU =====" + "\n1 - Cadastrar Disciplina" + "\n2 - Cadastrar Estudante"
					+ "\n3 - Relacionar Estudante e Disciplina" + "\n4 - Listar Dados" + "\n5 - Editar Disciplina"
					+ "\n6 - Editar Estudante" + "\n7 - Sair");

			op = sc.nextInt();

			switch (op) {

			case 1:

				sc.nextLine();

				printer.print("Nome da disciplina:");
				String nome = sc.nextLine();
				printer.print("Professor:");
				String professor = sc.nextLine();
				printer.print("Carga horária:");
				int carga = sc.nextInt();

				DisciplinaDTO disciplina = new DisciplinaDTO(null, nome, professor, carga);

				disciplinaController.cadastrar(disciplina);

				printer.print("Disciplina cadastrada!");

				break;

			case 2:

				sc.nextLine();

				printer.print("Nome:");
				String nomeE = sc.nextLine();
				printer.print("Idade:");
				int idade = sc.nextInt();
				sc.nextLine();
				printer.print("Matrícula:");
				String matricula = sc.nextLine();

				EstudanteDTO estudante = new EstudanteDTO(null, nomeE, idade, matricula);

				estudanteController.cadastrar(estudante);

				printer.print("Estudante cadastrado!");

				break;

			case 3:

				estudanteController.listarSimples(printer);
				printer.print("ID do estudante:");
				Long idEstudante = sc.nextLong();
				disciplinaController.listarSimples(printer);
				printer.print("ID da disciplina:");
				Long idDisciplina = sc.nextLong();

				Estudante estudanteEncontrado = estudanteRepository.findById(idEstudante).orElse(null);
				Disciplina disciplinaEncontrada = disciplinaRepository.findById(idDisciplina).orElse(null);

				if (estudanteEncontrado != null && disciplinaEncontrada != null) {

					estudanteEncontrado.adicionarDisciplina(disciplinaEncontrada);
					disciplinaEncontrada.adicionarEstudante(estudanteEncontrado);

					estudanteRepository.save(estudanteEncontrado);
					disciplinaRepository.save(disciplinaEncontrada);

					printer.print("Relacionamento realizado!");

				} else {

					printer.print("Dados não encontrados!");
				}

				break;

			case 4:

				printer.print("\n===== DISCIPLINAS =====");
				disciplinaController.listar(printer);
				printer.print("\n===== ESTUDANTES =====");
				estudanteController.listar(printer);

				break;

			case 5:

				disciplinaController.listarSimples(printer);
				printer.print("ID da disciplina:");
				Long idD = sc.nextLong();
				sc.nextLine();
				printer.print("Novo nome:");
				String novoNome = sc.nextLine();
				printer.print("Novo professor:");
				String novoProfessor = sc.nextLine();
				printer.print("Nova carga horária:");
				int novaCarga = sc.nextInt();

				DisciplinaDTO novaDisciplina = new DisciplinaDTO(idD, novoNome, novoProfessor, novaCarga);

				disciplinaController.editar(idD, novaDisciplina);

				printer.print("Disciplina editada!");

				break;

			case 6:

				estudanteController.listarSimples(printer);

				printer.print("ID do estudante:");
				Long idE = sc.nextLong();
				sc.nextLine();
				printer.print("Novo nome:");
				String novoNomeE = sc.nextLine();
				printer.print("Nova idade:");
				int novaIdade = sc.nextInt();
				sc.nextLine();
				printer.print("Nova matrícula:");
				String novaMatricula = sc.nextLine();

				EstudanteDTO novoEstudante = new EstudanteDTO(idE, novoNomeE, novaIdade, novaMatricula);

				estudanteController.editar(idE, novoEstudante);

				printer.print("Estudante editado!");

				break;

			case 7:

				printer.print("Sistema encerrado!");

				break;

			default:

				printer.print("Opção inválida!");
			}

		} while (op != 7);

		sc.close();
	}
}
