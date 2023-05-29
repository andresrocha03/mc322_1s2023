import java.util.Scanner;

import javax.swing.plaf.synth.SynthIcon;

import java.time.LocalDate;

public class OpCliente {
   
    public static Cliente encontrarCliente(String nome, Seguradora seguradora){
        //funcao que devolve o objeto cliente, sabendo o nome do cliente e em que seguradora este esta
        Cliente cliente=null;

        for (Cliente clienteAux: seguradora.getListaClientes("todos")) {
            if (clienteAux.getNome().equals(nome)){
                cliente = clienteAux;
                return cliente;
            }
        }
        //System.out.println("retornando cliente e seus dados");
        return cliente;
        
    }

    public static Cliente escolherCliente(Seguradora seguradora){
        //funcao que devolve o objeto cliente, sabendo em que seguradora este esta
        Scanner input = new Scanner(System.in);
        System.out.println("nome do cliente?");
        String nome = input.next();
        Cliente cliente=null;

        for (Cliente clienteAux: seguradora.getListaClientes("todos")) {
            if (clienteAux.getNome().equals(nome)){
                cliente = clienteAux;
                return cliente;
            }
        }
        return cliente;
        
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

}
