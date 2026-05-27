public class DisciplinaService {

    private DisciplinaRepository repo;

    public DisciplinaService(DisciplinaRepository repo) {

        this.repo = repo;
    }

    public void cadastrar(
            DisciplinaDTO dto) {

        Disciplina d = new Disciplina(
                dto.getId(),
                dto.getNome(),
                dto.getProfessor(),
                dto.getCargaHoraria()
        );

        repo.salvar(d);
    }

    public void editar(
            int id,
            DisciplinaDTO dto) {

        Disciplina d = repo.buscar(id);

        if (d != null) {

            d.setNome(dto.getNome());
            d.setProfessor(dto.getProfessor());
            d.setCargaHoraria(dto.getCargaHoraria()
            );
        }
    }

    public Disciplina buscar(int id) {

        return repo.buscar(id);
    }

    public void listar(
            PrinterService printer) {

        for (Disciplina d : repo.listar()) {

            DisciplinaDTO dto =
                    new DisciplinaDTO(
                            d.getId(),
                            d.getNome(),
                            d.getProfessor(),
                            d.getCargaHoraria()
                    );

            printer.print(dto.toString());

            for (Estudante e : d.getEstudantes()) {

                printer.print(
                        " - " + e.getNome()
                );
            }
        }
    }

    public void listarSimples(PrinterService printer) {

        for (Disciplina d : repo.listar()) {

            printer.print("ID: " + d.getId() + " | Nome: " + d.getNome()
            );
        }
    }
}