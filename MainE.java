import java.util.Scanner;

public class MainE {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaService sistema = new SistemaService();
        int op;

        do {
            System.out.println(
                    "\n1-Cad Disciplina\n2-Cad Estudante\n3-Relacionar\n4-Listar\n5-Editar Disciplina\n6-Editar Estudante\n7-Sair");
            op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("ID: ");
                    int idD = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeD = sc.nextLine();
                    System.out.print("Professor: ");
                    String prof = sc.nextLine();
                    System.out.print("Carga: ");
                    int carga = sc.nextInt();

                    sistema.cadastrarDisciplina(new Disciplina(idD, nomeD, prof, carga));
                    break;

                case 2:
                    System.out.print("ID: ");
                    int idE = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nomeE = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Matrícula: ");
                    String mat = sc.nextLine();

                    sistema.cadastrarEstudante(new Estudante(idE, nomeE, idade, mat));
                    break;

                case 3:
                    sistema.listarEstudantesSimples();
                    System.out.print("ID estudante: ");
                    int e = sc.nextInt();

                    sistema.listarDisciplinasSimples();
                    System.out.print("ID disciplina: ");
                    int d = sc.nextInt();

                    sistema.inserir(e, d);
                    break;

                case 4:
                    sistema.listarTudo();
                    break;

                case 5:
                    sistema.listarDisciplinasSimples();
                    System.out.print("ID: ");
                    int ed = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nd = sc.nextLine();
                    System.out.print("Professor: ");
                    String np = sc.nextLine();
                    System.out.print("Carga: ");
                    int nc = sc.nextInt();

                    sistema.editarDisciplina(ed, nd, np, nc);
                    break;

                case 6:
                    sistema.listarEstudantesSimples();
                    System.out.print("ID: ");
                    int ee = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String ne = sc.nextLine();
                    System.out.print("Idade: ");
                    int ni = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Matrícula: ");
                    String nm = sc.nextLine();

                    sistema.editarEstudante(ee, ne, ni, nm);
                    break;

            }

        } while (op != 7);

        sc.close();
    }
}
