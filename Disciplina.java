package br.edu.ifpb.isabelly.projetoweb.model.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String professor;
	private int cargaHoraria;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "disciplina_estudante", joinColumns = @JoinColumn(name = "disciplina_id"), inverseJoinColumns = @JoinColumn(name = "estudante_id"))
	private List<Estudante> estudantes;

	public Disciplina() {
		super();
		this.estudantes = new ArrayList<>();
	}

	public Disciplina(String nome, String professor, int cargaHoraria) {
		super();
		this.nome = nome;
		this.professor = professor;
		this.cargaHoraria = cargaHoraria;
		this.estudantes = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getProfessor() {
		return professor;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public List<Estudante> getEstudantes() {
		return estudantes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void adicionarEstudante(Estudante estudante) {
		if (!estudantes.contains(estudante)) {
			estudantes.add(estudante);
		}
	}
}
