public class DisciplinaDTO {

    private int id;
    private String nome;
    private String professor;
    private int cargaHoraria;

    public DisciplinaDTO(int id, String nome, String professor, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
    }

    public int getId() {
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

    @Override
    public String toString() {

        return "ID: " + id + " | Disciplina: " + nome + " | Professor: " + professor + " | Carga Horária: " + cargaHoraria + "h";
    }
}