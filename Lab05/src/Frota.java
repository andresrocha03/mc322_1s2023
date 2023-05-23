import java.util.ArrayList;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculo;


    public Frota(String code) {
        this.code = code;
        this.listaVeiculo = new ArrayList<>();
    }

    public String getCode() {
        return this.code;
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
