import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePF extends Cliente{
    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento ;
    private ArrayList<Veiculo> listaVeiculos;
    
    
    
    //construtor
    public ClientePF(String nome, String endereco, String telefone, 
                     String email, String cpf, String genero, LocalDate dataLicenca, 
                     String educacao, LocalDate dataNascimento) {
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = new ArrayList<>();
    }

    //getters and setters
    public String getCpf() {
        return this.cpf;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return this.educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculo(ArrayList<Veiculo> newLista) {
        this.listaVeiculos = newLista;
    }
    
    //metodos Veiculos 
    public boolean cadastrarVeiculo(Veiculo veiculo) {
        for (Veiculo veiculoCadastrado: listaVeiculos) {
            if (veiculoCadastrado == veiculo) {
                //veiculo já esta cadastrado
                System.out.println("Veiculo " + veiculo.getPlaca() + " já possui cadastro.");
                return false;
            }           
        }
        listaVeiculos.add(veiculo);
        System.out.println("Veiculo cadastrado: " + veiculo.getPlaca());
        return true;
    }

    public boolean removerVeiculo(Veiculo veiculo) {
        //encontrar veiculo e verificar se o veiculo esta cadastrado
        for (Veiculo veiculoCadastrado: listaVeiculos) {
            if (veiculoCadastrado.equals(veiculo)) {
                //veiculo cadastrado, é possível removê-lo
                listaVeiculos.remove(veiculoCadastrado);
                return true;
            }           
        }
        return false;
    }
    
   
    

    @Override
    public String toString() {
        return "{" +
            " cpf='" + getCpf() + "'" +
            ", genero='" + getGenero() + "'" +
            ", educacao='" + getEducacao() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", listaVeiculos='" + getListaVeiculos() + "'" +
            "}";
    }
   
    
    
}
