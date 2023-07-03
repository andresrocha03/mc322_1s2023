import java.time.LocalDate;
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

    public static Boolean cadastrarCondutor(Seguro seguro) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("UTILIZE _ AO INVES DE ESPACOS");
        System.out.println("nome:\n");
        String nome = entrada.next();
        //validar cpf
        if (!Validacao.validateName(nome)) {
            System.out.println("digite nome valido\n");
        }
        while (!Validacao.validateName(nome)) {  
            nome = entrada.next();
        }

        System.out.println("endereco:\n");
        String endereco = entrada.next();
        
        System.out.println("cpf:\n");
        String cpf = entrada.next();
        if (!Validacao.validateCPF(cpf)) {
            while (!Validacao.validateCPF(cpf)) {
                System.out.println("digite cpf valido\n");
                cpf = entrada.next();
            }
        }
        
        System.out.println("telefone:\n");
        String telefone = entrada.next();
        
        System.out.println("email:\n");
        String email = entrada.next();
        
        
        System.out.println("data nascimento:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
        int anoN = entrada.nextInt();
        entrada.nextLine();
        int mesN = entrada.nextInt();
        entrada.nextLine();
        int diaN = entrada.nextInt();
        entrada.nextLine();
        Condutor novoCondutor = new Condutor(cpf,nome,telefone,endereco,email,LocalDate.of(anoN,mesN,diaN));
        if (seguro.cadastrarCondutor(novoCondutor)){
            System.out.println("condutor cadastrado!");
            return true;
        }
        System.out.println("erro no cadastro");
        return false;
    }

    public static Boolean autorizacaoCondutor(Seguradora seguradora) {
        Scanner entrada = new Scanner(System.in);
        Seguro seguro = OpSeguro.escolherSeguro(seguradora);
        Condutor condutor = escolherCondutor(seguro);
        System.out.println("1 para autorizar\n2 para desautorizar");
        int comando = entrada.nextInt();
        if (comando == 1) {
            seguro.autorizarCondutor(condutor);
        }
        else if (comando == 2) {
            seguro.desautorizarCondutor(condutor);
        }
        System.out.println("a autorizacao do condutor " + condutor.getNome() + " é "  + condutor.getAutorizacao());
        return true;
    }


}
