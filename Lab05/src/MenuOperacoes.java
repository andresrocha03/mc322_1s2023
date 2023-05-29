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
    AUTORIZAR_CONDUTOR(7),
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
                Seguro seguro = OpSeguro.escolherSeguro(seguradora);
                OpCondutor.cadastrarCondutor(seguro);
            }
            else if (comando == 5) {
                Cliente cliente = OpCliente.escolherCliente(seguradora);
                OpFrota.cadastrarFrota((ClientePJ)cliente);
            }
            else if (comando == 6) {
                OpSeguro.cadastrarSeguro(seguradora);
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
            System.out.println(" 1:Cliente por Seguradora\n 2:Sinistros por Seguro\n 3:Sinistros por Cliente");
            System.out.println("4:Veiculos por Cliente\n 5:Veiculos por Seguro\n 6:Seguros por Cliente\n 7:VOLTAR\n");
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
                Cliente cliente = OpCliente.encontrarCliente(nome, seguradora);
                System.out.println("listando veiculos por Cliente...");
                if (cliente instanceof ClientePF) {
                    System.out.println(((ClientePF)cliente).getListaVeiculos());
                }
                else if (cliente instanceof ClientePJ) {
                    //todas as frotas
                    for(Frota frotaAux : ((ClientePJ)cliente).getListaFrotas()){
                        System.out.println("Veiculos da frota" + frotaAux.getCode());
                        System.out.println(frotaAux.getListaVeiculos());
                    }                    
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
                System.out.println("Digite o nome do cliente");
                String nome = input.next();
                Cliente cliente = OpCliente.encontrarCliente(nome, seguradora);
                System.out.println(seguradora.getSegurosPorCliente(cliente)); 
            }
            else if (comando == 7) {
                voltar = true;
            }
        } while (!voltar);
        
    }

    public static void excluir(Seguradora seguradora, ArrayList<Seguradora> listaSeguradoras) {
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("O que deseja excluir? digite o numero correspondente");
            System.out.println(" 1:CLIENTE\n 2:VEICULO\n 3:Sinistro\n");
            System.out.println(" 4:Frota\n 5:Condutor\n 6:Seguro\n 7: Seguradora \n 8:VOLTAR"); 
            
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
                seguro.getListaSinistros().remove(sinistro);    
                System.out.println("sinistro removido com sucesso!\n");
            }
            else if (comando == 4) {
                Cliente cliente = OpCliente.escolherCliente(seguradora);
                Frota frota = OpFrota.escolherFrota((ClientePJ)cliente);
                ((ClientePJ)cliente).atualizarFrota(frota);
                System.out.println("frota removida com sucesso!\n");
            }
            else if (comando == 5) {
                Seguro seguro = OpSeguro.escolherSeguro(seguradora);
                Condutor condutor = OpCondutor.escolherCondutor(seguro);
                seguro.getListaCondutores().remove(condutor);
                System.out.println("condutor removido com sucesso!\n");    
            }
            else if (comando == 6) {
                Seguro seguro = OpSeguro.escolherSeguro(seguradora);
                seguradora.cancelarSeguro(seguro);   
                System.out.println("Seguro excluido com sucesso!\n");
                
            }
            else if (comando == 7) {
                Seguradora seguradoraAux = OpSeguradora.escolherSeguradora(listaSeguradoras);
                listaSeguradoras.remove(seguradoraAux);   
                System.out.println("seguradora removida com sucesso!\n");
                 
            }
            else if (comando == 8) {
                voltar = true;
            }
        } while (!voltar);
        
    }

   
    


}
