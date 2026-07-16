package br.edu.ifpb.isabelly.projetoweb.business.dto;

public class DisciplinaDTO {

	private Long id;
	private String nome;
	private String professor;
	private int cargaHoraria;

	public DisciplinaDTO(Long id, String nome, String professor, int cargaHoraria) {
		super();
		this.id = id;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | Disciplina: " + nome + " | Professor: " + professor + " | Carga Horária: "
				+ cargaHoraria + "h";
	}
}
