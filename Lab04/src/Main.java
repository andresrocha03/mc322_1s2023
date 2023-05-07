import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        
        
        //criar clientes
        ClientePF pessoa = new ClientePF("Joao", "Rua Girassol","256.457.630-33",
                                        "masculino", LocalDate.of(2015,01,01), "superior completo",
                                        "classe media","01-01-1995");        
        ClientePJ empresa = new ClientePJ("FrangoSA", "Avenida Paulista",  "57.262.176/0001-39",
                                            LocalDate.of(2000,01,01));
        ClientePF marinalva = new ClientePF("Marinalva", "Rua Tulipa","133.560.470-78",
                                    "feminino", LocalDate.of(2016,01,01), "superior completo",
                                 "classe baixa","01-01-1985");

        
        //criar seguradora
        Seguradora seguradora = new Seguradora("Seguranca", "996683883", "esperancaseguradora@gmail.com", "Aevenida Faria Lima");
        
        //cadastrar clientes
        seguradora.cadastrarCliente(pessoa);
        seguradora.cadastrarCliente(empresa);
        seguradora.cadastrarCliente(marinalva);
        
        //listar clientes
        seguradora.listarClientes("PF");
        seguradora.listarClientes("PJ");
        System.out.println("----------------------------------------------");
        
        //remover cliente
        seguradora.removerCliente("Marinalva");
        
        //listar clientes
        seguradora.listarClientes("PF");
        seguradora.listarClientes("PJ");
        System.out.println("----------------------------------------------");
        
        //validar CPF/CNPJ
        pessoa.validateCPF(pessoa.getCpf());
        empresa.validateCNPJ(empresa.getCNPJ());
        System.out.println("----------------------------------------------");
        
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
        
        //chamar toString
            //toString ClientePF
        System.out.println(pessoa);    
        System.out.println("----------------------------------------------");
            //toString ClientePJ
        System.out.println(empresa);
        System.out.println("----------------------------------------------");
            //toString de Seguradora
        System.out.println(seguradora);
        System.out.println("----------------------------------------------");
            //toString de Sinistro
        System.out.println(seguradora.listarSinistros().get(0));
        System.out.println("----------------------------------------------");
            //toString de Veiculo
        System.out.println(empresa.listarVeiculos().get(0));
        System.out.println("----------------------------------------------");

        //listarClientes, visualizarSinistro, listarSinistros
        seguradora.listarClientes("PF");
        seguradora.listarClientes("PJ");
        System.out.println("----------------------------------------------");
        seguradora.visualizarSinistro(pessoa.getNome());
        System.out.println("----------------------------------------------");
        seguradora.visualizarSinistro(empresa.getNome());            
        System.out.println("----------------------------------------------");
        seguradora.listarSinistros();
        
        //leitura de dados
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja visualizar dados da seguradora? Sim/Nao");
        String comando = input.next();
        if (comando.equals("Sim")) {
            System.out.println("Qual dado deseja visualizar? Clientes/Sinistros");
            comando = input.next();
            if (comando.equals("Clientes")) {
                System.out.println("Qual tipo de cliente deseja visualizar? PF/PJ/TODOS");
                comando = input.next();
                if (comando.equals("PF")) {
                    seguradora.listarClientes(comando);
                }
                if (comando.equals("PJ")) {
                    seguradora.listarClientes(comando);
                }
                if (comando.equals("TODOS")) {
                    seguradora.listarClientes("PF");
                    seguradora.listarClientes("PJ");
                }
            
            }
            if (comando.equals("Sinistros")) {
                System.out.println("De qual cliente deseja visualizar? Digite o nome ou TODOS");
                comando = input.next();    
                if (comando.equals("TODOS")) {
                    System.out.println(seguradora.listarSinistros());
                }
                else{
                    seguradora.visualizarSinistro(comando);
                }
                }
        }
        input.close();
        System.out.println("Okay,obrigado!\n");       
    }
    
}
