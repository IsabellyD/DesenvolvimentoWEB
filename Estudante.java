public class Estudante {
    private int id;
    private String nome;
    private int idade;
    private String matricula;
    private String curso;

    public Estudante(int id, String nome, int idade, String matricula, String curso) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Idade: " + idade +
               " | Matrícula: " + matricula + " | Curso: " + curso;
    }
}