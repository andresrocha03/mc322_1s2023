import java.time.LocalDate;
import java.util.Scanner;

public class OpSeguro {
   
    public static Seguro escolherSeguro(Seguradora seguradora) {
        System.out.println("escolha o seguro : ");
        int i = 0;
        Scanner input = new Scanner(System.in);
        for (Seguro segAux:seguradora.getListaSeguros()) {
            System.out.println(i + ") " + segAux.getId());
            System.out.println(segAux);
            i++; 
        }
        int numSeg = input.nextInt();
        return seguradora.getListaSeguros().get(numSeg);
    }
   
    public static void transferirSeguro(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        
        System.out.println("nome que possui o seguro: ");    
        String nome1 = input.next();
        
        System.out.println("nome para o qual o seguro sera transferido: ");    
        String nome2 = input.next();

        Cliente cliente1 = OpCliente.encontrarCliente(nome1, seguradora);
        Cliente cliente2 = OpCliente.encontrarCliente(nome2, seguradora);

        System.out.println("1 p/ escolher seguro e 2 p/transferir todos os seguros");
        int opcao = input.nextInt();
        if (opcao == 1) {
            Seguro seguro = escolherSeguro(seguradora);
            if (seguro instanceof SeguroPF) {
                ((SeguroPF)seguro).setCliente((ClientePF)cliente2);
            }
            else {
                ((SeguroPJ)seguro).setCliente((ClientePJ)cliente2);
            }
        }
        else if (opcao == 2) {
            for (Seguro segAux: seguradora.getListaSeguros()) {
                if (cliente1 instanceof ClientePJ) {
                    if (segAux instanceof SeguroPJ){
                        ((SeguroPJ)segAux).setCliente((ClientePJ)cliente2);
                    }
                }
                else {
                    if (segAux instanceof SeguroPF){
                        ((SeguroPF)segAux).setCliente((ClientePF)cliente2);
                    }
                }
    
            }
        }
    }

    public static boolean cadastrarSeguro(Seguradora seguradora) {
        //criar nova frota
        Scanner entrada = new Scanner(System.in);
        int comando;
        System.out.println("Qual tipo de Seguro  deseja cadastrar? digite o numero correspondente");
        System.out.println(" 1:PF\n 2:PJ");
        comando = entrada.nextInt();
        entrada.nextLine();

        
        if (comando == 1) {
            System.out.println("data inicio:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoI = entrada.nextInt();
            entrada.nextLine();
            int mesI = entrada.nextInt();
            entrada.nextLine();
            int diaI = entrada.nextInt();
            entrada.nextLine();
            System.out.println("data fim:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoF = entrada.nextInt();
            entrada.nextLine();
            int mesF = entrada.nextInt();
            entrada.nextLine();
            int diaF = entrada.nextInt();
            entrada.nextLine();
            Cliente cliente = OpCliente.escolherCliente(seguradora);
            Veiculo veiculo = OpVeiculo.escolherVeiculo(cliente);

            SeguroPF novoSeguro = new SeguroPF(LocalDate.of(anoI,mesI,diaI),LocalDate.of(anoF, mesF, diaF), seguradora, veiculo, (ClientePF)cliente);
            if (seguradora.cadastrarSeguro(novoSeguro)) {
                System.out.println("Novo seguro" + novoSeguro.getId() + "cadastrado com sucesso!");
                return true;
            }
        }
        else if (comando == 2){
            System.out.println("data inicio:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoI = entrada.nextInt();
            entrada.nextLine();
            int mesI = entrada.nextInt();
            entrada.nextLine();
            int diaI = entrada.nextInt();
            entrada.nextLine();
            System.out.println("data fim:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoF = entrada.nextInt();
            entrada.nextLine();
            int mesF = entrada.nextInt();
            entrada.nextLine();
            int diaF = entrada.nextInt();
            entrada.nextLine();
            Cliente cliente = OpCliente.escolherCliente(seguradora);

            SeguroPJ novoSeguro = new SeguroPJ(LocalDate.of(anoI,mesI,diaI),LocalDate.of(anoF, mesF, diaF), seguradora, (ClientePJ)cliente);
            if (seguradora.cadastrarSeguro(novoSeguro)) {
                System.out.println("Novo seguro" + novoSeguro.getId() + "cadastrado com sucesso!");
                return true;
            }
        }
        
        
        System.out.println("erro no cadastro de seguro :(");
        return false;
    }
}
