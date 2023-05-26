import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
    MenuOperacoes operacao;

    public AppMain(MenuOperacoes operacao) {
        this.operacao = operacao;
    }
    ///// ARRUMAR AS TOSTRING //////////////////////////////
    public static void executarOperacao(MenuOperacoes operacao, Seguradora seguradora, ArrayList<Seguradora> listaSeguradoras) {       
        //escolher operacao de acordo com a operacao e seguradora solicitadas 
        switch(operacao) {
            case CADASTRAR_CLIENTE:
                cadastrar(seguradora,listaSeguradoras);
                break;
            case LISTAR:
                listar(seguradora);
                break;
            case EXCLUIR:
                excluir(seguradora);
                break;    
            case GERAR_SINISTRO:
                gerarSinistro(seguradora);
                break;
            case TRANSFERIR_SEGURO:
                transferirSeguro(seguradora);
                break;
            case CALC_RECEITA_SEGURADORA:
                calcReceita(seguradora);
                break;
            case SAIR:
                break;
        }
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
            entrada.nextLine();
            int mesN = entrada.nextInt();
            entrada.nextLine();
            int diaN = entrada.nextInt();
            entrada.nextLine();
            seguradora.cadastrarCliente(new ClientePF(nome,endereco,cpf,genero,LocalDate.of(anoL,mesL,diaL),educacao,classe,LocalDate.of(anoN,mesN,diaN)));
            System.out.println("cliente cadastrado!");
        }
        else if (comando == 2) {
            System.out.println("UTILIZE _ AO INVES DE ESPACOS");
            System.out.println("nome:\n");
            String nome = entrada.next();
            
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
            seguradora.cadastrarCliente(new ClientePJ(nome,endereco,cnpj,LocalDate.of(anoF,mesF,diaF),qtdFuncionarios));
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
            
        cliente.cadastrarVeiculo(new Veiculo(placa,marca,modelo,anoF));
        System.out.println("veiculo cadastrado!");            
        
    }

    public static Cliente encontrarCliente(String nome, Seguradora seguradora){
        //funcao que devolve o objeto cliente, sabendo o nome do cliente e em que seguradora este esta
        Cliente cliente=null;

        for (Cliente clienteAux: seguradora.listarClientes("todos")) {
            if (clienteAux.getNome().equals(nome)){
                cliente = clienteAux;
                return cliente;
            }
        }
        System.out.println("retornando cliente");
        return cliente;
        
    }

    public static void cadastrarSeguradora(ArrayList<Seguradora> lista) {
        System.out.println("UTILIZE _ AO INVES DE ESPACOS");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome da nova seguradora: ");
        String nome = entrada.next();
        System.out.println("Digite o telefone da nova seguradora: ");
        String telefone = entrada.next();
        System.out.println("Digite o email da nova seguradora: ");
        String email = entrada.nextLine();
        System.out.println("Digite o endereço da nova seguradora: ");
        String endereco = entrada.nextLine();

        Seguradora novaSeguradora = new Seguradora(nome, telefone, email, endereco);
        
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
                
                seguradora.listarClientes(tipo);
            }
            else if (comando == 2) {
                System.out.println("listando sinistros por Seguradora...");
                for (Sinistro sinistro: seguradora.listarSinistros()) {
                    System.out.println(sinistro.toString());
                }
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
                System.out.println(cliente.listarVeiculos()); 
            }
            else if (comando == 5) {
                System.out.println("listando veiculos por Seguradora...");
                for (Cliente cliente:seguradora.listarClientes("todos")){
                    System.out.println(cliente.listarVeiculos()); 
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
                //encontrar veiculo
                Sinistro sinistro = null;
                for (Sinistro sinistroAux: seguradora.listarSinistros()){
                    if (sinistroAux.getVeiculo().getPlaca().equals(placa)) {
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
        
    }

    public static void gerarSinistro(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        
        System.out.println("nome: ");    
        String nome = input.next();
        
        System.out.println("placa do carro: ");    
        String placa = input.next();

        //encontrar cliente
        Cliente cliente = encontrarCliente(nome, seguradora);
        
        //encontrar veiculo
        Veiculo veiculo = null;
        for (Veiculo veiculoAux: cliente.listarVeiculos()){
            if (veiculoAux.getPlaca().equals(placa)) {
                veiculo = veiculoAux;
                break;
            }
        }
        //gerar sinistro
        seguradora.gerarSinistro(cliente, veiculo);
    }

    public static void transferirSeguro(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        
        System.out.println("nome1: ");    
        String nome1 = input.next();
        
        System.out.println("nome2: ");    
        String nome2 = input.next();

        Cliente cliente1 = null;
        Cliente cliente2 = null;

        
        //encontrar clientes
        for (Cliente clienteAux: seguradora.listarClientes("todos")) {
            if (clienteAux.getNome().equals(nome1)){
                cliente1 = clienteAux;
            }
            if (clienteAux.getNome().equals(nome2)){
                cliente2 = clienteAux;
            }
        }
        
        //transferir lista de veiculos
        for (Veiculo veiculo: cliente1.listarVeiculos()){
            cliente2.listarVeiculos().add(veiculo);
        }
        cliente1.setListaVeiculo(new ArrayList<Veiculo>());
    
        //recalcular scores
        cliente1.setValorSeguro(cliente1.calcularScore());
        cliente2.setValorSeguro(cliente1.calcularScore());
    }

    public static void calcReceita(Seguradora seguradora){
        System.out.println("calculando receita...");
        double receita = seguradora.calcularReceita();
        //printar
        System.out.println("A receita é " + receita);
    }

    
    public static void main(String args[]){
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<>();


        //instanciar clientes
        ClientePF pessoa = new ClientePF("Joao", "Rua Girassol","256.457.630-33",
                                        "masculino", LocalDate.of(2015,01,01), "superior completo",
                                        "classe media",LocalDate.of(1995,01,01));        
        ClientePJ empresa = new ClientePJ("FrangoSA", "Avenida Paulista",  "57.262.176/0001-39",
                                            LocalDate.of(2000,01,01),10);
        ClientePF marinalva = new ClientePF("Marinalva", "Rua Tulipa","133.560.470-78",
                                    "feminino", LocalDate.of(2016,01,01), "superior completo",
                                 "classe baixa",LocalDate.of(1985,01,01));

        
        //criar seguradora
        Seguradora seguradora = new Seguradora("Seguranca", "996683883", "esperancaseguradora@gmail.com", "Aevenida Faria Lima");
        listaSeguradoras.add(seguradora);
        //cadastrar clientes
        seguradora.cadastrarCliente(pessoa);
        seguradora.cadastrarCliente(empresa);
        seguradora.cadastrarCliente(marinalva);
        
        //adicionar veiculo
        Veiculo veiculoPessoa = new Veiculo("ABC123", "BMW" , "X1", 2020);
        pessoa.cadastrarVeiculo(veiculoPessoa);
        Veiculo veiculoEmpresa = new Veiculo("DEF456", "JAC" , "FUSCA", 2000);
        empresa.cadastrarVeiculo(veiculoEmpresa);
        System.out.println("----------------------------------------------");

        //gerar sinistro
        Veiculo veiculoSinistroPessoa = pessoa.listarVeiculos().get(0);
        seguradora.gerarSinistro(pessoa, veiculoSinistroPessoa);
        Veiculo veiculoSinistroEmpresa = empresa.listarVeiculos().get(0);
        seguradora.gerarSinistro(empresa, veiculoSinistroEmpresa);

        //listarClientes, visualizarSinistro, listarSinistros
        seguradora.listarClientes("PF");
        seguradora.listarClientes("PJ");
        System.out.println("----------------------------------------------");
        seguradora.visualizarSinistro(pessoa.getNome());
        System.out.println("----------------------------------------------");
        seguradora.visualizarSinistro(empresa.getNome());            
        System.out.println("----------------------------------------------");
        System.out.println(seguradora.listarSinistros());
        System.out.println("----------------------------------------------");
        
        //calcularReceita
        System.out.println("Receita seguradora: " + seguradora.calcularReceita());
        System.out.println("----------------------------------------------");
        
        //atualizar valorSeguro
        pessoa.setValorSeguro(seguradora.calcularPrecoSeguroCliente(pessoa));
        empresa.setValorSeguro(seguradora.calcularPrecoSeguroCliente(empresa));
        System.out.println("Novo valor seguro pessoa: " + pessoa.getValorSeguro());
        System.out.println("Novo valor seguro empresa: " + empresa.getValorSeguro());
        
        //leitura de dados
        Scanner input = new Scanner(System.in);
        int valor = -1;
        do {
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

            System.out.println("escolha\n1:CADASTAR/\n2:LISTAR/\n3:EXCLUIR/\n4:GERARSINISTRO/\n5:TRANSFERIRSEGURO/\n6:CALCULARRECEITASEGURADORA/\n0:SAIR\n");
            valor = input.nextInt();
            //input.nextLine();
            if (valor != 0) {
                MenuOperacoes operacao = MenuOperacoes.getOperacao(valor);
                executarOperacao(operacao, escolhido, listaSeguradoras);
            }
       
        } while(valor != 0) ;

        input.close();
       
        
        

    }
    ///// ARRUMAR AS TOSTRING //////////////////////////////
   
}



