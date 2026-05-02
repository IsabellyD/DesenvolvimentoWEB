public class SistemaService {

    private SistemaRepository repo;

    public SistemaService() {
        repo = new SistemaRepository();
    }

    public void cadastrarEstudante(Estudante e) {
        repo.salvarEstudante(e);
    }

    public void cadastrarDisciplina(Disciplina d) {
        repo.salvarDisciplina(d);
    }

    public void editarEstudante(int id, String nome, int idade, String matricula) {
        Estudante e = repo.buscarEstudante(id);
        if (e != null) {
            e.setNome(nome);
            e.setIdade(idade);
            e.setMatricula(matricula);
            System.out.println("Estudante editado!");
        } else {
            System.out.println("Estudante não encontrado!");
        }
    }

    public void editarDisciplina(int id, String nome, String professor, int carga) {
        Disciplina d = repo.buscarDisciplina(id);
        if (d != null) {
            d.setNome(nome);
            d.setProfessor(professor);
            d.setCargaHoraria(carga);
            System.out.println("Disciplina editada!");
        } else {
            System.out.println("Disciplina não encontrada!");
        }
    }

    public void inserir(int idEst, int idDisc) {
        Estudante e = repo.buscarEstudante(idEst);
        Disciplina d = repo.buscarDisciplina(idDisc);

        if (e != null && d != null) {
            e.adicionarDisciplina(d);
            d.adicionarEstudante(e);
            System.out.println("Relacionamento feito!");
        } else {
            System.out.println("Estudante ou disciplina não encontrado!");
        }
    }

    public void listarTudo() {
        System.out.println("\nDISCIPLINAS:");
        for (Disciplina d : repo.listarDisciplinas()) {
            System.out.println(d);
            for (Estudante e : d.getEstudantes()) {
                System.out.println(" - " + e.getNome());
            }
        }

        System.out.println("\nESTUDANTES:");
        for (Estudante e : repo.listarEstudantes()) {
            System.out.println(e);
            for (Disciplina d : e.getDisciplinas()) {
                System.out.println(" - " + d.getNome());
            }
        }
    }

    public void listarEstudantesSimples() {
        if (repo.listarEstudantes().isEmpty()) {
            System.out.println("Nenhum estudante cadastrado!");
            return;
        }

        for (Estudante e : repo.listarEstudantes()) {
            System.out.println("ID: " + e.getId() + " | Nome: " + e.getNome());
        }
    }

    public void listarDisciplinasSimples() {
        if (repo.listarDisciplinas().isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada!");
            return;
        }

        for (Disciplina d : repo.listarDisciplinas()) {
            System.out.println("ID: " + d.getId() + " | Nome: " + d.getNome());
        }
    }
}