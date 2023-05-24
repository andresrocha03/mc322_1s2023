import java.util.ArrayList;
import java.time.LocalDate;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNasc;
    private ArrayList<Sinistros> listaSinistros;


    public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNasc, ArrayList<Sinistros> listaSinistros) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        this.listaSinistros = listaSinistros;
    }

    public String getCpf() {
        return this.cpf;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ArrayList<Sinistros> getListaSinistros() {
        return this.listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistros> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    //metodos sinistro
    public void adicionarSinistro(){

    }

    public String toString() {
        return "{" +
            " cpf='" + getCpf() + "'" +
            ", nome='" + getNome() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", email='" + getEmail() + "'" +
            ", dataNasc='" + getDataNasc() + "'" +
            ", listaSinistros='" + getListaSinistros() + "'" +
            "}";
    }



    
}
