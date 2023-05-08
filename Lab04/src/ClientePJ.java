import java.time.LocalDate;

public class ClientePJ extends Cliente{
    private String CNPJ;
    private LocalDate dataFundacao;
    private int qtdFuncionarios;

    //construtor
    public ClientePJ(String nome, String endereco, String CNPJ, LocalDate dataFundacao, double valorSeguro, int qtdFuncionarios) {
        super(nome, endereco,valorSeguro);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;
    }

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


    public int getQtdFuncionarios() {
        return this.qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public double calcularScore(Cliente cliente) {
        //encontrar qtdVeiculos
        int qtdVeiculos = (cliente.listarVeiculos()).size();
        
        return  CalcSeguro.VALOR_BASE.getValor() * (1+ (qtdFuncionarios/100)) * qtdVeiculos;
    }
    
    //toString
    public String toString() {
        return 
            super.toString() +
            "\nCNPJ: " + getCNPJ() + 
            "\ndataFundacao: " + getDataFundacao() 

            "\nqtdFuncionarios: " + getqtdFuncionarios();
    }

}