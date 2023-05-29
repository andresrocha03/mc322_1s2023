import java.util.Scanner;

public class OpVeiculo {
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
            for (Frota frotaAux: ((ClientePJ)cliente).getListaFrotas()) {
                for (Veiculo VeiculoAux: frotaAux.getListaVeiculos()) {
                    if (VeiculoAux.getPlaca().equals(placa)){
                        veiculo = VeiculoAux;
                        return veiculo;
                    }
                
                }
            }
        }
        return veiculo;
    }

    public static Veiculo escolherVeiculo(Cliente cliente){
        
        //funcao que devolve o objeto Veiculo, sabendo em que cliente este esta
        Veiculo veiculo = null;
        if (cliente instanceof ClientePF) {
            for (Veiculo veiculoAux: ((ClientePF)cliente).getListaVeiculos()) {
                System.out.println(veiculoAux);
            }
        }
        else if (cliente instanceof ClientePJ) {
            for (Frota frotaAux: ((ClientePJ)cliente).getListaFrotas()) {
                for (Veiculo veiculoAux: frotaAux.getListaVeiculos()) {
                        System.out.println(veiculoAux);
                }
            }
        }
        System.out.println("Digite a placa do veiculo escolhido: ");
        Scanner entrada = new Scanner(System.in);
        String placa = entrada.next();
        veiculo = encontrarVeiculo(placa, cliente);
        return veiculo;
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
}
