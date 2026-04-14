import java.util.ArrayList;

public class Disciplina {
    private int id;
    private String nome;
    private String parofessor;
    private int cargaHoraria;
    private ArrayList<Estudante> estudantes;

    public Disciplina(int id, String nome, String professor, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
        this.estudantes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarEstudante(Estudante e) {
        estudantes.add(e);
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Disciplina: " + nome +
               " | Professor: " + professor +
               " | Carga Horária: " + cargaHoraria + "h";
    }
}