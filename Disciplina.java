package br.edu.ifpb.isabelly.projetoweb.model.entity;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String professor;
	private int cargaHoraria;
	private ArrayList<Estudante> estudantes = new ArrayList<>();
	public Disciplina() {
	}
	public Disciplina(String nome, String professor, int cargaHoraria) {
		this.nome = nome;
		this.professor = professor;
		this.cargaHoraria = cargaHoraria;
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
	public ArrayList<Estudante> getEstudantes() {
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
	public void adicionarEstudante(Estudante e) {
		if (!estudantes.contains(e)) {
			estudantes.add(e);
		}
	}
}
