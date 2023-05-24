import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    private String CNPJ;
    private LocalDate dataFundacao;
    private ArrayList<Frota> listaFrota;
 

    //construtor
    public ClientePJ(String nome, String endereco, String CNPJ, LocalDate dataFundacao, int qtdFuncionarios) {
        super(nome, telefone, endereco, email);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;
        this.listaFrota = new ArrayList<>();
    }

    //getters and setters
    public String getCNPJ() {
        return this.CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public LocalDate getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public ArrayList<Frota> listarFrota() {
        return listaFrota;
    }

    //metodos Frota

    public boolean cadastrarFrota(){

    }

    public boolean atualizarFrota(){

    }

    public ArrayList<Veiculo> getVeiculosPorFrota(){
        //retornar lista com veiculos, conforme orientacoes do ped
    }

    //toString
    public String toString() {
        return 
            super.toString() +
            "\nCNPJ: " + getCNPJ() + 
            "\ndataFundacao: " + getDataFundacao() +
            "\nlistaFrota: " + listarFrota();
    }

}

/*
 
public double calcularScore() {
        //encontrar qtdVeiculos
        int qtdVeiculos = (this.listarVeiculos()).size();
        
        return  CalcSeguro.VALOR_BASE.getValor() * (1+ (qtdFuncionarios/100)) * qtdVeiculos;
    }
    
 */