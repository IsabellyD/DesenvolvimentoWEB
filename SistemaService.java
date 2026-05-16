public class SistemaService {

    private SistemaRepository repo;
    private PrinterService printer;

    public SistemaService() {

        repo = new SistemaRepository();
        printer = new PrinterService();
    }

    public void cadastrarEstudante(Estudante e) {

        repo.salvarEstudante(e);

        printer.print("Estudante cadastrado!");
    }

    public void cadastrarDisciplina(Disciplina d) {

        repo.salvarDisciplina(d);

        printer.print("Disciplina cadastrada!");
    }

    public void editarEstudante(int id, String nome, int idade, String matricula) {

        Estudante e = repo.buscarEstudante(id);

        if (e != null) {

            e.setNome(nome);
            e.setIdade(idade);
            e.setMatricula(matricula);

            printer.print("Estudante editado!");

        } else {

            printer.print("Estudante não encontrado!");
        }
    }

    public void editarDisciplina(int id, String nome, String professor, int carga) {

        Disciplina d = repo.buscarDisciplina(id);

        if (d != null) {

            d.setNome(nome);
            d.setProfessor(professor);
            d.setCargaHoraria(carga);

            printer.print("Disciplina editada!");

        } else {

            printer.print("Disciplina não encontrada!");
        }
    }

    public void inserir(int idEst, int idDisc) {

        Estudante e = repo.buscarEstudante(idEst);
        Disciplina d = repo.buscarDisciplina(idDisc);

        if (e != null && d != null) {

            e.adicionarDisciplina(d);
            d.adicionarEstudante(e);

            printer.print("Relacionamento feito!");

        } else {

            printer.print("Estudante ou disciplina não encontrado!");
        }
    }

    public void listarTudo() {

        printer.print("\nDISCIPLINAS:");

        for (Disciplina d : repo.listarDisciplinas()) {

            printer.print(d.toString());

            for (Estudante e : d.getEstudantes()) {

                printer.print(" - " + e.getNome());
            }
        }

        printer.print("\nESTUDANTES:");

        for (Estudante e : repo.listarEstudantes()) {

            printer.print(e.toString());

            for (Disciplina d : e.getDisciplinas()) {

                printer.print(" - " + d.getNome());
            }
        }
    }

    public void listarEstudantesSimples() {

        if (repo.listarEstudantes().isEmpty()) {

            printer.print("Nenhum estudante cadastrado!");
            return;
        }

        for (Estudante e : repo.listarEstudantes()) {

            printer.print("ID: " + e.getId()
                    + " | Nome: " + e.getNome());
        }
    }

    public void listarDisciplinasSimples() {

        if (repo.listarDisciplinas().isEmpty()) {

            printer.print("Nenhuma disciplina cadastrada!");
            return;
        }

        for (Disciplina d : repo.listarDisciplinas()) {

            printer.print("ID: " + d.getId()
                    + " | Nome: " + d.getNome());
        }
    }
}
