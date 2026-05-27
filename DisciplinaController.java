public class DisciplinaController {

    private DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    public void cadastrar(DisciplinaDTO dto) {
        service.cadastrar(dto);
    }

    public void editar(
            int id,
            DisciplinaDTO dto) {

        service.editar(id, dto);
    }

    public void listar(PrinterService printer) {
        service.listar(printer);
    }

    public void listarSimples(PrinterService printer) {
        service.listarSimples(printer);
    }
}