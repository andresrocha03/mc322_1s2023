import java.util.ArrayList;

public class Cliente {
    private String nome ;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;

    // Construtor
    public Cliente (String nome, String endereco) {
        this.nome              = nome ;
        this.endereco          = endereco ;
        this.listaVeiculos     = new ArrayList<Veiculo>();
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

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        for (Veiculo veiculoCadastrado: listaVeiculos) {
            if (veiculoCadastrado == veiculo) {
                //veiculo cadastrado, é possível removê-lo
                listaVeiculos.remove(veiculoCadastrado);
                return true;
            }           
        }
        listaVeiculos.add(veiculo);
        return true;
    }

    public boolean removerVeiculo(Veiculo veiculo) {
        //verificar se o veiculo esta cadastrado
        for (Veiculo veiculoCadastrado: listaVeiculos) {
            if (veiculoCadastrado == veiculo) {
                //veiculo cadastrado, é possível removê-lo
                listaVeiculos.remove(veiculoCadastrado);
                return true;
            }           
        }
        //veiculo não existe, não é possível removê-lo
        return false;
    }

    public ArrayList<Veiculo> listarVeiculos() {
        return listaVeiculos;
    }


    

    public String toString() {
        return 
            " nome: " + getNome() +
            "\nendereco: " + getEndereco() +
            "\nlistaVeiculos" + listaVeiculos;
    }


    
    
}