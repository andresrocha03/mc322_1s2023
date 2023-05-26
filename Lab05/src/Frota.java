import java.util.ArrayList;
import java.util.Random;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculo;


    public Frota() {
        this.code = generateCodeValue();
        this.listaVeiculo = new ArrayList<>();
    }

    public String getCode() {
        return this.code;
    }

    public String generateCodeValue() {
        //gerar um codigo aleatorio em formato de String para a frota
            String code = "";
            int min = 97;
            Random gerador = new Random();
            int limite = 25;
            for(int i = 0; i < 10; i++){
                int novoId = gerador.nextInt(limite);
                char charCodigo = (char)(novoId + min);
                code = code + charCodigo;
            }
            return code;
    }

    public ArrayList<Veiculo> getListaVeiculo() {
        return this.listaVeiculo;
    }

    public void setListaVeiculo(ArrayList<Veiculo> listaVeiculo) {
        this.listaVeiculo = listaVeiculo;
    }

    public void addVeiculo(Veiculo veiculo){
        this.listaVeiculo.add(veiculo);
    }

    public void removeVeiculo(Veiculo veiculo){
        this.listaVeiculo.remove(veiculo);
    }

}
