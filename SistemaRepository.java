import java.util.ArrayList;

public class SistemaRepository {

    private ArrayList<Estudante> estudantes = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public void salvarEstudante(Estudante e) {
        estudantes.add(e);
    }

    public void salvarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public Estudante buscarEstudante(int id) {

        for (Estudante e : estudantes) {

            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

    public Disciplina buscarDisciplina(int id) {

        for (Disciplina d : disciplinas) {

            if (d.getId() == id) {
                return d;
            }
        }

        return null;
    }

    public ArrayList<Estudante> listarEstudantes() {
        return estudantes;
    }

    public ArrayList<Disciplina> listarDisciplinas() {
        return disciplinas;
    }
}
