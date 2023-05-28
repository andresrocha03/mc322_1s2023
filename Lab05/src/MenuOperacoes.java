import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public enum MenuOperacoes {
    CADASTRAR_CLIENTE(1),
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

    public static Cliente encontrarCliente(String nome, Seguradora seguradora){
        //funcao que devolve o objeto cliente, sabendo o nome do cliente e em que seguradora este esta
        Cliente cliente=null;

        for (Cliente clienteAux: seguradora.getListaClientes("todos")) {
            if (clienteAux.getNome().equals(nome)){
                cliente = clienteAux;
                return cliente;
            }
        }
        System.out.println("retornando cliente e seus dados");
        return cliente;
        
    }
    public static Frota encontrarFrota(Veiculo veiculo, ClientePJ cliente) {
        Frota frota = null;
        for (Frota frotaAux: cliente.getListaFrotas()) {
            for (Veiculo veiculoAux: frotaAux.getListaVeiculos()) {
                if (veiculoAux.equals(veiculo)) {
                    frota = frotaAux;
                    return frota;
                }
            }
        }
        return frota;

    }
    public static Veiculo encontrarVeiculo(String placa, Cliente cliente){
        //funcao que devolve o objeto Veiculo, sabendo o placa do Veiculo e em que cliente este esta
        Veiculo veiculo = null;
        if (cliente instanceof ClientePF) {
            for (Veiculo veiculoAux: ((ClientePF)cliente).getListaVeiculos()) {
                if (veiculoAux.getPlaca().equals(placa)){
                    veiculo = veiculoAux;
                    return veiculo;
                }
            
            }
        }
        else if (cliente instanceof ClientePJ) {
            Frota frota = encontrarFrota(veiculo, (ClientePJ)cliente);
            for (Veiculo VeiculoAux: frota.getListaVeiculos()) {
                if (VeiculoAux.getPlaca().equals(placa)){
                    veiculo = VeiculoAux;
                    return veiculo;
                }
            
            }
        }
        return veiculo;
    }

    public static Frota escolherFrota(ClientePJ cliente) {
        int i = 0;
        Scanner input = new Scanner(System.in);
        for (Frota frotaAux: cliente.getListaFrotas()) {
            System.out.println(i + ") " + frotaAux.getCode());
            System.out.println(frotaAux);
            i++; 
        }
        int numFrota = input.nextInt();
        return cliente.getListaFrotas().get(numFrota);
    }

    public static Frota escolherFrota(SeguroPJ seguro) {
        int i = 0;
        Scanner input = new Scanner(System.in);
        for (Frota frotaAux: seguro.getListaFrotas()) {
            System.out.println(i + ") " + frotaAux.getCode());
            System.out.println(frotaAux);
            i++; 
        }
        int numFrota = input.nextInt();
        return seguro.getListaFrotas().get(numFrota);
    }

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

    public static void cadastrarCliente(Seguradora seguradora){
        Scanner entrada = new Scanner(System.in);
        int comando;
    
        System.out.println("Qual tipo de cliente  deseja cadastrar? digite o numero correspondente");
        System.out.println("1:PF/ 2:PJ/ 3:VOLTAR");
        comando = entrada.nextInt();
        entrada.nextLine();

        
        if (comando == 1) {
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
            
            System.out.println("genero:\n");
            String genero = entrada.next();
            
            System.out.println("telefone:\n");
            String telefone = entrada.next();
           
            System.out.println("email:\n");
            String email = entrada.next();
           
            System.out.println("dataLicenca:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoL = entrada.nextInt();
            int mesL = entrada.nextInt();
            int diaL = entrada.nextInt();
            
            System.out.println("educacao:\n");
            String educacao = entrada.next();
            
            System.out.println("data nascimento:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoN = entrada.nextInt();
            entrada.nextLine();
            int mesN = entrada.nextInt();
            entrada.nextLine();
            int diaN = entrada.nextInt();
            entrada.nextLine();
            seguradora.cadastrarCliente(new ClientePF(  nome,endereco,telefone,email,
                                                        cpf,genero,LocalDate.of(anoL,mesL,diaL),
                                                        educacao,LocalDate.of(anoN,mesN,diaN)));
            System.out.println("cliente cadastrado!");
        }
        else if (comando == 2) {
            System.out.println("UTILIZE _ AO INVES DE ESPACOS");
            System.out.println("nome:\n");
            String nome = entrada.next();
            
            System.out.println("telefone:\n");
            String telefone = entrada.next();
            
            System.out.println("email:\n");
            String email = entrada.next();

            System.out.println("endereco:\n");
            String endereco = entrada.next();
            
            //validar cnpj
            System.out.println("cnpj:\n");
            String cnpj = entrada.next();
            if (!Validacao.validateCNPJ(cnpj)) {
                while (!Validacao.validateCNPJ(cnpj)) {
                    System.out.println("digite cnpj valido\n");
                    cnpj = entrada.next();
                }
            }
            

            System.out.println("data fundacao:\n digite o ano,mes,dia. A cada entrada, pressione o enter");
            int anoF = entrada.nextInt();
            entrada.nextLine();
            int mesF = entrada.nextInt();
            entrada.nextLine();
            int diaF = entrada.nextInt();
            entrada.nextLine();
            System.out.println("qtdFuncionarios:\n");
            int qtdFuncionarios = entrada.nextInt();
            entrada.nextLine();
            seguradora.cadastrarCliente(new ClientePJ(  nome,telefone, email, endereco,cnpj,   
                                                        LocalDate.of(anoF,mesF,diaF),qtdFuncionarios));
            System.out.println("cliente cadastrado!");
        }
       
    }

    public static void cadastrarVeiculo(Seguradora seguradora, Cliente cliente){
        System.out.println("UTILIZE _ AO INVES DE ESPACOS");
    
        Scanner entrada = new Scanner(System.in);

        System.out.println("placa:\n");
        String placa = entrada.next();
        
        System.out.println("marca:\n");
        String marca = entrada.next();
        
        System.out.println("modelo:\n");
        String modelo = entrada.next();
        
        System.out.println("ano de fabricacao:\n digite o ano");
            int anoF = entrada.nextInt();
            entrada.nextLine();
        //efetuar o cadastro de acordo com o tipo de cliente
        if (cliente instanceof ClientePF) {
            ((ClientePF)cliente).cadastrarVeiculo(new Veiculo(placa,marca,modelo,anoF));
        

        }
        else if (cliente instanceof ClientePJ) {
            System.out.println("escolha a frota em que deseja adicionar o veículo: ");
            int i = 0;
            for (Frota frotaAux:((ClientePJ)cliente).getListaFrotas()) {
                System.out.println(i + ") " + frotaAux.getCode());
                System.out.println(frotaAux);
                i++; 
            }
            int numFrota = entrada.nextInt();
            Frota frotaEscolhida = ((ClientePJ)cliente).getListaFrotas().get(numFrota);
            ((ClientePJ)cliente).atualizarFrota(frotaEscolhida,new Veiculo(placa,marca,modelo,anoF));
        
        } 
        System.out.println("veiculo cadastrado!");            
    }

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

    public static void cadastrar(Seguradora seguradora,ArrayList<Seguradora> listaSeguradora){
        boolean voltar = false;
        Scanner input = new Scanner(System.in);
        int comando = -1;
        do {    
            System.out.println("O que deseja cadastrar? digite o numero correspondente");
            System.out.println("1:CLIENTE/ 2:VEICULO/ 3:SEGURADORA/ 4:VOLTAR");
            
            comando = input.nextInt();
            
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
            //CADASTRAR SEGURADORA
            else if (comando == 3){
                cadastrarSeguradora(listaSeguradora);
            }
            else if (comando == 4) {
                voltar = true;
            }
        } while(!voltar);    

        
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
                
                seguradora.getListaClientes(tipo);
            }
            else if (comando == 2) {
                System.out.println("listando sinistros por Seguro...");
                Seguro segEscolhido = escolherSeguro(seguradora);
                for (Sinistro sinistro: segEscolhido.getListaSinistros()) {
                    System.out.println(sinistro.toString());
                }
            }
            else if (comando == 3) {
                System.out.println("Digite o nome do cliente: ");
                String nome = input.next();
                System.out.println("listando sinistros por Cliente...");
                Cliente cliente = encontrarCliente(nome, seguradora);
                seguradora.getSinistrosPorCliente(cliente);
            }   
            else if (comando == 4) {
                System.out.println("listando veiculos por Cliente...");
                System.out.println("Digite o nome do cliente");
                String nome = input.next();
                System.out.println("listando veiculos por Cliente...");
                Cliente cliente = encontrarCliente(nome, seguradora);
                if (cliente instanceof ClientePF) {
                    System.out.println(((ClientePF)cliente).getListaVeiculos());
                }
                else if (cliente instanceof ClientePJ) {
                    Frota frotaEscolhida = escolherFrota((ClientePJ)cliente); 
                    System.out.println(frotaEscolhida.getListaVeiculos());
                }
                 
            }
            else if (comando == 5) {
                System.out.println("listando veiculos por Seguro...");
                Seguro seguro = escolherSeguro(seguradora);
                if (seguro instanceof SeguroPF) {
                    System.out.println(((SeguroPF)seguro).getVeiculo());
                }
                else if (seguro instanceof SeguroPJ) {
                    Frota frota = escolherFrota((SeguroPJ)seguro);
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
                Cliente cliente = encontrarCliente(nome, seguradora);
                seguradora.removerCliente(cliente);
            }
            else if (comando == 2) {
                System.out.println("nome do cliente dono do veiculo?");
                String nome = input.next();
                System.out.println("placa do veiculo?");
                String placa = input.next();
                Cliente cliente = encontrarCliente(nome, seguradora);
                Veiculo veiculo = encontrarVeiculo(placa,cliente);
                System.out.println("excluindo veiculo...");
                if (cliente instanceof ClientePF) {
                    ((ClientePF)cliente).removerVeiculo(veiculo);
                }
                else if (cliente instanceof ClientePJ) {
                    ((ClientePJ)cliente).atualizarFrota(encontrarFrota(veiculo, (ClientePJ)cliente), veiculo);
                }
            }  
            else if (comando == 3) {
                Seguro seguro = escolherSeguro(seguradora);
                Sinistro sinistro = escolherSinistro(seguro);
                System.out.println("excluindo sinistros...");
                seguro.getListaSinistros().remove(sinistro);    
            }
            else if (comando == 4) {
                voltar = true;
            }
        } while (!voltar);
        
    }

    public static void gerarSinistro(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        
        Seguro seguro = escolherSeguro(seguradora);
        
        Condutor condutor = escolherCondutor(seguro);
        System.out.println("Digite o endereco:\n");
        String endereco = input.next();
        
        System.out.println("dataLicenca:\n digite o ano,mes,dia. A cada input, pressione o enter");
        int ano = input.nextInt();
        int mes = input.nextInt();
        int dia = input.nextInt();
        //gerar sinistro
        seguro.gerarSinistro(LocalDate.of(ano,mes,dia),endereco,condutor);
    }

    public static void transferirSeguro(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        
        System.out.println("nome que possui o seguro: ");    
        String nome1 = input.next();
        
        System.out.println("nome para o qual o seguro sera transferido: ");    
        String nome2 = input.next();

        Cliente cliente1 = encontrarCliente(nome1, seguradora);
        Cliente cliente2 = encontrarCliente(nome2, seguradora);

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
        
    
        //recalcular VALores mensais
        
    }

    public static void calcReceita(Seguradora seguradora){
        System.out.println("calculando receita...");
        double receita = seguradora.calcularReceita();
        //printar
        System.out.println("A receita é " + receita);
    }

    


}
