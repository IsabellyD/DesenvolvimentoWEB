import java.util.ArrayList;

public class Estudante {
    private int id;
    private String nome;
    private int idade;
    private String matricula;
    private ArrayList<Disciplina> disciplinas;

    public Estudante(int id, String nome, int idade, String matricula) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.disciplinas = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public ArrayList<Disciplina> getDisciplinas() { return disciplinas; }

    public void setNome(String nome) { this.nome = nome; }

    public void adicionarDisciplina(Disciplina d) {
        if (!disciplinas.contains(d)) {
            disciplinas.add(d);
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nome + " Idade: " + idade + " Matrícula: " + matricula;
    }
}
