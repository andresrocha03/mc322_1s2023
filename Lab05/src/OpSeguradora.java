import java.util.ArrayList;
import java.util.Scanner;

public class OpSeguradora {
    
    public static void cadastrarSeguradora(ArrayList<Seguradora> lista) {
        System.out.println("UTILIZE _ AO INVES DE ESPACOS");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o cnpj da nova seguradora: ");
        String cnpj = entrada.next();
        System.out.println("Digite o nome da nova seguradora: ");
        String nome = entrada.next();
        System.out.println("Digite o telefone da nova seguradora: ");
        String telefone = entrada.next();
        System.out.println("Digite o email da nova seguradora: ");
        String email = entrada.next();
        System.out.println("Digite o endereço da nova seguradora: ");
        String endereco = entrada.nextLine();

        Seguradora novaSeguradora = new Seguradora(cnpj,nome, telefone, email, endereco);
        
        lista.add(novaSeguradora);
    }

    public static Seguradora escolherSeguradora(ArrayList<Seguradora> listaSeguradoras) {
        Scanner input = new Scanner(System.in);
        System.out.println("escolha nome seguradora: ");
        for (Seguradora segAux:listaSeguradoras) {
            System.out.println(segAux.getNome()); 
        }
        String nomeSeg = input.next();
        Seguradora escolhido = null;
        for (Seguradora s:listaSeguradoras){
            if (s.getNome().equals(nomeSeg)) {
                escolhido = s;
            }
        }
        return escolhido;
    }

    public static void calcReceita(Seguradora seguradora){
        System.out.println("calculando receita...");
        double receita = seguradora.calcularReceita();
        //printar
        System.out.println("A receita é " + receita);
    }



   
}
