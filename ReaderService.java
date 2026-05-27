import java.util.Scanner;

public class ReaderService {

    private Scanner sc = new Scanner(System.in);

    public int lerInt() {

        return sc.nextInt();
    }

    public String lerString() {

        sc.nextLine();

        return sc.nextLine();
    }

    public String lerTexto() {

        return sc.nextLine();
    }
}
