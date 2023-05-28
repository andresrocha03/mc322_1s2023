import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public enum MenuOperacoes {
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALC_RECEITA_SEGURADORA(6),
    SAIR(0);
    
    public final int valor;

    MenuOperacoes(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return this.valor;
    }

    public static MenuOperacoes getOperacao(int valor) {
        MenuOperacoes operacao = null;
        for (MenuOperacoes operacaoAux:MenuOperacoes.values()) {
            if (valor == operacaoAux.getValor()) {
                operacao = operacaoAux;
                break;
            }
        }
        return operacao;
    }

   
  
    public static void cadastrar(Seguradora seguradora,ArrayList<Seguradora> listaSeguradora){
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        int comando = -1;
        do {    
            System.out.println("O que deseja cadastrar? digite o numero correspondente");
            System.out.println("1:CLIENTE\n 2:VEICULO\n 3:SEGURADORA\n 4:CONDUTOR\n 5:FROTA\n 6:SEGURO\n 7:VOLTAR");
            
            comando = input.nextInt();
            
            //CADASTRAR CLIENTE
            if (comando == 1) {
                OpCliente.cadastrarCliente(seguradora);
            }        
            //CADASTRAR VEICULO
            else if (comando == 2) {
                System.out.println("nome do cliente:");
                String nome = input.next();
                //encontrar cliente
                Cliente cliente = OpCliente.encontrarCliente(nome,seguradora);
                
                OpVeiculo.cadastrarVeiculo(seguradora,cliente);
            }
            //CADASTRAR SEGURADORA
            else if (comando == 3){
                OpSeguradora.cadastrarSeguradora(listaSeguradora);
            }
            else if (comando == 4) {
                OpCondutor.cadastrarCondutor();
            }
            else if (comando == 5) {
                OpFrota.cadastrarFrota();
            }
            else if (comando == 6) {
                OpSegurao.cadastrarSeguro();
            }
            else if (comando == 7) {
                voltar = true;
            }
        } while(!voltar);    

        
    }

    public static void listar(Seguradora seguradora) {
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("O que deseja listar? digite o numero correspondente");
            System.out.println("1:Veiculos por Cliente\n 
            2:Frotas por ClientePJ\n 
            Seguros por Cliente
            Sinistros por Cliente
            3:Sinistros por Condutor\n 
            Cliente por Seguradora\n
            Sinistros por Seguro
            Condutores por Seguro
            Frotas por SeguroPJ
            4: 
            5:Veiculo por Seguro\n 
            6:Condutor\n
            Sinistro por Seguro/
            Sinistro por Cliente
            10:VOLTAR");
            
            int comando = input.nextInt();
            if (comando == 1) {

                System.out.println("tipo de cliente? PF/PJ");
                String tipo = input.next();
                System.out.println("listando clientes...");
                
                seguradora.getListaClientes(tipo);
            }
            else if (comando == 2) {
                System.out.println("listando sinistros por Seguro...");
                Seguro segEscolhido = OpSeguro.escolherSeguro(seguradora);
                for (Sinistro sinistro: segEscolhido.getListaSinistros()) {
                    System.out.println(sinistro.toString());
                }
            }
            else if (comando == 3) {
                System.out.println("Digite o nome do cliente: ");
                String nome = input.next();
                System.out.println("listando sinistros por Cliente...");
                Cliente cliente = OpCliente.encontrarCliente(nome, seguradora);
                seguradora.getSinistrosPorCliente(cliente);
            }   
            else if (comando == 4) {
                System.out.println("listando veiculos por Cliente...");
                System.out.println("Digite o nome do cliente");
                String nome = input.next();
                System.out.println("listando veiculos por Cliente...");
                Cliente cliente = OpCliente.encontrarCliente(nome, seguradora);
                if (cliente instanceof ClientePF) {
                    System.out.println(((ClientePF)cliente).getListaVeiculos());
                }
                else if (cliente instanceof ClientePJ) {
                    //todas as frotas
                    for(frotinha :listafrotas){
                        print(frota.listaveiculos)
                    }
                    //escolher frota
                    Frota frotaEscolhida = OpFrota.escolherFrota((ClientePJ)cliente); 
                    System.out.println(frotaEscolhida.getListaVeiculos());
                }
                 
            }
            else if (comando == 5) {
                System.out.println("listando veiculos por Seguro...");
                Seguro seguro = OpSeguro.escolherSeguro(seguradora);
                if (seguro instanceof SeguroPF) {
                    System.out.println(((SeguroPF)seguro).getVeiculo());
                }
                else if (seguro instanceof SeguroPJ) {
                    Frota frota = OpFrota.escolherFrota((SeguroPJ)seguro);
                    System.out.println(frota.getListaVeiculos());
                }
            }
            else if (comando == 6) {
                voltar = true;
            }
        } while (!voltar);
        
    }

    public static void excluir(Seguradora seguradora) {
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("O que deseja excluir? digite o numero correspondente");
            System.out.println("1:CLIENTE 2:VEICULO/ 3:Sinistro / 4:VOLTAR");
            
            int comando = input.nextInt();
            
            if (comando == 1) {
                System.out.println("nome?");
                String nome = input.next();
                System.out.println("excluindo cliente...");
                Cliente cliente = OpCliente.encontrarCliente(nome, seguradora);
                seguradora.removerCliente(cliente);
            }
            else if (comando == 2) {
                System.out.println("nome do cliente dono do veiculo?");
                String nome = input.next();
                System.out.println("placa do veiculo?");
                String placa = input.next();
                Cliente cliente = OpCliente.encontrarCliente(nome, seguradora);
                Veiculo veiculo = OpVeiculo.encontrarVeiculo(placa,cliente);
                System.out.println("excluindo veiculo...");
                if (cliente instanceof ClientePF) {
                    ((ClientePF)cliente).removerVeiculo(veiculo);
                }
                else if (cliente instanceof ClientePJ) {
                    ((ClientePJ)cliente).atualizarFrota(OpFrota.encontrarFrota(veiculo, (ClientePJ)cliente), veiculo);
                }
            }  
            else if (comando == 3) {
                Seguro seguro = OpSeguro.escolherSeguro(seguradora);
                Sinistro sinistro = OpSinistro.escolherSinistro(seguro);
                System.out.println("excluindo sinistros...");
                seguro.getListaSinistros().remove(sinistro);    
            }
            else if (comando == 4) {
                voltar = true;
            }
        } while (!voltar);
        
    }

    public static void calcReceita(Seguradora seguradora){
        System.out.println("calculando receita...");
        double receita = seguradora.calcularReceita();
        //printar
        System.out.println("A receita é " + receita);
    }

    


}
