public class Main {

    public static void main(String[] args) {

        ReaderService reader = new ReaderService();
        PrinterService printer = new PrinterService();

        SistemaService sistema = new SistemaService();

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

                    sistema.cadastrarDisciplina(
                            new Disciplina(idD, nomeD, prof, carga)
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

                    sistema.cadastrarEstudante(
                            new Estudante(idE, nomeE, idade, mat)
                    );

                    break;

                case 3:

                    sistema.listarEstudantesSimples();

                    printer.print("ID estudante:");
                    int e = reader.lerInt();

                    sistema.listarDisciplinasSimples();

                    printer.print("ID disciplina:");
                    int d = reader.lerInt();

                    sistema.inserir(e, d);

                    break;

                case 4:

                    sistema.listarTudo();

                    break;

                case 5:

                    sistema.listarDisciplinasSimples();

                    printer.print("ID:");
                    int ed = reader.lerInt();

                    printer.print("Nome:");
                    String nd = reader.lerString();

                    printer.print("Professor:");
                    String np = reader.lerTexto();

                    printer.print("Carga:");
                    int nc = reader.lerInt();

                    sistema.editarDisciplina(ed, nd, np, nc);

                    break;

                case 6:

                    sistema.listarEstudantesSimples();

                    printer.print("ID:");
                    int ee = reader.lerInt();

                    printer.print("Nome:");
                    String ne = reader.lerString();

                    printer.print("Idade:");
                    int ni = reader.lerInt();

                    printer.print("Matrícula:");
                    String nm = reader.lerString();

                    sistema.editarEstudante(ee, ne, ni, nm);

                    break;

                case 7:

                    printer.print("Sistema encerrado!");

                    break;

                default:

                    printer.print("Opção inválida!");
            }

        } while (op != 7);
    }
}
