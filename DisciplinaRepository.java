import java.util.ArrayList;

public class DisciplinaRepository {

    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public void salvar(Disciplina d) {

        disciplinas.add(d);
    }

    public Disciplina buscar(int id) {

        for (Disciplina d : disciplinas) {

            if (d.getId() == id) {
                return d;
            }
        }

        return null;
    }

    public ArrayList<Disciplina> listar() {

        return disciplinas;
    }
}