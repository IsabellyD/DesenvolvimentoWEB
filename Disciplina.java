import java.util.ArrayList;

public class Disciplina {
    private int id;
    private String nome;
    private String professor;
    private int cargaHoraria;
    private ArrayList<Estudante> estudantes = new ArrayList<>();

    public Disciplina(int id, String nome, String professor, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.cargaHoraria = cargaHoraria;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getProfessor() { return professor; }
    public int getCargaHoraria() { return cargaHoraria; }
    public ArrayList<Estudante> getEstudantes() { return estudantes; }

    public void setNome(String nome) { this.nome = nome; }
    public void setProfessor(String professor) { this.professor = professor; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    public void adicionarEstudante(Estudante e) {
        if (!estudantes.contains(e)) {
            estudantes.add(e);
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Disciplina: " + nome + " | Professor: " + professor + " | Carga Horária: " + cargaHoraria + "h";
    }
}