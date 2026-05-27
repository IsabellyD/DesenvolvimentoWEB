public class Main {
        public static void main(String[] args) {

        ReaderService reader = new ReaderService();
        PrinterService printer = new PrinterService();
        EstudanteRepository estRepo = new EstudanteRepository();
        DisciplinaRepository discRepo = new DisciplinaRepository();
        EstudanteService estService = new EstudanteService(estRepo);
        DisciplinaService discService = new DisciplinaService(discRepo);
        EstudanteController estController = new EstudanteController(estService);
        DisciplinaController discController = new DisciplinaController(discService);

        int op;

        do {

        printer.print(
                "\n1-Cad Disciplina" +
                "\n2-Cad Estudante" +
                "\n3-Relacionar" +
                "\n4-Listar" +
                "\n5-Editar Disciplina" +
                "\n6-Editar Estudante" +
                "\n7-Sair"
        );

        op = reader.lerInt();

        switch (op) {

                case 1:
                printer.print("ID:");
                int idD = reader.lerInt();

                printer.print("Nome:");
                String nomeD = reader.lerString();

                printer.print("Professor:");
                String prof = reader.lerTexto();

                printer.print("Carga:");
                int carga = reader.lerInt();

                DisciplinaDTO discDTO = new DisciplinaDTO(
                                idD,
                                nomeD,
                                prof,
                                carga
                );

                discController.cadastrar(
                        discDTO
                );

                printer.print("Disciplina cadastrada!"
                );
                break;

                case 2:
                printer.print("ID:");
                int idE = reader.lerInt();

                printer.print("Nome:");
                String nomeE = reader.lerString();

                printer.print("Idade:");
                int idade = reader.lerInt();

                printer.print("Matrícula:");
                String mat = reader.lerString();

                EstudanteDTO estDTO = new EstudanteDTO(
                                idE,
                                nomeE,
                                idade,
                                mat
                        );

                estController.cadastrar(
                        estDTO
                );

                printer.print("Estudante cadastrado!"
                );
                break;

                case 3:
                estController.listarSimples(
                        printer
                );

                printer.print("ID estudante:"
                );

                int idEst = reader.lerInt();

                discController.listarSimples(
                        printer
                );

                printer.print("ID disciplina:"
                );

                int idDisc = reader.lerInt();

                Estudante e = estService.buscar(idEst);

                Disciplina d = discService.buscar(idDisc);

                if (e != null && d != null) {

                        e.adicionarDisciplina(d);

                        d.adicionarEstudante(e);

                        printer.print("Relacionamento feito!"
                        );

                } else {

                        printer.print("Estudante ou disciplina não encontrado!"
                        );
                }
                break;

                case 4:
                printer.print("\nDISCIPLINAS:"
                );

                discController.listar(
                        printer
                );

                printer.print("\nESTUDANTES:"
                );

                estController.listar(
                        printer
                );
                break;

                case 5:
                discController.listarSimples(
                        printer
                );

                printer.print("ID:");
                int ed = reader.lerInt();

                printer.print("Nome:");
                String nd = reader.lerString();

                printer.print("Professor:");
                String np = reader.lerTexto();

                printer.print("Carga:");
                int nc = reader.lerInt();

                DisciplinaDTO dtoD = new DisciplinaDTO(
                                ed,
                                nd,
                                np,
                                nc
                        );

                discController.editar(
                        ed,
                        dtoD
                );

                printer.print("Disciplina editada!"
                );
                break;

                case 6:
                estController.listarSimples(
                        printer
                );

                printer.print("ID:");
                int ee = reader.lerInt();

                printer.print("Nome:");
                String ne = reader.lerString();

                printer.print("Idade:");
                int ni = reader.lerInt();

                printer.print("Matrícula:");
                String nm = reader.lerString();

                EstudanteDTO dtoE =  new EstudanteDTO(
                                ee,
                                ne,
                                ni,
                                nm
                        );

                estController.editar(
                        ee,
                        dtoE
                );

                printer.print("Estudante editado!"
                );
                break;

                case 7:
                printer.print("Sistema encerrado!"
                );
                break;

                default:

                printer.print("Opção inválida!"
                );
                }
        } while (op != 7);
}
}
