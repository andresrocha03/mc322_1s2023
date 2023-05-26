import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    private String CNPJ;
    private LocalDate dataFundacao;
    private ArrayList<Frota> listaFrotas;
    private int qtdFuncionarios;
 

    //construtor
    public ClientePJ(String nome, String telefone, String email, 
                     String endereco, String CNPJ, LocalDate dataFundacao,
                     int qtdFuncionarios) {
        super(nome, telefone, endereco, email);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.listaFrotas = new ArrayList<>();
        this.qtdFuncionarios = qtdFuncionarios;
    }

    //getters and setters
    public String getCNPJ() {
        return this.CNPJ;
    }
 
    public LocalDate getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public ArrayList<Frota> getListaFrotas() {
        return listaFrotas;
    }

    public int getQtdFuncionarios() {
        return this.qtdFuncionarios;
    }

    public void setQtdFuncionarios(int novaQtd) {
        this.qtdFuncionarios = novaQtd;
    }
    
    
    //metodos Frota
    public boolean cadastrarFrota(Frota frota){
        for (Frota frotaCadastrada: listaFrotas) {
            if (frotaCadastrada.equals(frota)) {
                //frota já cadastrada
                return false;
            }
        }
        listaFrotas.add(frota);
        return true;        
    }

    public boolean atualizarFrota(Frota frota, Veiculo veiculo){
    /*  adiciona o veículo na frota, caso ainda não esteja cadastrado. 
        remove o veículo da frtoa, caso já esteja cadastrado.
    */
        for (Frota frotaCadastrada:listaFrotas) {
            if (frotaCadastrada.equals(frota)) {
                //frota encontrada
                for (Veiculo veiculoCadastrado:frotaCadastrada.getListaVeiculo()) {
                    if (veiculoCadastrado.equals(veiculo)) {
                        //veiculo encontrado, é possível remover
                        (frotaCadastrada.getListaVeiculo()).remove(veiculo);
                        return true;
                    }

                }
            }
        }
    return false;
    }

    public boolean atualizarFrota(Frota frota){
    //remover frota inteira
    for (Frota frotaCadastrada: listaFrotas) {
        if (frotaCadastrada.equals(frota)) {
            //frota já cadastrada,é possível remover
            listaFrotas.remove(frota);
            return true;
            
        }
    }
    //
    return false;
    }


    public ArrayList<Veiculo> getVeiculosPorFrota(Frota frota){
        //retornar lista com veiculos
        return frota.getListaVeiculo();
    }


    
    //toString
    public String toString() {
        return 
            super.toString() +
            "\nCNPJ: " + getCNPJ() + 
            "\ndataFundacao: " + getDataFundacao() +
            "\nlistaFrota: " + getListaFrotas();
    }

}


/*
 
public double calcularScore() {
        //encontrar qtdVeiculos
        int qtdVeiculos = (this.listarVeiculos()).size();
        
        return  CalcSeguro.VALOR_BASE.getValor() * (1+ (qtdFuncionarios/100)) * qtdVeiculos;
    }
    
 */