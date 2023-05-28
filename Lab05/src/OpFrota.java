import java.util.Scanner;

public class OpFrota {
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
}
