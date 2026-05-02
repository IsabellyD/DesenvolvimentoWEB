import java.util.ArrayList;

public class Estudante {
    private int id;
    private String nome;
    private int idade;
    private String matricula;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Estudante(int id, String nome, int idade, String matricula) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getMatricula() { return matricula; }
    public ArrayList<Disciplina> getDisciplinas() { return disciplinas; }

    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public void adicionarDisciplina(Disciplina d) {
        if (!disciplinas.contains(d)) {
            disciplinas.add(d);
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Idade: " + idade + " | Matrícula: " + matricula;
    }
}