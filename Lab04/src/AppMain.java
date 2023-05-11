import java.time.LocalDate;
import java.util.Scanner;

public class AppMain {
    MenuOperacoes operacao;

    public AppMain(MenuOperacoes operacao) {
        this.operacao = operacao;
    }

    public  void executarOperacao(MenuOperacoes operacao, Seguradora seguradora) {        
        switch(operacao) {
            case CADASTRAR_CLIENTE:
                cadastrar(seguradora);
                break;
            case LISTAR:
                listar(seguradora);
            case EXCLUIR:
                excluir(seguradora);
            case GERAR_SINISTRO:
                gerarSinistro(seguradora);
            case TRANSFERIR_SEGURO:
                transferirSeguro(seguradora);
            case CALC_RECEITA_SEGURADORA:
                calcReceita(seguradora);
            case SAIR:
                break;
        }
    }

    public static void cadastrarCliente(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        int comando;
    
        System.out.println("Qual tipo de cliente  deseja cadastrar? digite o numero correspondente");
        System.out.println("1:PF/ 2:PJ/ 3:VOLTAR");
        comando = input.nextInt();

        Scanner entrada = new Scanner(System.in);

        if (comando == 1) {
            System.out.println("nome:\n");
            String nome = entrada.next();
            
            System.out.println("endereco:\n");
            String endereco = entrada.next();
            
            System.out.println("cpf:\n");
            String cpf = entrada.next();
            
            System.out.println("genero:\n");
            String genero = entrada.next();
            
            System.out.println("dataLicenca:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoL = entrada.nextInt();
            int mesL = entrada.nextInt();
            int diaL = entrada.nextInt();
            
            System.out.println("educacao:\n");
            String educacao = entrada.next();
            
            System.out.println("classe economica:\n");
            String classe = entrada.next();
            
            System.out.println("data nascimento:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoN = entrada.nextInt();
            int mesN = entrada.nextInt();
            int diaN = entrada.nextInt();

            seguradora.cadastrarCliente(new ClientePF(nome,endereco,cpf,genero,LocalDate.of(anoL,mesL,diaL),educacao,classe,LocalDate.of(anoN,mesN,diaN)));
            System.out.println("cliente cadastrado!");
        }
        else if (comando == 2) {
            System.out.println("nome:\n");
            String nome = entrada.next();
            
            System.out.println("endereco:\n");
            String endereco = entrada.next();
            
            System.out.println("cnpj:\n");
            String cnpj = entrada.next();
            
            System.out.println("data fundacao:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoF = entrada.nextInt();
            int mesF = entrada.nextInt();
            int diaF = entrada.nextInt();
            
            System.out.println("qtdFuncionarios:\n");
            int qtdFuncionarios = entrada.nextInt();
            
            seguradora.cadastrarCliente(new ClientePJ(nome,endereco,cnpj,LocalDate.of(anoF,mesF,diaF),qtdFuncionarios));
            System.out.println("cliente cadastrado!");
        }
        entrada.close();            
        input.close();
    }

    public static void cadastrarVeiculo(Seguradora seguradora, Cliente cliente){
        Scanner input = new Scanner(System.in);
        int comando;
    
        Scanner entrada = new Scanner(System.in);

        System.out.println("placa:\n");
        String placa = entrada.next();
        
        System.out.println("marca:\n");
        String marca = entrada.next();
        
        System.out.println("modelo:\n");
        String modelo = entrada.next();
        
        System.out.println("data fundacao:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoF = entrada.nextInt();
            int mesF = entrada.nextInt();
            int diaF = entrada.nextInt();
            
        cliente.cadastrarVeiculo(new Veiculo(placa,marca,modelo,));
        System.out.println("veiculo cadastrado!");
    
        entrada.close();            
        input.close();
    }

    public static Cliente encontrarCliente(String nome, Seguradora seguradora){
        Cliente cliente=null;
        for (Cliente clienteAux: seguradora.listarClientes("PF")) {
            if (clienteAux.getNome().equals(nome)){
                cliente = clienteAux;
                return cliente;
            }
        }
        for (Cliente clienteAux: seguradora.listarClientes("PJ")) {
            if (clienteAux.getNome().equals(nome)){
                cliente = clienteAux;
                break;
            }
        }
        return cliente;
        
    }

    public static void cadastrar(Seguradora seguradora){
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        
        do {    
            System.out.println("O que deseja cadastrar? digite o numero correspondente");
            System.out.println("1:CLIENTE/ 2:VEICULO/ 3:SEGURADORA/ 4:VOLTAR");
            
            int comando = input.nextInt();
            
            //CADASTRAR CLIENTE
            if (comando == 1) {
                cadastrarCliente(seguradora);
            }        
            //CADASTRAR VEICULO
            else if (comando == 2) {
                System.out.println("nome do cliente:");
                String nome = input.next();
                //encontrar cliente
                Cliente cliente = encontrarCliente(nome,seguradora);
                
                cadastrarVeiculo(seguradora,cliente);
            }
            
            else if (comando == 3){
                voltar = true;
            }
        } while(!voltar);    
        input.close();
        
    }

    public static void listar(Seguradora seguradora) {
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("O que deseja listar? digite o numero correspondente");
            System.out.println("1:CLIENTE por Seg/ 2:Sinistro por Seg/ 3:Sinistro por Cliente/ 4:Veiculo por Cliente/ 5:Veiculo por Seg/ 6:VOLTAR");
            
            int comando = input.nextInt();
            if (comando == 1) {

                System.out.println("tipo de cliente? PF/PJ");
                String tipo = input.next();
                System.out.println("listando clientes...");
                
                seguradora.listarClientes(tipo);
            }
            else if (comando == 2) {
                System.out.println("listando sinistros por Seguradora...");
                seguradora.listarSinistros();
            }
            else if (comando == 3) {
                System.out.println("nome?");
                String nome = input.next();
                System.out.println("listando sinistros por Cliente...");
                for (Sinistro sinistro: seguradora.listarSinistros()) {
                    if (nome.equals(sinistro.getCliente().getNome())) {
                        System.out.println(sinistro.toString());
                    }
                }
            }   
            else if (comando == 4) {
                System.out.println("listando veiculos por Cliente...");
                System.out.println("nome?");
                String nome = input.next();
                System.out.println("listando veiculos por Cliente...");
                Cliente cliente = encontrarCliente(nome, seguradora);
                cliente.listarVeiculos();
            }
            else if (comando == 5) {
                System.out.println("listando veiculos por Seguradora...");
                for (Cliente cliente:seguradora.listarClientes("PF")){
                    cliente.listarVeiculos();
                }
                for (Cliente cliente:seguradora.listarClientes("PJ")){
                    cliente.listarVeiculos();
                }
            }
            else if (comando == 6) {
                voltar = true;
            }
        } while (!voltar);
        
        input.close();
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
                seguradora.removerCliente(nome);
            }
            else if (comando == 2) {
                System.out.println("placa?");
                String placa = input.next();
                System.out.println("nome?");
                String nome = input.next();
                Cliente cliente = encontrarCliente(nome, seguradora);
                System.out.println("excluindo veiculo...");
                cliente.removerVeiculo(placa);
            }  
            else if (comando == 3) {
                System.out.println("excluindo sinistros...");
                System.out.println("placa?");
                String placa = input.next();
                Boolean encontrei = false;
                //encontrar veiculo
                Sinistro sinistro;
                for (Sinistro sinistroAux: seguradora.listarSinistros()){
                    if (sinistro.getVeiculo().getPlaca().equals(placa)) {
                        sinistro = sinistroAux;
                        break;
                    }
                }
                seguradora.listarSinistros().remove(sinistro);    
            }
            else if (comando == 4) {
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

    public static void calcReceita(Seguradora seguradora){
        System.out.println("calculando receita...");
        double receita = seguradora.calcularReceita();
        //printar
        System.out.printf("A receita é %d", receita);
    }
}
