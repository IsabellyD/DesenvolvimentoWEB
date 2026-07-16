package br.edu.ifpb.isabelly.projetoweb.model.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private int idade;
	private String matricula;

	@ManyToMany(mappedBy = "estudantes", fetch = FetchType.EAGER)
	private List<Disciplina> disciplinas;

	public Estudante() {
		super();
		this.disciplinas = new ArrayList<>();
	}

	public Estudante(String nome, int idade, String matricula) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
		this.disciplinas = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getMatricula() {
		return matricula;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		if (!disciplinas.contains(disciplina)) {
			disciplinas.add(disciplina);
		}
	}
}
