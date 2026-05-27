import java.util.ArrayList;

public class EstudanteRepository {

    private ArrayList<Estudante> estudantes = new ArrayList<>();

    public void salvar(Estudante e) {

        estudantes.add(e);
    }

    public Estudante buscar(int id) {

        for (Estudante e : estudantes) {

            if (e.getId() == id) {
                return e;
            }
        }

        return null;
    }

    public ArrayList<Estudante> listar() {

        return estudantes;
    }
}