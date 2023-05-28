import java.util.Scanner;
public class OpCondutor {
    public static Condutor escolherCondutor(Seguro seguro) {
        System.out.println("escolha o condutor: ");
        int i = 0;
        Scanner input = new Scanner(System.in);
        for (Condutor conAux:seguro.getListaCondutores()) {
            System.out.println(i + ") " + conAux.getNome());
            System.out.println(conAux);
            i++; 
        }
        int numCon = input.nextInt();
        return seguro.getListaCondutores().get(numCon);
    }
}
