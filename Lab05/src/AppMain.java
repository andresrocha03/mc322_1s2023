import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
    MenuOperacoes operacao;

    public AppMain(MenuOperacoes operacao) {
        this.operacao = operacao;
    }
    ///// ARRUMAR AS TOSTRING //////////////////////////////

    ///// ARRUMAR RELACOES/////////////////////

    //atualizar valorSeguro
        
    public static void executarOperacao(MenuOperacoes operacao, Seguradora seguradora,
            ArrayList<Seguradora> listaSeguradoras) {
        // escolher operacao de acordo com a operacao e seguradora solicitadas
        switch (operacao) {
            case CADASTRAR_CLIENTE:
                MenuOperacoes.cadastrar(seguradora, listaSeguradoras);
                break;
            case LISTAR:
                MenuOperacoes.listar(seguradora);
                break;
            case EXCLUIR:
                MenuOperacoes.excluir(seguradora);
                break;
            case GERAR_SINISTRO:
                MenuOperacoes.gerarSinistro(seguradora);
                break;
            case TRANSFERIR_SEGURO:
                MenuOperacoes.transferirSeguro(seguradora);
                break;
            case CALC_RECEITA_SEGURADORA:
                MenuOperacoes.calcReceita(seguradora);
                break;
            case SAIR:
                break;
        }
    }

    public static void main(String args[]){
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<>();


        //instanciar clientes
        ClientePF pessoa = new ClientePF("Joao", "Rua Girassol","62996973007","joao@gmail.com","256.457.630-33", 
                                  "masculino", LocalDate.of(2015,01,01), "superior completo",LocalDate.of(1995,01,01));        
        ClientePJ empresa = new ClientePJ("FrangoSA","6232263007", "frangosa@gmail.com","Avenida Paulista",  
                                     "57.262.176/0001-39",LocalDate.of(2000,01,01),10);
        ClientePF marinalva = new ClientePF("Marinalva", "Rua Tulipa","62992699330","marinalva@gmail.com","133.560.470-78",
                                     "feminino", LocalDate.of(2016,01,01), "superior completo",LocalDate.of(1985,01,01));

        
        //instanciar seguradora
        Seguradora seguradora = new Seguradora("96.513.152/0001-67","Seguranca", "996683883", "esperancaseguradora@gmail.com", "Aevenida Faria Lima");
        listaSeguradoras.add(seguradora);
        
        //cadastrar clientes
        seguradora.cadastrarCliente(pessoa);
        seguradora.cadastrarCliente(empresa);
        seguradora.cadastrarCliente(marinalva);
        
        //adicionar veiculo
        Veiculo veiculoPessoa = new Veiculo("ABC123", "BMW" , "X1", 2020);
        pessoa.cadastrarVeiculo(veiculoPessoa);
        Veiculo veiculoEmpresa = new Veiculo("DEF456", "JAC" , "FUSCA", 2000);
        Frota frota1 = new Frota();
        empresa.cadastrarFrota(frota1);
        empresa.atualizarFrota(frota1,veiculoEmpresa);
        System.out.println("----------------------------------------------");

        //instanciar condutores
        Condutor condutorJoao = new Condutor("256.457.630-33","Joao", "62996973007", "Rua Girassol", "joao@gmail.com", LocalDate.of(1995,01,01), null);
        Condutor condutorFuncionario = new Condutor("459.846.700-20","Funcionario", "62991419330", "Rua Tulipa", "funcionario@gmail.com", LocalDate.of(2000,01,01), null);

        //instanciar seguro
        seguradora.gerarSeguro(LocalDate.of(2022,01,01), LocalDate.of(2024,01,01),seguradora, veiculoPessoa, pessoa);
        seguradora.gerarSeguro(LocalDate.of(2023,01,01), LocalDate.of(2025,01,01), seguradora, veiculoEmpresa, empresa);

        //gerar sinistro
        seguradora.getSegurosPorCliente(pessoa).get(0).gerarSinistro(LocalDate.now(),"Rua Acidente Pessoa",condutorJoao);
        seguradora.getSegurosPorCliente(empresa).get(0).gerarSinistro(LocalDate.now(),"Rua Acidente Empresa",condutorFuncionario);
        
        //listarClientes, visualizarSinistro, listarSinistros
        System.out.println(seguradora.getListaClientes("PF"));
        System.out.println("----------------------------------------------");
        System.out.println(seguradora.getListaClientes("PJ"));
        System.out.println("----------------------------------------------");
        System.out.println(seguradora.getSinistrosPorCliente(pessoa));
        System.out.println("----------------------------------------------");
        System.out.println(seguradora.getSinistrosPorCliente(empresa));
        System.out.println("----------------------------------------------");
        System.out.println(seguradora.getSegurosPorCliente(pessoa));
        System.out.println("----------------------------------------------");
        System.out.println(seguradora.getSegurosPorCliente(empresa));
        System.out.println("----------------------------------------------");
        
        //calcularReceita
        System.out.println("Receita seguradora: " + seguradora.calcularReceita());
        System.out.println("----------------------------------------------");
            
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
    
}
