import java.util.ArrayList;

public class Cliente {
    private String nome ;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;

    // Construtor
    public Cliente (String nome, String endereco, ArrayList<Veiculo> listaVeiculos) {
        this.nome              = nome ;
        this.endereco          = endereco ;
        this.listaVeiculos     = listaVeiculos;
    }

    // Getters e setters
    public String getNome () {
        return nome ;
    }

    public void setNome ( String nome ) {
        this.nome = nome ;
    }

 
    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this.endereco = endereco ;
    }


    public ArrayList<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public String toString() {
        return 
            " nome: " + getNome() +
            "\nendereco: " + getEndereco() +
            "\nlistaVeiculos:" + getListaVeiculos();
    }


    
    
}