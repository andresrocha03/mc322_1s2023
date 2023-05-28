import java.util.Scanner;

public class OpSeguro {
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
    public static void transferirSeguro(Seguradora seguradora){
        Scanner input = new Scanner(System.in);
        
        System.out.println("nome que possui o seguro: ");    
        String nome1 = input.next();
        
        System.out.println("nome para o qual o seguro sera transferido: ");    
        String nome2 = input.next();

        Cliente cliente1 = OpCliente.encontrarCliente(nome1, seguradora);
        Cliente cliente2 = OpCliente.encontrarCliente(nome2, seguradora);

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
    }
}
