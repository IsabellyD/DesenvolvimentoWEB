import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Estudante> estudantes = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Disciplina");
            System.out.println("2 - Cadastrar Estudante");
            System.out.println("3 - Inserir estudante na disciplina");
            System.out.println("4 - Listar");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("ID da disciplina: ");
                    int idDisc = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome da disciplina: ");
                    String nomeDisc = sc.nextLine();

                    System.out.print("Professor: ");
                    String prof = sc.nextLine();

                    System.out.print("Carga horária: ");
                    int carga = sc.nextInt();

                    disciplinas.add(new Disciplina(idDisc, nomeDisc, prof, carga));
                    System.out.println("Disciplina cadastrada!");
                    break;

                case 2:
                    System.out.print("ID do estudante: ");
                    int idEst = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Matrícula: ");
                    String mat = sc.nextLine();

                    System.out.print("Curso: ");
                    String curso = sc.nextLine();

                    estudantes.add(new Estudante(idEst, nome, idade, mat, curso));
                    System.out.println("Estudante cadastrado!");
                    break;

                case 3:
                    System.out.print("ID do estudante: ");
                    int idEstBusca = sc.nextInt();

                    System.out.print("ID da disciplina: ");
                    int idDiscBusca = sc.nextInt();

                    Estudante estEncontrado = null;
                    Disciplina discEncontrada = null;

                    for (Estudante e : estudantes) {
                        if (e.getId() == idEstBusca) {
                            estEncontrado = e;
                            break;
                        }
                    }

                    for (Disciplina d : disciplinas) {
                        if (d.getId() == idDiscBusca) {
                            discEncontrada = d;
                            break;
                        }
                    }

                    if (estEncontrado != null && discEncontrada != null) {
                        discEncontrada.adicionarEstudante(estEncontrado);
                        System.out.println("Estudante inserido na disciplina!");
                    } else {
                        System.out.println("Estudante ou Disciplina não encontrado!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- DISCIPLINAS ---");
                    for (Disciplina d : disciplinas) {
                        System.out.println(d);
                        System.out.println("Estudantes:");
                        for (Estudante e : d.getEstudantes()) {
                            System.out.println("  - " + e.getNome());
                        }
                    }

                    System.out.println("\n--- ESTUDANTES ---");
                    for (Estudante e : estudantes) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}