public class EstudanteController {

    private EstudanteService service;

    public EstudanteController(EstudanteService service) {
        this.service = service;
    }

    public void cadastrar(EstudanteDTO dto) {
        service.cadastrar(dto);
    }

    public void editar(
            int id,
            EstudanteDTO dto) {

        service.editar(id, dto);
    }

    public void listar(
            PrinterService printer) {

        service.listar(printer);
    }

    public void listarSimples(
            PrinterService printer) {

        service.listarSimples(printer);
    }
}