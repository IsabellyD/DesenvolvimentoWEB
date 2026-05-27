public class EstudanteService {

    private EstudanteRepository repo;

    public EstudanteService(EstudanteRepository repo) {

        this.repo = repo;
    }

    public void cadastrar(
            EstudanteDTO dto) {

        Estudante e = new Estudante(
                dto.getId(),
                dto.getNome(),
                dto.getIdade(),
                dto.getMatricula()
        );

        repo.salvar(e);
    }

    public void editar(
            int id,
            EstudanteDTO dto) {

        Estudante e = repo.buscar(id);

        if (e != null) {

            e.setNome(dto.getNome());
            e.setIdade(dto.getIdade());
            e.setMatricula(dto.getMatricula());
        }
    }

    public Estudante buscar(int id) {

        return repo.buscar(id);
    }

    public void listar(
            PrinterService printer) {

        for (Estudante e : repo.listar()) {

            EstudanteDTO dto =
                    new EstudanteDTO(
                            e.getId(),
                            e.getNome(),
                            e.getIdade(),
                            e.getMatricula()
                    );

            printer.print(dto.toString());

            for (Disciplina d :
                    e.getDisciplinas()) {

                printer.print(" - " + d.getNome()
                );
            }
        }
    }

    public void listarSimples(
            PrinterService printer) {

        for (Estudante e : repo.listar()) {

            printer.print("ID: " + e.getId() + " | Nome: " + e.getNome()
            );
        }
    }
}