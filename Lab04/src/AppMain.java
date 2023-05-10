import java.util.Scanner;

public class AppMain {
    MenuOperacoes operacao;

    public AppMain(MenuOperacoes operacao) {
        this.operacao = operacao;
    }

    public  void executarOperacao(MenuOperacoes operacao, Seguradora seguradora) {        
        switch(operacao) {
            case CADASTRAR_CLIENTE:
                cadastrar();
                break;
            case LISTAR:
                listar();
            case EXCLUIR:
                excluir();
            case GERAR_SINISTRO:
                gerarSinistro(seguradora);
            case TRANSFERIR_SEGURO:
                transferirSeguro();
            case CALC_RECEITA_SEGURADORA:
                calcReceita();
            case SAIR:
                break;
        }
    }

    public static void cadastrar(){
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        
        do {    
            System.out.println("O que deseja cadastrar? digite o numero correspondente");
            System.out.println("1:CLIENTE/ 2:VEICULO/ 3:SEGURADORA/ 4:VOLTAR");
            
            int comando = input.nextInt();
            if (comando == 1) {
                System.out.println("Qual tipo de cliente  deseja cadastrar? digite o numero correspondente");
                System.out.println("1:PF/ 2:PJ/ 3:VOLTAR");
                comando = input.nextInt();
                if (comando == 1) {
                    System.out.println("Dados do cliente?");
                }
                else if (comando == 2) {
                    System.out.println("Dados do cliente?");
                
                }
                else if (comando == 3) {
                    voltar = true;
                }
            }        
        } while(!voltar);
        input.close();
        
    }

    public static void listar() {
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("O que deseja listar? digite o numero correspondente");
            System.out.println("1:CLIENTE por Seg/ 2:Sinistro por Seg/ 3:Sinistro por Cliente/ 4:Veiculo por Cliente/ 5:Veiculo por Seg/ 6:VOLTAR");
            
            int comando = input.nextInt();
            if (comando == 1) {
                System.out.println("listando clientes PF/PJ...");
            }
            else if (comando == 2) {
                System.out.println("listando sinistros por Seguradora...");
            
            }
            else if (comando == 3) {
                System.out.println("listando sinistros por Cliente...");
            
            }
            else if (comando == 4) {
                System.out.println("listando veiculos por Cliente...");
            
            }
            else if (comando == 5) {
                System.out.println("listando veiculos por Seguradora...");
            
            }
            else if (comando == 6) {
                voltar = true;
            }
        } while (!voltar);
        
        input.close();
    }

    public static void excluir() {
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("O que deseja excluir? digite o numero correspondente");
            System.out.println("1:CLIENTE 2:VEICULO/ 3:Sinistro / 4:VOLTAR");
            
            int comando = input.nextInt();
            if (comando == 1) {
                System.out.println("excluindo cliente...");
            }
            else if (comando == 2) {
                System.out.println("excluindo veiculo...");
            
            }
            else if (comando == 3) {
                System.out.println("excluindo sinistros...");
            
            }
            else if (comando == 6) {
                voltar = true;
            }
        } while (!voltar);
        
        input.close();
    }

    public static void gerarSinistro(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        
        System.out.println("cpf/cnpj: ");    
        String dadoCliente = input.next();
        
        System.out.println("placa do carro: ");    
        String dadoVeiculo = input.next();

        //encontrar cliente
        
        //encontrar veiculo

        //gerar sinistro
      
        input.close();
    }

    public static void transferirSeguro(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        
        System.out.println("cpf/cnpj 1: ");    
        String dadoCliente1 = input.next();
        
        System.out.println("cpf/cnpj 2: ");    
        String dadoCliente2 = input.next();

        //encontrar clientes
        
        //transferir lista de veiculos

        //recalcular scores
      
        input.close();
    }

    public static void calcularReceita(Seguradora seguradora){
        System.out.println("calculando receita...");
        double receita = seguradora.calcularReceita();
        //printar
        System.out.printf("A receita é %d", receita);
    }
}
