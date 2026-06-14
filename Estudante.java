package br.edu.ifpb.isabelly.projetoweb.model.entity;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private int idade;
	private String matricula;
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();
	public Estudante() {
	}
	public Estudante(String nome, int idade, String matricula) {
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
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
	public ArrayList<Disciplina> getDisciplinas() {
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
	public void adicionarDisciplina(Disciplina d) {
		if (!disciplinas.contains(d)) {
			disciplinas.add(d);
		}
	}
}
