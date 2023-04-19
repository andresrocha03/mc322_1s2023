import java.time.LocalDate;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;
public class Controle {
    public static void main(String args[]){
        
        
        //criar clientes
        ClientePF pessoa = new ClientePF("Joao Silva", "Rua Girassol","256.457.630-33",
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
        //remover cliente
        seguradora.removerCliente("Marinalva");
        //listar clientes
        seguradora.listarClientes("PF");
        seguradora.listarClientes("PJ");
        //validar CPF/CNPJ
        if (pessoa.validateCPF(pessoa.getCpf())){
            System.out.println("O cpf " + pessoa.getCpf() + " é válido");
        };
        if (empresa.validateCNPJ(empresa.getCNPJ())){
            System.out.println("O cpf " + empresa.getCNPJ() + " é válido");
        };
        //adicionar veiculo
        Veiculo veiculoPessoa = new Veiculo("ABC123", "BMW" , "X1", 2020);
        pessoa.cadastrarVeiculo(veiculoPessoa);
        Veiculo veiculoEmpresa = new Veiculo("DEF456", "JAC" , "FUSCA", 2000);
        empresa.cadastrarVeiculo(veiculoEmpresa);
        //gerar sinistro
        Veiculo veiculoSinistro = pessoa.listarVeiculos().get(0);
        seguradora.gerarSinistro(pessoa, veiculoSinistro);
        
        //chamar toString
            //toString ClientePF
        pessoa.toString();
            //toString ClientePJ
        empresa.toString();
            //toString de Seguradora
        seguradora.toString();
            //toString de Sinistro
        seguradora.listarSinistros().get(0).toString();
            //toString de Veiculo
        empresa.listarVeiculos().get(0).toString();

        //listarClientes, visualizarSinistro, listarSinistros
        seguradora.listarClientes("PF");
        seguradora.listarClientes("PJ");
        seguradora.listarSinistros();
        
        //leitura de dados
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja visualizar dados da seguradora? Sim/Nao");
        String comando = input.next();
        System.out.println(comando); 
        if (comando.equals("Sim")) {
            System.out.println("Qual dado deseja visualizar? Clientes/Sinistros\n");
            comando = input.next();
            if (comando.equals("Clientes")) {
                System.out.println("Qual tipo de cliente deseja visualizar? PF/PJ/TODOS\n");
                input.nextLine();
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
                input.nextLine();
                System.out.println("De qual cliente deseja visualizar? Digite o nome\n");
                    seguradora.visualizarSinistro(input.next());
            }
        }
        System.out.println("Okay,obrigado!\n");
        
    }
    
}
