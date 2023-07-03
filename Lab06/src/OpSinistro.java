import java.time.LocalDate;
import java.util.Scanner;

public class OpSinistro {
    public static Sinistro escolherSinistro(Seguro seguro) {
        System.out.println("escolha o sinistro: ");
        int i = 0;
        Scanner input = new Scanner(System.in);
        for (Sinistro sinAux:seguro.getListaSinistros()) {
            System.out.println(i + ") " + sinAux.getId());
            System.out.println(sinAux);
            i++; 
        }
        int numSin = input.nextInt();
        return seguro.getListaSinistros().get(numSin);
    }

    public static void gerarSinistro(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        System.out.println("UTILIZE _ AO INVES DE ESPACOS");
        
        Seguro seguro = OpSeguro.escolherSeguro(seguradora);
        
        Condutor condutor = OpCondutor.escolherCondutor(seguro);
        System.out.println("Digite o endereco:\n");
        String endereco = input.next();
        
        System.out.println("dataLicenca:\n digite o ano,mes,dia. A cada input, pressione o enter");
        int ano = input.nextInt();
        int mes = input.nextInt();
        int dia = input.nextInt();
        //gerar sinistro
        seguro.gerarSinistro(LocalDate.of(ano,mes,dia),endereco,condutor);
        System.out.println("sinistro gerado com sucesso !");
    }
}
